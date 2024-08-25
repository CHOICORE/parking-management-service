package me.choicore.samples.parking.core.access.domain

data class LicensePlate(
    val value: String,
) {
    init {
        require(value.matches(LICENSE_PLATE_REGEX)) { "Invalid license plate format: $value" }
    }

    companion object {
        const val LICENSE_PLATE_PATTERN: String = "^[0-9]{2,3}[가-힣][0-9]{4}\$"
        val LICENSE_PLATE_REGEX: Regex = Regex(pattern = LICENSE_PLATE_PATTERN)
    }
}
