package model.administration;

import model.supermarket.Market;
import model.supermarket.Product;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date 26/09/2020
 * Clase que permite administrar el sumercardo y surtir el mismo
 */
public class Administration {
    private static final int HALF_A_DOZEN = 6;
    private static final int HALF_A_TWO_DOZEN = 30;
    private static final int THREE_DOZEN = 36;
    private static final int MIN_WEIGHT= 30000;

    private double earnings;
    private Market market;

    public Administration(Market market) {
        this.earnings = 0;
        this.market = market;
    }

    /*protected double addDiscount(String indeifier, int discount){

    }

    protected double addDiscount(int discount){

    }*/

    /**
     * Metodo que agrega un producto a la lista de productos
     * @param product producto a agregar
     */
    public void addProduct(Product product){
        market.products.add(product);
    }

    /**
     * Metodo que elimina un producto de la lista
     * @param product nombre del producto a eliminar
     * @return true, si fue eliminado, false si no
     */
    public boolean isDeleteProduct(String product){
        for (int i=0; i<market.products.size(); i++){
            if (market.products.get(i).getName().equals(product)){
                market.products.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que revisa que en el inventario no queden menos de media docena por producto
     * @return lista de productos que tienen menos de 6 unidades en inventario
     */
    public List<Product> checkInventary(){
        List<Product> productsForOrder = new LinkedList();
        for (int i=0; i<market.products.size(); i++){
            Product productTemporal = market.products.get(i);
            if (productTemporal.getAvailableQuantity().getAmount() < HALF_A_DOZEN){
                productsForOrder.add(productTemporal);
            }
        }
        return productsForOrder;
    }

    /**
     * Metodo que calcula el costo de la orden para surtir el inventario de la tienda
     * @param order lista de productos
     * @return costo de pedido
     */
    public double getOrderPrice(List<Product> order){
        double price = 0;
        for (int i=0; i<order.size(); i++){
            Product temp = order.get(i);
            switch (temp.getIndentifier()){
                case "Electrodomestico" :
                    price += temp.getPriceOfProvider() * (HALF_A_DOZEN - temp.getAvailableQuantity().getAmount());
                    break;
                case "Frutas":
                    price += temp.getPriceOfProvider() * (MIN_WEIGHT - temp.getAvailableQuantity().getAmount());
                    break;
                case "Aseo":
                case "Licor":
                case "Personal":
                    price += temp.getPriceOfProvider() *(HALF_A_TWO_DOZEN - temp.getAvailableQuantity().getAmount());
                    break;
                case "Canasta":
                    price += temp.getPriceOfProvider() *(THREE_DOZEN - temp.getAvailableQuantity().getAmount());
                    break;
            }
        }
        return price;
    }

    /**
     * Metodo que llena el inventario de la tienda a lo arrojado por checkInventary
     */
    public void fixInventory(){
        List<Product> products = checkInventary();
        for (int i=0; i<products.size(); i++){
            for (int j=0; j<market.products.size(); j++){
                if (products.get(i).getName().equals(market.products.get(j).getName())){
                    market.products.get(j).getAvailableQuantity().setAmount(products.get(i).getAvailableQuantity().getAmount());
                    break;
                }
            }
        }
    }

    /**
     * Metodo que suma las ventas a un contador de ganancias
     * @param earnings
     */
    public void setEarnings(double earnings) {
        this.earnings+=earnings;
    }
}
