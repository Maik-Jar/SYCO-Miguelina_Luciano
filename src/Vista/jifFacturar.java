
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
        this.setSize(950,720);
    }
    
    private void Configuraciontabla (){
        //Asignación de tamaño a las celdas de cada columna.
        tcmtbFacturacion = tbFacturacion.getColumnModel();
        tcmtbProductos = tbProductos.getColumnModel();
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
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/facturar.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(950, 660));
        setPreferredSize(new java.awt.Dimension(950, 660));

        plFacturar.setToolTipText("");
        plFacturar.setName(""); // NOI18N
        plFacturar.setPreferredSize(new java.awt.Dimension(880, 378));

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
                "", "Código", "Descripción", "Precio Und.", "Cant.", "Precio", "Descto.", "ITBIS", "Monto", ""
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
        tbFacturacion.setRowHeight(25);
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

        btCerrar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        btFacturar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btFacturar.setText("Facturar");
        btFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFacturarActionPerformed(evt);
            }
        });

        lbNota.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbNota.setForeground(new java.awt.Color(118, 113, 113));
        lbNota.setText("Estatus");

        btGenerar.setVisible(false);
        btGenerar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btGenerar.setText("Generar");
        btGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerarActionPerformed(evt);
            }
        });

        lbNota.setVisible(false);
        lbCodigo.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbCodigo.setForeground(new java.awt.Color(118, 113, 113));
        lbCodigo.setText("Código art.:");

        tfCodigo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tfCodigo.setToolTipText("Para hacer una busqueda por descripción deje la casilla vacía y presione la telca F2.");
        tfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodigoKeyPressed(evt);
            }
        });

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

        btLimpiar.setVisible(false);
        btLimpiar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
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
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(plFacturarLayout.createSequentialGroup()
                        .addComponent(lbCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chbPreventa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbNota)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                        .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btGenerar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btFacturar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCerrar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                                .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbComentario)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
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
                                        .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        plFacturarLayout.setVerticalGroup(
            plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plFacturarLayout.createSequentialGroup()
                .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plFacturarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbCodigo)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbPreventa))
                        .addGap(12, 12, 12))
                    .addGroup(plFacturarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lbNota)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(plFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGenerar)
                    .addComponent(btFacturar)
                    .addComponent(btCerrar)
                    .addComponent(btLimpiar)))
        );

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
        cbDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDocumentoActionPerformed(evt);
            }
        });

        tfBusqueda.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfBusqueda.setEnabled(false);
        tfBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBusquedaKeyPressed(evt);
            }
        });

        btBuscar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 16)); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        tfCodcliente.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfCodcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCodclienteKeyPressed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(tfCodcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar)
                    .addComponent(tfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCliente)
                    .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfDireccion)
                    .addComponent(lbDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date now = new java.util.Date();
        this.tfFecha.setText(dateFormat.format(now));
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

        lbTipocomprobante.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbTipocomprobante.setForeground(new java.awt.Color(118, 113, 113));
        lbTipocomprobante.setText("Compobante:");

        cbComprobante.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 16)); // NOI18N
        cbComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Valor Fiscal", "Consumo", "Nota Crédito", "Reg. Especial", "Gubernamental", "Exportaciones" }));
        cbComprobante.setSelectedIndex(1);
        cbComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComprobanteActionPerformed(evt);
            }
        });

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
                            .addComponent(lbTipocomprobante)
                            .addComponent(lbNofactura))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatosfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbComprobante, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfNCF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfNofactura))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosfacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipocomprobante)
                    .addComponent(cbComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(plFacturar, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpDatosfactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDatosfactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpDatosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plFacturar, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
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
                lbTipodefactura.setFont(new Font ("Tw Cen MT Condensed", 1, 36));
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
