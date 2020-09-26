package model.products;

import model.supermarket.Product;

public class Liquor extends Product {
    private double tax;
    private int alcoholAmount;
    protected static final String INDENTIFIER = "Licor";

    public Liquor(double price, String name, int quantityForSold, double priceOfProvider, double tax, int alcoholAmount) {
        super(price, name, quantityForSold, priceOfProvider);
        this.tax=tax;
        this.alcoholAmount=alcoholAmount;
    }

    public double getTax() {
        return tax;
    }

    public int getAlcoholAmount() {
        return alcoholAmount;
    }

    public static String getINDENTIFIER() {
        return INDENTIFIER;
    }
}
