package TEMA5.POO3.Vehiculos;

public class Turismos extends Vehiculo {
 private int numeroPlazas;
 private String tipoUso;

    public Turismos(int puertas, String color, String combustible, int numeroPlazas) {
        super(puertas, color, combustible);
        this.numeroPlazas = numeroPlazas;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public String getTipoUso() {
        return tipoUso;
    }

    public void setTipoUso(String tipoUso) {
        this.tipoUso = tipoUso;
    }

}
