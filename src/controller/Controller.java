package controller;

import model.administration.*;
import model.products.*;
import model.supermarket.*;
import views.IoManager;

import java.time.LocalDate;

public class Controller {
    private Manager manager;
    private IoManager ioManager;

    public Controller(Manager manager) {
        this.manager = manager;
        this.ioManager = new IoManager();
    }

    public void masterMenu(){
        System.out.println("Supermercado la 33");
        int option = ioManager.masterMenu();
        switch (option){
            case  1:
                clientMenu();
                break;
            case 2:
                adminMenu();
                break;
            default:
                masterMenu();
        }
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
                               ioManager.priceOfProviderForProduct(), new Quantity(ioManager.getUnits(), ioManager.generateDenomination()), ioManager.taxForLiquiour() ,ioManager.gradesForLiquor()));
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
                   case "FRUTAS":
                       manager.getAdministrator().addProduct(new EarthProducts(ioManager.priceForProduct(),ioManager.nameForProduct(), ioManager.numberOfSold(),
                               ioManager.priceOfProviderForProduct(), new Quantity(ioManager.getUnits(), ioManager.generateDenomination())));
                       break;
                   default:
                      adminMenu();
               }
               adminMenu();
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
       adminMenu();
    }


    public void clientMenu(){
        if (manager.getClient() != null){
            int option = ioManager.chooseFilter();
            switch (option) {
                case 1:
                    manager.getClient().filterType(ioManager.typeForFilter());
                    break;
                case 2:
                    manager.getClient().filterRangePrices(ioManager.minPrice(), ioManager.maxPrice());
                    break;
                case 3:
                    manager.getClient().filterMaxPrice(ioManager.minPrice(), ioManager.typeForFilter());
                    break;
                case 4:
                    manager.getClient().filterMaxPrice(ioManager.minPrice());
                    break;
                case 5:
                    manager.getClient().filterLowerPrice(ioManager.maxPrice(), ioManager.typeForFilter());
                    break;
                case 6:
                    manager.getClient().filterLowerPrice(ioManager.maxPrice());
                    break;
                case 7:
                    manager.getClient().getAllProducts();
                    break;
                case 8:
                    manager.getClient().filterName(ioManager.nameForFilter());
                    break;
                case 9:
                    manager.getClient().generateBill();
                    manager.deleteClient();
                    masterMenu();
                default:
                    manager.getClient().getAllProducts();
                    break;
            }
            manager.getClient().showCar();
            int choose = ioManager.buyMenu();
            switch (choose){
                case 1:
                    manager.getClient().showCar();
                    manager.getClient().buy(ioManager.getIndexOfProduct(), ioManager.getQuantityForBuy());
                    break;
                case 2:
                    break;
                case 3:
                    manager.getClient().generateBill();
                    manager.deleteClient();
                    break;
                default:
                    clientMenu();
            }
            if (choose == 1 || choose == 2){
                clientMenu();
            }else if (choose == 3){
                masterMenu();
            }
        }else {
            System.out.println("Debe loguearse primero:");
            String name = ioManager.nameUser();
            String id = ioManager.idUser();
            int year = ioManager.yearUser();
            int month = ioManager.monthForYear();
            int day = ioManager.dayOfyear();
            manager.setClient(new Client(name, LocalDate.of(year, month, day), id, Charge.USER, new Bill(LocalDate.now()), manager.getMyMarket()));
            clientMenu();
        }
    }

    public static void main(String[] args) {
        Market supermercado33 = new Market();
        Administration administration = new Administration(supermercado33);
        administration.addProduct(new PersonalCareProducts(2000, "Clorox", 1, 1200, new Quantity(20, Denomination.UNITS)));
        administration.addProduct(new PersonalCareProducts(3600, "Mr musculo", 1, 1600, new Quantity(20, Denomination.UNITS)));
        administration.addProduct(new PersonalCareProducts(2400, "Jabon loza", 1, 900, new Quantity(20, Denomination.UNITS)));
        administration.addProduct(new Liquor(38000,"Smirnoff", 1,14000,new Quantity(20, Denomination.UNITS), 20,15));
        administration.addProduct(new EarthProducts(800,"Pera", 1, 400, new Quantity(12, Denomination.GRAMS)));
        administration.addProduct(new Basket(1100, "Panela", 4, 600, new Quantity(15, Denomination.UNITS)));
        administration.addProduct(new Basket(1500, "Chocoramo", 1, 700, new Quantity(40, Denomination.UNITS)));
        administration.addProduct(new Basket(766, "gala", 2, 21, new Quantity(4, Denomination.UNITS)));
        administration.addProduct(new Household(15000, "Plancha", 1, 50000, new Quantity(15, Denomination.UNITS), 8));
        administration.addProduct(new Liquor(45000, "Lider",1, 21000, new Quantity(35, Denomination.UNITS), 12, 29));
        Manager manager = new Manager(supermercado33);
        new Controller(manager).masterMenu();
    }
}
