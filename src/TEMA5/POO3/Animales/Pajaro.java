package TEMA5.POO3.Animales;

public class Pajaro extends Animal {
    public Pajaro(int edad, double peso,String nombre) {
        super(edad, peso, nombre);
    }

    public void volar() {
        System.out.println("está volando por el cielo.");
    }

}
