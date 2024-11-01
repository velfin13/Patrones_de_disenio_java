package me.velfinvelasquez.service.Cafe;

public class ConLeche extends CafeDecorador {
    public ConLeche(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 1.5; // Añade el costo de la leche
    }

    @Override
    public String getIngredientes() {
        return super.getIngredientes() + ", Leche";
    }
}