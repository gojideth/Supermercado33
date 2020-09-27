package model.products;
import model.supermarket.Product;
import model.supermarket.Quantity;
/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * Date: 26/09/2020
 * Clase de los productos que hacen parte de la canasta basica
 */

public class Basket extends Product {

    public Basket(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity) {
        super(price, name, quantityForSold, priceOfProvider, quantity);
    }

    @Override
    public String getIndentifier() {
        return "CANASTA";
    }
}
