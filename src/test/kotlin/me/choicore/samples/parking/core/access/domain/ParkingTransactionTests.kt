package me.choicore.samples.parking.core.access.domain

import me.choicore.samples.parking.core.access.domain.AccessType.ARRIVED
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class ParkingTransactionTests {
    @Test
    fun t1() {
        val accessKey: AccessKey = AccessKey.generate()
        val licensePlate = LicensePlate(value = "123가4567")
        val accessType: AccessType = ARRIVED
        val accessedAt: LocalDateTime = LocalDateTime.now()

        val parkingTransaction =
            ParkingTransaction(
                accessKey = accessKey,
                licensePlate = licensePlate,
                accessType = accessType,
                accessedAt = accessedAt,
            )

        assertThat(parkingTransaction.accessedTime.nano).isEqualTo(0)
        assertThat(parkingTransaction.accessedTime).hasSameHourAs(accessedAt.toLocalTime())
        assertThat(parkingTransaction.accessedDate).isEqualTo(accessedAt.toLocalDate())
    }
}
