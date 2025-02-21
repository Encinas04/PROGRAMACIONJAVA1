package TEMA5.COLECCIONES;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class ListaCompra {

    public static void main(String[]args){
        Set<String> lista= new HashSet<>();
        Set<String> carro= new HashSet<>();
        menu(lista,carro);
    }
    public static void menu( Set<String> lista,Set<String> carro){
        Scanner scan=new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Menú Lista de la Compra ---");
            System.out.println("1. Agregar productos a la lista de compra");
            System.out.println("2. Agregar productos al carro de la compra");
            System.out.println("3. Mostrar lista de compra");
            System.out.println("4. Mostrar carro de la compra");
            System.out.println("5. Mostrar productos pendientes por comprar");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    agregarProducto(lista);
                    break;
                case 2:
                    agregarAlCarro(lista, carro);
                    break;
                case 3:
                    mostrarLista(lista);
                    break;
                case 4:
                    mostrarLista(carro);
                    break;
                case 5:
                    mostrarPendientes(lista, carro);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 7);


    }
    public static void agregarProducto(Set <String> lista){
        String producto;
        do{
            Scanner scan= new Scanner(System.in);
            System.out.println("Si desea acabar inserte fin");
            System.out.println("Agregue el producto: ");
            producto= scan.next().toLowerCase();
            if (lista.contains(producto)){
                System.out.println("Este producto ya existe\n");
            } else if (producto.equals("fin")) {
                System.out.println("finalizando...");
            } else{
                lista.add(producto);
                System.out.println("Producto agregado existosamente");
            }
        }while(!producto.equals("fin"));


    }
    public static void mostrarLista(Set<String> lista){
        System.out.println("La lista contiene: ");
        for (String producto :lista){
            System.out.println("-"+producto);
        }
    }
    public static void agregarAlCarro(Set<String> lista,Set<String> carro){
        Scanner scan=new Scanner(System.in);
        String producto;
        System.out.println("Ingrese el producto de la lista al carro: ");
        do{
            producto= scan.next().toLowerCase();
        if (lista.contains(producto)){
            carro.add(producto);
            System.out.println("¡Producto agregado con exito!");
        }else if (producto.equals("fin")) {
            System.out.println("finalizando...");
        }else{
            System.out.println("Este producto no existe en la lista");
        }
        }while(!producto.equals("fin"));
    }
    public static void mostrarPendientes(Set<String> lista,Set<String> carro){
        Set<String> falta=new HashSet<>(lista);
        for (String producto:carro){
            if (falta.contains(producto)){
                falta.remove(producto);
            }
        }
        //lista.removeAll(carro);
        System.out.println("Falta por agregar: ");
        for (String producto:falta){

            System.out.println("-"+producto);
        }
    }
}
