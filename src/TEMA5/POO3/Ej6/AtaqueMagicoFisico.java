package TEMA5.POO3.Ej6;

public class AtaqueMagicoFisico implements Ataque {
    private double costeMagico;
    private double costeFisico;
    private double danyoMagico;
    private double danyoFisico;

    public AtaqueMagicoFisico(double costeMagico, double costeFisico, double danyoMagico, double danyoFisico) {
        this.costeMagico = costeMagico;
        this.costeFisico = costeFisico;
        this.danyoMagico = danyoMagico;
        this.danyoFisico = danyoFisico;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando un ataque mágico y físico...");
    }

    @Override
    public void coste() {
        System.out.println("Coste del ataque mágico y físico: " + (costeMagico + costeFisico));
    }

    @Override
    public void danyoInflingido() {
        System.out.println("Daño infligido por ataque mágico y físico: " + (danyoMagico + danyoFisico));

    }
}
