package me.velfinvelasquez;

public class Main {
    public static void main(String[] args) {

        // Creación de los componentes del sistema
        TV tv = new TV();
        ConsolaDeVideojuegos consola = new ConsolaDeVideojuegos();
        SistemaDeSonido sonido = new SistemaDeSonido();

        // Creación de la fachada de entretenimiento
        FachadaEntretenimiento entretenimiento = new FachadaEntretenimiento(tv, consola, sonido);

        // Usando la fachada para iniciar el sistema de entretenimiento
        entretenimiento.iniciarEntretenimiento("Super Mario", 7, 15);
    }
}