package TEMA8.piloto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Piloto {
    public static void main(String[] args) {
        String sql= "SELECT forename FROM drivers ";
        try (Connection conn = TEMA8.piloto.Conexion1.conexion1();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {

                System.out.println(rs.getString("forename"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

