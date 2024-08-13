package me.velfinvelasquez.solucion;

import me.velfinvelasquez.models.Product;

// Clase abstracta para los descuentos
public abstract class DiscountPolicy {
    public abstract double calculateDiscount(Product product);
}