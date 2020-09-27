package model.test;

import model.administration.Administration;
import model.products.*;
import model.supermarket.Denomination;
import model.supermarket.Market;
import model.supermarket.Quantity;

import java.util.Scanner;

public class TestMarket {
    private Market market;
    private Administration administration;
    private Scanner scanner;

    public TestMarket() {
        scanner = new Scanner(System.in);
        market = new Market();
        administration = new Administration(market);
    }

    public void test2(){
        System.out.println("Ingrese numeros de Productos");
        int productsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsNumber; i++) {
            String [] line = scanner.nextLine().split(" ");
            switch (line[0]){
                case "canasta":
                    new EarthProducts(Double.parseDouble(line[1]),line[2],Integer.parseInt(line[3]),Double.parseDouble(line[4]),new Quantity(Integer.parseInt(line[5]),Denomination.valueOf(line[6])));
                break;
            }
        }

    }

    public void test(){
        administration.addProduct(new EarthProducts(1800,"fresas",1,1000,new Quantity(5, Denomination.UNITS)));
        administration.addProduct(new EarthProducts(800,"papa",1,1000,new Quantity(5, Denomination.GRAMS)));
        administration.addProduct(new Liquor(10000, "Aguardiente antioqueño", 1, 3000, new Quantity(30, Denomination.UNITS), 0.15, 40));
        administration.addProduct(new GroomingProducts(3750,"escoba",3,3000,new Quantity(5,Denomination.UNITS)));
        administration.addProduct(new Household(250000,"licuadora",2,200000, new Quantity(8,Denomination.UNITS),12));
        administration.addProduct(new PersonalCareProducts(1300,"jabon de tierra",1,750,new Quantity(15,Denomination.UNITS)));
        administration.addProduct(new Basket(3000,"pan",15,100,new Quantity(50,Denomination.UNITS)));

        market.filterType("licor");
        System.out.println("======filtro======");
        market.showFilters();
        System.out.println("======filtro======");
        market.filterRangePrices(800,15000);
        market.showFilters();
        System.out.println("======filtro======");
        market.filterMaxPrice(800,"frutas");
        market.showFilters();
    }

    public static void main(String[] args) {
        new TestMarket().test();
    }
}
