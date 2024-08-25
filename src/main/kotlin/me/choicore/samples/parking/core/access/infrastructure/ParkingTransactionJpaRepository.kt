package me.choicore.samples.parking.core.access.infrastructure

import org.springframework.data.jpa.repository.JpaRepository

interface ParkingTransactionJpaRepository : JpaRepository<ParkingTransactionEntity, Long>
