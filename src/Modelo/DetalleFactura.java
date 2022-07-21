
package Modelo;

/**
 *
 * @author DELL
 */
public class DetalleFactura {
    
    private int id;
    private int noFactura;
    private String tipoItem; // Servicio o Producto
    private Producto producto; // codigo, descripcion, precioUnd, impuesto(si lleva o no)
    private Servicio servicio; // codigo, descripcion, precioUnd, impuesto(si lleva o no)
    private int cantidad;
    private double itbis;
    private double descuento;
    private double monto;
    
    // <editor-fold defaultstate="collapsed" desc="SETTERS"> 
    public void setId(int id) {
        this.id = id;
    }

    public void setNoFactura(int noFactura) {
        this.noFactura = noFactura;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setItbis(double itbis) {
        this.itbis = itbis;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GETTERS">
    public int getId() {
        return id;
    }

    public int getNoFactura() {
        return noFactura;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public Producto getProducto() {
        return producto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getItbis() {
        return itbis;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getMonto() {
        return monto;
    }
    // </editor-fold>
    
}
