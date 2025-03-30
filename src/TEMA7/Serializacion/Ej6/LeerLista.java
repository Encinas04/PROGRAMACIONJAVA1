package TEMA7.Serializacion.Ej6;
import TEMA7.Serializacion.Ej4.Persona;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerLista {
    public static void main(String[] args) {
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("personas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                Persona persona = new Persona(datos[0], Integer.parseInt(datos[1]));
                listaPersonas.add(persona);
            }

            System.out.println("Lista de personas deserializada:");
            for (Persona persona : listaPersonas) {
                System.out.println(persona);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
