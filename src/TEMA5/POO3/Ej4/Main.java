package TEMA5.POO3.Ej4;

public class Main {
        public static void main(String[] args) {
            Ficha libro = new Libros(1, "El principito", "Antoine de Saint-Exupéry", "Sudamericana");
            Ficha revista = new Revistas(2, "National Geographic", 305, 2024);
            Ficha dvd = new DVD(3, "Interstellar", "Christopher Nolan", 2014, "Ciencia Ficción");

            libro.mostrarInformacion();
            System.out.println();
            revista.mostrarInformacion();
            System.out.println();
            dvd.mostrarInformacion();
        }
}
