package model.administration;

import model.supermarket.Market;
import model.supermarket.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public void addProduct(Product product){
        market.products.add(product);
    }

    public boolean isDeleteProduct(String product){
        for (int i=0; i<market.products.size(); i++){
            if (market.products.get(i).getName().equals(product)){
                market.products.remove(i);
                return true;
            }
        }
        return false;
    }

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

    public void setEarnings(double earnings) {
        this.earnings+=earnings;
    }
}
