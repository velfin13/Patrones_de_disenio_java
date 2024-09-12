
# Patrón Abstract Factory

El Patrón Abstract Factory es una extensión del Patrón Factory Method. Se utiliza cuando necesitamos crear familias de objetos relacionados o dependientes sin especificar sus clases concretas. Este patrón proporciona una interfaz para crear objetos de diferentes familias, lo que facilita la creación de conjuntos de objetos interrelacionados.

## Caso Práctico:

Imaginemos que estamos desarrollando una aplicación que necesita crear diferentes tipos de Notificaciones para plataformas móviles y web. Cada plataforma puede enviar correo electrónico, SMS, o notificaciones push. Usaremos el Patrón Abstract Factory para crear las notificaciones adecuadas dependiendo de la plataforma.

1) Definimos una Interfaz Abstracta **Notificacion**: Esta interfaz será la base para todas las notificaciones.
```
public interface Notificacion {
    void enviar(String mensaje);
}

```
2) Creamos las Clases Concretas que Implementan la Interfaz **Notificacion**:

```
// Notificaciones para la plataforma web
public class EmailNotificacionWeb implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando correo electrónico desde la web: " + mensaje);
    }
}

public class SMSNotificacionWeb implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS desde la web: " + mensaje);
    }
}

public class PushNotificacionWeb implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando notificación push desde la web: " + mensaje);
    }
}

// Notificaciones para la plataforma móvil
public class EmailNotificacionMovil implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando correo electrónico desde el móvil: " + mensaje);
    }
}

public class SMSNotificacionMovil implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS desde el móvil: " + mensaje);
    }
}

public class PushNotificacionMovil implements Notificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando notificación push desde el móvil: " + mensaje);
    }
}

```

3) Definimos una Interfaz Abstracta **NotificacionFactory** que Declare Métodos para Crear los Objetos:

```
public interface NotificacionFactory {
    Notificacion crearEmailNotificacion();
    Notificacion crearSMSNotificacion();
    Notificacion crearPushNotificacion();
}

```
4) Creamos las Clases Concretas que Implementan la Interfaz **NotificacionFactory** para Cada Plataforma:

```
// Fábrica concreta para la plataforma web
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

// Fábrica concreta para la plataforma móvil
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

```
5) Utilizamos las Fábricas Abstractas en el Método Principal de la Aplicación

```
public class Main {
    public static void main(String[] args) {
        // Crear una fábrica de notificaciones para la plataforma web
        NotificacionFactory webFactory = new WebNotificacionFactory();
        Notificacion emailWeb = webFactory.crearEmailNotificacion();
        emailWeb.enviar("Mensaje de correo electrónico para web.");

        // Crear una fábrica de notificaciones para la plataforma móvil
        NotificacionFactory movilFactory = new MovilNotificacionFactory();
        Notificacion smsMovil = movilFactory.crearSMSNotificacion();
        smsMovil.enviar("Mensaje de SMS para móvil.");
    }
}

```

## Ventajas del Patrón Abstract Factory

- **Consistencia de Productos**: Facilita la creación de familias de productos relacionados (por ejemplo, notificaciones para web y móvil) manteniendo su consistencia.
- **Escalabilidad**: Facilita la adición de nuevas familias de productos simplemente añadiendo nuevas implementaciones de las fábricas.
- **Desacoplamiento:** El código del cliente no necesita conocer las clases concretas que está utilizando, solo la fábrica abstracta.

## Conclusión
El **patrón Abstract Factory** es ideal cuando se necesita crear familias de objetos relacionados sin acoplarlos a su clase concreta. Es especialmente útil en aplicaciones que requieren múltiples versiones de un conjunto de objetos interdependientes.
