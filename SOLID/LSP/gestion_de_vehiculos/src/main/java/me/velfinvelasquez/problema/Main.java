package me.velfinvelasquez.problema;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Vehicle myCar = new Car();
        myCar.startEngine(); // Funciona correctamente

        Vehicle myBike = new Bicycle();
        myBike.startEngine(); // Lanza una excepción
    }
}