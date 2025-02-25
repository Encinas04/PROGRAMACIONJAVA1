package TEMA5.POO3.Figuras;

public abstract class Figura2D {
    public abstract double area();

    public abstract double perimetro();


    @Override
    public String toString() {
        return "Figura2D: Área = " + area()+ ", Perímetro = "+perimetro();
    }
}

