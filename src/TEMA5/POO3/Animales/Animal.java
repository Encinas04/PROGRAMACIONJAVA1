package TEMA5.POO3.Animales;

public class Animal {
    private int edad;
    private double peso;
    private String nombre;


    public Animal(int edad, double peso, String nombre) {
        this.edad = edad;
        this.peso = peso;
        this.nombre=nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void comer(){
        System.out.println("ñam");
    }
    public void dormir(){
        System.out.println("zzzzzZ");
    }
    public void hacerRuid(){
        System.out.println("aaaaaaaaa");
    }

}
