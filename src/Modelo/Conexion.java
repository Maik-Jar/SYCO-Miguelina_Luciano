
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class Conexion {
    
    public static final String url = "jdbc:mysql://localhost:3306/scoa?user=minty&password=greatsqldb"; //192.168.100.102
    public static final String username = "root";
    public static final String password = "root";
    
    // Este metodo realiza la conexión a la base de datos.
    public static Connection getConnection() {
        
        try {
            File fl = new File("C:\\Users\\DELL\\OneDrive\\Escritorio\\config.json");
            FileReader fr = new FileReader(fl);
        }catch (FileNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
