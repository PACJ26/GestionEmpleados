package igu;

import Utilidad.Iconos;
import Utilidad.Mensajes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import logica.RegistroEntradaSalida;
import persistencia.Conexion;

public class formPrincipal extends javax.swing.JFrame {

    Conexion conexion;

    ArrayList<RegistroEntradaSalida> listaRegistros;

    public formPrincipal() {
        initComponents();
        conexion = new Conexion();
        listaRegistros = new ArrayList();
        this.setTitle("Gestion Empleados");
        this.setLocationRelativeTo(null);

        Iconos.setJFrameIcon(this, "iniciosesion.png");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Panel_Izquierda = new javax.swing.JPanel();
        Panel_Derecha = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        btnEntrada = new javax.swing.JButton();
        btnSalida = new javax.swing.JButton();
        BtIniciarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        Panel_Izquierda.setBackground(new java.awt.Color(0, 102, 102));
        Panel_Izquierda.setPreferredSize(new java.awt.Dimension(400, 500));

        javax.swing.GroupLayout Panel_IzquierdaLayout = new javax.swing.GroupLayout(Panel_Izquierda);
        Panel_Izquierda.setLayout(Panel_IzquierdaLayout);
        Panel_IzquierdaLayout.setHorizontalGroup(
            Panel_IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        Panel_IzquierdaLayout.setVerticalGroup(
            Panel_IzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jPanel1.add(Panel_Izquierda);
        Panel_Izquierda.setBounds(0, 0, 360, 480);

        Panel_Derecha.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("INGRESO LABORAL");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Digite el Documento de Identidad:");

        btnEntrada.setBackground(new java.awt.Color(0, 102, 26));
        btnEntrada.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrada.setText("Empezar Hora Laboral");
        btnEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaActionPerformed(evt);
            }
        });

        btnSalida.setBackground(new java.awt.Color(102, 0, 0));
        btnSalida.setForeground(new java.awt.Color(255, 255, 255));
        btnSalida.setText("Terminar Hora Laboral");
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_DerechaLayout = new javax.swing.GroupLayout(Panel_Derecha);
        Panel_Derecha.setLayout(Panel_DerechaLayout);
        Panel_DerechaLayout.setHorizontalGroup(
            Panel_DerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DerechaLayout.createSequentialGroup()
                .addGroup(Panel_DerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_DerechaLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(Panel_DerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_DerechaLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(Panel_DerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2)))
                    .addGroup(Panel_DerechaLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(Panel_DerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        Panel_DerechaLayout.setVerticalGroup(
            Panel_DerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DerechaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel1.add(Panel_Derecha);
        Panel_Derecha.setBounds(360, 0, 390, 380);

        BtIniciarSesion.setBackground(new java.awt.Color(204, 204, 204));
        BtIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS/Logo_Login.png"))); // NOI18N
        BtIniciarSesion.setText("LOGIN");
        BtIniciarSesion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        BtIniciarSesion.setBorderPainted(false);
        BtIniciarSesion.setContentAreaFilled(false);
        BtIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtIniciarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtIniciarSesion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        BtIniciarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(BtIniciarSesion);
        BtIniciarSesion.setBounds(650, 415, 70, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaActionPerformed
        String documento = txtDocumento.getText();

        // Validar el documento antes de registrar la entrada
        if (documento != null && !documento.isEmpty()) {
            // Obtener la fecha y hora actual
            java.util.Date fechaActual = new java.util.Date();
            java.sql.Date fecha = new java.sql.Date(fechaActual.getTime());
            java.sql.Time horaEntrada = new java.sql.Time(fechaActual.getTime());

            String mensaje = insertarRegistroEntrada(documento, fecha, horaEntrada);

            if (mensaje.equals("Registro de entrada ingresado exitosamente.")) {
                Mensajes.mostrarExito(mensaje);
            } else {

                Mensajes.mostrarError(mensaje);
            }
        } else {
            Mensajes.mostrarAdvertencia("Hay Campos vacios");
        }
    }//GEN-LAST:event_btnEntradaActionPerformed

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed
        String documento = txtDocumento.getText();

        // Validar el documento antes de registrar la entrada
        if (documento != null && !documento.isEmpty()) {
            // Obtener la fecha y hora actual
            java.util.Date fechaActual = new java.util.Date();
            java.sql.Date fecha = new java.sql.Date(fechaActual.getTime());
            java.sql.Time horaSalida = new java.sql.Time(fechaActual.getTime());

            String mensaje = insertarRegistroSalida(documento, fecha, horaSalida);

            if (mensaje.equals("Registro de salida actualizado exitosamente.")) {
                Mensajes.mostrarExito(mensaje);
            } else {

                Mensajes.mostrarError(mensaje);
            }
        } else {
            Mensajes.mostrarAdvertencia("Hay Campos vacios");
        }
    }//GEN-LAST:event_btnSalidaActionPerformed

    private void BtIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIniciarSesionActionPerformed
        formLogin login = new formLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtIniciarSesionActionPerformed

    public String insertarRegistroEntrada(String documento, java.sql.Date fecha, java.sql.Time horaEntrada) {
        String mensaje = "";
        try (Connection con = conexion.conectar()) {
            String callProcedure = "{CALL RegistrarEntradaEmpleado(?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(callProcedure);

            stmt.setString(1, documento);
            stmt.setDate(2, fecha);
            stmt.setTime(3, horaEntrada);
            stmt.registerOutParameter(4, Types.VARCHAR);

            stmt.execute();
            mensaje = stmt.getString(4);

            conexion.desconectar();
        } catch (SQLException e) {
            mensaje = "Error al insertar el registro de entrada: " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    public String insertarRegistroSalida(String documento, java.sql.Date fecha, java.sql.Time horaSalida) {
        String mensaje = "";
        try (Connection con = conexion.conectar()) {
            String callProcedure = "{CALL RegistrarSalidaEmpleado(?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(callProcedure);

            stmt.setString(1, documento);
            stmt.setDate(2, fecha);
            stmt.setTime(3, horaSalida);
            stmt.registerOutParameter(4, Types.VARCHAR); // Parámetro de salida para el mensaje

            stmt.execute();
            mensaje = stmt.getString(4);

            conexion.desconectar();
        } catch (SQLException e) {
            mensaje = "Error al insertar el registro de salida: " + e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtIniciarSesion;
    private javax.swing.JPanel Panel_Derecha;
    private javax.swing.JPanel Panel_Izquierda;
    private javax.swing.JButton btnEntrada;
    private javax.swing.JButton btnSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDocumento;
    // End of variables declaration//GEN-END:variables
}
