package me.choicore.samples.parking.core.access.domain

enum class AccessType(
    val description: String,
) {
    ENTERED(description = "입차"),
    EXITED(description = "출차"),
}
