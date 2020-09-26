package model;

import java.util.Date;

public class Administrator extends Person {
    private double earnings;

    public Administrator(String name, Date dateBirth, String id, double earnings) {
        super(name, dateBirth, id);
        this.earnings = earnings;
    }

    public void addDiscount(){

    }

    public void addProduct(){

    }


}
