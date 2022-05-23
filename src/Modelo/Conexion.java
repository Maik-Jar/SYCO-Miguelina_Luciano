
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    public static final String url = "jdbc:mysql://localhost:3306/scoa?user=minty&password=greatsqldb"; //192.168.100.102
    public static final String username = "root"; //cliente
    public static final String password = "root";
    
    // Este metodo realiza la conexión a la base de datos.
    public static Connection getConnection() {
        
       Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex, "Conexión1", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(ex);
        }
        try {
            con =  DriverManager.getConnection(url, username, password);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Conexión2", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(ex);
        }
        return con;
    }
    
}
