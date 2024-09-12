package me.velfinvelasquez.factory;

import me.velfinvelasquez.models.EmailNotificacion;
import me.velfinvelasquez.models.Notificacion;
import me.velfinvelasquez.models.PushNotificacion;
import me.velfinvelasquez.models.SMSNotificacion;
import me.velfinvelasquez.models.TipoNotificacion;

public class NotificacionFactory {
 
    public static Notificacion crearNotificacion(TipoNotificacion tipo) {
        switch (tipo) {
            case EMAIL:
                return new EmailNotificacion();
            case SMS:
                return new SMSNotificacion();
            case PUSH:
                return new PushNotificacion();
            default:
                throw new IllegalArgumentException("Tipo de notificación no soportado.");
        }
    }
}
