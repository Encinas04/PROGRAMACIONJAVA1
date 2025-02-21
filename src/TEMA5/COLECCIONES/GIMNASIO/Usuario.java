package TEMA5.COLECCIONES.GIMNASIO;

public class Usuario{
    private String nombre;
    private int edad;

    public Usuario(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
    }
    public Usuario(){
        this.nombre="";
        this.edad=0;
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
        if (edad<0){
            System.out.println("Esta edad no es correcta");
        }else{
            this.edad = edad;
        }
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+", Edad: "+edad;
    }

}
