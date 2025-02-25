package TEMA5.POO3.Ej6;

public class AtaqueMagico implements Ataque {
    private double costeMagico;
    private double danyoMagico;

    public AtaqueMagico(double costeMagico, double danyoMagico) {
        this.costeMagico = costeMagico;
        this.danyoMagico = danyoMagico;
    }


    @Override
    public void lanzar() {
        System.out.println("Lanzando un ataque mágico...");
    }

    @Override
    public void coste() {
        System.out.println("Coste del ataque mágico: " + costeMagico);
    }

    @Override
    public void danyoInflingido() {
        System.out.println("Daño infligido por ataque mágico: " + danyoMagico);
    }
}
