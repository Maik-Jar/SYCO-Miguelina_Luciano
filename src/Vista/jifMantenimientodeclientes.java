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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class jifMantenimientodeclientes extends javax.swing.JInternalFrame {
    TableColumnModel tcmtbMantenimientodeclientes;
    DefaultTableModel dtmtbMantenimientodeclientes;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usr;

    Conexion con = new Conexion();
    Validacion valida = new Validacion();
    
    private void Configuraciontabla() {
        //Asignación de tamaño a las celdas de cada columna.
        tcmtbMantenimientodeclientes = tbMantenimientodeclientes.getColumnModel();
        tcmtbMantenimientodeclientes.getColumn(0).setPreferredWidth(40); // Codigo.
        tcmtbMantenimientodeclientes.getColumn(1).setPreferredWidth(250); // Cliente.
        tcmtbMantenimientodeclientes.getColumn(2).setPreferredWidth(70); // ID.
        tcmtbMantenimientodeclientes.getColumn(3).setPreferredWidth(60); // Documento.
        tcmtbMantenimientodeclientes.getColumn(4).setPreferredWidth(80); // Telefono.
        tcmtbMantenimientodeclientes.getColumn(5).setPreferredWidth(40); // Estatus.
        //Asignación de cantidad de filas.
        dtmtbMantenimientodeclientes = (DefaultTableModel) tbMantenimientodeclientes.getModel();
        dtmtbMantenimientodeclientes.setRowCount(0);
        //Asignación de color al Background, color al texto y estilo de fuente del encabezado de columna.
        Color bgTitulocolumn = new Color(31, 78, 121);
        Color fgTitulocolumn = new Color(255, 255, 255);
        tbMantenimientodeclientes.getColumnModel().getColumn(0).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientodeclientes.getColumnModel().getColumn(1).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientodeclientes.getColumnModel().getColumn(2).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientodeclientes.getColumnModel().getColumn(3).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientodeclientes.getColumnModel().getColumn(4).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientodeclientes.getColumnModel().getColumn(5).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        //Alineación de contenido de columnas.
        DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tbMantenimientodeclientes.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tbMantenimientodeclientes.getColumnModel().getColumn(2).setCellRenderer(alinear);
        tbMantenimientodeclientes.getColumnModel().getColumn(3).setCellRenderer(alinear);
        tbMantenimientodeclientes.getColumnModel().getColumn(4).setCellRenderer(alinear);
        tbMantenimientodeclientes.getColumnModel().getColumn(5).setCellRenderer(alinear);
    }
    
    public jifMantenimientodeclientes(Usuario usr) {
        this.setSize(800, 600);
        initComponents();
        Configuraciontabla();
        Buscar_Cliente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdDatosclientes = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        cbDocumento = new javax.swing.JComboBox<>();
        tfID = new javax.swing.JTextField();
        lbCliente = new javax.swing.JLabel();
        tfCliente = new javax.swing.JTextField();
        lbDireccion = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lbEstatus = new javax.swing.JLabel();
        cbEstatus = new javax.swing.JComboBox<>();
        btCerrarjdDatosclientes = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        tfindex = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lbTipodebusqueda = new javax.swing.JLabel();
        cbTipodebusqueda = new javax.swing.JComboBox<>();
        tfBusqueda = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMantenimientodeclientes = new javax.swing.JTable();
        btCerrar = new javax.swing.JButton();
        btNuevo = new javax.swing.JButton();

        jdDatosclientes.setTitle("Nuevo Cliente");

        lbCodigo.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbCodigo.setForeground(new java.awt.Color(118, 113, 113));
        lbCodigo.setText("Código:");

        tfCodigo.setEditable(false);
        tfCodigo.setBackground(new java.awt.Color(255, 255, 255));
        tfCodigo.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cbDocumento.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        cbDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula", "RNC", "Pasaporte" }));

        tfID.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfIDKeyPressed(evt);
            }
        });

        lbCliente.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbCliente.setForeground(new java.awt.Color(118, 113, 113));
        lbCliente.setText("Cliente:*");

        tfCliente.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfClienteActionPerformed(evt);
            }
        });
        tfCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfClienteKeyPressed(evt);
            }
        });

        lbDireccion.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbDireccion.setForeground(new java.awt.Color(118, 113, 113));
        lbDireccion.setText("Dirección:*");

        tfDireccion.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDireccionKeyPressed(evt);
            }
        });

        lbTelefono.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbTelefono.setForeground(new java.awt.Color(118, 113, 113));
        lbTelefono.setText("Teléfono:*");

        tfTelefono.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefonoActionPerformed(evt);
            }
        });
        tfTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTelefonoKeyPressed(evt);
            }
        });

        lbEmail.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(118, 113, 113));
        lbEmail.setText("Email:");

        tfEmail.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        lbEstatus.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbEstatus.setForeground(new java.awt.Color(118, 113, 113));
        lbEstatus.setText("Estatus:");

        cbEstatus.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        cbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        btCerrarjdDatosclientes.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrarjdDatosclientes.setText("Cerrar");
        btCerrarjdDatosclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarjdDatosclientesActionPerformed(evt);
            }
        });

        btAgregar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        btModificar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        tfindex.setVisible(false);
        tfindex.setEditable(false);
        tfindex.setBackground(new java.awt.Color(255, 255, 255));
        tfindex.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfindex.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfindex, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbEstatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbCliente)
                                    .addComponent(lbDireccion)
                                    .addComponent(lbTelefono)
                                    .addComponent(lbEmail))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCerrarjdDatosclientes))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCodigo)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEstatus)
                    .addComponent(tfindex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbCliente)
                    .addComponent(tfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbTelefono)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbEmail)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCerrarjdDatosclientes)
                    .addComponent(btAgregar)
                    .addComponent(btModificar)))
        );

        javax.swing.GroupLayout jdDatosclientesLayout = new javax.swing.GroupLayout(jdDatosclientes.getContentPane());
        jdDatosclientes.getContentPane().setLayout(jdDatosclientesLayout);
        jdDatosclientesLayout.setHorizontalGroup(
            jdDatosclientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdDatosclientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jdDatosclientesLayout.setVerticalGroup(
            jdDatosclientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdDatosclientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setTitle("Mantenimiento de Clientes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/clientes.png"))); // NOI18N

        lbTipodebusqueda.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbTipodebusqueda.setForeground(new java.awt.Color(118, 113, 113));
        lbTipodebusqueda.setText("Tipo de búsqueda*");

        cbTipodebusqueda.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 16)); // NOI18N
        cbTipodebusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Cliente", "ID", "Documento", "Teléfono", "Estatus" }));

        tfBusqueda.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
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

        tbMantenimientodeclientes.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbMantenimientodeclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Cliente", "ID", "Documento", "Teléfono", "Estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tbMantenimientodeclientes.setRowHeight(22);
        tbMantenimientodeclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMantenimientodeclientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMantenimientodeclientes);

        btCerrar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        btNuevo.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btNuevo.setText("Nuevo");
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTipodebusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscar))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(btNuevo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btCerrar))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar)
                    .addComponent(cbTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTipodebusqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCerrar)
                    .addComponent(btNuevo)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

    private void tfBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBusquedaKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            btBuscar.requestFocus();
        }
    }//GEN-LAST:event_tfBusquedaKeyPressed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        Buscar_Cliente();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        if (!("Nuevo Cliente".equals(jdDatosclientes.getTitle()))) {
            jdDatosclientes.setTitle("Nuevo Cliente");
            btModificar.setVisible(false);
            btAgregar.setVisible(true);
        }
        Buscar_Codigo ();
        jdDatosclientes.setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/añadir.png")).getImage());
        btModificar.setVisible(false);
        jdDatosclientes.setSize(440,370);
        jdDatosclientes.setLocationRelativeTo(null);
        jdDatosclientes.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        jdDatosclientes.setVisible(true);
    }//GEN-LAST:event_btNuevoActionPerformed

    private void btCerrarjdDatosclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarjdDatosclientesActionPerformed
        jdDatosclientes.dispose();
        Limpiar();
    }//GEN-LAST:event_btCerrarjdDatosclientesActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed

        if (tfID.getText().isEmpty() || tfCliente.getText().isEmpty() || tfDireccion.getText().isEmpty() || tfTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(jdDatosclientes, "Los campos con " + "*" + " son obligatorios, por favor llenarlos todos.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
        } else if (valida.Cliente_igual("documentos", "ID", tfID.getText(), tfID.getText(), cbDocumento.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(jdDatosclientes, "El/ La " + cbDocumento.getSelectedItem().toString() + ", " + tfID.getText() + " ya existe. \n No puede haber más de un cliente con el mismo ID.", "INFORMACIÒN", JOptionPane.ERROR_MESSAGE);
        } else {

            try {

                // Conexion a la base de datos.
                Connection conn = con.getConnection();

                // Consulta a la base de datos.
                ps = conn.prepareCall("{ call jdDatosclientes_INSERTAR_CLIENTE (?,?,?,?,?,?,?,?) }");
                // Parametros.
                ps.setInt(1, Integer.parseInt(tfCodigo.getText())); // Código.
                ps.setString(2, cbDocumento.getSelectedItem().toString()); // Tipo de Documento.
                ps.setString(3, tfID.getText()); // ID.
                ps.setString(4, tfCliente.getText().toUpperCase()); // Cliente.
                ps.setString(5, tfDireccion.getText()); // Direccion.
                ps.setString(6, tfTelefono.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "")); // Telefono.
                ps.setString(7, tfEmail.getText()); // Email.
                ps.setString(8, cbEstatus.getSelectedItem().toString()); // Estatus.
                // Ejecutar Query.
                rs = ps.executeQuery();
                // Cerrar conexion.
                conn.close();

                JOptionPane.showMessageDialog(jdDatosclientes, "El nuevo cliente ha sido creado!!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                Limpiar ();
                Buscar_Codigo();
                Buscar_Cliente();
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btAgregarActionPerformed

    private void tfIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIDKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            tfCliente.requestFocus();
        }
    }//GEN-LAST:event_tfIDKeyPressed

    private void tfClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfClienteKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            tfDireccion.requestFocus();
        }
    }//GEN-LAST:event_tfClienteKeyPressed

    private void tfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfClienteActionPerformed
        String texto;
        texto = tfCliente.getText().toUpperCase();
        tfCliente.setText(texto);
    }//GEN-LAST:event_tfClienteActionPerformed

    private void tfDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDireccionKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            tfTelefono.requestFocus();
        }
    }//GEN-LAST:event_tfDireccionKeyPressed

    private void tfTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            btAgregar.requestFocus();
        }
    }//GEN-LAST:event_tfTelefonoKeyPressed

    private void tfTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefonoActionPerformed
        String telefono = null; // numero de telefono
        String patron = "(%s) %s-%s"; // patron de formato para el numero de telefono
        telefono = tfTelefono.getText();
        tfTelefono.setText(String.format(patron, telefono.substring(0, 3), telefono.substring(3, 6), telefono.substring(6)));
    }//GEN-LAST:event_tfTelefonoActionPerformed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
        
        int opcion = JOptionPane.showConfirmDialog(jdDatosclientes, "¿Está seguro que desea modificar este cliente?", "PRECAUCIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (opcion == 0) {
            if (tfID.getText().isEmpty() || tfCliente.getText().isEmpty() || tfDireccion.getText().isEmpty() || tfTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(jdDatosclientes, "Los campos con " + "*" + " son obligatorios, por favor llenarlos todos.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
            }else if (valida.ID_igual("documentos", "index", tfindex.getText(), tfID.getText(), cbDocumento.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(jdDatosclientes,  "El/ La " + cbDocumento.getSelectedItem().toString() + ", " + tfID.getText() + " ya existe. \n No puede haber más de un cliente con el mismo ID.", "INFORMACION", JOptionPane.ERROR_MESSAGE);
            } else {
                try {

                    // Conexion a la base de datos.
                    Connection conn = con.getConnection();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jdDatosclientes_ACTUALIZAR_CLIENTE (?,?,?,?,?,?,?,?,?) }");
                    // Parametros.
                    ps.setInt(1, Integer.parseInt(tfCodigo.getText())); // Código.
                    ps.setString(2, cbDocumento.getSelectedItem().toString()); // Tipo de Documento.
                    ps.setString(3, tfID.getText()); // ID.
                    ps.setString(4, tfCliente.getText().toUpperCase()); // Cliente.
                    ps.setString(5, tfDireccion.getText()); // Direccion.
                    ps.setString(6, tfTelefono.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "")); // Telefono.
                    ps.setString(7, tfEmail.getText()); // Email.
                    ps.setString(8, cbEstatus.getSelectedItem().toString()); // Estatus.
                    ps.setInt(9, Integer.parseInt(tfindex.getText())); // Index
                    System.out.println(tfindex.getText());
                    // Ejecutar Query.
                    rs = ps.executeQuery();
                    // Cerrar conexion.
                    conn.close();

                    JOptionPane.showMessageDialog(jdDatosclientes, "El  cliente ha sido modificado!!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                    Limpiar();
                    Buscar_Cliente();
                    jdDatosclientes.dispose();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(jdDatosclientes, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void tbMantenimientodeclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMantenimientodeclientesMouseClicked
        String telefono = null; // numero de telefono
        String patron = "(%s) %s-%s"; // patron de formato para el numero de telefono
        if (evt.getClickCount() == 2) {

            try {

                // Conexion a la base de datos.
                Connection conn = con.getConnection();

                // Consulta a la base de datos.
                ps = conn.prepareCall("{ call jdDatosclientes_BUSCAR_DATOS_CLIENTE (?) }");

                ps.setInt(1, Integer.parseInt(dtmtbMantenimientodeclientes.getValueAt(tbMantenimientodeclientes.getSelectedRow(), 0).toString()));

                rs = ps.executeQuery();

                if (rs.next()) {
                    tfCodigo.setText(rs.getString(1));
                    tfCliente.setText(rs.getString(2).toUpperCase());
                    tfID.setText(rs.getString(3));
                    cbDocumento.setSelectedItem(rs.getString(4));
                    tfDireccion.setText(rs.getString(5));
                    telefono = rs.getString(6);
                    tfTelefono.setText(String.format(patron, telefono.substring(0, 3), telefono.substring(3, 6), telefono.substring(6)));
                    tfEmail.setText(rs.getString(7));
                    cbEstatus.setSelectedItem(rs.getString(8));
                    tfindex.setText(String.valueOf(rs.getInt(9)));
                    System.out.println(String.valueOf(rs.getInt(9)));
                }

                conn.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(jdDatosclientes, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }

            if (!"Datos de cliente".equals(jdDatosclientes.getTitle())) {
                jdDatosclientes.setTitle("Datos de cliente");
                btModificar.setVisible(true);
                btAgregar.setVisible(false);
            }

            jdDatosclientes.setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/editar.png")).getImage());
            jdDatosclientes.setSize(440,370);
            jdDatosclientes.setLocationRelativeTo(null);
            jdDatosclientes.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            jdDatosclientes.setVisible(true);
        }
    }//GEN-LAST:event_tbMantenimientodeclientesMouseClicked

    private void Buscar_Cliente () {
        Object[] registro = new Object[6];
        dtmtbMantenimientodeclientes.setRowCount(0);
        
        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifMantenimientodeclientes_BUSCAR_CLIENTES (?,?) }");

            ps.setString(1, cbTipodebusqueda.getSelectedItem().toString());
            ps.setString(2, "%"+tfBusqueda.getText()+"%");

            rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getInt(1); // Código.
                registro[1] = rs.getString(2); // Cliente.
                registro[2] = rs.getString(3); // ID.
                registro[3] = rs.getString(4); // Documento.
                registro[4] = rs.getString(5); // Telefono.
                registro[5] = rs.getString(6); // Estatus.
                dtmtbMantenimientodeclientes.addRow(registro);
            }

            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void Buscar_Codigo () {
       int ticket = 0;
        
        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jdDatosclientes_BUSCAR_CODIGO () }");
            // Ejecutar Query.
            rs = ps.executeQuery();

            if (rs.next()) {
               ticket = rs.getInt(1);
               ticket += 1;
               tfCodigo.setText(String.valueOf(ticket));
            }

            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void Limpiar () {
        cbEstatus.setSelectedIndex(0);
        cbDocumento.setSelectedIndex(0);
        tfID.setText(null);
        tfCliente.setText(null);
        tfDireccion.setText(null);
        tfTelefono.setText(null);
        tfEmail.setText(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btCerrarjdDatosclientes;
    private javax.swing.JButton btModificar;
    private javax.swing.JButton btNuevo;
    private javax.swing.JComboBox<String> cbDocumento;
    private javax.swing.JComboBox<String> cbEstatus;
    private javax.swing.JComboBox<String> cbTipodebusqueda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog jdDatosclientes;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEstatus;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTipodebusqueda;
    private javax.swing.JTable tbMantenimientodeclientes;
    private javax.swing.JTextField tfBusqueda;
    private javax.swing.JTextField tfCliente;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JTextField tfindex;
    // End of variables declaration//GEN-END:variables
}
