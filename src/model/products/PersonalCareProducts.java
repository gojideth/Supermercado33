package model.products;

import model.supermarket.Product;
import model.supermarket.Quantity;

/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date 26/09/2020
 * Clase de los productos de cuidado y aseo personal
 */
public class PersonalCareProducts extends Product {

    public PersonalCareProducts(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity) {
        super(price, name, quantityForSold, priceOfProvider, quantity);
    }

    @Override
    public String getIndentifier() {
        return "PERSONAL";
    }


}
