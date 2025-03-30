package TEMA7.Serializacion.Ej4;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SerializarPersona {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 30);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("persona.txt"))) {
            writer.write(persona.toString());
            System.out.println("El objeto Persona ha sido serializado correctamente en texto.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

