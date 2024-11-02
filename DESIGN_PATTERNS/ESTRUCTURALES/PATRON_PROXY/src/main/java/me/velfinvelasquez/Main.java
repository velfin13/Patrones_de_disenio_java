package me.velfinvelasquez;


public class Main {
    public static void main(String[] args) {
        Imagen imagen = new ImagenProxy("foto_de_vacaciones.jpg");

        // La imagen se cargará en memoria solo cuando se necesite mostrar
        System.out.println("La imagen aún no se ha cargado...");
        imagen.mostrar(); // La imagen se carga y se muestra aquí
        System.out.println("La imagen ya está cargada.");
        
        // Volver a llamar a mostrar no recarga la imagen
        imagen.mostrar();
    }
}