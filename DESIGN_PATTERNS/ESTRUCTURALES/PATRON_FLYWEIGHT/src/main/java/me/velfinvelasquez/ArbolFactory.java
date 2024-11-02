package me.velfinvelasquez;

// Flyweight Factory: Gestiona y reutiliza los objetos ArbolTipo
import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private static Map<String, ArbolTipo> tipos = new HashMap<>();

    public static ArbolTipo obtenerTipoArbol(String especie, String color, String textura) {
        String clave = especie + "-" + color + "-" + textura;
        tipos.putIfAbsent(clave, new ArbolTipo(especie, color, textura));
        return tipos.get(clave);
    }
}

