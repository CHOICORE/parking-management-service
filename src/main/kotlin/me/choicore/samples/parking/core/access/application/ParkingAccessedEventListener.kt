package me.choicore.samples.parking.core.access.application

import me.choicore.samples.parking.core.access.domain.ParkingAccessedEvent
import me.choicore.samples.parking.core.access.domain.ParkingTransaction
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
internal class ParkingAccessedEventListener {
    @EventListener(ParkingAccessedEvent::class)
    fun onParkingAccessedEvent(event: ParkingAccessedEvent) {
        if (event.source is ParkingTransaction) {
            val parkingTransaction: ParkingTransaction = event.source
            log.info("Retrieved parking accessed event, access key: {}", parkingTransaction.accessKey)
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ParkingAccessedEventListener::class.java)
    }
}
