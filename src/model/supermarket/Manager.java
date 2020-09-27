package model.supermarket;

import model.administration.Administration;

public class Manager {

    private Administration administrator;
    private Client client;
    private Market myMarket;

    public Manager(Administration administrator, Client client, Market myMarket) {
        this.administrator = administrator;
        this.client = client;
        this.myMarket = myMarket;
    }

    public void setClient(Client client){
        this.client = client;
    }
}
