package model.supermarket;

import java.util.Date;

public class Client extends Person{
    private Charge charge;
    private Market market;
    private Bill bill;

    public Client(String name, Date dateBirth, String id, Charge charge, Bill bill, Market market) {
        super(name, dateBirth, id);
        this.charge=charge;
        this.bill=bill;
        this.market = market;
    }

    public void orderAlphabet(){
        market.orderAlphabet();
    }

    public void filterLowerPrice(double price, String typeProduct){
        market.filterLowerPrice(price, typeProduct);
    }

    public void filterLowerPrice(double price){
        market.filterLowerPrice(price);
    }

    public void filterMaxPrice(double maxPrice){
        market.filterMaxPrice(maxPrice);
    }

    public void filterMaxPrice(double maxPrice, String typeProduct){
        market.filterMaxPrice(maxPrice,typeProduct);
    }

    public void filterName(String nameProduct){
        market.filterName(nameProduct);
    }

    public void filterRangePrices(double minPrice, double maxPrice){
        market.filterRangePrices(minPrice, maxPrice);
    }

    public void productsToBuy(Product purchase){
        bill.getProducts().add(purchase);
    }

    public Charge getCharge() {
        return charge;
    }

    public Bill getBill() {
        return bill;
    }
}
