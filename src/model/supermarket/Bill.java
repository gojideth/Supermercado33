package model.supermarket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill {
    private Date dateOfExpedition;
    private List<Product> products;

    public Bill(Date dateOfExpedition) {
        this.dateOfExpedition=dateOfExpedition;
        this.products=new ArrayList();
    }

    public Date getDateOfExpedition() {
        return dateOfExpedition;
    }

    public List<Product> getProducts() {
        return products;
    }

}
