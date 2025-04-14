package TEMA7.RankingVideojuego;

import java.io.Serializable;

public class VideoJuegoFisico extends Videojuego implements Serializable {
    private String tiendaCompra;
    private String estado;

    public VideoJuegoFisico(String titulo, String plataforma, int nota,String tiendaCompra, String estado) throws NotaInvalidaException {
        super(titulo, plataforma, nota);
        this.tiendaCompra = tiendaCompra;
        this.estado = estado;
    }

   public String getTipo(){
        return "Fisico";
   }
    @Override
    public String toString() {
        return super.toString() +
                "tiendaCompra='" + tiendaCompra + '\'' +
                ", estado=" + estado +
                '}';
    }
}
