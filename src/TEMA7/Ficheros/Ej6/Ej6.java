package TEMA7.Ficheros.Ej6;
import java.io.*;
import java.util.Scanner;

public class Ej6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rutaPi = "pi-million.txt";
        String piDecimales = "";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaPi))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                piDecimales += linea.trim();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        System.out.print("Ingrese el número a buscar en los primeros 1,000,000 decimales de π: ");
        String numeroBuscado = scanner.next();

        int posicion = buscarNumero(piDecimales, numeroBuscado);
        if (posicion != -1) {
            System.out.println("El número " + numeroBuscado + " aparece en la posición " + posicion + " de los decimales de π.");
        } else {
            System.out.println("El número " + numeroBuscado + " no se encontró en los primeros 1,000,000 decimales de π.");
        }
    }

    public static int buscarNumero(String pi, String numero) {
        int piLength = pi.length();
        int numLength = numero.length();

        for (int i = 0; i <= piLength - numLength; i++) {
            boolean encontrado = true;
            for (int j = 0; j < numLength; j++) {
                if (pi.charAt(i + j) != numero.charAt(j)) {
                    encontrado = false;
                    break;
                }
            }
            if (encontrado) {
                return i + 1;
            }
        }
        return -1;
    }
}