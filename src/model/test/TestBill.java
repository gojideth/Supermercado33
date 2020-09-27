package model.test;

import model.products.*;
import model.supermarket.*;
import model.administration.*;

import java.time.LocalDate;
import java.util.Scanner;

public class TestBill {
    Market super33 = new Market();
    Scanner scanner = new Scanner(System.in);
    Administration administration = new Administration(super33);
    Bill bill = new Bill(LocalDate.now());
    Client client = new Client("Miguel", LocalDate.of(2001,12,21), "10005784121", Charge.USER, bill, super33);

    public void addProducts(){
        System.out.println("Ingrese numeros de Productos");
        int productsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsNumber; i++) {
            administration.addProduct(test2());
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

    public void buyClient(){
        client.getAllProducts();
        client.showCar();
        client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        client.showCar();
        client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        client.showCar();
        client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        client.showCar();
        client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        client.showCar();
        client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        client.showCar();
        client.buy(Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
        client.generateBill();
    }

    public static void main(String[] args) {
        TestBill testBill = new TestBill();
        testBill.addProducts();
        testBill.buyClient();
    }
}
