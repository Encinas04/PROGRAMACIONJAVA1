package TEMA5.COLECCIONES;

public class Usuario {
    private String nombre;
    private int edad;
    private String dni;

    public Usuario( String nombre,int edad,String dni){
        this.edad=edad;
        this.nombre=nombre;
        this.dni=dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad>=0){
            this.edad = edad;
        }else{
            System.out.println("Edad incorrecta");
        }

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
