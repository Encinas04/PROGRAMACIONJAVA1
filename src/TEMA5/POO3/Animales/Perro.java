package TEMA5.POO3.Animales;

public class Perro extends Animal {

    public Perro(int edad, double peso, String raza,String nombre) {
        super(edad, peso, nombre);

    }

    public void moverCola() {
        System.out.println(" mueve la cola felizmente.");
    }

}
