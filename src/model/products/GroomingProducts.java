package model.products;

import model.supermarket.Product;
import model.supermarket.Quantity;

public class GroomingProducts extends Product {
    protected static final String INDENTIFIER = "Aseo";

    public GroomingProducts(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity) {
        super(price, name, quantityForSold, priceOfProvider, quantity);
    }

    @Override
    public String getIndentifier() {
        return "ASEO";
    }
}
