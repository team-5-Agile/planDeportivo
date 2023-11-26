/**
 * RegistrarEntrenador.java
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Descripción general de la clase.
 *
 * Atributos: - administrador: objeto de tipo Administrador - AdministradorDAO:
 * objeto de tipo AdministradorDAO - EntrenadoresDAO: objeto de tipo
 * EntrenadoresDAO - Fecha: objeto de tipo Fecha
 *
 * @author Equipo #5 - Metodologías Ágiles de Desarrollo
 */
public class RegistrarEntrenador extends javax.swing.JFrame {

    // Atributos
    Administrador administrador;
    AdministradorDAO AdministradorDAO = new AdministradorDAO("AppPlanU");
    EntrenadoresDAO EntrenadoresDAO = new EntrenadoresDAO("AppPlanU");
    Fecha Fecha = new Fecha();
    Validaciones Validaciones = new Validaciones();

    /**
     * Creates new form RegistrarEntrenador
     *
     * @param administrador objeto de tipo Administrador
     */
    public RegistrarEntrenador(Administrador administrador) {
        this.administrador = administrador;
        initComponents();
    }

    public void eliminarEspaciosRepetidos() {
        this.txtApellidoMaterno.setText(Validaciones.eliminarEspaciosRepetidos(this.txtApellidoMaterno.getText()));
        this.txtApellidoPaterno.setText(Validaciones.eliminarEspaciosRepetidos(this.txtApellidoPaterno.getText()));
        this.txtNombre.setText(Validaciones.eliminarEspaciosRepetidos(this.txtNombre.getText()));
        this.txtUsuario.setText(Validaciones.eliminarEspaciosRepetidos(this.txtUsuario.getText()));
        this.txtContrasena.setText(Validaciones.eliminarEspaciosRepetidos(this.txtContrasena.getText()));
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
        lblSeleccionSesion = new javax.swing.JLabel();
        lblIngreseDatos = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registrar Nuevo Entrenador");

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
        lblTitulo.setText("Nuevo Entrenador");

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

        lblSeleccionSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSeleccionSesion.setText("Seleccione los datos de inicio de sesion:");

        lblIngreseDatos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIngreseDatos.setText("Ingrese los datos personales del entrenador:");

        txtNombre.setToolTipText("Nombre(s) del entrenador");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellidoPaterno.setToolTipText("Apellido Paterno del entrenador");
        txtApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPaternoKeyTyped(evt);
            }
        });

        txtApellidoMaterno.setToolTipText("Apellido Materno del entrenador");
        txtApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMaternoKeyTyped(evt);
            }
        });

        txtContrasena.setToolTipText("Contraseña del entrenador");
        txtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyTyped(evt);
            }
        });

        txtUsuario.setToolTipText("Usuario del entrenador");
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

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

        btnGuardar.setBackground(new java.awt.Color(132, 237, 123));
        btnGuardar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setOpaque(true);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblContrasena)
                            .addComponent(lblUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSeleccionSesion)))
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
                            .addComponent(lblIngreseDatos))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(lblIngreseDatos)
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
                .addGap(28, 28, 28)
                .addComponent(lblSeleccionSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para cancelar el registro.
     *
     * @param evt Evento de acción generado al hacer clic en el botón Cancelar.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Se muestra un mensaje de confirmación para cancelar el registro
        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cancelar el registro?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (i == JOptionPane.YES_OPTION) {
            this.dispose(); // Se cierra la ventana actual
            try {
                new PanelAdministrador(this.administrador).setVisible(true); // Se abre el panel del administrador
            } catch (Exception ex) {
                Logger.getLogger(RegistrarEntrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.setVisible(true); // Se mantiene visible la ventana actual
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Método para guardar los datos del entrenador.
     *
     * @param evt Evento de acción generado al hacer clic en el botón Guardar.
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // Se verifica que ningún campo esté vacío
            if (!this.txtApellidoMaterno.getText().isBlank()
                    && !this.txtApellidoPaterno.getText().isBlank()
                    && !this.txtContrasena.getText().isBlank()
                    && !this.txtNombre.getText().isBlank()
                    && !this.txtUsuario.getText().isBlank()) {
                eliminarEspaciosRepetidos();
                // Se registra el nuevo entrenador en la base de datos según los datos ingresados en los TextField
                Entrenador entrenador = EntrenadoresDAO.registrarEntrenador(new Entrenador(
                        this.txtNombre.getText(),
                        this.txtApellidoPaterno.getText(),
                        this.txtApellidoMaterno.getText(),
                        this.txtContrasena.getText(),
                        this.txtUsuario.getText(),
                        Fecha.fechaAhora(),
                        this.administrador));
                // Si se registra correctamente el entrenador
                if (entrenador.getId() != null) {
                    // Se muestra un mensaje de éxito con los detalles del entrenador registrado
                    JOptionPane.showMessageDialog(null, "Se creó exitosamente la cuenta del entrenador: " + this.txtNombre.getText() + " " + this.txtApellidoPaterno.getText() + " " + this.txtApellidoMaterno.getText() + " - ID: " + entrenador.getId() + ". ☺", "Registro de entrenador exitoso", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose(); // Se cierra la ventana actual
                    try {
                        new PanelAdministrador(this.administrador).setVisible(true); // Se abre el panel del administrador
                    } catch (Exception ex) {
                        Logger.getLogger(RegistrarEntrenador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    // Si ocurre un error en el registro, se muestra un mensaje de error
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al querer registrar la cuenta de entrenador.", "¡Error interno!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Si algún campo está vacío, se muestra un mensaje de error
                JOptionPane.showMessageDialog(null, "Ningún campo de registro puede estar vacío.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario " + this.txtUsuario.getText() + ", intente con otro usuario.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            this.txtUsuario.setText("");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JPanel lblEncabezadoMacro;
    private javax.swing.JPanel lblEncabezadoTitulo;
    private javax.swing.JLabel lblIngreseDatos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSeleccionSesion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
