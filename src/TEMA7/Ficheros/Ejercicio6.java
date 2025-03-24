package TEMA7.Ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio6 {
        public static void main(String[] args) {
            String rutaPi = "pi-million.txt";
            String piDecimales = leerArchivo(rutaPi);

            if (piDecimales == null) {
                System.out.println("Error al leer el archivo.");
                return;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce un número: ");
            String numeroBuscado = scanner.nextLine();



            boolean encontrado = buscarSecuencia(piDecimales, numeroBuscado);

            if (encontrado) {
                System.out.println("El número " + numeroBuscado + " aparece en los primeros 1M de decimales de π.");
            } else {
                System.out.println("El número " + numeroBuscado + " NO aparece en los primeros 1M de decimales de π.");
            }
        }


        private static String leerArchivo(String ruta) {
            String piDecimales = "";
            try (BufferedReader br = new BufferedReader(new FileReader("Documentos/"+ruta))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    piDecimales += linea.trim();
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
                return null;
            }
            return piDecimales;
        }

    private static boolean buscarSecuencia(String piDecimales, String numeroBuscado) {
        int n = piDecimales.length();
        int m = numeroBuscado.length();

        for (int i = 0; i <= n - m; i++) {
            boolean coincidencia = true;

            for (int j = 0; j < m; j++) {
                if (piDecimales.charAt(i + j) != numeroBuscado.charAt(j)) {
                    coincidencia = false;
                }
            }
            if (coincidencia) {
                return true;
            }
        }
        return false;
    }
}
