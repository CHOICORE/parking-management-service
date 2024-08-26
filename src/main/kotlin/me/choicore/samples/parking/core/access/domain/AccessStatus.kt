package me.choicore.samples.parking.core.access.domain

enum class AccessStatus(
    val description: String,
) {
    ARRIVED(description = "입차"),
    ARRIVED_UNRECORDED(description = "입차 누락"),
    DEPARTED(description = "출차"),
    DEPARTED_UNRECORDED(description = "출차 누락"),
    COMPLETED(description = "입출차 완료"),
}
