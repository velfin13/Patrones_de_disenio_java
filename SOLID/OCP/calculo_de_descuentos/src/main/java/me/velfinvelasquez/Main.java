package me.velfinvelasquez;

import me.velfinvelasquez.models.Product;
import me.velfinvelasquez.solucion.*;

public class Main {
    public static void main(String[] args) {
        System.out.printf("El Principio Abierto/Cerrado \n \n");

        // Crear algunos productos
        Product laptop = new Product("Laptop", "ELECTRONICS", 1000.00);
        Product jeans = new Product("Jeans", "CLOTHING", 50.00);
        Product apple = new Product("Apple", "GROCERIES", 2.00);

        // Crear las políticas de descuento
        DiscountPolicy electronicsDiscount = new ElectronicsDiscount();
        DiscountPolicy clothingDiscount = new ClothingDiscount();
        DiscountPolicy groceriesDiscount = new GroceriesDiscount();

        // Calcular y mostrar los descuentos para cada producto
        DiscountCalculator electronicsCalculator = new DiscountCalculator(electronicsDiscount);
        DiscountCalculator clothingCalculator = new DiscountCalculator(clothingDiscount);
        DiscountCalculator groceriesCalculator = new DiscountCalculator(groceriesDiscount);

        System.out.println("Discount on Laptop: $" + electronicsCalculator.calculateDiscount(laptop));
        System.out.println("Discount on Jeans: $" + clothingCalculator.calculateDiscount(jeans));
        System.out.println("Discount on Apple: $" + groceriesCalculator.calculateDiscount(apple));

    }
}