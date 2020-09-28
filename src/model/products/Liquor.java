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
    private double tax;
    private int alcoholAmount;

    /**
     * Constructor que crea productos de tipo aseo personal
     * @param price Precio de los productos
     * @param name Nombre del producto
     * @param quantityForSold Cantidad disponible de venta
     * @param priceOfProvider Precio de los proveedores
     * @param quantity Cantidad de la presentacion
     * @param tax Impuesto al licor
     * @param alcoholAmount Porcentaje de alcohol
     */
    public Liquor(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity, double tax, int alcoholAmount) {
        super(price, name, quantityForSold, priceOfProvider, quantity);
        this.tax=tax;
        this.alcoholAmount=alcoholAmount;
    }

    /**
     * Metodo que retorna el impuesto del licor
     * @return
     */
    public double getTax() {
        return tax;
    }

    /**
     * Metodo que retorna el porcentaje de alcohol del licor
     * @return Porcentaje de alcohol
     */
    public int getAlcoholAmount() {
        return alcoholAmount;
    }

    @Override
    public String getIndentifier() {
        return "LICOR";
    }
}
