package Vista;

import Modelo.Conexion;
import Modelo.RepFacturacion;
import Modelo.Reportes;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class jifReporte extends javax.swing.JInternalFrame {
    Conexion con = new Conexion();
    Reportes reporte = new Reportes();
    
    ResultSet rs;
    PreparedStatement ps;
    Usuario usr;
    
    private void Configuracionventana() {
        this.setSize(414,302);
        //this.setSize(460,302);
    }
    
    public jifReporte(Usuario usr) {
        initComponents();
        Configuracionventana();
        this.usr = usr;
        if ("Usuario".equals(usr.getRol())) {
            cbUsuario.setVisible(false);
            lbUsuario.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbFechadesde = new javax.swing.JLabel();
        lbEstatus = new javax.swing.JLabel();
        cbEstatus = new javax.swing.JComboBox<>();
        dcFechadesde = new com.toedter.calendar.JDateChooser();
        btCerrar = new javax.swing.JButton();
        btGenerar = new javax.swing.JButton();
        lbFechahasta = new javax.swing.JLabel();
        dcFechahasta = new com.toedter.calendar.JDateChooser();
        lbUsuario = new javax.swing.JLabel();
        cbUsuario = new javax.swing.JComboBox<>();
        lbReporte = new javax.swing.JLabel();
        cbReporte = new javax.swing.JComboBox<>();

        setTitle("Reporte de Facturación");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/reporte.png"))); // NOI18N

        lbFechadesde.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbFechadesde.setForeground(new java.awt.Color(118, 113, 113));
        lbFechadesde.setText("Desde*");

        lbEstatus.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbEstatus.setForeground(new java.awt.Color(118, 113, 113));
        lbEstatus.setText("Estatus");

        cbEstatus.setFont(new java.awt.Font("Browallia New", 0, 22)); // NOI18N
        cbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ACTIVO", "INACTIVO" }));

        dcFechadesde.setDateFormatString("yyyy-MM-dd");
        dcFechadesde.setFont(new java.awt.Font("Browallia New", 0, 22)); // NOI18N

        btCerrar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });

        btGenerar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btGenerar.setText("Generar");
        btGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerarActionPerformed(evt);
            }
        });

        lbFechahasta.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbFechahasta.setForeground(new java.awt.Color(118, 113, 113));
        lbFechahasta.setText("Hasta*");

        dcFechahasta.setDateFormatString("yyyy-MM-dd");
        dcFechahasta.setFont(new java.awt.Font("Browallia New", 0, 22)); // NOI18N

        lbUsuario.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(118, 113, 113));
        lbUsuario.setText("Usuario");

        cbUsuario.setFont(new java.awt.Font("Browallia New", 0, 22)); // NOI18N
        cbUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Por usuario" }));
        cbUsuario.setSelectedIndex(1);

        lbReporte.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbReporte.setForeground(new java.awt.Color(118, 113, 113));
        lbReporte.setText("Reporte");

        cbReporte.setFont(new java.awt.Font("Browallia New", 0, 22)); // NOI18N
        cbReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simple", "Detallado" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btGenerar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btCerrar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbUsuario)
                                .addComponent(lbEstatus, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbFechadesde, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dcFechadesde, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(33, 33, 33)
                                    .addComponent(lbFechahasta)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dcFechahasta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcFechadesde, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcFechahasta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFechahasta)
                    .addComponent(lbFechadesde))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstatus)
                    .addComponent(cbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUsuario)
                    .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbReporte)
                    .addComponent(cbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCerrar)
                    .addComponent(btGenerar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCerrarActionPerformed

    private void btGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGenerarActionPerformed
        
        RepFacturacion red;
        ArrayList coleccion = new ArrayList();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {

            // Conexión a la base de datos.
            Connection conn = con.getConnection();

            // Consulta a la base de datos.
            ps = conn.prepareCall("{ call jifReporte_BUSCAR_REPORTE (?,?,?,?) }");

            // Parametros de consulta.
            ps.setString(1, dateFormat.format(dcFechadesde.getDate())); // Envia la fecha desde.
            ps.setString(2, dateFormat.format(dcFechahasta.getDate())); // Envia la fecha hasta.
            ps.setString(3, cbEstatus.getSelectedItem().toString()); // Envia el estatus.
            if (cbUsuario.getSelectedIndex() == 1) {
                ps.setString(4, usr.getNick()); // Envia el usuario.
            } else {
                ps.setString(4, cbUsuario.getSelectedItem().toString()); // Envia el usuario.
            }

            rs = ps.executeQuery();

            if (cbUsuario.getSelectedIndex() == 1) {
                while (rs.next()) {
                    red = new RepFacturacion(usr.getNick(), dateFormat.format(dcFechadesde.getDate()), dateFormat.format(dcFechahasta.getDate()), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    coleccion.add(red);
                }
            } else {
                while (rs.next()) {
                    red = new RepFacturacion(cbUsuario.getSelectedItem().toString(), dateFormat.format(dcFechadesde.getDate()), dateFormat.format(dcFechahasta.getDate()), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                    coleccion.add(red);
                }
            }

            //Cierre de conexión a la base de datos.
            conn.close();
            
            reporte.Rep_facturacion(coleccion);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "BASE DE DATOS", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
       
    }//GEN-LAST:event_btGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCerrar;
    private javax.swing.JButton btGenerar;
    private javax.swing.JComboBox<String> cbEstatus;
    private javax.swing.JComboBox<String> cbReporte;
    private javax.swing.JComboBox<String> cbUsuario;
    private com.toedter.calendar.JDateChooser dcFechadesde;
    private com.toedter.calendar.JDateChooser dcFechahasta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbEstatus;
    private javax.swing.JLabel lbFechadesde;
    private javax.swing.JLabel lbFechahasta;
    private javax.swing.JLabel lbReporte;
    private javax.swing.JLabel lbUsuario;
    // End of variables declaration//GEN-END:variables
}
