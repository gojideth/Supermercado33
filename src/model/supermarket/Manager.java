package model.supermarket;

import model.administration.Administration;
/**
 * Clase Manager que contiene los permisos de crear clientes y administradores
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date: 26/09/2020
 */
public class Manager {

    private Administration administrator;
    private Client client;
    private Market myMarket;

    /**
     * Constructor que recibe un supermercado y lo instancia junto a los atributos de la clase
     * @param myMarket Mercado que se recibe para crear
     */

    public Manager(Market myMarket) {
        this.myMarket = new Market();
        this.administrator = new Administration(myMarket);
        this.client = null;
    }

    /**
     * Metodo que permite acceder al cliente
     * @return cliente
     */
    public Client getClient() {
        return client;
    }

    public void deleteClient(){
        this.client = null;
    }

    /**
     * Metodo que retorna el administrador
     * @return Administrador
     */
    public Administration getAdministrator() {
        return administrator;
    }

    /**
     * Metodo que modifica un cliente entrante al atributo de la clase
     * @param client El cliente que se quiere modificar
     */
    public void setClient(Client client){
        this.client = client;
    }

    public Market getMyMarket() {
        return myMarket;
    }
}
