package me.velfinvelasquez.solucion;

// Implementación para el envío de correos electrónicos
public class EmailSender implements NotificationSender {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}
