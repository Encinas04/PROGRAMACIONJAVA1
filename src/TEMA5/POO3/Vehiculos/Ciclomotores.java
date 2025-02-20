package TEMA5.POO3.Vehiculos;

public class Ciclomotores extends Vehiculo {
    private double cilindrada;

    public Ciclomotores(int puertas, String color, String combustible, double cilindrada) {
        super(puertas, color, combustible);
        this.cilindrada = cilindrada;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public boolean necesitaCarnet() {
        return cilindrada >= 125;
    }
}
