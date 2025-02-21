package TEMA5.EXCEPCIONES.ej7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MainGato {

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        ArrayList<Gato>gatos= new ArrayList<>(5);
        for (int i =0; i< 5;i++){
            String nombre="";
            int edad=0;
            boolean correto=false;
            try{
                System.out.println("Ingrese el nombre");
                nombre= scan.next();
                System.out.println("Ingrese la edad del gato: ");
                edad= scan.nextInt();
                correto=true;
                if (correto){
                    Gato gato=new Gato(nombre, edad);
                    gatos.add(gato);
                }
            }catch (Exception ex){
                System.out.println("Valor incorrecto");
                System.out.println(ex.getMessage());
                scan.next();
                correto=false;
            }

        }
        System.out.println(gatos);
    }
}
