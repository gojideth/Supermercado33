package model.prodcuts;

import model.Product;

import java.util.ArrayList;

public class Liquor extends Product {
    private ArrayList<Liquor> Liquors = new ArrayList();
    private double tax;
    private int alcoholAmount;

    public Liquor(double price, String name, int quantityForSold, double priceOfProvider, double tax, int alcoholAmount) {
        super(price, name, quantityForSold, priceOfProvider);
        this.tax=tax;
        this.alcoholAmount=alcoholAmount;
    }
}
