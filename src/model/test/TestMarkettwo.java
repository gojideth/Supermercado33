package model.test;
import model.administration.Administration;
import model.products.Liquor;
import model.products.PersonalCareProducts;
import model.supermarket.*;

import java.time.LocalDate;

public class TestMarkettwo {
    private Market market = new Market();
    private Administration administration;

    public TestMarkettwo() {
        this.administration=new Administration(market);
    }

    public void add(){
        administration.addProduct(new PersonalCareProducts(8, "Esponjilla", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(10, "jabon", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(12, "cloro", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(14, "fabuloso", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(20, "jabon de ropa", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new Liquor(211,"Aguardiente", 6,4,new Quantity(5, Denomination.GRAMS), 5,5));
    }

    public void filter(){
        Client client = new Client("ho", LocalDate.of(2000,2,2), "464646", Charge.USER, new Bill(LocalDate.now()), this.market);
        client.filterRangePrices(10,12);
        for (int i=0; i<market.getFilters().size(); i++){
            System.out.println(market.getFilters().get(i).getName());
        }
        System.out.println("____________");
        for (int i=0; i<client.getCar().size(); i++){
            System.out.println(client.getCar().get(i).getName());
        }
    }

    public static void main(String[] args) {
        TestMarkettwo testMarkettwo = new TestMarkettwo();
        testMarkettwo.add();
        testMarkettwo.filter();
    }
}
