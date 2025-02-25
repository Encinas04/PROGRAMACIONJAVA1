package TEMA5.POO3.Animales;

public class Gato extends Animal {
    private String raza;

    public Gato(int edad, double peso, String raza, String nombre) {
        super(edad, peso, nombre);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void ronronear() {
        System.out.println(" está ronroneando.");
    }

}
