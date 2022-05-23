package Vista;

import Modelo.Conexion;
import Modelo.FacturaSCOA;
import Modelo.IconCellRenderer;
import Modelo.MiRenderer;
import Modelo.Reportes;
import Modelo.Usuario;
import Modelo.Validacion;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class jifMantenimientodefacturas extends javax.swing.JInternalFrame {
    
    TableColumnModel tcmtbMantenimientodefacturas;
    TableColumnModel tcmtbFacturacion;
    DefaultTableModel dtmtbMantenimientodefacturas;
    DefaultTableModel dtmtbFacturacion;
    ResultSet rs;
    PreparedStatement ps;
    Usuario usr;
    
    Conexion con = new Conexion();
    Validacion valida = new Validacion();
    Reportes reporte = new Reportes();
    ImageIcon icono = new ImageIcon(getClass().getResource("/RecursosGraficos/logofactura.png"));
    
    static final Double ITBIS = 0.18;
    
    // Configuración de los JInternalFrame y JDialog.
    private void Configuracionventana() {
        this.setSize(880, 590);
    }
    // Configuración de atributos y medidas de todas las tablas.
   private void Configuraciontabla () {
       //Asignación de tamaño a las celdas de cada columna.
       tcmtbMantenimientodefacturas = tbMantenimientodefacturas.getColumnModel();
       tcmtbMantenimientodefacturas.getColumn(0).setPreferredWidth(60);
       tcmtbMantenimientodefacturas.getColumn(1).setPreferredWidth(180);
       tcmtbMantenimientodefacturas.getColumn(2).setPreferredWidth(170);
       tcmtbMantenimientodefacturas.getColumn(3).setPreferredWidth(70);
       tcmtbMantenimientodefacturas.getColumn(4).setPreferredWidth(100);
       tcmtbMantenimientodefacturas.getColumn(5).setPreferredWidth(80);
       tcmtbFacturacion = tbFacturacion.getColumnModel();
       tcmtbFacturacion.getColumn(0).setPreferredWidth(33);
       tcmtbFacturacion.getColumn(1).setPreferredWidth(50);
       tcmtbFacturacion.getColumn(2).setPreferredWidth(240);
       tcmtbFacturacion.getColumn(3).setPreferredWidth(100);
       tcmtbFacturacion.getColumn(4).setPreferredWidth(40);
       tcmtbFacturacion.getColumn(5).setPreferredWidth(90);
       tcmtbFacturacion.getColumn(6).setPreferredWidth(90);
       tcmtbFacturacion.getColumn(7).setPreferredWidth(90);
       tcmtbFacturacion.getColumn(8).setPreferredWidth(90);
       tcmtbFacturacion.getColumn(9).setPreferredWidth(33);
       //Asignación de cantidad de columnas.
       dtmtbMantenimientodefacturas = (DefaultTableModel) tbMantenimientodefacturas.getModel();
       dtmtbMantenimientodefacturas.setRowCount(0);
       dtmtbFacturacion = (DefaultTableModel) tbFacturacion.getModel();
       dtmtbFacturacion.setRowCount(0);
       //Asignación de color al Background, color al texto y estilo de fuente del encabezado de columna.
       Color bgTitulocolumn = new Color(31, 78, 121);
       Color fgTitulocolumn = new Color(255, 255, 255);
       tbMantenimientodefacturas.getColumnModel().getColumn(0).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbMantenimientodefacturas.getColumnModel().getColumn(1).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbMantenimientodefacturas.getColumnModel().getColumn(2).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbMantenimientodefacturas.getColumnModel().getColumn(3).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbMantenimientodefacturas.getColumnModel().getColumn(4).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbMantenimientodefacturas.getColumnModel().getColumn(5).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbFacturacion.getColumnModel().getColumn(0).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbFacturacion.getColumnModel().getColumn(1).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbFacturacion.getColumnModel().getColumn(2).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbFacturacion.getColumnModel().getColumn(3).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbFacturacion.getColumnModel().getColumn(4).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbFacturacion.getColumnModel().getColumn(5).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbFacturacion.getColumnModel().getColumn(6).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbFacturacion.getColumnModel().getColumn(7).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbFacturacion.getColumnModel().getColumn(8).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       tbFacturacion.getColumnModel().getColumn(9).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
       //Alineación de contenido de columnas.
       DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
       alinear.setHorizontalAlignment(SwingConstants.CENTER);
       tbMantenimientodefacturas.getColumnModel().getColumn(0).setCellRenderer(alinear);
       tbMantenimientodefacturas.getColumnModel().getColumn(1).setCellRenderer(alinear);
       tbMantenimientodefacturas.getColumnModel().getColumn(2).setCellRenderer(alinear);
       tbMantenimientodefacturas.getColumnModel().getColumn(3).setCellRenderer(alinear);
       tbMantenimientodefacturas.getColumnModel().getColumn(4).setCellRenderer(alinear);
       tbMantenimientodefacturas.getColumnModel().getColumn(5).setCellRenderer(alinear);
       tbFacturacion.getColumnModel().getColumn(0).setCellRenderer(alinear);
       tbFacturacion.getColumnModel().getColumn(1).setCellRenderer(alinear);
       tbFacturacion.getColumnModel().getColumn(3).setCellRenderer(alinear);
       tbFacturacion.getColumnModel().getColumn(4).setCellRenderer(alinear);
       tbFacturacion.getColumnModel().getColumn(5).setCellRenderer(alinear);
       tbFacturacion.getColumnModel().getColumn(6).setCellRenderer(alinear);
       tbFacturacion.getColumnModel().getColumn(7).setCellRenderer(alinear);
       // Añadir botones (JLabel) a la tabla.
       tbFacturacion.setDefaultRenderer(Object.class, new IconCellRenderer());
   } 
    
    public jifMantenimientodefacturas(Usuario usr) {
        initComponents();
        Configuracionventana();
        Configuraciontabla();
        this.usr = usr;
        if ("Usuario".equals(usr.getRol())) {
            btAnular.setVisible(false);
            btModificar.setVisible(false);
            cbVenta.setEnabled(false);
            cbModopago.setEnabled(false);
            tfPagado.setEditable(false);
            taComentario.setEditable(false);
            tbFacturacion.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdDetalledefactura = new javax.swing.JDialog();
        jpDatosCliente = new javax.swing.JPanel();
        lbCliente = new javax.swing.JLabel();
        tfCliente = new javax.swing.JTextField();
        lbDireccion = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        cbDocumento = new javax.swing.JComboBox<>();
        tfBusqueda = new javax.swing.JTextField();
        tfCodcliente = new javax.swing.JTextField();
        jpDatosfactura = new javax.swing.JPanel();
        lbTipodefactura = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        tfFecha = new javax.swing.JTextField();
        lbNofactura = new javax.swing.JLabel();
        tfNofactura = new javax.swing.JTextField();
        lbNCF = new javax.swing.JLabel();
        tfNCF = new javax.swing.JTextField();
        lbEstatus = new javax.swing.JLabel();
        tfEstatus = new javax.swing.JTextField();
        plFacturar = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbFacturacion = new javax.swing.JTable();
        lbVenta = new javax.swing.JLabel();
        lbModopago = new javax.swing.JLabel();
        lbPagado = new javax.swing.JLabel();
        cbVenta = new javax.swing.JComboBox<>();
        cbModopago = new javax.swing.JComboBox<>();
        tfPagado = new javax.swing.JTextField();
        lbSubtotal = new javax.swing.JLabel();
        lbITBIS = new javax.swing.JLabel();
        tfSubtotal = new javax.swing.JTextField();
        tfITBIS = new javax.swing.JTextField();
        lbDescto = new javax.swing.JLabel();
        tfDescto = new javax.swing.JTextField();
        lbTotal = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        chbPreventa = new javax.swing.JCheckBox();
        lbComentario = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taComentario = new javax.swing.JTextArea();
        btImprimir = new javax.swing.JButton();
        btAnular = new javax.swing.JButton();
        btCerrarjdDetalledefactura = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        jdAnulacion = new javax.swing.JDialog();
        plAnulacion = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taMotivodeanulacion = new javax.swing.JTextArea();
        jlMotivodeanulacion = new javax.swing.JLabel();
        btAceptar = new javax.swing.JButton();
        btCerrarjdAnulacion = new javax.swing.JButton();
        plBuscar = new javax.swing.JPanel();
        lbTipodebusqueda = new javax.swing.JLabel();
        cbTipodebusqueda = new javax.swing.JComboBox<>();
        tfTipodebusqueda = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMantenimientodefacturas = new javax.swing.JTable();
        btCerrar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        Estatus = new javax.swing.JLabel();

        jdDetalledefactura.setTitle("Factura");
        jdDetalledefactura.setMinimumSize(new java.awt.Dimension(875, 670));
        jdDetalledefactura.setResizable(false);
        jdDetalledefactura.setSize(new java.awt.Dimension(0, 0));

        jpDatosCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpDatosCliente.setToolTipText("Datos del Cliente");
        jpDatosCliente.setName(""); // NOI18N

        lbCliente.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbCliente.setForeground(new java.awt.Color(118, 113, 113));
        lbCliente.setText("Cliente:");

        tfCliente.setEditable(false);
        tfCliente.setBackground(new java.awt.Color(255, 255, 255));
        tfCliente.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        lbDireccion.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbDireccion.setForeground(new java.awt.Color(118, 113, 113));
        lbDireccion.setText("Dirección:");

        tfDireccion.setEditable(false);
        tfDireccion.setBackground(new java.awt.Color(255, 255, 255));
        tfDireccion.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        lbTelefono.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbTelefono.setForeground(new java.awt.Color(118, 113, 113));
        lbTelefono.setText("Teléfono:");

        tfTelefono.setEditable(false);
        tfTelefono.setBackground(new java.awt.Color(255, 255, 255));
        tfTelefono.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        cbDocumento.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 16)); // NOI18N
        cbDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Cédula", "Pasaporte", "RNC" }));
        cbDocumento.setEnabled(false);

        tfBusqueda.setEditable(false);
        tfBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        tfBusqueda.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        tfCodcliente.setEditable(false);
        tfCodcliente.setBackground(new java.awt.Color(255, 255, 255));
        tfCodcliente.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        javax.swing.GroupLayout jpDatosClienteLayout = new javax.swing.GroupLayout(jpDatosCliente);
        jpDatosCliente.setLayout(jpDatosClienteLayout);
        jpDatosClienteLayout.setHorizontalGroup(
            jpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosClienteLayout.createSequentialGroup()
                        .addComponent(cbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(tfCodcliente))
                    .addGroup(jpDatosClienteLayout.createSequentialGroup()
                        .addGroup(jpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jpDatosClienteLayout.createSequentialGroup()
                                    .addComponent(lbCliente)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpDatosClienteLayout.createSequentialGroup()
                                    .addComponent(lbDireccion)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfDireccion)))
                            .addGroup(jpDatosClienteLayout.createSequentialGroup()
                                .addComponent(lbTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpDatosClienteLayout.setVerticalGroup(
            jpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCodcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCliente)
                    .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lbTipodefactura.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        lbTipodefactura.setText("Factura de consumo");

        lbFecha.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(118, 113, 113));
        lbFecha.setText("Fecha:");

        tfFecha.setEditable(false);
        tfFecha.setFont(new java.awt.Font("Browallia New", 1, 16)); // NOI18N
        tfFecha.setBorder(null);

        lbNofactura.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbNofactura.setForeground(new java.awt.Color(118, 113, 113));
        lbNofactura.setText("No. Factura:");

        tfNofactura.setEditable(false);
        tfNofactura.setFont(new java.awt.Font("Browallia New", 1, 16)); // NOI18N
        tfNofactura.setBorder(null);

        lbNCF.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbNCF.setForeground(new java.awt.Color(118, 113, 113));
        lbNCF.setText("NCF:");

        tfNCF.setEditable(false);
        tfNCF.setFont(new java.awt.Font("Browallia New", 1, 16)); // NOI18N
        tfNCF.setBorder(null);

        lbEstatus.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbEstatus.setForeground(new java.awt.Color(118, 113, 113));
        lbEstatus.setText("Estatus:");

        tfEstatus.setEditable(false);
        tfEstatus.setFont(new java.awt.Font("Browallia New", 1, 16)); // NOI18N
        tfEstatus.setBorder(null);

        javax.swing.GroupLayout jpDatosfacturaLayout = new javax.swing.GroupLayout(jpDatosfactura);
        jpDatosfactura.setLayout(jpDatosfacturaLayout);
        jpDatosfacturaLayout.setHorizontalGroup(
            jpDatosfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosfacturaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpDatosfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTipodefactura, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatosfacturaLayout.createSequentialGroup()
                        .addGroup(jpDatosfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNCF)
                            .addComponent(lbFecha)
                            .addComponent(lbNofactura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatosfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNCF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(tfFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfNofactura)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatosfacturaLayout.createSequentialGroup()
                        .addComponent(lbEstatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpDatosfacturaLayout.setVerticalGroup(
            jpDatosfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosfacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTipodefactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosfacturaLayout.createSequentialGroup()
                        .addComponent(tfNCF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDatosfacturaLayout.createSequentialGroup()
                        .addComponent(lbNCF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFecha)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNofactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNofactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpDatosfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEstatus))
                .addContainerGap())
        );

        plFacturar.setToolTipText("");
        plFacturar.setName(""); // NOI18N
        plFacturar.setPreferredSize(new java.awt.Dimension(400, 400));

        jScrollPane6.setMinimumSize(new java.awt.Dimension(480, 400));
        jScrollPane6.setPreferredSize(new java.awt.Dimension(480, 400));

        tbFacturacion.setAutoCreateRowSorter(true);
        tbFacturacion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbFacturacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Código", "Descripción", "Precio und.", "Cant.", "Precio", "Descto.", "ITBIS", "Monto", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFacturacion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbFacturacion.setMinimumSize(new java.awt.Dimension(840, 150));
        tbFacturacion.setPreferredSize(new java.awt.Dimension(840, 150));
        tbFacturacion.setRowHeight(25);
        tbFacturacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbFacturacionKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(tbFacturacion);

        lbVenta.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbVenta.setForeground(new java.awt.Color(118, 113, 113));
        lbVenta.setText("Venta:");

        lbModopago.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbModopago.setForeground(new java.awt.Color(118, 113, 113));
        lbModopago.setText("Modo de pago:");

        lbPagado.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbPagado.setForeground(new java.awt.Color(118, 113, 113));
        lbPagado.setText("Pagado:");

        cbVenta.setBackground(new java.awt.Color(217, 217, 217));
        cbVenta.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 16)); // NOI18N
        cbVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Crédito" }));

        cbModopago.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 16)); // NOI18N
        cbModopago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta", "Cheque", "Transferencia", "Nota crédito" }));

        tfPagado.setEditable(false);
        tfPagado.setFont(new java.awt.Font("Browallia New", 0, 16)); // NOI18N
        tfPagado.setText("RD$0.00");
        tfPagado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPagadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPagadoFocusLost(evt);
            }
        });
        tfPagado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tfPagadoMousePressed(evt);
            }
        });
        tfPagado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPagadoKeyPressed(evt);
            }
        });

        lbSubtotal.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbSubtotal.setForeground(new java.awt.Color(118, 113, 113));
        lbSubtotal.setText("Subtotal:");

        lbITBIS.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbITBIS.setForeground(new java.awt.Color(118, 113, 113));
        lbITBIS.setText("ITBIS:");

        tfSubtotal.setEditable(false);
        tfSubtotal.setFont(new java.awt.Font("Browallia New", 0, 16)); // NOI18N
        tfSubtotal.setText("RD$0.00");

        tfITBIS.setEditable(false);
        tfITBIS.setFont(new java.awt.Font("Browallia New", 0, 16)); // NOI18N
        tfITBIS.setText("RD$0.00");

        lbDescto.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbDescto.setForeground(new java.awt.Color(118, 113, 113));
        lbDescto.setText("Descto.:");

        tfDescto.setEditable(false);
        tfDescto.setFont(new java.awt.Font("Browallia New", 0, 16)); // NOI18N
        tfDescto.setText("RD$0.00");

        lbTotal.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(118, 113, 113));
        lbTotal.setText("Total:");

        tfTotal.setEditable(false);
        tfTotal.setFont(new java.awt.Font("Browallia New", 0, 16)); // NOI18N
        tfTotal.setText("RD$0.00");

        chbPreventa.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        chbPreventa.setForeground(new java.awt.Color(118, 113, 113));
        chbPreventa.setText("Pre-Venta");

        lbComentario.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbComentario.setForeground(new java.awt.Color(118, 113, 113));
        lbComentario.setText("Comentario:");

        taComentario.setColumns(20);
        taComentario.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        taComentario.setRows(5);
        jScrollPane2.setViewportView(taComentario);

        btImprimir.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btImprimir.setText("Imprimir");
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });

        btAnular.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btAnular.setText("Anular");
        btAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnularActionPerformed(evt);
            }
        });

        btCerrarjdDetalledefactura.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrarjdDetalledefactura.setText("Cerrar");
        btCerrarjdDetalledefactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarjdDetalledefacturaActionPerformed(evt);
            }
        });

        btModificar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plFacturarLayout = new javax.swing.GroupLayout(plFacturar);
        plFacturar.setLayout(plFacturarLayout);
        plFacturarLayout.setHorizontalGroup(
            plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plFacturarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plFacturarLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(plFacturarLayout.createSequentialGroup()
                        .addComponent(chbPreventa)
                        .addGap(185, 769, Short.MAX_VALUE))
                    .addGroup(plFacturarLayout.createSequentialGroup()
                        .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbComentario)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                                .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                                        .addComponent(lbVenta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                                        .addComponent(lbPagado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                                        .addComponent(lbModopago)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbModopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25)
                                .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                                        .addComponent(lbSubtotal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                                        .addComponent(lbDescto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDescto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                                        .addComponent(lbITBIS)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfITBIS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                                        .addComponent(lbTotal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                                .addComponent(btModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btImprimir)
                                .addGap(4, 4, 4)
                                .addComponent(btAnular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCerrarjdDetalledefactura)))
                        .addContainerGap())))
        );
        plFacturarLayout.setVerticalGroup(
            plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plFacturarLayout.createSequentialGroup()
                .addComponent(chbPreventa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbVenta)
                    .addComponent(tfSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSubtotal)
                    .addComponent(lbComentario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plFacturarLayout.createSequentialGroup()
                        .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbModopago)
                            .addComponent(cbModopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDescto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDescto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPagado)
                            .addComponent(tfPagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfITBIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbITBIS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTotal)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAnular)
                            .addComponent(btImprimir)
                            .addComponent(btCerrarjdDetalledefactura)
                            .addComponent(btModificar)))
                    .addGroup(plFacturarLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jdDetalledefacturaLayout = new javax.swing.GroupLayout(jdDetalledefactura.getContentPane());
        jdDetalledefactura.getContentPane().setLayout(jdDetalledefacturaLayout);
        jdDetalledefacturaLayout.setHorizontalGroup(
            jdDetalledefacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdDetalledefacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdDetalledefacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(plFacturar, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                    .addGroup(jdDetalledefacturaLayout.createSequentialGroup()
                        .addComponent(jpDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpDatosfactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jdDetalledefacturaLayout.setVerticalGroup(
            jdDetalledefacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdDetalledefacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jdDetalledefacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDatosfactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jdAnulacion.setTitle("Anulación");

        plAnulacion.setBackground(new java.awt.Color(255, 255, 255));

        taMotivodeanulacion.setColumns(20);
        taMotivodeanulacion.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        taMotivodeanulacion.setRows(5);
        jScrollPane3.setViewportView(taMotivodeanulacion);

        jlMotivodeanulacion.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        jlMotivodeanulacion.setText("Motivo de anulación*:");

        btAceptar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        btCerrarjdAnulacion.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrarjdAnulacion.setText("Cerrar");
        btCerrarjdAnulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarjdAnulacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plAnulacionLayout = new javax.swing.GroupLayout(plAnulacion);
        plAnulacion.setLayout(plAnulacionLayout);
        plAnulacionLayout.setHorizontalGroup(
            plAnulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plAnulacionLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(plAnulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(plAnulacionLayout.createSequentialGroup()
                        .addComponent(btAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCerrarjdAnulacion))
                    .addGroup(plAnulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlMotivodeanulacion)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        plAnulacionLayout.setVerticalGroup(
            plAnulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plAnulacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlMotivodeanulacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(plAnulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAceptar)
                    .addComponent(btCerrarjdAnulacion))
                .addContainerGap())
        );

        javax.swing.GroupLayout jdAnulacionLayout = new javax.swing.GroupLayout(jdAnulacion.getContentPane());
        jdAnulacion.getContentPane().setLayout(jdAnulacionLayout);
        jdAnulacionLayout.setHorizontalGroup(
            jdAnulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plAnulacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdAnulacionLayout.setVerticalGroup(
            jdAnulacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plAnulacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setTitle("Mantenimiento de facturas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/mantenimientofactura.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(860, 590));
        setPreferredSize(new java.awt.Dimension(860, 590));

        lbTipodebusqueda.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbTipodebusqueda.setForeground(new java.awt.Color(118, 113, 113));
        lbTipodebusqueda.setText("Tipo de búsqueda*");

        cbTipodebusqueda.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 16)); // NOI18N
        cbTipodebusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No. Factura", "Cliente", "Fecha" }));
        cbTipodebusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipodebusquedaActionPerformed(evt);
            }
        });

        tfTipodebusqueda.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfTipodebusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTipodebusquedaKeyPressed(evt);
            }
        });

        btBuscar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 16)); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        tbMantenimientodefacturas.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbMantenimientodefacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No. Factura", "Cliente", "Fecha / Hora", "Venta", "Total", "Estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMantenimientodefacturas.setRowHeight(22);
        tbMantenimientodefacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMantenimientodefacturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMantenimientodefacturas);

        btCerrar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        btLimpiar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btLimpiar.setText("Limpiar");

        jdcFecha.setDateFormatString("yyyy-MM-dd");
        jdcFecha.setEnabled(false);

        this.setVisible(false);
        Estatus.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        Estatus.setForeground(new java.awt.Color(240, 240, 240));
        Estatus.setEnabled(false);

        javax.swing.GroupLayout plBuscarLayout = new javax.swing.GroupLayout(plBuscar);
        plBuscar.setLayout(plBuscarLayout);
        plBuscarLayout.setHorizontalGroup(
            plBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plBuscarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbTipodebusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Estatus)
                .addGap(0, 159, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plBuscarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCerrar)))
                .addContainerGap())
        );
        plBuscarLayout.setVerticalGroup(
            plBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plBuscarLayout.createSequentialGroup()
                .addGroup(plBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plBuscarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(plBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbTipodebusqueda)
                            .addComponent(cbTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBuscar))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
                    .addGroup(plBuscarLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(Estatus)
                        .addGap(471, 471, 471)))
                .addGap(18, 18, 18)
                .addGroup(plBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCerrar)
                    .addComponent(btLimpiar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(plBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed

        if (taMotivodeanulacion.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(jdAnulacion, "El motivo de anulación debe superar los 10 caracteres.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
        } else {
            int opcion = JOptionPane.showConfirmDialog(jdAnulacion, "¿Esta seguro que desea anular está factura?", "PRECAUCIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == 0) {
                try {
                    // Conexion a la base de datos.
                    Connection conn = con.getConnection();
                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jdAnulacion_ACTUALIZAR_ESTATUS (?) }");
                    // Parametros de consulta.
                    ps.setInt(1, Integer.parseInt(tfNofactura.getText()));

                    rs = ps.executeQuery();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jdAnulacion_INSERTAR_COMENTARIO (?,?) }");
                    // Parametros de consulta.
                    ps.setInt(1, Integer.parseInt(tfNofactura.getText()));
                    ps.setString(2, taMotivodeanulacion.getText());

                    rs = ps.executeQuery();

                    conn.close();

                    JOptionPane.showMessageDialog(jdAnulacion, "La factura No. " + tfNofactura.getText() + " se ha anulada correctamente.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                    
                    jdAnulacion.dispose();
                    jdDetalledefactura.dispose();
                    Buscar_Factura();
                    //tfEstatus.setText("INACTIVO");

                    if ("ACTIVO".equals(tfEstatus.getText())) {
                        tfEstatus.setForeground(Color.green);
                    } else if ("INACTIVO".equals(tfEstatus.getText())) {
                        tfEstatus.setForeground(Color.red);
                    }

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(jdAnulacion, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btAceptarActionPerformed

    private void btCerrarjdAnulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarjdAnulacionActionPerformed
        jdAnulacion.dispose();
    }//GEN-LAST:event_btCerrarjdAnulacionActionPerformed

    private void btAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnularActionPerformed
        if (valida.Validacion_Estatus_Factura("factura", "estatus", tfNofactura.getText()) == false) {
            JOptionPane.showMessageDialog(null, "La factura NO. " + tfNofactura.getText() + " ya esta en estatus INACTIVO.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jdAnulacion.setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/cancelar.png")).getImage());
            jdAnulacion.setSize(390, 294);
            jdAnulacion.setLocationRelativeTo(null);
            jdAnulacion.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jdAnulacion.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            jdAnulacion.setVisible(true);
        }
    }//GEN-LAST:event_btAnularActionPerformed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed

        if (valida.Validacion_Estatus_Factura("factura", "estatus", tfNofactura.getText()) == false) {
            JOptionPane.showMessageDialog(null, "La factura No. " + tfNofactura.getText() + " esta en estatus INACTIVO, no es posible imprimirla.", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
        } else {

            FacturaSCOA facturascoa;
            ArrayList coleccion = new ArrayList();
            ArrayList articulos = new ArrayList();
            DateFormat indateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // formato de entrada de fecha.
            DateFormat outdateFormat = new SimpleDateFormat("dd-MM-yyyy / hh:mm a"); // formato de salida de fecha.
            String currentTime = tfFecha.getText();
            Date indate = null;
            
            for (int i = 0; i < dtmtbFacturacion.getRowCount(); i++) {
                articulos.add(dtmtbFacturacion.getValueAt(i, 4)); // cantidad
                articulos.add(dtmtbFacturacion.getValueAt(i, 6)); // descuento
            }

            if (valida.Modificacion_factura(Integer.parseInt(tfNofactura.getText()), articulos, cbVenta.getSelectedItem().toString(), cbModopago.getSelectedItem().toString(), Double.valueOf(tfPagado.getText().replaceAll("[^\\d.]", "")), taComentario.getText())) {
                JOptionPane.showMessageDialog(jdDetalledefactura, "Existen cambios en la factura, por favor guarde las modificaciones.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    indate = indateFormat.parse(currentTime);

                    if (!"Factura de Consumo".equals(lbTipodefactura.getText())) {
                        for (int i = 0; i < tbFacturacion.getRowCount(); i++) {
                            facturascoa = new FacturaSCOA(lbTipodefactura.getText(), tfNCF.getText(), Vigencia_comprobante(), icono.getImage(), "RNC:", tfBusqueda.getText(), tfCliente.getText(), tfTelefono.getText(), tfCodcliente.getText(), currentTime, tfNofactura.getText(), dtmtbFacturacion.getValueAt(i, 1).toString(), dtmtbFacturacion.getValueAt(i, 2).toString(), dtmtbFacturacion.getValueAt(i, 7).toString(), dtmtbFacturacion.getValueAt(i, 4).toString(), dtmtbFacturacion.getValueAt(i, 3).toString(), tfSubtotal.getText(), tfDescto.getText(), tfITBIS.getText(), tfTotal.getText(), cbVenta.getSelectedItem().toString(), cbModopago.getSelectedItem().toString(), tfPagado.getText(), usr.getNombre(), taComentario.getText());
                            coleccion.add(facturascoa);
                        }
                    } else {
                        for (int i = 0; i < tbFacturacion.getRowCount(); i++) {
                            facturascoa = new FacturaSCOA(lbTipodefactura.getText() // n_comprobante
                                                            , tfNCF.getText() // comprobante
                                                            , Vigencia_comprobante() // fecha_vencimiento
                                                            , icono.getImage() // imagen
                                                            , "RNC:" // documento
                                                            , tfBusqueda.getText() // rnc
                                                            , tfCliente.getText() // cliente
                                                            , tfTelefono.getText() // telefono
                                                            , tfCodcliente.getText() // codcliente
                                                            , currentTime // fecha
                                                            , tfNofactura.getText() // nofactura
                                                            , dtmtbFacturacion.getValueAt(i, 1).toString() // codigo
                                                            , dtmtbFacturacion.getValueAt(i, 2).toString() // descripcion
                                                            , dtmtbFacturacion.getValueAt(i, 7).toString() // itbis
                                                            , dtmtbFacturacion.getValueAt(i, 4).toString() // cantidad
                                                            , dtmtbFacturacion.getValueAt(i, 3).toString() // precio
                                                            , tfSubtotal.getText() // subtotal
                                                            , tfDescto.getText() // descto
                                                            , tfITBIS.getText() // t_itbis
                                                            , tfTotal.getText() // total
                                                            , cbVenta.getSelectedItem().toString() // venta
                                                            , cbModopago.getSelectedItem().toString() // mpago
                                                            , tfPagado.getText() // pagado
                                                            , usr.getNombre() // usuario
                                                            , taComentario.getText()); // comentario
                            
                            /*facturascoa = new FacturaSCOA(lbTipodefactura.getText()
                                                        , tfNCF.getText()
                                                        , Vigencia_comprobante()
                                                        , icono.getImage()
                                                        , cbDocumento.getSelectedItem().toString() + ":"
                                                        , tfBusqueda.getText()
                                                        , tfCliente.getText()
                                                        , tfTelefono.getText()
                                                        , tfCodcliente.getText()
                                                        , currentTime
                                                        , tfNofactura.getText()
                                                        , dtmtbFacturacion.getValueAt(i, 1).toString()
                                                        , dtmtbFacturacion.getValueAt(i, 2).toString()
                                                        , dtmtbFacturacion.getValueAt(i, 7).toString()
                                                        , dtmtbFacturacion.getValueAt(i, 4).toString()
                                                        , dtmtbFacturacion.getValueAt(i, 3).toString()
                                                        , tfSubtotal.getText()
                                                        , tfDescto.getText()
                                                        , tfITBIS.getText()
                                                        , tfTotal.getText()
                                                        , cbVenta.getSelectedItem().toString()
                                                        , cbModopago.getSelectedItem().toString()
                                                        , tfPagado.getText()
                                                        , usr.getNombre()
                                                        , taComentario.getText());*/
                            coleccion.add(facturascoa);
                        }
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(jifMantenimientodefacturas.class.getName()).log(Level.SEVERE, null, ex);
                }
                reporte.Factura(coleccion);
            }
        }
    }//GEN-LAST:event_btImprimirActionPerformed

    private void btCerrarjdDetalledefacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarjdDetalledefacturaActionPerformed
        jdDetalledefactura.dispose();
        chbPreventa.setEnabled(true);
        if (chbPreventa.isSelected()) {
            chbPreventa.doClick();
        }
        Buscar_Factura();
    }//GEN-LAST:event_btCerrarjdDetalledefacturaActionPerformed

    private void tbFacturacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbFacturacionKeyPressed
        
        int fila = tbFacturacion.getSelectedRow(); // Obtener fila.
        int columna = tbFacturacion.getSelectedColumn(); // Obtener columna.

        if (columna == 4) { // Columna Cantidad
            if (dtmtbFacturacion.getValueAt(fila, 4) == null || Integer.parseInt(dtmtbFacturacion.getValueAt(fila, 4).toString()) == 0) { // Columna "Cantidad".
                dtmtbFacturacion.setValueAt(1, fila, 4); // Si la columna "Cantidad" esta vacia, asigna un valor de 1.
                dtmtbFacturacion.fireTableDataChanged(); // Ejecuta el cambio.
            }

            Double[] calculos = new Double[6];
            String itbis = null;

            try {
                //Consulta a la base de datos.
                Connection conn = con.getConnection();

                ps = conn.prepareCall("{ call jifFacturar_BUSCAR_ARTICULO (?) }");

                // Parametros de consulta.
                ps.setString(1, dtmtbFacturacion.getValueAt(fila, 1).toString());

                rs = ps.executeQuery();

                // Recorrido de datos para obtencion de los resultados de la consulta.
                while (rs.next()) {
                    calculos[0] = rs.getDouble(3); // Captura el preciound desde la base de datos.
                    itbis = rs.getString(4); // Captura si el articulo lleva itbis o no.
                }

                conn.close();

                calculos[1] = Double.parseDouble(dtmtbFacturacion.getValueAt(fila, 4).toString()); // Columna "Cantidad". 
                calculos[2] = Double.parseDouble(dtmtbFacturacion.getValueAt(fila, 6).toString())/100; // Columna "Descto".
                calculos[3] = (calculos[0] * calculos[1]); // Calcula precio por la cantidad.
                calculos[5] = calculos[3] - (calculos[3]*calculos[2]); // calcula precion con descuento.
                
                if ("Si".equals(itbis)) {
                    calculos[4] = Double.parseDouble(calculos[5].toString()) * ITBIS; // Calcula el ITBIS
                    dtmtbFacturacion.setValueAt(calculos[3], fila, 5); // Precio.
                    dtmtbFacturacion.setValueAt(calculos[4], fila, 7); // ITBIS.
                    dtmtbFacturacion.setValueAt((calculos[5] + calculos[4]), fila, 8); // Monto.
                } else {
                    calculos[4] = Double.parseDouble("0.00"); // ITBIS
                    dtmtbFacturacion.setValueAt(calculos[3], fila, 5); // Precio.
                    dtmtbFacturacion.setValueAt(calculos[5], fila, 8); // Monto.
                }

                dtmtbFacturacion.fireTableDataChanged(); // Ejecuta el cambio.

                CalcularTotal();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (columna == 6) { // Columna Descuento
            if (dtmtbFacturacion.getValueAt(fila, 6) == null) { // Evalua si la columna "Descuento" esta vacia.
                dtmtbFacturacion.setValueAt(0.00, fila, 6); // Si la columna "Descuento" esta vacia, asigna un valor de 0.0.
                dtmtbFacturacion.fireTableDataChanged(); // Ejecuta el cambio.
            }

            Double[] calculos = new Double[4];

            calculos[0] = Double.parseDouble(dtmtbFacturacion.getValueAt(fila, 5).toString()); // Columna "precio".
            calculos[1] = Double.parseDouble(dtmtbFacturacion.getValueAt(fila, 6).toString())/100; // Columna descto.
            calculos[2] = calculos[0] - (calculos[0]*calculos[1]); // Calcula precio con descuento.
            
            if (Double.valueOf(dtmtbFacturacion.getValueAt(fila, 7).toString()) != 0.0) { // valida si la columna ITBIS es diferente a 0.0
                calculos[3] = calculos[2] * ITBIS; // Calcula ITBIS. (calculos[0] - (calculos[0]*calculos[1]))
                dtmtbFacturacion.setValueAt(calculos[3], fila, 7); // ITBIS.
                dtmtbFacturacion.setValueAt(calculos[2] + calculos[3], fila, 8); // Monto.
            } else {
                calculos[3] = Double.parseDouble("0.00"); // ITBIS
                dtmtbFacturacion.setValueAt(calculos[2], fila, 8); // Monto.
                dtmtbFacturacion.setValueAt(calculos[3], fila, 7); // ITBIS.
            }

            dtmtbFacturacion.fireTableDataChanged(); // Ejecuta el cambio.

            CalcularTotal();
        }
    }//GEN-LAST:event_tbFacturacionKeyPressed

    private void tfPagadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPagadoMousePressed
        tfPagado.selectAll();
    }//GEN-LAST:event_tfPagadoMousePressed

    private void tfPagadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPagadoKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            btModificar.requestFocus();
        }
    }//GEN-LAST:event_tfPagadoKeyPressed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed

        int opcion = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea modificar está factura?", "PRECAUCIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == 0) {
            if (Valida_cantidad() == false) {
                // No se puso acción porque la alerta vendra desde el metodo Valida_cantidad ().
            } else if ("Contado".equals(cbVenta.getSelectedItem())) {
                if (Double.valueOf(tfPagado.getText().replaceAll("[^\\d.]", "")) > Double.valueOf(tfTotal.getText().replaceAll("[^\\d.]", ""))) {
                    tfPagado.setText(tfTotal.getText());
                }
                if (tfPagado.getText() == null ? tfTotal.getText() != null : !tfPagado.getText().equals(tfTotal.getText())) {
                    JOptionPane.showMessageDialog(null, "Venta al contado: Se debe aplicar la cantidad exacta que se visualiza en el total.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {

                        // Conexion a la base de datos.
                        Connection conn = con.getConnection();

                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{ call jdDetalledefactura_ACTUALIZAR_FACTURA (?,?,?,?,?,?,?,?,?) }");

                        // Parametos
                        ps.setInt(1, Integer.parseInt(tfNofactura.getText())); // No. factura.
                        ps.setString(2, cbVenta.getSelectedItem().toString()); // Tipo de venta.
                        ps.setString(3, cbModopago.getSelectedItem().toString()); // Modo de pago.
                        ps.setDouble(4, Double.parseDouble(tfPagado.getText().substring(3).replace(",", "").trim())); // Envia el monto pagado.
                        ps.setDouble(5, Double.parseDouble(tfSubtotal.getText().substring(3).replace(",", "").trim())); // Envia el  Subtotal.
                        ps.setDouble(6, Double.parseDouble(tfDescto.getText().substring(3).replace(",", "").trim())); // Envia el descuento.
                        ps.setDouble(7, Double.parseDouble(tfITBIS.getText().substring(3).replace(",", "").trim())); // Envia el ITBIS.
                        ps.setDouble(8, Double.parseDouble(tfTotal.getText().substring(3).replace(",", "").trim())); // Envia el total.
                        ps.setString(9, taComentario.getText()); // Comentarios.

                        // Ejecución de consulta
                        rs = ps.executeQuery();

                        Actualizar_inventario();

                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{ call jdDetalledefactura_ACTUALIZAR_DETALLE_FACT (?,?,?,?,?,?,?) }");

                        for (int i = 0; i < dtmtbFacturacion.getRowCount(); i++) {
                            // Parametros de consulta.
                            ps.setInt(1, Integer.parseInt(tfNofactura.getText())); // Envia el numero de factura
                            ps.setString(2, dtmtbFacturacion.getValueAt(i, 1).toString()); // Envia el codigo del artículo.
                            ps.setInt(3, Integer.parseInt(dtmtbFacturacion.getValueAt(i, 4).toString())); // Envia la cantidad.
                            ps.setDouble(4, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 5).toString())); // Envia el precio.
                            ps.setDouble(5, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 6).toString())); // Envia el descuento.
                            ps.setDouble(6, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 7).toString())); // Envia el ITBIS.
                            ps.setDouble(7, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 8).toString())); // Envia el monto.

                            // Ejecución de consulta
                            rs = ps.executeQuery();
                        }

                        // Cierre de conexión
                        conn.close();

                        JOptionPane.showMessageDialog(jdDetalledefactura, "La factura " + tfNofactura.getText() + " a sido modificada.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(jdDetalledefactura, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if ("Crédito".equals(cbVenta.getSelectedItem())) {
                if (Double.valueOf(tfPagado.getText().replaceAll("[^\\d.]", "")) > Double.valueOf(tfTotal.getText().replaceAll("[^\\d.]", ""))) {
                    tfPagado.setText(tfTotal.getText());
                }
                if (tfPagado.getText().trim().isEmpty()) {
                    tfPagado.setText("0.00");
                }
                try {

                    // Conexion a la base de datos.
                    Connection conn = con.getConnection();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jdDetalledefactura_ACTUALIZAR_FACTURA (?,?,?,?,?,?,?,?,?) }");

                    // Parametos
                    ps.setInt(1, Integer.parseInt(tfNofactura.getText())); // No. factura-
                    ps.setString(2, cbVenta.getSelectedItem().toString()); // Tipo de venta.
                    ps.setString(3, cbModopago.getSelectedItem().toString()); // Modo de pago.
                    ps.setDouble(4, Double.parseDouble(tfPagado.getText().substring(3).replace(",", "").trim())); // Envia el monto pagado.
                    ps.setDouble(5, Double.parseDouble(tfSubtotal.getText().substring(3).replace(",", "").trim())); // Envia el  Subtotal.
                    ps.setDouble(6, Double.parseDouble(tfDescto.getText().substring(3).replace(",", "").trim())); // Envia el descuento.
                    ps.setDouble(7, Double.parseDouble(tfITBIS.getText().substring(3).replace(",", "").trim())); // Envia el ITBIS.
                    ps.setDouble(8, Double.parseDouble(tfTotal.getText().substring(3).replace(",", "").trim())); // Envia el total.
                    ps.setString(9, taComentario.getText()); // Comentarios.

                    // Ejecución de consulta
                    rs = ps.executeQuery();

                    Actualizar_inventario();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jdDetalledefactura_ACTUALIZAR_DETALLE_FACT (?,?,?,?,?,?,?) }");

                    for (int i = 0; i < dtmtbFacturacion.getRowCount(); i++) {
                        // Parametros de consulta.
                        ps.setInt(1, Integer.parseInt(tfNofactura.getText())); // Envia el numero de factura
                        ps.setString(2, dtmtbFacturacion.getValueAt(i, 1).toString()); // Envia el codigo del artículo.
                        ps.setInt(3, Integer.parseInt(dtmtbFacturacion.getValueAt(i, 4).toString())); // Envia la cantidad.
                        ps.setDouble(4, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 5).toString())); // Envia el precio.
                        ps.setDouble(5, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 6).toString())); // Envia el descuento.
                        ps.setDouble(6, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 7).toString())); // Envia el ITBIS.
                        ps.setDouble(7, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 8).toString())); // Envia el monto.

                        // Ejecución de consulta
                        rs = ps.executeQuery();
                    }

                    // Cierre de conexión
                    conn.close();

                    JOptionPane.showMessageDialog(jdDetalledefactura, "La factura " + tfNofactura.getText() + " a sido modificada.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(jdDetalledefactura, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

    private void tbMantenimientodefacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMantenimientodefacturasMouseClicked
        int fila = tbMantenimientodefacturas.rowAtPoint(evt.getPoint());
        
        if (tbFacturacion.isEnabled() == false) {
            tbFacturacion.setEnabled(true);
        }

        if (evt.getClickCount() == 2) {

            dtmtbFacturacion.setRowCount(0);

            Object[] registro = new Object[10];
            String telefono = null; // numero de telefono
            String patron = "(%s) %s-%s"; // patron de formato para el numero de telefono

            // Sección de codigo para dar formato a las columna de tipo double. Solo se mostrara dos decimales.
            NumberFormat formatodecimal = NumberFormat.getCurrencyInstance(new Locale("es", "DO"));

            try {
                // Conexion a la base de datos.
                Connection conn = con.getConnection();
                // Consulta a la base de datos.
                ps = conn.prepareCall("{ call jdDetalledefactura_BUSCAR_FACTURAS (?) }");
                // Parametros de consulta.
                ps.setInt(1, Integer.parseInt(dtmtbMantenimientodefacturas.getValueAt(tbMantenimientodefacturas.getSelectedRow(), 0).toString()));

                rs = ps.executeQuery();

                if (rs.next()) {
                    tfCodcliente.setText(String.valueOf(rs.getInt(1))); // Código cliente.
                    tfBusqueda.setText(rs.getString(2)); // No. de documento.
                    cbDocumento.setSelectedItem(rs.getString(3)); // Tipo de documento.
                    tfCliente.setText(rs.getString(4)); // Nombre del cliente.
                    tfDireccion.setText(rs.getString(5)); // Dirección.
                    telefono = rs.getString(6); // Télefono
                    tfTelefono.setText(String.format(patron, telefono.substring(0, 3), telefono.substring(3, 6), telefono.substring(6))); // Télefono con formato.
                    tfNofactura.setText(String.valueOf(rs.getInt(7))); // No. factura.
                    tfNCF.setText(rs.getString(8)); // No. comprobante.
                    tfFecha.setText(rs.getString(9)); // Fecha y hora.
                    cbVenta.setSelectedItem(rs.getString(10)); // Tipo de venta.
                    cbModopago.setSelectedItem(rs.getString(11)); // Modo de pago.
                    tfPagado.setText(formatodecimal.format(rs.getDouble(12))); // Cantidad pagada.
                    tfEstatus.setText(rs.getString(18)); // Estatus.
                    taComentario.setText(rs.getString(19)); // Comentario.
                    if ("Si".equals(rs.getString(20))) { // Evalua si fue pre-venta o no
                        chbPreventa.doClick();
                        chbPreventa.setEnabled(false);
                    } else {
                        chbPreventa.setEnabled(false);
                    }
                    do {
                        registro[0] = dtmtbFacturacion.getRowCount() + 1; // No.orden artículo
                        registro[1] = rs.getString(21); // Código artículo.
                        registro[2] = rs.getString(22); // Descripción.
                        registro[3] = rs.getDouble(28); // precio und.
                        registro[4] = rs.getInt(23); // Cantidad.
                        registro[5] = rs.getDouble(24); // Precio.
                        registro[6] = rs.getDouble(25); // Descuento.
                        registro[7] = rs.getDouble(26); // ITBIS artículo.
                        registro[8] = rs.getDouble(27); // Monto.
                        registro[9] = new JLabel(); // Boton borrar
                        dtmtbFacturacion.addRow(registro);
                    } while (rs.next());
                }

                // Cierre de conexión.
                conn.close();

                if ("ACTIVO".equals(tfEstatus.getText())) {
                    tfEstatus.setForeground(Color.green);
                } else if ("INACTIVO".equals(tfEstatus.getText())) {
                    tfEstatus.setForeground(Color.red);
                }

                Tipo_factura();
                CalcularTotal();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }

            if (valida.Validacion_Estatus_Factura("factura", "estatus", dtmtbMantenimientodefacturas.getValueAt(fila, 0).toString()) == false || "Usuario".equals(usr.getRol())) {
                cbVenta.setEnabled(false);
                cbModopago.setEnabled(false);
                tfPagado.setEditable(false);
                taComentario.setEditable(false);
                btModificar.setEnabled(false);
                tbFacturacion.setEnabled(false);
            }
            jdDetalledefactura.setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/facturar.png")).getImage());
            jdDetalledefactura.setSize(875, 670);            //jdDetalledefactura.setSize(895, 620);
            jdDetalledefactura.setLocationRelativeTo(null);
            jdDetalledefactura.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            jdDetalledefactura.setVisible(true);
        }
    }//GEN-LAST:event_tbMantenimientodefacturasMouseClicked

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed

        if ("No. Factura".equals(cbTipodebusqueda.getSelectedItem())) {
            if (valida.isNumeric(tfTipodebusqueda.getText()) == false) {
                JOptionPane.showMessageDialog(null, "El tipo de busqueda seleccionado solo permite números.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
            } else {
                Buscar_Factura();
            }
        } else if ("Cliente".equals(cbTipodebusqueda.getSelectedItem())) {
            Buscar_Factura();
        } else if ("Fecha".equals(cbTipodebusqueda.getSelectedItem())) {
            Buscar_Factura();
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tfTipodebusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTipodebusquedaKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            btBuscar.requestFocus();
        }
    }//GEN-LAST:event_tfTipodebusquedaKeyPressed

    private void cbTipodebusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipodebusquedaActionPerformed
        if ("Fecha".equals(cbTipodebusqueda.getSelectedItem())) {
            jdcFecha.setEnabled(true);
            tfTipodebusqueda.setEnabled(false);
            tfTipodebusqueda.setText(null);
        } else {
            jdcFecha.setEnabled(false);
            tfTipodebusqueda.setEnabled(true);
        }
    }//GEN-LAST:event_cbTipodebusquedaActionPerformed

    private void tfPagadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPagadoFocusGained
        if (tfPagado.isEditable() == true) {
            tfPagado.selectAll();
        }
    }//GEN-LAST:event_tfPagadoFocusGained

    private void tfPagadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPagadoFocusLost
        if (tfPagado.isEditable() == true) {
            // Sección de codigo para dar formato a las columna de tipo double. Solo se mostrara dos decimales.
            NumberFormat formatodecimal = NumberFormat.getCurrencyInstance(new Locale("es", "DO"));

            if (tfPagado.getText().trim().isEmpty() == true) {
                tfPagado.setText("0.00");
            } else if (valida.isNumeric(tfPagado.getText().trim()) == false) {
                JOptionPane.showMessageDialog(null, "No puedes digital texto en este campo.", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
            } else {
                double monto = Double.parseDouble(tfPagado.getText().trim());
                tfPagado.setText(String.valueOf(formatodecimal.format(monto)));
            }
        }
    }//GEN-LAST:event_tfPagadoFocusLost
    // Busqueda de factura en la base de datos.
    private void Buscar_Factura() {
        // Sección de codigo para dar formato a las columna de tipo double. Solo se mostrara dos decimales.
        NumberFormat formatodecimal = NumberFormat.getCurrencyInstance(new Locale("es", "DO"));
        
        // Formato de fecha.
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Object[] registro = new Object[7];
        dtmtbMantenimientodefacturas.setRowCount(0);

        try {
            // Conexion a la base de datos.
            Connection conn = con.getConnection();
            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifMantenimientodefacturas_BUSCAR_FACTURAS (?,?) }");
            // Parametros de consulta.
            ps.setString(1, cbTipodebusqueda.getSelectedItem().toString());
            if ("Fecha".equals(cbTipodebusqueda.getSelectedItem())) {
                ps.setString(2, "%" + dateFormat.format(jdcFecha.getDate()) + "%");
            } else {
                ps.setString(2, "%" + tfTipodebusqueda.getText() + "%");
            }

            rs = ps.executeQuery();
            // Recorrido de datos para obtencion de los resultados de la consulta.
            while (rs.next()) {
                registro[0] = rs.getInt(1); // No. factura.
                registro[1] = rs.getString(2); // Cliente.
                registro[2] = rs.getString(3); // Fecha y hora.
                registro[3] = rs.getString(4); // Tipo de venta.
                registro[4] = formatodecimal.format(rs.getDouble(5)); // total.
                registro[5] = rs.getString(6); // Estatus.
                
                dtmtbMantenimientodefacturas.addRow(registro);
            }
            
            //cierre de conexión
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     private void CalcularTotal() {
        
        // Sección de codigo para dar formato a las columna de tipo double. Solo se mostrara dos decimales.
        NumberFormat formatodecimal = NumberFormat.getCurrencyInstance(new Locale("es", "DO"));
        
        double[] total = new double [4] ;
        double[] precio = new double [4] ;

        if (dtmtbFacturacion.getRowCount() > 0) {
            for (int i = 0; i < tbFacturacion.getRowCount(); i++) {
                precio[0] = Double.parseDouble(dtmtbFacturacion.getValueAt(i, 5).toString()); // Precio
                total[0] += precio[0];
            }
            tfSubtotal.setText(String.valueOf(formatodecimal.format(total[0])));
            
            for (int i = 0; i < tbFacturacion.getRowCount(); i++) {
                precio[1] = Double.parseDouble(dtmtbFacturacion.getValueAt(i, 7).toString()); // ITBIS
                total[1] += precio[1];
            }
            tfITBIS.setText(String.valueOf(formatodecimal.format(total[1])));
            
            for (int i = 0; i < tbFacturacion.getRowCount(); i++) {
                if (Double.parseDouble(dtmtbFacturacion.getValueAt(i, 6).toString()) != 0.0) {
                    precio[2] = Double.parseDouble(dtmtbFacturacion.getValueAt(i, 6).toString())/100 * Double.parseDouble(dtmtbFacturacion.getValueAt(i, 5).toString()); // Descuento
                    total[2] += precio[2];
                }
            }
            tfDescto.setText(String.valueOf(formatodecimal.format(total[2])));
            
            for (int i = 0; i < tbFacturacion.getRowCount(); i++) {
                precio[3] = Double.parseDouble(dtmtbFacturacion.getValueAt(i, 8).toString()); // Monto
                total[3] += precio[3];
            }
            tfTotal.setText(String.valueOf(formatodecimal.format(total[3])));
        } else {
            
            LimpiarTextField();
        }
        
        if (!"RD$0.00".equals(tfTotal.getText())) {
            tfPagado.setEditable(true);
        } else {
            tfPagado.setEditable(false);
            tfPagado.setText("RD$0.00");
        }
    }
    
    private String Vigencia_comprobante() {

        DateFormat outdateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat indateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String vigencia = null;
        Date fecha = null;

        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifFacturar_BUSCAR_ESTATUS_COMPROBANTE (?)}");

            ps.setString(1, tfNCF.getText().substring(0, 3));

            rs = ps.executeQuery();

            if (rs.next()) {
                vigencia = rs.getString(3);
            }

            fecha = indateFormat.parse(vigencia);

            // Cierre de conexión.
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(jifFacturar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return outdateFormat.format(fecha);
    }
    // Identifica el tipo de factura.
    private void Tipo_factura () {
        
        int label = 0;
        
        if ("B01".equals(tfNCF.getText().substring(0, 3))) {
            label = 0;
        } else if ("B02".equals(tfNCF.getText().substring(0, 3))) {
            label = 1;
        } else if ("B04".equals(tfNCF.getText().substring(0, 3))) {
            label = 2;
        } else if ("B14".equals(tfNCF.getText().substring(0, 3))) {
            label = 3;
        } else if ("B15".equals(tfNCF.getText().substring(0, 3))) {
            label = 4;
        } else if ("B16".equals(tfNCF.getText().substring(0, 3))) {
            label = 5;
        }
        
        switch (label) {
            case 0:
                lbTipodefactura.setText("Factura de Crédito Fiscal");
                lbTipodefactura.setFont(new Font("Tw Cen MT Condensed", 1, 36));
                break;
            case 1:
                lbTipodefactura.setText("Factura de Consumo");
                lbTipodefactura.setFont(new Font("Tw Cen MT Condensed", 1, 36));
                break;
            case 2:
                lbTipodefactura.setText("Nota de Crédito");
                lbTipodefactura.setFont(new Font("Tw Cen MT Condensed", 1, 36));
                break;
            case 3:
                lbTipodefactura.setText("Regímenes Especiales");
                lbTipodefactura.setFont(new Font("Tw Cen MT Condensed", 1, 36));
                break;
            case 4:
                lbTipodefactura.setText("Factura Gubernamental");
                lbTipodefactura.setFont(new Font("Tw Cen MT Condensed", 1, 36));
                break;
            case 5:
                lbTipodefactura.setText("Comprobante Exportación");
                lbTipodefactura.setFont(new Font("Tw Cen MT Condensed", 1, 36));
                break;
        }
    }
     // Actualiza las cantidades de los artículos en inventario
    private void Actualizar_inventario () {

        int[] cant_bd = new int[dtmtbFacturacion.getRowCount()]; // Arreglo para capturar las cantidades por productos en la BD.
        int[] cant_pro_fact = new int[dtmtbFacturacion.getRowCount()]; // Arreglo para capturar la cantidad por productos en la factura.

        try {
            // Conexion a la base de datos.
            Connection conn = con.getConnection();
            
            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jdDetalledefactura_BUSCAR_FACTURAS (?) }");
            
            // Parametros de consulta.
            ps.setInt(1, Integer.parseInt(dtmtbMantenimientodefacturas.getValueAt(tbMantenimientodefacturas.getSelectedRow(), 0).toString()));
            
            // Ejecución de la consulta SQL.
            rs = ps.executeQuery();
            
            // Obtrención de busqueda de la consulta.
            if (rs.next()) {
                int i = 0; // Contador para arreglo cant_pro_fact.
                do {
                    cant_pro_fact[i] = rs.getInt(23); // Cantidad.
                    i++;
                } while (rs.next());
            }
            for (int i = 0; i < dtmtbFacturacion.getRowCount(); i++) {
                if (cant_pro_fact[i] > Integer.parseInt(dtmtbFacturacion.getValueAt(i, 4).toString())) { // Si la cantidad vieja es mayor que la cantidad nueva.
                    
                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jifMantenimientodeproductos_BUSCAR_PRODUCTOS (?,?) }");

                    // Parametros de consulta.
                    ps.setString(1, "Código");
                    ps.setString(2, dtmtbFacturacion.getValueAt(i, 1).toString());
                    
                    // Ejecución de la consulta SQL.
                    rs = ps.executeQuery();

                    // Obtencion de los resultados (cantidad)de la consulta.
                    if (rs.next()) {
                        cant_bd[i] = rs.getInt(5); // Cantidad del artículo en inventario.
                    }

                    if (!(chbPreventa.isSelected())) { // Si el checkbox de Pre-venta no esta seleccionado.

                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{ call jifFacturar_ACTUALIZAR_CANTIDADPROD (?,?) }");
                        
                        // Parametros de consulta.
                        ps.setString(1, dtmtbFacturacion.getValueAt(i, 1).toString()); // Envia código.
                        ps.setInt(2, cant_bd[i] + (cant_pro_fact[i] - Integer.parseInt(dtmtbFacturacion.getValueAt(i, 4).toString()))); // Suma a la cantidad en inventario las cantidades sobrante del artículo en la modificación (Cantidad en inventario + (cantidad vieja - cantidad nueva)).
                        
                        // Ejecución de la consulta SQL.
                        rs = ps.executeQuery();
                    }
                } else if (cant_pro_fact[i] < Integer.parseInt(dtmtbFacturacion.getValueAt(i, 4).toString())) { // Si la cantidad vieja es menor que la cantidad nueva
                    
                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jifMantenimientodeproductos_BUSCAR_PRODUCTOS (?,?) }");
                    
                    // Parametros de consulta.
                    ps.setString(1, "Código");
                    ps.setString(2, dtmtbFacturacion.getValueAt(i, 1).toString());
                    
                    // Ejecución de la consulta SQL.
                    rs = ps.executeQuery();

                    // Obtencion de los resultados (cantidad)de la consulta.
                    if (rs.next()) {
                        cant_bd[i] = rs.getInt(5); // Cantidad del artículo en inventario.
                    }

                    if (!(chbPreventa.isSelected())) { // Si el checkbox de Pre-venta no esta seleccionado.

                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{ call jifFacturar_ACTUALIZAR_CANTIDADPROD (?,?) }");
                        
                        // Parametros de consulta.
                        ps.setString(1, dtmtbFacturacion.getValueAt(i, 1).toString()); // Envia código.
                        ps.setInt(2, cant_bd[i] - (Integer.parseInt(dtmtbFacturacion.getValueAt(i, 4).toString()) - cant_pro_fact[i])); // Resta a la cantidad en inventario las cantidades faltantes del artículo en la modificación (Cantidad en inventario - (cantidad nueva - cantidad vieja)).
                        
                        // Ejecución de la consulta SQL.
                        rs = ps.executeQuery();
                    }
                }
            }

            // Cierre conexión.
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void LimpiarTextField() {

        tfSubtotal.setText("RD$0.00");
        tfITBIS.setText("RD$0.00");
        tfDescto.setText("RD$0.00");
        tfTotal.setText("RD$0.00");
        tfPagado.setText("RD$0.00");
    }
    // Valida las cantidades disponibles en inventario.
    private boolean Valida_cantidad() {

        int cantidad = 0;

        for (int i = 0; i < dtmtbFacturacion.getRowCount(); i++) {
            try {

                // Conexion a la base de datos.
                Connection conn = con.getConnection();

                // Consulta a la base de datos.
                ps = conn.prepareCall("{ call jifMantenimientodeproductos_BUSCAR_PRODUCTOS (?,?) }");

                // Parametros de consulta.
                ps.setString(1, "Código");
                ps.setString(2, dtmtbFacturacion.getValueAt(i, 1).toString());

                rs = ps.executeQuery();

                // Recorrido de datos para obtencion de los resultados de la consulta.
                if (rs.next()) {
                    cantidad = rs.getInt(5);
                }

                // Cierre conexión.
                conn.close();

                if (cantidad < Integer.parseInt(dtmtbFacturacion.getValueAt(i, 4).toString()) && !(chbPreventa.isSelected())) {
                    JOptionPane.showMessageDialog(jdDetalledefactura, "La cantidad del artículo: " + dtmtbFacturacion.getValueAt(i, 2).toString() + "\n que esta facturando es mayor a la que tiene en inventario: " + cantidad, "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Estatus;
    protected javax.swing.JButton btAceptar;
    protected javax.swing.JButton btAnular;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btCerrarjdAnulacion;
    private javax.swing.JButton btCerrarjdDetalledefactura;
    protected javax.swing.JButton btImprimir;
    private javax.swing.JButton btLimpiar;
    protected javax.swing.JButton btModificar;
    private javax.swing.JComboBox<String> cbDocumento;
    protected javax.swing.JComboBox<String> cbModopago;
    private javax.swing.JComboBox<String> cbTipodebusqueda;
    protected javax.swing.JComboBox<String> cbVenta;
    protected javax.swing.JCheckBox chbPreventa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JDialog jdAnulacion;
    private javax.swing.JDialog jdDetalledefactura;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel jlMotivodeanulacion;
    private javax.swing.JPanel jpDatosCliente;
    private javax.swing.JPanel jpDatosfactura;
    private javax.swing.JLabel lbCliente;
    protected javax.swing.JLabel lbComentario;
    private javax.swing.JLabel lbDescto;
    private javax.swing.JLabel lbDireccion;
    protected javax.swing.JLabel lbEstatus;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbITBIS;
    protected javax.swing.JLabel lbModopago;
    protected javax.swing.JLabel lbNCF;
    protected javax.swing.JLabel lbNofactura;
    protected javax.swing.JLabel lbPagado;
    private javax.swing.JLabel lbSubtotal;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTipodebusqueda;
    protected javax.swing.JLabel lbTipodefactura;
    private javax.swing.JLabel lbTotal;
    protected javax.swing.JLabel lbVenta;
    private javax.swing.JPanel plAnulacion;
    private javax.swing.JPanel plBuscar;
    private javax.swing.JPanel plFacturar;
    private javax.swing.JTextArea taComentario;
    private javax.swing.JTextArea taMotivodeanulacion;
    private javax.swing.JTable tbFacturacion;
    private javax.swing.JTable tbMantenimientodefacturas;
    private javax.swing.JTextField tfBusqueda;
    private javax.swing.JTextField tfCliente;
    private javax.swing.JTextField tfCodcliente;
    private javax.swing.JTextField tfDescto;
    private javax.swing.JTextField tfDireccion;
    protected javax.swing.JTextField tfEstatus;
    private javax.swing.JTextField tfFecha;
    private javax.swing.JTextField tfITBIS;
    protected javax.swing.JTextField tfNCF;
    protected javax.swing.JTextField tfNofactura;
    protected javax.swing.JTextField tfPagado;
    private javax.swing.JTextField tfSubtotal;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JTextField tfTipodebusqueda;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
