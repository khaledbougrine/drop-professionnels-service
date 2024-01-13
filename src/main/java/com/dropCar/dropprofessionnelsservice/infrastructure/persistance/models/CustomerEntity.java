package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;

import com.dropCar.dropprofessionnelsservice.utils.Enum.StatesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "customer", indexes = {
        @Index(name = "customer_user_index", columnList = "client_id"),
        @Index(name = "customer_id_index",columnList = "id",unique = true)
})
@Entity
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private StatesEnum statesEnum;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private UserEntity user;

    @OneToMany
    @JoinColumn(name = "customer_id" )
    private List<LocationEntity> locationEntities = new ArrayList<>();
}
