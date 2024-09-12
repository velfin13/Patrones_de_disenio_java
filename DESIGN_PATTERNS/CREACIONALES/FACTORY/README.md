
# El patrón Factory

El patrón de diseño Factory (o Factory Method) es un patrón de creación que proporciona una interfaz para crear objetos en una superclase, pero permite que las subclases alteren el tipo de objetos que se crearán. Este patrón es especialmente útil cuando no sabemos de antemano qué clase de objeto necesitaremos instanciar o cuando queremos delegar la creación de objetos a subclases.

## Características clave del patrón Builder:

- **Desacoplamiento**: Separa el código que crea instancias de objetos del código que los utiliza, promoviendo así un bajo acoplamiento entre las clases.
- **Flexibilidad**: Permite cambiar o extender fácilmente las clases que se instancian, sin modificar el código que utiliza esas instancias.
- **Reutilización**: Facilita la reutilización del código al encapsular la lógica de creación de objetos en un solo lugar.

## Caso Práctico:

Vamos a crear un ejemplo práctico utilizando el patrón Factory en un escenario donde se requiere crear diferentes tipos de "Notificaciones". Supongamos que tenemos una aplicación que necesita enviar notificaciones por correo electrónico, SMS, y push notifications.

En lugar de tener un código que instancie directamente cada tipo de notificación, usaremos el patrón Factory para crear estas notificaciones.

1) **Definimos una interfaz Notificacion**: Esta interfaz será la base para todas las clases de notificación.
```
public interface Notificacion {
    void enviar(String mensaje);
}

```
2) Creamos las clases concretas que implementan la interfaz **Notificacion**:

```
public class EmailNotificacion implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando correo electrónico: " + mensaje);
    }
}

public class SMSNotificacion implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
    }
}

public class PushNotificacion implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando notificación push: " + mensaje);
    }
}
```

3) Implementamos la clase **NotificacionFactory** que será responsable de crear las instancias de **Notificacion** según el tipo requerido:

```
public class NotificacionFactory {
    public static Notificacion crearNotificacion(String tipo) {
        switch (tipo) {
            case "EMAIL":
                return new EmailNotificacion();
            case "SMS":
                return new SMSNotificacion();
            case "PUSH":
                return new PushNotificacion();
            default:
                throw new IllegalArgumentException("Tipo de notificación no soportado.");
        }
    }
}

```
4) Utilizamos la fábrica en el método principal de la aplicación:

```
public class Main {
    public static void main(String[] args) {
        // Crear una notificación de tipo EMAIL
        Notificacion notificacionEmail = NotificacionFactory.crearNotificacion("EMAIL");
        notificacionEmail.enviar("Hola, este es un mensaje de correo electrónico!");

        // Crear una notificación de tipo SMS
        Notificacion notificacionSMS = NotificacionFactory.crearNotificacion("SMS");
        notificacionSMS.enviar("Hola, este es un mensaje SMS!");

        // Crear una notificación de tipo PUSH
        Notificacion notificacionPush = NotificacionFactory.crearNotificacion("PUSH");
        notificacionPush.enviar("Hola, este es un mensaje Push!");
    }
}

```
## Ventajas de este Ejemplo

- **Flexibilidad**: Es fácil añadir nuevas notificaciones (como WhatsApp, Telegram, etc.) simplemente agregando nuevas clases que implementen la interfaz Notificacion y actualizando el método crearNotificacion en la fábrica.
- **Mantenibilidad**: El código que utiliza las notificaciones no necesita conocer los detalles de la implementación de cada tipo de notificación.
- **Desacoplamiento**: Separa la lógica de creación de objetos de su uso, promoviendo el uso de interfaces y la programación orientada a objetos.

## Conclusión
Este ejemplo muestra cómo usar el patrón Factory para simplificar la creación de objetos y aumentar la flexibilidad del código, permitiendo agregar nuevos tipos de notificaciones fácilmente sin modificar el código existente.
