package me.choicore.samples.parking.core.access.application

import me.choicore.samples.parking.core.access.domain.LicensePlate
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
class ParkingAccessorTests(
    private val parkingAccessor: ParkingAccessor,
) {
    @Test
    fun t1() {
        parkingAccessor.arrived(
            licensePlate = LicensePlate(value = "123가4567"),
            accessedAt = LocalDateTime.now(),
        )
    }
}
