package views;

import com.sun.org.apache.regexp.internal.RE;

import model.supermarket.Denomination;

import javax.swing.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

/**
 * @author Martin Santiago Chiquillo Castro
 * @author Julian Alberto Ardila Arguello
 * @author Andres Leonardo Amaya Vargas
 * Date: 26/09/2020
 * Clase que permite la entrada de datos
 */
public  class IoManager{

    private Scanner input;

    /**
     * Método constructor que instancia e inicializa un objeto de tipo Scanner
     */
    public IoManager() {
        input = new Scanner(System.in);
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
        System.out.println("Filtrar por: \n 1. Tipo de producto \n 2. Rango de precio \n 3. Max precio y tipo \n 4. Max precio \n 5. Min precio y tipo \n 6. Min precio \n 7. Extraer toda la lista \n 8. Buscar por nombre \n 9. generar factura");
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

    /**
     * Metodo que pide el nombre apra agregar un nuevo producto
     * @return nombre del nuevo producto que se agregara
     */
    public String nameForProduct(){
        System.out.println("Ingrese el nombre que le dara al nuevo producto : ");
        return input.nextLine();
    }

    /**
     * Metodo que pide el precio que se asiganra al producto
     * @return precio del nuevo producto
     */
    public double priceForProduct(){
        System.out.println("Ingrese el precio para el producto :");
        return Double.parseDouble(input.nextLine());
    }

    /**
     * Metodo que pide por cuantas unidades se vendera el nuevo producto
     * @return cantidad por la que se vendera el producto
     */
    public int numberOfSold(){
        System.out.println("Por cuantas unidades se vendera el producto");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que pide cuantas unidades tendra en principo el producto
     * @return cantidad unidadex
     */
    public int getUnits(){
        System.out.println("Ingrese cuanto habra disponible inicialmente en el inventario");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que regresa la denominacion por la que se deseen vender los productos
     * @return denominacion del producto a ingresar
     */
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

    /**
     * Metodo que pide a que precio se le comprara el producto
     * @return precio al que s ecomprara el producto
     */
    public double priceOfProviderForProduct(){
        System.out.println("Ingrese el precio al que se le comprara al proveedor");
        return Double.parseDouble(input.nextLine());
    }

    /**
     * Metodo que pide los meses de garantia para electrodomesticos
     * @return numer de meses de garantia
     */
    public int mothsOfGaranty(){
        System.out.println("Cuantos mese de garantia tendra el electrodomestico");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que pide el grado de alcohol par los licores
     * @return grados del alcohol de los licores
     */
    public int gradesForLiquor(){
        System.out.println("Ingrese que procentaje de alcohol tiene");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que pide el nombre del usuario al loguearse
     * @return nombre del usuario
     */
    public String nameUser(){
        System.out.println("Ingrese su nombre");
        return input.nextLine();
    }

    /**
     * Metodo que pide el id del usuario al loguearse
     * @return id de la persona
     */
    public String idUser(){
        System.out.println("Ingrese su documneto");
        return input.nextLine();
    }

    /**
     * Metodo que pide el año en el que nacio del usuario al loguearse
     * @return año en el que nacio el usuario
     */
    public int yearUser(){
        System.out.println("Ingrese el año en el que nacio :");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que pide el mes del año en el que nacio usuario al loguearse
     * @return mes del año en el que nacio el usuario
     */
    public int monthForYear(){
        System.out.println("Ingrese el numero del mes en el que nacio");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que pide el dia del año en el que nacio el usuario al loguearse
     * @return dia del año
     */
    public int dayOfyear(){
        System.out.println("Ingrese el dia el mes en el que nacio");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que pide el impuesto al licor
     * @return imnpuesto al licor
     */
    public double taxForLiquiour(){
        System.out.println("Ingrese el procentaje de imuesto al licor");
        return Double.parseDouble(input.nextLine());
    }

    /**
     * Metodo que pide al usuario el indice del producto que desee comprar
     * @return indice en una lista que le aparecera en pantalla
     */
    public int getIndexOfProduct(){
        System.out.println("Ingrese el numero del producto que desea agregar, los que se encuentran a la izquierda de cada producto");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que pide al usuaro la cantidad que comprara de cada producto respecto a su denominacion
     * @return cantidad que el usuario comprara
     */
    public int getQuantityForBuy(){
        System.out.println("Ingrese la cantidad de gramos o unidades que comprara, tengo en cuenta la cantidad disponible que aparece a la derecha");
        return Integer.parseInt(input.nextLine());
    }

    /**
     * Metodo que pide un nombre al usuario que le permitira filtrar
     * @return nombre para filtar
     */
    public String nameForFilter(){
        System.out.println("Ingrese nombre del producto por el que desee filtrar");
        return input.nextLine();
    }

    /**
     * Metodo que pide al usuario un precio de referencia maximo que desee pagar
     * @return precio maximo que desee pagar
     */
    public double maxPrice(){
        System.out.println("Ingrese el valor maximo que desee pagar");
        return Double.parseDouble(input.nextLine());
    }

    /**
     * Metodo que pide al usuario un precio de referencia minimo que desee pagar
     * @return precio minimo que desee pagar
     */
    public double minPrice(){
        System.out.println("Ingrese el valor minimo que desee pagar");
        return Double.parseDouble(input.nextLine());
    }

    /**
     * Metodo que regresa los tipos de producto para filtrar
     * @return tipos de producto
     */
    public String typeForFilter(){
        System.out.println("Porque tipo de prodcuto desea filtrar :");
        System.out.println(" 1. canasta(comida)\n 2. Licores \n 3. Aseo para hogar\n 4. Aseo personal \n 5. Electrodomesticos \n 6. Productos del agro");
        int option = Integer.parseInt(input.nextLine());
        String election = "";
        switch (option){
            case 1:
                election = "CANASTA";
                break;
            case 2:
                election = "LICOR";
                break;
            case 3:
                election = "ASEO";
                break;
            case 4:
                election = "PERSONAL";
                break;
            case 5:
                election = "ELECTRODOMESTICO";
                break;
            case 6:
                election = "FRUTAS";
                break;
            default:
                election = "CANASTA";
                break;
        }
        return election;
    }

    /**
     * Metodo que imprime el menu de opciones de compra
     * @return entero con la eleccion de usuario
     */
    public int buyMenu(){
        System.out.println("Desea comprar algo:\n 1.Comprar un producto\n 2.Filtrar por otro producto \n 3. generar factura y salir");
        return Integer.parseInt(input.nextLine());
    }
}


