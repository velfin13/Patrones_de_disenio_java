package me.velfinvelasquez.factory;

import me.velfinvelasquez.models.Notificacion;

public interface NotificacionFactory {
    Notificacion crearEmailNotificacion();

    Notificacion crearSMSNotificacion();

    Notificacion crearPushNotificacion();
}
