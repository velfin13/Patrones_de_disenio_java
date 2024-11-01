package me.velfinvelasquez;

import me.velfinvelasquez.service.Cafe.Cafe;
import me.velfinvelasquez.service.Cafe.CafeSimple;
import me.velfinvelasquez.service.Cafe.ConCanela;
import me.velfinvelasquez.service.Cafe.ConLeche;

public class Main {
     public static void main(String[] args) {
        Cafe cafe = new CafeSimple(); // Café simple
        System.out.println("Costo: " + cafe.getCosto());
        System.out.println("Ingredientes: " + cafe.getIngredientes());

        // Añadimos leche
        cafe = new ConLeche(cafe);
        System.out.println("Costo con leche: " + cafe.getCosto());
        System.out.println("Ingredientes con leche: " + cafe.getIngredientes());

        // Añadimos canela
        cafe = new ConCanela(cafe);
        System.out.println("Costo con leche y canela: " + cafe.getCosto());
        System.out.println("Ingredientes con leche y canela: " + cafe.getIngredientes());
    }
}