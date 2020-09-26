package model.products;

import model.supermarket.Product;

public class GroomingProducts extends Product {
    protected static final String INDENTIFIER = "Aseo";

    public GroomingProducts(double price, String name, int quantityForSold, double priceOfProvider) {
        super(price, name, quantityForSold, priceOfProvider);
    }

    public static String getINDENTIFIER() {
        return INDENTIFIER;
    }
}
