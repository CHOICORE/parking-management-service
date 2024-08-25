package me.choicore.samples.parking.core.access.infrastructure

import me.choicore.samples.parking.core.access.domain.ParkingTransaction
import me.choicore.samples.parking.core.access.domain.ParkingTransactionRepository
import org.springframework.stereotype.Repository

@Repository
class ParkingTransactionRepositoryAdapter(
    private val parkingTransactionJpaRepository: ParkingTransactionJpaRepository,
) : ParkingTransactionRepository {
    override fun save(request: ParkingTransaction) {
        ParkingTransactionEntity(request).let {
            parkingTransactionJpaRepository.save(it)
        }
    }
}
