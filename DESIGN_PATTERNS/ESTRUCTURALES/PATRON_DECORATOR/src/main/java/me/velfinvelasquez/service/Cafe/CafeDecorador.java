package me.velfinvelasquez.service.Cafe;

public abstract class CafeDecorador implements Cafe {
    protected Cafe cafeDecorado;

    public CafeDecorador(Cafe cafeDecorado) {
        this.cafeDecorado = cafeDecorado;
    }

    @Override
    public double getCosto() {
        return cafeDecorado.getCosto();
    }

    @Override
    public String getIngredientes() {
        return cafeDecorado.getIngredientes();
    }
}