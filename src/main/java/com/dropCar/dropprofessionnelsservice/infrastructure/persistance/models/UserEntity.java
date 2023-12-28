package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "client", indexes = {
		@Index(name = "un_index", columnList = "user_name",unique = true),
		@Index(name = "pn_index", columnList = "phone_number",unique = true),
		@Index(name = "id_index", columnList = "id",unique = true),
})
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "user_name", nullable = false)
    private String userName;

//    @OneToOne(mappedBy = "client")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    private SubscriptionEntity subscriptionEntity;

    @OneToMany
    @JoinColumn(name = "client_id" )
    private List<CarEntity> carList;



}
