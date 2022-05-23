package Vista;

import Modelo.Hash;
import Modelo.HashMD5;
import Modelo.Usuario;
import Modelo.Validacion;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    Validacion valida = new Validacion();
    
    private void ConfiguracionVentana() {
        this.setSize(365, 355);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/miniLOGO.jpg")).getImage());
    }
    
    public Login() {
        initComponents();
        ConfiguracionVentana();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbSAC = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        lbContrasena = new javax.swing.JLabel();
        pfContrasena = new javax.swing.JPasswordField();
        btIngresar = new javax.swing.JButton();
        lbIcono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(204, 204, 204));
        setIconImage(getIconImage());

        lbSAC.setBackground(new java.awt.Color(204, 204, 204));
        lbSAC.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 72)); // NOI18N
        lbSAC.setForeground(new java.awt.Color(31, 78, 121));
        lbSAC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSAC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/LogoSYCO.jpg"))); // NOI18N
        lbSAC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbUsuario.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(118, 113, 113));
        lbUsuario.setText("Usuario:");

        tfUsuario.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfUsuarioKeyPressed(evt);
            }
        });

        lbContrasena.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        lbContrasena.setForeground(new java.awt.Color(118, 113, 113));
        lbContrasena.setText("Contraseña:");

        pfContrasena.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        pfContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfContrasenaKeyPressed(evt);
            }
        });

        btIngresar.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 18)); // NOI18N
        btIngresar.setText("Ingresar");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });

        lbIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/logousuario.png"))); // NOI18N
        lbIcono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbIcono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbIcono.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(lbSAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(lbIcono)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lbContrasena))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btIngresar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbSAC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbUsuario)
                        .addGap(5, 5, 5)
                        .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(lbContrasena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pfContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(btIngresar))
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

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        Usuario usr = new Usuario();

        if (tfUsuario.getText().trim().isEmpty() || pfContrasena.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos.", "INFORMACIÓN", JOptionPane.WARNING_MESSAGE);
        } else {

            String pass = new String(pfContrasena.getPassword());

            usr.setNick(tfUsuario.getText());
            usr.setContrasena(pass);

            if (valida.Validacion_de_ususario(usr)) {
                VentanaPrincipal vp = new VentanaPrincipal(usr);
                vp.setVisible(true);
                this.dispose();
            } else{
                JOptionPane.showMessageDialog(null, "La contraseña o el usuario son incorrecto.", "INFORMACIÓN", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btIngresarActionPerformed

    private void pfContrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfContrasenaKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            btIngresar.requestFocus();
        }
    }//GEN-LAST:event_pfContrasenaKeyPressed

    private void tfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUsuarioKeyPressed
        if (KeyEvent.VK_ENTER == evt.getKeyCode()) {
            pfContrasena.requestFocus();
        }
    }//GEN-LAST:event_tfUsuarioKeyPressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold> 

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbContrasena;
    private javax.swing.JLabel lbIcono;
    private javax.swing.JLabel lbSAC;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPasswordField pfContrasena;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
