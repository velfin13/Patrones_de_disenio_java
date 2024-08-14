package me.velfinvelasquez.solucion;

// Implementación para el envío de SMS
public class SMSSender implements NotificationSender {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
