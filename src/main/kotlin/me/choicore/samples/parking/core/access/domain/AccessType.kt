package me.choicore.samples.parking.core.access.domain

enum class AccessType(
    val description: String,
) {
    ARRIVED(description = "입차"),
    DEPARTED(description = "출차"),
}
