package com.parkingcontrol.api.parkingcontrol.dtos

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

class ParkingSpotDto{
    @NotBlank
    var parkingSpotNumber: String? = null
    @NotBlank
    @Size(max = 7)
    var licensePlateCar: String? = null
    @NotBlank
    var brandCard: String? = null
    @NotBlank
    var modelCar: String? = null
    @NotBlank
    var colorCar: String? = null
    @NotBlank
    var responsibleName: String? = null
    @NotBlank
    var apartment: String? = null
    @NotBlank
    var block: String? = null


}