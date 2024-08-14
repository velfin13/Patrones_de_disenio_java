
# Dependency Inversion Principle, DIP

**El Principio de Inversión de Dependencia** (Dependency Inversion Principle, DIP) es el quinto y último de los principios SOLID, y establece que:

* Los módulos de alto nivel no deben depender de módulos de bajo nivel. Ambos deben depender de abstracciones.
* Las abstracciones no deben depender de los detalles. Los detalles deben depender de las abstracciones.

En otras palabras, en lugar de depender directamente de implementaciones concretas, el código debe depender de interfaces o clases abstractas. Esto reduce el acoplamiento y aumenta la flexibilidad del sistema.

## Ejemplo: Envío de Notificaciones
Imaginemos un sistema donde una clase NotificationService envía notificaciones a los usuarios. Inicialmente, el sistema puede enviar notificaciones por correo electrónico, pero en el futuro podría extenderse para enviar notificaciones por SMS u otros medios.

## Ejemplo que viola el DIP:

```
// Servicio de notificaciones que envía correos electrónicos
class EmailService {
    public void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

class NotificationService {
    private EmailService emailService;

    public NotificationService() {
        this.emailService = new EmailService();
    }

    public void notifyUser(String message) {
        emailService.sendEmail(message);
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.notifyUser("Your order has been shipped!");
    }
}
```

## Problema:

En este ejemplo, la clase **NotificationService** depende directamente de la implementación concreta **EmailService**. Si en el futuro se quiere agregar otro tipo de notificación, como SMS, sería necesario modificar la clase **NotificationService**, violando así el **DIP**.

## Ejemplo que sigue el DIP:
Para cumplir con el DIP, podemos crear una interfaz **NotificationSender** que defina el contrato para enviar notificaciones. Luego, **NotificationService** dependerá de esta interfaz, y podremos tener múltiples implementaciones.

```
// Interfaz que define el contrato para enviar notificaciones
interface NotificationSender {
    void sendNotification(String message);
}

// Implementación para el envío de correos electrónicos
class EmailSender implements NotificationSender {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}

// Implementación para el envío de SMS
class SMSSender implements NotificationSender {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// Servicio de notificaciones que depende de una abstracción
class NotificationService {
    private NotificationSender notificationSender;

    // Inyección de dependencia a través del constructor
    public NotificationService(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    public void notifyUser(String message) {
        notificationSender.sendNotification(message);
    }
}

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
```

## Explicación del Código:
* **NotificationSender**: Es una interfaz que define el método sendNotification. Este es el contrato que las implementaciones concretas deben seguir.
* **EmailSender y SMSSender**: Son implementaciones concretas de la interfaz NotificationSender. Cada una sabe cómo enviar una notificación a través de un canal específico.
* **NotificationService**: Depende de la abstracción (NotificationSender) y no de una implementación concreta. La dependencia se inyecta a través del constructor, lo que permite cambiar fácilmente la implementación sin modificar el código de NotificationService.

## Ejecución del main:
* Puedes ver que **NotificationService** puede funcionar tanto con **EmailSender** como con **SMSSender** sin necesidad de cambiar su código.
* Esto muestra cómo el **DIP** ayuda a crear un código más flexible y fácil de mantener.

## Resumen
El Principio de Inversión de Dependencia promueve la desacoplar módulos de alto nivel y módulos de bajo nivel mediante el uso de abstracciones. Esto no solo hace que el código sea más flexible y fácil de extender, sino que también facilita las pruebas, ya que las implementaciones concretas pueden ser fácilmente reemplazadas por versiones simuladas (mocks).