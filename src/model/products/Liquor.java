package model.products;

import model.supermarket.Product;
import model.supermarket.Quantity;

/**
 * Clase de las bebidas alcoholicas
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date: 26/09/2020
 */
public class Liquor extends Product {
    private int alcoholAmount;

    public Liquor(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity, int alcoholAmount) {
        super(price, name, quantityForSold, priceOfProvider, quantity);
        this.alcoholAmount=alcoholAmount;
    }

    public int getAlcoholAmount() {
        return alcoholAmount;
    }

    @Override
    public String getIndentifier() {
        return "LICOR";
    }
}
