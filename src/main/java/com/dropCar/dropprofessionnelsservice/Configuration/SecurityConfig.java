package com.dropCar.dropprofessionnelsservice.Configuration;

import com.dropCar.dropprofessionnelsservice.application.domain.ClientSecurityDomain;
import com.dropCar.dropprofessionnelsservice.application.load.ClientLoader;
import com.dropCar.dropprofessionnelsservice.utils.JwtHelper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private static final String LOG_OUT_URL = "/logout";
    private final ClientLoader clientLoader;

    @Bean
    OncePerRequestFilter doFilterForEachRequest(ClientLoader clientLoader) {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                final String authHeader = JwtHelper.getAuthHeader(request);
                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    filterChain.doFilter(request, response);
                    return;
                }
                final String jwtToken = authHeader.substring(7);
                final String userName = JwtHelper.extractUsername(jwtToken);
                if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    ClientSecurityDomain userDetails = clientLoader.loadUserByUsername(userName);
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()


                    );
                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
                filterChain.doFilter(request, response);

            }
        };
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/usr/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(doFilterForEachRequest(clientLoader), UsernamePasswordAuthenticationFilter.class)
                .logout(logoutConfigurer -> {
                    logoutConfigurer.logoutUrl(LOG_OUT_URL)
                            .addLogoutHandler(((request, response, authentication) -> {
                                SecurityContextHolder.clearContext();
                            }))
                            .logoutSuccessHandler((request,
                                                   response,
                                                   authentication) -> SecurityContextHolder.clearContext());
                }).build();
    }



    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(clientLoader);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
