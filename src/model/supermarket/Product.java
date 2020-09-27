package model.supermarket;

public abstract class Product {
    public static final double IVA_PERCENTAGE = 0.19;

    protected double price;
    protected String name;
    protected int quantityForSold;
    private double priceOfProvider;
    private Provider provider;
    private Quantity availableQuantity;

    public Product(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity) {
        this.price=price;
        this.name=name;
        this.availableQuantity = quantity;
        this.quantityForSold=quantityForSold;
        this.priceOfProvider=priceOfProvider;
    }

    public double getPriceOfProvider() {
        return priceOfProvider;
    }

    public double getPrice() {
        return price;
    }

    public Provider getProvider() {
        return provider;
    }

    public Quantity getAvailableQuantity() {
        return availableQuantity;
    }

    public abstract String getIndentifier();

    public String getName() {
        return name;
    }
}
