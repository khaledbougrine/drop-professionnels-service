package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;

// Lombok imports

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;

/**
 * Abstract class to manage the versioning of rows in the datasource tables
 *
 * @author jlesaulnier
 * @version $Id: $Id
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AAuditableVersionedEntity {
    /** Composite containing the usual versioning information */
    @Embedded
    protected AuditEmbedded auditEmbedded;

    /** The version number of the change on the considered row */
    @Version
    protected Long version;

    ///////////////
    // CALLBACKS //
    ///////////////

    /**
     * Method executed before persist or update action on a considered row
     */
    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdateCallback() {
        if (auditEmbedded == null) {
            auditEmbedded = new AuditEmbedded();
            auditEmbedded.setCreatedAt(Instant.now());
        }
        else auditEmbedded.setUpdatedAt(Instant.now());
    }

}
