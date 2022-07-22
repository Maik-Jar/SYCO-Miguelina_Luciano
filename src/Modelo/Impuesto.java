
package Modelo;

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
    
    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR"> 
    
    public Impuesto(String nombre, String detalle, double monto, boolean estatus) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.porcentaje = monto;
        this.estatus = estatus;
    }

    public Impuesto(int id, String nombre, String detalle, double monto, boolean estatus) {
        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
        this.porcentaje = monto;
        this.estatus = estatus;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="SETTERS">
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public void setEstatus(boolean estatus) {
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
    
}
