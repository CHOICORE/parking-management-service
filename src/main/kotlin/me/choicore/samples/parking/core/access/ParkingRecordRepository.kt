package me.choicore.samples.parking.core.access

import org.springframework.data.jpa.repository.JpaRepository

interface ParkingRecordRepository : JpaRepository<ParkingRecord, Long> {
    fun findByAccessKey(accessKey: String): ParkingRecord?
}
