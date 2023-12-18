package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;

import com.dropCar.dropprofessionnelsservice.utils.Enum.StatesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "customer", indexes = {
        @Index(name = "ui_index", columnList = "user_id", unique = true),
        @Index(name = "ci_index",columnList = "customer_id",unique = true),
        @Index(name = "pn_index",columnList = "phone_number",unique = true),
})
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

}
