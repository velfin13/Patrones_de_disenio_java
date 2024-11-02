
# Patrón Bridge

Es un patrón estructural que permite separar la abstracción de su implementación, de modo que ambas puedan evolucionar de manera independiente. Este patrón es útil cuando quieres que tus clases abstractas sean flexibles y puedan adaptarse a múltiples implementaciones sin que cada implementación dependa de la abstracción.

## Ventajas del patrón bridge

* **Desacoplamiento**: Separa la abstracción de la implementación, permitiendo que ambas evolucionen independientemente.

* **Extensibilidad**: Facilita la adición de nuevas abstracciones e implementaciones sin modificar el código existente.

* **Mayor flexibilidad**: Permite combinar diferentes abstracciones con varias implementaciones de forma dinámica.

## Ejemplo práctico
Supongamos que tenemos un sistema de dispositivos y queremos controlar diferentes tipos de dispositivos (como televisores y radios) a través de distintos controles remotos (como controles básicos y avanzados). Utilizando el patrón Bridge, podemos crear una estructura flexible que permita agregar nuevos tipos de dispositivos y controles sin cambios significativos en el código.

Primero, creamos una interfaz Dispositivo, que representa la implementación para diferentes tipos de dispositivos.

```
// Implementación para dispositivos
public interface Dispositivo {
    void encender();
    void apagar();
    void setVolumen(int nivel);
    boolean estaEncendido();
}

```

Luego, implementamos la interfaz para dispositivos específicos, como Television y Radio.

```
// Implementación concreta: Televisión
public class Television implements Dispositivo {
    private boolean encendido = false;
    private int volumen = 10;

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Televisión encendida");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Televisión apagada");
    }

    @Override
    public void setVolumen(int nivel) {
        volumen = nivel;
        System.out.println("Volumen de televisión ajustado a " + volumen);
    }

    @Override
    public boolean estaEncendido() {
        return encendido;
    }
}

// Implementación concreta: Radio
public class Radio implements Dispositivo {
    private boolean encendido = false;
    private int volumen = 5;

    @Override
    public void encender() {
        encendido = true;
        System.out.println("Radio encendida");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Radio apagada");
    }

    @Override
    public void setVolumen(int nivel) {
        volumen = nivel;
        System.out.println("Volumen de radio ajustado a " + volumen);
    }

    @Override
    public boolean estaEncendido() {
        return encendido;
    }
}


```

A continuación, creamos una clase ControlRemoto, que actúa como una abstracción para el control de dispositivos. Esta clase contiene una referencia a la implementación Dispositivo.

```
// Abstracción de Control Remoto
public class ControlRemoto {
    protected Dispositivo dispositivo;

    public ControlRemoto(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void encender() {
        dispositivo.encender();
    }

    public void apagar() {
        dispositivo.apagar();
    }

    public void ajustarVolumen(int nivel) {
        dispositivo.setVolumen(nivel);
    }
}


```

Luego, podemos crear una versión avanzada del control remoto que extiende las funcionalidades básicas, llamada ControlRemotoAvanzado.
```
// Abstracción extendida: Control Remoto Avanzado
public class ControlRemotoAvanzado extends ControlRemoto {

    public ControlRemotoAvanzado(Dispositivo dispositivo) {
        super(dispositivo);
    }

    public void silenciar() {
        System.out.println("Silenciando dispositivo");
        dispositivo.setVolumen(0);
    }
}

```

## Uso del patrón Bridge
Ahora podemos combinar diferentes implementaciones de dispositivos con distintos tipos de controles remotos.

```
public class Main {
    public static void main(String[] args) {
        // Usando el control remoto básico para una televisión
        Dispositivo tv = new Television();
        ControlRemoto controlTv = new ControlRemoto(tv);
        controlTv.encender();
        controlTv.ajustarVolumen(20);

        // Usando el control remoto avanzado para una radio
        Dispositivo radio = new Radio();
        ControlRemotoAvanzado controlRadioAvanzado = new ControlRemotoAvanzado(radio);
        controlRadioAvanzado.encender();
        controlRadioAvanzado.silenciar();
    }
}

```

## salida
```
Televisión encendida
Volumen de televisión ajustado a 20
Radio encendida
Silenciando dispositivo
Volumen de radio ajustado a 0

```

## Resumen
En este ejemplo, el patrón Bridge permite que los dispositivos y los controles remotos sean independientes. Hemos separado la abstracción (control remoto) de su implementación concreta (televisión y radio). El control remoto avanzado tiene funcionalidades adicionales (como silenciar) que pueden utilizarse con cualquier dispositivo.

Gracias a esta estructura, es fácil agregar nuevos tipos de dispositivos o nuevos tipos de controles sin modificar el código existente, lo que hace que el sistema sea extensible y flexible.