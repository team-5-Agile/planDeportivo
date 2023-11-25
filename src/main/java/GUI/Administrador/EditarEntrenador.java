/**
 * EditarEntrenador.java
 */
package GUI.Administrador;

// Importaciones
import DAOs.AdministradorDAO;
import DAOs.EntrenadoresDAO;
import Dominio.Administrador;
import Dominio.Entrenador;
import Herramientas.Fecha;
import Herramientas.Validaciones;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Ventana de edición de entrenador.
 *
 * Atributos: - administrador: Objeto de la clase Administrador. - entrenador:
 * Objeto de la clase Entrenador. - AdministradorDAO: Objeto de la clase
 * AdministradorDAO, inicializado con el nombre "AppPlanU". - EntrenadoresDAO:
 * Objeto de la clase EntrenadoresDAO, inicializado con el nombre "AppPlanU". -
 * Fecha: Objeto de la clase Fecha.
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class EditarEntrenador extends javax.swing.JFrame {

    // Atributos
    Administrador administrador;
    Entrenador entrenador;
    AdministradorDAO AdministradorDAO = new AdministradorDAO("AppPlanU");
    EntrenadoresDAO EntrenadoresDAO = new EntrenadoresDAO("AppPlanU");
    Fecha Fecha = new Fecha();
    Validaciones Validaciones = new Validaciones();

    /**
     * Constructor de la clase EditarEntrenador.
     *
     * @param administrador Objeto de la clase Administrador que representa al
     * administrador actual.
     * @param entrenador Objeto de la clase Entrenador que se va a editar.
     * @throws ParseException Si ocurre un error al parsear la fecha.
     */
    public EditarEntrenador(Administrador administrador, Entrenador entrenador) throws ParseException {
        this.administrador = administrador;
        this.entrenador = entrenador;
        initComponents();
        llenarTextos();
    }
    
    public void eliminarEspaciosRepetidos() {
        this.txtApellidoMaterno.setText(Validaciones.eliminarEspaciosRepetidos(this.txtApellidoMaterno.getText()));
        this.txtApellidoPaterno.setText(Validaciones.eliminarEspaciosRepetidos(this.txtApellidoPaterno.getText()));
        this.txtNombre.setText(Validaciones.eliminarEspaciosRepetidos(this.txtNombre.getText()));
        this.txtUsuario.setText(Validaciones.eliminarEspaciosRepetidos(this.txtUsuario.getText()));
        this.txtContrasena.setText(Validaciones.eliminarEspaciosRepetidos(this.txtContrasena.getText()));
    }

    /**
     * Llena los campos de texto con la información del entrenador.
     *
     * @throws ParseException Si ocurre un error al parsear la fecha.
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
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Editar Entrenador");

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
        lblTitulo.setText("Editar Entrenador");

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

        txtNombre.setText("Nombre del entrenador");
        txtNombre.setToolTipText("Nombre(s) del entrenador");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellidoPaterno.setText("Apellido paterno del entrenador");
        txtApellidoPaterno.setToolTipText("Apellido Paterno del entrenador");

        txtApellidoMaterno.setText("Apellido materno del entrenador");
        txtApellidoMaterno.setToolTipText("Apellido Materno del entrenador");

        txtContrasena.setText("Contraseña del entrenador");
        txtContrasena.setToolTipText("Contraseña del entrenador");

        txtUsuario.setText("Usuario del entrenador");
        txtUsuario.setToolTipText("Usuario del entrenador");

        txtID.setEditable(false);
        txtID.setText("ID del entrenador");
        txtID.setToolTipText("Nombre(s) del entrenador");

        txtFechaRegistro.setEditable(false);
        txtFechaRegistro.setText("Fecha registro del entrenador");
        txtFechaRegistro.setToolTipText("Apellido Paterno del entrenador");

        btnCancelar.setBackground(new java.awt.Color(237, 123, 123));
        btnCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setOpaque(true);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(132, 237, 123));
        btnEditar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setOpaque(true);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción realizada al hacer clic en el botón Cancelar.
     *
     * @param evt Evento de acción.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cancelar la edicion?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
            try {
                new PanelAdministrador(this.administrador).setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(RegistrarEntrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Acción realizada al hacer clic en el botón Editar.
     *
     * @param evt Evento de acción.
     */
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            if (!this.txtApellidoMaterno.getText().isBlank()
                    && !this.txtApellidoPaterno.getText().isBlank()
                    && !this.txtContrasena.getText().isBlank()
                    && !this.txtNombre.getText().isBlank()
                    && !this.txtUsuario.getText().isBlank()) {
                eliminarEspaciosRepetidos();
                // Se edita el nuevo entrenador en la base de datos segun los datos seleccionados en el los TextField
                Entrenador entrenador = EntrenadoresDAO.editarEntrenador(new Entrenador(
                        this.entrenador.getId(),
                        this.txtNombre.getText(),
                        this.txtApellidoPaterno.getText(),
                        this.txtApellidoMaterno.getText(),
                        this.txtContrasena.getText(),
                        this.txtUsuario.getText(),
                        this.entrenador.getFechaRegistro(),
                        this.entrenador.getMacrociclos(),
                        this.entrenador.getAdministrador()));
                if (entrenador.getId() != null) {
                    JOptionPane.showMessageDialog(null, "Se editó exitosamente la cuenta del entrenador: " + this.txtNombre.getText() + " " + this.txtApellidoPaterno.getText() + " " + this.txtApellidoMaterno.getText() + " - ID: " + this.entrenador.getId() + ". ☺", "Registro de entrenador exitoso", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    try {
                        new PanelAdministrador(this.administrador).setVisible(true);
                    } catch (Exception ex) {
                        Logger.getLogger(RegistrarEntrenador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrió un errror al querer registrar la cuenta de entrenador.", "¡Error interno!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ningun campo de registro puede estar vacio.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario " + this.txtUsuario.getText() + ", intente con otro usuario.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            this.txtUsuario.setText("");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * Método para limitar la entrada de caracteres en el campo de nombre.
     *
     * @param evt Evento de teclado generado al escribir en el campo de nombre.
     */
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        // Verificar si la tecla presionada es una letra y no es un espacio
        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
            evt.consume(); // Consumir la tecla (evita que se escriba en el TextField)
        }
        // Verificar la longitud del texto
        if (txtNombre.getText().length() >= 100) {
            evt.consume(); // Consumir la tecla si se alcanza la longitud máxima
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    /**
     * Método para limitar la entrada de caracteres en el campo de apellido
     * paterno.
     *
     * @param evt Evento de teclado generado al escribir en el campo de apellido
     * paterno.
     */
    private void txtApellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPaternoKeyTyped
        char c = evt.getKeyChar();
        // Verificar si la tecla presionada es una letra y no es un espacio
        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
            evt.consume(); // Consumir la tecla (evita que se escriba en el TextField)
        }
        // Verificar la longitud del texto
        if (txtNombre.getText().length() >= 100) {
            evt.consume(); // Consumir la tecla si se alcanza la longitud máxima
        }
    }//GEN-LAST:event_txtApellidoPaternoKeyTyped

    /**
     * Método para limitar la entrada de caracteres en el campo de apellido
     * materno.
     *
     * @param evt Evento de teclado generado al escribir en el campo de apellido
     * materno.
     */
    private void txtApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMaternoKeyTyped
        char c = evt.getKeyChar();
        // Verificar si la tecla presionada es una letra y no es un espacio
        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
            evt.consume(); // Consumir la tecla (evita que se escriba en el TextField)
        }
        // Verificar la longitud del texto
        if (txtNombre.getText().length() >= 100) {
            evt.consume(); // Consumir la tecla si se alcanza la longitud máxima
        }
    }//GEN-LAST:event_txtApellidoMaternoKeyTyped

    /**
     * Método para limitar la entrada de caracteres en el campo de usuario.
     *
     * @param evt Evento de teclado generado al escribir en el campo de usuario.
     */
    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        char c = evt.getKeyChar();
        // Verificar si la tecla presionada es una letra y no es un espacio
        if (Character.isWhitespace(c)) {
            evt.consume(); // Consumir la tecla (evita que se escriba en el TextField)
        }
        // Verificar la longitud del texto
        if (txtNombre.getText().length() >= 30) {
            evt.consume(); // Consumir la tecla si se alcanza la longitud máxima
        }
        // Deshabilita Ctrl+C (Copiar) y Ctrl+V (Pegar)
        if ((evt.getKeyCode() == KeyEvent.VK_C && evt.isControlDown())
                || (evt.getKeyCode() == KeyEvent.VK_V && evt.isControlDown())) {
            evt.consume(); // Consume el evento para evitar que se complete la acción
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    /**
     * Método para limitar la entrada de caracteres en el campo de contraseña.
     *
     * @param evt Evento de teclado generado al escribir en el campo de
     * contraseña.
     */
    private void txtContrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyTyped
        char c = evt.getKeyChar();
        // Verificar si la tecla presionada es una letra y no es un espacio
        if (Character.isWhitespace(c)) {
            evt.consume(); // Consumir la tecla (evita que se escriba en el TextField)
        }
        // Verificar la longitud del texto
        if (txtNombre.getText().length() >= 30) {
            evt.consume(); // Consumir la tecla si se alcanza la longitud máxima
        }
        // Deshabilita Ctrl+C (Copiar) y Ctrl+V (Pegar)
        if ((evt.getKeyCode() == KeyEvent.VK_C && evt.isControlDown())
                || (evt.getKeyCode() == KeyEvent.VK_V && evt.isControlDown())) {
            evt.consume(); // Consume el evento para evitar que se complete la acción
        }
    }//GEN-LAST:event_txtContrasenaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
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
