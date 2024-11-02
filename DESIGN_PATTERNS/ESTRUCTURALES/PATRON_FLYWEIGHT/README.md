
# Patrón Flyweight

Es un patrón estructural que se utiliza para reducir el uso de memoria al compartir la mayor cantidad de datos posible con objetos similares. Este patrón es útil en aplicaciones que crean una gran cantidad de objetos, ya que evita duplicaciones innecesarias al compartir ciertos estados entre ellos.

## Ventajas del patrón flyweight

* **Ahorro de memoria**: Reduce significativamente el consumo de memoria al compartir objetos y minimizar la duplicación de datos.

* **Mayor rendimiento**: Reduce la carga del sistema al evitar la creación de objetos redundantes.

* **Eficiencia**: Es ideal para aplicaciones que requieren un gran número de objetos con datos repetidos.

## Ejemplo práctico
Supongamos que tenemos un juego de bosque en el que creamos millones de árboles. Cada árbol tiene atributos como tipo, color, y textura (que son iguales para los árboles de la misma especie), y una posición específica en el bosque. Usaremos el patrón Flyweight para compartir los atributos comunes entre los árboles de la misma especie.

Primero, creamos la clase ArbolTipo, que contiene los atributos compartidos entre árboles del mismo tipo, como especie y color. Esta clase representa el estado intrínseco que será compartido.

```
// Flyweight: Atributos compartidos entre árboles del mismo tipo
public class ArbolTipo {
    private String especie;
    private String color;
    private String textura;

    public ArbolTipo(String especie, String color, String textura) {
        this.especie = especie;
        this.color = color;
        this.textura = textura;
    }

    public void mostrarDetalles(int x, int y) {
        System.out.println("Árbol de tipo: " + especie + " en posición (" + x + ", " + y + ")");
    }
}

```
Luego, creamos la clase Arbol, que representa un árbol específico en el bosque con su posición. Cada árbol tiene una referencia a un ArbolTipo, que es compartido entre árboles del mismo tipo.

```
// Clase Arbol: Representa el estado extrínseco específico
public class Arbol {
    private int x;
    private int y;
    private ArbolTipo tipo;

    public Arbol(int x, int y, ArbolTipo tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }

    public void mostrar() {
        tipo.mostrarDetalles(x, y);
    }
}

```
Para manejar y reutilizar instancias de ArbolTipo, creamos una fábrica ArbolFactory. Esta clase se encarga de gestionar y devolver instancias compartidas de ArbolTipo según sea necesario.

```
// Flyweight Factory: Gestiona y reutiliza los objetos ArbolTipo
import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private static Map<String, ArbolTipo> tipos = new HashMap<>();

    public static ArbolTipo obtenerTipoArbol(String especie, String color, String textura) {
        String clave = especie + "-" + color + "-" + textura;
        tipos.putIfAbsent(clave, new ArbolTipo(especie, color, textura));
        return tipos.get(clave);
    }
}

```


## Uso del patrón Flyweight
Ahora podemos crear muchos árboles en el bosque usando el patrón Flyweight para compartir atributos comunes entre árboles del mismo tipo.

```
public class Main {
    public static void main(String[] args) {
        // Crear árboles reutilizando ArbolTipo a través de la fábrica
        ArbolTipo pinoTipo = ArbolFactory.obtenerTipoArbol("Pino", "Verde", "TexturaPino");
        ArbolTipo robleTipo = ArbolFactory.obtenerTipoArbol("Roble", "Marrón", "TexturaRoble");

        Arbol arbol1 = new Arbol(10, 20, pinoTipo);
        Arbol arbol2 = new Arbol(30, 40, pinoTipo);
        Arbol arbol3 = new Arbol(50, 60, robleTipo);

        arbol1.mostrar();
        arbol2.mostrar();
        arbol3.mostrar();
    }
}


```

## salida
```
Árbol de tipo: Pino en posición (10, 20)
Árbol de tipo: Pino en posición (30, 40)
Árbol de tipo: Roble en posición (50, 60)

```

## Resumen
En este ejemplo, el patrón Flyweight permite que múltiples instancias de Arbol compartan la misma instancia de ArbolTipo para ahorrar memoria. La clase ArbolFactory administra la creación de los objetos ArbolTipo, reutilizando las instancias cuando se solicitan árboles del mismo tipo (mismo especie, color y textura).

Este enfoque permite que cientos o miles de árboles puedan compartan su "tipo" (color, especie, textura), manteniendo solo la información necesaria de la posición específica (x, y) en cada instancia individual de Arbol.