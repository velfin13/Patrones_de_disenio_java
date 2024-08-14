
# Liskov Substitution Principle, LSP

**El Principio de Sustitución de Liskov** (Liskov Substitution Principle, LSP) establece que los objetos de una clase derivada deben ser reemplazables por objetos de la clase base sin alterar el correcto funcionamiento del programa. Esto significa que una subclase debe ser capaz de sustituir a su superclase sin que el comportamiento esperado del sistema cambie.

## Ejemplo: Gestión de Vehículos
Imaginemos que tenemos una jerarquía de clases para manejar vehículos, y queremos asegurar que cualquier subclase de **Vehicle** pueda sustituir a **Vehicle** sin problemas.

## Ejemplo que viola el LSP:

```
class Vehicle {
    public void startEngine() {
        System.out.println("Engine started.");
    }
}

class Car extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }
}

class Bicycle extends Vehicle {
    @Override
    public void startEngine() {
        throw new UnsupportedOperationException("Bicycles don't have engines.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.startEngine(); // Funciona correctamente

        Vehicle myBike = new Bicycle();
        myBike.startEngine(); // Lanza una excepción
    }
}
```

## Problema:

* En este ejemplo, la clase **Bicycle** viola el principio **LSP** porque no puede sustituir a **Vehicle** sin alterar el comportamiento esperado del sistema. 
* Intentar iniciar el motor de una bicicleta lanza una excepción, lo que no es un comportamiento que esperarías de un **Vehicle**.

## Ejemplo que Cumple el LSP:
Para cumplir con el **LSP**, podemos hacer que **Vehicle** y **Bicycle** compartan una interfaz común sin forzar a **Bicycle** a tener un motor.

```
// Interfaz para vehículos con motor
interface EnginePoweredVehicle {
    void startEngine();
}

// Clase para vehículos en general
class Vehicle {
    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Clase para autos, que son vehículos con motor
class Car extends Vehicle implements EnginePoweredVehicle {
    public Car(String name) {
        super(name);
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }
}

// Clase para bicicletas, que no tienen motor
class Bicycle extends Vehicle {
    public Bicycle(String name) {
        super(name);
    }

    // Bicicletas no implementan startEngine porque no tienen motor
}

public class Main {
    public static void main(String[] args) {
        // Crear una lista de vehículos con motor
        List<EnginePoweredVehicle> enginePoweredVehicles = new ArrayList<>();
        enginePoweredVehicles.add(new Car("Toyota"));

        for (EnginePoweredVehicle vehicle : enginePoweredVehicles) {
            vehicle.startEngine(); // Funciona sin problemas
        }

        // Crear una lista de vehículos en general
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Honda"));
        vehicles.add(new Bicycle("Mountain Bike"));

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getName());
            // Aquí no se intenta iniciar el motor, porque no todos los vehículos tienen motor
        }
    }
}
```

## Explicación del Código:

* **EnginePoweredVehicle**: Es una interfaz para los vehículos que tienen motor. Solo los vehículos con motor deben implementar este método.
* **Vehicle**: Es una clase base general que no asume que todos los vehículos tienen motor.
* **Car**: Extiende **Vehicle** y también implementa **EnginePoweredVehicle**, lo que significa que puede arrancar un motor.
* **Bicycle**: Extiende **Vehicle**, pero no implementa **EnginePoweredVehicle** porque las bicicletas no tienen motor.

## Ejecución del main:
* Se pueden manejar vehículos en listas genéricas sin asumir que todos tienen motor.
* No hay problemas de comportamiento o excepciones inesperadas cuando se trabaja con las subclases.

## Resumen
El Principio de Sustitución de Liskov asegura que las subclases puedan reemplazar a las clases base sin afectar el comportamiento del sistema. Esto se logra diseñando clases y jerarquías que no violen las expectativas sobre el comportamiento de las clases base, lo que lleva a un código más robusto y flexible.