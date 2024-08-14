package me.velfinvelasquez;

import me.velfinvelasquez.models.Document;
import me.velfinvelasquez.solucion.BasicPrinter;
import me.velfinvelasquez.solucion.MultiFunctionPrinter;
import me.velfinvelasquez.solucion.Printer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Interface Segregation Principle, ISP \n \n");

        Document doc = new Document("My Document");

        Printer basicPrinter = new BasicPrinter();
        basicPrinter.print(doc);

        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print(doc);
        mfp.scan(doc);
        mfp.fax(doc);
    }
}