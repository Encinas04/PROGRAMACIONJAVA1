package TEMA5.POO3.Animales;

public class Vaca extends Animal{
    public Vaca(int edad, double peso, String nombre) {
        super(edad, peso, nombre);
    }
    public void accionUnica() {
        System.out.println("La vaca está pastando.");
    }
}
