package me.velfinvelasquez.models;

public class EmailNotificacionWeb implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando correo electrónico desde la web: " + mensaje);
    }
}