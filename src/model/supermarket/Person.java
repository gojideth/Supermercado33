package model.supermarket;

import java.time.LocalDate;
import java.util.Date;

/**
 * Clase persona que sera parte de la inforacion del cliente
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date: 26/09/2020
 */
public abstract class Person {
    private String name;
    private LocalDate dateBirth;
    private String id;

    public Person(String name, LocalDate dateBirth, String id) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.id = id;
    }

    /**
     * Metodo para extraer nombre del cliente
     * @return nombre del cliente
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que regresa la fecha de nacimiento de la persona
     * @return fecha de nacimiento de la persona
     */
    public LocalDate getDateBirth() {
        return dateBirth;
    }

    /**
     * Metodo que permite extraer el id del cliente
     * @return id del cliente
     */
    public String getId() {
        return id;
    }
}
