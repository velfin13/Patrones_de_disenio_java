package me.velfinvelasquez.solucion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportSaver {

    public void saveToFile(String filename, String formattedReport) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(formattedReport);
        writer.close();
    }
}
