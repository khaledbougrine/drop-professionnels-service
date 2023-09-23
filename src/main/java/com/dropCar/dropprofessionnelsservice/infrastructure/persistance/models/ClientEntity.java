package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;

import org.springframework.stereotype.Indexed;

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
		@Index(name = "un_index", columnList = "username",unique = true),
		@Index(name = "pn_index", columnList = "phoneNumber",unique = true),
		@Index(name = "id_index", columnList = "id",unique = true),
})
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
    @OneToMany
    @JoinColumn(name = "client_id" )
    private List<CarEntity> carList;



}
