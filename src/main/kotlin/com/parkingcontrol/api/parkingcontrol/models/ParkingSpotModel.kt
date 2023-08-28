package com.parkingcontrol.api.parkingcontrol.models

import java.util.UUID
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "TB_PARKING_SPOT")
class ParkingSpotModel : java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID? = null

    @Column(nullable = false, unique = true, length = 10)
    var parkingSpotNumber: String = ""

    @Column(nullable = false, unique = true, length = 7)
    var licensePlateCar: String = ""

    @Column(nullable = false, length = 70)
    var brandCar: String = ""

    @Column(nullable = false, length = 70)
    var modelCar: String= ""

    @Column(nullable = false, length = 70)
    var colorCar: String = ""

    @Column(nullable = false)
    var registrationDate: java.time.LocalDateTime? = null

    @Column(nullable = false, length = 130)
    var responsibleName: String = ""

    @Column(nullable = false, length = 30)
    var apartment: String = ""

    @Column(nullable = false, length = 30)
    var block: String = ""

    companion object {
        private const val serialVersionUID = 1L
    }

}