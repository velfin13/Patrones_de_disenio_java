package me.velfinvelasquez;

// Flyweight: Atributos compartidos entre árboles del mismo tipo
public class ArbolTipo {
    private String especie;
    private String color;
    private String textura;

    public ArbolTipo(String especie, String color, String textura) {
        this.especie = especie;
        this.color = color;
        this.textura = textura;
    }

    public void mostrarDetalles(int x, int y) {
        System.out.println("Árbol de tipo: " + especie + " en posición (" + x + ", " + y + ")");
    }
}

