
package Vista;

import Modelo.Conexion;
import Modelo.Cotizacion;
import Modelo.FacturaSCOA;
import Modelo.IconCellRenderer;
import Modelo.MiRenderer;
import Modelo.Reportes;
import Modelo.Usuario;
import Modelo.Validacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.TableColumnModel;
import java.sql.Connection;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

public final class jifFacturar extends javax.swing.JInternalFrame {

    TableColumnModel tcmtbFacturacion;
    TableColumnModel tcmtbProductos;
    DefaultTableModel dtmtbFacturacion;
    DefaultTableModel dtmtbProductos;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usr;
    
    Conexion con = new Conexion();
    Validacion valida = new Validacion();
    Reportes reporte = new Reportes();
    ImageIcon icono = new ImageIcon(getClass().getResource("/RecursosGraficos/logofactura.png"));
    
    static final Double ITBIS = 0.18;
    
    private void Configuracionventana(){
        //this.setSize(895,650);
        this.setSize(1330,970);
    }
    
    private void Configuraciontabla (){
        //Asignación de tamaño a las celdas de cada columna.
        tcmtbFacturacion = tbFacturacion.getColumnModel();
        tcmtbProductos = tbProductos.getColumnModel();
        tcmtbFacturacion.getColumn(0).setPreferredWidth(33); // No.
        tcmtbFacturacion.getColumn(1).setPreferredWidth(70); // Codigo
        tcmtbFacturacion.getColumn(2).setPreferredWidth(404); // Descripcion
        tcmtbFacturacion.getColumn(3).setPreferredWidth(140); // Precion Und
        tcmtbFacturacion.getColumn(4).setPreferredWidth(50); // Cantidad
        tcmtbFacturacion.getColumn(5).setPreferredWidth(140); // Precio
        tcmtbFacturacion.getColumn(6).setPreferredWidth(140); // Descuento
        tcmtbFacturacion.getColumn(7).setPreferredWidth(100);
        tcmtbFacturacion.getColumn(8).setPreferredWidth(140);
        tcmtbFacturacion.getColumn(9).setPreferredWidth(33);
        tcmtbProductos.getColumn(0).setPreferredWidth(60);
        tcmtbProductos.getColumn(1).setPreferredWidth(250);
        tcmtbProductos.getColumn(2).setPreferredWidth(80);
        tcmtbProductos.getColumn(3).setPreferredWidth(150);
        tcmtbProductos.getColumn(4).setPreferredWidth(40);
        //Asignación de cantidad de filas.
        dtmtbFacturacion = (DefaultTableModel) tbFacturacion.getModel();
        dtmtbFacturacion.setRowCount(0);
        dtmtbProductos = (DefaultTableModel) tbProductos.getModel();
        //Asignación de color al Background, color al texto y estilo de fuente del encabezado de columna.
        Color bgTitulocolumn = new Color(31, 78, 121);
        Color fgTitulocolumn = new Color(255, 255, 255);
        tbFacturacion.getColumnModel().getColumn(0).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbFacturacion.getColumnModel().getColumn(1).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbFacturacion.getColumnModel().getColumn(2).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbFacturacion.getColumnModel().getColumn(3).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbFacturacion.getColumnModel().getColumn(4).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbFacturacion.getColumnModel().getColumn(5).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbFacturacion.getColumnModel().getColumn(6).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbFacturacion.getColumnModel().getColumn(7).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbFacturacion.getColumnModel().getColumn(8).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbFacturacion.getColumnModel().getColumn(9).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbProductos.getColumnModel().getColumn(0).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbProductos.getColumnModel().getColumn(1).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbProductos.getColumnModel().getColumn(2).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbProductos.getColumnModel().getColumn(3).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        tbProductos.getColumnModel().getColumn(4).setHeaderRenderer(new MiRenderer (bgTitulocolumn, fgTitulocolumn));
        //Alineación de contenido de columnas.
        DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tbFacturacion.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tbFacturacion.getColumnModel().getColumn(1).setCellRenderer(alinear);
        tbFacturacion.getColumnModel().getColumn(3).setCellRenderer(alinear);
        tbFacturacion.getColumnModel().getColumn(4).setCellRenderer(alinear);
        tbFacturacion.getColumnModel().getColumn(5).setCellRenderer(alinear);
        tbFacturacion.getColumnModel().getColumn(6).setCellRenderer(alinear);
        tbFacturacion.getColumnModel().getColumn(7).setCellRenderer(alinear);
        tbFacturacion.getColumnModel().getColumn(8).setCellRenderer(alinear);
        tbProductos.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tbProductos.getColumnModel().getColumn(2).setCellRenderer(alinear);
        tbProductos.getColumnModel().getColumn(4).setCellRenderer(alinear);
        // Añadir botones (JLabel) a la tabla.
        tbFacturacion.setDefaultRenderer(Object.class, new IconCellRenderer());
     }
    
    public jifFacturar(Usuario usr) {
        initComponents();
        Configuracionventana();
        Configuraciontabla ();
        NumeroFactura();
        Buscar_NFC();
        this.usr = usr;
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdProductos = new javax.swing.JDialog();
        plProductos = new javax.swing.JPanel();
        btCerrarjdProductos = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        tfBuscar = new javax.swing.JTextField();
        btAgregar = new javax.swing.JButton();
        jplContenedor = new javax.swing.JPanel();
        jpDatosCliente = new javax.swing.JPanel();
        lbCliente = new javax.swing.JLabel();
        tfCliente = new javax.swing.JTextField();
        lbDireccion = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        cbDocumento = new javax.swing.JComboBox<>();
        tfBusqueda = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        tfCodcliente = new javax.swing.JTextField();
        jpDatosfactura = new javax.swing.JPanel();
        lbTipodefactura = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        tfFecha = new javax.swing.JTextField();
        lbNofactura = new javax.swing.JLabel();
        tfNofactura = new javax.swing.JTextField();
        lbNCF = new javax.swing.JLabel();
        tfNCF = new javax.swing.JTextField();
        lbTipocomprobante = new javax.swing.JLabel();
        cbComprobante = new javax.swing.JComboBox<>();
        plFacturar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
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
        btCerrar = new javax.swing.JButton();
        btFacturar = new javax.swing.JButton();
        lbNota = new javax.swing.JLabel();
        btGenerar = new javax.swing.JButton();
        lbCodigo = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        chbPreventa = new javax.swing.JCheckBox();
        lbComentario = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taComentario = new javax.swing.JTextArea();
        btLimpiar = new javax.swing.JButton();

        jdProductos.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jdProductos.setTitle("Productos");

        btCerrarjdProductos.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrarjdProductos.setText("Cerrar");
        btCerrarjdProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarjdProductosActionPerformed(evt);
            }
        });

        tbProductos.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Precio", "Categoría", "Cant"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbProductos.setRowHeight(20);
        jScrollPane4.setViewportView(tbProductos);

        tfBuscar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfBuscarKeyReleased(evt);
            }
        });

        btAgregar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plProductosLayout = new javax.swing.GroupLayout(plProductos);
        plProductos.setLayout(plProductosLayout);
        plProductosLayout.setHorizontalGroup(
            plProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plProductosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCerrarjdProductos))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addGroup(plProductosLayout.createSequentialGroup()
                        .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        plProductosLayout.setVerticalGroup(
            plProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(plProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCerrarjdProductos)
                    .addComponent(btAgregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdProductosLayout = new javax.swing.GroupLayout(jdProductos.getContentPane());
        jdProductos.getContentPane().setLayout(jdProductosLayout);
        jdProductosLayout.setHorizontalGroup(
            jdProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdProductosLayout.setVerticalGroup(
            jdProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Facturación de Artículos");
        setFont(new java.awt.Font("Roboto Black", 1, 10)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/facturar.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(950, 660));
        setPreferredSize(new java.awt.Dimension(950, 660));

        jplContenedor.setBackground(new java.awt.Color(245, 245, 245));
        jplContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpDatosCliente.setBackground(new java.awt.Color(245, 245, 245));
        jpDatosCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpDatosCliente.setToolTipText("Datos del Cliente");
        jpDatosCliente.setName(""); // NOI18N
        jpDatosCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCliente.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbCliente.setForeground(new java.awt.Color(118, 113, 113));
        lbCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbCliente.setText("Cliente:");
        jpDatosCliente.add(lbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 115, 40));

        tfCliente.setEditable(false);
        tfCliente.setBackground(new java.awt.Color(214, 214, 214));
        tfCliente.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfCliente.setBorder(null);
        jpDatosCliente.add(tfCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 60, 545, 40));

        lbDireccion.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbDireccion.setForeground(new java.awt.Color(118, 113, 113));
        lbDireccion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDireccion.setText("Dirección:");
        jpDatosCliente.add(lbDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 115, 40));

        tfDireccion.setEditable(false);
        tfDireccion.setBackground(new java.awt.Color(214, 214, 214));
        tfDireccion.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfDireccion.setBorder(null);
        jpDatosCliente.add(tfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 110, 545, 40));

        lbTelefono.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbTelefono.setForeground(new java.awt.Color(118, 113, 113));
        lbTelefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTelefono.setText("Teléfono:");
        jpDatosCliente.add(lbTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 115, 40));

        tfTelefono.setEditable(false);
        tfTelefono.setBackground(new java.awt.Color(214, 214, 214));
        tfTelefono.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfTelefono.setBorder(null);
        jpDatosCliente.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 160, 195, 40));

        cbDocumento.setBackground(new java.awt.Color(51, 153, 255));
        cbDocumento.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        cbDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Cédula", "Pasaporte", "RNC" }));
        cbDocumento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDocumentoActionPerformed(evt);
            }
        });
        jpDatosCliente.add(cbDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 175, 40));

        tfBusqueda.setBackground(new java.awt.Color(214, 214, 214));
        tfBusqueda.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfBusqueda.setToolTipText("");
        tfBusqueda.setBorder(null);
        tfBusqueda.setEnabled(false);
        tfBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBusquedaKeyPressed(evt);
            }
        });
        jpDatosCliente.add(tfBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 10, 175, 40));

        btBuscar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBuscar.setOpaque(true);
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jpDatosCliente.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 150, 40));

        tfCodcliente.setBackground(new java.awt.Color(214, 214, 214));
        tfCodcliente.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfCodcliente.setBorder(null);
        tfCodcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodclienteKeyPressed(evt);
            }
        });
        jpDatosCliente.add(tfCodcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 200, 40));

        jplContenedor.add(jpDatosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 750, 210));

        jpDatosfactura.setBackground(new java.awt.Color(245, 245, 245));
        jpDatosfactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTipodefactura.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lbTipodefactura.setText("Factura de consumo");
        jpDatosfactura.add(lbTipodefactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 40));

        lbFecha.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbFecha.setForeground(new java.awt.Color(118, 113, 113));
        lbFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFecha.setText("Fecha:");
        jpDatosfactura.add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, 40));

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date now = new java.util.Date();
        this.tfFecha.setText(dateFormat.format(now));
        tfFecha.setEditable(false);
        tfFecha.setBackground(new java.awt.Color(214, 214, 214));
        tfFecha.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfFecha.setBorder(null);
        jpDatosfactura.add(tfFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 200, 40));

        lbNofactura.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbNofactura.setForeground(new java.awt.Color(118, 113, 113));
        lbNofactura.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNofactura.setText("No. Factura:");
        jpDatosfactura.add(lbNofactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 40));

        tfNofactura.setEditable(false);
        tfNofactura.setBackground(new java.awt.Color(214, 214, 214));
        tfNofactura.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfNofactura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNofactura.setBorder(null);
        jpDatosfactura.add(tfNofactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 200, 40));

        lbNCF.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbNCF.setForeground(new java.awt.Color(118, 113, 113));
        lbNCF.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNCF.setText("NCF:");
        jpDatosfactura.add(lbNCF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, 40));

        tfNCF.setEditable(false);
        tfNCF.setBackground(new java.awt.Color(214, 214, 214));
        tfNCF.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfNCF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNCF.setBorder(null);
        jpDatosfactura.add(tfNCF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 200, 40));

        lbTipocomprobante.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbTipocomprobante.setForeground(new java.awt.Color(118, 113, 113));
        lbTipocomprobante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTipocomprobante.setText("Compobante:");
        jpDatosfactura.add(lbTipocomprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 150, 40));

        cbComprobante.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        cbComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Valor Fiscal", "Consumo", "Nota Crédito", "Reg. Especial", "Gubernamental", "Exportaciones" }));
        cbComprobante.setSelectedIndex(1);
        cbComprobante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComprobanteActionPerformed(evt);
            }
        });
        jpDatosfactura.add(cbComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 200, 40));

        jplContenedor.add(jpDatosfactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 450, 260));

        plFacturar.setBackground(new java.awt.Color(245, 245, 245));
        plFacturar.setToolTipText("");
        plFacturar.setName(""); // NOI18N
        plFacturar.setPreferredSize(new java.awt.Dimension(880, 378));
        plFacturar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbFacturacion.setAutoCreateRowSorter(true);
        tbFacturacion.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tbFacturacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Código", "Descripción", "Precio Und.", "Cant.", "Precio", "Descto.", "ITBIS", "Monto", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFacturacion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbFacturacion.setRowHeight(40);
        tbFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFacturacionMouseClicked(evt);
            }
        });
        tbFacturacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbFacturacionKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbFacturacion);

        plFacturar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1250, 250));

        lbVenta.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbVenta.setForeground(new java.awt.Color(118, 113, 113));
        lbVenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbVenta.setText("Venta:");
        plFacturar.add(lbVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 150, 40));

        lbModopago.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbModopago.setForeground(new java.awt.Color(118, 113, 113));
        lbModopago.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbModopago.setText("Modo de pago:");
        plFacturar.add(lbModopago, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 370, 175, 40));

        lbPagado.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbPagado.setForeground(new java.awt.Color(118, 113, 113));
        lbPagado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPagado.setText("Pagado:");
        plFacturar.add(lbPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 150, 40));

        cbVenta.setBackground(new java.awt.Color(217, 217, 217));
        cbVenta.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        cbVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Crédito" }));
        cbVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        plFacturar.add(cbVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 200, 40));

        cbModopago.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        cbModopago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta", "Cheque", "Transferencia", "Nota crédito" }));
        cbModopago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        plFacturar.add(cbModopago, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 200, 40));

        tfPagado.setEditable(false);
        tfPagado.setBackground(new java.awt.Color(214, 214, 214));
        tfPagado.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfPagado.setText("RD$0.00");
        tfPagado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPagadoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPagadoFocusLost(evt);
            }
        });
        tfPagado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPagadoKeyPressed(evt);
            }
        });
        plFacturar.add(tfPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 200, 40));

        lbSubtotal.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbSubtotal.setForeground(new java.awt.Color(118, 113, 113));
        lbSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSubtotal.setText("Subtotal:");
        plFacturar.add(lbSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 320, 150, 40));

        lbITBIS.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbITBIS.setForeground(new java.awt.Color(118, 113, 113));
        lbITBIS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbITBIS.setText("ITBIS:");
        plFacturar.add(lbITBIS, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, 150, 40));

        tfSubtotal.setEditable(false);
        tfSubtotal.setBackground(new java.awt.Color(214, 214, 214));
        tfSubtotal.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfSubtotal.setText("RD$0.00");
        plFacturar.add(tfSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 320, 200, 40));

        tfITBIS.setEditable(false);
        tfITBIS.setBackground(new java.awt.Color(214, 214, 214));
        tfITBIS.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfITBIS.setText("RD$0.00");
        plFacturar.add(tfITBIS, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, 200, 40));

        lbDescto.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbDescto.setForeground(new java.awt.Color(118, 113, 113));
        lbDescto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDescto.setText("Descto.:");
        plFacturar.add(lbDescto, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 150, 40));

        tfDescto.setEditable(false);
        tfDescto.setBackground(new java.awt.Color(214, 214, 214));
        tfDescto.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfDescto.setText("RD$0.00");
        plFacturar.add(tfDescto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 370, 200, 40));

        lbTotal.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbTotal.setForeground(new java.awt.Color(118, 113, 113));
        lbTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTotal.setText("Total:");
        plFacturar.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 470, 150, 40));

        tfTotal.setEditable(false);
        tfTotal.setBackground(new java.awt.Color(214, 214, 214));
        tfTotal.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfTotal.setText("RD$0.00");
        plFacturar.add(tfTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 470, 200, 40));

        btCerrar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        btCerrar.setText("Cerrar");
        btCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });
        plFacturar.add(btCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 580, 200, 40));

        btFacturar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        btFacturar.setText("Facturar");
        btFacturar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFacturarActionPerformed(evt);
            }
        });
        plFacturar.add(btFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, 200, 40));

        lbNota.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbNota.setForeground(new java.awt.Color(118, 113, 113));
        lbNota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNota.setText("Estatus");
        plFacturar.add(lbNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 150, 40));

        btGenerar.setVisible(false);
        btGenerar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        btGenerar.setText("Generar");
        btGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerarActionPerformed(evt);
            }
        });
        plFacturar.add(btGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, 200, 40));

        lbNota.setVisible(false);
        lbCodigo.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbCodigo.setForeground(new java.awt.Color(118, 113, 113));
        lbCodigo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbCodigo.setText("Código art.:");
        lbCodigo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        plFacturar.add(lbCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

        tfCodigo.setBackground(new java.awt.Color(214, 214, 214));
        tfCodigo.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfCodigo.setToolTipText("Para hacer una busqueda por descripción deje la casilla vacía y presione la telca F2.");
        tfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodigoKeyPressed(evt);
            }
        });
        plFacturar.add(tfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 150, 40));

        chbPreventa.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        chbPreventa.setForeground(new java.awt.Color(118, 113, 113));
        chbPreventa.setSelected(true);
        chbPreventa.setText("Servicio");
        plFacturar.add(chbPreventa, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 200, 40));

        lbComentario.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lbComentario.setForeground(new java.awt.Color(118, 113, 113));
        lbComentario.setText("Comentario:");
        plFacturar.add(lbComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 150, 40));

        taComentario.setBackground(new java.awt.Color(214, 214, 214));
        taComentario.setColumns(20);
        taComentario.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        taComentario.setRows(5);
        jScrollPane2.setViewportView(taComentario);

        plFacturar.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 400, 250));

        btLimpiar.setVisible(false);
        btLimpiar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        btLimpiar.setText("Limpiar");
        btLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });
        plFacturar.add(btLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 200, 40));

        jplContenedor.add(plFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 1270, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplContenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCerrarjdProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarjdProductosActionPerformed
        jdProductos.dispose();
        tfBuscar.setText(null);
    }//GEN-LAST:event_btCerrarjdProductosActionPerformed

    private void tfBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyReleased
        
        dtmtbProductos.setRowCount(0);
        Object[] registro = new Object[5];
        
        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jdProductos_BUSCAR_PRODUCTOS (?) }");

            // Parametros de consulta.
            ps.setString(1, "%"+tfBuscar.getText()+"%");

            rs = ps.executeQuery();

            // Recorrido de datos para obtencion de los resultados de la consulta.
            while (rs.next()) {
                if ("Si".equals(rs.getString(7))) {
                    registro[0] = rs.getString(1);
                    registro[1] = rs.getString(2);
                    registro[2] = rs.getDouble(3);
                    registro[3] = rs.getString(4);
                    registro[4] = rs.getInt(5);

                    dtmtbProductos.addRow(registro);
                }
            }

            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jdProductos, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tfBuscarKeyReleased

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed

        int fsel = tbProductos.getSelectedRow();
        String itbis = null;
        int cantidad = 0;

        // Validación de selección. Aquí se valida que haya una fila seleccionada.
        if (fsel == -1) {
            JOptionPane.showMessageDialog(jdProductos, "Por favor seleccione un artículo", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
        } else {

            // Validación de duplicidad. Aquí se valida que no se inserte dos veces el mismo código.
            if (Validacionduplicidad(dtmtbProductos.getValueAt(fsel, 0).toString()) == true) {
                JOptionPane.showMessageDialog(null, "Este artículo ya ha sido insertado. NO puede haber dos artículos iguales. \n SUGERENCIA: Aumente la cantidad del artículo si lo que desea es tener más de uno.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
            } else {

                Object[] registro = new Object[10];
                registro[1] = dtmtbProductos.getValueAt(fsel, 0).toString();

                try {

                    // Conexion a la base de datos.
                    Connection conn = con.getConnection();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jifFacturar_BUSCAR_ARTICULO (?) }");

                    // Parametros de consulta.
                    ps.setString(1, registro[1].toString());

                    rs = ps.executeQuery();

                    // Recorrido de datos para obtencion de los resultados de la consulta.
                    while (rs.next()) {

                        registro[1] = rs.getString(1); // Código
                        registro[2] = rs.getString(2); // Descripción
                        registro[3] = rs.getDouble(3); // Precio und.
                        itbis = rs.getString(4); // itbis
                        cantidad = rs.getInt(5); // Cantidad
                    }

                    conn.close();

                    //double precio = Double.parseDouble(registro[4].toString());

                    registro[0] = dtmtbFacturacion.getRowCount() + 1; // No.orden artículo
                    registro[4] = Integer.parseInt("1"); // cantidad
                    registro[5] = registro[3]; // Precio
                    registro[6] = Double.parseDouble("0.00"); // Descuento

                    if ("Si".equalsIgnoreCase(itbis)) {
                        registro[7] = Double.parseDouble(registro[3].toString()) * ITBIS; // ITBIS
                    } else {
                        registro[7] = "0.00"; // ITBIS
                    }
                    registro[8] = Double.parseDouble(registro[5].toString()) + Double.parseDouble(registro[7].toString()); // Monto
                    registro[9] = new JLabel(); // Boton borrar

                    if (cantidad == 0 && !(chbPreventa.isSelected())) {
                        JOptionPane.showMessageDialog(jdProductos, "No puedes agregar este artículo porque la cantidad en inventario es 0", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
                    } else {
                        dtmtbFacturacion.addRow(registro);
                        CalcularTotal();
                        tfBuscar.setText(null);
                        jdProductos.dispose();
                    }
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(jdProductos, e, "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btAgregarActionPerformed

    private void tfCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoKeyPressed
    
        if (evt.VK_ENTER == evt.getKeyCode() && (tfCodigo.getText().trim().isEmpty())) {
            jdProductos.setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/productos.png")).getImage());
            jdProductos.setSize(630, 340);
            jdProductos.setLocationRelativeTo(null);
            jdProductos.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            jdProductos.setVisible(true);
            
            // Ejecuciòn de la busqueda e inserción del artículo desde la base de datos a la tabla tbFacturación en el sistema el presionar la tecla ENTER.
        } else if (KeyEvent.VK_ENTER == evt.getKeyCode()) {

            if (Validacionduplicidad(tfCodigo.getText().trim().toUpperCase()) == true) {
                JOptionPane.showMessageDialog(null, "Este artículo ya ha sido insertado. NO puede haber dos artículos iguales. \n SUGERENCIA: Aumente la cantidad del artículo si lo que deseas es tener más de uno.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);

                // Validación de existencia utilizando el metodo "Validacion_Existencia_Registro" de la clase Validacion. Aquí se valida que el servicio que se esta insertando exista en la base de datos.
            } else if (valida.Validacion_Existencia_Registro("productos", "codigo", tfCodigo.getText().trim()) == false) {
                JOptionPane.showMessageDialog(null, "El artículo que esta intentando insertar no existe en la base de datos.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);

                // Validacion de disponibilidad de artículo.
            } else if (valida.Disponibilidad_Articulo("productos", "disponibilidad", tfCodigo.getText().trim()) == false) {
                JOptionPane.showMessageDialog(null, "El artículo que esta intentando insertar no esta disponible para la venta.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);

            } else {

                Object[] registro = new Object[10];
                String itbis = null;
                int cantidad = 0;

                try {

                    // Conexion a la base de datos.
                    Connection conn = con.getConnection();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jifFacturar_BUSCAR_ARTICULO (?) }");

                    // Parametros de consulta.
                    ps.setString(1, tfCodigo.getText().trim()
                    );

                    rs = ps.executeQuery();

                    // Recorrido de datos para obtencion de los resultados de la consulta.
                    while (rs.next()) {

                        registro[1] = rs.getString(1); // Código
                        registro[2] = rs.getString(2); // Descripción
                        registro[3] = rs.getDouble(3); // Precio und.
                        itbis = rs.getString(4); // itbis
                        cantidad = rs.getInt(5); // Cantidad
                    }

                    conn.close();

                    registro[0] = dtmtbFacturacion.getRowCount() + 1; // No.orden artículo
                    registro[4] = Integer.parseInt("1"); // cantidad
                    registro[5] = registro[3]; // Precio
                    registro[6] = Double.parseDouble("0.00"); // Descuento
                    
                    if ("Si".equals(itbis)) {
                        registro[7] = Double.parseDouble(registro[4].toString()) * ITBIS; // ITBIS
                    } else {
                        registro[7] = "0.00"; // ITBIS
                    }
                    registro[8] = Double.parseDouble(registro[5].toString()) + Double.parseDouble(registro[7].toString()); // Monto
                    registro[9] = new JLabel(); // Boton borrar

                    if (cantidad == 0 && !(chbPreventa.isSelected())) {
                        JOptionPane.showMessageDialog(null, "No puedes agregar este artículo porque la cantidad en inventario es 0.", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
                    } else {
                        dtmtbFacturacion.addRow(registro);
                        CalcularTotal();
                    }

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                }

            }
            tfCodigo.setText(null);
        }
    }//GEN-LAST:event_tfCodigoKeyPressed

    private void btFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFacturarActionPerformed
 
        FacturaSCOA facturascoa;
        ArrayList coleccion = new ArrayList();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy / hh:mm a");
        java.util.Date now = new java.util.Date();
        String currentTime = dateFormat.format(now);
        
        int eleccion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea realizar esta facturación?", "PRECAUCIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (eleccion == 0) {

            if (tfCliente.getText().trim().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar el cliente al que se hará la venta.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
            } else if (dtmtbFacturacion.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Debe haber al menos un artículo insertado para proceder a generar la factura.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
            } else if (Valida_comprobante(tfNCF.getText()) == false) {
                JOptionPane.showMessageDialog(null, "El nùmero de comprobante " + tfNCF.getText() + " no está autorizado.", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
            } else if (Valida_cantidad() == false) {
                // No se puso acción porque la alerta vendra desde el metodo Valida_cantidad ().
            } else if ("Contado".equals(cbVenta.getSelectedItem())) { // Venta al contado.
                if (Double.valueOf(tfPagado.getText().replaceAll("[^\\d.]", "")) > Double.valueOf(tfTotal.getText().replaceAll("[^\\d.]", ""))) {
                    tfPagado.setText(tfTotal.getText());
                }
                if (tfPagado.getText() == null ? tfTotal.getText() != null : !tfPagado.getText().equals(tfTotal.getText())) {
                    JOptionPane.showMessageDialog(null, "Venta al contado: Se debe aplicar la cantidad exacta que se visualiza en el total.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
                } else {
                    
                    NumeroFactura();
                    Buscar_NFC();

                    try {

                        // Conexión a la base de datos.
                        Connection conn = con.getConnection();

                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{ call jifFacturar_INSERTAR_FACTURACION (?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");

                        // Parametros de consulta.
                        ps.setInt(1, Integer.parseInt(tfNofactura.getText())); // Envia el numero de factura
                        ps.setInt(2, Integer.parseInt(tfCodcliente.getText())); // Envia el código de cliente.
                        ps.setString(3, getFechaActual()); // Envia la fecha y hora.
                        ps.setString(4, cbVenta.getSelectedItem().toString()); // Envia el tipo de venta.
                        ps.setString(5, cbModopago.getSelectedItem().toString()); // Envia el modo de pago.
                        ps.setDouble(6, Double.parseDouble(tfPagado.getText().substring(3).replace(",", "").trim())); // Envia el monto pagado.
                        ps.setDouble(7, Double.parseDouble(tfSubtotal.getText().substring(3).replace(",", "").trim())); // Envia el  Subtotal.
                        ps.setDouble(8, Double.parseDouble(tfDescto.getText().substring(3).replace(",", "").trim())); // Envia el descuento.
                        ps.setDouble(9, Double.parseDouble(tfITBIS.getText().substring(3).replace(",", "").trim())); // Envia el ITBIS.
                        ps.setDouble(10, Double.parseDouble(tfTotal.getText().substring(3).replace(",", "").trim())); // Envia el total.
                        ps.setString(11, usr.getNick()); // Envia el usuraio que facturo.
                        ps.setString(12, "ACTIVO"); // Envia el estatus de la facturar al ser generada.
                        ps.setString(13, taComentario.getText()); // Envia comentarios.
                        if (chbPreventa.isSelected()) {
                            ps.setString(14, "Si"); // Envia si fue pre-venta.
                        } else {
                            ps.setString(14, "No"); // Envia no fue pre-venta.
                        }

                        rs = ps.executeQuery();

                        for (int i = 0; i < dtmtbFacturacion.getRowCount(); i++) {
                            // Consulta a la base de datos.
                            ps = conn.prepareCall("{ call jifFacturar_INSERTAR_DETALLE_FACTURACION (?,?,?,?,?,?,?,?,?) }");

                            // Parametros de consulta.
                            ps.setInt(1, Integer.parseInt(tfNofactura.getText())); // Envia el numero de factura
                            ps.setString(2, dtmtbFacturacion.getValueAt(i, 1).toString()); // Envia el codigo del artículo.
                            ps.setString(3, dtmtbFacturacion.getValueAt(i, 2).toString()); // Envia la descripcion.
                            ps.setInt(4, Integer.parseInt(dtmtbFacturacion.getValueAt(i, 4).toString())); // Envia la cantidad.
                            ps.setDouble(5, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 5).toString())); // Envia el precio.
                            ps.setDouble(6, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 6).toString())); // Envia el descuento.
                            ps.setDouble(7, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 7).toString())); // Envia el ITBIS.
                            ps.setDouble(8, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 8).toString())); // Envia el monto.
                            ps.setDouble(9, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 3).toString())); // Envia el precio und.

                            rs = ps.executeQuery();
                        }

                        Actualizar_inventario();

                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{ call jifFacturar_INSERTAR_COMPROBANTE (?,?,?) }");

                        // Parametros de consulta.
                        ps.setString(1, tfNCF.getText().substring(0, 3)); // Envia la serie del comprobante.
                        ps.setString(2, tfNCF.getText()); // Envia el NCF.
                        ps.setInt(3, Integer.parseInt(tfNofactura.getText())); // Envia el numero de factura.

                        rs = ps.executeQuery();

                        //Cierre de conexión a la base de datos.
                        conn.close();

                        if (cbComprobante.getSelectedIndex() != 1) { // comprobante diferente a "consumo".
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
                                coleccion.add(facturascoa);
                            }
                        } else {
                            for (int i = 0; i < tbFacturacion.getRowCount(); i++) {
                                facturascoa = new FacturaSCOA(lbTipodefactura.getText() // n_comprobante
                                                            , tfNCF.getText() // comprobante
                                                            , Vigencia_comprobante() // fecha_vencimiento
                                                            , icono.getImage() // imagen
                                                            , cbDocumento.getSelectedItem().toString() + ":" // documento
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
                                coleccion.add(facturascoa);
                            }
                        }

                        dtmtbFacturacion.setRowCount(0);
                        cbDocumento.setSelectedIndex(0);
                        tfCliente.setText(null);
                        tfBusqueda.setText(null);
                        tfTelefono.setText(null);
                        tfCodigo.setText(null);
                        cbComprobante.setSelectedIndex(1);
                        cbVenta.setSelectedIndex(0);
                        cbModopago.setSelectedIndex(0);
                        taComentario.setText(null);
                        if (chbPreventa.isSelected()) {
                            chbPreventa.doClick();
                        }
                        CalcularTotal();

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                        System.out.println(e);
                    }
                    reporte.Factura(coleccion);
                    NumeroFactura();
                    Buscar_NFC();
                }
            } else if ("Crédito".equals(cbVenta.getSelectedItem())) { // Venta a credito
                
                NumeroFactura();
                Buscar_NFC();
                
                if (Double.valueOf(tfPagado.getText().substring(3).replaceAll("[^\\d.]", "")) > Double.valueOf(tfTotal.getText().substring(3).replaceAll("[^\\d.]", ""))) {
                    tfPagado.setText(tfTotal.getText());
                }
                if (tfPagado.getText().trim().isEmpty()) {
                    tfPagado.setText("0.00");
                }
                try {

                    // Conexión a la base de datos.
                    Connection conn = con.getConnection();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jifFacturar_INSERTAR_FACTURACION (?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");

                    // Parametros de consulta.
                    ps.setInt(1, Integer.parseInt(tfNofactura.getText())); // Envia el numero de factura
                    ps.setInt(2, Integer.parseInt(tfCodcliente.getText())); // Envia el código de cliente.
                    ps.setString(3, getFechaActual()); // Envia la fecha y hora.
                    ps.setString(4, cbVenta.getSelectedItem().toString()); // Envia el tipo de venta.
                    ps.setString(5, cbModopago.getSelectedItem().toString()); // Envia el modo de pago.
                    ps.setDouble(6, Double.parseDouble(tfPagado.getText().substring(3).replace(",", "").trim())); // Envia el monto pagado.
                    ps.setDouble(7, Double.parseDouble(tfSubtotal.getText().substring(3).replace(",", "").trim())); // Envia el  Subtotal.
                    ps.setDouble(8, Double.parseDouble(tfDescto.getText().substring(3).replace(",", "").trim())); // Envia el descuento.
                    ps.setDouble(9, Double.parseDouble(tfITBIS.getText().substring(3).replace(",", "").trim())); // Envia el ITBIS.
                    ps.setDouble(10, Double.parseDouble(tfTotal.getText().substring(3).replace(",", "").trim())); // Envia el total.
                    ps.setString(11, usr.getNick()); // Envia el usuraio que facturo.
                    ps.setString(12, "ACTIVO"); // Envia el estatus de la facturar al ser generada.
                    ps.setString(13, taComentario.getText()); // Envia comentarios.
                    if (chbPreventa.isSelected()) {
                        ps.setString(14, "Si"); // Envia si fue pre-venta.
                    } else {
                        ps.setString(14, "No"); // Envia no fue pre-venta.
                    }

                    rs = ps.executeQuery();

                    for (int i = 0; i < dtmtbFacturacion.getRowCount(); i++) {
                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{ call jifFacturar_INSERTAR_DETALLE_FACTURACION (?,?,?,?,?,?,?,?,?) }");

                        // Parametros de consulta.
                        ps.setInt(1, Integer.parseInt(tfNofactura.getText())); // Envia el numero de factura
                        ps.setString(2, dtmtbFacturacion.getValueAt(i, 1).toString()); // Envia el codigo del artículo.
                        ps.setString(3, dtmtbFacturacion.getValueAt(i, 2).toString()); // Envia la descripcion.
                        ps.setInt(4, Integer.parseInt(dtmtbFacturacion.getValueAt(i, 4).toString())); // Envia la cantidad.
                        ps.setDouble(5, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 5).toString())); // Envia el precio.
                        ps.setDouble(6, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 6).toString())); // Envia el descuento.
                        ps.setDouble(7, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 7).toString())); // Envia el ITBIS.
                        ps.setDouble(8, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 8).toString())); // Envia el monto.
                        ps.setDouble(9, Double.parseDouble(dtmtbFacturacion.getValueAt(i, 3).toString())); // Envia el precio und.

                        rs = ps.executeQuery();
                    }

                    Actualizar_inventario();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jifFacturar_INSERTAR_COMPROBANTE (?,?,?) }");

                    // Parametros de consulta.
                    ps.setString(1, tfNCF.getText().substring(0, 3)); // Envia la serie del comprobante.
                    ps.setString(2, tfNCF.getText()); // Envia el NCF.
                    ps.setInt(3, Integer.parseInt(tfNofactura.getText())); // Envia el numero de factura.

                    rs = ps.executeQuery();

                    //Cierre de conexión a la base de datos.
                    conn.close();

                    if (cbComprobante.getSelectedIndex() != 1) { // comprobante diferente a "consumo".
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
                            coleccion.add(facturascoa);
                        }
                    } else {
                        for (int i = 0; i < tbFacturacion.getRowCount(); i++) {
                            facturascoa = new FacturaSCOA(lbTipodefactura.getText() // n_comprobante
                                                            , tfNCF.getText() // comprobante
                                                            , Vigencia_comprobante() // fecha_vencimiento
                                                            , icono.getImage() // imagen
                                                            , cbDocumento.getSelectedItem().toString() + ":" // documento
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
                            coleccion.add(facturascoa);
                        }
                    }

                    dtmtbFacturacion.setRowCount(0);
                    cbDocumento.setSelectedIndex(0);
                    tfCliente.setText(null);
                    tfBusqueda.setText(null);
                    tfTelefono.setText(null);
                    tfCodigo.setText(null);
                    cbComprobante.setSelectedIndex(1);
                    cbVenta.setSelectedIndex(0);
                    cbModopago.setSelectedIndex(0);
                    taComentario.setText(null);
                    if (chbPreventa.isSelected()) {
                        chbPreventa.doClick();
                    }
                    CalcularTotal();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e);
                }
                reporte.Factura(coleccion);
                NumeroFactura();
                Buscar_NFC();
            }
        }
    }//GEN-LAST:event_btFacturarActionPerformed

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

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
                calculos[5] = calculos[3] - (calculos[3]*calculos[2]); // calcula precio con descuento.
                
                if ("Si".equals(itbis)) {
                    
                    
                    
                    //calculos[4] = Double.parseDouble(calculos[5].toString()) * ITBIS; // Calcula el ITBIS
                    
                    
                    //dtmtbFacturacion.setValueAt(calculos[3], fila, 5); // Precio.
                    
                    // Pasa el precio por cantidad calculado.
                    dtmtbFacturacion.setValueAt(calculaPrecio(calculos[0],
                                                              (int) dtmtbFacturacion.getValueAt(fila, 4)),
                                                fila, 5);
                    
                    // Pasa el itbis calculado.
                    dtmtbFacturacion.setValueAt(calculaItbis((double) dtmtbFacturacion.getValueAt(fila, 5),
                                                            (double) dtmtbFacturacion.getValueAt(fila, 6)),
                                                fila, 7);
                    
                    //dtmtbFacturacion.setValueAt((calculos[5] + calculos[4]), fila, 8); // Monto.
                    // Pasa el monto calculado.
                    dtmtbFacturacion.setValueAt(calculaMonto((double) dtmtbFacturacion.getValueAt(fila, 5),
                                                             (double) dtmtbFacturacion.getValueAt(fila, 7),
                                                             calculaDescuento((double) dtmtbFacturacion.getValueAt(fila, 5),
                                                                              (double) dtmtbFacturacion.getValueAt(fila, 6))),
                                                fila, 8);
                } else {
                    calculos[4] = Double.parseDouble("0.00"); // ITBIS
                    dtmtbFacturacion.setValueAt(calculos[3], fila, 5); // Precio.
                    dtmtbFacturacion.setValueAt(calculos[5], fila, 8); // Monto.
                }
                
          
                // Ejecuta el cambio.
                dtmtbFacturacion.fireTableDataChanged(); 

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }

        } else if (columna == 6) { // Columna Descuento
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

            
        } else if (columna == 3){
            if (dtmtbFacturacion.getValueAt(fila, 3) == null || Integer.parseInt(dtmtbFacturacion.getValueAt(fila, 3).toString()) == 0) { // Columna "Cantidad".
                dtmtbFacturacion.setValueAt(1.00, fila, 3); // Si la columna "Cantidad" esta vacia, asigna un valor de 1.
                dtmtbFacturacion.fireTableDataChanged(); // Ejecuta el cambio.
            }
            
            Double[] precio = new Double[3];
            
            precio[0] = Double.parseDouble(dtmtbFacturacion.getValueAt(fila, 4).toString()); // Columna cantidad
            precio[1] = Double.parseDouble(dtmtbFacturacion.getValueAt(fila, 3).toString()); // Columna precio
            precio[2] = precio[1] * precio[0];
            
        }
        
        CalcularTotal();
    }//GEN-LAST:event_tbFacturacionKeyPressed

    private void tbFacturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFacturacionMouseClicked
        int fila = tbFacturacion.rowAtPoint(evt.getPoint());
        int columna = tbFacturacion.columnAtPoint(evt.getPoint());

        if (columna == 9) { //columna de boton eliminar.
            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea remover este artículo?", "PRECAUCIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion ==0) {
                dtmtbFacturacion.removeRow(fila);
                CalcularTotal();
                for (int i = 0; i < dtmtbFacturacion.getRowCount(); i++) {
                    dtmtbFacturacion.setValueAt(i + 1, i, 0);
                }
            }
        }
        
        if (columna == 4 || columna == 6) { // columnas cantidad y descuento.
            tbFacturacion.requestFocus();
        }
    }//GEN-LAST:event_tbFacturacionMouseClicked

    private void cbComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbComprobanteActionPerformed
        
        switch (cbComprobante.getSelectedIndex()) {
            case 0:
                lbTipodefactura.setText("Factura de Crédito Fiscal");
                //lbTipodefactura.setFont(new Font("Tw Cen MT Condensed", 1, 36));
                break;
            case 1:
                lbTipodefactura.setText("Factura de Consumo");
                //lbTipodefactura.setFont(new Font("Tw Cen MT Condensed", 1, 36));
                break;
            case 2:
                lbTipodefactura.setText("Nota de Crédito");
                //lbTipodefactura.setFont(new Font("Tw Cen MT Condensed", 1, 36));
                break;
            case 3:
                lbTipodefactura.setText("Regímenes Especiales");
                //lbTipodefactura.setFont(new Font("Tw Cen MT Condensed", 1, 36));
                break;
            case 4:
                lbTipodefactura.setText("Factura Gubernamental");
                //lbTipodefactura.setFont(new Font("Tw Cen MT Condensed", 1, 36));
                break;
            case 5:
                lbTipodefactura.setText("Comprobante Exportación");
                //lbTipodefactura.setFont(new Font ("Tw Cen MT Condensed", 1, 36));
                break;
        }
        
        Buscar_NFC() ;
    }//GEN-LAST:event_cbComprobanteActionPerformed

    private void btGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerarActionPerformed
       
        Cotizacion cotizacion;
        ArrayList coleccion = new ArrayList();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy / hh:mm a");
        java.util.Date now = new java.util.Date();
        String currentTime = dateFormat.format(now);

        if (dtmtbFacturacion.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Debe haber al menos un artículo insertado para proceder a generar la factura.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
        } else {
            for (int i = 0; i < dtmtbFacturacion.getRowCount(); i++) {
                cotizacion = new Cotizacion(lbTipodefactura.getText() // n_comprobante
                                          , icono.getImage() // imagen
                                          , cbDocumento.getSelectedItem().toString() + ":" // t_documento
                                          , tfBusqueda.getText() // rnc
                                          , tfCliente.getText() // cliente
                                          , tfTelefono.getText() // telefono
                                          , tfCodcliente.getText() // codcliente
                                          , currentTime // fecha
                                          , dtmtbFacturacion.getValueAt(i, 1).toString() // codigo
                                          , dtmtbFacturacion.getValueAt(i, 2).toString() // descripcion
                                          , dtmtbFacturacion.getValueAt(i, 4).toString() // cantidad
                                          , dtmtbFacturacion.getValueAt(i, 7).toString() // itbis
                                          , dtmtbFacturacion.getValueAt(i, 3).toString() // precio
                                          , tfSubtotal.getText() // subtotal
                                          , tfDescto.getText() // descto
                                          , tfITBIS.getText() // t_itbis
                                          , tfTotal.getText() // total
                                          , usr.getNombre() // usuario
                                          , taComentario.getText()); // comentario
                coleccion.add(cotizacion);
            }
            reporte.Cotizacion(coleccion);
        }
    }//GEN-LAST:event_btGenerarActionPerformed

    private void tfBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBusquedaKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            btBuscar.requestFocus();
        }
    }//GEN-LAST:event_tfBusquedaKeyPressed

    private void tfPagadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPagadoKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            btFacturar.requestFocus();
        }
    }//GEN-LAST:event_tfPagadoKeyPressed

    private void cbDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDocumentoActionPerformed
        if (cbDocumento.getSelectedIndex() == 0) {
            tfCodcliente.setEnabled(true);
            tfBusqueda.setEnabled(false);
        } else {
            tfBusqueda.setEnabled(true);
            tfCodcliente.setEnabled(false);
        }
        tfBusqueda.setText(null);
        tfCliente.setText(null);
        tfDireccion.setText(null);
        tfTelefono.setText(null);
        tfCodcliente.setText(null);
    }//GEN-LAST:event_cbDocumentoActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        
        String telefono = null; // numero de telefono
        String patron = "(%s) %s-%s"; // patron de formato para el numero de telefono
        
        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifFacturar_BUSCAR_CLIENTE (?,?) }");

            // Parametros de consulta.
            ps.setString(1, cbDocumento.getSelectedItem().toString());
            if (cbDocumento.getSelectedIndex() == 0) {
                ps.setString(2, tfCodcliente.getText());
            } else {
                ps.setString(2,  tfBusqueda.getText());
            }

            rs = ps.executeQuery();

            // Recorrido de datos para obtencion de los resultados de la consulta.
            if (rs.next()) {
                cbDocumento.setSelectedItem(rs.getString(6)); // Tipo de documento.
                tfCodcliente.setText(rs.getString(1)); // Código de cliente.
                tfBusqueda.setText(rs.getString(2)); // No. de documento.
                tfCliente.setText(rs.getString(3)); // Nombre de cliente.
                tfDireccion.setText(rs.getString(4)); // Direccion.
                telefono = rs.getString(5); // Telefono.
                tfTelefono.setText(String.format(patron, telefono.substring(0,3), telefono.substring(3,6), telefono.substring(6)));
            } else {
                JOptionPane.showMessageDialog(null, "El Código o Documento que esta ingresando no existe, por favor verifique.", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void tfCodclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodclienteKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            btBuscar.requestFocus();
        }
    }//GEN-LAST:event_tfCodclienteKeyPressed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        dtmtbFacturacion.setRowCount(0);
        cbDocumento.setSelectedIndex(0);
        tfCliente.setText(null);
        tfBusqueda.setText(null);
        tfTelefono.setText(null);
        tfCodigo.setText(null);
        taComentario.setText(null);
        CalcularTotal();
    }//GEN-LAST:event_btLimpiarActionPerformed

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

    private static String getFechaActual() {
       
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date now = new java.util.Date();
        String currentTime = dateFormat.format(now);
        return  currentTime;
    }
    
    private String Vigencia_comprobante() {
        
        DateFormat outdateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat indateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String vigencia = null;
        Date f = null;
        
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
            
            f = indateFormat.parse(vigencia);
            
            // Cierre de conexión.
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(jifFacturar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return outdateFormat.format(f);
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
    
    private boolean Validacionduplicidad (String codigo) {
        String digito = codigo;
        
        if (dtmtbFacturacion.getRowCount() > 0) {
            for (int i = 0; i < tbFacturacion.getRowCount(); i++) {
                if (digito.equals(dtmtbFacturacion.getValueAt(i, 1).toString())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean Valida_comprobante (String comprobante) {
        
        int[] rango = new int[3];
        
        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifFacturar_BUSCAR_ESTATUS_COMPROBANTE (?) }");

            ps.setString(1, comprobante.substring(0, 3));
            
            rs = ps.executeQuery();

            if (rs.next()) {
                rango[0] = rs.getInt(1); // inico de rango.
                rango[1] = rs.getInt(2); // fin de rango.
                rango[2] = Integer.parseInt(comprobante.substring(3)); // numeración de comprobante.
                
                if (rango[2] >= rango[0] && rango[2] <= rango[1]) {
                    tfNCF.setForeground(Color.black);
                    return true;
                }
            }

            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
        
        tfNCF.setForeground(Color.RED);
        return false;
    }
    
    private void NumeroFactura () {

        Calendar cal = Calendar.getInstance();
        String ano = String.valueOf(cal.get(Calendar.YEAR));
        int ticket = 0;
        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifFacturar_NUMERO_FACTURA () }");

            rs = ps.executeQuery();

            if (rs.next()) {
                ticket = rs.getInt(1) + 1;
                if (String.valueOf(ticket).substring(0, 4).equals(String.valueOf(cal.get(Calendar.YEAR)))) {
                    tfNofactura.setText(String.valueOf(ticket));
                } else {
                    tfNofactura.setText(cal.get(Calendar.YEAR) + "00001");
                }
            }else {
                tfNofactura.setText(cal.get(Calendar.YEAR) + "00001");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void Buscar_NFC() {
        
        String secuencia;
        String comprobante;
        int ticket = 0;
        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifFacturar_BUSCAR_COMPROBANTES (?) }");

            ps.setString(1, cbComprobante.getSelectedItem().toString());
            
            rs = ps.executeQuery();

            if (rs.next()) {
                comprobante = rs.getString(1);
                ticket = Integer.parseInt(comprobante.substring(2));
                ticket += 1;
                secuencia = comprobante.substring(0, 2);
                tfNCF.setText(secuencia + String.valueOf(ticket));
            }
            
            conn.close();
            
            Valida_comprobante(tfNCF.getText());
            //System.out.println(Integer.parseInt(tfNCF.getText().substring(3)));
            
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
    
    private boolean Valida_cantidad () {

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
                    JOptionPane.showMessageDialog(null, "La cantidad del artículo: " + dtmtbFacturacion.getValueAt(i, 2).toString() + "\n que esta facturando es mayor a la que tiene en inventario: " + cantidad, "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }
        }
        return true;
    }
    // Actualiza las cantidades de los artículos en inventario
    private void Actualizar_inventario () {
        int[] cantidad = new int[dtmtbFacturacion.getRowCount()];

        for (int i = 0; i < dtmtbFacturacion.getRowCount(); i++) {
            try {

                // Conexion a la base de datos.
                Connection conn = con.getConnection();

                // Consulta a la base de datos.
                ps = conn.prepareCall("{ call jifMantenimientodeproductos_BUSCAR_PRODUCTOS (?,?) }");

                // Parametros de consulta.
                ps.setString(1, "Código");
                ps.setString(2, dtmtbFacturacion.getValueAt(i, 1).toString()); // codigo.

                rs = ps.executeQuery();

                // Obtencion de los resultados (cantidad)de la consulta.
                if (rs.next()) {
                    cantidad[i] = rs.getInt(5);
                }

                if (!(chbPreventa.isSelected())) {

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jifFacturar_ACTUALIZAR_CANTIDADPROD (?,?) }");

                    // Parametros de consulta.
                    ps.setString(1, dtmtbFacturacion.getValueAt(i, 1).toString()); // Envia código.
                    ps.setInt(2, cantidad[i] - Integer.parseInt(dtmtbFacturacion.getValueAt(i, 4).toString())); // Resta la cantidad en base de datos - cantidad facturada.

                    rs = ps.executeQuery();
                }
                
                // Cierre conexión.
                conn.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private double calculaItbis(double precioCantidad, double descuento){
        
        final double itbis = 0.18;
        double monto = 0.00;
        double montoItbis = 0.00;
        
        monto = precioCantidad - (precioCantidad * (descuento/100));
        
        montoItbis = monto * itbis;
        
        return montoItbis;
    }
    
    private double calculaDescuento(double precioCantidad, double descuento){
        
        double montoDescuento = 0.00;
        
        montoDescuento = precioCantidad * (descuento/100);
        
        return montoDescuento;
    }
    
    private double calculaPrecio(double precioUnd, int cantidad){
        
        double precioCantidad = 0.00;
        
        precioCantidad = precioUnd * cantidad;
        
        return precioCantidad;
    }
    
     private double calculaMonto(double precioCantidad, double itbis, double descuento){
        
        double monto = 0.00;
        
        monto = (precioCantidad - descuento) + itbis;
        
        return monto;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btCerrarjdProductos;
    protected javax.swing.JButton btFacturar;
    protected javax.swing.JButton btGenerar;
    protected javax.swing.JButton btLimpiar;
    protected javax.swing.JComboBox<String> cbComprobante;
    private javax.swing.JComboBox<String> cbDocumento;
    protected javax.swing.JComboBox<String> cbModopago;
    protected javax.swing.JComboBox<String> cbVenta;
    protected javax.swing.JCheckBox chbPreventa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JDialog jdProductos;
    private javax.swing.JPanel jpDatosCliente;
    private javax.swing.JPanel jpDatosfactura;
    private javax.swing.JPanel jplContenedor;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbCodigo;
    protected javax.swing.JLabel lbComentario;
    private javax.swing.JLabel lbDescto;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbITBIS;
    protected javax.swing.JLabel lbModopago;
    protected javax.swing.JLabel lbNCF;
    protected javax.swing.JLabel lbNofactura;
    private javax.swing.JLabel lbNota;
    protected javax.swing.JLabel lbPagado;
    private javax.swing.JLabel lbSubtotal;
    private javax.swing.JLabel lbTelefono;
    protected javax.swing.JLabel lbTipocomprobante;
    protected javax.swing.JLabel lbTipodefactura;
    private javax.swing.JLabel lbTotal;
    protected javax.swing.JLabel lbVenta;
    private javax.swing.JPanel plFacturar;
    private javax.swing.JPanel plProductos;
    private javax.swing.JTextArea taComentario;
    private javax.swing.JTable tbFacturacion;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField tfBuscar;
    private javax.swing.JTextField tfBusqueda;
    protected javax.swing.JTextField tfCliente;
    private javax.swing.JTextField tfCodcliente;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDescto;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfFecha;
    private javax.swing.JTextField tfITBIS;
    protected javax.swing.JTextField tfNCF;
    protected javax.swing.JTextField tfNofactura;
    protected javax.swing.JTextField tfPagado;
    private javax.swing.JTextField tfSubtotal;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
