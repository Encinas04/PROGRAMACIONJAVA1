package TEMA5.POO3.Figuras;

public class Circulo extends Figura2D {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }
    @Override
    public void area() {
        System.out.println("Área: " + (Math.PI * radio * radio));
    }
    @Override
    public void perimetro() {
        System.out.println("Perímetro: " + (2 * Math.PI * radio));
    }
}
