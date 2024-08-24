package me.choicore.samples.parking.core.access

import me.choicore.samples.parking.core.access.AccessType.ENTERED
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class ParkingAccessTests {
    @Test
    fun t1() {
        val parkingAccess =
            ParkingAccess(
                licensePlate = "123가4567",
                accessKey = AccessKey.generate().value,
                accessType = ENTERED,
                accessedAt = LocalDateTime.now(),
            )

        assertThatExceptionOfType(IllegalStateException::class.java)
            .isThrownBy { parkingAccess.id }
            .withMessageStartingWith("This entity has not been persisted yet.")
    }
}
