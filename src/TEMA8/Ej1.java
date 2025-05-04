package TEMA8;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) throws SQLException, IOException {
        System.out.println("Ingrese la casa");
        Scanner scan=new Scanner(System.in);
        String casa= scan.next();
        consultarEstudiantesPorCasa(casa);
        String nombre= scan.next();
        String apellido= scan.next();
        obtenerMascotaEstudiante(nombre, apellido);
    }

    public static void consultarEstudiantesPorCasa(String casa) {
        String sql = "SELECT nombre, apellido FROM Estudiante WHERE casa = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, casa);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Estudiantes de " + casa + ":");
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void obtenerMascotaEstudiante(String nombre, String apellido) {
        String sql = "SELECT mascota FROM Estudiante WHERE nombre = ? AND apellido = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Mascota de " + nombre + " " + apellido + ": " + rs.getString("mascota"));
            } else {
                System.out.println("Estudiante no encontrado");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}


