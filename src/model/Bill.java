package model;
import java.util.ArrayList;
import java.util.Date;

public class Bill {
    private Date dateOfExpedition;
    private Client payer;
    private ArrayList <Product> products;

    public Bill(Date dateOfExpedition, Client payer) {
        this.dateOfExpedition=dateOfExpedition;
        this.payer=payer;
        this.products=new ArrayList();
    }
}
