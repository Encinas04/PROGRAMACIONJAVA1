package TEMA7.Serializacion;
import TEMA7.Serializacion.Ej4.Persona;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej5 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("persona.txt"))) {
            String linea = reader.readLine();
            if (linea != null) {
                String[] datos = linea.split(",");
                Persona persona = new Persona(datos[0], Integer.parseInt(datos[1]));
                System.out.println("Persona leída del archivo: " + persona);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
