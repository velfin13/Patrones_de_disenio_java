
# Patrón Composite

Es un patrón estructural que permite tratar a un grupo de objetos de la misma manera que a un único objeto. Este patrón organiza los objetos en estructuras jerárquicas en forma de árbol y permite tratar tanto a los objetos individuales como a las composiciones de objetos de manera uniforme.

## Ventajas del patrón composite

* **Jerarquía de objetos**: Facilita la creación de estructuras de objetos en forma de árbol, como menús, archivos y carpetas.

* **Uniformidad:** Permite que los clientes traten de la misma manera a objetos individuales y compuestos.

* **Extensibilidad:** Facilita la adición de nuevos tipos de componentes sin alterar el código cliente.

## Ejemplo práctico
Imaginemos un sistema de archivos donde tenemos archivos individuales y carpetas que pueden contener archivos o incluso otras carpetas. Queremos poder listar el contenido de una carpeta o un archivo usando una interfaz común.

Primero, definimos una interfaz ComponenteArchivo, que representa tanto archivos individuales como carpetas.

```
// Componente base
public interface ComponenteArchivo {
    void mostrarDetalles();
}
```
Luego, implementamos la clase Archivo, que representa un archivo individual, y que implementa la interfaz ComponenteArchivo.

```
// Clase hoja: Archivo individual
public class Archivo implements ComponenteArchivo {
    private String nombre;
    private int tamaño; // en KB

    public Archivo(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Archivo: " + nombre + " (" + tamaño + " KB)");
    }
}
```
Ahora creamos la clase Carpeta, que puede contener múltiples ComponenteArchivo (ya sean archivos o carpetas), y también implementa la interfaz ComponenteArchivo.

```
// Clase compuesta: Carpeta
import java.util.ArrayList;
import java.util.List;

public class Carpeta implements ComponenteArchivo {
    private String nombre;
    private List<ComponenteArchivo> componentes = new ArrayList<>();

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ComponenteArchivo componente) {
        componentes.add(componente);
    }

    public void eliminar(ComponenteArchivo componente) {
        componentes.remove(componente);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Carpeta: " + nombre);
        for (ComponenteArchivo componente : componentes) {
            componente.mostrarDetalles();
        }
    }
}
```


## Uso del patrón Composite
Ahora podemos crear archivos y carpetas, y combinar estas estructuras en un árbol jerárquico.

```
public class Main {
    public static void main(String[] args) {
        // Crear archivos individuales
        Archivo archivo1 = new Archivo("foto1.jpg", 500);
        Archivo archivo2 = new Archivo("documento.pdf", 1200);
        Archivo archivo3 = new Archivo("video.mp4", 3000);

        // Crear una carpeta y agregar archivos
        Carpeta carpetaFotos = new Carpeta("Fotos");
        carpetaFotos.agregar(archivo1);

        Carpeta carpetaDocumentos = new Carpeta("Documentos");
        carpetaDocumentos.agregar(archivo2);

        // Crear una carpeta raíz y agregar otras carpetas y archivos
        Carpeta carpetaPrincipal = new Carpeta("Carpeta Principal");
        carpetaPrincipal.agregar(carpetaFotos);
        carpetaPrincipal.agregar(carpetaDocumentos);
        carpetaPrincipal.agregar(archivo3);

        // Mostrar detalles de la estructura
        carpetaPrincipal.mostrarDetalles();
    }
}

```

## salida
```
Carpeta: Carpeta Principal
Carpeta: Fotos
Archivo: foto1.jpg (500 KB)
Carpeta: Documentos
Archivo: documento.pdf (1200 KB)
Archivo: video.mp4 (3000 KB)
```

## Resumen
En este ejemplo, el patrón Composite permite tratar archivos individuales y carpetas de la misma manera. La clase Carpeta contiene una lista de ComponenteArchivo, lo cual le permite agregar tanto Archivo como otras Carpeta. Al invocar el método mostrarDetalles en Carpeta, se recorre toda la estructura jerárquica, mostrando los detalles de cada archivo y subcarpeta.

Gracias al patrón Composite, el cliente puede manejar tanto archivos individuales como estructuras de carpetas compuestas de forma uniforme y escalable.