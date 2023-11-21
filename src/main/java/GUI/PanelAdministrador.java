/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAOs.AdministradorDAO;
import DAOs.EntrenadoresDAO;
import Dominio.Administrador;
import Dominio.Entrenador;
import Herramientas.Fecha;
import Herramientas.Validaciones;
import com.sun.tools.javac.comp.Enter;
import jakarta.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brawun
 */
public class PanelAdministrador extends javax.swing.JFrame {

    //Atributos
    Administrador administrador;
    Entrenador seleccion = null;
    AdministradorDAO AdministradorDAO = new AdministradorDAO("AppPlanU");
    EntrenadoresDAO EntrenadoresDAO = new EntrenadoresDAO("AppPlanU");
    Validaciones Validaciones = new Validaciones();
    Fecha Fecha = new Fecha();

    /**
     * Creates new form PanelAdministrador
     */
    public PanelAdministrador(Administrador administrador) throws ParseException, Exception {
        this.administrador = administrador;
        initComponents();
        this.lblFechaHoy.setText(Fecha.formatoFecha(Fecha.fechaAhora()));
        cargarTablaEntrenadores();
    }

    private void cargarTablaEntrenadores() throws Exception {
        List<Entrenador> listaEntrenadores = EntrenadoresDAO.consultarTodosEntrenadores();
        DefaultTableModel modeloTablaEntrenadores = (DefaultTableModel) this.tblEntrenadores.getModel();
        modeloTablaEntrenadores.setRowCount(0);
        for (Entrenador entrenador : listaEntrenadores) {
            Object[] filaNueva = {
                entrenador.getId(),
                entrenador.getNombre(),
                entrenador.getApellidoPaterno(),
                entrenador.getApellidoMaterno(),
                entrenador.getUsuario(),
                entrenador.getContrasena(),
                Fecha.formatoFecha(entrenador.getFechaRegistro())};
            modeloTablaEntrenadores.addRow(filaNueva);
        }
        Validaciones.centrarTabla(tblEntrenadores);
    }

    public int obtenerFila() {
        try {
            int fila = tblEntrenadores.getSelectedRow();
            return fila;
        } catch (Exception e) {
            Logger.getLogger(PanelAdministrador.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
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
        lblFechaHoy = new javax.swing.JLabel();
        lblEncabezadoMacro = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPanel = new javax.swing.JScrollPane();
        tblEntrenadores = new javax.swing.JTable();
        lblSeleccion = new javax.swing.JLabel();
        txtSeleccion = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        btnConfigPersonal = new javax.swing.JButton();
        btnConfigMedios = new javax.swing.JButton();
        btnConfigDeportes = new javax.swing.JButton();
        btnConfigAcentos = new javax.swing.JButton();
        btnNuevoEntrenador = new javax.swing.JButton();
        btnAdminMacrociclos = new javax.swing.JButton();
        btnVerEntrenador = new javax.swing.JButton();
        btnEditarEntrenador = new javax.swing.JButton();
        btnEliminarEntrenador = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Panel Principal Adminsitrador");

        lblEncabezadoTitulo.setBackground(new java.awt.Color(98, 142, 255));

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo1.setText("Panel de Administrador");

        lblFechaHoy.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblFechaHoy.setText("Fecha Hoy");

        javax.swing.GroupLayout lblEncabezadoTituloLayout = new javax.swing.GroupLayout(lblEncabezadoTitulo);
        lblEncabezadoTitulo.setLayout(lblEncabezadoTituloLayout);
        lblEncabezadoTituloLayout.setHorizontalGroup(
            lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                .addComponent(lblFechaHoy)
                .addGap(59, 59, 59))
        );
        lblEncabezadoTituloLayout.setVerticalGroup(
            lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEncabezadoMacro.setBackground(new java.awt.Color(217, 217, 217));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Configuracion del sistema");

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

        jScrollPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entrenadores Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 14))); // NOI18N

        tblEntrenadores.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tblEntrenadores.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        tblEntrenadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nombre", "Apellido Paterno", "Apellido Materno", "Usuario", "Contraseña", "Fecha de Registro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEntrenadores.setToolTipText("Haga clic en entrenador a administrar");
        jScrollPanel.setViewportView(tblEntrenadores);

        lblSeleccion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSeleccion.setText("Selección:");

        txtSeleccion.setEditable(false);
        txtSeleccion.setBackground(new java.awt.Color(217, 217, 217));
        txtSeleccion.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        txtSeleccion.setText("Seleccione un entrenador de la tabla");

        btnSeleccionar.setBackground(new java.awt.Color(163, 163, 163));
        btnSeleccionar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionar.setOpaque(true);
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnConfigPersonal.setBackground(new java.awt.Color(237, 192, 123));
        btnConfigPersonal.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnConfigPersonal.setText("Configurar Personal");
        btnConfigPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfigPersonal.setOpaque(true);
        btnConfigPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigPersonalActionPerformed(evt);
            }
        });

        btnConfigMedios.setBackground(new java.awt.Color(237, 192, 123));
        btnConfigMedios.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnConfigMedios.setText("Configurar Medios");
        btnConfigMedios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfigMedios.setOpaque(true);
        btnConfigMedios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigMediosActionPerformed(evt);
            }
        });

        btnConfigDeportes.setBackground(new java.awt.Color(237, 192, 123));
        btnConfigDeportes.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnConfigDeportes.setText("Configurar Deportes");
        btnConfigDeportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfigDeportes.setOpaque(true);
        btnConfigDeportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigDeportesActionPerformed(evt);
            }
        });

        btnConfigAcentos.setBackground(new java.awt.Color(237, 192, 123));
        btnConfigAcentos.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnConfigAcentos.setText("Configurar Acentos");
        btnConfigAcentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfigAcentos.setOpaque(true);
        btnConfigAcentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigAcentosActionPerformed(evt);
            }
        });

        btnNuevoEntrenador.setBackground(new java.awt.Color(204, 255, 204));
        btnNuevoEntrenador.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnNuevoEntrenador.setText("Registrar Nuevo Entrenador");
        btnNuevoEntrenador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoEntrenador.setOpaque(true);
        btnNuevoEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEntrenadorActionPerformed(evt);
            }
        });

        btnAdminMacrociclos.setBackground(new java.awt.Color(153, 123, 237));
        btnAdminMacrociclos.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnAdminMacrociclos.setText("Administrar Macrociclos");
        btnAdminMacrociclos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminMacrociclos.setOpaque(true);
        btnAdminMacrociclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminMacrociclosActionPerformed(evt);
            }
        });

        btnVerEntrenador.setBackground(new java.awt.Color(238, 239, 170));
        btnVerEntrenador.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnVerEntrenador.setText("Ver");
        btnVerEntrenador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerEntrenador.setOpaque(true);
        btnVerEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEntrenadorActionPerformed(evt);
            }
        });

        btnEditarEntrenador.setBackground(new java.awt.Color(170, 194, 239));
        btnEditarEntrenador.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnEditarEntrenador.setText("Editar");
        btnEditarEntrenador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarEntrenador.setOpaque(true);
        btnEditarEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEntrenadorActionPerformed(evt);
            }
        });

        btnEliminarEntrenador.setBackground(new java.awt.Color(239, 170, 170));
        btnEliminarEntrenador.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnEliminarEntrenador.setText("Eliminar");
        btnEliminarEntrenador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarEntrenador.setOpaque(true);
        btnEliminarEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEntrenadorActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(237, 123, 123));
        btnCerrarSesion.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesion");
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setOpaque(true);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfigDeportes, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnConfigPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnConfigAcentos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnConfigMedios, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdminMacrociclos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(460, 460, 460)
                        .addComponent(btnNuevoEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(72, 72, 72)
                        .addComponent(lblSeleccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSeleccion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVerEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(btnEditarEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfigDeportes)
                    .addComponent(btnConfigPersonal)
                    .addComponent(btnConfigAcentos)
                    .addComponent(btnConfigMedios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdminMacrociclos)
                    .addComponent(btnNuevoEntrenador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar)
                    .addComponent(lblSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVerEntrenador)
                            .addComponent(btnEditarEntrenador)
                            .addComponent(btnEliminarEntrenador))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        try {
            int fila = obtenerFila();
            if (fila != -1) {
                Entrenador entrenador = EntrenadoresDAO.consultarEntrenador((Long) tblEntrenadores.getValueAt(fila, 0));
                this.txtSeleccion.setText(entrenador.getNombre() + " " + entrenador.getApellidoPaterno() + " " + entrenador.getApellidoMaterno() + " - ID: " + entrenador.getId() + ".");
                this.seleccion = entrenador;
                tblEntrenadores.clearSelection();
            } else {
                JOptionPane.showMessageDialog(null, "Error: Seleccione un entrenador. (De la tabla 'Entrenadores Registrados').", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (EntityNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un errror al querer seleccionar al entrenador. Intente de nuevo", "¡Error interno!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnNuevoEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEntrenadorActionPerformed
        this.dispose();
        new RegistrarEntrenador(this.administrador).setVisible(true);
    }//GEN-LAST:event_btnNuevoEntrenadorActionPerformed

    private void btnVerEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEntrenadorActionPerformed
        if (seleccion != null) {
            try {
                this.dispose();
                new VerEntrenador(this.administrador, this.seleccion).setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(PanelAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Seleccione un entrenador a ver. (De la tabla 'Entrenadores Registrados').", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnVerEntrenadorActionPerformed

    private void btnEliminarEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEntrenadorActionPerformed
        if (seleccion != null) {
            int i = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el entrenador? (Se eliminaran todos los macrociclos y relacionados registrados por este entrenador)", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (i == JOptionPane.YES_OPTION) {
                try {
                    EntrenadoresDAO.eliminarEntrenador(this.seleccion.getId());
                    JOptionPane.showMessageDialog(null, "Se eliminó exitosamente la cuenta del entrenador: " + this.seleccion.getNombre() + " " + this.seleccion.getApellidoPaterno() + " " + this.seleccion.getApellidoMaterno() + " - ID: " + seleccion.getId() + ".", "Eliminacion de entrenador exitosa.", JOptionPane.INFORMATION_MESSAGE);
                    cargarTablaEntrenadores();
                } catch (EntityNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un errror al querer eliminar al entrenador. Intente de nuevo", "¡Error interno!", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(PanelAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Seleccione un entrenador a eliminar. (De la tabla 'Entrenadores Registrados').", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarEntrenadorActionPerformed

    private void btnAdminMacrociclosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminMacrociclosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdminMacrociclosActionPerformed

    private void btnConfigAcentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigAcentosActionPerformed
        JOptionPane.showMessageDialog(null, "Funcion por agregar: \n"
                + "\n La funcion seleccionada esta por ser \n"
                + "agregada en futuras versiones del sistema. \n"
                + "\n Agradecemos su comprension \n",
                "¡Oops!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnConfigAcentosActionPerformed

    private void btnConfigPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigPersonalActionPerformed
        JOptionPane.showMessageDialog(null, "Funcion por agregar: \n"
                + "\n La funcion seleccionada esta por ser \n"
                + "agregada en futuras versiones del sistema. \n"
                + "\n Agradecemos su comprension \n",
                "¡Oops!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnConfigPersonalActionPerformed

    private void btnConfigMediosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigMediosActionPerformed
        JOptionPane.showMessageDialog(null, "Funcion por agregar: \n"
                + "\n La funcion seleccionada esta por ser \n"
                + "agregada en futuras versiones del sistema. \n"
                + "\n Agradecemos su comprension \n",
                "¡Oops!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnConfigMediosActionPerformed

    private void btnConfigDeportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigDeportesActionPerformed
        JOptionPane.showMessageDialog(null, "Funcion por agregar: \n"
                + "\n La funcion seleccionada esta por ser \n"
                + "agregada en futuras versiones del sistema. \n"
                + "\n Agradecemos su comprension \n",
                "¡Oops!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnConfigDeportesActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cerrar sesion?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
            new Login().setVisible(true);
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnEditarEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarEntrenadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminMacrociclos;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConfigAcentos;
    private javax.swing.JButton btnConfigDeportes;
    private javax.swing.JButton btnConfigMedios;
    private javax.swing.JButton btnConfigPersonal;
    private javax.swing.JButton btnEditarEntrenador;
    private javax.swing.JButton btnEliminarEntrenador;
    private javax.swing.JButton btnNuevoEntrenador;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVerEntrenador;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JPanel lblEncabezadoMacro;
    private javax.swing.JPanel lblEncabezadoTitulo;
    private javax.swing.JLabel lblFechaHoy;
    private javax.swing.JLabel lblSeleccion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JTable tblEntrenadores;
    private javax.swing.JTextField txtSeleccion;
    // End of variables declaration//GEN-END:variables
}
