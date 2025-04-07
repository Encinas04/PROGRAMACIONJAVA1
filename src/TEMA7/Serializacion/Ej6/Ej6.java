package TEMA7.Serializacion.Ej6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class Ej6 {
    public static void main(String[] args) {

        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Juan", 30));
        listaPersonas.add(new Persona("Ana", 25));
        listaPersonas.add(new Persona("Carlos", 40));

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("personas.dat"))) {
            salida.writeObject(listaPersonas);
            System.out.println("Lista de personas guardada exitosamente en personas.dat");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
