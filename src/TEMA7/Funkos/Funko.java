package TEMA7.Funkos;

public class Funko {
    private String codigo;
    private String nombre;
    private String modelo;
    private Double precio;
    private String fecha;

    public Funko(String codigo, String nombre, String modelo, Double precio, String fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.modelo = modelo;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Nombre: " + nombre + ", Modelo: " + modelo +
                ", Precio: " + precio + ", Fecha: " + fecha;
    }
}
