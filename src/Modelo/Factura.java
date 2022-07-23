
package Modelo;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Factura {
    
    private int id;
    private String noFactura;
    private String tipoFactura;
    private String nfc;
    private String vencimientoNFC;
    private String fechaHora;
    private Cliente cliente;
    private List<DetalleFactura> detalleFactura;
    private String tipoVenta;
    private String modoPago;
    private double subtotal = 0.00; // Calculo interno
    private double totalDescuento = 0.00; // Calculo interno
    private double totalImpuesto = 0.00; // Calculo interno
    private double montoTotal = 0.00; // Calculo interno
    private double pagado = 0.00;
    private String comentario;
    private boolean estatus = true;
    private Usuario usuario;

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    // Para cuando se vaya a crear una nueva factura.
    public Factura(Usuario usuario){
        this.usuario = usuario;
    }
    /*
    // Para cuando se vaya a crear una nueva factura sin comprobante.
    public Factura(String tipoFactura, Cliente cliente) {
        this.tipoFactura = tipoFactura;
        this.cliente = cliente;
    }
    // Para cuando se vaya a crear una nueva factura con comprobante.
    public Factura(String tipoFactura, String nfc, String vencimientoNFC, Cliente cliente) {
        this.tipoFactura = tipoFactura;
        this.nfc = nfc;
        this.vencimientoNFC = vencimientoNFC;
        this.cliente = cliente;
    }
    */
    // Para cuando se este buscando una factura sin comprobante.
    public Factura(int id, String noFactura, String tipoFactura, String fechaHora, Cliente cliente, List<DetalleFactura> detalleFactura, String tipoVenta, String modoPago, String comentario, boolean estatus, Usuario usuario) {
        this.id = id;
        this.noFactura = noFactura;
        this.tipoFactura = tipoFactura;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.detalleFactura = detalleFactura;
        this.tipoVenta = tipoVenta;
        this.modoPago = modoPago;
        this.comentario = comentario;
        this.estatus = estatus;
        this.usuario = usuario;
        
        calculaSubtotal();
        calculaTotalDescuento();
        calculaTotalImpuesto();
        calculaMontoTotal();
    }
    // Para cuando se este buscando una factura con comprobante.
    public Factura(int id, String noFactura, String tipoFactura, String nfc, String vencimientoNFC, String fechaHora, Cliente cliente, List<DetalleFactura> detalleFactura, String tipoVenta, String modoPago, String comentario, boolean estatus, Usuario usuario) {
        this.id = id;
        this.noFactura = noFactura;
        this.tipoFactura = tipoFactura;
        this.nfc = nfc;
        this.vencimientoNFC = vencimientoNFC;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.detalleFactura = detalleFactura;
        this.tipoVenta = tipoVenta;
        this.modoPago = modoPago;
        this.comentario = comentario;
        this.estatus = estatus;
        this.usuario = usuario;
        
        calculaSubtotal();
        calculaTotalDescuento();
        calculaTotalImpuesto();
        calculaMontoTotal();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="SETTERS"> 
    public void setNoFactura(String noFactura) {
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
        
        calculaSubtotal();
        calculaTotalDescuento();
        calculaTotalImpuesto();
        calculaMontoTotal();
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }

    /*
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotalDescuento(double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public void setTotalImpuesto(double totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    */
    public void setPagado(double pagado) {
        this.pagado = pagado;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public void setEstatus (boolean estatus) {
        this.estatus = estatus;
    }
    
    public void setUsuario (Usuario usuario) {
        this.usuario = usuario;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="GETTERS"> 
    public String getNoFactura() {
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
    
    public int getid() {
        return id;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="METODOS"> 
    private void calculaSubtotal(){
        
        double monto = 0.00;
        
        for (DetalleFactura item : detalleFactura) {
            
            monto += item.getPrecio();
            
        }
        
        this.subtotal = monto;
    }
    
    private void calculaTotalDescuento(){
        
        double monto = 0.00;
        
        for (DetalleFactura item : detalleFactura) {
            monto += item.getMontoDescuento();
        }
        
        this.totalDescuento = monto;
    }
    
    private void calculaTotalImpuesto () {
        
        double monto = 0.00;
        
        for (DetalleFactura item : detalleFactura) {
            monto += item.getImpuesto();
        }
        
        this.totalImpuesto = monto;
    }
    
    private void calculaMontoTotal () {
        
        double monto = 0.00;
        
        monto = (subtotal - totalDescuento) + totalImpuesto;
        
        this.montoTotal = monto;
    }
    
    public void agregarItem(String codigoItem){
        
    }
    // </editor-fold>
}
