// Abstract class representing a general vehicle
abstract class Vehicle(val make: String, val model: String, val year: Int) {

    // Abstract method to calculate the mileage of the vehicle
    abstract fun calculateMileage(): Double

    // Concrete method to display vehicle information
    fun displayInfo() {
        println("Vehicle: $year $make $model")
        println("Mileage: ${calculateMileage()} miles per gallon")
    }
}

// Interface representing a vehicle with electric capabilities
interface ElectricVehicle {
    val range: Double // Range in miles

    fun chargeBattery() {
        println("Charging battery...")
    }
}

// Class representing a Car which is a type of Vehicle
open class Car(make: String, model: String, year: Int, val mileage: Double) : Vehicle(make, model, year) {

    override fun calculateMileage(): Double {
        return mileage
    }
}

// Class representing an ElectricCar which is a type of Car and ElectricVehicle
  class ElectricCar(make: String, model: String, year: Int, mileage: Double, override val range: Double) : Car(make, model, year, mileage), ElectricVehicle {

    override fun calculateMileage(): Double {
        // For electric cars, mileage is represented by range
        return range
    }
}

fun main() {
    // Create a regular car
    val car = Car("Toyota", "Corolla", 2020, 35.5)
    println("Car Information:")
    car.displayInfo()

    println()

    // Create an electric car
    val electricCar = ElectricCar("Tesla", "Model 3", 2022, 0.0, 300.0)
    println("Electric Car Information:")
    electricCar.displayInfo()
    electricCar.chargeBattery()
}

// bu error bitdi bideyqe dayan koda baxim gorum isleme mentiqi necedi
//