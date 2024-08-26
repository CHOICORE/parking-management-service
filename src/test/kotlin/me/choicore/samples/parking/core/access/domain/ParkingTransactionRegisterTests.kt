package me.choicore.samples.parking.core.access.domain

import me.choicore.samples.parking.core.access.domain.AccessType.ARRIVED
import me.choicore.samples.parking.core.access.domain.AccessType.DEPARTED
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
class ParkingTransactionRegisterTests(
    private val parkingTransactionRegister: ParkingTransactionRegister,
) {
    @Test
    fun t1() {
        val accessKey: AccessKey = AccessKey.generate()
        val accessType: AccessType = ARRIVED
        val accessedAt: LocalDateTime = LocalDateTime.now()

        val parkingTransaction =
            ParkingTransaction(
                licensePlate = LicensePlate(value = "123가4567"),
                accessKey = accessKey,
                accessType = accessType,
                accessedAt = accessedAt,
            )

        parkingTransactionRegister.register(parkingTransaction)
    }

    @Test
    fun t2() {
        val accessKey: AccessKey? = null
        val accessType: AccessType = ARRIVED
        val accessedAt: LocalDateTime = LocalDateTime.now()

        val parkingTransaction =
            ParkingTransaction(
                accessKey = accessKey,
                licensePlate = LicensePlate(value = "123가4567"),
                accessType = accessType,
                accessedAt = accessedAt,
            )

        parkingTransactionRegister.register(parkingTransaction)
    }

    @Test
    fun t3() {
        val accessKey: AccessKey = AccessKey.generate()
        val accessType: AccessType = DEPARTED
        val accessedAt: LocalDateTime = LocalDateTime.now()

        val parkingTransaction =
            ParkingTransaction(
                accessKey = accessKey,
                licensePlate = LicensePlate(value = "123가4567"),
                accessType = accessType,
                accessedAt = accessedAt,
            )

        parkingTransactionRegister.register(parkingTransaction = parkingTransaction)
    }

    @Test
    fun t4() {
        val accessKey: AccessKey? = null
        val accessType: AccessType = DEPARTED
        val accessedAt: LocalDateTime = LocalDateTime.now()

        val parkingTransaction =
            ParkingTransaction(
                accessKey = accessKey,
                licensePlate = LicensePlate(value = "123가4567"),
                accessType = accessType,
                accessedAt = accessedAt,
            )

        parkingTransactionRegister.register(parkingTransaction = parkingTransaction)
    }
}
