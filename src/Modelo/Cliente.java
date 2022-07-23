
package Modelo;

/**
 *
 * @author DELL
 */
public class Cliente {
    
    private int id;
    private String codigo;
    private String tipoCliente;
    private String noDocumento;
    private String tipoDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String apellidos;
    private String razonSocial;
    private String telefono;
    private String email;

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTOR">
    // Para cuando se cree un nuevo cliente de tipo empresa.
    public Cliente(String tipoCliente, String noDocumento, String tipoDocumento, String razonSocial, String telefono, String email) {
        this.tipoCliente = tipoCliente;
        this.noDocumento = noDocumento;
        this.tipoDocumento = tipoDocumento;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.email = email;
    }
    // Para cuando se cree un nuevo cliente de tipo persona.
    public Cliente(String tipoCliente, String noDocumento, String tipoDocumento, String primerNombre, String segundoNombre, String apellidos, String telefono, String email) {
        this.tipoCliente = tipoCliente;
        this.noDocumento = noDocumento;
        this.tipoDocumento = tipoDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }
    // Para cuando se busque un cliente de tipo empresa.
    public Cliente(int id, String codigo, String tipoCliente, String noDocumento, String tipoDocumento, String razonSocial, String telefono, String email) {
        this.id = id;
        this.codigo = codigo;
        this.tipoCliente = tipoCliente;
        this.noDocumento = noDocumento;
        this.tipoDocumento = tipoDocumento;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.email = email;
    }
    // Para cuando se busque un cliente de tipo persona.
    public Cliente(int id, String codigo, String tipoCliente, String noDocumento, String tipoDocumento, String primerNombre, String segundoNombre, String apellidos, String telefono, String email) {
        this.id = id;
        this.codigo = codigo;
        this.tipoCliente = tipoCliente;
        this.noDocumento = noDocumento;
        this.tipoDocumento = tipoDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GETTERS">
    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getNoDocumento() {
        return noDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="SETTERS">
    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // </editor-fold>
    
}
