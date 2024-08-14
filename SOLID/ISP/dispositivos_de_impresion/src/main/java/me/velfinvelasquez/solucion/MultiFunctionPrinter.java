package me.velfinvelasquez.solucion;

import me.velfinvelasquez.models.Document;

// Implementación de impresora multifuncional
public class MultiFunctionPrinter implements Printer, Scanner, Fax {
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