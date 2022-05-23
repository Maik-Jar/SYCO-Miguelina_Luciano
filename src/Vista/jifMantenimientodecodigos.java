package Vista;

import Modelo.Conexion;
import Modelo.MiRenderer;
import Modelo.Usuario;
import Modelo.Validacion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class jifMantenimientodecodigos extends javax.swing.JInternalFrame {
   
    TableColumnModel tcmtbCategoria;
    DefaultTableModel dtmtbCategoria;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usr;
    
    Conexion con = new Conexion();
    Validacion valida = new Validacion();
    
    private void Configuraciontabla() {
        //Asignación de tamaño a las celdas de cada columna.
        tcmtbCategoria = tbCategoria.getColumnModel();
        tcmtbCategoria.getColumn(0).setPreferredWidth(40);
        tcmtbCategoria.getColumn(1).setPreferredWidth(60);
        tcmtbCategoria.getColumn(2).setPreferredWidth(250);
        //Asignación de cantidad de filas.
        dtmtbCategoria = (DefaultTableModel) tbCategoria.getModel();
        dtmtbCategoria.setRowCount(0);
        //Asignación de color al Background, color al texto y estilo de fuente del encabezado de columna.
        Color bgTitulocolumn = new Color(31, 78, 121);
        Color fgTitulocolumn = new Color(255, 255, 255);
        tbCategoria.getColumnModel().getColumn(0).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbCategoria.getColumnModel().getColumn(1).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbCategoria.getColumnModel().getColumn(2).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        //Alineación de contenido de columnas.
        DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tbCategoria.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tbCategoria.getColumnModel().getColumn(1).setCellRenderer(alinear);
    }
    
    public jifMantenimientodecodigos(Usuario usr) {
        initComponents();
        this.setSize(700, 530);
        Configuraciontabla();
        Busquedadecategorias();
        this.usr = usr;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCategoria = new javax.swing.JTable();
        lbSerie = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        tfSerie = new javax.swing.JTextField();
        tfCategoria = new javax.swing.JTextField();
        btCerrar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btAgregar = new javax.swing.JButton();
        tfIndex = new javax.swing.JTextField();
        btLimpiar = new javax.swing.JButton();

        setTitle("Mantenimiento de Códigos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/categoria.png"))); // NOI18N

        jScrollPane1.setMinimumSize( jScrollPane1.getPreferredSize() );
        jScrollPane1.setPreferredSize(new java.awt.Dimension(2, 450));

        tbCategoria.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "Serie", "Categoría"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCategoria.setRowHeight(25);
        tbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbCategoriaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbCategoria);

        lbSerie.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbSerie.setForeground(new java.awt.Color(118, 113, 113));
        lbSerie.setText("Serie:");

        lbCategoria.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbCategoria.setForeground(new java.awt.Color(118, 113, 113));
        lbCategoria.setText("Categoría:");

        tfSerie.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        tfCategoria.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        btCerrar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        btModificar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });

        btAgregar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btAgregar.setText("Agregar");
        btAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }
        });

        tfIndex.setVisible(false);
        tfIndex.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N

        btLimpiar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btModificar)
                                .addGap(5, 5, 5)
                                .addComponent(btAgregar)
                                .addGap(5, 5, 5)
                                .addComponent(btCerrar))
                            .addComponent(tfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tfIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btLimpiar)
                                .addGap(119, 119, 119))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbCategoria)
                .addGap(5, 5, 5)
                .addComponent(tfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbSerie)
                .addGap(5, 5, 5)
                .addComponent(tfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btLimpiar)
                .addGap(36, 36, 36)
                .addComponent(tfIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btModificar)
                    .addComponent(btAgregar)
                    .addComponent(btCerrar)))
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

    private void tbCategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCategoriaMousePressed
        if (evt.getClickCount() == 2) {
            tfCategoria.setText(dtmtbCategoria.getValueAt(tbCategoria.getSelectedRow(), 2).toString());
            tfSerie.setText(dtmtbCategoria.getValueAt(tbCategoria.getSelectedRow(), 1).toString());
            tfIndex.setText(dtmtbCategoria.getValueAt(tbCategoria.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tbCategoriaMousePressed

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed
  
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea modificar esta categoría?", "PRECAUCIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == 0) {
            if (tfCategoria.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Categoria no puede estar vacio.", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
            } else if (tfSerie.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Serie no puede estar vacio.", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
            } else if (valida.Iguardad_categoria("codigo_productos", "index", tfIndex.getText(), tfCategoria.getText(), tfSerie.getText())) {
                // No se definio instrucción pues el metodo realizara la acción.
            } else {
                try {

                    // Conexion a la base de datos.
                    Connection conn = con.getConnection();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jifMantenimientodecodigo_ACTUALIZAR_CATEGORIA (?,?,?) }");
                    // Parametros de consulta
                    ps.setInt(1, Integer.parseInt(tfIndex.getText()));
                    ps.setString(2, tfSerie.getText());
                    ps.setString(3, tfCategoria.getText());
                    // Ejecución de la consulta
                    rs = ps.executeQuery();

                    // Cierre de conexión.
                    conn.close();

                    JOptionPane.showMessageDialog(null, "La categoría ha sido modificada!!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                    tfCategoria.setText(null);
                    tfSerie.setText(null);
                    tfIndex.setText(null);
                    Busquedadecategorias();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btModificarActionPerformed

    private void btAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActionPerformed
        
        int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea crear una nueva categoría?", "PRECAUCIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == 0) {
            if (tfCategoria.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Categoria no puede estar vacio.", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
            } else if (tfSerie.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Serie no puede estar vacio.", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
            } else if (valida.Existencia_de_categoria("codigo_productos", "categoria", tfCategoria.getText())) {
                JOptionPane.showMessageDialog(null, "La Categoría " + tfCategoria.getText() + " ya existe.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
            } else if (valida.Existencia_de_categoria("codigo_productos", "codigo", tfSerie.getText())) {
                JOptionPane.showMessageDialog(null, "La Serie " + tfSerie.getText() + " ya existe.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
            }else {
                try {

                    // Conexion a la base de datos.
                    Connection conn = con.getConnection();

                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call  jifMantenimientodecodigo_INSERTAR_CATEGORIA (?,?) }");
                    // Parametros de consulta
                    ps.setString(1, tfSerie.getText().toUpperCase().trim());
                    ps.setString(2, tfCategoria.getText());
                    // Ejecución de la consulta
                    rs = ps.executeQuery();

                    // Cierre de conexión.
                    conn.close();

                    JOptionPane.showMessageDialog(null, "La nueva categoría ha sido agregada!!", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
                    tfCategoria.setText(null);
                    tfSerie.setText(null);
                    Busquedadecategorias();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btAgregarActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        tfCategoria.setText(null);
        tfSerie.setText(null);
        tfIndex.setText(null);
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void Busquedadecategorias() {

        Object[] registro = new Object[3];
        dtmtbCategoria.setRowCount(0);

        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifMantenimientodecodigo_BUSCAR_CATEGORIA () }");
            // Ejecución de la consulta
            rs = ps.executeQuery();

            // Recorrido de datos para obtencion de los resultados de la consulta.
            while (rs.next()) {

                registro[0] = rs.getInt(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                
                dtmtbCategoria.addRow(registro);
                tbCategoria.setPreferredScrollableViewportSize(tbCategoria.getPreferredSize());
            }
            // Cierre de conexión.
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JButton btModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbSerie;
    private javax.swing.JTable tbCategoria;
    private javax.swing.JTextField tfCategoria;
    private javax.swing.JTextField tfIndex;
    private javax.swing.JTextField tfSerie;
    // End of variables declaration//GEN-END:variables
}
