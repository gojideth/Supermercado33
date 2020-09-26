package model.products;

import model.Product;
import java.util.ArrayList;


public class Household extends Product {

    private int warranty;

    public Household(double price, String name, int quantityForSold, double priceOfProvider, int warranty) {
        super(price, name, quantityForSold, priceOfProvider);
        this.warranty=warranty;
    }
}
