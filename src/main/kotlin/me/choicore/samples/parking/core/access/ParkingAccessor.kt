package me.choicore.samples.parking.core.access

import me.choicore.samples.parking.core.access.AccessType.ENTERED
import me.choicore.samples.parking.core.access.AccessType.EXITED
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class ParkingAccessor(
    private val parkingAccessRepository: ParkingAccessRepository,
    private val parkingRecordRepository: ParkingRecordRepository,
) {
    @Transactional
    fun entered(
        licensePlate: String,
        enteredAt: LocalDateTime,
    ): AccessKey {
        val accessKey: AccessKey = AccessKey.generate()
        log.info(
            "Parking Entered - License Plate: {}, Access Key Generated: {}, Entered At: {}",
            licensePlate,
            accessKey,
            enteredAt,
        )

        parkingAccessRepository.save(
            ParkingAccess(
                licensePlate = licensePlate,
                accessKey = accessKey.value,
                accessType = ENTERED,
                accessedAt = enteredAt,
            ),
        )

        parkingRecordRepository.save(
            ParkingRecord(
                licensePlate = licensePlate,
                accessKey = accessKey.value,
                enteredAt = enteredAt,
            ),
        )

        return accessKey
    }

    @Transactional
    fun exited(
        accessKey: AccessKey,
        licensePlate: String,
        exitedAt: LocalDateTime,
    ) {
        log.info(
            "Parking Exited - License Plate: {}, Provided Access Key: {}, Exited At: {}",
            licensePlate,
            accessKey,
            exitedAt,
        )

        parkingAccessRepository.save(
            ParkingAccess(
                licensePlate = licensePlate,
                accessKey = accessKey.value,
                accessType = EXITED,
                accessedAt = exitedAt,
            ),
        )

        parkingRecordRepository.findByAccessKey(accessKey.value)?.let { found ->
            if (found.licensePlate == licensePlate) {
                found.exit(exitedAt)
            } else {
                // TODO: Handle this case
            }
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(ParkingAccessor::class.java)
    }
}
