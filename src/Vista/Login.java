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
        this.setSize(505, 490);
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(204, 204, 204));
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSAC.setBackground(new java.awt.Color(204, 204, 204));
        lbSAC.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 72)); // NOI18N
        lbSAC.setForeground(new java.awt.Color(31, 78, 121));
        lbSAC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSAC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/LogoSYCO.jpg"))); // NOI18N
        lbSAC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbSAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 180, 100));

        lbUsuario.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(118, 113, 113));
        lbUsuario.setText("Usuario:");
        jPanel1.add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 150, 40));

        tfUsuario.setBackground(new java.awt.Color(214, 214, 214));
        tfUsuario.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        tfUsuario.setBorder(null);
        tfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfUsuarioKeyPressed(evt);
            }
        });
        jPanel1.add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 200, 40));

        lbContrasena.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbContrasena.setForeground(new java.awt.Color(118, 113, 113));
        lbContrasena.setText("Contraseña:");
        jPanel1.add(lbContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 150, 40));

        pfContrasena.setBackground(new java.awt.Color(214, 214, 214));
        pfContrasena.setFont(new java.awt.Font("Roboto Light", 0, 22)); // NOI18N
        pfContrasena.setBorder(null);
        pfContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfContrasenaKeyPressed(evt);
            }
        });
        jPanel1.add(pfContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 200, 40));

        btIngresar.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        btIngresar.setForeground(new java.awt.Color(118, 113, 113));
        btIngresar.setText("Ingresar");
        btIngresar.setBorder(null);
        btIngresar.setBorderPainted(false);
        btIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 150, 40));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(118, 113, 113));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 30, 250, 50));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 5, 250));

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 200, 3));

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 200, 3));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbContrasena;
    private javax.swing.JLabel lbSAC;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPasswordField pfContrasena;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
