
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Servicio {
    
    private int id;
    private int codigo;
    private String descripcion;
    private String detalle;
    private double precio;
    private List<Impuesto> impuesto;
    private boolean estatus;
    
    private Conexion con;
    private ResultSet rs;
    private PreparedStatement ps;

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    // Para cuando se cree un nuevo producto
    public Servicio(String descripcion, double precio, List<Impuesto> impuesto, boolean estatus) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.impuesto = impuesto;
        this.estatus = estatus;
    }
    // Para cuando se busque un servicio existente
    public Servicio(int id, int codigo, String descripcion, String detalle, double precio, List<Impuesto> impuesto, boolean estatus) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.impuesto = impuesto;
        this.estatus = estatus;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GETTERS">
    public int getId() {
        return id;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public List<Impuesto> getImpuesto() {
        return impuesto;
    }

    public boolean isEstatus() {
        return estatus;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SETTERS">
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto.add(impuesto);
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="METODOS">
    public void crear() throws SQLException{
        conexionDB("crear");
    }
    
    public void modificar(double precio, boolean estatus, List<Impuesto> impuesto) throws SQLException{
        
        this.precio = precio;
        this.estatus = estatus;
        this.impuesto = impuesto;
        
        conexionDB("modificar");
    }
    /* Codigo comentado porque se usara en un futuro
    private List<Impuesto> eliminarImpuesto(List<Impuesto> impuesto){

        for (Impuesto i : this.impuesto) {
            for (Impuesto j : impuesto) {
                if (!(impuesto.isEmpty())) {
                    if (i.getId() == j.getId()) {
                        impuesto.remove(j);
                    }
                }
            }
        }
        
        return impuesto;
    }
    */
    private void conexionDB(String accion) throws SQLException {

        // Conexion a la base de datos.
        Connection conn = con.getConnection();

        try {

            if (accion.equalsIgnoreCase("crear")) {
                
                conn.setAutoCommit(false);
                
                // Consulta a la base de datos.
                ps = conn.prepareCall("{call sp_servicio_crear(?,?,?)}");

                // Parametros de consulta.
                ps.setString(1, descripcion); // descripcion del servicio.
                ps.setDouble(2, precio); // precio del servicio.
                ps.setBoolean(3, estatus); // estatus del servicio.

                rs = ps.executeQuery();
                
                this.codigo = rs.getInt("@ocodigo");
                this.id = rs.getInt("@oid");
                
                if (!this.impuesto.isEmpty()) {

                    for (Impuesto imp : this.impuesto) {
                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{call sp_servicio_agregar_quitarimpuesto(?,?,?)}");

                        // Parametros de consulta.
                        ps.setInt(1, codigo); // codigo del servicio.
                        ps.setInt(2, imp.getId()); // id del impuesto.
                        ps.setBoolean(3, imp.isEstatus()); // estatus del impuesto. Esto para saber si el servicio lleva impuesto o no.

                        ps.execute();
                    }
                }
                conn.commit();

                JOptionPane.showMessageDialog(null, "¡Nuevo servicio creado!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

            } else if (accion.equalsIgnoreCase("modificar")) {

                // Consulta a la base de datos.
                ps = conn.prepareCall("{call sp_servicio_modificar(?,?,?,?)}");

                // Parametros de consulta.
                ps.setInt(1, id); // id del servicio.
                ps.setString(2, descripcion); // descripcion del servicio.
                ps.setDouble(3, precio); // precio del servicio.
                ps.setBoolean(4, estatus); // estatus del impuesto.

                ps.executeUpdate();
                
                if (!this.impuesto.isEmpty()) {

                    for (Impuesto imp : this.impuesto) {
                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{call sp_servicio_agregar_quitarimpuesto(?,?,?)}");

                        // Parametros de consulta.
                        ps.setInt(1, codigo); // codigo del servicio.
                        ps.setInt(2, imp.getId()); // id del impuesto.
                        ps.setBoolean(3, imp.isEstatus()); // estatus del impuesto. Esto para saber si el servicio lleva impuesto o no.

                        ps.execute();
                    }
                }
                
                conn.commit();
                
                JOptionPane.showMessageDialog(null, "¡Servicio modificado!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (SQLException e) {
            conn.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.close();
        }
    }
    // </editor-fold>
}
