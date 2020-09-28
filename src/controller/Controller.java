package controller;

import model.products.Household;
import model.supermarket.Manager;
import org.omg.CORBA.PUBLIC_MEMBER;
import views.IoManager;

public class Controller {
    private Manager manager;
    private IoManager ioManager;

    public Controller(Manager manager) {
        this.manager = manager;
        this.ioManager = new IoManager();
    }

    public void masterMenu(){

    }

    public void adminMenu(){
       int option = ioManager.adminMenu();
       switch (option){
           case 1:
               String type = ioManager.getTypeNewProduct().toUpperCase();
               switch (type){
                   case "ELECTRODOMESTIOC":
                       manager.getAdministrator().addProduct(new Household());
               }
           case 2:
               manager.getAdministrator().isDeleteProduct(ioManager.nameDeleteForAdmin());
               break;

       }
    }

    public void filtersMenu(){

    }

    public void clientMenu(){

    }
}
