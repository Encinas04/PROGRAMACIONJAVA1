package POO2;

import java.util.Scanner;

public class MenuCuenta {
    public static void main(String[] args) {

        menu();


    }
    public static void menu(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Vienvenudo a caixamar, que desea hacer \n" +
                "1.Crear usuario\n" +
                "2.Crear una cuenta asociada al usuario\n" +
                "3.Mostrar datos del usuario\n" +
                "4.Recibir nomina mensual de una persona\n" +
                "5.Recibir un pago\n" +
                "6.Relaizar transferencia entre cuentas\n" +
                "7.Imprimir las personas morosas");
        int opccion= scan.nextInt();
        switch (opccion){
            case 1:
                System.out.print("Ingrese el DNI de la persona: ");
                String dni = scan.next();
                System.out.println("Usuario creado con éxito.");
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                System.out.println("Valor incorrecto");
                break;


        }
    }

}