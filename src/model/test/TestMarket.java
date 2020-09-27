package model.test;

import model.administration.Administration;
import model.products.*;
import model.supermarket.Denomination;
import model.supermarket.Market;
import model.supermarket.Quantity;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * @date 26/09/2020
 * Clase que testea la clase Market
 */
public class TestMarket {
    private Market market;
    private Administration administration;
    private Scanner scanner;

    public TestMarket() {
        scanner = new Scanner(System.in);
        market = new Market();
        administration = new Administration(market);
    }

    public void test() {
        System.out.println("Ingrese numeros de Productos");
        int productsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsNumber; i++) {
            String[] line = scanner.nextLine().split(" ");
            switch (line[0]) {
                case "frutas":
                    administration.addProduct(new EarthProducts(Double.parseDouble(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6]))));
                    break;
                case "licor":
                    administration.addProduct(new Liquor(Double.parseDouble(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6])), Double.parseDouble(line[7]), Integer.parseInt(line[8])));
                    break;
                case "aseo":
                    administration.addProduct(new GroomingProducts(Integer.parseInt(line[1]),line[2],Integer.parseInt(line[3]),Double.parseDouble(line[4]),new Quantity(Integer.parseInt(line[5]),Denomination.valueOf(line[6]))));
                    break;
                case "electrodomestico":
                    administration.addProduct(new Household(Integer.parseInt(line[1]),line[2],Integer.parseInt(line[3]),Double.parseDouble(line[4]),new Quantity(Integer.parseInt(line[5]),Denomination.valueOf(line[6])), Integer.parseInt(line[7])));
                    break;
                case "personal":
                    administration.addProduct(new PersonalCareProducts(Integer.parseInt(line[1]),line[2],Integer.parseInt(line[3]),Double.parseDouble(line[4]),new Quantity(Integer.parseInt(line[5]),Denomination.valueOf(line[6]))));
                    break;
                case "canasta":
                    administration.addProduct(new Basket(Double.parseDouble(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6]))));
                default:
            }
        }
        criteria();
    }

    public void criteria(){
        market.filterType("canasta");
        System.out.println("======filtro======");
        market.showFilters();
        System.out.println("======filtro======");
        market.filterRangePrices(0,250000);
        market.showFilters();
        System.out.println("======filtro======");
        market.filterMaxPrice(800,"licor");
        market.showFilters();
        System.out.println("=============================");
        market.show();
    }

    public static void main(String[] args) {
        new TestMarket().test();
    }
}
