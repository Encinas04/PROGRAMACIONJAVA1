package TEMA8;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    public static Connection conexion() throws SQLException, IOException {
        Properties propiedades = new Properties();
        try (FileInputStream input = new FileInputStream("src/TEMA8/conexion")) {
            propiedades.load(input);

            String url = propiedades.getProperty("db.url");
            String user = propiedades.getProperty("db.user");
            String password = propiedades.getProperty("db.password");

            // Establece la conexión real
            return DriverManager.getConnection(url, user, password);
        }
    }
}