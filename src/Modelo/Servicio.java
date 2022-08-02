
package Modelo;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Servicio {
    
    private int id;
    private String codigo;
    private String descripcion;
    private String detalle;
    private double precio;
    private List<Impuesto> impuesto;
    private boolean estatus;

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    // Para cuando se cree un nuevo producto
    public Servicio(String descripcion, String detalle, double precio, List<Impuesto> impuesto, boolean estatus) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.impuesto = impuesto;
        this.estatus = estatus;
    }
    // Para cuando se busque un servicio existente
    public Servicio(int id, String codigo, String descripcion, String detalle, double precio, List<Impuesto> impuesto, boolean estatus) {
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

    public String getCodigo() {
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
    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

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
    
}
