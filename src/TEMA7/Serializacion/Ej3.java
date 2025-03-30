package TEMA7.Serializacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej3 {
    public static void main(String[] args) {
        String rutaArchivo = "./Documentos/texto.txt";
        int contadorPalabras = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] palabrasLinea = linea.split("\\s+");
                    contadorPalabras += palabrasLinea.length;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Número total de palabras en el archivo: " + contadorPalabras);
    }
}
