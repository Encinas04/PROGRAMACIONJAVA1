package TEMA5.EXCEPCIONES;

public class Gato {
    private int edad;
    private String nombre;

    public Gato(String nombre,int edad ) {
        setEdad(edad);
        setNombre(nombre);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
       try {
           if (edad<0){
               System.out.println("Esta edad es incorrecta");
           }else{
               this.edad = edad;
           }
       }catch (Exception ex){
           System.out.println("Edad invalida");
           System.out.println(ex.getMessage());
       }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        try {if (nombre.length()<3){
            System.out.println("Este nombre es demasiado corto");
        }else{
            this.nombre = nombre;
        }
        }catch (Exception ex){
            System.out.println("Nombre incorrecto");
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public String toString() {
        return "Gato{" +
                "edad=" + getEdad() +
                ", nombre='" + getNombre() + '\'' +
                '}';
    }
}
