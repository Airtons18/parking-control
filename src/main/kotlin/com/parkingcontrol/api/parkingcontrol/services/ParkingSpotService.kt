package com.parkingcontrol.api.parkingcontrol.services
import com.parkingcontrol.api.parkingcontrol.models.ParkingSpotModel
import com.parkingcontrol.api.parkingcontrol.repositories.ParkingSpotRepository


import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ParkingSpotService(val parkingSpotRepository: ParkingSpotRepository) {
    @Transactional
    fun save(parkingSpotModel: ParkingSpotModel): ParkingSpotModel {
        return parkingSpotRepository.save(parkingSpotModel)
    }

    fun existByLicensePlateCar(licensePlateCar: String?): Boolean {
        return parkingSpotRepository.existByLicensePlateCar(licensePlateCar = "")
    }

    fun existByParkingSpotNumber(parkingSpotNumber: String?): Boolean {
        return parkingSpotRepository.existByParkingSpotNumber(parkingSpotNumber = "")
    }

    fun existByApartmentAndBlock(apartment: String?, block: String?): Boolean {
        return parkingSpotRepository.existByApartmentAndBlock(apartment = "", block = "")
    }
}