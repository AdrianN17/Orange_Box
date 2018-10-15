package bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class conectar {
    
    public Connection connect() {
        Connection conn = null;
        String url = "jdbc:sqlite::resource:bd/bd.db";
        try {

            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(true);
            
        } catch (SQLException e) {
            System.out.println("No se pudo generar la conexión. Mensaje:" + e.getMessage());
        }
        return conn;
    }
    
}
