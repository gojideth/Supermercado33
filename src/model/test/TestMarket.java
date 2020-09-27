package model.test;

import model.administration.Administration;
import model.products.*;
import model.supermarket.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * Date: 26/09/2020
 * Clase que testea la clase Market
 */
public class TestMarket {
    private Market market;
    private Administration administration;
    private Scanner scanner;
    List<Product> proof;

    public TestMarket() {
        scanner = new Scanner(System.in);
        market = new Market();
        proof = new LinkedList<>();
        administration = new Administration(market);
    }

//    public void test() {
//        System.out.println("Ingrese numeros de Productos");
//        int productsNumber = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < productsNumber; i++) {
//            String[] line = scanner.nextLine().split(" ");
//            switch (line[0]) {
//                case "frutas":
//                    administration.addProduct(new EarthProducts(Double.parseDouble(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6]))));
//                    break;
//                case "licor":
//                    administration.addProduct(new Liquor(Double.parseDouble(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6])), Double.parseDouble(line[7]), Integer.parseInt(line[8])));
//                    break;
//                case "aseo":
//                    administration.addProduct(new GroomingProducts(Integer.parseInt(line[1]),line[2],Integer.parseInt(line[3]),Double.parseDouble(line[4]),new Quantity(Integer.parseInt(line[5]),Denomination.valueOf(line[6]))));
//                    break;
//                case "electrodomestico":
//                    administration.addProduct(new Household(Integer.parseInt(line[1]),line[2],Integer.parseInt(line[3]),Double.parseDouble(line[4]),new Quantity(Integer.parseInt(line[5]),Denomination.valueOf(line[6])), Integer.parseInt(line[7])));
//                    break;
//                case "personal":
//                    administration.addProduct(new PersonalCareProducts(Integer.parseInt(line[1]),line[2],Integer.parseInt(line[3]),Double.parseDouble(line[4]),new Quantity(Integer.parseInt(line[5]),Denomination.valueOf(line[6]))));
//                    break;
//                case "canasta":
//                    administration.addProduct(new Basket(Double.parseDouble(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6]))));
//                default:
//            }
//        }
//        criteria();
//    }

    public void addProducts(){
        System.out.println("Ingrese numeros de Productos");
        int productsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsNumber; i++) {
            administration.addProduct(test2());
        }
    }

//    public void addExpectedProducts(int numberExpected){
//        int productsNumber = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < productsNumber; i++) {
//            proof.add(test2());
//        }
//    }

    public Product test2() {
        Product product = null;
        try {
            String[] line = scanner.nextLine().split(" ");
            switch (line[0]) {
                case "frutas":
                    product = new EarthProducts(Double.parseDouble(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6])));
                    break;
                case "licor":
                    product = new Liquor(Double.parseDouble(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6])), Double.parseDouble(line[7]), Integer.parseInt(line[8]));
                    break;
                case "aseo":
                    product = new GroomingProducts(Integer.parseInt(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6])));
                    break;
                case "electrodomestico":
                    product = new Household(Integer.parseInt(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6])), Integer.parseInt(line[7]));
                    break;
                case "personal":
                    product = new PersonalCareProducts(Integer.parseInt(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6])));
                    break;
                case "canasta":
                    product = new Basket(Double.parseDouble(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6])));
                    break;
                default:
            }
        }catch (NullPointerException e){
            System.out.println("se ingreso un valor invalido");
            throw e;
        }
        return product;
    }


    public void testMenu(){
        System.out.println("Filtrar por: \n 1. Tipo de producto \n 2. Rango de precio \n 3. Max precio y tipo \n 4. Max precio \n 5. Min precio y tipo \n 6. Min precio \n 7. Ordenar Nombre \n 8. Buscar por nombre ");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option){
            case 1:
                System.out.println("Tipo: ");
                market.filterType(scanner.nextLine());
                break;
            case 2:
                System.out.println("Min Precio, max precio");
                market.filterRangePrices(Double.parseDouble(scanner.nextLine()),Double.parseDouble(scanner.nextLine()));
                break;
            case 3:
                System.out.println("Ingrese precio maximo y tipo ");
                market.filterMaxPrice(Double.parseDouble(scanner.nextLine()),scanner.nextLine());
                break;
            case 4:
                System.out.println("Ingrese maximo precio");
                market.filterMaxPrice(Double.parseDouble(scanner.nextLine()));
                break;
            case 5:
                System.out.println("Ingrese precio minimo y tipo ");
                market.filterLowerPrice(Double.parseDouble(scanner.nextLine()),scanner.nextLine());
                break;
            case 6:
                System.out.println("Ingrese precio minimo");
                market.filterLowerPrice(Double.parseDouble(scanner.nextLine()));
                break;
            case 7:
                System.out.println("Ordenar alfabeticamente");
                market.orderAlphabet();
                break;
            case 8:
                System.out.println("Ingrese nombre");
                market.filterName(scanner.nextLine());
                break;
            case 9:
                return;
        }
        market.showFilters();
        testMenu();
    }

    public static void main(String[] args) {
        TestMarket testMarket = new TestMarket();
        testMarket.addProducts();
        testMarket.testMenu();
    }
}
