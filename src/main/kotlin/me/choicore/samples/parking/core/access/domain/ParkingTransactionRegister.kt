package me.choicore.samples.parking.core.access.domain

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ParkingTransactionRegister(
    private val parkingTransactionRepository: ParkingTransactionRepository,
) {
    fun register(parkingTransaction: ParkingTransaction) {
        log.info("Registering parking transaction: {}", parkingTransaction)
        parkingTransactionRepository.save(parkingTransaction)
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ParkingTransactionRegister::class.java)
    }
}
