/*
 * VerEntrenador.java
 */
package GUI.Administrador;

// Importaciones
import DAOs.AdministradorDAO;
import DAOs.EntrenadoresDAO;
import Dominio.Administrador;
import Dominio.Entrenador;
import Herramientas.Fecha;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa la interfaz gráfica para visualizar los detalles de un
 * entrenador.
 *
 * Atributos: - administrador: Objeto que representa al administrador asociado a
 * la ventana. - entrenador: Objeto que representa al entrenador cuyos detalles
 * se están visualizando. - AdministradorDAO: Objeto para acceder a la capa de
 * acceso a datos de los administradores. - EntrenadoresDAO: Objeto para acceder
 * a la capa de acceso a datos de los entrenadores. - Fecha: Objeto utilizado
 * para manejar fechas en el formato deseado.
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class VerEntrenador extends javax.swing.JFrame {

    // Atributos
    Administrador administrador;
    Entrenador entrenador;
    AdministradorDAO AdministradorDAO = new AdministradorDAO("AppPlanU");
    EntrenadoresDAO EntrenadoresDAO = new EntrenadoresDAO("AppPlanU");
    Fecha Fecha = new Fecha();

    /**
     * Constructor de la clase VerEntrenador.
     *
     * @param administrador Objeto Administrador asociado a la ventana.
     * @param entrenador Objeto Entrenador cuyos detalles se visualizarán.
     * @throws ParseException Excepción lanzada en caso de error de formato de
     * fecha.
     */
    public VerEntrenador(Administrador administrador, Entrenador entrenador) throws ParseException {
        this.administrador = administrador;
        this.entrenador = entrenador;
        initComponents();
        llenarTextos();
    }

    /**
     * Método que llena los campos de texto con los detalles del entrenador.
     *
     * @throws ParseException Excepción lanzada en caso de error de formato de
     * fecha.
     */
    public void llenarTextos() throws ParseException {
        // Inserción de datos a mostrar
        this.txtID.setText(this.entrenador.getId().toString());
        this.txtFechaRegistro.setText(Fecha.formatoFecha(this.entrenador.getFechaRegistro()));
        this.txtNombre.setText(this.entrenador.getNombre());
        this.txtApellidoPaterno.setText(this.entrenador.getApellidoPaterno());
        this.txtApellidoMaterno.setText(this.entrenador.getApellidoMaterno());
        this.txtUsuario.setText(this.entrenador.getUsuario());
        this.txtContrasena.setText(this.entrenador.getContrasena());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEncabezadoTitulo = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblEncabezadoMacro = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        lblDatosRegistro = new javax.swing.JLabel();
        lblDatosSesion = new javax.swing.JLabel();
        lblDatosPersonales = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblFechaRegistro = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtFechaRegistro = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ver Entrenador");
        setResizable(false);

        lblEncabezadoTitulo.setBackground(new java.awt.Color(98, 142, 255));

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo1.setText("Datos de Entrenador");

        javax.swing.GroupLayout lblEncabezadoTituloLayout = new javax.swing.GroupLayout(lblEncabezadoTitulo);
        lblEncabezadoTitulo.setLayout(lblEncabezadoTituloLayout);
        lblEncabezadoTituloLayout.setHorizontalGroup(
            lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        lblEncabezadoTituloLayout.setVerticalGroup(
            lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        lblEncabezadoMacro.setBackground(new java.awt.Color(217, 217, 217));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Ver Entrenador");

        javax.swing.GroupLayout lblEncabezadoMacroLayout = new javax.swing.GroupLayout(lblEncabezadoMacro);
        lblEncabezadoMacro.setLayout(lblEncabezadoMacroLayout);
        lblEncabezadoMacroLayout.setHorizontalGroup(
            lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoMacroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lblEncabezadoMacroLayout.setVerticalGroup(
            lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoMacroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        lblApellidoPaterno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblApellidoPaterno.setText("Apellido Paterno:");

        lblApellidoMaterno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblApellidoMaterno.setText("Apellido Materno:");

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUsuario.setText("Usuario:");

        lblContrasena.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblContrasena.setText("Contraseña:");

        lblDatosRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDatosRegistro.setText("Datos de registro:");

        lblDatosSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDatosSesion.setText("Datos de inicio de sesion:");

        lblDatosPersonales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDatosPersonales.setText("Datos personales del entrenador:");

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblID.setText("ID:");

        lblFechaRegistro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaRegistro.setText("Fecha de registro:");

        txtNombre.setEditable(false);
        txtNombre.setText("Nombre del entrenador");
        txtNombre.setToolTipText("Nombre(s) del entrenador");

        txtApellidoPaterno.setEditable(false);
        txtApellidoPaterno.setText("Apellido paterno del entrenador");
        txtApellidoPaterno.setToolTipText("Apellido Paterno del entrenador");

        txtApellidoMaterno.setEditable(false);
        txtApellidoMaterno.setText("Apellido materno del entrenador");
        txtApellidoMaterno.setToolTipText("Apellido Materno del entrenador");

        txtContrasena.setEditable(false);
        txtContrasena.setText("Contraseña del entrenador");
        txtContrasena.setToolTipText("Contraseña del entrenador");

        txtUsuario.setEditable(false);
        txtUsuario.setText("Usuario del entrenador");
        txtUsuario.setToolTipText("Usuario del entrenador");

        txtID.setEditable(false);
        txtID.setText("ID del entrenador");
        txtID.setToolTipText("Nombre(s) del entrenador");

        txtFechaRegistro.setEditable(false);
        txtFechaRegistro.setText("Fecha registro del entrenador");
        txtFechaRegistro.setToolTipText("Apellido Paterno del entrenador");

        btnRegresar.setBackground(new java.awt.Color(123, 162, 237));
        btnRegresar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setOpaque(true);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblContrasena)
                            .addComponent(lblUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDatosSesion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblApellidoMaterno)
                            .addComponent(lblApellidoPaterno)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDatosPersonales)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFechaRegistro)
                            .addComponent(lblID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDatosRegistro))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDatosRegistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaRegistro)
                    .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDatosPersonales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoPaterno)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoMaterno)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDatosSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método invocado al hacer clic en el botón de regresar. Cierra la ventana
     * actual y abre el panel del administrador.
     *
     * @param evt Objeto que representa el evento de clic.
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        try {
            new PanelAdministrador(this.administrador).setVisible(true);
        } catch (Exception ex) {
            // Manejo de excepciones y registro en el log en caso de error
            Logger.getLogger(VerEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblDatosPersonales;
    private javax.swing.JLabel lblDatosRegistro;
    private javax.swing.JLabel lblDatosSesion;
    private javax.swing.JPanel lblEncabezadoMacro;
    private javax.swing.JPanel lblEncabezadoTitulo;
    private javax.swing.JLabel lblFechaRegistro;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtFechaRegistro;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
