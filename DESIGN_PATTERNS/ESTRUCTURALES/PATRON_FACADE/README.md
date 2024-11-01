
# Patrón Facade

Es un patrón estructural que proporciona una interfaz simplificada y unificada para un conjunto de interfaces en un subsistema. Básicamente, el patrón Facade actúa como un intermediario que oculta la complejidad de un sistema, proporcionando una interfaz más sencilla para que otros componentes o sistemas puedan interactuar con él sin necesidad de conocer todos sus detalles internos.

## Ventajas del patrón Facade

* **Simplificación**: Reduce la complejidad de la interacción con el sistema al ofrecer una interfaz simplificada y más amigable.

* **Desacoplamiento**: El cliente no necesita saber cómo funcionan las clases internas del sistema, ya que interactúa solo a través de la fachada.

* **Mantenimiento**: Facilita el mantenimiento del código, ya que los cambios en el sistema interno no afectan directamente a los clientes siempre que la fachada permanezca igual.

* **Compatibilidad**: Permite hacer cambios en el subsistema sin modificar el código del cliente.


## Ejemplo práctico
Imaginemos un sistema de gestión de entretenimiento en el hogar que involucra varios subsistemas: TV, ConsolaDeVideojuegos, y SistemaDeSonido. Encender el sistema de entretenimiento requiere varios pasos: encender la TV, cambiar el canal, encender el sistema de sonido, y encender la consola de videojuegos. Utilizando el patrón Facade, podemos simplificar todo este proceso para el usuario.

Primero, definimos cada subsistema con sus métodos específicos:

```
// Subsistema: TV
public class TV {
    public void encender() {
        System.out.println("TV encendida");
    }
    
    public void cambiarCanal(int canal) {
        System.out.println("TV cambiada al canal " + canal);
    }
}

// Subsistema: Consola de Videojuegos
public class ConsolaDeVideojuegos {
    public void encender() {
        System.out.println("Consola de videojuegos encendida");
    }

    public void iniciarJuego(String juego) {
        System.out.println("Iniciando el juego: " + juego);
    }
}

// Subsistema: Sistema de Sonido
public class SistemaDeSonido {
    public void encender() {
        System.out.println("Sistema de sonido encendido");
    }

    public void ajustarVolumen(int nivel) {
        System.out.println("Volumen ajustado a " + nivel);
    }
}

```

Luego, creamos la clase FachadaEntretenimiento, que servirá como la fachada para coordinar estos subsistemas y proporcionar una interfaz sencilla al cliente.

```
// Clase Facade
public class FachadaEntretenimiento {
    private TV tv;
    private ConsolaDeVideojuegos consola;
    private SistemaDeSonido sonido;

    public FachadaEntretenimiento(TV tv, ConsolaDeVideojuegos consola, SistemaDeSonido sonido) {
        this.tv = tv;
        this.consola = consola;
        this.sonido = sonido;
    }

    // Método simplificado para encender todo el sistema de entretenimiento
    public void iniciarEntretenimiento(String juego, int canal, int volumen) {
        tv.encender();
        tv.cambiarCanal(canal);
        
        sonido.encender();
        sonido.ajustarVolumen(volumen);
        
        consola.encender();
        consola.iniciarJuego(juego);
        
        System.out.println("Sistema de entretenimiento listo para jugar.");
    }
}



## Uso del patrón Facade
Ahora, el cliente puede encender todo el sistema de entretenimiento usando solo un método en la clase FachadaEntretenimiento.

```
public class Main {
    public static void main(String[] args) {
        // Creación de los componentes del sistema
        TV tv = new TV();
        ConsolaDeVideojuegos consola = new ConsolaDeVideojuegos();
        SistemaDeSonido sonido = new SistemaDeSonido();

        // Creación de la fachada de entretenimiento
        FachadaEntretenimiento entretenimiento = new FachadaEntretenimiento(tv, consola, sonido);

        // Usando la fachada para iniciar el sistema de entretenimiento
        entretenimiento.iniciarEntretenimiento("Super Mario", 7, 15);
    }
}

```

## salida
```
TV encendida
TV cambiada al canal 7
Sistema de sonido encendido
Volumen ajustado a 15
Consola de videojuegos encendida
Iniciando el juego: Super Mario
Sistema de entretenimiento listo para jugar.


```

## Resumen
En este ejemplo, hemos creado la clase FachadaEntretenimiento, que actúa como una fachada que coordina los subsistemas TV, ConsolaDeVideojuegos, y SistemaDeSonido. En lugar de tener que controlar cada componente del sistema por separado, el cliente simplemente llama al método iniciarEntretenimiento, y la fachada se encarga de encender cada subsistema y de realizar la configuración necesaria.

El patrón Facade permite que el cliente interactúe con un sistema complejo a través de una interfaz simplificada, ocultando la lógica interna de los subsistemas y proporcionando una mejor experiencia de uso.