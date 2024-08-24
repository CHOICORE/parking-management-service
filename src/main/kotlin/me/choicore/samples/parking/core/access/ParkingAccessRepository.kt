package me.choicore.samples.parking.core.access

import org.springframework.data.jpa.repository.JpaRepository

interface ParkingAccessRepository : JpaRepository<ParkingAccess, Long> {
    fun findByAccessTypeAndAccessKey(
        accessType: AccessType,
        accessKey: String,
    ): ParkingAccess?
}
