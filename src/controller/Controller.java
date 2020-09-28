package controller;

import model.products.*;
import model.supermarket.Manager;
import model.supermarket.Quantity;
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
                   case "ELECTRODOMESTICO":
                       manager.getAdministrator().addProduct(
                               new Household(ioManager.priceForProduct(),ioManager.nameForProduct(), ioManager.numberOfSold(),
                                       ioManager.priceOfProviderForProduct(), new Quantity(ioManager.getUnits(), ioManager.generateDenomination()), ioManager.mothsOfGaranty()));
                       break;
                   case "LICOR":
                       manager.getAdministrator().addProduct(new Liquor(ioManager.priceForProduct(),ioManager.nameForProduct(), ioManager.numberOfSold(),
                               ioManager.priceOfProviderForProduct(), new Quantity(ioManager.getUnits(), ioManager.generateDenomination()), ioManager.gradesForLiquor()));
                       break;
                   case "CANASTA":
                        manager.getAdministrator().addProduct(new Basket(ioManager.priceForProduct(),ioManager.nameForProduct(), ioManager.numberOfSold(),
                                ioManager.priceOfProviderForProduct(), new Quantity(ioManager.getUnits(), ioManager.generateDenomination())));
                        break;
                   case "ASEO":
                       manager.getAdministrator().addProduct(new GroomingProducts(ioManager.priceForProduct(),ioManager.nameForProduct(), ioManager.numberOfSold(),
                               ioManager.priceOfProviderForProduct(), new Quantity(ioManager.getUnits(), ioManager.generateDenomination())));
                       break;
                   case "PERSONAL":
                       manager.getAdministrator().addProduct(new PersonalCareProducts(ioManager.priceForProduct(),ioManager.nameForProduct(), ioManager.numberOfSold(),
                               ioManager.priceOfProviderForProduct(), new Quantity(ioManager.getUnits(), ioManager.generateDenomination())));
                       break;
                   case "Frutas":
                       manager.getAdministrator().addProduct(new EarthProducts(ioManager.priceForProduct(),ioManager.nameForProduct(), ioManager.numberOfSold(),
                               ioManager.priceOfProviderForProduct(), new Quantity(ioManager.getUnits(), ioManager.generateDenomination())));
                       break;
               }
           case 2:
               manager.getAdministrator().isDeleteProduct(ioManager.nameDeleteForAdmin());
               break;
           case 3:
               manager.getAdministrator().checkInventary();
               break;
           case 4:
               manager.getAdministrator().getOrderPrice(manager.getAdministrator().checkInventary());
               break;
           case 5:
               manager.getAdministrator().fixInventory();
               break;
           case 6:
               masterMenu();
           default:
               adminMenu();
       }
    }

    public void filtersMenu(){

    }

    public void clientMenu(){

    }
}
