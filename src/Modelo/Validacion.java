package Modelo;

import Vista.VentanaPrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JInternalFrame;

public class Validacion {
    ResultSet rs;
    PreparedStatement ps;
    Conexion con = new Conexion();
    
    public static final String storeprocedure = "{ call Validacion_BUSCAR (?,?,?) }";
    
    // Este metodo hace una validación a la base de datos. Retornar true si existe al menos un registro.
    public boolean Validacion_Existencia_Registro(String tabla, String columna, String criterio) {

        try {
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall(storeprocedure);

            // Parametros de consulta.
            ps.setString(1,  tabla);
            ps.setString(2, columna);
            ps.setString(3, criterio);

            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    // Este metodo valida si un dato es numerico.
    public boolean isNumeric(String cadena) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(cadena, pos);
        return cadena.length() == pos.getIndex();
    }
    // Este metodo valida que la misma ventana no este abierta dos veces.
    public boolean JInternalFrames_Abiertos(JInternalFrame jif){ // Creamos un metodo publico de tipo boolean.
        JInternalFrame [] jif_Activos = VentanaPrincipal.jDPprincipal.getAllFrames(); // Este arreglo almacena todos los JInternalFrames que esten abierto en el jDesktopPane.
        
        for (int i = 0; i < jif_Activos.length; i++) { // Creamos un ciclo for para recorrer nuestro arreglo utilizando la propiedad length de nuestro arreglo.
            
            // Validamos con un if si nuestro arreglo en la posición i es igual al JInternalFrame que esta activo en el jDesktopPane, si es igual devolverá true.
            if (jif.getClass().isInstance(jif_Activos[i])) {
                JOptionPane.showMessageDialog(null, "La ventana que esta intentando abrir ya esta abierta.", "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }
    // Este metodo hace una validación a la base de datos. Retornar true si el estatus es ACTIVO.
    public boolean Validacion_Estatus_Factura(String tabla, String columna, String criterio) {

        try {
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall(storeprocedure);

            // Parametros de consulta.
            ps.setString(1, tabla);
            ps.setString(2, columna);
            ps.setString(3, criterio);

            rs = ps.executeQuery();
            
            rs.next();
            String estatus = rs.getString(1);
            
            if ("ACTIVO".equals(estatus)) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    // Este metodo valida si exite un usuario con el mismo nick que se esta tratando de crear al nuevo usuario.
    public boolean Existencia_de_usuario(String nick) {
        try {
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall(storeprocedure);

            // Parametros de consulta.
            ps.setString(1, "usuario");
            ps.setString(2, "nick");
            ps.setString(3, nick);

            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    // Este metodo valida que el usuario y la clave que se esta ingresando en el login coinsidan.
    public boolean Validacion_de_ususario(Usuario usr){
        
        try {
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall(storeprocedure);

            // Parametros de consulta.
            ps.setString(1, "usuario");
            ps.setString(2, "validacion");
            ps.setString(3, usr.getNick());

            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getContrasena().equals(HashMD5.deencode("llavedeencriptacion",rs.getString(3)))) {
                    usr.setId(rs.getInt(1));
                    usr.setNick(rs.getString(2));
                    usr.setPuesto(rs.getString(4));
                    usr.setNombre(rs.getString(5));
                    usr.setRol(rs.getString(6));
                    return true;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    // Este metodo valida que la categoria que se esta creando no este repetida en la BBDD.
    public boolean Existencia_de_categoria (String tabla, String columna, String criterio) {
        try {
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall(storeprocedure);

            // Parametros de consulta.
            ps.setString(1, tabla);
            ps.setString(2, columna);
            ps.setString(3, criterio);

            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    // Este metodo valida que la categoria que se esta modificando no este repetida en la BBDD.
    public boolean Iguardad_categoria(String tabla, String columna, String criterio, String eserie, String ecategoria) {
       String serie = null;
       String categoria = null;
        try {
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall(storeprocedure);

            // Parametros de consulta.
            ps.setString(1, tabla);
            ps.setString(2, columna);
            ps.setString(3, criterio);

            rs = ps.executeQuery();
            
            while (rs.next()) {
                serie = rs.getString(1);
                categoria = rs.getString(2);
                if (categoria.equals(ecategoria)  == true) {
                    JOptionPane.showMessageDialog(null, "La Categoría "+ecategoria+" ya existe.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
                    return true;
                } else if (serie.equals(eserie) == true) {
                    JOptionPane.showMessageDialog(null, "La Serie " + eserie + " ya existe.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
                    return true;
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    // Este metodo valida que el ID que se este creando no este repetido en la BBDD.
    public boolean Cliente_igual (String tabla, String columna, String criterio, String id, String documento) {
        String idbd;
        String documentobd;
        
        try {
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall(storeprocedure);

            // Parametros de consulta.
            ps.setString(1, tabla);
            ps.setString(2, columna);
            ps.setString(3, criterio);

            rs = ps.executeQuery();

            if (rs.next()) {
                idbd = rs.getString(1);
                documentobd = rs.getString(2);
                if (id.equals(idbd) && documento.equals(documentobd)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    // Este metodo valida que el ID que se esta modificando no sea igual o otro que ya exista en la BBDD-
    public boolean ID_igual (String tabla, String columna, String criterio, String id, String documento){
        String idbd;
        String documentobd;
        try {
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall(storeprocedure);

            // Parametros de consulta.
            ps.setString(1, tabla);
            ps.setString(2, columna);
            ps.setString(3, criterio);

            rs = ps.executeQuery();

            while (rs.next()) {
                idbd = rs.getString(1);
                documentobd = rs.getString(2);
                if (id.equals(idbd)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    // Este metodo valida si el artículo esta o no disponible,
    public boolean Disponibilidad_Articulo (String tabla, String columna, String criterio) {
        try {
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall(storeprocedure);

            // Parametros de consulta.
            ps.setString(1, tabla);
            ps.setString(2, columna);
            ps.setString(3, criterio);

            rs = ps.executeQuery();

            if (rs.next()) {
                if ("Si".equals(rs.getString(1))) {
                    return true;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean Modificacion_factura (int nofactura, ArrayList articulos, String venta, String modopago, Double pagado, String comentario) {

        ArrayList articulosbd = new ArrayList();

        try {
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jdDetalledefactura_BUSCAR_FACTURAS (?) }");

            // Parametros de consulta.
            ps.setInt(1, nofactura);

            rs = ps.executeQuery();

            if (rs.next()) {
                if (!venta.equals(rs.getString(10)) || !modopago.equals(rs.getString(11)) || pagado != rs.getDouble(12) || !comentario.equals(rs.getString(19))) {
                    return true;
                } else {
                    do {
                        articulosbd.add(rs.getInt(23));
                        articulosbd.add(rs.getDouble(25));
                    } while (rs.next());

                    Iterator targetIt = articulos.iterator();
                    for (Object artbd : articulosbd) {
                        if (!artbd.equals(targetIt.next())) {
                            return true;
                        }
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
}
