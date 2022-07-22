
package Modelo;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Servicio {
    
    private int id;
    private String codigo;
    private String detalle;
    private double precio;
    private List<Impuesto> impuesto;
    private boolean estatus;

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    public Servicio(String detalle, double precio, Impuesto impuesto, boolean estatus) {
        this.detalle = detalle;
        this.precio = precio;
        this.impuesto.add(impuesto);
        this.estatus = estatus;
    }

    public Servicio(int id, String codigo, String detalle, double precio, Impuesto impuesto, boolean estatus) {
        this.id = id;
        this.codigo = codigo;
        this.detalle = detalle;
        this.precio = precio;
        this.impuesto.add(impuesto);
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

    public String getDetalle() {
        return detalle;
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

    public void setDetalle(String detalle) {
        this.detalle = detalle;
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
