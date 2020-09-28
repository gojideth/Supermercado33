package model.test;

import model.administration.Administration;
import model.supermarket.Bill;
import model.supermarket.Charge;
import model.supermarket.Client;
import model.supermarket.Market;

import java.time.LocalDate;
import java.util.Scanner;
/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * Date: 26/09/2020
 * Clase que testea la clase Cliente
 */
public class TestClient {
    private Market market;
    private Administration admin;
    private Client client;
    private Scanner scanner;

    /**
     * Constructor que instancia los atributos de la clase
     */
    public TestClient() {
        market = new Market();
        admin = new Administration(market);
        scanner = new Scanner(System.in);
    }

    /**
     * Metodo que agrega clientes
     */
    public void addClients(){
        System.out.println("agregar datos de cliente ");
        String[] dates = scanner.nextLine().split(" ");
        client = new Client(dates[0], LocalDate.of(Integer.parseInt(dates[1]), Integer.parseInt(dates[2]), Integer.parseInt(dates[3])), dates[4], Charge.valueOf(dates[5]), new Bill(LocalDate.now()), new Market());
        testMenu();
    }

    /**
     * Metodo que muestra el menu para elegir la manera de probar los datos ingresados
     */
    public void testMenu(){
        System.out.println("Filtrar por: \n 1. Tipo de producto \n 2. Rango de precio \n 3. Max precio y tipo \n 4. Max precio \n 5. Min precio y tipo \n 6. Min precio \n 7. Ordenar Nombre \n 8. Buscar por nombre ");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option){
            case 1:
                System.out.println("Tipo: ");
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
        //.showFilters();
        testMenu();
    }

    public static void main(String[] args) {
        new TestClient().addClients();
    }
}
