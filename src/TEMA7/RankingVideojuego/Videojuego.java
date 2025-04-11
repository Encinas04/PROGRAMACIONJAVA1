package TEMA7.RankingVideojuego;

public abstract class Videojuego  {
    private String titulo;
    private String Plataforma;
    private int nota;

    public Videojuego(String titulo, String plataforma, int nota) {
        this.titulo = titulo;
        Plataforma = plataforma;
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return Plataforma;
    }

    public void setPlataforma(String plataforma) {
        Plataforma = plataforma;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "Videojuego{" +
                "titulo='" + titulo + '\'' +
                ", Plataforma='" + Plataforma + '\'' +
                ", nota=" + nota ;
    }
}
