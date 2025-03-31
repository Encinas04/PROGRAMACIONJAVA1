package TEMA7.Funkos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainFunko {
    private static Map<String, Funko> funkos=new HashMap<>();

    public static void main(String[]args){
        String ruta="funkos.csv";
        cargarFunkos(ruta);
        menu();
    }
    public static void cargarFunkos(String ruta){
        try{
            BufferedReader br=new BufferedReader(new FileReader(ruta));
            String linea;
            br.readLine();
            while((linea=br.readLine())!=null){
                String[] datos=linea.split(",");
                if (datos.length==5){
                    String codigo = datos[0];
                    String nombre = datos[1];
                    String modelo = datos[2];
                    double precio = Double.parseDouble(datos[4]);
                    String fecha = datos[4];
                    Funko funko=new Funko(codigo,nombre,modelo,precio,fecha);
                    funkos.put(codigo, funko);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void menu(){
        Scanner scanner=new Scanner(System.in);
        String ruta="funkos.csv";
        boolean acabar=false;
        while (!acabar) {
            System.out.println("1. Añadir Funko");
            System.out.println("2. Borrar funko");
            System.out.println("3. Mostrar todos los funkos");
            System.out.print("4. Mostrar el funko más caro");
            System.out.print("5. Mostrar media de precio de los funkos");
            System.out.print("6. Mostrar los funkos agrupados por modelos ");
            System.out.print("7. Mostrar los funkos de 2023 ");
            System.out.print("8. Salir");


            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    anyadirFunko();
                    break;
                case 2:

                    break;
                case 3:

                    return;
                case 4:
                    return;
                case 5:
                    return;
                case 6:
                    return;
                case 7:
                    return;
                case 8:
                    acabar=true;
                    return;



                default:
                    System.out.println("Opción no válida");
            }
        }
    }
    public static void anyadirFunko(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Inserte el codigo");
        String codigo = scan.nextLine();
        System.out.println("Inserte el nombre del funko");
        String nombre =scan.next() ;
        System.out.println("Inserte el modelo");
        String modelo = scan.next();
        System.out.println("Inserte el precio");
        double precio = scan.nextDouble();
        System.out.println("Inserte la fecha");
        String fecha = scan.next();
        Funko funko=new Funko(codigo, nombre,modelo,precio,fecha);
        funkos.put(codigo,funko);
        guardarFunkos(funko);
    }
    public static void guardarFunkos(Funko funko) {
        String ruta="funkos.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
            bw.write(funko.getNombre() + "," + funko.getModelo() + "," + funko.getFecha() + "," + funko.getPrecio() + "," + funko.getCodigo());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al agregar el Funko al archivo CSV: " + e.getMessage());
        }
    }
}
