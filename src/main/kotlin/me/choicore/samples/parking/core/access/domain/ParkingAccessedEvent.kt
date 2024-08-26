package me.choicore.samples.parking.core.access.domain

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDateTime

data class ParkingAccessedEvent(
    val source: Any,
) {
    val publishedAt: LocalDateTime = LocalDateTime.now()

    init {
        log.info("Published parking accessed event, at: {}", publishedAt)
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ParkingAccessedEvent::class.java)
    }
}
