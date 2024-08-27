package me.velfinvelasquez;

import me.velfinvelasquez.models.Room;

public class Main {
    public static void main(String[] args) {
        // Crear una habitación base con configuración predeterminada
        Room baseRoom = new Room("Sofa, Coffee Table", "Modern Art", "Light Blue");

        // Clonar la habitación base y personalizarla para una configuración específica
        Room livingRoom = baseRoom.clone();
        livingRoom.setFurniture("Luxury Sofa, Glass Table");
        livingRoom.setColorScheme("Beige");

        Room office = baseRoom.clone();
        office.setFurniture("Desk, Ergonomic Chair");
        office.setDecoration("Inspirational Posters");
        office.setColorScheme("White");

        // Mostrar las configuraciones de las habitaciones
        System.out.println("Base Room: " + baseRoom);
        System.out.println("Living Room: " + livingRoom);
        System.out.println("Office: " + office);
    }
}