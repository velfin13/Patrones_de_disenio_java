package me.velfinvelasquez;

// Abstracción extendida: Control Remoto Avanzado
public class ControlRemotoAvanzado extends ControlRemoto {

    public ControlRemotoAvanzado(Dispositivo dispositivo) {
        super(dispositivo);
    }

    public void silenciar() {
        System.out.println("Silenciando dispositivo");
        dispositivo.setVolumen(0);
    }
}
