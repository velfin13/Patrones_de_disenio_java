
# Single Responsibility Principle, SRP

**El Principio de Responsabilidad Única** es uno de los principios fundamentales en la programación orientada a objetos, y establece que una clase debe tener una única razón para cambiar, es decir, debe tener una única responsabilidad o propósito.



## Ejemplo: Gestión de Reportes
Imaginemos que estamos desarrollando un sistema que genera reportes. A continuación, se muestra una clase que viola el **SRP** y luego cómo refactorizarla para cumplir con el principio.

## Ejemplo que viola SRP:

```
public class ReportManager {
    private String reportContent;

    public ReportManager(String reportContent) {
        this.reportContent = reportContent;
    }

    // Método para formatear el reporte
    public String formatReport() {
        return "Formatted Report: " + reportContent;
    }

    // Método para imprimir el reporte
    public void printReport() {
        System.out.println(formatReport());
    }

    // Método para guardar el reporte en un archivo
    public void saveReportToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(formatReport());
        writer.close();
    }
}

```

## Explicación:

* **formatReport():** Se encarga de formatear el reporte.
* **printReport():** Imprime el reporte.
* **saveReportToFile():** Guarda el reporte en un archivo.

## Problema:
Esta clase ReportManager tiene múltiples responsabilidades:

* Formatear el reporte.
* Imprimir el reporte.
* Guardar el reporte en un archivo.

Esto viola el **SRP**, ya que la clase tiene más de una razón para cambiar. Por ejemplo, si cambia la forma en que se imprime el reporte, se tendrá que modificar esta clase; lo mismo ocurre si cambia la manera de guardar el archivo.

Ejemplo que cumple el **SRP**:

```
// Clase responsable de manejar el contenido del reporte
public class Report {
    private String content;

    public Report(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Clase responsable de formatear el reporte
public class ReportFormatter {
    public String format(Report report) {
        return "Formatted Report: " + report.getContent();
    }
}

// Clase responsable de imprimir el reporte
public class ReportPrinter {
    public void print(String formattedReport) {
        System.out.println(formattedReport);
    }
}

// Clase responsable de guardar el reporte en un archivo
public class ReportSaver {
    public void saveToFile(String filename, String formattedReport) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(formattedReport);
        writer.close();
    }
}

```

## Explicación:

* **Report:** Maneja el contenido del reporte. Su única responsabilidad es almacenar y proporcionar el contenido del reporte.
* **ReportFormatter:** Es responsable de formatear el reporte.
* **ReportPrinter:** Es responsable de imprimir el reporte.
* **ReportSaver:** Es responsable de guardar el reporte en un archivo.

## Ventajas:

* **Cambio aislado:** Si necesitas cambiar la forma de formatear el reporte, solo necesitas modificar la clase ReportFormatter. Las clases ReportPrinter y ReportSaver no se verán afectadas.
* **Reutilización:** Cada clase es más reusable en diferentes contextos. Por ejemplo, podrías usar ReportSaver para guardar cualquier reporte formateado, no solo los reportes manejados por la clase Report.

## Resumen
El *SRP* nos guía a diseñar clases que tienen una única responsabilidad, lo que facilita el mantenimiento, prueba y reutilización del código. Al seguir este principio, minimizamos el impacto de los cambios en el sistema y mejoramos la organización del código.