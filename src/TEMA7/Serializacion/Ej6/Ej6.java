package TEMA7.Serializacion.Ej6;
import TEMA7.Serializacion.Ej4.Persona;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ej6 {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan", 30));
        personas.add(new Persona("Maria", 25));
        personas.add(new Persona("Carlos", 40));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("personas.txt"))) {
            for (Persona persona : personas) {
                writer.write(persona.toString());
                writer.newLine();
            }
            System.out.println("El ArrayList de personas ha sido serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

