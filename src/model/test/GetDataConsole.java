package model.test;

import model.administration.Administration;
import model.products.*;
import model.supermarket.Denomination;
import model.supermarket.Market;
import model.supermarket.Product;
import model.supermarket.Quantity;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * Date: 26/09/2020
 * Clase que permite interactuar con los datos de entrada
 */
public class GetDataConsole {
    private Administration admin;
    private Market market;
    private Scanner scanner;
    private List<Product> expectedProducts;

    /**
     * Constructor que instancia los diferentes atributos de la clase
     */
    public GetDataConsole() {
        scanner = new Scanner(System.in);
        market = new Market();
        admin = new Administration(market);
        expectedProducts = new LinkedList<>();
    }
    /**
     * Metodo que agrega los productos a la lista del supermercado
     */
    public void addProducts(){
        System.out.println("Ingrese numeros de Productos");
        int productsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsNumber; i++) {
            admin.addProduct(test());
        }
    }
    /**
     * Metodo que comprueba una vez agregados los elementos que estos hayan sido efectivos
     * en su implementación
     */
    public void addExpectedProducts(){
        System.out.println("Ingrese valores esperados");
        int productsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsNumber; i++) {
            expectedProducts.add(test());
        }
    }
    /**
     * Metodo que comprueba si la cantidad esperada y agregada de productos es la misma
     * @return Numero de elementos agregados correctamente
     */
    public int isOk(){
        int count = 0;
        for (int i = 0; i < market.products.size(); i++) {
            for (int j = 0; j < expectedProducts.size(); j++) {
                if (market.products.get(i).getName().equals(expectedProducts.get(j).getName())){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Metodo que permite la entrada del tamaño que debe tener alguna lista
     * @return El tamaño ingresado
     */
    public int sizeExpected(){
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Metodo que prueba si los productos son agregados eficientemente
     * @return el producto agregado
     */
    public Product test() {
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

    /**
     * Metodo que muestra los filtros disponibles en el almacen
     */
    public void showFilters(){
        market.showFilters();
    }

    /**
     * Metodo que retorna lista de filtros
     * @return Lista con los filtros
     */
    public List<Product> getFilters(){
        return market.getFilters();
    }

    /**
     * Metodo que retorna lista de productos esperados
     * @return Lista con los productos
     */
    public List<Product> getExpectedProducts() {
        return expectedProducts;
    }

    public static void main(String[] args) {
        GetDataConsole getDataConsole = new GetDataConsole();
        getDataConsole.addProducts();
        getDataConsole.addExpectedProducts();
        System.out.println(getDataConsole.isOk());
    }
}
