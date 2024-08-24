package me.choicore.samples.parking.core.access

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@EntityListeners(AuditingEntityListener::class)
@Entity
class ParkingRecord(
    val licensePlate: String,
    val enteredAt: LocalDateTime,
    exitedAt: LocalDateTime? = null,
    val accessKey: String,
    val derivedKey: String = accessKey,
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private var _id: Long? = null

    var exitedAt: LocalDateTime? = exitedAt
        private set

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

    fun exit(exitedAt: LocalDateTime) {
        this.exitedAt = exitedAt
    }
}
