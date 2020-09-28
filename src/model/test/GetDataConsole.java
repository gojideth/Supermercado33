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

public class GetDataConsole {
    private Administration admin;
    private Market market;
    private Scanner scanner;
    private List<Product> expectedProducts;

    public GetDataConsole() {
        scanner = new Scanner(System.in);
        market = new Market();
        admin = new Administration(market);
        expectedProducts = new LinkedList<>();
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
            expectedProducts.add(test2());
        }
    }

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

    public int sizeExpected(){
        return Integer.parseInt(scanner.nextLine());
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


    public void showFilters(){
        market.showFilters();
    }

    public List<Product> getFilters(){
        return market.getFilters();
    }

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
