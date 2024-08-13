package me.velfinvelasquez.problema;

import me.velfinvelasquez.models.Product;

public class DiscountCalculator {
    public double calculateDiscount(Product product) {
        double discount = 0.0;

        if (product.getType().equals("ELECTRONICS")) {
            discount = product.getPrice() * 0.10;  // 10% de descuento
        } else if (product.getType().equals("CLOTHING")) {
            discount = product.getPrice() * 0.20;  // 20% de descuento
        } else if (product.getType().equals("GROCERIES")) {
            discount = product.getPrice() * 0.05;  // 5% de descuento
        }

        return discount;
    }
}