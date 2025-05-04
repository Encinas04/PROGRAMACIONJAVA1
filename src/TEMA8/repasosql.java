package TEMA8;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class repasosql {

    public static void main(String[] args) throws SQLException, IOException {
    menu();

    }
    public static void menu() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENÚ CONSULTAS SQL ");
            System.out.println("1. Ver nombres y apellidos de los profesores");
            System.out.println("2. Estudiantes nacidos después de 01/01/1980");
            System.out.println("3. Estudiantes ordenados por fecha de nacimiento");
            System.out.println("4. Número de estudiantes por casa");
            System.out.println("5. Calificación media y máxima en 'Pociones'");
            System.out.println("6. Años de curso sin duplicados");
            System.out.println("7. Estudiantes cuyo apellido empieza con 'P'");
            System.out.println("8. Estudiantes en 4º o 5º año");
            System.out.println("9. Estudiantes de 5º de Gryffindor o Slytherin");
            System.out.println("10. Primeros 5 estudiantes por fecha de nacimiento");
            System.out.println("11. Estudiantes con calificación >= 8 en 'Vuelo'");
            System.out.println("12. Insertar estudiante 'Nymphadora Tonks'");
            System.out.println("13. Cambiar jefe de Hufflepuff a 'Pomona Sprout'");
            System.out.println("14. Eliminar estudiante 'Tom Riddle'");
            System.out.println("15. Estudiantes con nombre de su casa");
            System.out.println("16. Estudiantes con mascota y asignaturas (LEFT JOIN)");
            System.out.println("17. Estudiantes con nota superior al promedio en 'Encantamientos'");
            System.out.println("18. Casas con nota promedio > 7");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> ejercicio4();
                case 5 -> ejercicio5();
                case 6 -> ejercicio6();
                case 7 -> ejercicio7();
                case 8 -> ejercicio8();
                case 9 -> ejercicio9();
                case 10 -> ejercicio10();
                case 11 -> ejercicio11();
                case 12 -> ejercicio12();
                case 13 -> ejercicio13();
                case 14 -> ejercicio14();
                case 15 -> ejercicio15();
                case 16 -> ejercicio16();
                case 17 -> ejercicio17();
                case 18 -> ejercicio18();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    public static void ejercicio1() throws SQLException, IOException {
        String sql = "SELECT nombre, apellido FROM profesor";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        }
    }

    public static void ejercicio2() throws SQLException, IOException {
        String sql = "SELECT nombre, apellido FROM estudiante WHERE fecha_nacimiento > '1980-01-01'";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        }
    }

    public static void ejercicio3() throws SQLException, IOException {
        String sql = "SELECT nombre, apellido FROM estudiante ORDER BY fecha_nacimiento ASC";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        }
    }

    public static void ejercicio4() throws SQLException, IOException {
        String sql = "SELECT c.nombre, COUNT(e.id_estudiante) FROM estudiante e JOIN casa c ON e.id_casa = c.id_casa GROUP BY c.nombre";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + ": " + rs.getInt(2) + " estudiante");
            }
        }
    }

    public static void ejercicio5() throws SQLException, IOException {
        String sql = "SELECT AVG(calificacion) AS media, MAX(calificacion) AS maxima\n" +
                "FROM Estudiante_Asignatura ea\n" +
                "JOIN Asignatura a ON ea.id_asignatura = a.id_asignatura\n" +
                "WHERE a.nombre = 'Pociones';";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                System.out.println("Media: " + rs.getDouble(1) + " | Máxima: " + rs.getDouble(2));
            }
        }
    }

    public static void ejercicio6() throws SQLException, IOException {
        String sql = "SELECT DISTINCT anyo_curso \n" +
                "FROM Estudiante \n" +
                "ORDER BY anyo_curso;";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Año: " + rs.getInt(1));
            }
        }
    }

    public static void ejercicio7() throws SQLException, IOException {
        String sql = "SELECT nombre, apellido \n" +
                "FROM Estudiante \n" +
                "WHERE apellido LIKE 'P%';";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre"));
            }
        }
    }

    public static void ejercicio8() throws SQLException, IOException {
        String sql = "SELECT nombre, apellido \n" +
                "FROM Estudiante \n" +
                "WHERE anyo_curso IN (4, 5);";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        }
    }

    public static void ejercicio9() throws SQLException, IOException {
        String sql = "SELECT e.nombre, e.apellido \n" +
                "FROM Estudiante e\n" +
                "JOIN Casa c ON e.id_casa = c.id_casa\n" +
                "WHERE e.anyo_curso = 5 \n" +
                "AND (c.nombre = 'Gryffindor' OR c.nombre = 'Slytherin');";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        }
    }

    public static void ejercicio10() throws SQLException, IOException {
        String sql = "SELECT nombre, apellido, fecha_nacimiento \n" +
                "FROM Estudiante \n" +
                "ORDER BY fecha_nacimiento \n" +
                "LIMIT 5;";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
        }
    }

    public static void ejercicio11() throws SQLException, IOException {
        String sql = "SELECT e.nombre, e.apellido, ea.calificacion\n" +
                "FROM Estudiante e\n" +
                "JOIN Estudiante_Asignatura ea ON e.id_estudiante = ea.id_estudiante\n" +
                "JOIN Asignatura a ON ea.id_asignatura = a.id_asignatura\n" +
                "WHERE a.nombre = 'Vuelo' AND ea.calificacion >= 8;";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre"));
            }
        }
    }

    public static void ejercicio12() throws SQLException, IOException {
        String sql = "INSERT INTO Estudiante (nombre, apellido, id_casa, anyo_curso, fecha_nacimiento)\n" +
                "VALUES ('Nymphadora', 'Tonks', 4, 7, '1973-11-25');";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            int rows = stmt.executeUpdate();
            System.out.println("Filas insertadas: " + rows);
        }
    }

    public static void ejercicio13() throws SQLException, IOException {
        String sql = "UPDATE Casa\n" +
                "SET id_jefe = (SELECT id_profesor FROM Profesor WHERE nombre = 'Pomona' AND apellido = 'Sprout')\n" +
                "WHERE nombre = 'Hufflepuff';";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            int rows = stmt.executeUpdate();
            System.out.println("Filas actualizadas: " + rows);
        }
    }

    public static void ejercicio14() throws SQLException, IOException {
        String sql = "DELETE FROM Estudiante \n" +
                "WHERE nombre = 'Tom' AND apellido = 'Riddle';";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            int rows = stmt.executeUpdate();
            System.out.println("Filas eliminadas: " + rows);
        }
    }

    public static void ejercicio15() throws SQLException, IOException {
        String sql = "SELECT e.nombre, e.apellido, c.nombre AS casa\n" +
                "FROM Estudiante e\n" +
                "JOIN Casa c ON e.id_casa = c.id_casa;";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("nombre") + " " + rs.getString("apellido") + " - " + rs.getString("casa"));
            }
        }
    }

    public static void ejercicio16() throws SQLException, IOException {
        String sql = "SELECT \n" +
                "    e.nombre AS estudiante, \n" +
                "    m.nombre AS mascota, \n" +
                "    a.nombre AS asignatura\n" +
                "FROM Estudiante e\n" +
                "LEFT JOIN Mascota m ON e.id_estudiante = m.id_estudiante\n" +
                "LEFT JOIN Estudiante_Asignatura ea ON e.id_estudiante = ea.id_estudiante\n" +
                "LEFT JOIN Asignatura a ON ea.id_asignatura = a.id_asignatura;";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("estudiante") + " - " +
                        rs.getString("mascota") + " - " +
                        rs.getString("asignatura"));
            }
        }
    }

    public static void ejercicio17() throws SQLException, IOException {
        String sql = "SELECT e.nombre, e.apellido\n" +
                "FROM Estudiante e\n" +
                "JOIN Estudiante_Asignatura ea ON e.id_estudiante = ea.id_estudiante\n" +
                "JOIN Asignatura a ON ea.id_asignatura = a.id_asignatura\n" +
                "WHERE a.nombre = 'Encantamientos' \n" +
                "AND ea.calificacion > (\n" +
                "    SELECT AVG(calificacion) \n" +
                "    FROM Estudiante_Asignatura ea2\n" +
                "    JOIN Asignatura a2 ON ea2.id_asignatura = a2.id_asignatura\n" +
                "    WHERE a2.nombre = 'Encantamientos'\n" +
                ");";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString("nombre"));
            }
        }
    }

    public static void ejercicio18() throws SQLException, IOException {
        String sql = "SELECT c.nombre AS casa, AVG(ea.calificacion) AS promedio_calificaciones\n" +
                "FROM Casa c\n" +
                "JOIN Estudiante e ON c.id_casa = e.id_casa\n" +
                "JOIN Estudiante_Asignatura ea ON e.id_estudiante = ea.id_estudiante\n" +
                "GROUP BY c.nombre\n" +
                "HAVING AVG(ea.calificacion) > 7;";
        try (Connection conn = Conexion.conexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Casa: " + rs.getString("nombre"));
            }
        }
    }
}
