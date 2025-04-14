package TEMA7.RankingVideojuego;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class mainJuego {
    private static Scanner scanner = new Scanner(System.in);
    static ArrayList<Videojuego> juegos=new ArrayList<>();
    public static void main(String[] args) {
    menu();
    }
    public static void menu(){

        int opcion = -1;

        do {
            System.out.println("--- Ranking de Videojuegos ---");
            System.out.println("1. Añadir videojuego");
            System.out.println("2. Mostrar ranking");
            System.out.println("3. Guardar ranking");
            System.out.println("4. Cargar ranking");
            System.out.println("5. Eliminar videojuego");
            System.out.println("6. Exportar a texto");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            try{
                opcion = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
            
            scanner.nextLine();
            try {
                switch (opcion) {
                    case 1:
                        anyadirVideojuego();
                        break;
                    case 2:
                        mostrarJuegos();
                        break;
                    case 3:
                        guardarBinario();
                        break;
                    case 4:
                        cargarBinario();
                        break;
                    case 5:
                        eliminarVideojuego();
                        break;
                    case 6:
                        exportarTexto();
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
    public static void anyadirVideojuego() throws NotaInvalidaException {
        System.out.println("Que videojuego desea añadir:");

        System.out.println("Para videojuego digital pulse 1, para videojuego fisico pulse el 2");
        int videojuego= scanner.nextInt();
        switch (videojuego){
            case 1:
                System.out.println("Ingrese el titulo del videojuego digital: ");
                String titulo= scanner.next().toLowerCase();
                System.out.println("Ingrese la plataforma: ");
                String plataforma= scanner.next().toLowerCase();
                System.out.println("Ingrese la nota: ");
                int nota= scanner.nextInt();
                System.out.println("Ingrese la tienda online: ");
                String tienda= scanner.next().toLowerCase();
                System.out.println("GB de espacio1");
                double gb= scanner.nextDouble();
                VideoJuegoDigital digital=new VideoJuegoDigital(titulo,plataforma,nota,tienda,gb);
                juegos.add(digital);
                System.out.println("JUEGO AGREGADO");
                break;
            case 2:
                System.out.println("Ingrese el titulo del videojuego digital: ");
                String titulo2= scanner.next().toLowerCase();
                System.out.println("Ingrese la plataforma: ");
                String plataforma2= scanner.next().toLowerCase();
                System.out.println("Ingrese la nota: ");
                int nota2= scanner.nextInt();
                System.out.println("Ingrese la tienda: ");
                String tienda2= scanner.next().toLowerCase();
                System.out.println("Ingrese el estado del videojuego: 1 para nuevo 2 para usado");
                int estado= scanner.nextInt();
                VideoJuegoFisico fisico;
                switch (estado){
                    case 1:
                        fisico=new VideoJuegoFisico(titulo2,plataforma2,nota2, tienda2,"nuevo");
                        juegos.add(fisico);
                        System.out.println("JUEGO AGREGADO");
                        break;
                    case 2:
                        fisico=new VideoJuegoFisico(titulo2,plataforma2,nota2, tienda2,"usado");
                        juegos.add(fisico);
                        System.out.println("JUEGO AGREGADO");
                        break;
                    default:
                        System.out.println("Valor incorrecto");
                }
                break;
            default:
                System.out.println("Numero invalido");
        }

    }
    public static void mostrarJuegos(){
        for (Videojuego juego:juegos){
            System.out.println(juego.toString());
        }
    }
    public static void eliminarVideojuego() throws JuegoNoEncontradoException {
        System.out.println("Elija el videojuego que desea eliminar:");
        String juego= scanner.next().toLowerCase();
        boolean encontrado=false;
        for (Videojuego j: juegos){
            if (j.getTitulo().equals(juego)){
                juegos.remove(j);
                encontrado=true;
                System.out.println("Juego eliminado correctamente.");
            }
        }
        if (!encontrado){
            throw new JuegoNoEncontradoException("El videojuego con el título '" + juego + "' no se encontró.");
        }
    }
    public static void guardarBinario(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("juegos.dat"));
            oos.writeObject(juegos);
            System.out.println("Archivo guardado con exito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cargarBinario(){
        juegos.clear();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("juegos.dat"));
           juegos=(ArrayList<Videojuego>) ois.readObject();
            System.out.println("Juegos cargados correctamente");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void exportarTexto(){
        try{
         BufferedWriter r=new BufferedWriter(new FileWriter("archivo.txt"));
         for (Videojuego j:juegos){
             r.write(j.toString());
             r.newLine();
         }
         r.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
