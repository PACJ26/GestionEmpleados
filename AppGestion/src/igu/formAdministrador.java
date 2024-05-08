package igu;

import Utilidad.Mensajes;
import Utilidad.TabIconos;
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

        TabIconos.setIcon(Jtab, 0, "registrar.png");
        TabIconos.setIcon(Jtab, 1, "empleado.png");
        TabIconos.setIcon(Jtab, 2, "asistencia.png");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Jtab.setForeground(new java.awt.Color(0, 0, 0));
        Jtab.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        Jtab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Jtab.setFocusCycleRoot(true);
        Jtab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Jtab.setName(""); // NOI18N

        PanelRegistro.setBackground(new java.awt.Color(255, 255, 255));
        PanelRegistro.setForeground(new java.awt.Color(255, 255, 255));
        PanelRegistro.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombres");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 29, 0, 0);
        PanelRegistro.add(jLabel2, gridBagConstraints);

        txtNombres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombres.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 151;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 0, 0, 0);
        PanelRegistro.add(txtNombres, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellidos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 59, 0, 0);
        PanelRegistro.add(jLabel3, gridBagConstraints);

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtApellidos.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 178;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 6, 0, 0);
        PanelRegistro.add(txtApellidos, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(46, 43, 0, 0);
        PanelRegistro.add(jLabel4, gridBagConstraints);

        txtDocumento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDocumento.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 151;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 6, 0, 24);
        PanelRegistro.add(txtDocumento, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tipo de Documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 33, 0, 0);
        PanelRegistro.add(jLabel5, gridBagConstraints);

        comboDocumento.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 6, 0, 0);
        PanelRegistro.add(comboDocumento, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Numero Telefonico");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 74, 0, 0);
        PanelRegistro.add(jLabel6, gridBagConstraints);

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelefono.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 108;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 2, 0, 0);
        PanelRegistro.add(txtTelefono, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Dirección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 33, 0, 0);
        PanelRegistro.add(jLabel7, gridBagConstraints);

        txtDirreccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDirreccion.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 151;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 5, 0, 0);
        PanelRegistro.add(txtDirreccion, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Correo Electronico");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 9, 0, 0);
        PanelRegistro.add(jLabel8, gridBagConstraints);

        txtCorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCorreo.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 151;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 6, 0, 24);
        PanelRegistro.add(txtCorreo, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Genero");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 33, 0, 0);
        PanelRegistro.add(jLabel9, gridBagConstraints);

        comboGenero.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 6, 0, 0);
        PanelRegistro.add(comboGenero, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Fecha de Nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 58, 0, 0);
        PanelRegistro.add(jLabel10, gridBagConstraints);

        dateFechanacimiento.setBackground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 112;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 58, 0, 0);
        PanelRegistro.add(dateFechanacimiento, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Fecha de Contratación");
        jLabel11.setToolTipText("");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 79, 0, 0);
        PanelRegistro.add(jLabel11, gridBagConstraints);

        dateContratacion.setBackground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 112;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 79, 0, 0);
        PanelRegistro.add(dateContratacion, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Cargo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 102, 0, 0);
        PanelRegistro.add(jLabel12, gridBagConstraints);

        comboCargo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        comboCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 25;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 6, 0, 0);
        PanelRegistro.add(comboCargo, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Salario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 47, 0, 0);
        PanelRegistro.add(jLabel13, gridBagConstraints);

        txtSalario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSalario.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 151;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 0, 0);
        PanelRegistro.add(txtSalario, gridBagConstraints);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 51;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(140, 4, 67, 0);
        PanelRegistro.add(btnRegistrar, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 22, 0, 0);
        PanelRegistro.add(jLabel16, gridBagConstraints);

        txtPassword.setText("jPasswordField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        PanelRegistro.add(txtPassword, gridBagConstraints);

        Jtab.addTab("Registrar", PanelRegistro);

        PanelEmpleados.setLayout(new java.awt.GridBagLayout());

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 867;
        gridBagConstraints.ipady = 397;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 108, 6);
        PanelEmpleados.add(jScrollPane1, gridBagConstraints);

        Jtab.addTab("Empleados", PanelEmpleados);

        PanelAsisencia.setLayout(new java.awt.GridBagLayout());

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 809;
        gridBagConstraints.ipady = 397;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 25, 22, 45);
        PanelAsisencia.add(jScrollPane2, gridBagConstraints);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ICONOS/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(6, 57, 0, 0);
        PanelAsisencia.add(btnBuscar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 114, 0, 0);
        PanelAsisencia.add(txtDempleado, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(6, 83, 0, 0);
        PanelAsisencia.add(dateInicio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(6, 35, 0, 0);
        PanelAsisencia.add(dateFin, gridBagConstraints);

        jLabel1.setText("Documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 113, 0, 0);
        PanelAsisencia.add(jLabel1, gridBagConstraints);

        jLabel14.setText("Fecha de finalización ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 2, 0, 0);
        PanelAsisencia.add(jLabel14, gridBagConstraints);

        jLabel15.setText("Fecha de Inicio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(20, 44, 0, 0);
        PanelAsisencia.add(jLabel15, gridBagConstraints);

        Jtab.addTab("Registro Entrada y Salida", PanelAsisencia);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jtab, javax.swing.GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jtab, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
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
                formAdministrador admi = new formAdministrador();
                admi.setVisible(true);

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
