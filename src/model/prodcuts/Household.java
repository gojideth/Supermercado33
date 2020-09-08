package model.prodcuts;

import model.Product;
import java.util.ArrayList;


public class Household extends Product {
    private ArrayList<Household> householdsProdcuts = new ArrayList();
    private int warranty;

    public Household(double price, String name, int quantityForSold, double priceOfProvider, int warranty) {
        super(price, name, quantityForSold, priceOfProvider);
        this.warranty=warranty;
    }
}
