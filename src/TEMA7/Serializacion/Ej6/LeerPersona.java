package TEMA7.Serializacion.Ej6;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LeerPersona {
    public static void main(String[] args) {

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("personas.dat"))) {
            ArrayList<Persona> listaPersonas = (ArrayList<Persona>) entrada.readObject();

            System.out.println("Datos de las personas:");
            for (Persona persona : listaPersonas) {
                System.out.println(persona);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
