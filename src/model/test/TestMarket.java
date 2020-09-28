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
    private GetDataConsole getDataConsole;
    List<Product> proof;

    public TestMarket() {
        scanner = new Scanner(System.in);
        market = new Market();
        proof = new LinkedList<>();
        administration = new Administration(market);
        getDataConsole = new GetDataConsole();
    }

    /**
     * Metodo encargado de recibir los Productos que seran agreados
     * a la lista de productos en market
     */
    public void addProducts(){
        getDataConsole.addProducts();
    }

    /**
     * Metodo encargado de recibir los Productos que seran agreados
     * a la lista de valores esperados
     */
    public void addExpectedProducts(){
        getDataConsole.addExpectedProducts();
    }

    /**
     * Metodo encargado de comprobar si la lista de objetos filtrado y la de valores
     * esperado coinciden
     * @return el numero de elementos que coinciden en la lista respecto la otra
     */
    public int isOk(){
        return getDataConsole.isOk();
    }

    /**
     * Metodo encargado de dar el tamaño esperado de la lista
     * de resultados esperados
     * @return
     */
    public int sizeExpected(){
        return getDataConsole.sizeExpected();
    }

    /**
     * Metodo encargado de mostrar el menu y realizar los correspondientes
     * llamados a los metodos solicitados
     */
    public void testMenu(){
        System.out.println("Filtrar por: \n 1. Tipo de producto \n 2. Rango de precio \n 3. Max precio y tipo \n 4. Max precio \n 5. Min precio y tipo \n 6. Min precio \n 7. Ordenar Nombre \n 8. Buscar por nombre \n 9. salir ");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option){
            case 1:
                System.out.println("Tipo: ");
                market.filterType(scanner.nextLine());
                addExpectedProducts();
                System.out.println((isOk() == sizeExpected())? "Ok" : "Fail");
                break;
            case 2:
                System.out.println("Min Precio, max precio");
                market.filterRangePrices(Double.parseDouble(scanner.nextLine()),Double.parseDouble(scanner.nextLine()));
                addExpectedProducts();
                System.out.println(isOk() == Integer.parseInt(scanner.nextLine()));
                break;
            case 3:
                System.out.println("Ingrese precio Minimo a pagar y tipo ");
                market.filterMaxPrice(Double.parseDouble(scanner.nextLine()),scanner.nextLine());
                addExpectedProducts();
                System.out.println(isOk() == Integer.parseInt(scanner.nextLine()));
                break;
            case 4:
                System.out.println("Ingrese precio Minimo a pagar");
                market.filterMaxPrice(Double.parseDouble(scanner.nextLine()));
                addExpectedProducts();
                System.out.println(isOk() == Integer.parseInt(scanner.nextLine()));
                break;
            case 5:
                System.out.println("Ingrese precio Maximo a pagar y tipo ");
                market.filterLowerPrice(Double.parseDouble(scanner.nextLine()),scanner.nextLine());
                addExpectedProducts();
                System.out.println(isOk() == Integer.parseInt(scanner.nextLine()));
                break;
            case 6:
                System.out.println("Ingrese precio Maximo a pagar");
                market.filterLowerPrice(Double.parseDouble(scanner.nextLine()));
                addExpectedProducts();
                System.out.println(isOk() == Integer.parseInt(scanner.nextLine()));
                break;
            case 7:
                System.out.println("Ordenar alfabeticamente");
                market.orderAlphabet();
                addExpectedProducts();
                System.out.println(isOk() == Integer.parseInt(scanner.nextLine()));
                break;
            case 8:
                System.out.println("Ingrese nombre");
                market.filterName(scanner.nextLine());
                addExpectedProducts();
                System.out.println(isOk() == Integer.parseInt(scanner.nextLine()));
                break;
            case 9:
                return;
        }
        testMenu();
    }

    public static void main(String[] args) {
        TestMarket testMarket = new TestMarket();
        testMarket.addProducts();
        testMarket.testMenu();
    }
}
