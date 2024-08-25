package me.choicore.samples.parking.core.access.domain

data class LicensePlate(
    val value: String,
) {
    init {
        require(value.matches(Regex("^[0-9]{2,3}[가-힣][0-9]{4}\$"))) { "Invalid license plate format." }
    }
}
