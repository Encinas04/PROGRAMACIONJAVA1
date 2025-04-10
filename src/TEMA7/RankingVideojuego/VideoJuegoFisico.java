package TEMA7.RankingVideojuego;

public class VideoJuegoFisico extends Videojuego{
    private String tiendaCompra;
    private String estado;

    public VideoJuegoFisico(String titulo, String plataforma, int nota) {
        super(titulo, plataforma, nota);
        this.tiendaCompra = tiendaCompra;
        this.estado = estado;
    }
   public String getTipo(){
        return "Fisico";
   }
    public String toString() {
        return super.toString() + ", Tienda Compra: " + tiendaCompra + ", Estado: " + estado;
    }
}
