package model.products;

import model.supermarket.Product;
import model.supermarket.Quantity;

public class Liquor extends Product {
    private double tax;
    private int alcoholAmount;

    public Liquor(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity, double tax, int alcoholAmount) {
        super(price, name, quantityForSold, priceOfProvider, quantity);
        this.tax=tax;
        this.alcoholAmount=alcoholAmount;
    }

    public double getTax() {
        return tax;
    }

    public int getAlcoholAmount() {
        return alcoholAmount;
    }

    @Override
    public String getIndentifier() {
        return "LICOR";
    }
}
