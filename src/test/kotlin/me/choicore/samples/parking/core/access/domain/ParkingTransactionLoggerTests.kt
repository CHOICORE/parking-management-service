package me.choicore.samples.parking.core.access.domain

import me.choicore.samples.parking.core.access.domain.AccessType.ENTERED
import me.choicore.samples.parking.core.access.domain.AccessType.EXITED
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@SpringBootTest(webEnvironment = NONE)
@TestConstructor(autowireMode = ALL)
@Transactional
class ParkingTransactionLoggerTests(
    private val parkingTransactionLogger: ParkingTransactionLogger,
) {
    @Test
    fun t1() {
        val accessedAt: LocalDateTime = LocalDateTime.now()
        val accessKey: AccessKey = AccessKey.generate()
        val accessType: AccessType = ENTERED

        val parkingTransaction =
            ParkingTransaction(
                licensePlate = LicensePlate(value = "123가4567"),
                accessKey = accessKey,
                accessType = accessType,
                accessedAt = accessedAt,
            )

        parkingTransactionLogger.log(parkingTransaction)
    }

    @Test
    fun t2() {
        val accessedAt: LocalDateTime = LocalDateTime.now()
        val accessKey: AccessKey? = null
        val accessType: AccessType = ENTERED

        val parkingTransaction =
            ParkingTransaction(
                licensePlate = LicensePlate(value = "123가4567"),
                accessKey = accessKey,
                accessType = accessType,
                accessedAt = accessedAt,
            )

        parkingTransactionLogger.log(parkingTransaction)
    }

    @Test
    fun t3() {
        val accessedAt: LocalDateTime = LocalDateTime.now()
        val accessKey: AccessKey = AccessKey.generate()
        val accessType: AccessType = EXITED

        val parkingTransaction =
            ParkingTransaction(
                licensePlate = LicensePlate(value = "123가4567"),
                accessKey = accessKey,
                accessType = accessType,
                accessedAt = accessedAt,
            )

        parkingTransactionLogger.log(parkingTransaction)
    }

    @Test
    fun t4() {
        val accessedAt: LocalDateTime = LocalDateTime.now()
        val accessKey: AccessKey? = null
        val accessType: AccessType = EXITED

        val parkingTransaction =
            ParkingTransaction(
                licensePlate = LicensePlate(value = "123가4567"),
                accessKey = accessKey,
                accessType = accessType,
                accessedAt = accessedAt,
            )

        parkingTransactionLogger.log(parkingTransaction)
    }
}
