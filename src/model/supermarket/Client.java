package model.supermarket;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que contiene la informacion del cliente
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date: 26/09/2020
 */
public class Client extends Person{
    private Market market;
    private Bill bill;
    private List<Product> car;

    /**
     * Constructor que crea un cliente heredando los atributos de la clase abstracta Persona
     * @param name Nombre del cliente
     * @param dateBirth Año de nacimiento
     * @param id Identificacion del cliente
     * @param charge Estado del cliente
     * @param bill Factura del cliente
     * @param market Mercado al cual esta comprando
     */

    public Client(String name, LocalDate dateBirth, String id, Charge charge, Bill bill, Market market) {
        super(name, dateBirth, id);
        this.bill=bill;
        this.market = market;
        this.car = new LinkedList();
    }

    public void getAllProducts(){
        car = market.products;
    }

    /**
     * Metodo que ordena la lista de productos por orden alfabetico
     */
    public void orderAlphabet(){
        market.orderAlphabet();
        car = market.products;
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
        car = market.filters;
    }

    /**
     * Metodo que permite al usuario filtrar la lista por productos mayores a un precio
     * @param maxPrice precio minimo a pagar
     */
    public void filterMaxPrice(double maxPrice){
        market.filterMaxPrice(maxPrice);
        car = market.filters;
    }

    /**
     * Metodo que permite al usuario filtrar lista de productos por un precio minimo y un tipo de producto
     * @param minPrice precio minimo a pagar
     * @param typeProduct tipo de productos que desea buscar
     */
    public void filterMaxPrice(double minPrice, String typeProduct){
        market.filterMaxPrice(minPrice,typeProduct);
        car = market.filters;
    }

    /**
     * Metodo que permite al usuario filtrar la lista por el nombre del producto
     * @param nameProduct nombre del producto
     */
    public void filterName(String nameProduct){
        market.filterName(nameProduct);
        car = market.filters;
    }

    /**
     * Metodo que permite al usuario filtrar productos por un rango de precios
     * @param minPrice precio minimo que desee pagar
     * @param maxPrice precio maximo que desee pagar
     */
    public void filterRangePrices(double minPrice, double maxPrice){
        market.filterRangePrices(minPrice, maxPrice);
        car = market.filters;
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

    /**
     * Metodo que muestra todo el carrito de compras del cliente
     */
    public void showCar(){
        for (int i=0; i<car.size(); i++){
            System.out.println((i+1) + ". " + car.get(i).formatForBuy());
        }
    }

    /**
     * Metodo que genera la compra del cliente
     * @param index Posicion del producto que se va a comprar
     * @param quantity Cantidad de los productos
     */
    public void buy(int index, int quantity){
        if (index>=1 && index<=car.size()){
            car.get(index-1).getAvailableQuantity().setAmount(quantity);
            bill.getProducts().add(car.get(index-1));
            car.remove(index-1);
        }
    }

    public List<Product> getCar() {
        return car;
    }

    /**
     * Metodo que genera factura para el cliente
     */
    public void generateBill(){
        System.out.println("            Supermercado la 33          ");
        System.out.println(getName());
        System.out.println(getId());
        System.out.println(LocalDate.now() + " -- " +LocalTime.now());
        //System.out.println("Cantidad    Denominacion    nombre     precio  ");
        for (int i=0; i<bill.getProducts().size(); i++){
            Product temporal = bill.getProducts().get(i);
            System.out.println(temporal.getAvailableQuantity().getAmount() + "    " + temporal.getAvailableQuantity().getProductDenomination() + "    "
                + temporal.getName() + "     " + temporal.getAvailableQuantity().getAmount() * temporal.getPrice());
        }
        System.out.println("Total :                                " + bill.calculateTotal());
        System.out.println("     Gracias por su compra vuelva pronto          ");

    }
}
