package model.supermarket;

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
        this.amount+=amount;
    }

    public void restToAmount(int quantity){
        if (amount - quantity >= 0){
            this.amount -= quantity;
        }
    }
}
