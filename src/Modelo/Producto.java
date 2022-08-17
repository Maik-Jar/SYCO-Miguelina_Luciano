
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class Producto {
    
    private int id;
    private int codigo;
    private String descripcion;
    private double precio;
    private int cantidad;
    private Categoria categoria;
    private List<Impuesto> impuesto;
    private boolean estatus;
    
    private Conexion con;
    private ResultSet rs;
    private PreparedStatement ps;

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    // para cuando se cree un nuevo producto.
    public Producto(String descripcion, double precio, int cantidad, Categoria categoria, List<Impuesto> impuesto, boolean estatus) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.impuesto = impuesto;
        this.estatus = estatus;
    }
    // para cuando se busque un producto ya creado.
    public Producto(int id, int codigo, String descripcion, double precio, int cantidad, Categoria categoria, List<Impuesto> impuesto, boolean estatus) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
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

    public int getCantidad() {
        return cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
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

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto.add(impuesto);
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="METODOS">
    
    private void conexionDB(String accion) throws SQLException {

        // Conexion a la base de datos.
        Connection conn = con.getConnection();

        try {

            if (accion.equalsIgnoreCase("crear")) {

                conn.setAutoCommit(false);

                // Consulta a la base de datos.
                ps = conn.prepareCall("{call sp_producto_crear(?,?,?)}");

                // Parametros de consulta.
                ps.setString(1, descripcion); // descripcion del producto.
                ps.setDouble(2, precio); // precio del producto.
                ps.setInt(3, cantidad); // cantidad del producto.
                ps.setInt(4, categoria.getId()); // categoria del producto.
                ps.setBoolean(5, estatus); // estatus del producto.

                rs = ps.executeQuery();

                this.codigo = rs.getInt("@ocodigo");
                this.id = rs.getInt("@oid");

                if (!this.impuesto.isEmpty()) {

                    for (Impuesto imp : this.impuesto) {
                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{call sp_agregar_quitar_impuesto(?,?,?)}");

                        // Parametros de consulta.
                        ps.setInt(1, codigo); // codigo del item.
                        ps.setInt(2, imp.getId()); // id del impuesto.
                        ps.setBoolean(3, imp.isEstatus()); // estatus del impuesto. Esto para saber si el item lleva impuesto o no.

                        ps.execute();
                    }
                }
                conn.commit();

                JOptionPane.showMessageDialog(null, "¡Nuevo producto creado!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

            } else if (accion.equalsIgnoreCase("modificar")) {

                // Consulta a la base de datos.
                ps = conn.prepareCall("{call sp_producto_modificar(?,?,?,?)}");

                // Parametros de consulta.
                ps.setInt(1, id); // id del producto.
                ps.setString(2, descripcion); // descripcion del producto.
                ps.setDouble(3, precio); // precio del producto.
                ps.setInt(4, cantidad); // cantidad del producto.
                ps.setInt(5, categoria.getId()); // categoria del producto.
                ps.setBoolean(6, estatus); // estatus del producto.

                ps.executeUpdate();

                if (!this.impuesto.isEmpty()) {

                    for (Impuesto imp : this.impuesto) {
                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{call sp_agregar_quitar_impuesto(?,?,?)}");

                        // Parametros de consulta.
                        ps.setInt(1, codigo); // codigo del item.
                        ps.setInt(2, imp.getId()); // id del impuesto.
                        ps.setBoolean(3, imp.isEstatus()); // estatus del impuesto. Esto para saber si el item lleva impuesto o no.

                        ps.execute();
                    }
                }

                conn.commit();

                JOptionPane.showMessageDialog(null, "¡producto modificado!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
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
