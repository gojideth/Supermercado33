package model.supermarket;

import java.util.ArrayList;
import java.util.Date;

public class Bill {
    private Date dateOfExpedition;
    private ArrayList <Product> products;

    public Bill(Date dateOfExpedition) {
        this.dateOfExpedition=dateOfExpedition;
        this.products=new ArrayList();
    }

    public Date getDateOfExpedition() {
        return dateOfExpedition;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
