package model.products;

import model.supermarket.Product;

public class PersonalCareProducts extends Product {

    public PersonalCareProducts(double price, String name, int quantityForSold, double priceOfProvider) {
        super(price, name, quantityForSold, priceOfProvider);
    }

    @Override
    public String getIndentifier() {
        return "Personal";
    }


}
