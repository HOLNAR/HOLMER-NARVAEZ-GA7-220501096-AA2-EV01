package ordenatupan.conexion;
import java.sql.Connection;

public class Conexion {
    public static Connection getConexion() {
        Connection conexion = null;
        var baseDatos = "ordenatupan";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "admin";
        var password = "Solin20232023###*";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = java.sql.DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.out.println("Error al conectarse a la BD: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        if (conexion != null) {
            System.out.println("Conexion exitosa" + conexion);
        } else {
            System.out.println("Error al conectarse");
        }
    }
}
