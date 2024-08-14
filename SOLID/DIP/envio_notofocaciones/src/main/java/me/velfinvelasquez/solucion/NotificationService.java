package me.velfinvelasquez.solucion;

// Servicio de notificaciones que depende de una abstracción
public class NotificationService {
    private NotificationSender notificationSender;

    // Inyección de dependencia a través del constructor
    public NotificationService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void notifyUser(String message) {
        notificationSender.sendNotification(message);
    }
}