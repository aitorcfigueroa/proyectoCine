package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class dbconnection {
    /**
     * Método para realizar la conexión a la base de datos.
     * @return la conexión a la base de datos o null en caso de error.
     */
    public static Connection conexion() {
        Dotenv dotenv = Dotenv.load();
        Connection conexion = null;
        String url = "jdbc:mysql://localhost:3306/proyecto_cine";
        String usuario = dotenv.get("USER");
        String passwd = dotenv.get("PASS");

        // Registrar el controlador JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al registrar el controlador JDBC: " + e.getMessage());
            return null;
        }

        // Conexión a la base de datos
        try {
            conexion = DriverManager.getConnection(url, usuario, passwd);
            System.out.println("Conexión correcta");
        } catch (SQLException e) {
            System.out.println("Error en la conexión con MySQL");
            System.out.println("Revisa que todo esté bien escrito y funcional");
            System.out.println(e.getLocalizedMessage());
            return null;
        }

        return conexion;
    }

    /**
     * Método para cerrar la conexión a la base de datos.
     * @param conexion
     */
    static void closeConection(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
