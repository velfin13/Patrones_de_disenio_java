package me.velfinvelasquez;

// Proxy: controla el acceso a ImagenReal con carga diferida
public class ImagenProxy implements Imagen {
    private String nombreArchivo;
    private ImagenReal imagenReal;

    public ImagenProxy(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void mostrar() {
        if (imagenReal == null) {
            imagenReal = new ImagenReal(nombreArchivo); // Carga la imagen real solo cuando se necesita
        }
        imagenReal.mostrar();
    }
}
