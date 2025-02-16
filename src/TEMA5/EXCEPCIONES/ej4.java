package TEMA5.EXCEPCIONES;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ej4 {
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        Random rand=new Random();
        int[] array=new int[rand.nextInt(100)+1];
        for (int i=0;i<array.length;i++){
            int numRand= rand.nextInt(10)+1;
            array[i]=numRand;
        }

        int eleccion;
        try {
            do {
                System.out.println("Di una posicion del vector ");
                eleccion=scan.nextInt();
                System.out.println("El numero de la posicion"+eleccion+"es: "+array [eleccion-1] );
            }while(eleccion>=0);
        }catch (ArrayIndexOutOfBoundsException | InputMismatchException ex){
            System.out.println("Valor no valido");
        }

    }
}
