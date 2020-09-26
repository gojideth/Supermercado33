package model.products;
import model.supermarket.Product;

public class Basket extends Product {

    public Basket(double price, String name, int quantityForSold, double priceOfProvider) {
        super(price, name, quantityForSold, priceOfProvider);
    }

    @Override
    public String getIndentifier() {
        return "Canasta";
    }
}
