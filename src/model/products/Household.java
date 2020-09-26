package model.products;

import model.supermarket.Product;


public class Household extends Product {
    private int warranty;

    public Household(double price, String name, int quantityForSold, double priceOfProvider, int warranty) {
        super(price, name, quantityForSold, priceOfProvider);
        this.warranty=warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    @Override
    public String getIndentifier() {
        return "Electrodomestico";
    }
}
