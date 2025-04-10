package TEMA7.RankingVideojuego;

import java.util.Scanner;

public class mainJuego {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    menu();
    }
    public static void menu(){
        System.out.println("--- Ranking de Videojuegos ---");
        System.out.println("1. Añadir videojuego");
        System.out.println("2. Mostrar ranking");
        System.out.println("3. Guardar ranking");
        System.out.println("4. Cargar ranking");
        System.out.println("5. Eliminar videojuego");
        System.out.println("6. Exportar a texto");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
        int opcion;

        do {
            opcion = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (opcion) {
                    case 1:
                        anyadirVideojuego();
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
                    case 0:
                        System.out.println("¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
    }
    public static void anyadirVideojuego(){
        System.out.println("Que videojuego desea añadir:");
        int videojuego=0;
        System.out.println("Para videojuego digital pulse 1, para videojuego fisico pulse 0");

        if (videojuego==1){
            System.out.println("Ingrese el titulo del videojuego: ");
            String titulo= scanner.next();
            System.out.println("Ingrese la plataforma: ");
            String plataforma= scanner.next();
            System.out.println("Ingrese la nota: ");
            int nota= scanner.nextInt();
            System.out.println("Ingrese la tienda online: ");
            String tienda= scanner.next();
            double gb= scanner.nextDouble();
            VideoJuegoDigital digital=new VideoJuegoDigital(titulo,plataforma,nota,tienda,gb);

        }
    }

}
