package TEMA5.EXCEPCIONES;

public class MainGato {
    public static void main(String[] args) {
        Gato gato1 = null;
        Gato gato2 = null;
        Gato gato3 = null;

        try {
            gato1 = new Gato("Michi", -3);
            System.out.println("Gato1: Nombre = " + gato1.getNombre() + ", Edad = " + gato1.getEdad());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear Gato1: " + e.getMessage());
        }

        try {
            gato2 = new Gato("X", 5);
            System.out.println("Gato2: Nombre = " + gato2.getNombre() + ", Edad = " + gato2.getEdad());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear Gato2: " + e.getMessage());
        }

        try {
            gato3 = new Gato("Leo", -2);
            System.out.println("Gato3: Nombre = " + gato3.getNombre() + ", Edad = " + gato3.getEdad());
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear Gato3: " + e.getMessage());
        }

        if (gato1 != null) {
            try {
                gato1.setNombre("Felix");
                gato1.setEdad(4);
                System.out.println("Gato1 actualizado: Nombre = " + gato1.getNombre() + ", Edad = " + gato1.getEdad());
            } catch (IllegalArgumentException e) {
                System.out.println("Error al modificar Gato1: " + e.getMessage());
            }
        }

        if (gato2 != null) {
            try {
                gato2.setNombre("A");
            } catch (IllegalArgumentException e) {
                System.out.println("Error al modificar Gato2: " + e.getMessage());
            }
        }
    }
}
