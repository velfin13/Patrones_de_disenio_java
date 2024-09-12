package me.velfinvelasquez;

import me.velfinvelasquez.factory.NotificacionFactory;
import me.velfinvelasquez.models.Notificacion;
import me.velfinvelasquez.models.TipoNotificacion;

public class Main {
    public static void main(String[] args) {
        // Crear una notificación de tipo EMAIL
        Notificacion notificacionEmail = NotificacionFactory.crearNotificacion(TipoNotificacion.EMAIL);
        notificacionEmail.enviar("Hola, este es un mensaje de correo electrónico!");

        // Crear una notificación de tipo SMS
        Notificacion notificacionSMS = NotificacionFactory.crearNotificacion(TipoNotificacion.SMS);
        notificacionSMS.enviar("Hola, este es un mensaje SMS!");

        // Crear una notificación de tipo PUSH
        Notificacion notificacionPush = NotificacionFactory.crearNotificacion(TipoNotificacion.PUSH);
        notificacionPush.enviar("Hola, este es un mensaje Push!");
    }
}