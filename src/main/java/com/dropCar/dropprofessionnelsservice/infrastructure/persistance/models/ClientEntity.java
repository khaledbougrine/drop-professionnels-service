package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "client")
@Entity
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String password;
    private String phoneNumber;
    private  String userName;
    @OneToOne
    private SubscriptionEntity subscriptionEntity;


}
