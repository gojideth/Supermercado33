package model.products;

import model.supermarket.Product;
import model.supermarket.Quantity;

/**
 * Clase de los electrodomesticos
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date: 26/09/2020
 */
public class Household extends Product {
    private int warranty;

    /**
     * Constructor que crea productos de tipo electrodomesticos
     * @param price Precio de los productos
     * @param name Nombre del producto
     * @param quantityForSold Cantidad disponible de venta
     * @param priceOfProvider Precio de los proveedores
     * @param quantity Cantidad de la presentacion
     */
    public Household(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity, int warranty) {
        super(price, name, quantityForSold, priceOfProvider, quantity);
        this.warranty=warranty;
    }

    /**
     * Metodo que retorna la garantia del producto
     * @return Periodo de tiempo de garantia
     */
    public int getWarranty() {
        return warranty;
    }

    @Override
    public String getIndentifier() {
        return "ELECTRODOMESTICO";
    }
}
