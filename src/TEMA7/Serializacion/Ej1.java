package TEMA7.Serializacion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[]src){
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingrese su nombre");
        String nombre= scan.next();
        System.out.println("Ingrese la edad ");
        int edad= scan.nextInt();
        try{
            FileWriter writer= new FileWriter("usuario.txt");
            writer.write("Nombre: "+nombre+"\n" +
                    "Edad: "+edad);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}