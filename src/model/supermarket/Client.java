package model.supermarket;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date 26/09/2020
 * Clase que contiene la informacion del cliente
 */
public class Client extends Person{
    private Market market;
    private Bill bill;

    public Client(String name, LocalDate dateBirth, String id, Charge charge, Bill bill, Market market) {
        super(name, dateBirth, id);
        this.bill=bill;
        this.market = market;
    }

    /**
     * Metodo que ordena la lista de productos por orden alfabetico
     */
    public void orderAlphabet(){
        market.orderAlphabet();
    }

    /**
     * Metodo que permite al usuario filtrar la lista de productos por un tipo de producto y por un precio maximo
     * @param price precio maximo de productos a buscar
     * @param typeProduct tipo de producto por el que se filtraran
     */
    public void filterLowerPrice(double price, String typeProduct){
        market.filterLowerPrice(price, typeProduct);
    }

    /**
     * Metodo que permite al usuario filtrar la lista por un precio maximo que desse pagar
     * @param price precio maximo a pagar
     */
    public void filterLowerPrice(double price){
        market.filterLowerPrice(price);
    }

    /**
     * Metodo que permite al usuario filtrar la lista por productos mayores a un precio
     * @param maxPrice precio minimo a pagar
     */
    public void filterMaxPrice(double maxPrice){
        market.filterMaxPrice(maxPrice);
    }

    /**
     * Metodo que permite al usuario filtrar lista de productos por un precio minimo y un tipo de producto
     * @param minPrice precio minimo a pagar
     * @param typeProduct tipo de productos que desea buscar
     */
    public void filterMaxPrice(double minPrice, String typeProduct){
        market.filterMaxPrice(minPrice,typeProduct);
    }

    /**
     * Metodo que permite al usuario filtrar la lista por el nombre del producto
     * @param nameProduct nombre del producto
     */
    public void filterName(String nameProduct){
        market.filterName(nameProduct);
    }

    /**
     * Metodo que permite al usuario filtrar productos por un rango de precios
     * @param minPrice precio minimo que desee pagar
     * @param maxPrice precio maximo que desee pagar
     */
    public void filterRangePrices(double minPrice, double maxPrice){
        market.filterRangePrices(minPrice, maxPrice);
    }

    /**
     * Metodo que agregar a la lista de compra del usuario un producto
     * @param purchase producto a agregar
     */
    public void productsToBuy(Product purchase){
        bill.getProducts().add(purchase);
    }

    /**
     * Metodo que entrega la informacion de la factura
     * @return factura del usuario
     */
    public Bill getBill() {
        return bill;
    }
}
