package me.velfinvelasquez;

// Implementación concreta: Radio
public class Radio implements Dispositivo {
    private boolean encendido = false;
    private int volumen = 5;

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Radio encendida");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Radio apagada");
    }

    @Override
    public void setVolumen(int nivel) {
        volumen = nivel;
        System.out.println("Volumen de radio ajustado a " + volumen);
    }

    @Override
    public boolean estaEncendido() {
        return encendido;
    }
}