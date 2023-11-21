package GUI;

import Dominio.Administrador;
import Dominio.Entrenador;
import Exceptions.InputException;
import GUI.PanelAdministrador;
import GUI.PanelEntrenador;
import Negocio.AdministradorNegocio;
import Negocio.EntrenadorNegocio;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author ceria
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        checkVisiblePassword = new javax.swing.JCheckBox();
        btnIniciar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblIconOjo = new javax.swing.JLabel();
        lblLogoItson = new javax.swing.JLabel();
        lblLogoIws = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblUserProfile = new javax.swing.JLabel();
        lblContrasenia = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationByPlatform(true);

        txtUsuario.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtUsuario.setToolTipText("Ingrese su usuario");
        txtUsuario.setDragEnabled(true);
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        checkVisiblePassword.setToolTipText("Ver contraseña");
        checkVisiblePassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkVisiblePassword.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkVisiblePasswordStateChanged(evt);
            }
        });

        btnIniciar.setBackground(new java.awt.Color(117, 155, 255));
        btnIniciar.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnIniciar.setText("Iniciar Sesión");
        btnIniciar.setToolTipText("Iniciar Sesión");
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 117, 117));
        btnSalir.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblIconOjo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ojo.png"))); // NOI18N

        lblLogoItson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo-itson.png"))); // NOI18N

        lblLogoIws.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo-isw.jpg"))); // NOI18N
        lblLogoIws.setToolTipText("Acerca de");
        lblLogoIws.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoIwsMouseClicked(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Plan de Entrenamiento");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSubtitulo.setText("Generador de Macrociclos");

        lblUserProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user-profile.jpg"))); // NOI18N

        lblContrasenia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblContrasenia.setText("Contraseña:");

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUsuario.setText("Usuario:");

        txtPassword.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtPassword.setToolTipText("Ingrese su contraseña");
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 32, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(224, 224, 224)
                .addComponent(btnIniciar)
                .addGap(169, 169, 169)
                .addComponent(lblLogoIws)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(lblLogoItson))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(lblSubtitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addComponent(lblUserProfile))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(lblUsuario)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblContrasenia)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtPassword))
                        .addGap(12, 12, 12)
                        .addComponent(checkVisiblePassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIconOjo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblLogoItson)
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addGap(12, 12, 12)
                .addComponent(lblSubtitulo)
                .addGap(6, 6, 6)
                .addComponent(lblUserProfile)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblContrasenia))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(checkVisiblePassword))
                            .addComponent(lblIconOjo))
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoIws, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSalir)
                        .addComponent(btnIniciar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        try {
            if (!txtUsuario.getText().equals("admin")) {
                EntrenadorNegocio en = new EntrenadorNegocio();
                Entrenador entrenador = en.iniciarSesion(txtUsuario.getText(), String.valueOf(txtPassword.getPassword()));
                if (entrenador != null) {
                    this.dispose();
                    new PanelEntrenador(entrenador).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña de incorrectas (Intente de nuevo).", "¡Error!", JOptionPane.ERROR_MESSAGE);
                    txtUsuario.setBorder(new LineBorder(Color.RED));
                    txtPassword.setBorder(new LineBorder(Color.RED));
                }
            } else {
                AdministradorNegocio an = new AdministradorNegocio();
                Administrador administrador = an.iniciarSesion(txtUsuario.getText(), String.valueOf(txtPassword.getPassword()));
                if (administrador != null) {
                    this.dispose();
                    new PanelAdministrador(administrador).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña de incorrectas (Intente de nuevo).", "¡Error!", JOptionPane.ERROR_MESSAGE);
                    txtUsuario.setBorder(new LineBorder(Color.RED));
                    txtPassword.setBorder(new LineBorder(Color.RED));
                }
            }
        } catch (Exception e) {
            if (e instanceof InputException) {
                InputException ex = (InputException) e;
                if (ex.getTextField().equals("usuario")) {
                    txtUsuario.setBorder(new LineBorder(Color.RED));
                }
                if (ex.getTextField().equals("contrasena")) {
                    txtPassword.setBorder(new LineBorder(Color.RED));
                }
            }
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }

    }//GEN-LAST:event_btnIniciarActionPerformed

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        txtUsuario.setBorder(new LineBorder(Color.GRAY));
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        txtPassword.setBorder(new LineBorder(Color.GRAY));
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // Verifica si la tecla presionada es un espacio
        if (evt.getKeyChar() == ' ') {
            // Si es un espacio, consume el evento para evitar que se escriba en el TextField
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        // Verifica si la tecla presionada es un espacio
        if (evt.getKeyChar() == ' ') {
            // Si es un espacio, consume el evento para evitar que se escriba en el TextField
            evt.consume();
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void lblLogoIwsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoIwsMouseClicked
        JOptionPane.showMessageDialog(null, "Autores: \n"
                + " - Brandon Figueroa Ugalde \n"
                + " - Jesus Omar Hernandez Iturbe \n"
                + " - Jose Alfredo Núñez Aguirre \n"
                + "\nProf. Gilberto Borrego \n"
                + "Metodologías Ágiles de Desarrollo "
                + "ISW ITSON",
                "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lblLogoIwsMouseClicked

    private void checkVisiblePasswordStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkVisiblePasswordStateChanged
        if (this.checkVisiblePassword.isSelected()) {
            this.txtPassword.setEchoChar((char) 0);
        } else {
            this.txtPassword.setEchoChar('•');
        }
    }//GEN-LAST:event_checkVisiblePasswordStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox checkVisiblePassword;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblIconOjo;
    private javax.swing.JLabel lblLogoItson;
    private javax.swing.JLabel lblLogoIws;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUserProfile;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
