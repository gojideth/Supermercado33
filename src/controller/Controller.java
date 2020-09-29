package controller;

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
                case 8:
                    manager.getClient().filterName(ioManager.nameForProduct());
                    break;
                default:
                    manager.getClient().getAllProducts();
                    break;
            }
            int choose = ioManager.buyMenu();
            System.out.println(manager.getClient().getCar().size());
            manager.getClient().showCar();
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
        Manager manager = new Manager(supermercado33);
        new Controller(manager).masterMenu();
    }
}
