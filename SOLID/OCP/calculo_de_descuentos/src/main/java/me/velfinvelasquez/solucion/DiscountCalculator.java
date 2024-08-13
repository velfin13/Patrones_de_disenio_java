package me.velfinvelasquez.solucion;

import me.velfinvelasquez.models.Product;

// Clase DiscountCalculator que utiliza la política de descuento
public class DiscountCalculator {
    private DiscountPolicy discountPolicy;

    public DiscountCalculator(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public double calculateDiscount(Product product) {
        return discountPolicy.calculateDiscount(product);
    }
}