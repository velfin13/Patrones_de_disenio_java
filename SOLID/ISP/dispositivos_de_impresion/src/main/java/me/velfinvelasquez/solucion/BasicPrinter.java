package me.velfinvelasquez.solucion;

import me.velfinvelasquez.models.Document;

// Implementación de impresora básica
public class BasicPrinter implements Printer {
    @Override
    public void print(Document document) {
        System.out.println("Printing document...");
    }
}