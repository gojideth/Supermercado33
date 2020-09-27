package model.supermarket;

/**
 * Clase producto que contiene la informacion de todos los productos que se venden en el supermercado
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date: 26/09/2020
 */
public abstract class Product {
    public static final double IVA_PERCENTAGE = 0.19;

    protected double price;
    protected String name;
    protected int quantityForSold;
    private double priceOfProvider;
    private Provider provider;
    private Quantity availableQuantity;

    public Product(double price, String name, int quantityForSold, double priceOfProvider, Quantity quantity) {
        this.price=price;
        this.name=name;
        this.availableQuantity = quantity;
        this.quantityForSold=quantityForSold;
        this.priceOfProvider=priceOfProvider;
    }

    /**
     * Metodo que permite extraer el precio al proveedor
     * @return precio de compra al proveedor
     */
    public double getPriceOfProvider() {
        return priceOfProvider;
    }

    /**
     * Metodo que devuelve el precio del producto en la tienda
     * @return precio del producto
     */
    public double getPrice() {
        return price;
    }

    /**
     * Metodo que retorna el nombre del provedor
     * @return nombre del proveedor del producto
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * Metodo que retonar la clase Quantity que contiene la informacion de la disponibilidad del producto en inventario
     * @return cantidad del producto
     */
    public Quantity getAvailableQuantity() {
        return availableQuantity;
    }

    /**
     * Metodo abstracto que retorna una cadena que hara de identificador del producto
     * @return cadena que sera un identificador
     */
    public abstract String getIndentifier();

    /**
     * Metodo que devuelve el nombre del producto
     * @return nombre del producto
     */
    public String getName() {
        return name;
    }

    public String formatForBuy(){
        return name + " precio: " + price + " cantidad disponible :" + getAvailableQuantity().getAmount() + getAvailableQuantity().getProductDenomination();
    }
}
