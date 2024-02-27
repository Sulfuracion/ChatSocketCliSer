package org.example.mensajesServidor.DataBase;

import org.example.mensajesServidor.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseController {

    private static Connection connection;
    public static Connection getConnection() {
        // Datos de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/chatCliSer"; // URL de la base de datos
        String user = "root"; // Usuario de la base de datos
        String password = ""; // Contraseña de la base de datos

        Connection connection = null;

        try {
            // Establecer la conexión
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        return connection;
    }
    public static List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM Usuarios";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public static boolean usuarioExiste(String name, String password) {
        // Obtén la conexión
        Connection conn = getConnection();
        if (conn == null) {
            return false;
        }

        // Prepara la consulta SQL
        String sql = "SELECT * FROM Usuarios WHERE name = ? AND password = ?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            // Si hay al menos un resultado, el usuario existe
            if (resultSet.next()) {
                System.out.println("El usuario existe.");
                return true;
            } else {
                System.out.println("El usuario no existe.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar el usuario: " + e.getMessage());
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }





}
