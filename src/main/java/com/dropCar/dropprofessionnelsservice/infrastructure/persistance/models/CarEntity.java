package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;

import com.dropCar.dropprofessionnelsservice.utils.Enum.BoiteVitesse;
import com.dropCar.dropprofessionnelsservice.utils.Enum.Motorisation;
import com.dropCar.dropprofessionnelsservice.utils.Enum.VehiculeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "car", indexes = {
        @Index(name = "MultiIndex", columnList = "id, client_id", unique = true),
        @Index(name = "CarId",columnList = "id")},
        uniqueConstraints = @UniqueConstraint(columnNames = "immatricule")
)
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "immatricule" )
    private String immatricule;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "kilometrage")
    private Double kilometrage;

    @Enumerated(EnumType.STRING)
    @Column(name = "motorisation")
    private Motorisation motorisation;

    @Column(name = "boite_vitesse")
    @Enumerated(EnumType.STRING)
    private BoiteVitesse boiteVitesse;

    @Column(name = "type_de_vehicule")
    @Enumerated(EnumType.STRING)
    private VehiculeType typeDeVehicule;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private UserEntity client;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_id" )
    private List<LocationEntity> locationEntities = new ArrayList<>();
}
