package model.supermarket;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Client extends Person{
    private Charge charge;
    private Bill bill;

    public Client(String name, Date dateBirth, String id, Charge charge, Bill bill) {
        super(name, dateBirth, id);
        this.charge=charge;
        this.bill=bill;
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
