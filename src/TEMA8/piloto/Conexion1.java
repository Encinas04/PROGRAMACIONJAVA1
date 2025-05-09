package TEMA8.piloto;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion1 {
    public static Connection conexion1() throws SQLException, IOException {
        Properties propiedades = new Properties();
        try (FileInputStream input = new FileInputStream("resources/conexion.properties")) {
            propiedades.load(input);

            String url = propiedades.getProperty("db.url1");
            String user = propiedades.getProperty("db.user1");
            String password = propiedades.getProperty("db.password1");

            // Establece la conexión real
            return DriverManager.getConnection(url, user, password);
        }
    }
}