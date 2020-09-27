package model.products;

import model.supermarket.Product;
import model.supermarket.Quantity;

public class EarthProducts extends Product {

    public EarthProducts(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity) {
        super(price, name, quantityForSold, priceOfProvider, quantity);
    }

    @Override
    public String getIndentifier() {
        return "FRUTAS";
    }
}
