package TEMA5.POO3.Ej4;

public class Revistas extends Ficha{
    private int numeroPubli;
    private int año;

    public Revistas(int numero, String titulo, int numeroPubli, int año) {
        super(numero, titulo);
        this.numeroPubli = numeroPubli;
        this.año = año;
    }

    public int getNumeroPubli() {
        return numeroPubli;
    }

    public void setNumeroPubli(int numeroPubli) {
        this.numeroPubli = numeroPubli;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
}
