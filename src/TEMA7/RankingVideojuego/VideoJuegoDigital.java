package TEMA7.RankingVideojuego;

public class VideoJuegoDigital extends Videojuego {
    private String tiendaOnline;
    private double tamañoGB;

    public VideoJuegoDigital(String titulo, String plataforma, int nota, String tiendaOnline, double tamañoGB) {
        super(titulo, plataforma, nota);
        this.tiendaOnline = tiendaOnline;
        this.tamañoGB = tamañoGB;
    }

    @Override
    public String getTipo() {
        return "Digital";
    }

    @Override
    public String toString() {
        return super.toString() + ", Tienda Online: " + tiendaOnline + ", Tamaño: " + tamañoGB + " GB";
    }
}
