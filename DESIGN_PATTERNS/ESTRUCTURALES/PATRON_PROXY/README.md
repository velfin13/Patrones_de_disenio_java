
# Patrón Proxy

Es un patrón estructural que permite controlar el acceso a un objeto mediante otro objeto intermediario. El proxy actúa como un sustituto o representante del objeto real, permitiendo al cliente interactuar con el proxy en lugar del objeto real directamente. Esto es útil para realizar acciones adicionales, como control de acceso, carga diferida (lazy loading), o registro de operaciones, sin modificar la funcionalidad del objeto real.

## Ventajas del patrón proxy

* **Control de acceso**: Permite restringir o controlar el acceso al objeto real.

* **Carga diferida**: Puede posponer la creación o el procesamiento del objeto real hasta que sea necesario.

* **Optimización del rendimiento**: Útil para objetos que consumen muchos recursos, reduciendo su uso hasta que sea necesario.
* **Seguridad:** Puede restringir el acceso o aplicar autenticación al interactuar con el objeto real.

## Tipos de Proxy
* **Proxy remoto:** Representa un objeto que reside en una ubicación remota.
* **Proxy virtual:** Controla el acceso a recursos que consumen mucho tiempo o recursos, como cargar archivos o inicializar datos pesados.
* **Proxy de protección**: Limita el acceso a recursos con base en permisos de usuario.

## Ejemplo práctico
Supongamos que tenemos un sistema de visualización de imágenes que carga imágenes grandes de un servidor externo. No queremos cargar la imagen real hasta que se necesite. Utilizaremos un proxy que simule la carga diferida de la imagen.

Primero, creamos la interfaz Imagen, que define el método para mostrar una imagen.

```
// Interfaz de la imagen
public interface Imagen {
    void mostrar();
}

```
A continuación, implementamos la clase ImagenReal, que representa la imagen completa y realiza la carga de la imagen desde un archivo.

```
// Objeto real: Imagen completa que simula la carga desde un archivo
public class ImagenReal implements Imagen {
    private String nombreArchivo;

    public ImagenReal(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        cargarDesdeDisco();
    }

    private void cargarDesdeDisco() {
        System.out.println("Cargando " + nombreArchivo);
    }

    @Override
    public void mostrar() {
        System.out.println("Mostrando " + nombreArchivo);
    }
}


```
Ahora creamos la clase ImagenProxy, que implementa la interfaz Imagen y actúa como intermediario para ImagenReal. La imagen se cargará realmente solo cuando se llame al método mostrar() por primera vez.

```
// Proxy: controla el acceso a ImagenReal con carga diferida
public class ImagenProxy implements Imagen {
    private String nombreArchivo;
    private ImagenReal imagenReal;

    public ImagenProxy(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void mostrar() {
        if (imagenReal == null) {
            imagenReal = new ImagenReal(nombreArchivo); // Carga la imagen real solo cuando se necesita
        }
        imagenReal.mostrar();
    }
}

```


## Uso del patrón Proxy
Ahora podemos crear una imagen proxy en lugar de la imagen real. Esto permite diferir la carga de la imagen hasta que sea realmente necesario.

```
public class Main {
    public static void main(String[] args) {
        Imagen imagen = new ImagenProxy("foto_de_vacaciones.jpg");

        // La imagen se cargará en memoria solo cuando se necesite mostrar
        System.out.println("La imagen aún no se ha cargado...");
        imagen.mostrar(); // La imagen se carga y se muestra aquí
        System.out.println("La imagen ya está cargada.");
        
        // Volver a llamar a mostrar no recarga la imagen
        imagen.mostrar();
    }
}


```

## salida
```
La imagen aún no se ha cargado...
Cargando foto_de_vacaciones.jpg
Mostrando foto_de_vacaciones.jpg
La imagen ya está cargada.
Mostrando foto_de_vacaciones.jpg

```

## Resumen
En este ejemplo, el patrón Proxy permite controlar el acceso a la imagen real mediante ImagenProxy. La imagen solo se carga desde el disco cuando se llama al método mostrar() por primera vez. Esto permite ahorrar memoria y mejorar el rendimiento, especialmente en escenarios donde el objeto es costoso de crear y es posible que no siempre se necesite.

El proxy aquí actúa como un intermediario que decide cuándo es necesario crear la instancia de ImagenReal, aplicando el principio de "carga diferida" (lazy loading).