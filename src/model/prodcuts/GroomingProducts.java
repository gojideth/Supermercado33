package model.prodcuts;

import model.Product;

import java.util.ArrayList;

public class GroomingProducts extends Product {
    private ArrayList<GroomingProducts> productsOfGrooming = new ArrayList();

    public GroomingProducts(double price, String name, int quantityForSold, double priceOfProvider) {
        super(price, name, quantityForSold, priceOfProvider);
    }
}
