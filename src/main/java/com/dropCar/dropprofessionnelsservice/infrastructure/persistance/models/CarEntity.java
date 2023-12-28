package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;

import com.dropCar.dropprofessionnelsservice.utils.Enum.VehiculeType;
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
        @Index(name = "MultiIndex", columnList = "id, client_id", unique = true)

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

    @Column(name = "type_de_vehicule")
    @Enumerated(EnumType.STRING)
    private VehiculeType typeDeVehicule;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private UserEntity client;
}
