package me.choicore.samples.parking.core.access.infrastructure

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Transient
import me.choicore.samples.parking.core.access.domain.AccessKey
import me.choicore.samples.parking.core.access.domain.AccessType
import me.choicore.samples.parking.core.access.domain.LicensePlate
import me.choicore.samples.parking.core.access.domain.ParkingTransaction
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit

@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "parking_transaction")
class ParkingTransactionEntity(
    licensePlate: LicensePlate,
    accessKey: AccessKey?,
    @Enumerated(EnumType.STRING)
    val accessType: AccessType,
    @Transient
    val accessedAt: LocalDateTime,
) {
    constructor(parkingTransaction: ParkingTransaction) : this(
        parkingTransaction.licensePlate,
        parkingTransaction.accessKey,
        parkingTransaction.accessType,
        parkingTransaction.accessedAt,
    )

    val licensePlate: String = licensePlate.value

    val accessKey: String? = accessKey?.value

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

    val accessedDate: LocalDate = this.accessedAt.toLocalDate()

    val accessedTime: LocalTime = this.accessedAt.toLocalTime().truncatedTo(ChronoUnit.SECONDS)

    fun toParkingTransaction(): ParkingTransaction =
        ParkingTransaction(
            licensePlate = LicensePlate(this.licensePlate),
            accessKey = this.accessKey?.let { AccessKey(it) },
            accessType = this.accessType,
            accessedAt = this.accessedAt,
        )
}
