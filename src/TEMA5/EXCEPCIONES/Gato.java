package TEMA5.EXCEPCIONES;

public class Gato {
    private int edad;
    private String nombre;

    public Gato(String nombre, int edad) {
        setEdad(edad);
        setNombre(nombre);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Número negativo no permitido para la edad.");
        }
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre es demasiado corto. Debe tener al menos 3 caracteres.");
        }
        this.nombre = nombre;
    }
}
