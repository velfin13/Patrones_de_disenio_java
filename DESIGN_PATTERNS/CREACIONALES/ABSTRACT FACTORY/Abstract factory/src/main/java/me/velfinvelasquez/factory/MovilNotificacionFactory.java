package me.velfinvelasquez.factory;

import me.velfinvelasquez.models.EmailNotificacionMovil;
import me.velfinvelasquez.models.Notificacion;
import me.velfinvelasquez.models.PushNotificacionMovil;
import me.velfinvelasquez.models.SMSNotificacionMovil;

public class MovilNotificacionFactory implements NotificacionFactory {
    @Override
    public Notificacion crearEmailNotificacion() {
        return new EmailNotificacionMovil();
    }

    @Override
    public Notificacion crearSMSNotificacion() {
        return new SMSNotificacionMovil();
    }

    @Override
    public Notificacion crearPushNotificacion() {
        return new PushNotificacionMovil();
    }
}