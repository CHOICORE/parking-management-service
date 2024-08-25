package me.choicore.samples.parking.core.access.domain

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

data class ParkingTransaction(
    val licensePlate: LicensePlate,
    val accessKey: AccessKey?,
    val accessType: AccessType,
    val accessedAt: LocalDateTime,
) {
    val accessedTime: LocalTime = accessedAt.toLocalTime()
    val accessedDate: LocalDate = accessedAt.toLocalDate()
}
