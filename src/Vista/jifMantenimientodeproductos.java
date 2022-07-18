package Vista;

import Modelo.Conexion;
import Modelo.MiRenderer;
import Modelo.Usuario;
import Modelo.Validacion;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class jifMantenimientodeproductos extends javax.swing.JInternalFrame {

    DefaultTableModel dtmtbMantenimientodeproductos;
    TableColumnModel tcmtbMantenimientodeproductos;
    ResultSet rs;
    PreparedStatement ps;
    Usuario usr;

    DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
    Conexion con = new Conexion();
    Color bgTitulocolumn = new Color(31, 78, 121);
    Color fgTitulocolumn = new Color(255, 255, 255);
    Validacion valida = new Validacion();

    private void Configuracionventana() {
        this.setSize(850, 560);
    }

    private void Configuraciontabla() {
        //Asignación de tamaño a las celdas de cada columna.
        tcmtbMantenimientodeproductos = tbMantenimientodeproductos.getColumnModel();
        tcmtbMantenimientodeproductos.getColumn(0).setPreferredWidth(50);
        tcmtbMantenimientodeproductos.getColumn(1).setPreferredWidth(200);
        tcmtbMantenimientodeproductos.getColumn(2).setPreferredWidth(70);
        tcmtbMantenimientodeproductos.getColumn(3).setPreferredWidth(120);
        tcmtbMantenimientodeproductos.getColumn(4).setPreferredWidth(50);
        tcmtbMantenimientodeproductos.getColumn(5).setPreferredWidth(20);
        tcmtbMantenimientodeproductos.getColumn(6).setPreferredWidth(20);
        //Asignación de cantidad de columnas.
        dtmtbMantenimientodeproductos = (DefaultTableModel) tbMantenimientodeproductos.getModel();
        dtmtbMantenimientodeproductos.setRowCount(0);
        //Asignación de color al Background, color al texto y estilo de fuente del encabezado de columna.
        tbMantenimientodeproductos.getColumnModel().getColumn(0).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientodeproductos.getColumnModel().getColumn(1).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientodeproductos.getColumnModel().getColumn(2).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientodeproductos.getColumnModel().getColumn(3).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientodeproductos.getColumnModel().getColumn(4).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientodeproductos.getColumnModel().getColumn(5).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientodeproductos.getColumnModel().getColumn(6).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        //Alineación de contenido de columnas.
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tbMantenimientodeproductos.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tbMantenimientodeproductos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        tbMantenimientodeproductos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        tbMantenimientodeproductos.getColumnModel().getColumn(4).setCellRenderer(Alinear);
        tbMantenimientodeproductos.getColumnModel().getColumn(5).setCellRenderer(Alinear);
        tbMantenimientodeproductos.getColumnModel().getColumn(6).setCellRenderer(Alinear);
    }

    public jifMantenimientodeproductos(Usuario usr) {
        initComponents();
        Configuracionventana();
        Configuraciontabla();
        Busquedadeproductos();
        this.usr = usr;
        if ("Usuario".equals(usr.getRol())) {
            btAgregar.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdDatosproductos = new javax.swing.JDialog();
        plDatosservicio = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        lbDescripcion = new javax.swing.JLabel();
        tfDescripcion = new javax.swing.JTextField();
        lbPrecio = new javax.swing.JLabel();
        tfPrecio = new javax.swing.JTextField();
        lbCategoria = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        btCerrarjdDatosproductos = new javax.swing.JButton();
        btAgregarjdDatosproductos = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        lbCantidad = new javax.swing.JLabel();
        tfCantidad = new javax.swing.JTextField();
        chbitbis = new javax.swing.JCheckBox();
        chbDisponible = new javax.swing.JCheckBox();
        plMantenimientodeservicios = new javax.swing.JPanel();
        lbTipodebusqueda = new javax.swing.JLabel();
        cbTipodebusqueda = new javax.swing.JComboBox<>();
        tfTipodebusqueda = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMantenimientodeproductos = new javax.swing.JTable();
        btCerrar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();

        jdDatosproductos.setTitle("Agregar nuevo producto");

        lbCodigo.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbCodigo.setForeground(new java.awt.Color(118, 113, 113));
        lbCodigo.setText("Código:");

        tfCodigo.setEditable(false);
        tfCodigo.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        lbDescripcion.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbDescripcion.setForeground(new java.awt.Color(118, 113, 113));
        lbDescripcion.setText("Descripción*:");

        tfDescripcion.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        lbPrecio.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbPrecio.setForeground(new java.awt.Color(118, 113, 113));
        lbPrecio.setText("Precio*:");

        tfPrecio.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfPrecioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPrecioFocusLost(evt);
            }
        });

        lbCategoria.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbCategoria.setForeground(new java.awt.Color(118, 113, 113));
        lbCategoria.setText("Categoría*:");

        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifMantenimientodeproductos_BUSCAR_CATEGORIA () }");
            // Ejecución de consulta.
            rs = ps.executeQuery();

            while (rs.next()) {
                cbCategoria.addItem(rs.getString(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        cbCategoria.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 16)); // NOI18N
        cbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoriaItemStateChanged(evt);
            }
        });

        btCerrarjdDatosproductos.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrarjdDatosproductos.setText("Cerrar");
        btCerrarjdDatosproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarjdDatosproductosActionPerformed(evt);
            }
        });

        btAgregarjdDatosproductos.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btAgregarjdDatosproductos.setText("Agregar");
        btAgregarjdDatosproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarjdDatosproductosActionPerformed(evt);
            }
        });

        btModificar.setVisible(false);
        btModificar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        lbCantidad.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbCantidad.setForeground(new java.awt.Color(118, 113, 113));
        lbCantidad.setText("Cantidad*:");

        tfCantidad.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        chbitbis.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        chbitbis.setForeground(new java.awt.Color(118, 113, 113));
        chbitbis.setText("ITBIS");

        chbDisponible.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        chbDisponible.setForeground(new java.awt.Color(118, 113, 113));
        chbDisponible.setText("Disponible");

        javax.swing.GroupLayout plDatosservicioLayout = new javax.swing.GroupLayout(plDatosservicio);
        plDatosservicio.setLayout(plDatosservicioLayout);
        plDatosservicioLayout.setHorizontalGroup(
            plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plDatosservicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plDatosservicioLayout.createSequentialGroup()
                        .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbCategoria)
                                .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(plDatosservicioLayout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(lbCodigo))
                                    .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbPrecio)
                                        .addComponent(lbDescripcion))))
                            .addComponent(lbCantidad, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(plDatosservicioLayout.createSequentialGroup()
                                .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                                .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chbDisponible)
                                    .addComponent(chbitbis)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plDatosservicioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAgregarjdDatosproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCerrarjdDatosproductos)))
                .addContainerGap())
        );
        plDatosservicioLayout.setVerticalGroup(
            plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plDatosservicioLayout.createSequentialGroup()
                .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plDatosservicioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCategoria)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbitbis))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbCodigo)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbDescripcion)
                            .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbPrecio)
                            .addComponent(tfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbCantidad)
                            .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(plDatosservicioLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(chbDisponible)))
                .addGap(18, 18, 18)
                .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plDatosservicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCerrarjdDatosproductos)
                        .addComponent(btAgregarjdDatosproductos))
                    .addComponent(btModificar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdDatosproductosLayout = new javax.swing.GroupLayout(jdDatosproductos.getContentPane());
        jdDatosproductos.getContentPane().setLayout(jdDatosproductosLayout);
        jdDatosproductosLayout.setHorizontalGroup(
            jdDatosproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdDatosproductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plDatosservicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jdDatosproductosLayout.setVerticalGroup(
            jdDatosproductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdDatosproductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plDatosservicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setTitle("Mantenimiento de Productos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/mantenimientoproductos.png"))); // NOI18N

        lbTipodebusqueda.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbTipodebusqueda.setForeground(new java.awt.Color(118, 113, 113));
        lbTipodebusqueda.setText("Tipo de búsqueda*");

        cbTipodebusqueda.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 16)); // NOI18N
        cbTipodebusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Descripción", "Categoría" }));

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

        tbMantenimientodeproductos.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbMantenimientodeproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Precio", "Categoría", "Cantidad", "ITBIS", "Disp."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMantenimientodeproductos.setRowHeight(25);
        tbMantenimientodeproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbMantenimientodeproductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbMantenimientodeproductos);

        btCerrar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        btAgregar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plMantenimientodeserviciosLayout = new javax.swing.GroupLayout(plMantenimientodeservicios);
        plMantenimientodeservicios.setLayout(plMantenimientodeserviciosLayout);
        plMantenimientodeserviciosLayout.setHorizontalGroup(
            plMantenimientodeserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMantenimientodeserviciosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(plMantenimientodeserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(plMantenimientodeserviciosLayout.createSequentialGroup()
                        .addComponent(btAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCerrar))
                    .addGroup(plMantenimientodeserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(plMantenimientodeserviciosLayout.createSequentialGroup()
                            .addComponent(lbTipodebusqueda)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(tfTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(btBuscar))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        plMantenimientodeserviciosLayout.setVerticalGroup(
            plMantenimientodeserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMantenimientodeserviciosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(plMantenimientodeserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbTipodebusqueda)
                    .addComponent(cbTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(plMantenimientodeserviciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCerrar)
                    .addComponent(btAgregar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plMantenimientodeservicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plMantenimientodeservicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        Busquedadeproductos();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        if (!"Agregar nuevo producto".equals(jdDatosproductos.getTitle())) {
            jdDatosproductos.setTitle("Agregar nuevo producto");
        }

        if (btModificar.isVisible() == true) {
            btAgregarjdDatosproductos.setVisible(true);
            cbCategoria.setEnabled(true);
            btModificar.setVisible(false);
        }
        
        Codigo_producto();
        jdDatosproductos.setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/añadir.png")).getImage());
        jdDatosproductos.setSize(440, 320);
        jdDatosproductos.setLocationRelativeTo(null);
        jdDatosproductos.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        jdDatosproductos.setVisible(true);
    }//GEN-LAST:event_btAgregarActionPerformed

    private void btCerrarjdDatosproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarjdDatosproductosActionPerformed
        jdDatosproductos.dispose();
        LimpiarTexto();
    }//GEN-LAST:event_btCerrarjdDatosproductosActionPerformed

    private void btAgregarjdDatosproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarjdDatosproductosActionPerformed

        if (tfDescripcion.getText().trim().isEmpty() || tfPrecio.getText().trim().isEmpty() || tfCantidad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(jdDatosproductos, "Los campos con ''*'' son obligatorios. \n Por favor llene los campos.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
        } else if (valida.isNumeric(tfCantidad.getText()) == false) {
            JOptionPane.showMessageDialog(jdDatosproductos, "Cantidad*: Este campo solo admite números.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                
                Codigo_producto();
                
                // Conexión a la base de datos.
                Connection conn = con.getConnection();

                // Consulta a la base de datos.
                ps = conn.prepareCall("{ call jdDatosproductos_INSERTAR_PRODUCTOS (?,?,?,?,?,?,?) }");

                // Parametros de consulta.
                ps.setString(1, tfCodigo.getText());
                ps.setString(2, tfDescripcion.getText());
                ps.setDouble(3, Double.valueOf(tfPrecio.getText()));
                ps.setString(4, cbCategoria.getSelectedItem().toString());
                ps.setInt(5, Integer.parseInt(tfCantidad.getText()));
                if (chbitbis.isSelected()) {
                    ps.setString(6, "Si");
                } else {
                    ps.setString(6, "No");
                }
                if (chbDisponible.isSelected()) { // Evalua si el CheckBox Disponible está seleccionado.
                    ps.setString(7, "Si"); // Verdadero: Si
                } else {
                    ps.setString(7, "No"); // Falso: No.
                }

                rs = ps.executeQuery();

                JOptionPane.showMessageDialog(jdDatosproductos, "Se agrego un nuevo producto!!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

                //Cierre de conexión a la base de datos.
                conn.close();

                LimpiarTexto();
                Busquedadeproductos();
                Codigo_producto();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(jdDatosproductos, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btAgregarjdDatosproductosActionPerformed

    private void tbMantenimientodeproductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMantenimientodeproductosMousePressed

        if (!"Usuario".equals(usr.getRol())) {
            if (evt.getClickCount() == 2) {

                if (!"Información de Producto".equals(jdDatosproductos.getTitle())) {
                    jdDatosproductos.setTitle("Información de Producto");
                }

                if (btModificar.isVisible() == false) {
                    btAgregarjdDatosproductos.setVisible(false);
                    cbCategoria.setEnabled(false);
                    btModificar.setVisible(true);
                }

                tfCodigo.setText(dtmtbMantenimientodeproductos.getValueAt(tbMantenimientodeproductos.getSelectedRow(), 0).toString());
                tfDescripcion.setText(dtmtbMantenimientodeproductos.getValueAt(tbMantenimientodeproductos.getSelectedRow(), 1).toString());
                tfPrecio.setText(dtmtbMantenimientodeproductos.getValueAt(tbMantenimientodeproductos.getSelectedRow(), 2).toString().substring(3).replace(",", ""));
                cbCategoria.setSelectedItem(dtmtbMantenimientodeproductos.getValueAt(tbMantenimientodeproductos.getSelectedRow(), 3).toString());
                tfCantidad.setText(dtmtbMantenimientodeproductos.getValueAt(tbMantenimientodeproductos.getSelectedRow(), 4).toString());
                if ("Si".equals(dtmtbMantenimientodeproductos.getValueAt(tbMantenimientodeproductos.getSelectedRow(), 5).toString())) {
                    chbitbis.doClick();
                }
                if ("Si".equals(dtmtbMantenimientodeproductos.getValueAt(tbMantenimientodeproductos.getSelectedRow(), 6).toString())) {
                    chbDisponible.doClick();
                }
                jdDatosproductos.setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/editar.png")).getImage());
                jdDatosproductos.setSize(440, 320);
                jdDatosproductos.setLocationRelativeTo(null);
                jdDatosproductos.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                jdDatosproductos.setVisible(true);
            }
        }
    }//GEN-LAST:event_tbMantenimientodeproductosMousePressed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        
        int eleccion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea modificar los datos de este artículo?", "PRECAUCIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (eleccion == 0) {

            if ((tfDescripcion.getText().trim().isEmpty() || tfPrecio.getText().trim().isEmpty())) {
                JOptionPane.showMessageDialog(jdDatosproductos, "Los campos con ''*'' son obligatorios. \n Por favor llene los campos.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
            } else {
                try {

                    // Conexión a la base de datos.
                    Connection conn = con.getConnection();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jdDatosproductos_ACTUALIZAR_PRODUCTO (?,?,?,?,?,?,?) }");

                    // Parametros de consulta.
                    ps.setString(1, tfCodigo.getText()); // Código.
                    ps.setString(2, tfDescripcion.getText()); // Descripción.
                    ps.setDouble(3, Double.valueOf(tfPrecio.getText())); // Precio.
                    ps.setString(4, cbCategoria.getSelectedItem().toString()); // Categoria.
                    ps.setInt(5, Integer.parseInt(tfCantidad.getText())); // Cantidad.
                    if (chbitbis.isSelected()) { // Evalua si el CheckBox ITBIS está seleccionado.
                        ps.setString(6, "Si"); // Verdadero: Si
                    } else {
                        ps.setString(6, "No"); // Falso: No.
                    }

                    if (chbDisponible.isSelected()) { // Evalua si el CheckBox Disponible está seleccionado.
                        ps.setString(7, "Si"); // Verdadero: Si
                    } else {
                        ps.setString(7, "No"); // Falso: No.
                    }
                    // Ejecución de consulta.
                    rs = ps.executeQuery();

                    JOptionPane.showMessageDialog(jdDatosproductos, "El artículo ha sido actualizado.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

                    //Cierre de conexión a la base de datos.
                    conn.close();

                    LimpiarTexto();
                    jdDatosproductos.dispose();
                    Busquedadeproductos();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(jdDatosproductos, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void cbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoriaItemStateChanged
        if ("Agregar nuevo producto".equals(jdDatosproductos.getTitle())) {
            Codigo_producto();
        }
    }//GEN-LAST:event_cbCategoriaItemStateChanged

    private void tfTipodebusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTipodebusquedaKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            btBuscar.requestFocus();
        }
    }//GEN-LAST:event_tfTipodebusquedaKeyPressed

    private void tfPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrecioFocusGained
        tfPrecio.selectAll();
    }//GEN-LAST:event_tfPrecioFocusGained

    private void tfPrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPrecioFocusLost
        // Sección de codigo para dar formato a las columna de tipo double. Solo se mostrara dos decimales.
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        DecimalFormat formatodecimal = new DecimalFormat("####.00", simbolo);

        if (tfPrecio.getText().trim().isEmpty() == true) {
            tfPrecio.setText("0.00");
        } else if (valida.isNumeric(tfPrecio.getText().trim()) == false) {
            JOptionPane.showMessageDialog(jdDatosproductos, "No puedes digital texto en este campo.", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
        } else {
            double monto = Double.parseDouble(tfPrecio.getText().trim());
            tfPrecio.setText(String.valueOf(formatodecimal.format(monto)));
        }
    }//GEN-LAST:event_tfPrecioFocusLost

    private void Busquedadeproductos() {

        // Sección de codigo para dar formato a las columna de tipo double. Solo se mostrara dos decimales.
        NumberFormat formatodecimal = NumberFormat.getCurrencyInstance(new Locale("es", "DO"));

        Object[] registro = new Object[7];
        dtmtbMantenimientodeproductos.setRowCount(0);

        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifMantenimientodeproductos_BUSCAR_PRODUCTOS (?,?) }");

            // Parametros de consulta.
            ps.setString(1, cbTipodebusqueda.getSelectedItem().toString());
            ps.setString(2, "%" + tfTipodebusqueda.getText() + "%");

            rs = ps.executeQuery();

            // Recorrido de datos para obtencion de los resultados de la consulta.
            while (rs.next()) {

                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = formatodecimal.format(rs.getDouble(3));
                registro[3] = rs.getString(4);
                registro[4] = rs.getInt(5);
                registro[5] = rs.getString(6);
                registro[6] = rs.getString(7);

                dtmtbMantenimientodeproductos.addRow(registro);
            }

            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Codigo_producto() {

        String secuencia;
        String serie;
        
        int ticket = 0;

        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jdDatosproductos_BUSCAR_CODIGO_PRODUCTOS (?) }");

            // Parametros
            ps.setString(1, cbCategoria.getSelectedItem().toString());
            
            rs = ps.executeQuery();

            if (rs.next()) {
                
                serie = rs.getString("serie"); // Serie de la categoria.
                secuencia = rs.getString("secuencia"); // Secuencia del codigo.
                
                if (secuencia == null) {
                    ticket = 0;
                } else {
                    ticket = Integer.parseInt(secuencia.replaceAll("[^\\d.]", ""));
                }
                    //ticket += 1;
                    tfCodigo.setText(serie + String.valueOf(ticket));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void Cargarcategorias() { // Este metodo esta implementado en el codigo pre-inicio del objeto cbCategoria. Este es solo para documentacion.
        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifMantenimientodeproductos_BUSCAR_CATEGORIA () }");
            // Ejecución de consulta.
            rs = ps.executeQuery();

            while (rs.next()) {
                cbCategoria.addItem(rs.getString(1));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void LimpiarTexto() {
        tfDescripcion.setText(null);
        tfPrecio.setText(null);
        tfCodigo.setText(null);
        tfCantidad.setText(null);
        cbCategoria.setSelectedIndex(0);
        if (chbitbis.isSelected()) {
            chbitbis.doClick();
        }
        if (chbDisponible.isSelected()) {
            chbDisponible.doClick();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btAgregarjdDatosproductos;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btCerrarjdDatosproductos;
    private javax.swing.JButton btModificar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbTipodebusqueda;
    private javax.swing.JCheckBox chbDisponible;
    private javax.swing.JCheckBox chbitbis;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog jdDatosproductos;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbPrecio;
    private javax.swing.JLabel lbTipodebusqueda;
    private javax.swing.JPanel plDatosservicio;
    private javax.swing.JPanel plMantenimientodeservicios;
    private javax.swing.JTable tbMantenimientodeproductos;
    private javax.swing.JTextField tfCantidad;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDescripcion;
    private javax.swing.JTextField tfPrecio;
    private javax.swing.JTextField tfTipodebusqueda;
    // End of variables declaration//GEN-END:variables
}
