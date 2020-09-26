package model.products;

import model.supermarket.Product;

public class Liquor extends Product {
    private double tax;
    private int alcoholAmount;

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

    @Override
    public String getIndentifier() {
        return "Licor";
    }
}
