package igu;

import Utilidad.Mensajes;
import Utilidad.Iconos;
import Utilidad.ajustesTablas;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
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
        Iconos.setIcon(Jtab, 3, "entradasalida.png");
        Iconos.setIcon(Jtab, 4, "reloj.png");

        Iconos.setJFrameIcon(this, "admi.png");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Jtab = new javax.swing.JTabbedPane();
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
        jLabel24 = new javax.swing.JLabel();
        txtDocumentoActual = new javax.swing.JTextField();
        btbBuscarEmpleado = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        PanelEmpleados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistro = new javax.swing.JTable();
        btnReporte = new javax.swing.JButton();
        PanelAsisencia = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableAsistencia = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        txtDempleado = new javax.swing.JTextField();
        dateInicio = new com.toedter.calendar.JDateChooser();
        dateFin = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnGenerarAsistencia = new javax.swing.JButton();
        PanelEntradasTardes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableLlegadastardes = new javax.swing.JTable();
        btnBuscartarde = new javax.swing.JButton();
        txtDoTarde = new javax.swing.JTextField();
        Datefechainicial = new com.toedter.calendar.JDateChooser();
        Datefechafinal = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnReportetarde = new javax.swing.JButton();
        PanelHorasextras = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableHorasExtras = new javax.swing.JTable();
        btnBuscarextras = new javax.swing.JButton();
        txtDoExtras = new javax.swing.JTextField();
        DatefechainicialExtras = new com.toedter.calendar.JDateChooser();
        DatefechafinalExtras = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnReporteExtras = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        ItemCerrarSesion = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Jtab.setForeground(new java.awt.Color(0, 0, 0));
        Jtab.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Jtab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Jtab.setFocusCycleRoot(true);
        Jtab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Jtab.setName(""); // NOI18N

        PanelRegistro.setBackground(new java.awt.Color(255, 255, 229));
        PanelRegistro.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombres");

        txtNombres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombres.setText("jTextField1");
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellidos");

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtApellidos.setText("jTextField1");
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Documento");

        txtDocumento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDocumento.setText("jTextField1");
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });

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
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Dirección");

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
        txtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalarioKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Contraseña");

        txtPassword.setText("jPasswordField1");

        jPanel3.setBackground(new java.awt.Color(255, 255, 229));

        jLabel17.setFont(new java.awt.Font("Bodoni MT Black", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("FORMULARIO DE REGISTRO");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Buscar por documento");

        txtDocumentoActual.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDocumentoActual.setText("jTextField1");
        txtDocumentoActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoActualKeyTyped(evt);
            }
        });

        btbBuscarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS/buscar.png"))); // NOI18N
        btbBuscarEmpleado.setText("Buscar");
        btbBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbBuscarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(380, 380, 380))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDocumentoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btbBuscarEmpleado)
                        .addGap(320, 320, 320))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDocumentoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btbBuscarEmpleado)
                    .addComponent(jLabel24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 229));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

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

        btnModificar.setBackground(new java.awt.Color(0, 0, 0));
        btnModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS/editar.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        jScrollPane5.setViewportView(txtDireccion);

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
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
                .addGap(0, 223, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(btnRegistrar)
                .addGap(117, 117, 117)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)))
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelRegistroLayout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addComponent(jLabel12))
                                        .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel13))
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addComponent(dateFechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(6, 6, 6)
                        .addComponent(dateContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        Jtab.addTab("Registrar y Modificar", PanelRegistro);

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

        btnReporte.setText("Generar Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEmpleadosLayout = new javax.swing.GroupLayout(PanelEmpleados);
        PanelEmpleados.setLayout(PanelEmpleadosLayout);
        PanelEmpleadosLayout.setHorizontalGroup(
            PanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PanelEmpleadosLayout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(btnReporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelEmpleadosLayout.setVerticalGroup(
            PanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmpleadosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReporte)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Jtab.addTab("Tabla Empleados", PanelEmpleados);

        TableAsistencia.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TableAsistencia);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtDempleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDempleadoKeyTyped(evt);
            }
        });

        jLabel1.setText("Documento");

        jLabel14.setText("Fecha de finalización ");

        jLabel15.setText("Fecha de Inicio");

        btnGenerarAsistencia.setText("Descargar");
        btnGenerarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarAsistenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAsisenciaLayout = new javax.swing.GroupLayout(PanelAsisencia);
        PanelAsisencia.setLayout(PanelAsisenciaLayout);
        PanelAsisenciaLayout.setHorizontalGroup(
            PanelAsisenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAsisenciaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelAsisenciaLayout.createSequentialGroup()
                .addGroup(PanelAsisenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarAsistencia)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelAsisenciaLayout.setVerticalGroup(
            PanelAsisenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAsisenciaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelAsisenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAsisenciaLayout.createSequentialGroup()
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
                            .addComponent(dateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelAsisenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(btnGenerarAsistencia)))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Jtab.addTab("Registro Entrada y Salida", PanelAsisencia);

        TableLlegadastardes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(TableLlegadastardes);

        btnBuscartarde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS/buscar.png"))); // NOI18N
        btnBuscartarde.setText("Buscar");
        btnBuscartarde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscartardeActionPerformed(evt);
            }
        });

        txtDoTarde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDoTardeKeyTyped(evt);
            }
        });

        jLabel18.setText("Documento");

        jLabel19.setText("Fecha de finalización ");

        jLabel20.setText("Fecha de Inicio");

        btnReportetarde.setText("Descargar");
        btnReportetarde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportetardeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEntradasTardesLayout = new javax.swing.GroupLayout(PanelEntradasTardes);
        PanelEntradasTardes.setLayout(PanelEntradasTardesLayout);
        PanelEntradasTardesLayout.setHorizontalGroup(
            PanelEntradasTardesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEntradasTardesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelEntradasTardesLayout.createSequentialGroup()
                .addGroup(PanelEntradasTardesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEntradasTardesLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel18)
                        .addGap(191, 191, 191)
                        .addComponent(jLabel20)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel19))
                    .addGroup(PanelEntradasTardesLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(txtDoTarde, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(Datefechainicial, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(Datefechafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(btnBuscartarde)
                .addGap(18, 18, 18)
                .addComponent(btnReportetarde)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelEntradasTardesLayout.setVerticalGroup(
            PanelEntradasTardesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEntradasTardesLayout.createSequentialGroup()
                .addGroup(PanelEntradasTardesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEntradasTardesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PanelEntradasTardesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addGap(6, 6, 6)
                        .addGroup(PanelEntradasTardesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEntradasTardesLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtDoTarde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Datefechainicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Datefechafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEntradasTardesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelEntradasTardesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscartarde)
                            .addComponent(btnReportetarde))
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Jtab.addTab("Registro Entradas Tardes", PanelEntradasTardes);

        TableHorasExtras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(TableHorasExtras);

        btnBuscarextras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS/buscar.png"))); // NOI18N
        btnBuscarextras.setText("Buscar");
        btnBuscarextras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarextrasActionPerformed(evt);
            }
        });

        txtDoExtras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDoExtrasKeyTyped(evt);
            }
        });

        jLabel21.setText("Documento");

        jLabel22.setText("Fecha de finalización ");

        jLabel23.setText("Fecha de Inicio");

        btnReporteExtras.setText("Descargar");
        btnReporteExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteExtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelHorasextrasLayout = new javax.swing.GroupLayout(PanelHorasextras);
        PanelHorasextras.setLayout(PanelHorasextrasLayout);
        PanelHorasextrasLayout.setHorizontalGroup(
            PanelHorasextrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHorasextrasLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelHorasextrasLayout.createSequentialGroup()
                .addGroup(PanelHorasextrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelHorasextrasLayout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel21)
                        .addGap(191, 191, 191)
                        .addComponent(jLabel23)
                        .addGap(150, 150, 150)
                        .addComponent(jLabel22))
                    .addGroup(PanelHorasextrasLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(txtDoExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(DatefechainicialExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(DatefechafinalExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(btnBuscarextras)
                .addGap(18, 18, 18)
                .addComponent(btnReporteExtras)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelHorasextrasLayout.setVerticalGroup(
            PanelHorasextrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHorasextrasLayout.createSequentialGroup()
                .addGroup(PanelHorasextrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelHorasextrasLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PanelHorasextrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22))
                        .addGap(6, 6, 6)
                        .addGroup(PanelHorasextrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelHorasextrasLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtDoExtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DatefechainicialExtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DatefechafinalExtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHorasextrasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelHorasextrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarextras)
                            .addComponent(btnReporteExtras))
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Jtab.addTab("Registro Horas Extras", PanelHorasextras);

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Jtab, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        jMenu2.setText("Inicio");

        ItemCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS/cerrarsesion.png"))); // NOI18N
        ItemCerrarSesion.setText("Cerrar Sesión");
        ItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCerrarSesionActionPerformed(evt);
            }
        });
        jMenu2.add(ItemCerrarSesion);

        MenuBar.add(jMenu2);

        jMenu3.setText("Ayuda");
        MenuBar.add(jMenu3);

        setJMenuBar(MenuBar);

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
        AsistenciaEntradaSalida();

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscartardeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscartardeActionPerformed
        // TODO add your handling code here:
        LlegadasTardes();
    }//GEN-LAST:event_btnBuscartardeActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // se pone la ruta
        exportToExcel(tablaRegistro, "C:/Users/Juan/Desktop/prueba.xls");
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnGenerarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarAsistenciaActionPerformed
        // TODO add your handling code here:
        exportToExcel(TableAsistencia, "C:/Users/Juan/Desktop/Asistencia.xls");
    }//GEN-LAST:event_btnGenerarAsistenciaActionPerformed

    private void btnReportetardeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportetardeActionPerformed
        // TODO add your handling code here:
        exportToExcel(TableLlegadastardes, "C:/Users/Juan/Desktop/LledadasTardes.xls");
    }//GEN-LAST:event_btnReportetardeActionPerformed

    private void btnBuscarextrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarextrasActionPerformed
        // TODO add your handling code here:
        ReporteHorasExtras();
    }//GEN-LAST:event_btnBuscarextrasActionPerformed

    private void btnReporteExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteExtrasActionPerformed
        // TODO add your handling code here:
        exportToExcel(TableHorasExtras, "C:/Users/Juan/Desktop/HorasExtras.xls");


    }//GEN-LAST:event_btnReporteExtrasActionPerformed

    private void ItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCerrarSesionActionPerformed
        // TODO add your handling code here:

        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas cerrar la sesión?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            formPrincipal principal = new formPrincipal();
            principal.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_ItemCerrarSesionActionPerformed

    private void btbBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbBuscarEmpleadoActionPerformed
        // TODO add your handling code here:
        String documento = txtDocumentoActual.getText(); // Obtener el documento del campo de texto
        buscarYMostrarEmpleado(documento);
    }//GEN-LAST:event_btbBuscarEmpleadoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        String documentoAnterior = txtDocumentoActual.getText();
        String nuevoDocumento = txtDocumento.getText();
        String nuevosNombres = txtNombres.getText();
        String nuevosApellidos = txtApellidos.getText();
        int nuevoTipoDocumento = comboDocumento.getSelectedIndex(); // Ajusta esto según tu lógica
        String nuevoNumeroTelefonico = txtTelefono.getText();
        String nuevaDireccion = txtDireccion.getText();
        String nuevoCorreoElectronico = txtCorreo.getText();
        int nuevoGenero = comboGenero.getSelectedIndex(); // Ajusta esto según tu lógica
        Date nuevaFechaNacimiento = dateFechanacimiento.getDate(); // Ajusta esto según tu lógica
        Date nuevaFechaContratacion = dateContratacion.getDate(); // Ajusta esto según tu lógica
        int nuevoCargo = comboCargo.getSelectedIndex(); // Ajusta esto según tu lógica
        String nuevoSalario = txtSalario.getText();
        String nuevaClave = String.valueOf(txtPassword.getPassword());

        // Llamar al método para modificar el empleado por documento
        modificarEmpleadoPorDocumento(
                documentoAnterior,
                nuevoDocumento,
                nuevosNombres,
                nuevosApellidos,
                nuevoTipoDocumento,
                nuevoNumeroTelefonico,
                nuevaDireccion,
                nuevoCorreoElectronico,
                nuevoGenero,
                nuevaFechaNacimiento,
                nuevaFechaContratacion,
                nuevoCargo,
                nuevoSalario,
                nuevaClave
        );

    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtDocumentoActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoActualKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
        {

        }
    }//GEN-LAST:event_txtDocumentoActualKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
        {

        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        // TODO add your handling code here:

        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
        {

        }
    }//GEN-LAST:event_txtDocumentoKeyTyped

    private void txtSalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
        {

        }
    }//GEN-LAST:event_txtSalarioKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtDempleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDempleadoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
        {
        }
    }//GEN-LAST:event_txtDempleadoKeyTyped

    private void txtDoTardeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDoTardeKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
        {
        }
    }//GEN-LAST:event_txtDoTardeKeyTyped

    private void txtDoExtrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDoExtrasKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
        {
        }
    }//GEN-LAST:event_txtDoExtrasKeyTyped

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
        } catch (SQLException e) {
            Mensajes.mostrarError("Error al cargagar el combo tipo documento");
        } finally {
            conexion.desconectar();
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
        } catch (SQLException e) {
            Mensajes.mostrarError("Error al cargagar el combo genero");
        } finally {
            conexion.desconectar();
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
        } catch (SQLException e) {
            Mensajes.mostrarError("Error al cargagar el combo tipo de cargo");
        } finally {
            conexion.desconectar();
        }
    }

    private boolean ValidarCamposVacios() {

        if (txtNombres.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtDocumento.getText().isEmpty()
                || txtCorreo.getText().isEmpty() || comboCargo.getSelectedIndex() == 0 || comboDocumento.getSelectedIndex() == 0
                || txtTelefono.getText().isEmpty() || txtDireccion.getText().isEmpty() || comboGenero.getSelectedIndex() == 0 || txtSalario.getText().isEmpty()
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
                stmt.setString(6, txtDireccion.getText());
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

    public void buscarYMostrarEmpleado(String documento) {
        // Verificar si el campo del documento está vacío
        if (documento.isEmpty()) {
            Mensajes.mostrarAdvertencia("Ingrese un documento para buscar");
            return; // Salir del método si el campo está vacío
        }

        String callProcedureBuscar = "{CALL BuscarEmpleadoPorDocumento(?)}";

        try (Connection con = conexion.conectar()) {
            CallableStatement stmtBuscar = con.prepareCall(callProcedureBuscar);
            stmtBuscar.setString(1, documento);
            ResultSet rs = stmtBuscar.executeQuery();
            if (!rs.isBeforeFirst()) {
                Mensajes.mostrarAdvertencia("No se encontró ningún empleado con el documento proporcionado");
            } else {
                while (rs.next()) {
                    // Aquí obtienes los datos del empleado encontrado
                    String nombres = rs.getString("nombres");
                    String apellidos = rs.getString("apellidos");
                    String documentos = rs.getString("documento");
                    String numerotelefono = rs.getString("numeroTelefonico");
                    String direccion = rs.getString("direccion");
                    String correo = rs.getString("correoElectronico");
                    int combogenero = rs.getInt("genero");
                    int combodocumento = rs.getInt("tipoDocumento");
                    Date datefechanacimiento = rs.getDate("fechaNacimiento");
                    Date datecontratacion = rs.getDate("fechaContratacion");
                    int combocargo = rs.getInt("cargo");
                    String salario = rs.getString("salario");
                    String salarioFormateado = formatearSalario(salario);
                    String clave = rs.getString("clave");

                    // Asignar los datos del empleado a los campos correspondientes en la interfaz gráfica
                    txtNombres.setText(nombres);
                    txtApellidos.setText(apellidos);
                    txtDocumento.setText(documentos);
                    comboDocumento.setSelectedIndex(combodocumento);
                    txtTelefono.setText(numerotelefono);
                    txtDireccion.setText(direccion);
                    txtCorreo.setText(correo);
                    comboGenero.setSelectedIndex(combogenero);
                    dateFechanacimiento.setDate(datefechanacimiento);
                    dateContratacion.setDate(datecontratacion);
                    comboCargo.setSelectedIndex(combocargo);
                    txtSalario.setText(salarioFormateado);
                    txtPassword.setText(clave);
                }
            }
            conexion.desconectar();
        } catch (SQLException e) {
            Mensajes.mostrarError("Error al buscar el empleado");
            System.out.println(e.toString());
        }
    }

    public void modificarEmpleadoPorDocumento(
            String documentoAnterior,
            String nuevoDocumento,
            String nuevosNombres,
            String nuevosApellidos,
            int nuevoTipoDocumento,
            String nuevoNumeroTelefonico,
            String nuevaDireccion,
            String nuevoCorreoElectronico,
            int nuevoGenero,
            Date nuevaFechaNacimiento,
            Date nuevaFechaContratacion,
            int nuevoCargo,
            String nuevoSalario,
            String nuevaClave
    ) {

        nuevoSalario = formatearSalario(nuevoSalario);
        String callProcedureModificar = "{CALL ModificarEmpleadoPorDocumento(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection con = conexion.conectar()) {
            CallableStatement stmtModificar = con.prepareCall(callProcedureModificar);
            stmtModificar.setString(1, documentoAnterior); // Documento anterior del empleado
            stmtModificar.setString(2, nuevoDocumento); // Nuevo documento del empleado
            stmtModificar.setString(3, nuevosNombres);
            stmtModificar.setString(4, nuevosApellidos);
            stmtModificar.setInt(5, nuevoTipoDocumento);
            stmtModificar.setString(6, nuevoNumeroTelefonico);
            stmtModificar.setString(7, nuevaDireccion);
            stmtModificar.setString(8, nuevoCorreoElectronico);
            stmtModificar.setInt(9, nuevoGenero);
            stmtModificar.setDate(10, new java.sql.Date(nuevaFechaNacimiento.getTime()));
            stmtModificar.setDate(11, new java.sql.Date(nuevaFechaContratacion.getTime()));
            stmtModificar.setInt(12, nuevoCargo);
            stmtModificar.setString(13, nuevoSalario);
            stmtModificar.setString(14, nuevaClave);

            stmtModificar.execute();
            Mensajes.mostrarExito("Empleado modificado correctamente");
            conexion.desconectar();
            mostrarInfo();
        } catch (SQLException e) {
            Mensajes.mostrarError("Error al modificar el empleado");
            System.out.println(e.toString());
        }
    }

    public String formatearSalario(String salario) {
        // Verificar si el salario ya está en el formato deseado
        if (salario.matches("^\\$\\s\\d{1,3}(\\.\\d{3})*(,\\d+)?$")) {
            return salario;
        }

        salario = salario.replaceAll("[^\\d.,]", ""); // Eliminar todo excepto los dígitos, coma y punto decimal
        double salarioNumerico = Double.parseDouble(salario.replace(",", "")); // Eliminar comas para evitar errores en el parseo
        DecimalFormat formatoSalario = new DecimalFormat("$ #,###.##");
        String salarioFormateado = formatoSalario.format(salarioNumerico);
        return salarioFormateado;
    }

    public void limpiarCampos() {
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDocumento.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        dateFechanacimiento.setDate(null);
        dateContratacion.setDate(null);
        txtSalario.setText("");
        txtPassword.setText("");
        txtDocumentoActual.setText("");

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

    public void AsistenciaEntradaSalida() {
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
            TableAsistencia.setModel(model);
            ajustesTablas.ajustarTabla(TableAsistencia);
        } catch (SQLException e) {
            Mensajes.mostrarError("Error al obtener los datos de entrada y salida" + e);
        } finally {
            conexion.desconectar();
        }
    }

    public void LlegadasTardes() {
        Date fechatardeInicio = Datefechainicial.getDate();
        Date fechatardeFin = Datefechafinal.getDate();

        if (fechatardeInicio == null || fechatardeFin == null) {
            Mensajes.mostrarAdvertencia("Por favor, seleccione una fecha de inicio y una fecha de fin válidas.");
            return;
        }

        if (fechatardeInicio.after(fechatardeFin)) {
            Mensajes.mostrarAdvertencia("La fecha de inicio no puede ser posterior a la fecha de fin.");
            return;
        }

        java.sql.Date sqlFechaInicio = new java.sql.Date(fechatardeInicio.getTime());
        java.sql.Date sqlFechaFin = new java.sql.Date(fechatardeFin.getTime());

        String documentoEmpleado = txtDoTarde.getText().trim();

        try (Connection con = conexion.conectar()) {
            DefaultTableModel model = new DefaultTableModel();
            CallableStatement stmt = con.prepareCall("{CALL ReporteIngresosTarde(?, ?, ?)}");
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
            TableLlegadastardes.setModel(model);
            ajustesTablas.ajustarTabla(TableLlegadastardes);
        } catch (SQLException e) {
            Mensajes.mostrarError("Error al obtener los datos de entrada y salida" + e);
        } finally {
            conexion.desconectar();
        }
    }

    public void ReporteHorasExtras() {
        Date fechaInicio = DatefechainicialExtras.getDate();
        Date fechaFin = DatefechafinalExtras.getDate();

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

        String documentoEmpleado = txtDoExtras.getText().trim();

        try (Connection con = conexion.conectar()) {
            DefaultTableModel model = new DefaultTableModel();
            CallableStatement stmt = con.prepareCall("{CALL ReporteHorasExtras(?, ?, ?)}");
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
            TableHorasExtras.setModel(model);
            ajustesTablas.ajustarTabla(TableHorasExtras);
        } catch (SQLException e) {
            Mensajes.mostrarError("Error al obtener los datos de entrada y salida" + e);
        } finally {
            conexion.desconectar();
        }
    }

    public static void exportToExcel(JTable table, String filePath) {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(filePath));
            WritableSheet sheet = workbook.createSheet("Datos", 0);

            // Formato para los encabezados
            WritableFont headerFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);
            WritableCellFormat headerFormat = new WritableCellFormat(headerFont);
            headerFormat.setBackground(Colour.AQUA);
            headerFormat.setAlignment(Alignment.CENTRE);
            headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
            headerFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

            // Escribir los encabezados y establecer ancho predeterminado para las columnas
            for (int i = 0; i < table.getColumnCount(); i++) {
                Label label = new Label(i, 0, table.getColumnName(i), headerFormat);
                sheet.addCell(label);
                sheet.setColumnView(i, 23); // Ajustar manualmente el ancho de las columnas
            }

            // Formato para los datos
            WritableFont dataFont = new WritableFont(WritableFont.ARIAL, 10);
            WritableCellFormat dataFormat = new WritableCellFormat(dataFont);
            dataFormat.setAlignment(Alignment.CENTRE);
            dataFormat.setVerticalAlignment(VerticalAlignment.CENTRE);

            // Escribir datos de la tabla y ajustar altura de filas según el contenido
            TableModel model = table.getModel();
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col);
                    Label label = new Label(col, row + 1, value != null ? value.toString() : "", dataFormat);
                    sheet.addCell(label);
                }
                sheet.setRowView(row + 1, 250); // Ajustar manualmente la altura de las filas
            }

            workbook.write();
            workbook.close();

            String message = "Excel creado exitosamente en: " + filePath;
            Mensajes.mostrarInformacion(message);
        } catch (IOException | WriteException e) {
            e.printStackTrace();
            Mensajes.mostrarError("Error al exportar a Excel: " + e.getMessage());
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
    private com.toedter.calendar.JDateChooser Datefechafinal;
    private com.toedter.calendar.JDateChooser DatefechafinalExtras;
    private com.toedter.calendar.JDateChooser Datefechainicial;
    private com.toedter.calendar.JDateChooser DatefechainicialExtras;
    private javax.swing.JMenuItem ItemCerrarSesion;
    private javax.swing.JTabbedPane Jtab;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel PanelAsisencia;
    private javax.swing.JPanel PanelEmpleados;
    private javax.swing.JPanel PanelEntradasTardes;
    private javax.swing.JPanel PanelHorasextras;
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JTable TableAsistencia;
    private javax.swing.JTable TableHorasExtras;
    private javax.swing.JTable TableLlegadastardes;
    private javax.swing.JButton btbBuscarEmpleado;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarextras;
    private javax.swing.JButton btnBuscartarde;
    private javax.swing.JButton btnGenerarAsistencia;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnReporteExtras;
    private javax.swing.JButton btnReportetarde;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tablaRegistro;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDempleado;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtDoExtras;
    private javax.swing.JTextField txtDoTarde;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtDocumentoActual;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
