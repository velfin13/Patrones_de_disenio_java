package me.velfinvelasquez;

public class Main {
    public static void main(String[] args) {

       // Crear árboles reutilizando ArbolTipo a través de la fábrica
       ArbolTipo pinoTipo = ArbolFactory.obtenerTipoArbol("Pino", "Verde", "TexturaPino");
       ArbolTipo robleTipo = ArbolFactory.obtenerTipoArbol("Roble", "Marrón", "TexturaRoble");

       Arbol arbol1 = new Arbol(10, 20, pinoTipo);
       Arbol arbol2 = new Arbol(30, 40, pinoTipo);
       Arbol arbol3 = new Arbol(50, 60, robleTipo);

       arbol1.mostrar();
       arbol2.mostrar();
       arbol3.mostrar();
    }
}