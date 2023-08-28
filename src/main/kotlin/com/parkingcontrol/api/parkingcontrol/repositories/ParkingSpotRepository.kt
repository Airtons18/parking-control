package com.parkingcontrol.api.parkingcontrol.repositories

import com.parkingcontrol.api.parkingcontrol.models.ParkingSpotModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ParkingSpotRepository : JpaRepository<ParkingSpotModel, UUID>{
    fun existByLicensePlateCar(licensePlateCar: String): Boolean
    fun existByParkingSpotNumber(parkingSpotNumber: String): Boolean
    fun existByApartmentAndBlock(apartment: String, block: String): Boolean
}