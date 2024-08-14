package me.velfinvelasquez.problema;

public class Bicycle extends Vehicle {
    @Override
    public void startEngine() {
        throw new UnsupportedOperationException("Bicycles don't have engines.");
    }
}
