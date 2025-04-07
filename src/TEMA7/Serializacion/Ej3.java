package TEMA7.Serializacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej3 {
    public static void main(String[] args) {
        String nombreArchivo = "usuario.txt";
        int contadorPalabras = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en palabras usando espacios en blanco
                String[] palabras = linea.trim().split("\\s+");
                contadorPalabras += palabras.length;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Número total de palabras: " + contadorPalabras);
    }
}

