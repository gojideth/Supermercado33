package model.supermarket;

/**
 * Enumerado que da roles a las personas en el supermercado
 * @author Martin Santiago Chuquillo Castro
 * @author Julian Alberto Ardila Arguelo
 * @author Andres Leonardo Amaya Vargas
 * @date : 26/09/2020
 */
public enum Charge {
    USER("Usuario"), Administrative("Administrador");
    private String charge;

    Charge(String charge) {
        this.charge = charge;
    }

    public String getCharge() {
        return charge;
    }
}
