package TEMA5.EXCEPCIONES;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ej5 {

    public static void imprimePositivo(int p) throws Exception {
        if (p<0){
            throw new Exception("Numero negativo no permitido");
        }else {
            System.out.println("El numero positivo es: "+p);
        }
    }
    public static void imprimeNegativo(int p) throws Exception{
        if (p>=0){
            throw new Exception("Numero Positivo no permitido");
        }else {
            System.out.println("El numero negativo es: "+p);
        }
    }
    public static void main(String[]args) throws Exception {
        Scanner scan=new Scanner(System.in);
        int p=0;
        int eleccion=0;
        do {
            System.out.println("Elija lo que desea 1 para imprimir valor positivo, 2 para valor negativo y si desea salir escriba 999");
            try{
                eleccion= scan.nextInt();
            }catch (InputMismatchException ex){
                System.out.println("Valor incorrecto");
                System.out.println(ex.getMessage());
            }
            System.out.println("Escriba el numero que desea imprimir");
            try{
                p=scan.nextInt();
            }catch (InputMismatchException ex){
                System.out.println("Valor incorrecto");
                System.out.println(ex.getMessage());
            }
            try {
                switch (eleccion) {
                    case 1:
                        imprimePositivo(p);
                        break;
                    case 2:
                        imprimeNegativo(p);
                        break;
                    default:
                        System.out.println("valor incorrecto");
                }
                System.out.println("No es valido");
            }
            catch (Exception ex){
                System.out.println("Ha saltado un error");
                System.out.println(ex.getMessage());
            }
        }while(eleccion!=999);
    }


}
