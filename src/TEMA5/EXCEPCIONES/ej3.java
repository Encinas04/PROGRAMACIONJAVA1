package TEMA5.EXCEPCIONES;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ej3 {
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        double[] array= new double[5];
        int i=0;
       while(i<array.length){
           try{
               System.out.println("Ingrese el "+(i+1)+" numero: ");
               array[i]= scan.nextDouble();
               i++;
           }catch (InputMismatchException ex){
               System.out.println("Valor incorrecto");
               scan.next();
               System.out.println(ex.getMessage());
           }catch (IndexOutOfBoundsException ex){

           }
       }
    }
}
