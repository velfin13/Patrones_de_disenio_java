package me.velfinvelasquez.models;

public class SMSNotificacionWeb implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS desde la web: " + mensaje);
    }
}