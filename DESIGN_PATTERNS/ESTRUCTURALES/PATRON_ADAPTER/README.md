
# Patrón Adapter

Es un patrón estructural que permite que dos interfaces incompatibles trabajen juntas. Actúa como un "traductor" entre dos clases con interfaces distintas para que puedan interactuar sin cambiar sus implementaciones. Es muy útil cuando necesitas integrar código existente con nuevas funcionalidades sin modificar el código de ninguna de las dos partes.

## Ventajas del patrón adapter

* **Reusabilidad**: Permite utilizar código existente con nuevas interfaces sin modificar el código original.

* **Flexibilidad**: Facilita la adaptación de clases existentes a diferentes interfaces, lo cual es especialmente útil en sistemas grandes.

* **Principio de abierto/cerrado**: Puedes extender el comportamiento de las clases sin modificar su implementación original.


## Ejemplo práctico
Imaginemos un ejemplo en el que tenemos un sistema que usa un servicio para la reproducción de audio que espera trabajar con una interfaz ReproductorAudio. Sin embargo, un nuevo dispositivo solo implementa la interfaz NuevoReproductorAudio. Aquí, usaremos un adaptador para que ambas interfaces sean compatibles.

Primero, definimos la interfaz existente ReproductorAudio y una implementación concreta.

```
// Interfaz esperada por el sistema
public interface ReproductorAudio {
    void reproducir(String tipoArchivo, String nombreArchivo);
}

// Implementación concreta de la interfaz
public class ReproductorMP3 implements ReproductorAudio {
    @Override
    public void reproducir(String tipoArchivo, String nombreArchivo) {
        if ("mp3".equalsIgnoreCase(tipoArchivo)) {
            System.out.println("Reproduciendo archivo MP3: " + nombreArchivo);
        } else {
            System.out.println("Formato no soportado");
        }
    }
}

```

Ahora, supongamos que tenemos una clase NuevoReproductorAudio que funciona de manera diferente y solo reproduce archivos de tipo "mp4".

```
// Clase con una interfaz diferente
public class NuevoReproductorAudio {
    public void reproducirMP4(String nombreArchivo) {
        System.out.println("Reproduciendo archivo MP4: " + nombreArchivo);
    }
}

```

Para hacer que NuevoReproductorAudio sea compatible con ReproductorAudio, creamos una clase adaptadora AdaptadorReproductor que implementa ReproductorAudio y utiliza una instancia de NuevoReproductorAudio.

```
// Clase adaptadora que convierte NuevoReproductorAudio a ReproductorAudio
public class AdaptadorReproductor implements ReproductorAudio {
    private NuevoReproductorAudio nuevoReproductor;

    public AdaptadorReproductor(NuevoReproductorAudio nuevoReproductor) {
        this.nuevoReproductor = nuevoReproductor;
    }

    @Override
    public void reproducir(String tipoArchivo, String nombreArchivo) {
        if ("mp4".equalsIgnoreCase(tipoArchivo)) {
            nuevoReproductor.reproducirMP4(nombreArchivo); // Usa el método específico de NuevoReproductorAudio
        } else {
            System.out.println("Formato no soportado");
        }
    }
}


```

Ahora, el cliente puede utilizar el AdaptadorReproductor para reproducir archivos mp4, como si estuviera usando un ReproductorAudio.
```
public class Main {
    public static void main(String[] args) {
        ReproductorAudio reproductorMP3 = new ReproductorMP3();
        reproductorMP3.reproducir("mp3", "cancion1.mp3");

        NuevoReproductorAudio nuevoReproductor = new NuevoReproductorAudio();
        ReproductorAudio adaptador = new AdaptadorReproductor(nuevoReproductor);
        adaptador.reproducir("mp4", "video1.mp4");
    }
}

```

## salida
```
Reproduciendo archivo MP3: cancion1.mp3
Reproduciendo archivo MP4: video1.mp4


```

## Resumen
En este ejemplo, hemos creado el AdaptadorReproductor para hacer compatible la clase NuevoReproductorAudio con la interfaz ReproductorAudio. El adaptador redirige las solicitudes reproducir("mp4", "archivo.mp4") a NuevoReproductorAudio, permitiendo así que el sistema funcione sin cambios adicionales en el código original.

Este patrón permite que el código existente se mantenga sin alteraciones, y, al mismo tiempo, facilita la integración de nuevas clases con diferentes interfaces.