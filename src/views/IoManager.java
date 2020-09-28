package views;

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

    public int masterMenu(){
        System.out.println("1. Menu usuario\n2. Menu administrador");
        return Integer.parseInt(input.nextLine());
    }

    public int userMenu(){
        System.out.println("1. filtrar\n2.Monstrar filtro\n3.comprar\4.generar factura");
        return Integer.parseInt(input.nextLine());
    }

    public int filters(){
        return Integer.parseInt(input.nextLine());
    }

    public int adminMenu(){
        System.out.println("1. Borrar agregar producto\n2. Borrar producto\n3. Revisar inventario\n4. Revisar costo pedido\n5. Realizar pedido");
        return Integer.parseInt(input.nextLine());
    }
}


