package Vista;

import Modelo.Conexion;
import Modelo.MiRenderer;
import Modelo.Usuario;
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

public class jifMantenimientodecomprobantes extends javax.swing.JInternalFrame {

    TableColumnModel tcmtbComprobantes;
    DefaultTableModel dtmtbComprobantes;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usr;

    Conexion con = new Conexion();
    
    private void Configuraciontabla() {
        //Asignación de tamaño a las celdas de cada columna.
        tcmtbComprobantes = tbComprobantes.getColumnModel();
        tcmtbComprobantes.getColumn(0).setPreferredWidth(33);
        tcmtbComprobantes.getColumn(1).setPreferredWidth(240);
        tcmtbComprobantes.getColumn(2).setPreferredWidth(50);
        tcmtbComprobantes.getColumn(3).setPreferredWidth(40);
        tcmtbComprobantes.getColumn(4).setPreferredWidth(90);
        tcmtbComprobantes.getColumn(5).setPreferredWidth(90);
        //Asignación de cantidad de filas.
        dtmtbComprobantes = (DefaultTableModel) tbComprobantes.getModel();
        dtmtbComprobantes.setRowCount(0);
        //Asignación de color al Background, color al texto y estilo de fuente del encabezado de columna.
        Color bgTitulocolumn = new Color(31, 78, 121);
        Color fgTitulocolumn = new Color(255, 255, 255);
        tbComprobantes.getColumnModel().getColumn(0).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbComprobantes.getColumnModel().getColumn(1).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbComprobantes.getColumnModel().getColumn(2).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbComprobantes.getColumnModel().getColumn(3).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbComprobantes.getColumnModel().getColumn(4).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        tbComprobantes.getColumnModel().getColumn(5).setHeaderRenderer(new MiRenderer(bgTitulocolumn, fgTitulocolumn));
        //Alineación de contenido de columnas.
        DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tbComprobantes.getColumnModel().getColumn(0).setCellRenderer(alinear);
        tbComprobantes.getColumnModel().getColumn(2).setCellRenderer(alinear);
        tbComprobantes.getColumnModel().getColumn(3).setCellRenderer(alinear);
        tbComprobantes.getColumnModel().getColumn(4).setCellRenderer(alinear);
        tbComprobantes.getColumnModel().getColumn(5).setCellRenderer(alinear);
    }
    
    private void ConfiguracionVentana() {
        this.setSize(800, 385);
    }
    
    public jifMantenimientodecomprobantes() {
        initComponents();
        ConfiguracionVentana();
        Configuraciontabla();
        Buscar_comprobantes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbComprobantes = new javax.swing.JTable();
        btGuardar = new javax.swing.JButton();
        btCerrar = new javax.swing.JButton();

        setTitle("Mantenimiento de Comprobantes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/comprobante.png"))); // NOI18N

        tbComprobantes.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbComprobantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "Tipo Comprobante", "Serie", "Desde", "Hasta", "Vigencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbComprobantes.setRowHeight(25);
        jScrollPane1.setViewportView(tbComprobantes);

        btGuardar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        btCerrar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCerrar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar)
                    .addComponent(btCerrar))
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        
        int eleccion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea modificar los datos de este(os) comprobante(s) ?", "PRECAUCIÒN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (eleccion == 0) {
            try {

                // Conexion a la base de datos.
                Connection conn = con.getConnection();
                for (int i = 0; i < dtmtbComprobantes.getRowCount(); i++) {
                    // Consulta a la base de datos.
                    ps = conn.prepareCall("{ call jifMantenimientodecomprobantes_ACTUALIZAR_COMPROBANTE (?,?,?,?) }");
                    ps.setInt(1, Integer.parseInt(dtmtbComprobantes.getValueAt(i, 0).toString()));
                    ps.setInt(2, Integer.parseInt(dtmtbComprobantes.getValueAt(i, 3).toString()));
                    ps.setInt(3, Integer.parseInt(dtmtbComprobantes.getValueAt(i, 4).toString()));
                    ps.setString(4, dtmtbComprobantes.getValueAt(i, 5).toString());
                    rs = ps.executeQuery();
                }

                conn.close();

                JOptionPane.showMessageDialog(null, "Todos los cambios se han guardado con éxito.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void Buscar_comprobantes() {

        Object[] registro = new Object[6];
        
        try {

            // Conexion a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifMantenimientodecomprobantes_BUSCAR_COMPROBANTE () }");

            rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getInt(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getInt(4);
                registro[4] = rs.getInt(5);
                registro[5] = rs.getString(6);
                dtmtbComprobantes.addRow(registro);
            }
            
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCerrar;
    protected javax.swing.JButton btGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbComprobantes;
    // End of variables declaration//GEN-END:variables
}
