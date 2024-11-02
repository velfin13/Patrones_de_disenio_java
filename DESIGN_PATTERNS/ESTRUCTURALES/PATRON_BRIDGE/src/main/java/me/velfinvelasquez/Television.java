package me.velfinvelasquez;

// Implementación concreta: Televisión
public class Television implements Dispositivo {
    private boolean encendido = false;
    private int volumen = 10;

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Televisión encendida");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Televisión apagada");
    }

    @Override
    public void setVolumen(int nivel) {
        volumen = nivel;
        System.out.println("Volumen de televisión ajustado a " + volumen);
    }

    @Override
    public boolean estaEncendido() {
        return encendido;
    }
}
