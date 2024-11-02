package me.velfinvelasquez;

// Clase Arbol: Representa el estado extrínseco específico
public class Arbol {
    private int x;
    private int y;
    private ArbolTipo tipo;

    public Arbol(int x, int y, ArbolTipo tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }

    public void mostrar() {
        tipo.mostrarDetalles(x, y);
    }
}

