package me.velfinvelasquez.service.Cafe;

public class ConCanela extends CafeDecorador {
    public ConCanela(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 0.5; // Añade el costo de la canela
    }

    @Override
    public String getIngredientes() {
        return super.getIngredientes() + ", Canela";
    }
}