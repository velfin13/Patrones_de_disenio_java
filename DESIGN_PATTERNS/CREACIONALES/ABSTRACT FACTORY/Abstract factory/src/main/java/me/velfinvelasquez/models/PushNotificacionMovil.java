package me.velfinvelasquez.models;

public class PushNotificacionMovil implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando notificación push desde el móvil: " + mensaje);
    }
}