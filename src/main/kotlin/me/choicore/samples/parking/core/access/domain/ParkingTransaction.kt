package me.choicore.samples.parking.core.access.domain

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit

data class ParkingTransaction(
    val accessKey: AccessKey?,
    val licensePlate: LicensePlate,
    val accessType: AccessType,
    val accessedAt: LocalDateTime,
) {
    val accessedDate: LocalDate = accessedAt.toLocalDate()
    val accessedTime: LocalTime = accessedAt.toLocalTime().truncatedTo(ChronoUnit.SECONDS)
}
