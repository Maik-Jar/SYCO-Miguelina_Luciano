package Modelo;

public class Cotizacion {
    
    private String n_comprobante;
    private Object imagen;
    private String t_documento;
    private String rnc;
    private String cliente;
    private String telefono;
    private String codcliente;
    private String fecha;
    private String codigo;
    private String descripcion;
    private String cantidad;
    private String itbis;
    private String precio;
    private String subtotal;
    private String descto;
    private String t_itbis;
    private String total;
    private String usuario;
    private String comentario;

    public Cotizacion(String n_comprobante, Object imagen, String t_documento, String rnc, String cliente, String telefono, String codcliente, String fecha, String codigo, String descripcion, String cantidad, String itbis, String precio, String subtotal, String descto, String t_itbis, String total, String usuario, String comentario) {
        this.n_comprobante = n_comprobante;
        this.imagen = imagen;
        this.t_documento = t_documento;
        this.rnc = rnc;
        this.cliente = cliente;
        this.telefono = telefono;
        this.codcliente = codcliente;
        this.fecha = fecha;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.itbis = itbis;
        this.precio = precio;
        this.subtotal = subtotal;
        this.descto = descto;
        this.t_itbis = t_itbis;
        this.total = total;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public String getN_comprobante() {
        return n_comprobante;
    }

    public void setN_comprobante(String n_comprobante) {
        this.n_comprobante = n_comprobante;
    }

    public Object getImagen() {
        return imagen;
    }

    public void setImagen(Object imagen) {
        this.imagen = imagen;
    }

    public String getT_documento() {
        return t_documento;
    }

    public void setT_documento(String t_documento) {
        this.t_documento = t_documento;
    }

    public String getRnc() {
        return rnc;
    }

    public void setRnc(String rnc) {
        this.rnc = rnc;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getItbis() {
        return itbis;
    }

    public void setItbis(String itbis) {
        this.itbis = itbis;
    }
    
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getDescto() {
        return descto;
    }

    public void setDesctol(String descto) {
        this.descto = descto;
    }

    public String getT_itbis() {
        return t_itbis;
    }

    public void setT_itbis(String t_itbis) {
        this.t_itbis = t_itbis;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComntario(String comentario) {
        this.comentario = comentario;
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }
    
}
