package model.test;

import model.administration.Administration;
import model.supermarket.*;
import model.products.*;

public class TestAdmin {
    public static void main(String[] args) {
        Market superLa33 = new Market();
        Administration admin = new Administration(superLa33);
        admin.addProduct(new PersonalCareProducts(
                12000, "Today Condoms long action", 1, 8000, new Quantity(25, Denomination.UNITS)));
        admin.addProduct(new Liquor(
                10000, "Cachaza", 1, 3000, new Quantity(30, Denomination.UNITS), 0.15, 40));
        admin.addProduct(new Household(
                400000, "Lavadora 906090",1,180000, new Quantity(9, Denomination.UNITS), 6));
        admin.addProduct(new GroomingProducts(
                12000,"Mr. musculo", 1,5000, new Quantity(25,Denomination.UNITS)));
        admin.addProduct(new EarthProducts(1200,"Manzana", 1, 500, new Quantity(30000, Denomination.GRAMS)));
        superLa33.show();
        System.out.println(admin.isDeleteProduct("Manzana")?"Si se borro xD": "Nel no se encontro :c");
        superLa33.show();
    }
}
