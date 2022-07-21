
package Modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Conexion {
    
    public static final String url = "jdbc:mysql://localhost:3306/scoa?user=minty&password=greatsqldb"; //192.168.100.102
    public static final String username = "appsyco";
    public static final String password = "@frente21";
    
    // Este metodo realiza la conexión a la base de datos.
    public static Connection getConnection() {
        
        Connection con = null;
        
        
        try {
            /*Object obj = new JSONParser().parse(new FileReader("config.json"));
            JSONObject jsonObject = (JSONObject) obj;

            String url = (String) jsonObject.get("url");
            String username = (String) jsonObject.get("username");
            String password = (String) jsonObject.get("password");

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();*/

            con = DriverManager.getConnection(url, username, password);
        } /*catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex, "Conexión1", JOptionPane.INFORMATION_MESSAGE);
        } */catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Conexión2", JOptionPane.INFORMATION_MESSAGE);
        } /*catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "No se encuentra el archivo config.json", JOptionPane.INFORMATION_MESSAGE);
        }*/ catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }

        return con;
    }
    
    
}
