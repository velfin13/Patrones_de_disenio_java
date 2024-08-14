package me.velfinvelasquez.solucion;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una lista de vehículos con motor
        List<EnginePoweredVehicle> enginePoweredVehicles = new ArrayList<>();
        enginePoweredVehicles.add(new Car("Toyota"));

        for (EnginePoweredVehicle vehicle : enginePoweredVehicles) {
            vehicle.startEngine(); // Funciona sin problemas
        }

        // Crear una lista de vehículos en general
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Honda"));
        vehicles.add(new Bicycle("Mountain Bike"));

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getName());
            // Aquí no se intenta iniciar el motor, porque no todos los vehículos tienen motor
        }
    }
}