package com.dropCar.dropprofessionnelsservice.Configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableCaching
public class AppConfig {
@Bean
public CacheManager chacheManager() {
	return new ConcurrentMapCacheManager("myCache");
	
}

}
