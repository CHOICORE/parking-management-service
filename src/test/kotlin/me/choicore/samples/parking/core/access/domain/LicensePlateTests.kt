package me.choicore.samples.parking.core.access.domain

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatNoException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LicensePlateTests {
    @ParameterizedTest
    @ValueSource(strings = ["", "12345678", "123가45678", "1234가4567", "123가456", "1234"])
    fun t1(licensePlate: String) {
        assertThatIllegalArgumentException()
            .isThrownBy {
                LicensePlate(licensePlate)
            }.withMessage("Invalid license plate format.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["123가4567", "12가3456"])
    fun t2(licensePlate: String) {
        assertThatNoException()
            .isThrownBy {
                LicensePlate(licensePlate)
            }
    }
}
