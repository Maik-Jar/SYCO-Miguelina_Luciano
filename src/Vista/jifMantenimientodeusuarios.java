package Vista;

import Modelo.Conexion;
import Modelo.HashMD5;
import Modelo.MiRenderer;
import Modelo.Validacion;
import java.sql.Connection;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class jifMantenimientodeusuarios extends javax.swing.JInternalFrame {
    
    DefaultTableModel dtmtbMantenimientousuarios;
    DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
    Color bgTitulocolumn = new Color(31, 78, 121);
    Color fgTitulocolumn = new Color(255, 255, 255);
    Conexion con = new Conexion();
    ResultSet rs;
    PreparedStatement ps;
    int idUsuario;
    
    Validacion valida = new Validacion();
    HashMD5 md5 = new HashMD5();
    
    private void Configuracionventana () {
        this.setSize(850, 560);
    }
    
    private void Configuraciontabla() {
        //Asignación de tamaño a las celdas de cada columna.
        /*tcmtbMantenimientodeservicios = tbMantenimientodeservicios.getColumnModel();
        tcmtbMantenimientodeservicios.getColumn(0).setPreferredWidth(50);
        tcmtbMantenimientodeservicios.getColumn(1).setPreferredWidth(310);
        tcmtbMantenimientodeservicios.getColumn(2).setPreferredWidth(60);
        tcmtbMantenimientodeservicios.getColumn(3).setPreferredWidth(80);
        tcmtbMantenimientodeservicios.getColumn(4).setPreferredWidth(80);
        tcmtbMantenimientodeservicios.getColumn(5).setPreferredWidth(70);
        tcmtbMantenimientodeservicios.getColumn(6).setPreferredWidth(158);*/
        //Asignación de cantidad de columnas.
        dtmtbMantenimientousuarios = (DefaultTableModel) tbMantenimientousuarios.getModel();
        dtmtbMantenimientousuarios.setRowCount(0);
        //Asignación de color al Background, color al texto y estilo de fuente del encabezado de columna.
        tbMantenimientousuarios.getColumnModel().getColumn(0).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientousuarios.getColumnModel().getColumn(1).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientousuarios.getColumnModel().getColumn(2).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbMantenimientousuarios.getColumnModel().getColumn(3).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        //Alineación de contenido de columnas.
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tbMantenimientousuarios.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tbMantenimientousuarios.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        tbMantenimientousuarios.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        tbMantenimientousuarios.getColumnModel().getColumn(3).setCellRenderer(Alinear);
    }
            
    public jifMantenimientodeusuarios() {
        initComponents();
        Configuracionventana ();
        Configuraciontabla();
        Buscar_usuario();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdDatosusuario = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        lbNick = new javax.swing.JLabel();
        tfNick = new javax.swing.JTextField();
        lbContrasena = new javax.swing.JLabel();
        pfContrasena = new javax.swing.JPasswordField();
        lbValidarcontrasena = new javax.swing.JLabel();
        pfValidarcontrasena = new javax.swing.JPasswordField();
        lbPuesto = new javax.swing.JLabel();
        tfPuesto = new javax.swing.JTextField();
        lbNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        lbApellido = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        lbRol = new javax.swing.JLabel();
        cbRol = new javax.swing.JComboBox<>();
        btCerrarjdDatosusuario = new javax.swing.JButton();
        btGuardar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        plAccesos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMantenimientousuarios = new javax.swing.JTable();
        btCerrar = new javax.swing.JButton();
        btCrear = new javax.swing.JButton();
        lbTipodebusqueda = new javax.swing.JLabel();
        cbTipodebusqueda = new javax.swing.JComboBox<>();
        tfTipodebusqueda = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();

        jdDatosusuario.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        lbNick.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbNick.setText("Nick*");

        tfNick.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        lbContrasena.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbContrasena.setText("Contraseña*");

        pfContrasena.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        pfContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pfContrasenaFocusGained(evt);
            }
        });

        lbValidarcontrasena.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbValidarcontrasena.setText("<html>Validar contraseña*<\\html>");

        pfValidarcontrasena.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        pfValidarcontrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pfValidarcontrasenaFocusGained(evt);
            }
        });
        pfValidarcontrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfValidarcontrasenaKeyPressed(evt);
            }
        });

        lbPuesto.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbPuesto.setText("Puesto*");

        tfPuesto.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        lbNombre.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbNombre.setText("Nombre*");

        tfNombre.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNombreFocusLost(evt);
            }
        });

        lbApellido.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbApellido.setText("Apellido*");

        tfApellido.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfApellidoFocusLost(evt);
            }
        });

        lbRol.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbRol.setText("Rol*");

        cbRol.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Master", "Administrador" }));

        btCerrarjdDatosusuario.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrarjdDatosusuario.setText("Cerrar");
        btCerrarjdDatosusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarjdDatosusuarioActionPerformed(evt);
            }
        });

        btGuardar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btEliminar.setVisible(false);
        btEliminar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btEliminar.setText("Eliminar");
        btEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbContrasena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNombre)
                            .addComponent(lbNick)
                            .addComponent(lbPuesto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfNick, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbRol))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbApellido)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCerrarjdDatosusuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbValidarcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pfValidarcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbNombre)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbApellido)
                            .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbRol)
                            .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNick, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNick, javax.swing.GroupLayout.Alignment.CENTER))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbPuesto)
                    .addComponent(tfPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbContrasena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pfValidarcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbValidarcontrasena, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCerrarjdDatosusuario)
                    .addComponent(btGuardar)
                    .addComponent(btModificar)
                    .addComponent(btEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdDatosusuarioLayout = new javax.swing.GroupLayout(jdDatosusuario.getContentPane());
        jdDatosusuario.getContentPane().setLayout(jdDatosusuarioLayout);
        jdDatosusuarioLayout.setHorizontalGroup(
            jdDatosusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdDatosusuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdDatosusuarioLayout.setVerticalGroup(
            jdDatosusuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdDatosusuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setTitle("Mantenimiento de Usuarios");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/usuario.png"))); // NOI18N

        tbMantenimientousuarios.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbMantenimientousuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Usuario", "Propietario", "Puesto", "Rol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMantenimientousuarios.setRowHeight(25);
        tbMantenimientousuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbMantenimientousuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbMantenimientousuarios);

        btCerrar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        btCrear.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCrear.setText("Crear");
        btCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearActionPerformed(evt);
            }
        });

        lbTipodebusqueda.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbTipodebusqueda.setForeground(new java.awt.Color(118, 113, 113));
        lbTipodebusqueda.setText("Tipo de búsqueda*");

        cbTipodebusqueda.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        cbTipodebusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Propietario", "Puesto" }));

        tfTipodebusqueda.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        tfTipodebusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTipodebusquedaKeyPressed(evt);
            }
        });

        btBuscar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plAccesosLayout = new javax.swing.GroupLayout(plAccesos);
        plAccesos.setLayout(plAccesosLayout);
        plAccesosLayout.setHorizontalGroup(
            plAccesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plAccesosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plAccesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(plAccesosLayout.createSequentialGroup()
                        .addComponent(lbTipodebusqueda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(tfTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btBuscar)))
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plAccesosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCerrar)
                .addContainerGap())
        );
        plAccesosLayout.setVerticalGroup(
            plAccesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plAccesosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plAccesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbTipodebusqueda)
                    .addComponent(cbTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTipodebusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(plAccesosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCerrar)
                    .addComponent(btCrear))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plAccesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plAccesos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        Buscar_usuario();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btCerrarjdDatosusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarjdDatosusuarioActionPerformed
        jdDatosusuario.dispose();
        Limpiarcampos();
    }//GEN-LAST:event_btCerrarjdDatosusuarioActionPerformed

    private void btCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearActionPerformed
        
        if (!"Nuevo usuario".equals(jdDatosusuario.getTitle())) {
            jdDatosusuario.setTitle("Nuevo usuario");
        }
        
        if (btGuardar.isVisible() != true) {
            btGuardar.setVisible(true);
            btModificar.setVisible(false);
            btEliminar.setVisible(false);
        }
        
        jdDatosusuario.setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/añadir.png")).getImage());
        jdDatosusuario.setSize(480, 370);
        jdDatosusuario.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        jdDatosusuario.setLocationRelativeTo(null);
        jdDatosusuario.setVisible(true);
    }//GEN-LAST:event_btCrearActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed

        if (tfNick.getText().trim().isEmpty() || pfContrasena.getText().trim().isEmpty() || tfPuesto.getText().trim().isEmpty() || tfNombre.getText().trim().isEmpty() || tfApellido.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
        } else if (valida.Existencia_de_usuario(tfNick.getText().trim()) == true) {
            JOptionPane.showMessageDialog(null, "Ya exite otro usuario con el mismo Nick.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
        } else {
            
            String pass = new String(pfContrasena.getPassword());
            String cpass = new String(pfValidarcontrasena.getPassword());
            
            if (!pass.equals(cpass)) {
                JOptionPane.showMessageDialog(null, "Las contraseñas deben de ser iguales.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
            } else {
                String npass = HashMD5.encode("llavedeencriptacion", pass);
                try {

                    // Conexion a la base de datos.
                    Connection conn = con.getConnection();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jdDatosusuario_INSERTAR_USUARIO(?,?,?,?,?,?) }");

                    // Parametros de consulta.
                    ps.setString(1, tfNick.getText().trim());
                    ps.setString(2, npass);
                    ps.setString(3, tfPuesto.getText());
                    ps.setString(4, tfNombre.getText());
                    ps.setString(5, tfApellido.getText());
                    ps.setString(6, cbRol.getSelectedItem().toString());

                    rs = ps.executeQuery();

                    conn.close();

                    JOptionPane.showMessageDialog(null, "¡El usuario ha sido creado!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                    Limpiarcampos();
                    Buscar_usuario();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void tbMantenimientousuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMantenimientousuariosMousePressed
        
        if (evt.getClickCount() == 2) {

            if (!"Datos del usuario".equals(jdDatosusuario.getTitle())) {
                jdDatosusuario.setTitle("Datos del usuario");
            }

            if (btModificar.isVisible() != true && btEliminar.isVisible() != true) {
                btGuardar.setVisible(false);
                btModificar.setVisible(true);
                btEliminar.setVisible(true);
            }
            
            try {

                // Conexion a la base de datos.
                Connection conn = con.getConnection();

                // Consulta a la base de datos.
                ps = conn.prepareCall("{ call jdDatosusuario_BUSCAR_USUARIO (?) }");

                // Parametros de consulta.
                ps.setString(1,  dtmtbMantenimientousuarios.getValueAt(tbMantenimientousuarios.getSelectedRow(), 0).toString());

                rs = ps.executeQuery();

                // Recorrido de datos para obtencion de los resultados de la consulta.
                if (rs.next()) {
                    idUsuario = rs.getInt(1);
                    tfNick.setText(rs.getString(2));
                    pfContrasena.setText(HashMD5.deencode("llavedeencriptacion",rs.getString(3)));
                    tfPuesto.setText(rs.getString(4));
                    tfNombre.setText(rs.getString(5));
                    tfApellido.setText(rs.getString(6));
                    cbRol.setSelectedItem(rs.getString(7));
                }

                conn.close();
                
                pfValidarcontrasena.setText(pfContrasena.getText());

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }
            jdDatosusuario.setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/editar.png")).getImage());
            jdDatosusuario.setSize(480, 370);
            jdDatosusuario.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            jdDatosusuario.setLocationRelativeTo(null);
            jdDatosusuario.setVisible(true);
        }
    }//GEN-LAST:event_tbMantenimientousuariosMousePressed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
 
        int eleccion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea modificar los datos del usuario?", "PRECAUCIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (eleccion == 0) {

            if (tfNick.getText().trim().isEmpty() || pfContrasena.getText().trim().isEmpty() || tfPuesto.getText().trim().isEmpty() || tfNombre.getText().trim().isEmpty() || tfApellido.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor llene todos los campos.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
            } else {
                String pass = new String(pfContrasena.getPassword());
                String cpass = new String(pfValidarcontrasena.getPassword());

                if (!pass.equals(cpass)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas deben de ser iguales.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
                } else {

                    String npass = HashMD5.encode("llavedeencriptacion", pass);
                    
                    try {

                        // Conexion a la base de datos.
                        Connection conn = con.getConnection();

                        // Consulta a la base de datos.
                        ps = conn.prepareCall("{ call jdDatosusuario_ACTUALIZAR_USUARIO(?,?,?,?,?,?,?) }");

                        // Parametros de consulta.
                        ps.setInt(1, idUsuario);
                        ps.setString(2, tfNick.getText().trim());
                        ps.setString(3, npass);
                        ps.setString(4, tfPuesto.getText());
                        ps.setString(5, tfNombre.getText());
                        ps.setString(6, tfApellido.getText());
                        ps.setString(7, cbRol.getSelectedItem().toString());

                        rs = ps.executeQuery();

                        conn.close();

                        JOptionPane.showMessageDialog(null, "¡El usuario ha sido Modificado!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                        Limpiarcampos();
                        jdDatosusuario.dispose();
                        Buscar_usuario();
                        
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarActionPerformed

        int eleccion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el usuario?", "PRECAUCIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (eleccion == 0) {

            try {

                // Conexion a la base de datos.
                Connection conn = con.getConnection();

                // Consulta a la base de datos.
                ps = conn.prepareCall("{ call jdDatosusuario_ELIMINAR_USUARIO(?) }");

                // Parametros de consulta.
                ps.setInt(1, idUsuario);

                rs = ps.executeQuery();

                conn.close();

                JOptionPane.showMessageDialog(null, "¡El usuario ha sido eliminado!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                Limpiarcampos();
                Buscar_usuario();
                jdDatosusuario.dispose();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btEliminarActionPerformed

    private void pfContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfContrasenaFocusGained
        pfContrasena.selectAll();
    }//GEN-LAST:event_pfContrasenaFocusGained

    private void pfValidarcontrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pfValidarcontrasenaFocusGained
        pfValidarcontrasena.selectAll();
    }//GEN-LAST:event_pfValidarcontrasenaFocusGained

    private void pfValidarcontrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfValidarcontrasenaKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            btGuardar.requestFocus();
        }
    }//GEN-LAST:event_pfValidarcontrasenaKeyPressed

    private void tfTipodebusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTipodebusquedaKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            btBuscar.requestFocus();
        }
    }//GEN-LAST:event_tfTipodebusquedaKeyPressed

    private void tfNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNombreFocusLost
        if ("Nuevo usuario".equals(jdDatosusuario.getTitle())) {
            tfNick.setText(tfNombre.getText().substring(0, 1).toUpperCase());
        }
    }//GEN-LAST:event_tfNombreFocusLost

    private void tfApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfApellidoFocusLost
        if ("Nuevo usuario".equals(jdDatosusuario.getTitle())) {
            tfNick.setText(tfNick.getText() + tfApellido.getText().trim());
        }
    }//GEN-LAST:event_tfApellidoFocusLost

    private void Buscar_usuario() {
        Object[] registro = new Object[4];
        dtmtbMantenimientousuarios.setRowCount(0);

        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifMantenimientodeusuarios_BUSCAR_USUARIOS (?,?) }");

            // Parametros de consulta.
            ps.setString(1, cbTipodebusqueda.getSelectedItem().toString());
            ps.setString(2, "%" + tfTipodebusqueda.getText() + "%");
            
            rs = ps.executeQuery();

            // Recorrido de datos para obtencion de los resultados de la consulta.
            while (rs.next()) {

                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);

                dtmtbMantenimientousuarios.addRow(registro);
            }

            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void Limpiarcampos() {
        tfNick.setText(null);
        tfNombre.setText(null);
        tfApellido.setText(null);
        tfPuesto.setText(null);
        pfContrasena.setText(null);
        pfValidarcontrasena.setText(null);
        cbRol.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btCerrarjdDatosusuario;
    private javax.swing.JButton btCrear;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btModificar;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JComboBox<String> cbTipodebusqueda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog jdDatosusuario;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbContrasena;
    private javax.swing.JLabel lbNick;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPuesto;
    private javax.swing.JLabel lbRol;
    private javax.swing.JLabel lbTipodebusqueda;
    private javax.swing.JLabel lbValidarcontrasena;
    private javax.swing.JPasswordField pfContrasena;
    private javax.swing.JPasswordField pfValidarcontrasena;
    private javax.swing.JPanel plAccesos;
    private javax.swing.JTable tbMantenimientousuarios;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfNick;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPuesto;
    private javax.swing.JTextField tfTipodebusqueda;
    // End of variables declaration//GEN-END:variables
}
