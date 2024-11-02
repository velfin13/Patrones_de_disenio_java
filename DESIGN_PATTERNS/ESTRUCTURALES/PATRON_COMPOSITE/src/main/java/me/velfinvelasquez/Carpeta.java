package me.velfinvelasquez;

// Clase compuesta: Carpeta
import java.util.ArrayList;
import java.util.List;

public class Carpeta implements ComponenteArchivo {
    private String nombre;
    private List<ComponenteArchivo> componentes = new ArrayList<>();

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ComponenteArchivo componente) {
        componentes.add(componente);
    }

    public void eliminar(ComponenteArchivo componente) {
        componentes.remove(componente);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Carpeta: " + nombre);
        for (ComponenteArchivo componente : componentes) {
            componente.mostrarDetalles();
        }
    }
}
