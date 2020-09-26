package model;

import java.util.Date;

public abstract class Person {
    private String name;
    private Date dateBirth;
    private String id;

    public Person(String name, Date dateBirth, String id) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.id = id;
    }
}
