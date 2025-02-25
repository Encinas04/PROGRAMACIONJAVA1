package TEMA5.POO3.Ej4;

public class DVD extends Ficha{
    private String director;
    private int año;
    public String tipo;

    public DVD(int numero, String titulo, String director, int año, String tipo) {
        super(numero, titulo);
        this.director = director;
        this.año = año;
    }
}
