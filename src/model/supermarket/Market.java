package model.supermarket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date 26/09/2020
 * Clase Supermercadp que contiene los productos que se venden y los filtros a estos productos
 */
public class Market {
    public List<Product> products;
    private List<Product> filters;

    public Market() {
        products = new ArrayList<>();
        filters = new ArrayList<>();
    }

    public void orderAlphabet(){
        filters.clear();
        filters.addAll(products);
        filters.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }

    /**
     * Metodo que filtra la lista de productos por nombre
     * @param name nombre del producto
     */
    public void filterName(String name){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).name.contains(name)){
                filters.add(products.get(i));
            }
        }
    }

    /**
     * Metodo que permite filtrar por un tipo de producto
     * @param type tipo de producto
     */
    public void filterType(String type){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIndentifier().contains(type.toUpperCase())){
                filters.add(products.get(i));
            }
        }
    }

    /**
     * Metodo que permite filtrar la lista por un precio masximo a pagar
     * @param maxPrice precio maximo a pagar
     */
    public void filterLowerPrice(double maxPrice){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() <= maxPrice){
                filters.add(products.get(i));
            }
        }
    }

    /**
     * Metodo que permite filtrar por un precio maximo a pagar y por un tipo de producto
     * @param maxPrice
     * @param typeProduct
     */
    public void filterLowerPrice(double maxPrice, String typeProduct){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            Product productTemporal = products.get(i);
            if (productTemporal.getPrice() <= maxPrice && productTemporal.getIndentifier().equalsIgnoreCase(typeProduct)){
                filters.add(productTemporal);
            }
        }
    }

    /**
     * Metodo que permite filtrar los productos por un precio minimo
     * @param minPrice minimo precio
     */
    public void filterMaxPrice(double minPrice){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() >= minPrice){
                filters.add(products.get(i));
            }
        }
    }

    /**
     * Metodo que permite filtrar por un precio minimo y un tipo de producto
     * @param minPrice minimo precio a pagar
     * @param typeProduct tipo de producto
     */
    public void filterMaxPrice(double minPrice, String typeProduct){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            Product productTemporal = products.get(i);
            if (productTemporal.getPrice() >= minPrice && productTemporal.getIndentifier().contains(typeProduct.toUpperCase())){
                filters.add(productTemporal);
            }
        }
    }

    /**
     * Metodo que permite filtrar por un rango de precios
     * @param minPrice precio minimo que se desea pagar
     * @param maxPrice precio maximo que se desea pagar
     */
    public void filterRangePrices(double minPrice, double maxPrice){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            Product productTemporal = products.get(i);
            if (productTemporal.getPrice() >= minPrice && productTemporal.getPrice() <= maxPrice){
                filters.add(productTemporal);
            }
        }
    }

    /**
     * metodo que muestra la lista de productos
     */
    public void show(){
        for (int i=0; i<this.products.size(); i++){
            System.out.println(products.get(i).name);
        }
    }

    /**
     * Metodo que muestra lista de filtrados
     */
    public void showFilters(){
        for (int i=0; i<this.filters.size(); i++){
            System.out.println(filters.get(i).name);
        }
    }
}
