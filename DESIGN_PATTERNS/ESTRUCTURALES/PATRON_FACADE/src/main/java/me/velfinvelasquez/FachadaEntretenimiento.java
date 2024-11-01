package me.velfinvelasquez;

public class FachadaEntretenimiento {
    private TV tv;
    private ConsolaDeVideojuegos consola;
    private SistemaDeSonido sonido;

    public FachadaEntretenimiento(TV tv, ConsolaDeVideojuegos consola, SistemaDeSonido sonido) {
        this.tv = tv;
        this.consola = consola;
        this.sonido = sonido;
    }

    // Método simplificado para encender todo el sistema de entretenimiento
    public void iniciarEntretenimiento(String juego, int canal, int volumen) {
        tv.encender();
        tv.cambiarCanal(canal);
        
        sonido.encender();
        sonido.ajustarVolumen(volumen);
        
        consola.encender();
        consola.iniciarJuego(juego);
        
        System.out.println("Sistema de entretenimiento listo para jugar.");
    }
}