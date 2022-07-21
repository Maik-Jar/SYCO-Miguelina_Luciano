
package Modelo;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Factura {
    
    private int noFactura;
    private String tipoFactura;
    private String nfc;
    private String vencimientoNFC;
    private String fechaHora;
    private Cliente cliente;
    private List<DetalleFactura> detalleFactura;
    private String tipoVenta;
    private String modoPago;
    private double subtotal;
    private double totalDescuento;
    private double totalImpuesto;
    private double montoTotal;
    private double pagado;
    private String comentario;

    public Factura(String tipoFactura, String tipoVenta, String modoPago) {
        this.tipoFactura = tipoFactura;
        this.tipoVenta = tipoVenta;
        this.modoPago = modoPago;
        this.noFactura = 0;
        this.nfc = "n/a";
        this.vencimientoNFC = "n/a";
        this.fechaHora = null;
        this.cliente = null;
        this.detalleFactura = null;
        this.subtotal = 0.00;
        this.totalDescuento = 0.00;
        this.totalImpuesto = 0.00;
        this.montoTotal = 0.00;
        this.pagado = 0.00;
        this.comentario = null;
    }

    // <editor-fold defaultstate="collapsed" desc="SETTERS"> 
    public void setNoFactura(int noFactura) {
        this.noFactura = noFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    public void setVencimientoNFC(String vencimientoNFC) {
        this.vencimientoNFC = vencimientoNFC;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura.add(detalleFactura);
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }

    /*public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }*/

    public void setTotalDescuento(double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public void setTotalImpuesto(double totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setPagado(double pagado) {
        this.pagado = pagado;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GETTERS"> 
    public int getNoFactura() {
        return noFactura;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public String getNfc() {
        return nfc;
    }

    public String getVencimientoNFC() {
        return vencimientoNFC;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public String getModoPago() {
        return modoPago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotalDescuento() {
        return totalDescuento;
    }

    public double getTotalImpuesto() {
        return totalImpuesto;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public double getPagado() {
        return pagado;
    }

    public String getComentario() {
        return comentario;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="METODOS"> 
    
    private void calculaSubtotal(List<DetalleFactura> detalleFactura){
        
        for (DetalleFactura precioCantidad : detalleFactura) {
           this.subtotal += precioCantidad.getServicio().getPrecio();
        }
        
        
    }
    
    // </editor-fold>
}
