package model.supermarket;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * Date: 26/09/2020
 * Clase factura que almacena los productos comprados por el usuario
 */
public class Bill {
    private LocalDate dateOfExpedition;
    private List<Product> products;

    public Bill(LocalDate date) {
        this.dateOfExpedition=date;
        this.products=new ArrayList();
    }

    /**
     * Metodo que arrjo la fecha de compra que se imprimira en la factura
     * @return fecha del dia actual
     */
    public LocalDate getDateOfExpedition() {
        return dateOfExpedition;
    }

    /**
     * Metodo que retornara la lista que contiene lo que el cliente comprara
     * @return arraylist con los productos que se compraran
     */
    public List<Product> getProducts() {
        return products;
    }

}
