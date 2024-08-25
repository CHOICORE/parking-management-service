package me.choicore.samples.parking.core.access.domain

import org.springframework.stereotype.Service

@Service
class ParkingTransactionLogger(
    private val parkingTransactionRepository: ParkingTransactionRepository,
) {
    fun log(request: ParkingTransaction) {
        parkingTransactionRepository.save(request)
    }
}
