package model.products;
import model.supermarket.Product;

public class Basket extends Product {
    protected static final String IDENTIFIER = "Canasta";

    public Basket(double price, String name, int quantityForSold, double priceOfProvider) {
        super(price, name, quantityForSold, priceOfProvider);
    }

    public static String getIDENTIFIER() {
        return IDENTIFIER;
    }
}
