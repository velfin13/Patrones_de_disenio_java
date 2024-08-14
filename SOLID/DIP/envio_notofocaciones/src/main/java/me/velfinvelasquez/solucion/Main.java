package me.velfinvelasquez.solucion;

public class Main {
    public static void main(String[] args) {
        // Puedes cambiar la implementación sin modificar NotificationService
        NotificationSender emailSender = new EmailSender();
        NotificationService notificationService = new NotificationService(emailSender);
        notificationService.notifyUser("Your order has been shipped!");

        // Ahora con SMS
        NotificationSender smsSender = new SMSSender();
        notificationService = new NotificationService(smsSender);
        notificationService.notifyUser("Your package has been delivered!");
    }
}