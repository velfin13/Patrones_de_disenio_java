package me.velfinvelasquez.problema;

import me.velfinvelasquez.models.Document;

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