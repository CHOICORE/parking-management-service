package me.choicore.samples.parking.core.access.application

import me.choicore.samples.parking.core.access.domain.AccessKey
import me.choicore.samples.parking.core.access.domain.AccessType
import me.choicore.samples.parking.core.access.domain.LicensePlate
import me.choicore.samples.parking.core.access.domain.ParkingAccessedEvent
import me.choicore.samples.parking.core.access.domain.ParkingTransaction
import me.choicore.samples.parking.core.access.domain.ParkingTransactionRegister
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ParkingAccessor(
    private val parkingAccessRegister: ParkingTransactionRegister,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {
    fun arrived(
        licensePlate: LicensePlate,
        accessedAt: LocalDateTime,
    ): AccessKey {
        val accessKey: AccessKey = AccessKey.generate()
        val parkingTransaction =
            ParkingTransaction(
                licensePlate = licensePlate,
                accessKey = accessKey,
                accessType = AccessType.ARRIVED,
                accessedAt = accessedAt,
            )
        registerParkingTransaction(parkingTransaction)
        publishParkingAccessedEvent(parkingTransaction)
        return accessKey
    }

    fun departed(
        accessKey: AccessKey?,
        licensePlate: LicensePlate,
        accessedAt: LocalDateTime,
    ) {
        val parkingTransaction =
            ParkingTransaction(
                licensePlate = licensePlate,
                accessKey = accessKey,
                accessType = AccessType.DEPARTED,
                accessedAt = accessedAt,
            )
        publishParkingAccessedEvent(parkingTransaction)
        registerParkingTransaction(parkingTransaction)
    }

    private fun registerParkingTransaction(parkingTransaction: ParkingTransaction) {
        parkingAccessRegister.register(parkingTransaction)
    }

    private fun publishParkingAccessedEvent(parkingTransaction: ParkingTransaction) {
        applicationEventPublisher.publishEvent(ParkingAccessedEvent(parkingTransaction))
    }
}
