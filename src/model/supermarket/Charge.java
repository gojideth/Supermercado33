package model.supermarket;

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
