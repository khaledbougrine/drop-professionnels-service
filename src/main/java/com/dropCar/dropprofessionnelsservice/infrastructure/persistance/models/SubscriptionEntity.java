package com.dropCar.dropprofessionnelsservice.infrastructure.persistance.models;


// Jakarta imports
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

// Lombok imports
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Spring imports
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

// J2EE imports
import java.time.Instant;

/**
 * Entity to manage the persistence of the client subscriptions
 *
 * @author jlesaulnier
 * @version $Id: $Id
 */
@Entity
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Table(name = "subscription", schema = "public", uniqueConstraints = {
//       @UniqueConstraint(name = "uc_subscription_entity_client_module", columnNames = {"client_id", "module_id"})
//})
@Table(name = "subscription")
@EntityListeners(AuditingEntityListener.class)
public class SubscriptionEntity extends AAuditableVersionedEntity {
    /** Unique identifier/primary key of this partner module subscription */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    /** Boolean flag indicating if this partner module subscription is active */
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    /** The UTC start date for the validity of the partner module subscription */
    @Column(name = "start_date")
    @Nullable
    private Instant startDate;

    /** The UTC end date for the validity of the partner module subscription */
    @Column(name = "end_date")
    @Nullable
    private Instant endDate;

    //////////////////
    // ASSOCIATIONS //
    //////////////////
    /** Details about the client associated to this partner module subscription */
    @NotNull(message = "{subscription.client.id.not-null}")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SUBSCRIPTION_CLIENT"))
    private ClientEntity client;

    /** Details about the partner module associated to this client subscription */
    @NotNull(message = "{subscription.module.id.not-null}")
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "module_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SUBSCRIPTION_MODULE"))
    private ModuleEntity module;

}
