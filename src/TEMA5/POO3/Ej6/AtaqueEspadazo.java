package TEMA5.POO3.Ej6;

class AtaqueEspadazo implements AtaqueAvanzado {
    private double costeEsfuerzo;
    private double danyoFisico;

    public AtaqueEspadazo(double costeEsfuerzo, double danyoFisico) {
        this.costeEsfuerzo = costeEsfuerzo;
        this.danyoFisico = danyoFisico;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando un espadazo...");
    }

    @Override
    public double coste() {
        return costeEsfuerzo;
    }

    @Override
    public double[] danyoInfligido() {
        return new double[]{0, danyoFisico};
    }
}
