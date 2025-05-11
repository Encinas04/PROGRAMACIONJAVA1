package TEMA8.piloto;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class PilotsCRUD {

    public static List<Piloto> pilotos = new ArrayList<>();

    public static void main(String[] args) throws SQLException, IOException {
        String sql = "SELECT driverid, code, forename, surname, dob, nationality, url FROM drivers";
        try (Connection conn = TEMA8.piloto.Conexion1.conexion1();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int driverId = rs.getInt("driverid");
                String code = rs.getString("code");
                String forename = rs.getString("forename");
                String surname = rs.getString("surname");
                String dob = rs.getString("dob");
                String nationality = rs.getString("nationality");
                String url = rs.getString("url");
                Piloto piloto = new Piloto(driverId, code, forename, surname, dob, nationality, url);
                pilotos.add(piloto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        menu();
    }

    public static void menu() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ GESTIÓN DE PILOTOS ---");
            System.out.println("1. Añadir piloto");
            System.out.println("2. Buscar piloto por ID");
            System.out.println("3. Listar todos los pilotos");
            System.out.println("4. Actualizar piloto");
            System.out.println("5. Eliminar piloto");
            System.out.println("6. Mostrar clasificación de pilotos");
            System.out.println("7. Mostrar clasificación de constructores");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    CreatePilot();
                    break;
                case 2:
                    ReadPilot();
                    break;
                case 3:
                     readPilotos();
                    break;
                case 4:
                    UpdatePilot();
                    break;
                case 5:
                    DeletePilot();
                    break;
                case 6:
                    ShowPilotClassification();
                    break;
                case 7:
                    ShowBuildersClassification();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    public static void CreatePilot() throws SQLException, IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("\n--- AÑADIR NUEVO PILOTO ---");
        System.out.print("ID del piloto: ");
        int driverId = scanner.nextInt();
        System.out.print("Código: ");
        String code = scanner.nextLine();
        System.out.print("Nombre: ");
        String forename = scanner.nextLine();
        System.out.print("Apellido: ");
        String surname = scanner.nextLine();
        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        System.out.print("Nacionalidad: ");
        String nationality = scanner.nextLine();
        System.out.print("URL: ");
        String url = scanner.nextLine();

        Piloto nuevoPiloto = new Piloto(driverId, code, forename, surname, dob, nationality, url);
        pilotos.add(nuevoPiloto);
        String sql="INSERT INTO drivers(driverid, code, forename, surname, dob, nationality, url) VALUES(?,?,?,?,?,?,?)";
        Date fecha;
        try {
            fecha = Date.valueOf(dob);
        } catch (IllegalArgumentException e) {
            System.out.println("Fecha inválida. Asegúrate de usar el formato YYYY-MM-DD.");
            return;
        }

        try (Connection conn = TEMA8.piloto.Conexion1.conexion1();
             PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setInt(1, nuevoPiloto.getDriverId());
            stmt.setString(2, nuevoPiloto.getCode());
            stmt.setString(3, nuevoPiloto.getForename());
            stmt.setString(4, nuevoPiloto.getSurname());
            stmt.setDate(5, fecha);
            stmt.setString(6, nuevoPiloto.getNationality());
            stmt.setString(7, nuevoPiloto.getUrl());
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Piloto añadido correctamente.");
            } else {
                System.out.println("No se pudo añadir el piloto.");
            }

        }

    }
    private static void ReadPilot() {
        String sql = "SELECT driverid, code, forename, surname, dob, nationality, url FROM drivers WHERE driverid = ?";
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingrese la id del piloto:");
        int id= scan.nextInt();
        try (Connection conn = Conexion1.conexion1();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("\n--- PILOTO ENCONTRADO ---");
                System.out.println("ID: " + rs.getString("driverid"));
                System.out.println("Código: " + rs.getString("code"));
                System.out.println("Nombre: " + rs.getString("forename"));
                System.out.println("Apellido: " + rs.getString("surname"));
                System.out.println("Fecha de nacimiento: " + rs.getString("dob"));
                System.out.println("Nacionalidad: " + rs.getString("nationality"));
                System.out.println("URL: " + rs.getString("url"));
            }else{
                System.out.println("Piloto no encontrado");
            }

        } catch (SQLException e) {
            System.err.println("Error de SQL al buscar piloto: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
    public static void readPilotos(){
        System.out.println("Lista de pilotos: ");
        for(Piloto piloto:pilotos){
            System.out.println(piloto);
        }
    }
    public static void UpdatePilot() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del piloto que desea actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Piloto pilotoEncontrado = null;
        for (Piloto p : pilotos) {
            if (p.getDriverId() == id) {
                pilotoEncontrado = p;
            }else {
                System.out.println("Piloto no encontrado");
            }
        }

        if (pilotoEncontrado == null) {
            System.out.println("Piloto no encontrado en la lista.");
            return;
        }

        System.out.print("Nuevo código: ");
        String code = scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String forename = scanner.nextLine();
        System.out.print("Nuevo apellido: ");
        String surname = scanner.nextLine();
        System.out.print("Nueva fecha de nacimiento (YYYY-MM-DD): ");
        String dobInput = scanner.nextLine();
        System.out.print("Nueva nacionalidad: ");
        String nationality = scanner.nextLine();
        System.out.print("Nueva URL: ");
        String url = scanner.nextLine();

        Date dob;
        try {
            dob = Date.valueOf(dobInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Fecha inválida. Usa el formato YYYY-MM-DD.");
            return;
        }
        pilotoEncontrado.setCode(code);
        pilotoEncontrado.setForename(forename);
        pilotoEncontrado.setSurname(surname);
        pilotoEncontrado.setDob(String.valueOf(dob));
        pilotoEncontrado.setNationality(nationality);
        pilotoEncontrado.setUrl(url);

        String sql = "UPDATE drivers SET code=?, forename=?, surname=?, dob=?, nationality=?, url=? WHERE driverid=?";
        try (Connection conn = Conexion1.conexion1();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, code);
            stmt.setString(2, forename);
            stmt.setString(3, surname);
            stmt.setDate(4, dob);
            stmt.setString(5, nationality);
            stmt.setString(6, url);
            stmt.setInt(7, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Piloto actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el piloto.");
            }
        }
    }
    public static void DeletePilot() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del piloto que desea eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Piloto pilotoAEliminar = null;
        for (Piloto p : pilotos) {
            if (p.getDriverId() == id) {
                pilotoAEliminar = p;
            }
        }

        if (pilotoAEliminar == null) {
            System.out.println("Piloto no encontrado en la lista.");
        }

        String sql = "DELETE FROM drivers WHERE driverid=?";
        try (Connection conn = Conexion1.conexion1();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Piloto eliminado correctamente.");
                pilotos.remove(pilotoAEliminar);
            } else {
                System.out.println("No se pudo eliminar el piloto.");
            }
        }
    }
    public static void ShowPilotClassification() throws SQLException, IOException {
        String sql = "SELECT d.driverId, d.forename, d.surname, SUM(r.points) AS total_points " +
                "FROM drivers d " +
                "JOIN results r ON d.driverId = r.driverId " +
                "GROUP BY d.driverId, d.forename, d.surname " +
                "ORDER BY total_points DESC";

        try (Connection conn = Conexion1.conexion1();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n--- CLASIFICACIÓN FINAL DE PILOTOS ---");
            int posicion = 1;
            while (rs.next()) {
                String nombre = rs.getString("forename");
                String apellido = rs.getString("surname");
                double puntos = rs.getDouble("total_points");

                System.out.println(posicion + ". " + nombre + " " + apellido + " - " + puntos + " puntos");
                posicion++;

            }

        } catch (SQLException e) {
            System.err.println("Error al obtener la clasificación: " + e.getMessage());
        }
    }
    public static void ShowBuildersClassification() {
        String sql = "SELECT c.name AS constructor, SUM(r.points) AS points " +
                "FROM constructors c " +
                "JOIN results r ON c.constructorid = r.constructorid " +
                "GROUP BY c.name " +
                "ORDER BY points DESC";

        try (Connection conn = Conexion1.conexion1();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n--- CLASIFICACIÓN DE CONSTRUCTORES ---");
            int posicion = 1;

            while (rs.next()) {
                String constructor = rs.getString("constructor");
                double puntos = rs.getDouble("points");

                System.out.println(posicion + ". " + constructor + " - " + puntos + " puntos");
                posicion++;
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener la clasificación de constructores: " + e.getMessage());
            System.err.println("Consulta SQL fallida: " + sql);
        } catch (IOException e) {
            throw new RuntimeException("Error de conexión: " + e.getMessage());
        }
    }





}