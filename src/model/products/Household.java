package model.products;

import model.supermarket.Product;


public class Household extends Product {
    private int warranty;
    protected static final String INDENTIFIER = "Electrodomestico";

    public Household(double price, String name, int quantityForSold, double priceOfProvider, int warranty) {
        super(price, name, quantityForSold, priceOfProvider);
        this.warranty=warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    public static String getINDENTIFIER() {
        return INDENTIFIER;
    }
}
