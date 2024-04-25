
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Conexion {
    String basedatos = "empleados";
    String URL = "jdbc:mysql://localhost:3306/";
    String USU = "root";
    String CLAVE = "123456";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection con;

    public Conexion() {
        
    }
    
    public Connection conectar() throws SQLException {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL + basedatos, USU, CLAVE);
              System.out.println("SI CONECTADO A : "+basedatos);
        } catch (  ClassNotFoundException | SQLException ex) {
            System.out.println("NO CONECTADO");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void desconectar(){
        try {
            con.close();
            System.out.println("DESCONECTADO DE : "+basedatos);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
