package TEMA5.POO3.Ej4;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de Ficha
        DVD dvd = new DVD(1, "Inception", "Christopher Nolan", 2010, "Ciencia Ficción");
        Libros libro = new Libros(2, "1984", "George Orwell", "Secker and Warburg");
        Revistas revista = new Revistas(3, "National Geographic", 250, 2021);

        // Imprimir información de cada objeto
        System.out.println("DVD:");
        System.out.println("Número: " + dvd.getNumero());
        System.out.println("Título: " + dvd.getTitulo());
        System.out.println("Director: " + dvd.getDirector());
        System.out.println("Año: " + dvd.getAño());
        System.out.println("Tipo: " + dvd.tipo);

        System.out.println("\nLibro:");
        System.out.println("Número: " + libro.getNumero());
        System.out.println("Título: " + libro.getTitulo());
        System.out.println("Autor: " + libro.getAutor());
        System.out.println("Editorial: " + libro.getEditorial());

        System.out.println("\nRevista:");
        System.out.println("Número: " + revista.getNumero());
        System.out.println("Título: " + revista.getTitulo());
        System.out.println("Número de Publicación: " + revista.getNumeroPubli());
        System.out.println("Año: " + revista.getAño());
    }
}

