package me.choicore.samples.parking.core.access.domain

import me.choicore.samples.parking.core.access.domain.AccessType.ARRIVED
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class ParkingTransactionTests {
    @Test
    fun t1() {
        val accessedAt: LocalDateTime = LocalDateTime.now()
        val licensePlate = LicensePlate(value = "123가4567")
        val accessKey: AccessKey = AccessKey.generate()
        val accessType: AccessType = ARRIVED

        val parkingTransaction =
            ParkingTransaction(
                licensePlate = licensePlate,
                accessKey = accessKey,
                accessType = accessType,
                accessedAt = accessedAt,
            )

        assertThat(parkingTransaction.accessedTime.nano).isEqualTo(0)
        assertThat(parkingTransaction.accessedTime).hasSameHourAs(accessedAt.toLocalTime())
        assertThat(parkingTransaction.accessedDate).isEqualTo(accessedAt.toLocalDate())
    }
}
