package TEMA5.POO3.Ej6;

public class AtaqueFisico implements Ataque{
    private double costeFisico;
    private double danyoFisico;

    public AtaqueFisico(double costeFisico, double danyoFisico) {
        this.costeFisico = costeFisico;
        this.danyoFisico = danyoFisico;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando un ataque físico...");
    }

    @Override
    public void coste() {
        System.out.println("Coste del ataque físico: " + costeFisico);
    }

    @Override
    public void danyoInflingido() {
        System.out.println("Daño infligido por ataque físico: " + danyoFisico);
    }
}
