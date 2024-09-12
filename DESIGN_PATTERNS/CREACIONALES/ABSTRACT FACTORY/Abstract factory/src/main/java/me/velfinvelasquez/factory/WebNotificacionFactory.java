package me.velfinvelasquez.factory;

import me.velfinvelasquez.models.EmailNotificacionWeb;
import me.velfinvelasquez.models.Notificacion;
import me.velfinvelasquez.models.PushNotificacionWeb;
import me.velfinvelasquez.models.SMSNotificacionWeb;

public class WebNotificacionFactory implements NotificacionFactory {
    @Override
    public Notificacion crearEmailNotificacion() {
        return new EmailNotificacionWeb();
    }

    @Override
    public Notificacion crearSMSNotificacion() {
        return new SMSNotificacionWeb();
    }

    @Override
    public Notificacion crearPushNotificacion() {
        return new PushNotificacionWeb();
    }
}