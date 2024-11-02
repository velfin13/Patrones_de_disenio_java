package me.velfinvelasquez;

// Abstracción de Control Remoto
public class ControlRemoto {
    protected Dispositivo dispositivo;

    public ControlRemoto(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void encender() {
        dispositivo.encender();
    }

    public void apagar() {
        dispositivo.apagar();
    }

    public void ajustarVolumen(int nivel) {
        dispositivo.setVolumen(nivel);
    }
}