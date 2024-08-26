package me.choicore.samples.parking.core.access.infrastructure

import me.choicore.samples.parking.core.access.domain.ParkingTransaction
import me.choicore.samples.parking.core.access.domain.ParkingTransactionRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository

@Repository
class ParkingTransactionRepositoryAdapter(
    private val parkingTransactionJpaRepository: ParkingTransactionJpaRepository,
) : ParkingTransactionRepository {
    override fun save(parkingTransaction: ParkingTransaction) {
        ParkingTransactionEntity(parkingTransaction)
            .let {
                log.debug("converting parking transaction to entity: {}", it)
                parkingTransactionJpaRepository.save(it)
            }.also {
                log.info("Registered parking transaction id: {}, access key: {}", it.id, it.accessKey)
            }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ParkingTransactionRepositoryAdapter::class.java)
    }
}
