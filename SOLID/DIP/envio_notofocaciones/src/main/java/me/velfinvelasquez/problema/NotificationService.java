package me.velfinvelasquez.problema;

public class NotificationService {
    private EmailService emailService;

    public NotificationService() {
        this.emailService = new EmailService();
    }

    public void notifyUser(String message) {
        emailService.sendEmail(message);
    }
}