package igu;

import Utilidad.Mensajes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.RegistroEntradaSalida;
import persistencia.Conexion;

public class formPrincipal extends javax.swing.JFrame {

    Conexion conexion;

    ArrayList<RegistroEntradaSalida> listaRegistros;

    public formPrincipal() {
        conexion = new Conexion();
        listaRegistros = new ArrayList();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEntrada = new javax.swing.JButton();
        btnSalida = new javax.swing.JButton();
        txtDocumento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnEntrada.setText("jButton1");
        btnEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaActionPerformed(evt);
            }
        });

        btnSalida.setText("jButton2");
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });

        txtDocumento.setText("jTextField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnEntrada)
                        .addGap(80, 80, 80)
                        .addComponent(btnSalida))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrada)
                    .addComponent(btnSalida))
                .addGap(215, 215, 215))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    public String insertarRegistroEntrada(String documento, java.sql.Date fecha, java.sql.Time horaEntrada) {
        String mensaje = "";
        try (Connection con = conexion.conectar()) {
            String callProcedure = "{CALL RegistrarEntradaEmpleado(?, ?, ?, ?)}";
            CallableStatement stmt = con.prepareCall(callProcedure);

            stmt.setString(1, documento);
            stmt.setDate(2, fecha);
            stmt.setTime(3, horaEntrada);
            stmt.registerOutParameter(4, Types.VARCHAR); // Parámetro de salida para el mensaje

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
    private javax.swing.JButton btnEntrada;
    private javax.swing.JButton btnSalida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDocumento;
    // End of variables declaration//GEN-END:variables
}
