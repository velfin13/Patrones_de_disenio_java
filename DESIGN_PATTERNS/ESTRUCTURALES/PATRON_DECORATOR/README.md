
# Patrón Decorator

Es un patrón estructural que permite añadir funcionalidades adicionales a un objeto de forma dinámica, sin modificar su estructura original. Este patrón es útil cuando necesitamos agregar funcionalidades a objetos individuales en lugar de a toda una clase, manteniendo la flexibilidad de aplicar o remover las decoraciones en tiempo de ejecución.

## Ventajas del patrón Decorator

* **Flexibilidad y extensibilidad:** Permite añadir y combinar comportamientos de manera dinámica sin necesidad de modificar las clases base.
* **Simplicidad en la modificación de funcionalidades:** Puedes añadir, quitar o combinar funcionalidades específicas sin afectar el código existente.

* **Cumplimiento del principio de abierto/cerrado:** Las clases están abiertas para extensión, pero cerradas para modificación, lo que mejora la mantenibilidad.
* **Uso de múltiples decoradores:** Es posible aplicar varios decoradores a un objeto para crear combinaciones únicas de comportamientos.

## Ejemplo práctico
Supongamos que estamos creando una aplicación de café, y cada tipo de café tiene un costo. Queremos aplicar decoradores para añadir complementos como leche, azúcar, o canela, sin tener que modificar la clase de café original.

Primero, definimos la interfaz Café, que será la base para nuestras clases concretas y decoradores.

```
// Interfaz base
public interface Cafe {
    double getCosto(); // Devuelve el costo
    String getIngredientes(); // Devuelve los ingredientes
}
```

Luego, creamos una clase concreta que implementa esta interfaz. Esta es la base de nuestro café.

```
// Clase concreta de café
public class CafeSimple implements Cafe {
    @Override
    public double getCosto() {
        return 5.0; // Precio base del café
    }

    @Override
    public String getIngredientes() {
        return "Café";
    }
}

```

Ahora, creamos un decorador abstracto que también implementa la interfaz Café y toma un Café en su constructor. Esto nos permite añadir comportamientos específicos a las subclases.

```
// Decorador abstracto
public abstract class CafeDecorador implements Cafe {
    protected Cafe cafeDecorado;

    public CafeDecorador(Cafe cafeDecorado) {
        this.cafeDecorado = cafeDecorado;
    }

    @Override
    public double getCosto() {
        return cafeDecorado.getCosto();
    }

    @Override
    public String getIngredientes() {
        return cafeDecorado.getIngredientes();
    }
}

```
Finalmente, creamos algunos decoradores concretos, como ConLeche y ConCanela, que añaden funcionalidad al objeto Café.

```
// Decorador concreto que añade leche
public class ConLeche extends CafeDecorador {
    public ConLeche(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 1.5; // Añade el costo de la leche
    }

    @Override
    public String getIngredientes() {
        return super.getIngredientes() + ", Leche";
    }
}

// Decorador concreto que añade canela
public class ConCanela extends CafeDecorador {
    public ConCanela(Cafe cafeDecorado) {
        super(cafeDecorado);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 0.5; // Añade el costo de la canela
    }

    @Override
    public String getIngredientes() {
        return super.getIngredientes() + ", Canela";
    }
}

```

## Uso del patrón Decorator
Ahora podemos crear un café básico y añadirle decoradores de manera dinámica para agregar características adicionales.

```
public class Main {
    public static void main(String[] args) {
        Cafe cafe = new CafeSimple(); // Café simple
        System.out.println("Costo: " + cafe.getCosto());
        System.out.println("Ingredientes: " + cafe.getIngredientes());

        // Añadimos leche
        cafe = new ConLeche(cafe);
        System.out.println("Costo con leche: " + cafe.getCosto());
        System.out.println("Ingredientes con leche: " + cafe.getIngredientes());

        // Añadimos canela
        cafe = new ConCanela(cafe);
        System.out.println("Costo con leche y canela: " + cafe.getCosto());
        System.out.println("Ingredientes con leche y canela: " + cafe.getIngredientes());
    }
}

```

## salida
```
Costo: 5.0
Ingredientes: Café
Costo con leche: 6.5
Ingredientes con leche: Café, Leche
Costo con leche y canela: 7.0
Ingredientes con leche y canela: Café, Leche, Canela

```

## Resumen
Aquí hemos creado un objeto CafeSimple y luego, de forma dinámica, le hemos agregado decoradores ConLeche y ConCanela para incrementar su costo y cambiar la descripción de sus ingredientes. Esto permite construir una combinación de cafés con diferentes características sin alterar la clase base CafeSimple.