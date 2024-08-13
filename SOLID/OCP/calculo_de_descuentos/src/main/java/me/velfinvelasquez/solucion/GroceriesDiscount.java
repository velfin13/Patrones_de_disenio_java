package me.velfinvelasquez.solucion;

import me.velfinvelasquez.models.Product;

public class GroceriesDiscount extends DiscountPolicy {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.05;  // 5% de descuento
    }
}
