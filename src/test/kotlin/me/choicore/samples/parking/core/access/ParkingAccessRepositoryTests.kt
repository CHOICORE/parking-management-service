package me.choicore.samples.parking.core.access

import me.choicore.samples.parking.core.access.AccessType.ENTERED
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode
import java.time.LocalDateTime

@DataJpaTest
@TestConstructor(autowireMode = AutowireMode.ALL)
class ParkingAccessRepositoryTests(
    private val parkingAccessRepository: ParkingAccessRepository,
) {
    @Test
    fun t1() {
        val parkingAccessLog =
            ParkingAccess(
                licensePlate = "123가4567",
                accessKey = AccessKey.generate().value,
                accessType = ENTERED,
                accessedAt = LocalDateTime.now(),
            )

        val result: ParkingAccess = parkingAccessRepository.save(parkingAccessLog)

        assertThat(result.id).isNotNull
        assertThat(result.registeredAt).isNotNull
    }
}
