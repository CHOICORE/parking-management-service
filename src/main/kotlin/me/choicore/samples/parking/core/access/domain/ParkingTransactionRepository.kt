package me.choicore.samples.parking.core.access.domain

interface ParkingTransactionRepository {
    fun save(request: ParkingTransaction)
}
