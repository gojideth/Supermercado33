package model.prodcuts;
import model.Product;

import java.util.ArrayList;

public class Basket extends Product {
    private ArrayList<Basket>  basketProduct = new ArrayList();

    public Basket(double price, String name, int quantityForSold, double priceOfProvider) {
        super(price, name, quantityForSold, priceOfProvider);
    }
}
