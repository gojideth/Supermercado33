package model.test;

import model.administration.Administration;
import model.supermarket.*;
import model.products.*;

import javax.swing.plaf.IconUIResource;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * Date: 26/09/2020
 * Clase que testea la clase Administration
 */
public class TestAdmin {
    private Scanner scanner;
    private Administration admin;
    private Market market;
    private List<Product> proof;

    public TestAdmin() {
        scanner = new Scanner(System.in);
        market = new Market();
        admin = new Administration(market);
        proof = new LinkedList<>();
    }

    public void addProducts(){
        System.out.println("Ingrese numeros de Productos");
        int productsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsNumber; i++) {
            admin.addProduct(test2());
        }
    }

    public void addExpectedProducts(){
        System.out.println("Ingrese valores esperados");
        int productsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsNumber; i++) {
            proof.add(test2());
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

    public int isOk(){
        int count = 0;
        for (int i = 0; i < market.products.size(); i++) {
            for (int j = 0; j < proof.size(); j++) {
                if (market.products.get(i).getName().equals(proof.get(j).getName())){
                    count++;
                }
            }
        }
        return count;
    }

    public int sizeProof(){
        return proof.size();
    }

    public static void main(String[] args) {
        TestAdmin testAdmin = new TestAdmin();
        testAdmin.addProducts();
        testAdmin.addExpectedProducts();
        System.out.println(testAdmin.isOk() == testAdmin.sizeProof()? "ok" : "Fail");
    }
}
