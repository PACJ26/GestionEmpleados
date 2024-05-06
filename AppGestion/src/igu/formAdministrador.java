package igu;

import Utilidad.Mensajes;
import Utilidad.ajustesTablas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import logica.Empleado;
import persistencia.Conexion;

/**
 *
 * @author Juan
 */
public class formAdministrador extends javax.swing.JFrame {

    Conexion conexion;
    ArrayList<Empleado> listaEmpleados;
    LocalDate fechaActual = LocalDate.now();
    LocalDate fechaHace18Anios = fechaActual.minusYears(18);
    Date fechaHace18AniosDate = Date.from(fechaHace18Anios.atStartOfDay(ZoneId.systemDefault()).toInstant());
    String Clave;

    public formAdministrador() {
        listaEmpleados = new ArrayList();
        conexion = new Conexion();
        this.setTitle("Registro de Empleado");
        this.setLocationRelativeTo(null);
        initComponents();
        dateFechanacimiento.setMaxSelectableDate(fechaHace18AniosDate);
        llenarComboDocumento();
        llenarComboGenero();
        llenarComboCargo();
        ValidarCamposVacios();
        validarDocumentoUnico();
        mostrarInfo();
        limpiarCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTab = new javax.swing.JTabbedPane();
        PanelRegistro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboDocumento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDirreccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboGenero = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        dateFechanacimiento = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        dateContratacion = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        comboCargo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistro = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Asistencia = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtDempleado = new javax.swing.JTextField();
        dateInicio = new com.toedter.calendar.JDateChooser();
        dateFin = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        PanelRegistro.setBackground(new java.awt.Color(255, 255, 255));
        PanelRegistro.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombres");

        txtNombres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombres.setText("jTextField1");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellidos");

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtApellidos.setText("jTextField1");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Documento");

        txtDocumento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDocumento.setText("jTextField1");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tipo de Documento");

        comboDocumento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Numero de Telefono");

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelefono.setText("jTextField1");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Dirección");

        txtDirreccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDirreccion.setText("jTextField1");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Correo Electronico");

        txtCorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCorreo.setText("jTextField1");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Genero");

        comboGenero.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Fecha de Nacimiento");

        dateFechanacimiento.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Fecha de Contratación");

        dateContratacion.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Cargo");

        comboCargo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Salario");

        txtSalario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSalario.setText("jTextField1");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Contraseña");

        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setText("jPasswordField1");

        javax.swing.GroupLayout PanelRegistroLayout = new javax.swing.GroupLayout(PanelRegistro);
        PanelRegistro.setLayout(PanelRegistroLayout);
        PanelRegistroLayout.setHorizontalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelRegistroLayout.createSequentialGroup()
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelRegistroLayout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelRegistroLayout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDirreccion, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelRegistroLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(56, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelRegistroLayout.createSequentialGroup()
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateFechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel11))
                            .addComponent(dateContratacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(180, 180, 180))))
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelRegistroLayout.setVerticalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(comboDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtDirreccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateFechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        JTab.addTab("Registrar", PanelRegistro);

        tablaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaRegistro);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        JTab.addTab("Registro de Empleado", jPanel2);

        Asistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(Asistencia);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(txtDempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(txtDempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        JTab.addTab("Registro Entrada y Salida", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTab)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTab)
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

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if (ValidarCamposVacios()) {
            guardarRegistro();
            limpiarCampos();
        } else {
            Mensajes.mostrarAdvertencia("Hay Campos vacios");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:

        Date fechaInicio = dateInicio.getDate();
        Date fechaFin = dateFin.getDate();

        if (fechaInicio == null || fechaFin == null) {
           Mensajes.mostrarAdvertencia("Por favor, seleccione una fecha de inicio y una fecha de fin válidas.");
            return;
        }

        if (fechaInicio.after(fechaFin)) {
            Mensajes.mostrarAdvertencia( "La fecha de inicio no puede ser posterior a la fecha de fin.");
            return;
        }

        java.sql.Date sqlFechaInicio = new java.sql.Date(fechaInicio.getTime());
        java.sql.Date sqlFechaFin = new java.sql.Date(fechaFin.getTime());

        String documentoEmpleado = txtDempleado.getText().trim();

        try (Connection con = conexion.conectar()) {
            DefaultTableModel model = new DefaultTableModel();
            CallableStatement stmt = con.prepareCall("{CALL ReporteEntradaSalida(?, ?, ?)}");
            stmt.setDate(1, sqlFechaInicio);
            stmt.setDate(2, sqlFechaFin);

            // Pasar null si el campo del documento del empleado está vacío
            if (documentoEmpleado.isEmpty()) {
                stmt.setNull(3, Types.VARCHAR);
            } else {
                stmt.setString(3, documentoEmpleado);
            }

            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                model.addColumn(metaData.getColumnLabel(i));
            }

            while (resultSet.next()) {
                Object[] filas = new Object[metaData.getColumnCount()];
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    filas[i] = resultSet.getObject(i + 1);
                }
                model.addRow(filas);
            }
            Asistencia.setModel(model);
           
        } catch (SQLException e) {
            Mensajes.mostrarError("Error al obtener los datos de entrada y salida");
            e.printStackTrace();
        } finally {
            conexion.desconectar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    public void llenarComboDocumento() {
        try (Connection con = conexion.conectar()) {
            comboDocumento.removeAllItems();
            comboDocumento.addItem("Seleccione...");
            listaEmpleados.clear();
            String callProcedure = "{CALL MostrarTiposDocumentos()}";
            CallableStatement stmt = con.prepareCall(callProcedure);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String tipoDocumento = rs.getString("tipoDocumento");
                System.out.println("Tipo de documento: " + tipoDocumento);
                comboDocumento.addItem(tipoDocumento);
            }
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void llenarComboGenero() {
        try (Connection con = conexion.conectar()) {
            comboGenero.removeAllItems();
            comboGenero.addItem("Seleccione...");
            listaEmpleados.clear();
            String callProcedure = "{CALL MostrarTiposGeneros()}";
            CallableStatement stmt = con.prepareCall(callProcedure);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String tipoGenero = rs.getString("tipoGenero");
                System.out.println("Tipo de generos: " + tipoGenero);
                comboGenero.addItem(tipoGenero);
            }
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void llenarComboCargo() {
        try (Connection con = conexion.conectar()) {
            comboCargo.removeAllItems();
            comboCargo.addItem("Seleccione...");
            listaEmpleados.clear();
            String callProcedure = "{CALL MostrarTiposCargos()}";
            CallableStatement stmt = con.prepareCall(callProcedure);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String tipoCargo = rs.getString("tipoCargo");
                System.out.println("Tipo de cargos: " + tipoCargo);
                comboCargo.addItem(tipoCargo);
            }
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private boolean ValidarCamposVacios() {

        if (txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtDocumento.getText().isEmpty()
                || txtCorreo.getText().isEmpty() || comboCargo.getSelectedIndex() == 0 || comboDocumento.getSelectedIndex() == 0
                || txtTelefono.getText().isEmpty() || txtDirreccion.getText().isEmpty() || comboGenero.getSelectedIndex() == 0 || txtSalario.getText().isEmpty()
                || dateFechanacimiento.getDate() == null || dateContratacion.getDate() == null || String.valueOf(txtPassword.getPassword()).isEmpty()) {
            return false;
        }
        return true;
    }

    public void guardarRegistro() {

        Clave = String.valueOf(txtPassword.getPassword());
        if (validarDocumentoUnico()) {
            Mensajes.mostrarAdvertencia("El documento ya existe");
            return;
        }
        if (comboDocumento.getSelectedIndex() != -1 && comboGenero.getSelectedIndex() != -1 && comboCargo.getSelectedIndex() != -1) {
            String callProcedure = "{CALL RegistrarEmpleado(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)}";

            try (Connection con = conexion.conectar()) {
                CallableStatement stmt = con.prepareCall(callProcedure);
                stmt.setString(1, txtNombres.getText());
                stmt.setString(2, txtApellidos.getText());
                stmt.setString(3, txtDocumento.getText());
                stmt.setInt(4, comboDocumento.getSelectedIndex());
                stmt.setString(5, txtTelefono.getText());
                stmt.setString(6, txtDirreccion.getText());
                stmt.setString(7, txtCorreo.getText());
                stmt.setInt(8, comboGenero.getSelectedIndex());
                java.util.Date utilDate = dateFechanacimiento.getDate();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                stmt.setDate(9, sqlDate);
                java.util.Date utilcontra = dateContratacion.getDate();
                java.sql.Date sqlcontra = new java.sql.Date(utilcontra.getTime());
                stmt.setDate(10, sqlcontra);
                stmt.setInt(11, comboCargo.getSelectedIndex());
                String salarioFormateado = formatearSalario(txtSalario.getText());
                stmt.setString(12, salarioFormateado);
                stmt.setString(13, Clave);
                stmt.execute();
                Mensajes.mostrarExito("Registro agregado");
                mostrarInfo();
                conexion.desconectar();
            } catch (SQLException e) {
                Mensajes.mostrarError("Error al guardar el registro");
                System.out.println(e.toString());
            }
        } else {
            Mensajes.mostrarAdvertencia("Selecciones todos los campos requeridos");
        }
    }

    public String formatearSalario(String salario) {

        salario = salario.replaceAll("[^\\d.]", "");
        double salarioNumerico = Double.parseDouble(salario);
        DecimalFormat formatoSalario = new DecimalFormat("$ #,###.###");
        String salarioFormateado = formatoSalario.format(salarioNumerico);

        return salarioFormateado;
    }

    public void limpiarCampos() {
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDocumento.setText("");
        txtTelefono.setText("");
        txtDirreccion.setText("");
        txtCorreo.setText("");
        dateFechanacimiento.setDate(null);
        dateContratacion.setDate(null);
        txtSalario.setText("");

        comboDocumento.removeAllItems();
        llenarComboDocumento();
        comboGenero.removeAllItems();
        llenarComboGenero();
        comboCargo.removeAllItems();
        llenarComboCargo();

    }

    public boolean validarDocumentoUnico() {
        boolean existe = false;

        try (Connection con = conexion.conectar()) {
            String callProcedure = "{CALL ValidarDocumentoUnico(?, ?)}";
            CallableStatement stmt = con.prepareCall(callProcedure);
            stmt.setString(1, txtDocumento.getText());
            stmt.registerOutParameter(2, Types.BIT);
            stmt.execute();

            existe = stmt.getBoolean(2);
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al validar el documento único: " + e.getMessage());
        }

        return existe;
    }

    public void mostrarInfo() {
        try (Connection con = conexion.conectar()) {
            DefaultTableModel model = new DefaultTableModel();
            Statement statement = con.createStatement();
            String query = "call MostrarEmpleados()";
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                model.addColumn(metaData.getColumnLabel(i));
            }

            while (resultSet.next()) {
                Object[] filas = new Object[metaData.getColumnCount()];
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    filas[i] = resultSet.getObject(i + 1);
                }
                model.addRow(filas);
            }
            tablaRegistro.setModel(model);
            ajustesTablas.ajustarTabla(tablaRegistro);
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
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
            java.util.logging.Logger.getLogger(formAdministrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formAdministrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formAdministrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formAdministrador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                formAdministrador admi = new formAdministrador();
                admi.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Asistencia;
    private javax.swing.JTabbedPane JTab;
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> comboCargo;
    private javax.swing.JComboBox<String> comboDocumento;
    private javax.swing.JComboBox<String> comboGenero;
    private com.toedter.calendar.JDateChooser dateContratacion;
    private com.toedter.calendar.JDateChooser dateFechanacimiento;
    private com.toedter.calendar.JDateChooser dateFin;
    private com.toedter.calendar.JDateChooser dateInicio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaRegistro;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDempleado;
    private javax.swing.JTextField txtDirreccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
