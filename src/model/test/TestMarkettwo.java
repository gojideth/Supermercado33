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

    public void addtr(){
        administration.addProduct(new PersonalCareProducts(8, "persona1", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(10, "persona2", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(12, "persona3", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(14, "persona4", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(20, "sable", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new Liquor(211,"rrr", 6,4,new Quantity(5, Denomination.GRAMS), 5,5));
    }

    public void cdd(){
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
        testMarkettwo.addtr();
        testMarkettwo.cdd();
    }
}
