
# Open/Closed Principle, OCP

**El Principio Abierto/Cerrado** (Open/Closed Principle, OCP) es uno de los principios fundamentales en la programación orientada a objetos. Este principio establece que una entidad (clase, módulo, función, etc.) debe estar abierta para la extensión pero cerrada para la modificación. Es decir, deberíamos poder extender el comportamiento de una clase sin tener que modificar su código fuente original.

## Ejemplo: Cálculo de Descuentos
Imaginemos que estamos desarrollando un sistema que aplica diferentes tipos de descuentos a productos.

## Ejemplo que viola el OCP:

```
public class DiscountCalculator {
    public double calculateDiscount(Product product) {
        double discount = 0.0;

        if (product.getType().equals("ELECTRONICS")) {
            discount = product.getPrice() * 0.10;  // 10% de descuento
        } else if (product.getType().equals("CLOTHING")) {
            discount = product.getPrice() * 0.20;  // 20% de descuento
        } else if (product.getType().equals("GROCERIES")) {
            discount = product.getPrice() * 0.05;  // 5% de descuento
        }

        return discount;
    }
}
```

## Explicación:

* Este código calcula el descuento en función del tipo de producto.
* Si se necesita agregar un nuevo tipo de producto, como "LIBROS", tendríamos que modificar esta clase para agregar una nueva condición if.

## Problema:
Este diseño viola el principio **OCP** porque para agregar un nuevo tipo de descuento necesitamos modificar la clase **DiscountCalculator**, lo cual podría introducir errores en el código existente.

Ejemplo que cumple el **OCP**:

```
// Clase abstracta para los descuentos
public abstract class DiscountPolicy {
    public abstract double calculateDiscount(Product product);
}

// Implementaciones concretas de políticas de descuento

public class ElectronicsDiscount extends DiscountPolicy {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.10;  // 10% de descuento
    }
}

public class ClothingDiscount extends DiscountPolicy {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.20;  // 20% de descuento
    }
}

public class GroceriesDiscount extends DiscountPolicy {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.05;  // 5% de descuento
    }
}

// Clase DiscountCalculator que utiliza la política de descuento
public class DiscountCalculator {
    private DiscountPolicy discountPolicy;

    public DiscountCalculator(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public double calculateDiscount(Product product) {
        return discountPolicy.calculateDiscount(product);
    }
}
```

## Explicación:

* **DiscountPolicy:** Es una clase abstracta que define el contrato para las políticas de descuento.
* **ElectronicsDiscount**, **ClothingDiscount**, **GroceriesDiscount**: Son clases concretas que implementan la política de descuento para diferentes tipos de productos.
* **DiscountCalculator**: Utiliza una instancia de DiscountPolicy para calcular el descuento.

## Ventajas:

* **Extensible sin modificar**: Para agregar un nuevo tipo de descuento, como "LIBROS", simplemente creas una nueva clase que extienda **DiscountPolicy** sin necesidad de modificar **DiscountCalculator**.
* **Cumple con OCP**: La clase **DiscountCalculator** está abierta para la extensión (podemos añadir nuevos tipos de descuentos) pero cerrada para la modificación (no necesitamos cambiar su código existente).

## Resumen
**El Principio Abierto/Cerrado** fomenta la creación de sistemas que pueden evolucionar de manera segura y predecible. Nos permite agregar nuevas funcionalidades o comportamientos al sistema sin alterar el código existente, lo que reduce el riesgo de introducir errores y mejora la mantenibilidad.