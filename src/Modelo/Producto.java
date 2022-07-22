
package Modelo;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Producto {
    
    private int id;
    private String codigo;
    private String descripcion;
    private double precio;
    private int cantidad;
    private String categoria;
    private List<Impuesto> impuesto;
    private boolean estatus;

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    public Producto(String descripcion, double precio, int cantidad, String categoria, Impuesto impuesto, boolean estatus) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.impuesto.add(impuesto);
        this.estatus = estatus;
    }

    public Producto(int id, String codigo, String descripcion, double precio, int cantidad, String categoria, Impuesto impuesto, boolean estatus) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
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

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCategoria() {
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

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setImpuesto(List<Impuesto> impuesto) {
        this.impuesto = impuesto;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    // </editor-fold>
    
}   
