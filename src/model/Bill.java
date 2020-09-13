package model;
import java.util.ArrayList;
import java.util.Date;

public class Bill {

    private int totalPriceProducts;
    private Date dateOfExpedition;
    private boolean statusPayment;
    private Client payer;
    private ArrayList <Product> products = new ArrayList<>();
    private Worker casher;

    public Bill(int totalPriceProducts, Date dateOfExpedition, boolean statusPayment, Client payer, ArrayList<Product> products, Worker casher) {
        this.totalPriceProducts = totalPriceProducts;
        this.dateOfExpedition = dateOfExpedition;
        this.statusPayment = statusPayment;
        this.payer = payer;
        this.products = products;
        this.casher = casher;
    }






}
