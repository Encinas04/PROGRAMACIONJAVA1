package TEMA7.Serializacion.Ej4;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializarPersona {
    public static void main(String[] args) {
        Persona persona = new Persona("paco", 25);

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("persona.dat"))) {
            salida.writeObject(persona);
            System.out.println("Objeto Persona guardado exitosamente en persona.dat");
        } catch (IOException e) {
            System.out.println("Error al guardar el objeto: " + e.getMessage());
        }
    }
}

