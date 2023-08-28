package com.parkingcontrol.api.parkingcontrol.controllers

import com.parkingcontrol.api.parkingcontrol.dtos.ParkingSpotDto
import com.parkingcontrol.api.parkingcontrol.models.ParkingSpotModel
import com.parkingcontrol.api.parkingcontrol.services.ParkingSpotService
import jakarta.validation.Valid
import org.springframework.beans.BeanUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.time.ZoneId


@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("/parking-spot")
class ParkingSpotController(val parkingSpotService: ParkingSpotService){
    @PostMapping
    fun saveParkingSpot(@RequestBody parkingSpotDto: @Valid ParkingSpotDto): ResponseEntity<Any>? {

        if (parkingSpotService.existByLicensePlateCar(parkingSpotDto.licensePlateCar!!)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!")
        }
        if (parkingSpotService.existByParkingSpotNumber(parkingSpotDto.parkingSpotNumber!!)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!")
        }
        if (parkingSpotService.existByApartmentAndBlock(parkingSpotDto.apartment!!, parkingSpotDto.block!!)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!")
        }

        val parkingSpotModel = ParkingSpotModel()
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel)
        parkingSpotModel.registrationDate = LocalDateTime.now(ZoneId.of("UTC"))
        return ResponseEntity.status(HttpStatus.CONFLICT).body(parkingSpotService.save(parkingSpotModel))
    }



    }

