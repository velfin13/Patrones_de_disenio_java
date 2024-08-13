package me.velfinvelasquez.problema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
