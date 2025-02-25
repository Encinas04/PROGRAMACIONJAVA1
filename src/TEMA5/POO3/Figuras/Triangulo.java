package TEMA5.POO3.Figuras;

public class Triangulo extends Figura2D {
    private double base, altura, lado1, lado2, lado3;

    public Triangulo(double base, double altura, double lado1, double lado2, double lado3) {
        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    @Override
    public void area() {
        System.out.println("Área: " + ((base * altura) / 2));
    }

    @Override
    public void perimetro() {
        System.out.println("Perímetro: " + (lado1 + lado2 + lado3));
    }
}
