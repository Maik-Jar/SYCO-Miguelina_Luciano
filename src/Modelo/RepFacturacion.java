
package Modelo;

public class RepFacturacion {
    
    private String usuario;
    private String fdesde;
    private String fhasta;
    private String nofactura;
    private String cliente;
    private String venta;
    private String mpago;
    private String tmonto;
    private String pago;
    private String estatus;

    public RepFacturacion(String usuario, String fdesde, String fhasta, String nofactura, String cliente, String venta, String mpago, String tmonto, String pago, String estatus) {
        this.usuario = usuario;
        this.fdesde = fdesde;
        this.fhasta = fhasta;
        this.nofactura = nofactura;
        this.cliente = cliente;
        this.venta = venta;
        this.mpago = mpago;
        this.tmonto = tmonto;
        this.pago = pago;
        this.estatus = estatus;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFdesde() {
        return fdesde;
    }

    public void setFdesde(String fdesde) {
        this.fdesde = fdesde;
    }

    public String getFhasta() {
        return fhasta;
    }

    public void setFhasta(String fhasta) {
        this.fhasta = fhasta;
    }

    public String getNofactura() {
        return nofactura;
    }

    public void setNofactura(String nofactura) {
        this.nofactura = nofactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    public String getMpago() {
        return mpago;
    }

    public void setMpago(String mpago) {
        this.mpago = mpago;
    }

    public String getTmonto() {
        return tmonto;
    }

    public void setTmonto(String tmonto) {
        this.tmonto = tmonto;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
}
