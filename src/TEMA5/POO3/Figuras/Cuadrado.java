package TEMA5.POO3.Figuras;

public class Cuadrado  extends Figura2D{
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public void area() {
        System.out.println("Área: " + (lado * lado));
    }

    @Override
    public void perimetro() {
        System.out.println("Perímetro: " + (4 * lado));
    }
}
