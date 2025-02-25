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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
