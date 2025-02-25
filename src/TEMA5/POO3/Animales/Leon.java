package TEMA5.POO3.Animales;

public class Leon extends Animal {

    public Leon(int edad, double peso, String nombre) {
        super(edad, peso, nombre);
    }
    public void accionUnica() {
        System.out.println("El león está rugiendo en la sabana.");
    }
}