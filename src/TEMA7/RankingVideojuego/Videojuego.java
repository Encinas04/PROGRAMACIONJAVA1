package TEMA7.RankingVideojuego;

import java.io.Serializable;

public abstract class Videojuego implements Serializable {
    private String titulo;
    private String plataforma;
    private int nota;

    public Videojuego(String titulo, String plataforma, int nota) throws NotaInvalidaException {
        if (nota < 1 || nota > 10) {
            throw new NotaInvalidaException("La nota debe estar entre 1 y 10.");
        }
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "Título: " + titulo + ", Plataforma: " + plataforma + ", Nota: " + nota;
    }
}
