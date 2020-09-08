package model;

public class Quantity {
    private int amount;
    private Denomination productDenomination;

    public Quantity(int amount, Denomination productDenomination) {
        this.amount=amount;
        this.productDenomination=productDenomination;
    }

    public int getAmount() {
        return amount;
    }

    public Denomination getProductDenomination() {
        return productDenomination;
    }

    public void setAmount(int amount) {
        this.amount=amount;
    }
}
