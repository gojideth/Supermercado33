package model.supermarket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Market {
    private List<Product> products;
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

    public void filterName(String name){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).name.contains(name)){ //comparar con el identificador
                filters.add(products.get(i));
            }
        }
    }

    public void filterLowerPrice(double maxPrice){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() <= maxPrice){
                filters.add(products.get(i));
            }
        }
    }

    public void filterLowerPrice(double maxPrice, String typeProduct){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() <= maxPrice && products.get(i).INDENTIFIER.equalsIgnoreCase(typeProduct)){
                filters.add(products.get(i));
            }
        }
    }

    public void filterMaxPrice(double minPrice){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() >= minPrice){
                filters.add(products.get(i));
            }
        }
    }

    public void filterRangePrices(double minPrice, double maxPrice){
        filters.clear();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() >= minPrice && products.get(i).getPrice() <= maxPrice){
                filters.add(products.get(i));
            }
        }
    }

    public Product getProduct (Product product){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(product)){
                return products.get(i);
            }
        }
        return null; // implementar exepcion try cash
    }

    public void alertForQuantity(){

    }


}
