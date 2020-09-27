package model.products;

import model.supermarket.Product;
import model.supermarket.Quantity;

/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * Date: 26/09/2020
 * Clase de los electrodomesticos
 */
public class Household extends Product {
    private int warranty;

    public Household(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity, int warranty) {
        super(price, name, quantityForSold, priceOfProvider, quantity);
        this.warranty=warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    @Override
    public String getIndentifier() {
        return "ELECTRODOMESTICO";
    }
}
