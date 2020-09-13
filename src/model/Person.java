package model;

import java.util.Date;

public abstract class Person {
    private int age;
    private String name;
    private Date dateBirth;
    private String id;

    public Person(int age, String name, Date dateBirth, String id) {
        this.age = age;
        this.name = name;
        this.dateBirth = dateBirth;
        this.id = id;
    }
}
