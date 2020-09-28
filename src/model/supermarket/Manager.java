package model.supermarket;

import model.administration.Administration;

public class Manager {

    private Administration administrator;
    private Client client;
    private Market myMarket;

    public Manager(Market myMarket) {
        this.myMarket = new Market();
        this.administrator = new Administration(myMarket);
    }

    public Administration getAdministrator() {
        return administrator;
    }

    public void setClient(Client client){
        this.client = client;
    }
}
