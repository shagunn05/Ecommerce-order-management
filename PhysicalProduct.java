package com.ecommerce.model;

/**
 * Concrete subclass representing physical goods requiring shipping.
 * Demonstrates:
 * - Inheritance: Extends Product
 * - Polymorphism: Overrides getProductType(), calculateShippingCost(), calculateDiscount()
 */
public class PhysicalProduct extends Product {

    private double weightKg;

    public PhysicalProduct() {
        super();
    }

    public PhysicalProduct(Long id, String sku, String name, String category, double price, int stockQuantity, double weightKg) {
        super(id, sku, name, category, price, stockQuantity);
        setWeightKg(weightKg);
    }

    @Override
    public String getProductType() {
        return "PHYSICAL";
    }

    /**
     * Shipping cost based on weight ($4.50 base + $2.00 per kg).
     */
    @Override
    public double calculateShippingCost() {
        return Math.round((4.50 + (this.weightKg * 2.00)) * 100.0) / 100.0;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        this.weightKg = Math.max(0.0, weightKg);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [Weight: %.2f kg, Shipping: $%.2f]", weightKg, calculateShippingCost());
    }
}

