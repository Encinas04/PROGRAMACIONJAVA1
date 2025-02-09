package TEMA5.COLECCIONES;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ListaCompra {

    public static void main(String[]args){
        Set<String> lista= new HashSet<>();
        agregarProducto(lista);
        mostrarLista(lista);

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
            }else{
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
}
