package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;


import com.dropCar.dropprofessionnelsservice.utils.Enum.Garantie;
import com.dropCar.dropprofessionnelsservice.utils.Enum.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.text.DefaultEditorKit;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "location", indexes = {
        @Index(name = "cari_index", columnList = "car_id"),
        @Index(name = "ci_index",columnList = "customer_id"),
})
@Entity
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "rental_days")
    private Integer rentalDays;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "vehicle")
    private String vehicle;

    @Enumerated(EnumType.STRING)
    @Column(name = "rent_status")
    private Statut rentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "guarantee")
    private Garantie guarantee;

    @Column(name = "guarantee_amount")
    private Integer guaranteeAmount;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "car_id", updatable = false)
    private CarEntity carEntity;

    @ManyToOne
    @JoinColumn(name = "customer_id", updatable = false)
    private CustomerEntity customerEntity;
    @ManyToOne
    @JoinColumn(name = "client_id", updatable = false)
    private UserEntity userEntity;


}
