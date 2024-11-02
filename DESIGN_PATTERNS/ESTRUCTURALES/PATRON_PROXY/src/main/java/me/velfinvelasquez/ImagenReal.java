package me.velfinvelasquez;

// Objeto real: Imagen completa que simula la carga desde un archivo
public class ImagenReal implements Imagen {
    private String nombreArchivo;

    public ImagenReal(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        cargarDesdeDisco();
    }

    private void cargarDesdeDisco() {
        System.out.println("Cargando " + nombreArchivo);
    }

    @Override
    public void mostrar() {
        System.out.println("Mostrando " + nombreArchivo);
    }
}
