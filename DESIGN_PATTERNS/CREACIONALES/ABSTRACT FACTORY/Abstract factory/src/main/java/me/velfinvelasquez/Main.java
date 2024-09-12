package me.velfinvelasquez;

import me.velfinvelasquez.factory.MovilNotificacionFactory;
import me.velfinvelasquez.factory.NotificacionFactory;
import me.velfinvelasquez.factory.WebNotificacionFactory;
import me.velfinvelasquez.models.Notificacion;

public class Main {
    public static void main(String[] args) {
        // Crear una fábrica de notificaciones para la plataforma web
        NotificacionFactory webFactory = new WebNotificacionFactory();
        Notificacion emailWeb = webFactory.crearEmailNotificacion();
        emailWeb.enviar("Mensaje de correo electrónico para web.");

        // Crear una fábrica de notificaciones para la plataforma móvil
        NotificacionFactory movilFactory = new MovilNotificacionFactory();
        Notificacion smsMovil = movilFactory.crearSMSNotificacion();
        smsMovil.enviar("Mensaje de SMS para móvil.");
    }
}