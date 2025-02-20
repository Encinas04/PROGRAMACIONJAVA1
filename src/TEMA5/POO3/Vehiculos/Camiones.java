package TEMA5.POO3.Vehiculos;

public class Camiones extends Vehiculo {
    private double pesoMaximo;
    private boolean mercanciaPeligrosa;

    public Camiones(int puertas, String color, String combustible, double pesoMaximo, boolean mercanciaPeligrosa) {
        super(puertas, color, combustible);
        this.pesoMaximo = pesoMaximo;
        this.mercanciaPeligrosa = mercanciaPeligrosa;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public boolean isMercanciaPeligrosa() {
        return mercanciaPeligrosa;
    }

    public void setMercanciaPeligrosa(boolean mercanciaPeligrosa) {
        this.mercanciaPeligrosa = mercanciaPeligrosa;
    }

}
