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
        this.setSize(390,500);
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
        java.awt.GridBagConstraints gridBagConstraints;

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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbFechadesde.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbFechadesde.setForeground(new java.awt.Color(118, 113, 113));
        lbFechadesde.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFechadesde.setText("Desde*");
        jPanel1.add(lbFechadesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 40));

        lbEstatus.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbEstatus.setForeground(new java.awt.Color(118, 113, 113));
        lbEstatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEstatus.setText("Estatus");
        jPanel1.add(lbEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 100, 40));

        cbEstatus.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        cbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ACTIVO", "INACTIVO" }));
        jPanel1.add(cbEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 200, 40));

        dcFechadesde.setDateFormatString("dd-MM-yyyy");
        dcFechadesde.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jPanel1.add(dcFechadesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 200, 40));

        btCerrar.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btCerrar.setText("Cerrar");
        btCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 150, 40));

        btGenerar.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        btGenerar.setText("Generar");
        btGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGenerarActionPerformed(evt);
            }
        });
        jPanel1.add(btGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 150, 40));

        lbFechahasta.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbFechahasta.setForeground(new java.awt.Color(118, 113, 113));
        lbFechahasta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFechahasta.setText("Hasta*");
        jPanel1.add(lbFechahasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, 40));

        dcFechahasta.setDateFormatString("dd-MM-yyyy");
        dcFechahasta.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        jPanel1.add(dcFechahasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 200, 40));

        lbUsuario.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(118, 113, 113));
        lbUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUsuario.setText("Usuario");
        jPanel1.add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 100, 40));

        cbUsuario.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        cbUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Por usuario" }));
        cbUsuario.setSelectedIndex(1);
        jPanel1.add(cbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 200, 40));

        lbReporte.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbReporte.setForeground(new java.awt.Color(118, 113, 113));
        lbReporte.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbReporte.setText("Reporte");
        jPanel1.add(lbReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 100, 40));

        cbReporte.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        cbReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simple", "Detallado" }));
        jPanel1.add(cbReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
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
        
        if(dcFechadesde.getDate() != null && dcFechahasta.getDate() != null){
        
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
        } else {
            JOptionPane.showMessageDialog(null, "Por favor complete el rango de fechas.", "Rango de fechas incompleto", JOptionPane.ERROR_MESSAGE);
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
