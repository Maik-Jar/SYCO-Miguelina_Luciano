package Vista;

import Modelo.Reportes;
import Modelo.Usuario;
import Modelo.Validacion;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Image;
import java.awt.Graphics;


public final class VentanaPrincipal extends javax.swing.JFrame {
    
    Validacion valida = new Validacion();
    Usuario usr;

    public VentanaPrincipal() {
        initComponents();
    }
    
    public VentanaPrincipal(Usuario usr){
        this.usr = usr;
        this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        lbUsuario.setBounds(740, 540, 80, 30);
        lbUsuario.setText(usr.getNick());
        this.setIconImage(new ImageIcon(getClass().getResource("/RecursosGraficos/miniLOGO.jpg")).getImage());
        
        if (!"Administrador".equals(usr.getRol())) {
            jmConfiguracion.setVisible(false);
        }
        
        if ("Usuario".equals(usr.getRol())) {
            miMantenimientodecodigos.setVisible(false);
            miMantenimientocomprobantes.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon (getClass().getResource("/RecursosGraficos/Fondo3.jpg"));
        Image imagen = icon.getImage();
        jDPprincipal = new javax.swing.JDesktopPane() {

            public void paintComponent (Graphics g) {
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }

        };
        lbUsuario = new javax.swing.JLabel();
        MBprincipal = new javax.swing.JMenuBar();
        jmInicio = new javax.swing.JMenu();
        miCerrarsesion = new javax.swing.JMenuItem();
        miSalir = new javax.swing.JMenuItem();
        jmVentas = new javax.swing.JMenu();
        miFacturar = new javax.swing.JMenuItem();
        miCotizar = new javax.swing.JMenuItem();
        miReporte = new javax.swing.JMenuItem();
        miMantenimientodefacturas = new javax.swing.JMenuItem();
        miMantenimientocomprobantes = new javax.swing.JMenuItem();
        jmProductos = new javax.swing.JMenu();
        miMantenimientodeproductos = new javax.swing.JMenuItem();
        miMantenimientodecodigos = new javax.swing.JMenuItem();
        miListadeprecios = new javax.swing.JMenuItem();
        jmCartera = new javax.swing.JMenu();
        miMantenimientodeclientes = new javax.swing.JMenuItem();
        jmConfiguracion = new javax.swing.JMenu();
        miMantenimientodeusuarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Principal");
        setIconImage(getIconImage());

        jDPprincipal.setOpaque(false);

        lbUsuario.setBackground(new java.awt.Color(245, 245, 245));
        lbUsuario.setFont(new java.awt.Font("Roboto Medium", 0, 22)); // NOI18N
        lbUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(187, 187, 187)));
        lbUsuario.setOpaque(true);

        jDPprincipal.setLayer(lbUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDPprincipalLayout = new javax.swing.GroupLayout(jDPprincipal);
        jDPprincipal.setLayout(jDPprincipalLayout);
        jDPprincipalLayout.setHorizontalGroup(
            jDPprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDPprincipalLayout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDPprincipalLayout.setVerticalGroup(
            jDPprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDPprincipalLayout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jDPprincipal, java.awt.BorderLayout.CENTER);

        MBprincipal.setBackground(new java.awt.Color(255, 255, 255));
        MBprincipal.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N

        jmInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/inicio.png"))); // NOI18N
        jmInicio.setText("Inicio");
        jmInicio.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jmInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        miCerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/cerrar.png"))); // NOI18N
        miCerrarsesion.setText("Cerrar Sesión");
        miCerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCerrarsesionActionPerformed(evt);
            }
        });
        jmInicio.add(miCerrarsesion);

        miSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/salida.png"))); // NOI18N
        miSalir.setText("Salir del Sistema");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        jmInicio.add(miSalir);

        MBprincipal.add(jmInicio);

        jmVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/ventas.png"))); // NOI18N
        jmVentas.setText("Ventas");
        jmVentas.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jmVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        miFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/facturar.png"))); // NOI18N
        miFacturar.setText("Facturar");
        miFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFacturarActionPerformed(evt);
            }
        });
        jmVentas.add(miFacturar);

        miCotizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/cotizacion.png"))); // NOI18N
        miCotizar.setText("Cotizar");
        miCotizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCotizarActionPerformed(evt);
            }
        });
        jmVentas.add(miCotizar);

        miReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/reporte.png"))); // NOI18N
        miReporte.setText("Reporte");
        miReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miReporteActionPerformed(evt);
            }
        });
        jmVentas.add(miReporte);

        miMantenimientodefacturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/mantenimientofactura.png"))); // NOI18N
        miMantenimientodefacturas.setText("Mantenimiento de Factura");
        miMantenimientodefacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMantenimientodefacturasActionPerformed(evt);
            }
        });
        jmVentas.add(miMantenimientodefacturas);

        miMantenimientocomprobantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/comprobante.png"))); // NOI18N
        miMantenimientocomprobantes.setText("Mantenimiento de Comprobante");
        miMantenimientocomprobantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMantenimientocomprobantesActionPerformed(evt);
            }
        });
        jmVentas.add(miMantenimientocomprobantes);

        MBprincipal.add(jmVentas);

        jmProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/productos.png"))); // NOI18N
        jmProductos.setText("Productos");
        jmProductos.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jmProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        miMantenimientodeproductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/mantenimientoproductos.png"))); // NOI18N
        miMantenimientodeproductos.setText("Mantenimiento de Producto");
        miMantenimientodeproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMantenimientodeproductosActionPerformed(evt);
            }
        });
        jmProductos.add(miMantenimientodeproductos);

        miMantenimientodecodigos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/categoria.png"))); // NOI18N
        miMantenimientodecodigos.setText("Mantenimiento de Código");
        miMantenimientodecodigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMantenimientodecodigosActionPerformed(evt);
            }
        });
        jmProductos.add(miMantenimientodecodigos);

        miListadeprecios.setText("Lista de precios");
        miListadeprecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miListadepreciosActionPerformed(evt);
            }
        });
        jmProductos.add(miListadeprecios);

        MBprincipal.add(jmProductos);

        jmCartera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/cartera.png"))); // NOI18N
        jmCartera.setText("Cartera");
        jmCartera.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jmCartera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        miMantenimientodeclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/clientes.png"))); // NOI18N
        miMantenimientodeclientes.setText("Mantenimiento de Cliente");
        miMantenimientodeclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMantenimientodeclientesActionPerformed(evt);
            }
        });
        jmCartera.add(miMantenimientodeclientes);

        MBprincipal.add(jmCartera);

        jmConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/Configuracion.png"))); // NOI18N
        jmConfiguracion.setText("Configuración");
        jmConfiguracion.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jmConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        miMantenimientodeusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RecursosGraficos/usuario.png"))); // NOI18N
        miMantenimientodeusuarios.setText("Mantenimiento de Usuario");
        miMantenimientodeusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMantenimientodeusuariosActionPerformed(evt);
            }
        });
        jmConfiguracion.add(miMantenimientodeusuarios);

        MBprincipal.add(jmConfiguracion);

        setJMenuBar(MBprincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFacturarActionPerformed
        // Instanciamiento de la clase jifFactura:
        jifFacturar jiffacturar = new jifFacturar(usr);
        
        if (valida.JInternalFrames_Abiertos(jiffacturar) == false) {
            jDPprincipal.add(jiffacturar);
            //Codigo para central VentanaInterna (JInternalFrame) en el PanelInterno (JDesktopPane).
            Dimension desktopSize = jDPprincipal.getSize();
            Dimension FrameSize = jiffacturar.getSize();
            jiffacturar.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            jiffacturar.setVisible(true);
        }
    }//GEN-LAST:event_miFacturarActionPerformed

    private void miMantenimientodefacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMantenimientodefacturasActionPerformed
        // Instanciamiento de la clase jifMantenimientodefactura:
        jifMantenimientodefacturas jifmantenimientodefacturas = new jifMantenimientodefacturas(usr);
        
        if (valida.JInternalFrames_Abiertos(jifmantenimientodefacturas) == false) {
            jDPprincipal.add(jifmantenimientodefacturas);
            //Codigo para central VentanaInterna (JInternalFrame) en el PanelInterno (JDesktopPane).
            Dimension desktopSize = jDPprincipal.getSize();
            Dimension FrameSize = jifmantenimientodefacturas.getSize();
            jifmantenimientodefacturas.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            jifmantenimientodefacturas.setVisible(true);
        }
    }//GEN-LAST:event_miMantenimientodefacturasActionPerformed

    private void miCotizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCotizarActionPerformed
        // Instanciamiento de la clase jifFacturar:
        jifFacturar jifcotizador = new jifFacturar(usr);
        
        if (valida.JInternalFrames_Abiertos(jifcotizador) == false) {
            jDPprincipal.add(jifcotizador);
            //Codigo para central VentanaInterna (JInternalFrame) en el PanelInterno (JDesktopPane).
            Dimension desktopSize = jDPprincipal.getSize();
            Dimension FrameSize = jifcotizador.getSize();
            jifcotizador.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            jifcotizador.setVisible(true);
            // Activación y desactivación de objetos en el formulario.
            jifcotizador.btFacturar.setVisible(false);
            jifcotizador.btGenerar.setVisible(true);
            jifcotizador.btLimpiar.setVisible(true);
            jifcotizador.lbNofactura.setVisible(false);
            jifcotizador.tfNofactura.setVisible(false);
            jifcotizador.lbVenta.setVisible(false);
            jifcotizador.cbVenta.setVisible(false);
            jifcotizador.lbModopago.setVisible(false);
            jifcotizador.cbModopago.setVisible(false);
            jifcotizador.lbPagado.setVisible(false);
            jifcotizador.tfPagado.setVisible(false);
            jifcotizador.chbPreventa.setVisible(false);
            jifcotizador.chbPreventa.doClick();
            jifcotizador.cbComprobante.setVisible(false);
            jifcotizador.lbTipocomprobante.setVisible(false);
            jifcotizador.lbNCF.setVisible(false);
            jifcotizador.tfNCF.setVisible(false);
            jifcotizador.lbTipodefactura.setText("Cotización");
            jifcotizador.tfCliente.setEditable(true);
            if (!"Cotizador".equals(jifcotizador.getTitle())) {
                jifcotizador.setTitle("Cotizador");
            }
            jifcotizador.setFrameIcon(new ImageIcon(getClass().getResource("/RecursosGraficos/cotizacion.png")));
        }
    }//GEN-LAST:event_miCotizarActionPerformed

    private void miReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miReporteActionPerformed
        // Instanciamiento de la clase jifReporte:
        jifReporte jifreporte = new jifReporte(usr);
        
        if (valida.JInternalFrames_Abiertos(jifreporte) == false) {
            jDPprincipal.add(jifreporte);
            //Codigo para central VentanaInterna (JInternalFrame) en el PanelInterno (JDesktopPane).
            Dimension desktopSize = jDPprincipal.getSize();
            Dimension FrameSize = jifreporte.getSize();
            jifreporte.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            jifreporte.setVisible(true);
        }
    }//GEN-LAST:event_miReporteActionPerformed

    private void miMantenimientodeproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMantenimientodeproductosActionPerformed
        // Instanciamiento de la clase jifMantenimientodeproductos:
        jifMantenimientodeproductos jifmantenimientodeservicios = new jifMantenimientodeproductos(usr);
        
        if (valida.JInternalFrames_Abiertos(jifmantenimientodeservicios) == false) {
            jDPprincipal.add(jifmantenimientodeservicios);
            //Codigo para central VentanaInterna (JInternalFrame) en el PanelInterno (JDesktopPane).
            Dimension desktopSize = jDPprincipal.getSize();
            Dimension FrameSize = jifmantenimientodeservicios.getSize();
            jifmantenimientodeservicios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            jifmantenimientodeservicios.setVisible(true);
        }
    }//GEN-LAST:event_miMantenimientodeproductosActionPerformed

    private void miMantenimientodeusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMantenimientodeusuariosActionPerformed
        // Instanciamiento de la clase jifMantenimientodeusuarios:
        jifMantenimientodeusuarios jifmantenimientodeusuarios = new jifMantenimientodeusuarios();

        if (valida.JInternalFrames_Abiertos(jifmantenimientodeusuarios) == false) {
            jDPprincipal.add(jifmantenimientodeusuarios);
            //Codigo para central VentanaInterna (JInternalFrame) en el PanelInterno (JDesktopPane).
            Dimension desktopSize = jDPprincipal.getSize();
            Dimension FrameSize = jifmantenimientodeusuarios.getSize();
            jifmantenimientodeusuarios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            jifmantenimientodeusuarios.setVisible(true);
        }
    }//GEN-LAST:event_miMantenimientodeusuariosActionPerformed

    private void miCerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCerrarsesionActionPerformed
        Login lg = new Login();
        this.dispose();
        lg.setVisible(true);
    }//GEN-LAST:event_miCerrarsesionActionPerformed

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSalirActionPerformed

    private void miMantenimientodecodigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMantenimientodecodigosActionPerformed
        // Instanciamiento de la clase jifMantenimientodecodigos:
        jifMantenimientodecodigos jifmantenimientodecodigos = new jifMantenimientodecodigos(usr);

        if (valida.JInternalFrames_Abiertos(jifmantenimientodecodigos) == false) {
            jDPprincipal.add(jifmantenimientodecodigos);
            //Codigo para central VentanaInterna (JInternalFrame) en el PanelInterno (JDesktopPane).
            Dimension desktopSize = jDPprincipal.getSize();
            Dimension FrameSize = jifmantenimientodecodigos.getSize();
            jifmantenimientodecodigos.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            jifmantenimientodecodigos.setVisible(true);
        }
    }//GEN-LAST:event_miMantenimientodecodigosActionPerformed

    private void miMantenimientocomprobantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMantenimientocomprobantesActionPerformed
        // Instanciamiento de la clase jifMantenimientodecomprobvantes:
        jifMantenimientodecomprobantes jifmantenimientodecomprobantes = new jifMantenimientodecomprobantes();

        if (valida.JInternalFrames_Abiertos(jifmantenimientodecomprobantes) == false) {
            jDPprincipal.add(jifmantenimientodecomprobantes);
            //Codigo para central VentanaInterna (JInternalFrame) en el PanelInterno (JDesktopPane).
            Dimension desktopSize = jDPprincipal.getSize();
            Dimension FrameSize = jifmantenimientodecomprobantes.getSize();
            jifmantenimientodecomprobantes.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            jifmantenimientodecomprobantes.setVisible(true);
        }
    }//GEN-LAST:event_miMantenimientocomprobantesActionPerformed

    private void miMantenimientodeclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMantenimientodeclientesActionPerformed
        // Instanciamiento de la clase jifMantenimientodeclientes:
        jifMantenimientodeclientes jifmantenimientodeclientes = new jifMantenimientodeclientes(usr);

        if (valida.JInternalFrames_Abiertos(jifmantenimientodeclientes) == false) {
            jDPprincipal.add(jifmantenimientodeclientes);
            //Codigo para central VentanaInterna (JInternalFrame) en el PanelInterno (JDesktopPane).
            Dimension desktopSize = jDPprincipal.getSize();
            Dimension FrameSize = jifmantenimientodeclientes.getSize();
            jifmantenimientodeclientes.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            jifmantenimientodeclientes.setVisible(true);
        }
    }//GEN-LAST:event_miMantenimientodeclientesActionPerformed

    private void miListadepreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miListadepreciosActionPerformed
        Reportes reporte = new Reportes();
        
        reporte.Listadodeprecios();
    }//GEN-LAST:event_miListadepreciosActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MBprincipal;
    public static javax.swing.JDesktopPane jDPprincipal;
    private javax.swing.JMenu jmCartera;
    private javax.swing.JMenu jmConfiguracion;
    private javax.swing.JMenu jmInicio;
    private javax.swing.JMenu jmProductos;
    private javax.swing.JMenu jmVentas;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JMenuItem miCerrarsesion;
    private javax.swing.JMenuItem miCotizar;
    private javax.swing.JMenuItem miFacturar;
    private javax.swing.JMenuItem miListadeprecios;
    private javax.swing.JMenuItem miMantenimientocomprobantes;
    private javax.swing.JMenuItem miMantenimientodeclientes;
    private javax.swing.JMenuItem miMantenimientodecodigos;
    private javax.swing.JMenuItem miMantenimientodefacturas;
    private javax.swing.JMenuItem miMantenimientodeproductos;
    private javax.swing.JMenuItem miMantenimientodeusuarios;
    private javax.swing.JMenuItem miReporte;
    private javax.swing.JMenuItem miSalir;
    // End of variables declaration//GEN-END:variables
}