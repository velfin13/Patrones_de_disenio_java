package me.velfinvelasquez;

public class Main {
    public static void main(String[] args) {
      
        // Usando el control remoto básico para una televisión
        Dispositivo tv = new Television();
        ControlRemoto controlTv = new ControlRemoto(tv);
        controlTv.encender();
        controlTv.ajustarVolumen(15);

        // Usando el control remoto avanzado para una radio
        Dispositivo radio = new Radio();
        ControlRemotoAvanzado controlRadioAvanzado = new ControlRemotoAvanzado(radio);
        controlRadioAvanzado.encender();
        controlRadioAvanzado.silenciar();
    }
}