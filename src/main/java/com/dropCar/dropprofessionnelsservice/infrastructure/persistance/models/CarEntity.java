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
@Entity
@Table(name = "car", indexes = {
        @Index(name = "MultiIndex", columnList = "id, client_id", unique = true),
        @Index(name = "CarId",columnList = "id")
})
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String immatricule;
    private String brand;
    private String model;
    private Double kilometrage;
    private Integer age;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private UserEntity client;
}
