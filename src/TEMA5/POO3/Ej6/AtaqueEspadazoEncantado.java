package TEMA5.POO3.Ej6;

class AtaqueEspadazoEncantado implements AtaqueAvanzado {
    private double costeMana;
    private double costeEsfuerzo;
    private double danyoMagico;
    private double danyoFisico;

    public AtaqueEspadazoEncantado(double costeMana, double costeEsfuerzo, double danyoMagico, double danyoFisico) {
        this.costeMana = costeMana;
        this.costeEsfuerzo = costeEsfuerzo;
        this.danyoMagico = danyoMagico;
        this.danyoFisico = danyoFisico;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando un espadazo encantado...");
    }

    @Override
    public double coste() {
        return costeMana + costeEsfuerzo; // Devuelve el coste total en maná y esfuerzo físico
    }

    @Override
    public double[] danyoInfligido() {
        return new double[]{danyoMagico, danyoFisico}; // Devuelve el daño mágico y físico
    }
}

