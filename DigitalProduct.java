package com.ecommerce.model;

/**
 * Concrete subclass representing digital goods (e-books, software licenses).
 * Demonstrates:
 * - Inheritance: Extends Product
 * - Polymorphism: Overrides getProductType(), calculateShippingCost() (always $0.00), calculateDiscount()
 */
public class DigitalProduct extends Product {

    private String downloadUrl;

    public DigitalProduct() {
        super();
    }

    public DigitalProduct(Long id, String sku, String name, String category, double price, int stockQuantity, String downloadUrl) {
        super(id, sku, name, category, price, stockQuantity);
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String getProductType() {
        return "DIGITAL";
    }

    /**
     * Digital goods have zero shipping costs.
     */
    @Override
    public double calculateShippingCost() {
        return 0.0;
    }

    @Override
    public double calculateDiscount(int quantity, CustomerTier tier) {
        // Digital products have near-zero marginal cost, offering higher discounts
        double baseDiscount = super.calculateDiscount(quantity, tier);
        double digitalBonus = (getPrice() * quantity) * 0.05; // Extra 5% digital promotion
        return Math.round((baseDiscount + digitalBonus) * 100.0) / 100.0;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return super.toString() + " [Digital Download: " + downloadUrl + "]";
    }
}
