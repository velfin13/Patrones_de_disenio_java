package me.velfinvelasquez.service.Cafe;

public class CafeSimple implements Cafe {
    @Override
    public double getCosto() {
        return 5.0; // Precio base del café
    }

    @Override
    public String getIngredientes() {
        return "Café";
    }
}