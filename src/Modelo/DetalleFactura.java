
package Modelo;

/**
 *
 * @author DELL
 */
public class DetalleFactura {
    
    private int id;
    private String noFactura;
    private String tipoItem; // Servicio o Producto / asignacion automatica.
    private Producto producto; // codigo, descripcion, precioUnd, impuesto(si lleva o no)
    private Servicio servicio; // codigo, detalle, precio, impuesto(si lleva o no)
    private String codigoItem; // asignacion automatica
    private String descripcionItem; // asignacion automatica
    private double precioUnitario = 0.00; // asignacion automatica
    private int cantidad = 1;
    private double impuesto = 0.00; // Calulo interno
    private double porcentajeDescuento = 0.00; 
    private double monto = 0.00; // Calculo interno
    private double precio = 0.00; // Calculo interno
    private double montoDescuento = 0.00; // Calculo interno

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    // Para cuando se vaya agregar un nuevo detalle a la factura y sea un producto.
    public DetalleFactura(int id, String noFactura, Producto producto, int cantidad, double descuento) {
        this.id = id;
        this.noFactura = noFactura;
        this.tipoItem = "producto";
        this.producto = producto;
        this.cantidad = cantidad;
        this.porcentajeDescuento = descuento;
        this.codigoItem = producto.getCodigo();
        this.descripcionItem = producto.getDescripcion();
        this.precioUnitario = producto.getPrecio();
        
        calculaPreio();
        calculaDescuento();
        calculaImpuesto();
        calculaMonto();
    }
    // Para cuando se vaya agregar un nuevo detalle a la factura y sea un servicio.
    public DetalleFactura(int id, String noFactura, Servicio servicio, int cantidad, double descuento) {
        this.id = id;
        this.noFactura = noFactura;
        this.tipoItem = "servicio";
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.porcentajeDescuento = descuento;
        this.codigoItem = servicio.getCodigo();
        this.descripcionItem = servicio.getDescripcion();
        this.precioUnitario = servicio.getPrecio();
        
        calculaPreio();
        calculaDescuento();
        calculaImpuesto();
        calculaMonto();
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="SETTERS"> 
    public void setId(int id) {
        this.id = id;
    }
    
    /*
    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }
    */

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        
        calculaPreio();
        calculaDescuento();
        calculaImpuesto();
        calculaMonto();
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
        
        calculaPreio();
        calculaDescuento();
        calculaImpuesto();
        calculaMonto();
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GETTERS">
    public int getId() {
        return id;
    }

    public String getNoFactura() {
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

    public double getImpuesto() {
        return impuesto;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public double getMonto() {
        return monto;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public double getMontoDescuento() {
        return montoDescuento;
    }
    
    public String getCodigo() {
        return codigoItem;
    }
    
    public String getDescripcion() {
        return descripcionItem;
    }
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="METODOS">
    private void calculaPreio() {
        
        this.precio = precioUnitario * cantidad;
    }
    
    private void calculaDescuento() {
        
        this.montoDescuento = precio * (porcentajeDescuento/100);
    }
    
    private void calculaImpuesto() {
        
        double montoImpuesto = 0.00;
        double impuestos = 0.00;
        
        if (tipoItem.equalsIgnoreCase("Servicio")) { // Se valida si es un servicio o producto
            for (Impuesto imp : servicio.getImpuesto()) {
                impuestos += imp.getPorcentaje();
            }
            
            montoImpuesto = (precio-montoDescuento) * impuestos;
        }else {
            for (Impuesto imp : producto.getImpuesto()) {
                impuestos += imp.getPorcentaje();
            }
            
            montoImpuesto = (precio-montoDescuento) * impuestos;
        }
        
        this.impuesto = montoImpuesto;
    }
    
    private void calculaMonto() {
        
        double total = 0.00;
        
        total = (precio-montoDescuento)+ impuesto;
        
        this.monto = total;
    }
    // </editor-fold>
}
