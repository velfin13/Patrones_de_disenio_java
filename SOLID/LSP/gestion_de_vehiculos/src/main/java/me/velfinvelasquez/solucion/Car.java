package me.velfinvelasquez.solucion;

// Clase para autos, que son vehículos con motor
class Car extends Vehicle implements EnginePoweredVehicle {
    public Car(String name) {
        super(name);
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }
}