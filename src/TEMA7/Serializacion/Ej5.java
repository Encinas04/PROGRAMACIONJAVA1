package TEMA7.Serializacion;
import TEMA7.Serializacion.Ej4.Persona;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ej5 {
    public static void main(String[] args) {

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("persona.dat"))) {
            Persona persona = (Persona) entrada.readObject();
            System.out.println("Datos de la persona:");
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Edad: " + persona.getEdad());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el objeto: " + e.getMessage());
        }
    }
}
