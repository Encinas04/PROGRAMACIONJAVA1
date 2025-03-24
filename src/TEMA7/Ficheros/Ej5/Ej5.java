package TEMA7.Ficheros.Ej5;
import java.io.*;
import java.util.*;

public class Ej5 {
    public static void main(String[] args) {
        String rutaDiccionario = "diccionario.txt";
        String carpetaDiccionario = "Diccionario";

        File carpeta = new File(carpetaDiccionario);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        Map<Character, List<String>> palabrasPorLetra = new HashMap<>();
        for (char letra = 'A'; letra <= 'Z'; letra++) {
            palabrasPorLetra.put(letra, new ArrayList<>());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(rutaDiccionario))) {
            String palabra;
            while ((palabra = br.readLine()) != null) {
                palabra = palabra.trim();
                if (!palabra.isEmpty()) {
                    char primeraLetra = Character.toUpperCase(palabra.charAt(0));
                    if (palabrasPorLetra.containsKey(primeraLetra)) {
                        palabrasPorLetra.get(primeraLetra).add(palabra);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el diccionario: " + e.getMessage());
        }

        for (char letra = 'A'; letra <= 'Z'; letra++) {
            File archivoLetra = new File(carpetaDiccionario + "/" + letra + ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoLetra))) {
                for (String palabra : palabrasPorLetra.get(letra)) {
                    writer.write(palabra);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error al escribir en " + letra + ".txt: " + e.getMessage());
            }
        }

        System.out.println("Diccionario organizado con éxito en la carpeta '" + carpetaDiccionario + "'.");
    }
}