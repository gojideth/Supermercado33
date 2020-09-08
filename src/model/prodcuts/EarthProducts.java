package model.prodcuts;

import model.Product;

import java.util.ArrayList;

public class EarthProducts extends Product {
    private ArrayList<EarthProducts> productsOfEarth = new ArrayList();

    public EarthProducts(double price, String name, int quantityForSold, double priceOfProvider) {
        super(price, name, quantityForSold, priceOfProvider);
    }
}
