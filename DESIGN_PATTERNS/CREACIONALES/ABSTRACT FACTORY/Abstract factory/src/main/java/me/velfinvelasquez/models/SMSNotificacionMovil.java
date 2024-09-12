package me.velfinvelasquez.models;

public class SMSNotificacionMovil implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS desde el móvil: " + mensaje);
    }
}
