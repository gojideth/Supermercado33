package model.products;

import model.supermarket.Product;

public class EarthProducts extends Product {

    public EarthProducts(double price, String name, int quantityForSold, double priceOfProvider) {
        super(price, name, quantityForSold, priceOfProvider);
    }

    @Override
    public String getIndentifier() {
        return "Frutas";
    }
}
