package me.choicore.samples.parking.core.access

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Transient
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit

@EntityListeners(AuditingEntityListener::class)
@Entity
class ParkingAccess(
    val licensePlate: String,
    val accessKey: String,
    @Enumerated(EnumType.STRING)
    val accessType: AccessType,
    @Transient
    val accessedAt: LocalDateTime,
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private var _id: Long? = null

    val id: Long
        get() =
            checkNotNull(_id) {
                "This entity has not been persisted yet. Please save the entity before accessing its primary key."
            }

    @CreatedDate
    var registeredAt: LocalDateTime? = null
        private set

    @LastModifiedDate
    var lastModifiedAt: LocalDateTime? = registeredAt
        private set

    val accessDate: LocalDate = accessedAt.toLocalDate()

    val accessTime: LocalTime = accessedAt.toLocalTime().truncatedTo(ChronoUnit.SECONDS)
}
