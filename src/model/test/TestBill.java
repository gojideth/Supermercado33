package model.test;

import model.products.*;
import model.supermarket.*;
import model.administration.*;

import java.time.LocalDate;
import java.util.Scanner;
/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * Date: 26/09/2020
 * Clase que testea la clase Bill
 */
public class TestBill {
    Market super33 = new Market();
    Scanner scanner = new Scanner(System.in);
    Administration administration = new Administration(super33);
    Bill bill = new Bill(LocalDate.now());
    Client client = new Client("Miguel", LocalDate.of(2001,12,21), "10005784121", Charge.USER, bill, super33);

    /**
     * Metodo que agrega los productos al carrito
     */
    public void addProducts(){
        System.out.println("Ingrese numeros de Productos");
        int productsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsNumber; i++) {
            administration.addProduct(test());
        }
    }

    //wapoooo julian :3 
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
                    product = new Liquor(Double.parseDouble(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]), new Quantity(Integer.parseInt(line[5]), Denomination.valueOf(line[6])), Integer.parseInt(line[7]),Integer.parseInt(scanner.nextLine()));
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
     * Metodo que permite probar de que manera se prueba los productos ingresados para su factura
     */
    public void buyClient(){
        client.getAllProducts();
        System.out.println("Ingrese:\n1. para comprar\n2 Para generar su factura y pagar");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option){
            case 1:
                client.showCar();
                System.out.println("Ingrese el numero que corresponde al producto, el que se encuentra a la izquierda");
                int index = Integer.parseInt(scanner.nextLine());
                System.out.println("Ingrese la cantidad que desee llevar");
                int quantity = Integer.parseInt(scanner.nextLine());
                client.buy(index, quantity);
                break;
            case 2:
                client.generateBill();
                break;
        }
        if (option == 1)
            buyClient();
        /*client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        client.showCar();
        client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        client.showCar();
        client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        client.showCar();
        client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        client.showCar();
        client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        client.showCar();
        client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));*/
    }

    public static void main(String[] args) {
        TestBill testBill = new TestBill();
        testBill.addProducts();
        testBill.buyClient();
    }
}
