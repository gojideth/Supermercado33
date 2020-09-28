package model.test;

import model.administration.Administration;
import model.products.*;
import model.supermarket.*;

import java.time.LocalDate;
import java.util.List;
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
    private GetDataConsole getDataConsole;
    private Scanner scanner;

    /**
     * Constructor que instancia los atributos de la clase
     */
    public TestClient() {
        market = new Market();
        admin = new Administration(market);
        scanner = new Scanner(System.in);
        getDataConsole = new GetDataConsole();
    }

    /**
<<<<<<< HEAD
     * Metodo encargado de tomar los datos para la creacion de Usuarios
=======
     * Metodo que agrega clientes
>>>>>>> 7532d502dedb5487cf340c4c17102599bf2c7143
     */
    public void addClients(){
        System.out.println("agregar datos de cliente ");
        String[] dates = scanner.nextLine().split(" ");
        client = new Client(dates[0], LocalDate.of(Integer.parseInt(dates[1]), Integer.parseInt(dates[2]), Integer.parseInt(dates[3])), dates[4], Charge.valueOf(dates[5]), new Bill(LocalDate.now()), market);
    }


    public void showMenuFiltres() {
        System.out.println("Filtrar por: \n 1. Tipo de producto \n 2. Rango de precio \n 3. Max precio y tipo \n 4. Max precio \n 5. Min precio y tipo \n 6. Min precio \n 7. Ordenar Nombre \n 8. Buscar por nombre ");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1:
                System.out.println("Tipo: ");
                client.filterName(scanner.nextLine());
                System.out.println("entro");
                break;
            case 2:
                System.out.println("Min Precio, max precio");
                client.filterRangePrices(Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()));
                client.showCar();
                System.out.println(client.getCar().size());
                break;
            case 3:
                System.out.println("Ingrese precio Minimo a pagar y tipo ");
                client.filterMaxPrice(Double.parseDouble(scanner.nextLine()), scanner.nextLine());
                break;
            case 4:
                System.out.println("Ingrese precio Minimo a pagar");
                client.filterMaxPrice(Double.parseDouble(scanner.nextLine()));
                break;
            case 5:
                System.out.println("Ingrese precio Maximo a pagar y tipo ");
                client.filterLowerPrice(Double.parseDouble(scanner.nextLine()), scanner.nextLine());
                break;
            case 6:
                System.out.println("Ingrese precio Maximo a pagar");
                client.filterLowerPrice(Double.parseDouble(scanner.nextLine()));
                break;
            case 7:
                showMarket();
                System.out.println("Ordenar alfabeticamente");
                client.orderAlphabet();
                showMarket();
                System.out.println(client.getCar().size());
                break;
            case 8:
                System.out.println("Ingrese nombre");
                client.filterName(scanner.nextLine());
                break;
            case 9:
                return;
        }
    }

    public void addProductsToCar(){
        int numberbuys = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberbuys; i++) {
            String [] dates = scanner.nextLine().split(" ");
        }
    }

    public void testMenu(){
        addClients();
        addProducts();
        System.out.println("Metodos Usuarios: \n 1. Seleccionar metodo de filtrado");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option){
            case 1:
                showMenuFiltres();
                break;
        }
    }

    public void showMarket(){
        for (int i = 0; i < market.products.size(); i++) {
            System.out.println(market.products.get(i).getName());
        }
    }

    public void addProducts(){
        System.out.println("Ingrese numeros de Productos");
        int productsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsNumber; i++) {
            admin.addProduct(test2());
        }
    }

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

    public static void main(String[] args) {
        TestClient testClient = new TestClient();
        testClient.testMenu();
    }
}
