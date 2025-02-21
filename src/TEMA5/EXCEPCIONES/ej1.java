package TEMA5.EXCEPCIONES;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ej1 {
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Escriba el numero:");
        int numero=0;
        try {
            numero=scan.nextInt();
            System.out.println("hola");
        }catch (InputMismatchException ex){
            System.out.println("Valor introducido incorrecto");
            System.out.println(ex.getMessage());
            numero=-1;
        }finally {
            System.out.println("El numero es: "+numero);
        }

    }
}
