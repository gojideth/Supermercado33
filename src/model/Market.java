package model;

import java.util.ArrayList;
import java.util.List;

public class Market {
    List<Product> products;

    public Market() {
        products = new ArrayList<>();
    }

    public void filter(){

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
