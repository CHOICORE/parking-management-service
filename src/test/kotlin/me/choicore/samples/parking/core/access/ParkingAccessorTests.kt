package me.choicore.samples.parking.core.access

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@TestConstructor(autowireMode = AutowireMode.ALL)
@Transactional
class ParkingAccessorTests(
    private val parkingAccessor: ParkingAccessor,
) {
    @Test
    fun t1() {
        val sut: ParkingAccessor = parkingAccessor
        sut.entered("123가4567", LocalDateTime.now())
    }

    @Test
    fun t2() {
        val sut: ParkingAccessor = parkingAccessor
        sut.exited(AccessKey.generate(), "123가4567", LocalDateTime.now())
    }
}
