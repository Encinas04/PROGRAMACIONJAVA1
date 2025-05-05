package TEMA8;

import com.sun.source.tree.TryTree;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) throws SQLException, IOException {
       menu();

    }
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de Hogwarts ---");
            System.out.println("1. Consultar estudiantes por casa");
            System.out.println("2. Obtener mascota de un estudiante");
            System.out.println("3. Número de estudiantes por casa");
            System.out.println("4. Insertar nueva asignatura");
            System.out.println("5. Modificar aula de asignatura");
            System.out.println("6. Eliminar una asignatura");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    consultarEstudiantesPorCasa();
                    break;
                case 2:
                    mascotaEstudiante();
                    break;
                case 3:
                    numeroEstudiantes();
                    break;
                case 4:
                    insertarAsignatura();
                    break;
                case 5:
                    modificarAula();
                    break;
                case 6:
                    borrarAsignatura();
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
    public static void consultarEstudiantesPorCasa() {
        System.out.println("Ingrese la id casa");
        Scanner scan = new Scanner(System.in);
        String casa = scan.next();
        String sql = "SELECT nombre, apellido FROM Estudiante  WHERE id_casa =" + casa;
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Estudiantes de " + casa + ":");
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void mascotaEstudiante() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre");
        String nombre = scan.next();
        System.out.println("Ingrese el apellido");
        String apellido = scan.next();
        String sql = "SELECT m.id_mascota, m.nombre AS nombre_mascota, m.especie\n" +
                "FROM Mascota m\n" +
                "JOIN Estudiante e ON m.id_estudiante = e.id_estudiante WHERE e.nombre = '" + nombre + "' AND e.apellido = '" + apellido + "'";
        try (Connection conn = Conexion.conexion();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            System.out.println("Mascota del esstudiante " + nombre + " " + apellido);
            while (rs.next()) {
                System.out.println(rs.getString("nombre_mascota"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void numeroEstudiantes() {

        String sql = "SELECT casa.nombre AS nombre_casa, COUNT(id_estudiante) AS estudiantes FROM casa " +
                "INNER JOIN estudiante ON casa.id_casa=estudiante.id_casa GROUP BY casa.nombre";
        try (Connection conn = Conexion.conexion();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                System.out.println("La casa " + rs.getString("nombre_casa") + " tiene " + rs.getString("estudiantes") + " personas");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void insertarAsignatura(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la asignatura:");
        String nombre = scan.nextLine();

        System.out.println("Ingrese el aula:");
        String aula = scan.nextLine();

        System.out.println("¿Es obligatoria? (true/false):");
        boolean obligatoria = scan.nextBoolean();
        String sql = "INSERT INTO asignatura(nombre, aula, obligatoria) " +
                "VALUES(?, ?, ?)";

        try (Connection conn = Conexion.conexion();
             PreparedStatement st = conn.prepareStatement(sql))
        {
            st.setString(1, nombre);
            st.setString(2, aula);
            st.setBoolean(3, obligatoria);

            int filasAfectadas = st.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Asignatura insertada correctamente.");
            } else {
                System.out.println("No se pudo insertar la asignatura.");
            }
        } catch (RuntimeException | SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void modificarAula(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la asignatura a modificar:");
        String id = scan.nextLine();
        System.out.println("Ingrese la nueva aula: ");
        String aula= scan.next();
        String sql = "UPDATE Asignatura SET aula = ? WHERE nombre = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement st = conn.prepareStatement(sql)){
            st.setString(1,id);
            st.setString(2,aula);
            int filascCambiadas=st.executeUpdate();
            if (filascCambiadas>0){
                System.out.println("Aula modificada correctamente");
            }else {
                System.out.println("No se ha podido modificar");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void borrarAsignatura(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la asignatura que desea borrar:");
        String nombre = scan.nextLine();
        String sql = "DELETE FROM Asignatura  WHERE nombre = ?";
        try (Connection conn = Conexion.conexion();
        PreparedStatement st = conn.prepareStatement(sql)){
            st.setString(1,nombre);
            int borrado=st.executeUpdate();
            if (borrado>0){
                System.out.println("Borrado correctamente");
            }else{
                System.out.println("No se ha podido borrar");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


