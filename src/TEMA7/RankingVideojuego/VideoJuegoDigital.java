package TEMA7.RankingVideojuego;

import java.io.Serializable;

public class VideoJuegoDigital extends Videojuego implements Serializable {
    private String tiendaOnline;
    private double tamañoGB;

    public VideoJuegoDigital(String titulo, String plataforma, int nota, String tiendaOnline, double tamañoGB) {
        super(titulo, plataforma, nota);
        this.tiendaOnline = tiendaOnline;
        this.tamañoGB = tamañoGB;
    }

    public String getTiendaOnline() {
        return tiendaOnline;
    }

    public void setTiendaOnline(String tiendaOnline) {
        this.tiendaOnline = tiendaOnline;
    }

    public double getTamañoGB() {
        return tamañoGB;
    }

    public void setTamañoGB(double tamañoGB) {
        this.tamañoGB = tamañoGB;
    }

    @Override
    public String getTipo() {
        return "Digital";
    }

    @Override
    public String toString() {
        return super.toString() +
                "tiendaOnline='" + tiendaOnline + '\'' +
                ", tamañoGB=" + tamañoGB +
                '}';
    }
}
