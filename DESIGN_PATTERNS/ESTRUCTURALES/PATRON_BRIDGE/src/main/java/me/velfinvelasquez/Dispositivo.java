package me.velfinvelasquez;

// Implementación para dispositivos
public interface Dispositivo {
    void encender();
    void apagar();
    void setVolumen(int nivel);
    boolean estaEncendido();
}