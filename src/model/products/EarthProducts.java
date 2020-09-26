package model.products;

import model.supermarket.Product;

public class EarthProducts extends Product {
    protected static final String INDENTIFIER = "fruta";

    public EarthProducts(double price, String name, int quantityForSold, double priceOfProvider) {
        super(price, name, quantityForSold, priceOfProvider);
    }

    public static String getINDENTIFIER() {
        return INDENTIFIER;
    }
}
