package TEMA5.COLECCIONES;

import java.util.ArrayList;
import java.util.List;

public class ColaBanco {
    static List<Usuario> colaBanco=new ArrayList<>();

    public static void agregarUser(Usuario usuario) {
        colaBanco.addLast(usuario);
        System.out.println(usuario.getNombre()+"Ha sido añadido con exito");
    }

     public static void eliminarUsuarioPrimero(){
        if (!colaBanco.isEmpty()){
            Usuario usuario=colaBanco.remove(0);
            //removeFirst();
            System.out.println(usuario.getNombre()+"Ha sido eliminado");
        }else{
            System.out.println("No hay usuarios");
        }
     }
    public static void eliminarUsuario(Usuario usuario){
        if (colaBanco.contains(usuario)){
            colaBanco.remove(usuario);
            System.out.println(usuario.getNombre()+"Ha sido eliminado");
        }else{
            System.out.println("No hay usuarios");
        }
    }

    public static void main(String[]args){
        Usuario usuario1 = new Usuario("Juan", 30, "12345678A");
        Usuario usuario2 = new Usuario("Maria", 25, "87654321B");
        Usuario usuario3 = new Usuario("Pedro", 40, "11223344C");
        ColaBanco.agregarUser(usuario1);
        ColaBanco.agregarUser(usuario2);
        ColaBanco.agregarUser(usuario3);

    }
}
