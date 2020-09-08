package model;

public abstract class Product {
    public static final double IVA_PERCENTAGE = 0.19;

    protected double price;
    protected String name;
    protected int quantityForSold;
    private double priceOfProvider;
    private Provider provider;
    private Quantity availableQuantity;

    public Product(double price, String name, int quantityForSold, double priceOfProvider) {
        this.price=price;
        this.name=name;
        this.quantityForSold=quantityForSold;
        this.priceOfProvider=priceOfProvider;
    }

    public double getPriceOfProvider() {
        return priceOfProvider;
    }
}
