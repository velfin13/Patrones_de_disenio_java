package me.velfinvelasquez.problema;

import me.velfinvelasquez.models.Document;

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