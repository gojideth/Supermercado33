package model;

import java.util.Date;

public class Client extends Person{
    private Charge charge;

    public Client(int age, String name, Date dateBirth, String id, Charge charge) {
        super(age, name, dateBirth, id);
        this.charge = Charge.USER;
    }


}
