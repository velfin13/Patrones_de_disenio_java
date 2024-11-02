package me.velfinvelasquez;

public class Main {
    public static void main(String[] args) {
        // Crear archivos individuales
        Archivo archivo1 = new Archivo("foto1.jpg", 500);
        Archivo archivo2 = new Archivo("documento.pdf", 1200);
        Archivo archivo3 = new Archivo("video.mp4", 3000);

        // Crear una carpeta y agregar archivos
        Carpeta carpetaFotos = new Carpeta("Fotos");
        carpetaFotos.agregar(archivo1);

        Carpeta carpetaDocumentos = new Carpeta("Documentos");
        carpetaDocumentos.agregar(archivo2);

        // Crear una carpeta raíz y agregar otras carpetas y archivos
        Carpeta carpetaPrincipal = new Carpeta("Carpeta Principal");
        carpetaPrincipal.agregar(carpetaFotos);
        carpetaPrincipal.agregar(carpetaDocumentos);
        carpetaPrincipal.agregar(archivo3);

        // Mostrar detalles de la estructura
        carpetaPrincipal.mostrarDetalles();
    }
}