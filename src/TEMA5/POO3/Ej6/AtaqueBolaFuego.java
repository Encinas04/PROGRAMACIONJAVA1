package TEMA5.POO3.Ej6;

public class AtaqueBolaFuego implements AtaqueAvanzado {
    private double costeMana;
    private double costeEsfuerzo;
    private double danyoMagico;

    public AtaqueBolaFuego(double costeMana, double costeEsfuerzo, double danyoMagico) {
        this.costeMana = costeMana;
        this.costeEsfuerzo = costeEsfuerzo;
        this.danyoMagico = danyoMagico;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando una bola de fuego...");
    }

    @Override
    public double coste() {
        return costeMana + costeEsfuerzo;
    }

    @Override
    public double[] danyoInfligido() {
        return new double[]{danyoMagico, 0};
    }
}