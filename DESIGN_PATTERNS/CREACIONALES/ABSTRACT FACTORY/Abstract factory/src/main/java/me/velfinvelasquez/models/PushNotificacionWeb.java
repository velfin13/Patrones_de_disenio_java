package me.velfinvelasquez.models;

public class PushNotificacionWeb implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando notificación push desde la web: " + mensaje);
    }
}