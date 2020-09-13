package model;

import java.util.Date;

public class Worker extends Person{

    private Charge companyStatus;

    public Worker(int age, String name, Date dateBirth, String id, Charge companyStatus) {
        super(age, name, dateBirth, id);
        this.companyStatus = Charge.WORKER;
    }
}
