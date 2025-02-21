package TEMA5.COLECCIONES.GIMNASIO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainGym {
    static Map<String, Usuario> infoUsuario= new HashMap<>();

    public static void main(String[]args){
        Scanner scanner= new Scanner(System.in);
        menu();
    }
    public static void menu() {
        Scanner scanner= new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Gestión de Usuarios del Gimnasio ---");
            System.out.println("1. Dar de alta usuario");
            System.out.println("2. Dar de baja usuario");
            System.out.println("3. Mostrar usuario");
            System.out.println("4. Modificar usuario");
            System.out.println("5. Mostrar todos los usuarios");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();


            switch (opcion) {
                case 1:
                    darAltaUsuario();
                    break;
                case 2:
                    darBajaUsuario();
                    break;
                case 3:
                    mostrarUsuario();
                    break;
                case 4:
                    modificarUsuario();
                    break;
                case 5:
                    //mostrarUsuarios();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 6);
    }
    public static void darAltaUsuario(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese el dni: ");
        String dni= scanner.next();
        if (infoUsuario.containsKey(dni)){
            System.out.println("Este usuario ya existe");
        }else{
            System.out.println("Ingrese el nombre de usuario: ");
            String nombre= scanner.next();
            System.out.println("Ingrese la edad:");
            int edad= scanner.nextInt();
            infoUsuario.put(dni, new Usuario(nombre,edad));
            System.out.println("Cuenta creada con exito.");
        }
    }
    public static void darBajaUsuario(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese el dni: ");
        String dni= scanner.next();
        if (infoUsuario.containsKey(dni)){
            infoUsuario.remove(dni);
        }else{
            System.out.println("Esta cuenta no existe.");
        }
    }
    public static void mostrarUsuario(){
        Scanner scan= new Scanner(System.in);
        System.out.println("Ingrese el dni del usuario: ");
        String dni= scan.next();
        if (infoUsuario.containsKey(dni)){
            System.out.println(infoUsuario.get(dni));
        }else{
            System.out.println("Este usuario no existe");
        }

    }

    public static void modificarUsuario(){
        Scanner scan= new Scanner(System.in);
        System.out.println("Ingrese el dni para cambiar la cuenta:");
        String dni= scan.next();

        if (infoUsuario.containsKey(dni)){
            Usuario user=infoUsuario.get(dni);
            System.out.println("Seleccione la nueva edad");
            int edad= scan.nextInt();
            user.setEdad(edad);
            System.out.println("Seleccione la nueva nombre");
            String nombre= scan.next();
            user.setNombre(nombre);
        }else{
            System.out.println("Este usuario no existe");
        }
    }



}
