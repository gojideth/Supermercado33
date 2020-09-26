package model.products;

import model.supermarket.Product;

public class PersonalCareProducts extends Product {
    protected static final String INDENTIFIER = "Personal";

    public PersonalCareProducts(double price, String name, int quantityForSold, double priceOfProvider) {
        super(price, name, quantityForSold, priceOfProvider);
    }

    public static String getINDENTIFIER() {
        return INDENTIFIER;
    }
}
