
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Impuesto {
    
    private int id;
    private String nombre;
    private String detalle;
    private double porcentaje;
    private boolean estatus;
    
    private Conexion con;
    private ResultSet rs;
    private PreparedStatement ps;
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR"> 
    // para cuando se cree un nuevo impuesto.
    public Impuesto(String nombre, String detalle, double monto) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.porcentaje = monto;
        this.estatus = true;
    }
    // para cuando se busque un impuesto ya existente.
    public Impuesto(int id, String nombre, String detalle, double monto, boolean estatus) {
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
        this.porcentaje = monto;
        this.estatus = estatus;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GETTERS">
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public boolean isEstatus() {
        return estatus;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="METODOS"> 
    public void crear() throws SQLException{
        conexionDB("crear");
    }
    
    public void modifica(String nombre, String detalle, double porcentaje, boolean estatus) throws SQLException{
        
        this.nombre = !nombre.equalsIgnoreCase(this.nombre)?nombre:this.nombre;
        this.detalle = !detalle.equalsIgnoreCase(this.detalle)?detalle:this.detalle;
        this.porcentaje = porcentaje != this.porcentaje?porcentaje:this.porcentaje;
        this.estatus = estatus != this.estatus?estatus:this.estatus;
        
        conexionDB("modificar");
    }
    
    public void eliminar() throws SQLException{
        conexionDB("elimnar");
    }
    
    private void conexionDB(String accion) throws SQLException {
        
        // Conexion a la base de datos.
        Connection conn = con.getConnection();
        
        try {
            
            if (accion.equalsIgnoreCase("crear")){
                
                // Consulta a la base de datos.
                ps = conn.prepareCall("{call sp_insertar_impuesto(?,?,?,?)}");

                // Parametros de consulta.
                ps.setString(1, nombre); // nombre del impuesto ej. ITBIS
                ps.setString(2, detalle); // detalle del impuesto.
                ps.setDouble(3, porcentaje); // porcentaje del impuesto ej. 0.18
                ps.setBoolean(4, estatus); // estatus del impuesto.

                rs = ps.executeQuery();
                
                JOptionPane.showMessageDialog(null, "¡Nuevo impuesto creado!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                
            } else if (accion.equalsIgnoreCase("modificar")){
                
                // Consulta a la base de datos.
                ps = conn.prepareCall("{call sp_modificar_impuesto(?,?,?,?,?)}");

                // Parametros de consulta.
                ps.setInt(1, id); // id del impuesto.
                ps.setString(2, nombre); // nombre del impuesto ej. ITBIS
                ps.setString(3, detalle); // detalle del impuesto.
                ps.setDouble(4, porcentaje); // porcentaje del impuesto ej. 0.18
                ps.setBoolean(5, estatus); // estatus del impuesto.

                rs = ps.executeQuery();
                
                JOptionPane.showMessageDialog(null, "¡Impuesto modificado!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                
            } else if (accion.equalsIgnoreCase("eliminar")){
                
                // Consulta a la base de datos.
                ps = conn.prepareCall("{call sp_eliminar_impuesto(?)}");

                // Parametros de consulta.
                ps.setInt(1, id); // id del impuesto.

                rs = ps.executeQuery();
                
                JOptionPane.showMessageDialog(null, "¡Impuesto eliminado!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.close();
        }
    }
    //</editor-fold>
}
