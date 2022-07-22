
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
    private Servicio servicio; // codigo, detalle, precio, impuesto(si lleva o no)
    private int cantidad;
    private double impuesto; // Calulo interno
    private double descuento; 
    private double monto; // Calculo interno
    private double precio; // Calculo interno

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    // Para cuando se vaya agregar un nuevo detalle a la factura y sea un producto.
    public DetalleFactura(int id, int noFactura, String tipoItem, Producto producto, int cantidad, double descuento) {
        this.id = id;
        this.noFactura = noFactura;
        this.tipoItem = tipoItem;
        this.producto = producto;
        this.cantidad = cantidad;
        this.descuento = descuento;
        
        calculaPreio();
        calculaImpuesto();
        calculaMonto();
    }
    // Para cuando se vaya agregar un nuevo detalle a la factura y sea un servicio.
    public DetalleFactura(int id, int noFactura, String tipoItem, Servicio servicio, int cantidad, double descuento) {
        this.id = id;
        this.noFactura = noFactura;
        this.tipoItem = tipoItem;
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.descuento = descuento;
        
        calculaPreio();
        calculaImpuesto();
        calculaMonto();
    }
    // </editor-fold>
    
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
        
        calculaPreio();
        calculaImpuesto();
        calculaMonto();
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
        
        calculaPreio();
        calculaImpuesto();
        calculaMonto();
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

    public double getImpuesto() {
        return impuesto;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getMonto() {
        return monto;
    }
    
    public double getPrecio() {
        return precio;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="METODOS">
    private void calculaPreio() {
        
        double montoDescuento = calculaDescuento();
        double precioXcantidad = 0.00;
        
        if (tipoItem.equalsIgnoreCase("Servicio")) { // Se valida si es un servicio o producto
            precioXcantidad = servicio.getPrecio() * cantidad;
        }else {
            precioXcantidad = producto.getPrecio() * cantidad;
        }
        
        this.precio = precioXcantidad - montoDescuento;
    }
    
    private double calculaDescuento() {
        
        double montodescuento = 0.00;
        
        montodescuento = precio * (descuento/100);
        
        return montodescuento;
    }
    
    private void calculaImpuesto() {
        
        double montoImpuesto = 0.00;
        double impuestos = 0.00;
        
        if (tipoItem.equalsIgnoreCase("Servicio")) { // Se valida si es un servicio o producto
            for (Impuesto imp : servicio.getImpuesto()) {
                impuestos += imp.getPorcentaje();
            }
            
            montoImpuesto = precio * impuestos;
        }else {
            for (Impuesto imp : producto.getImpuesto()) {
                impuestos += imp.getPorcentaje();
            }
            
            montoImpuesto = precio * impuestos;
        }
        
        this.impuesto = montoImpuesto;
    }
    
    private void calculaMonto() {
        
        double total = 0.00;
        
        total = precio + impuesto;
        
        this.monto = total;
    }
    // </editor-fold>
}
