package me.choicore.samples.parking.core.access.infrastructure

import me.choicore.samples.parking.core.access.domain.AccessKey
import me.choicore.samples.parking.core.access.domain.AccessType.ENTERED
import me.choicore.samples.parking.core.access.domain.LicensePlate
import me.choicore.samples.parking.core.access.domain.ParkingTransaction
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class ParkingTransactionEntityTests {
    @Test
    fun t1() {
        val accessedAt: LocalDateTime = LocalDateTime.now()
        val parkingTransaction =
            ParkingTransaction(
                licensePlate = LicensePlate(value = "123가4567"),
                accessKey = AccessKey.generate(),
                accessType = ENTERED,
                accessedAt = accessedAt,
            )
        val entity = ParkingTransactionEntity(parkingTransaction = parkingTransaction)

        assertThat(entity.licensePlate).isEqualTo("123가4567")
        assertThat(entity.accessKey).isNotNull
        assertThat(entity.accessType).isEqualTo(ENTERED)
        assertThat(entity.accessedAt).isNotNull
        assertThat(entity.accessedDate).isNotNull.isEqualTo(accessedAt.toLocalDate())
        assertThat(entity.accessedTime).isNotNull.isEqualTo(accessedAt.toLocalTime().truncatedTo(ChronoUnit.SECONDS))
        assertThat(entity.accessedTime.nano).isEqualTo(0)
    }

    @Test
    fun t2() {
        val accessedAt: LocalDateTime = LocalDateTime.now()
        val parkingTransaction =
            ParkingTransaction(
                licensePlate = LicensePlate(value = "123가4567"),
                accessKey = AccessKey.generate(),
                accessType = ENTERED,
                accessedAt = accessedAt,
            )

        val entity = ParkingTransactionEntity(parkingTransaction = parkingTransaction)

        val converted: ParkingTransaction = entity.toParkingTransaction()

        assertThat(converted).isEqualTo(parkingTransaction)
    }
}
