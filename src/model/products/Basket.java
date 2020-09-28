package model.products;
import model.supermarket.Product;
import model.supermarket.Quantity;
/**
 * Clase de los productos que hacen parte de la canasta basica
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date : 26/09/2020
 */

public class Basket extends Product {

    /**
     * Constructor que crea una canasta de productos alimenticios
     * @param price Precio de los productos
     * @param name Nombre del producto
     * @param quantityForSold Cantidad disponible de venta
     * @param priceOfProvider Precio de los proveedores
     * @param quantity Cantidad de la presentacion
     */
    public Basket(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity) {
        super(price, name, quantityForSold, priceOfProvider, quantity);
    }

    @Override
    public String getIndentifier() {
        return "CANASTA";
    }
}
