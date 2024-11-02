package me.velfinvelasquez;

// Clase hoja: Archivo individual
public class Archivo implements ComponenteArchivo {
    private String nombre;
    private int tamaño; // en KB

    public Archivo(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Archivo: " + nombre + " (" + tamaño + " KB)");
    }
}
