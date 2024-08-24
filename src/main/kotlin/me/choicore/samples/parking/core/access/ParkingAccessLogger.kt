package me.choicore.samples.parking.core.access

import org.springframework.stereotype.Service

@Service
class ParkingAccessLogger(
    private val parkingAccessRepository: ParkingAccessRepository,
)
