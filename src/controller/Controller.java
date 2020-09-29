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

    // System.out.println("Filtrar por: \n 1. Tipo de producto \n 2. Rango de precio \n 3.max precio y tipo \n 4. Max precio \n 5. Min precio y tipo
    // \n 6. Min precio \n 7. Ordenar Nombre \n 8. Buscar por nombre ");
    public void clientMenu(){
        if (manager.getClient() != null){
            int option = ioManager.chooseFilter();
            Client tempClient = manager.getClient();
            switch (option) {
                case 1:
                    tempClient.filterType(ioManager.typeForFilter());
                    tempClient.showCar();
                    break;
                case 2:
                    tempClient.filterRangePrices(ioManager.minPrice(), ioManager.maxPrice());
                    tempClient.showCar();
                    break;
                case 3:
                    tempClient.filterMaxPrice(ioManager.minPrice(), ioManager.typeForFilter());
                    tempClient.showCar();
                    break;
                case 4:
                    tempClient.filterMaxPrice(ioManager.minPrice());
                    tempClient.showCar();
                    break;
                case 5:
                    tempClient.filterLowerPrice(ioManager.maxPrice(), ioManager.typeForFilter());
                    tempClient.showCar();
                    break;
                case 6:
                    tempClient.filterLowerPrice(ioManager.maxPrice());
                    tempClient.showCar();
                    break;
                case 7:
<<<<<<< HEAD
                    manager.getClient().getAllProducts();
                    break;
=======
                    tempClient.getAllProducts();
                    tempClient.showCar();
>>>>>>> 7d507690399defb8ea2901a3c74d457204184033
                case 8:
                    tempClient.filterName(ioManager.nameForProduct());
                    tempClient.showCar();
                    break;
                default:
                    tempClient.getAllProducts();
                    tempClient.showCar();
                    break;
            }
            System.out.println(manager.getClient().getCar().size());
            manager.getClient().showCar();
            int choose = ioManager.buyMenu();
            switch (choose){
                case 1:
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
        administration.addProduct(new PersonalCareProducts(8, "persona1", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(10, "persona2", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(12, "persona3", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(14, "persona4", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new PersonalCareProducts(20, "sable", 1, 455, new Quantity(20, Denomination.GRAMS)));
        administration.addProduct(new Liquor(211,"rrr", 6,4,new Quantity(5, Denomination.GRAMS), 5,5));
        administration.addProduct(new EarthProducts(5,"FF:3", 2, 5, new Quantity(7, Denomination.GRAMS)));
        administration.addProduct(new Basket(766, "gala", 2, 21, new Quantity(4, Denomination.UNITS)));
        Manager manager = new Manager(supermercado33);
        new Controller(manager).masterMenu();
    }
}
