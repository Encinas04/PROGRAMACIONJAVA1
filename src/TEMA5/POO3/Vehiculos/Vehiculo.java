package TEMA5.POO3.Vehiculos;

public class Vehiculo {
    private int puertas;
    private String color;
    private String combustible;

    public Vehiculo(int puertas,String color,String combustible){
        setColor(color);
        this.puertas=puertas;
        this.combustible=combustible;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        if(puertas<2||puertas>6){
            System.out.println("No existe un vehiculo con estas caracteristicas");
        }else{
            this.puertas = puertas;
        }

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

}
