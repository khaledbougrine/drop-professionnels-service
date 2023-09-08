package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;

public class ModuleEntity {
    String id;
    String name;
    String description;
    Boolean isEnabled = true;
    SubscriptionEntity subscriptionEntity;
}
