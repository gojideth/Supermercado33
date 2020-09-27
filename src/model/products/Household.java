package model.products;

import model.supermarket.Product;
import model.supermarket.Quantity;


public class Household extends Product {
    private int warranty;

    public Household(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity, int warranty) {
        super(price, name, quantityForSold, priceOfProvider, quantity);
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
