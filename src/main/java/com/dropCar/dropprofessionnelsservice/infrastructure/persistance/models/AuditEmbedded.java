package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;

// Lombok imports

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

/**
 * Embeddable containing the usual auditable properties for the datasource
 *
 * @author khaledbougrine
 * @version $Id: $Id
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditEmbedded {
    /** The timestamp of creation of the associated entity in the datasource */
    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Instant createdAt;

    /** The timestamp of last update of the associated entity in the datasource */
    @Column(name = "updated_at")
    @LastModifiedDate
    private Instant updatedAt;

    /** The timestamp of deletion of the associated entity in the datasource */
    @Column(name = "deleted_at")
    private Instant deletedAt;
}
