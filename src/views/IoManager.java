package views;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import model.supermarket.Denomination;

import javax.swing.*;
import java.util.Scanner;

public  class IoManager{

    private Scanner input;

    /**
     * Método constructor que instancia e inicializa un objeto de tipo Scanner
     */
    public IoManager() {
        input = new Scanner(System.in);
    }

    /**
     * Método encargado de mostrar y leer opciones del menú
     * @return La opción deseada del menú
     */
    public short readMenu() {
        String menuText = "1. Adicionar Circulos\n" +
                "2. Mostrar circulos \n" +
                "3. Obtener intersecciones\n" +
                "4. Salir del menú\n";

        return readShort(menuText);
    }

    /**
     * Método que recibe una cadena de texto y la muestra
     * @param message El texto a mostrar
     */
    public void showMessage(String message) {
        System.out.print(message);
    }

    /**
     * Método que recibe un mensaje y lo muestra gráficamente
     * @param message Mensaje que se quiere mostrar
     */
    public void showMessageGUI(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Método que muestra un mensaje y lee un short
     * @param message Mensaje que se quiere mostrar
     * @return El número ingresado
     */
    public short readShort(String message) {
        this.showMessage(message);
        return input.nextShort();
    }

    /**
     * Método que muestra un mensaje y lee un short gráficamente
     * @param message Mensaje que se quiere mostrar
     * @return El número ingresado
     */
    public short readShortGUI(String message) {
        return Short.parseShort( JOptionPane.showInputDialog(message));
    }

    /**
     * Método que muestra un mensaje y lee un double
     * @param message Mensaje que se quiere mostrar
     * @return El número ingresado
     */
    public double readDouble(String message) {
        this.showMessage(message);
        return input.nextDouble();
    }

    /**
     *
     * Método que muestra un mensaje y lee un double gráficamente
     * @param message Mensaje que se quiere mostrar
     * @return El número ingresado
     */
    public double readDoubleGUI(String message) {
        return Double.parseDouble(JOptionPane.showInputDialog(message));
    }

    /**
     * Método que muestra un mensaje y lee un entero
     * @param message Mensaje que se quiere mostrar
     * @return El número ingresado
     */
    public int readIntegerGUI(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(message));
    }

    /**
     * Método que muestra un mensaje y lee texto
     * @param message Mensaje que se quiere mostrar
     * @return El texto ingresado
     */
    public String readString(String message) {
        this.showMessage(message);
        return input.next();
    }

    /**
     * Método que muestra un mensaje y lee texto gráficamente
     * @param message Mensaje que se quiere mostrar
     * @return El texto ingresado
     */
    public String readStringGUI(String message) {
        return JOptionPane.showInputDialog(message);
    }

    /**
     * Metodo que permite elegir que menu se mostrara en caso de ser usuario o administrador
     * @return Opcion elegida
     */
    public int masterMenu(){
        System.out.println("1. Menu usuario\n2. Menu administrador");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que muestra las opciones disponibles para el administrador
     * @return Opcion elegida
     */
    public int userMenu(){
        System.out.println("1. filtrar\n2.Monstrar filtro\n3.comprar\4.generar factura");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que permite elegir algun tipo de filtro
     * @return Opcion elegida
     */
    public int filters(){
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que muestra un menu con todos los filtros disponibles
     * @return La opcion elegida
     */
    public int chooseFilter(){
        System.out.println("Filtrar por: \n 1. Tipo de producto \n 2. Rango de precio \n 3. Max precio y tipo \n 4. Max precio \n 5. Min precio y tipo \n 6. Min precio \n 7. Ordenar Nombre \n 8. Buscar por nombre ");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que muestra el menu con las opciones disponibles del administrador
     * @return Opcion elegida
     */
    public int adminMenu(){
        System.out.println("1.Agregar producto\n2. Borrar producto\n3. Revisar inventario\n4. Revisar costo pedido\n5. Realizar pedido\n6. regresar al menu anterior");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que permire buscar y eliminar un producto para el administrador
     * @return Nombre del producto que se quiere eliminar
     */
    public String nameDeleteForAdmin(){
        System.out.println("Ingrese el nombre del prodcuto que borrara");
        return input.nextLine();
    }

    /**
     * Metodo que permite agregar un nuevo producto al inventario
     * @return Nombre del producto que se quiere eliminar
     */
    public String getTypeNewProduct(){
        System.out.println("Ingrese de que tipo de producto agregara : canasta, licor, electrodomestico, aseo, personal, frutas");
        return input.nextLine();
    }

    public String nameForProduct(){
        System.out.println("Ingrese el nombre que le dara al nuevo producto : ");
        return input.nextLine();
    }

    public double priceForProduct(){
        System.out.println("Ingrese el precio para el producto :");
        return Double.parseDouble(input.nextLine());
    }

    public int numberOfSold(){
        System.out.println("Por cuantas unidades se vendera el producto");
        return Integer.parseInt(input.nextLine());
    }

    public int getUnits(){
        System.out.println("Ingrese cuanto habra disponible inicialmente en el inventario");
        return Integer.parseInt(input.nextLine());
    }

    public Denomination generateDenomination(){
        System.out.println("De que denominacion sera ese producto: gramos o unidades");
        String denomination = input.nextLine().toUpperCase();
        switch (denomination){
            case "GRAMOS":
                return Denomination.GRAMS;
            case "UNIDADES":
                return Denomination.UNITS;
        }
        return Denomination.UNITS;
    }

    public double priceOfProviderForProduct(){
        System.out.println("Ingrese el precio al que se le comprara al proveedor");
        return Double.parseDouble(input.nextLine());
    }

    public int mothsOfGaranty(){
        System.out.println("Cuantos mese de garantia tendra el electrodomestico");
        return Integer.parseInt(input.nextLine());
    }

    public int gradesForLiquor(){
        System.out.println("Ingrese que procentaje de alcohol tiene");
        return Integer.parseInt(input.nextLine());
    }
}


