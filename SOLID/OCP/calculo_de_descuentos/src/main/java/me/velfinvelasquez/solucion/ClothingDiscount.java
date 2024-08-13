package me.velfinvelasquez.solucion;

import me.velfinvelasquez.models.Product;

public class ClothingDiscount extends DiscountPolicy {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.20;  // 20% de descuento
    }
}