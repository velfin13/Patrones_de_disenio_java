package me.velfinvelasquez.solucion;

// Implementaciones concretas de políticas de descuento

import me.velfinvelasquez.models.Product;

public class ElectronicsDiscount extends DiscountPolicy {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.10;  // 10% de descuento
    }
}