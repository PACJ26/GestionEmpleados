package igu;

import Utilidad.Mensajes;
import Utilidad.Iconos;
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
import javax.swing.ImageIcon;
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

        initComponents();
        listaEmpleados = new ArrayList();
        conexion = new Conexion();
        this.setTitle("Registro de Empleado");
        this.setLocationRelativeTo(null);
        dateFechanacimiento.setMaxSelectableDate(fechaHace18AniosDate);
        llenarComboDocumento();
        llenarComboGenero();
        llenarComboCargo();
        ValidarCamposVacios();
        validarDocumentoUnico();
        mostrarInfo();
        limpiarCampos();

        Iconos.setIcon(Jtab, 0, "registrar.png");
        Iconos.setIcon(Jtab, 1, "empleado.png");
        Iconos.setIcon(Jtab, 2, "asistencia.png");
        
      Iconos.setJFrameIcon(this, "admi.png");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        Jtab = new javax.swing.JTabbedPane();
        PanelEmpleados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistro = new javax.swing.JTable();
        PanelAsisencia = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Asistencia = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtDempleado = new javax.swing.JTextField();
        dateInicio = new com.toedter.calendar.JDateChooser();
        dateFin = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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
        jLabel16 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Jtab.setForeground(new java.awt.Color(0, 0, 0));
        Jtab.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Jtab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Jtab.setFocusCycleRoot(true);
        Jtab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Jtab.setName(""); // NOI18N

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

        javax.swing.GroupLayout PanelEmpleadosLayout = new javax.swing.GroupLayout(PanelEmpleados);
        PanelEmpleados.setLayout(PanelEmpleadosLayout);
        PanelEmpleadosLayout.setHorizontalGroup(
            PanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelEmpleadosLayout.setVerticalGroup(
            PanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmpleadosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Jtab.addTab("Empleados", PanelEmpleados);

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

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Documento");

        jLabel14.setText("Fecha de finalización ");

        jLabel15.setText("Fecha de Inicio");

        javax.swing.GroupLayout PanelAsisenciaLayout = new javax.swing.GroupLayout(PanelAsisencia);
        PanelAsisencia.setLayout(PanelAsisenciaLayout);
        PanelAsisenciaLayout.setHorizontalGroup(
            PanelAsisenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAsisenciaLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel1)
                .addGap(191, 191, 191)
                .addComponent(jLabel15)
                .addGap(150, 150, 150)
                .addComponent(jLabel14))
            .addGroup(PanelAsisenciaLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(txtDempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(btnBuscar))
            .addGroup(PanelAsisenciaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelAsisenciaLayout.setVerticalGroup(
            PanelAsisenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAsisenciaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelAsisenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addGap(6, 6, 6)
                .addGroup(PanelAsisenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAsisenciaLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtDempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Jtab.addTab("Registro Entrada y Salida", PanelAsisencia);

        PanelRegistro.setBackground(new java.awt.Color(255, 255, 229));
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
        jLabel6.setText("Numero Telefonico");

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
        jLabel11.setToolTipText("");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Contraseña");

        txtPassword.setText("jPasswordField1");

        jPanel3.setBackground(new java.awt.Color(255, 255, 229));

        jLabel17.setFont(new java.awt.Font("Bodoni MT Black", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("FORMULARIO DE REGISTRO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(338, 338, 338))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(33, 33, 33))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 229));

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 0));
        btnRegistrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS/guardar32.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(460, 460, 460))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelRegistroLayout = new javax.swing.GroupLayout(PanelRegistro);
        PanelRegistro.setLayout(PanelRegistroLayout);
        PanelRegistroLayout.setHorizontalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel13))
                            .addComponent(jLabel16))
                        .addGap(5, 5, 5)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(dateFechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(6, 6, 6)
                                .addComponent(txtDirreccion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(144, 144, 144)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(65, 65, 65)
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelRegistroLayout.createSequentialGroup()
                                    .addGap(65, 65, 65)
                                    .addComponent(jLabel4)
                                    .addGap(13, 13, 13)
                                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelRegistroLayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel8)
                                    .addGap(6, 6, 6)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabel12)
                                .addGap(7, 7, 7)
                                .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 226, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelRegistroLayout.setVerticalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel5))
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel6))
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel8))
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(comboDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel7))
                            .addComponent(txtDirreccion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel9))))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelRegistroLayout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel12))
                                .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel13)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel16))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addComponent(dateFechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(6, 6, 6)
                        .addComponent(dateContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(121, 121, 121)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Jtab.addTab("Registrar", PanelRegistro);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Jtab, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jtab)
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
            Mensajes.mostrarAdvertencia("La fecha de inicio no puede ser posterior a la fecha de fin.");
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
            ajustesTablas.ajustarTabla(Asistencia);
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
        txtPassword.setText("");

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
                formPrincipal principal = new formPrincipal();
                principal.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Asistencia;
    private javax.swing.JTabbedPane Jtab;
    private javax.swing.JPanel PanelAsisencia;
    private javax.swing.JPanel PanelEmpleados;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
