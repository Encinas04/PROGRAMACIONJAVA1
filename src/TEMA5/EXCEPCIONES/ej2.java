package TEMA5.EXCEPCIONES;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ej2 {

    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        double num2=0;
        double num1=0;
        try {
            System.out.println("INTRODUZCA EL NUMERO:");
            num1= scan.nextDouble();
            System.out.println("INTRODUZCA EL NUMERO:");
            num2= scan.nextDouble();
        }catch (InputMismatchException ex){
            System.out.println("Valor introducido incorrecto");
            System.out.println(ex.getMessage());
        }
        double resultado=0;
        try{
            resultado=num1/num2;
        }catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("EL RESULTADO ES= "+resultado);
        }
    }


}
