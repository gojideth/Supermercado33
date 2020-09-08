package model.prodcuts;

import model.Product;

import java.util.ArrayList;

public class PersonalCareProducts extends Product {
    private ArrayList<PersonalCareProducts> personalProducts = new ArrayList();

    public PersonalCareProducts(double price, String name, int quantityForSold, double priceOfProvider) {
        super(price, name, quantityForSold, priceOfProvider);
    }
}
