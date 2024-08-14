
# Interface Segregation Principle, ISP

**El Principio de Segregación de Interfaces** (Interface Segregation Principle, ISP) establece que una clase no debería estar obligada a implementar interfaces que no utiliza. En lugar de tener una única interfaz grande que incluya muchos métodos, es mejor dividirla en interfaces más pequeñas y específicas. Esto asegura que las clases solo dependen de los métodos que realmente necesitan.

## Ejemplo: Dispositivos de Impresión
Imaginemos un sistema que maneja diferentes tipos de dispositivos de impresión: impresoras básicas y multifuncionales. Queremos asegurarnos de que cada tipo de dispositivo solo implemente las funcionalidades que realmente necesita.

## Ejemplo que viola el ISP:

```
// Interfaz con demasiadas responsabilidades
interface Printer {
    void print(Document document);
    void scan(Document document);
    void fax(Document document);
}

// Clase que implementa todas las funcionalidades (multifuncional)
class MultiFunctionPrinter implements Printer {
    @Override
    public void print(Document document) {
        System.out.println("Printing document...");
    }

    @Override
    public void scan(Document document) {
        System.out.println("Scanning document...");
    }

    @Override
    public void fax(Document document) {
        System.out.println("Faxing document...");
    }
}

// Clase que implementa solo algunas funcionalidades (impresora básica)
class BasicPrinter implements Printer {
    @Override
    public void print(Document document) {
        System.out.println("Printing document...");
    }

    @Override
    public void scan(Document document) {
        // La impresora básica no escanea, pero se ve obligada a implementar este método
        throw new UnsupportedOperationException("Scan not supported");
    }

    @Override
    public void fax(Document document) {
        // La impresora básica no envía faxes, pero se ve obligada a implementar este método
        throw new UnsupportedOperationException("Fax not supported");
    }
}
```

## Problema:

La interfaz **Printer** obliga a la clase **BasicPrinter** a implementar métodos (scan y fax) que no usa. Esto viola el **ISP**, ya que la clase depende de métodos que no necesita.

## Ejemplo que sigue el ISP:
Para cumplir con el **ISP**, podemos dividir la interfaz **Printer** en interfaces más específicas.

```
// Interfaces segregadas

interface Printer {
    void print(Document document);
}

interface Scanner {
    void scan(Document document);
}

interface Fax {
    void fax(Document document);
}

// Implementación de impresora multifuncional
class MultiFunctionPrinter implements Printer, Scanner, Fax {
    @Override
    public void print(Document document) {
        System.out.println("Printing document...");
    }

    @Override
    public void scan(Document document) {
        System.out.println("Scanning document...");
    }

    @Override
    public void fax(Document document) {
        System.out.println("Faxing document...");
    }
}

// Implementación de impresora básica
class BasicPrinter implements Printer {
    @Override
    public void print(Document document) {
        System.out.println("Printing document...");
    }
}

```

## Explicación:

* **Printer**: Es una interfaz específica para imprimir documentos.
* **Scanner**: Es una interfaz específica para escanear documentos.
* **Fax**: Es una interfaz específica para enviar faxes.

## Ventajas:

* **Segregación de Interfaces**: Las clases ahora implementan solo las interfaces que realmente necesitan. La clase **BasicPrinter** solo depende de la interfaz **Printer**, mientras que **MultiFunctionPrinter** depende de las tres interfaces (Printer, Scanner, y Fax).
* **Mantenimiento**: Si se cambia la funcionalidad de escaneo o fax, no afecta a las clases que solo implementan la funcionalidad de impresión.

## Ejecución del main:

```
public class Main {
    public static void main(String[] args) {
        Document doc = new Document("My Document");

        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print(doc);

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print(doc);
        mfp.scan(doc);
        mfp.fax(doc);
    }
}

```

## Explicación del main:
* **Document**: Representa el documento que se va a imprimir, escanear o enviar por fax.
* **BasicPrinter**: Solo imprime, ya que implementa solo la interfaz Printer.
* **MultiFunctionPrinter**: Puede imprimir, escanear y enviar faxes, ya que implementa todas las interfaces.

## Resumen
**El Principio de Segregación de Interfaces** asegura que las clases solo dependen de las interfaces que realmente necesitan. Esto lleva a un diseño más limpio y flexible, donde las clases están menos acopladas y es más fácil modificar o extender funcionalidades sin afectar a otras partes del sistema.