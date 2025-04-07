package TEMA7.Funkos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainFunko {
    private static Map<String, Funko> funkos = new HashMap<>();
    public static String ruta = "funkos.csv";
    public static void main(String[] args) {
        cargarFunkos(ruta);
        menu();
    }

    public static void cargarFunkos(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String codigo = datos[0];
                    String nombre = datos[1];
                    String modelo = datos[2];
                    double precio = Double.parseDouble(datos[3]);
                    String fecha = datos[4];
                    Funko funko = new Funko(codigo, nombre, modelo, precio, fecha);
                    funkos.put(codigo, funko);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void saveFunkos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.newLine();
            for (Funko funko : funkos.values()) {
                bw.write(funko.getCodigo() + "," + funko.getNombre() + "," + funko.getModelo() + "," + funko.getPrecio() + "," + funko.getFecha());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los Funkos en el archivo: " + e.getMessage());
        }
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean acabar = false;

        while (!acabar) {
            System.out.println("\nQue desea hacer:");
            System.out.println("1. Añadir Funko");
            System.out.println("2. Borrar Funko");
            System.out.println("3. Mostrar todos los Funkos");
            System.out.println("4. Mostrar el Funko más caro");
            System.out.println("5. Mostrar media de precio de los Funkos");
            System.out.println("6. Mostrar los Funkos agrupados por modelo");
            System.out.println("7. Mostrar los Funkos de 2023");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    anyadirFunko(scanner);
                    break;
                case 2:
                    borrarFunko(scanner);
                    break;
                case 3:
                    mostrarFunkos();
                    break;
                case 4:
                    funkoCaro();
                break;
                case 5:
                    mediaFunkos();
                    break;
                case 6:

                    break;
                case 7:
                    funkos2023();
                    break;
                case 8:
                    acabar = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

    }

    public static void anyadirFunko(Scanner scan) {
        System.out.println("Inserte el código:");
        String codigo = scan.nextLine();
        System.out.println("Inserte el nombre del Funko:");
        String nombre = scan.nextLine();
        System.out.println("Inserte el modelo:");
        String modelo = scan.nextLine();
        System.out.println("Inserte el precio:");
        double precio = scan.nextDouble();
        scan.nextLine();
        System.out.println("Inserte la fecha:");
        String fecha = scan.nextLine();

        Funko funko = new Funko(codigo, nombre, modelo, precio, fecha);
        funkos.put(codigo, funko);
        guardarFunkos(funko);
    }

    public static void guardarFunkos(Funko funko) {
        String ruta = "funkos.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
            bw.write(funko.getCodigo() + "," + funko.getNombre() + "," + funko.getModelo() + "," + funko.getPrecio() + "," + funko.getFecha());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al agregar el Funko al archivo CSV: " + e.getMessage());
        }
    }
    public static void borrarFunko(Scanner scan) {
        System.out.println("Ingrese el código del Funko a borrar:");
        String codigo = scan.nextLine();
        if (funkos.remove(codigo) != null) {
            System.out.println("Funko eliminado.");
            saveFunkos();
        } else {
            System.out.println("Funko no encontrado.");
        }
    }
    public static void mostrarFunkos() {
        for (Funko funko : funkos.values()) {
            System.out.println(funko);
        }
    }
    public static void funkoCaro(){
        double funkoCaro = 0;
        Funko funkoMasCaro = null;
        for (Funko funko : funkos.values()) {
            if (funko.getPrecio() > funkoCaro) {
                funkoCaro = funko.getPrecio();
                funkoMasCaro = funko;
            }
        }
        if (funkoMasCaro != null) {
            System.out.println("El Funko más caro es: " + funkoMasCaro.getNombre() + " con un precio de " + funkoMasCaro.getPrecio());
        } else {
            System.out.println("No se encontró ningún Funko.");
        }
    }
    public static void mediaFunkos(){
        double totalPrecio = 0;
        int cantidadFunkos = 0;
        for (Funko funko : funkos.values()) {
            totalPrecio += funko.getPrecio();
            cantidadFunkos++;
        }
        if (cantidadFunkos > 0) {
            double mediaPrecio = totalPrecio / cantidadFunkos;
            System.out.println("La media de precio de los Funkos es: " + mediaPrecio);
        } else {
            System.out.println("No hay Funkos disponibles.");
        }
    }

    public static void funkos2023(){
        for (Funko funko : funkos.values()) {
            if (funko.getFecha().startsWith("2023")) {
                System.out.println(funko.getNombre() + " - Precio: " + funko.getPrecio());
            }
        }
    }
    public static void separarModelo(){
        for (Funko funko: funkos.values()){
            funko.getModelo();
        }
    }
}