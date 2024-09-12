package me.velfinvelasquez.models;

public class EmailNotificacionMovil implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando correo electrónico desde el móvil: " + mensaje);
    }
}