package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;


import com.dropCar.dropprofessionnelsservice.utils.Enum.OfferTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "offer")
@Entity
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "offerTypeEnum")
    private OfferTypeEnum offerTypeEnum;
    @Column(name = "description")
    private String description;
    @Column(name = "isEnabled")
    private Boolean isEnabled = true;

//    @OneToMany
//    @JoinColumn(name = "module_id")
//    private List<SubscriptionEntity> subscriptionEntity;

}
