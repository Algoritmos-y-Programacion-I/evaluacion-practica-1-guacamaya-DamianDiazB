package ui;

import java.util.Scanner;

public class Guacamaya {

    // Scanner global para todo el programa
    public static Scanner reader;
    // Arreglos de precios y unidades para todo el programa
    public static double[] precios;
    public static int[] unidades;
    public static int referencias;
    public static int total;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);
        int referencias = 0;

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a Guacamaya!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada referencia de producto vendida en el dia");
            System.out.println("2. Calcular la cantidad total de unidades vendidas en el dia");
            System.out.println("3. Calcular el precio promedio de las referencias de producto vendidas en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de unidades vendidas en el dia fue de: "+calcularTotalUnidadesVendidas());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de las referencias de producto vendidas en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpcion invalida, intenta nuevamente.");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de referencias de producto diferentes 
     * vendidas en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de referencias de producto diferentes vendidas en el dia ");
        referencias = reader.nextInt();

        precios = new double[referencias];
        unidades = new int[referencias];

        

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de de unidades segun la refrencia y el precio del mismo
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades son llenados
     */
    public static void solicitarDatos(){


        for(int i = 0; i < precios.length; i++) {
            System.out.println("Digite el precio de la unidad " +(i+1));
            double precio = reader.nextDouble();
            precios[i] = precio;
            
        }

        for(int o = 0; o < unidades.length; o++) {
                System.out.println("Digite el numero de unidades vendidas de la unidad " +(o+1));
                int unidad = reader.nextInt();
                unidades[o] = unidad;
        }
    }

    /**
     * Descripcion: Este metodo se encarga de calcular el total de unidades vendidas
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar llenados
     * pos: Da el total de unidades vendidas
     * @return: int, total de unidades vendidas
     */
    public static int calcularTotalUnidadesVendidas(){
        int total = 0;
        for (int i = 0; i < unidades.length; i++) {
            System.out.println(unidades[i]);
            total += unidades[i];
        }
        return total;
    }

    /**
     * Descripcion: Este metodo se encarga de calcular el precio promedio 
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Da el promedio de los precios
     * @return: double, promedio de precios de las unidades vendidas
     */
    public static double calcularPrecioPromedio(){
		double promedio = 0.0, totalPrecios = 0.0;
		for(int i = 0; i < precios.length; i++) {
            totalPrecios += precios[i];
            promedio = totalPrecios /= precios.length;
        }
        return promedio;
    }

    /**
     * Descripcion: Este metodo se encarga de calcular el precio promedio 
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Da el totasl de lo vendido en el proceso
     * @return: double, ventas totales
     */
    public static double calcularVentasTotales(){

        double total = 0;
        for (int i = 0; i < unidades.length; i++) {
            total += precios[i] * unidades[i];
        }
        return total;

    }
}
