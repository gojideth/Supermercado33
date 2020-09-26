package model;

import java.util.Date;

public class Client extends Person{

    private Charge charge;

    public Client(String name, Date dateBirth, String id, Charge charge) {
        super(name, dateBirth, id);
        this.charge=charge;
    }

    public void checkAge(){

    }

    public void pay(){

    }
}
