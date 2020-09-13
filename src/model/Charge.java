package model;

public enum Charge {
    USER("Usuario"), WORKER("Trabajador"), Administrative("Administrador");
    private String charge;

    Charge(String charge) {
        this.charge = charge;
    }

    public String getCharge() {
        return charge;
    }
}
