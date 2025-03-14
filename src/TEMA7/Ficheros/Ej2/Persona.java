package TEMA7.Ficheros.Ej2;

public class Persona {
    private String nombre;
    private double notaMedia;


    public Persona(String nombre,double notaMedia) {
        this.nombre = nombre;
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
        return "El alumno "+getNombre()+" tiene de media: "+getNotaMedia();
    }
}
