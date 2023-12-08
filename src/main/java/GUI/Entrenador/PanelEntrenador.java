/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Entrenador;

import DAOs.EntrenadoresDAO;
import DAOs.MacrociclosDAO;
import Dominio.Entrenador;
import Dominio.Macrociclo;
import GUI.Login.Login;
import Herramientas.Fecha;
import Herramientas.Validaciones;
import jakarta.persistence.EntityNotFoundException;
import java.awt.event.ItemEvent;
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
public class PanelEntrenador extends javax.swing.JFrame {

    //Atributos
    Entrenador entrenador;
    Macrociclo seleccion = null;
    EntrenadoresDAO EntrenadoresDAO = new EntrenadoresDAO("AppPlanU");
    MacrociclosDAO MacrociclosDAO = new MacrociclosDAO("AppPlanU");
    Validaciones Validaciones = new Validaciones();
    Fecha Fecha = new Fecha();

    /**
     * Creates new form PanelEntrenador
     */
    public PanelEntrenador(Entrenador entrenador) throws ParseException, Exception {
        this.entrenador = entrenador;
        initComponents();
        llenarTextos();
        cargarTablaMacros();
    }

    public void llenarTextos() throws ParseException {
        this.lblFechaHoy.setText(Fecha.formatoFecha(Fecha.fechaAhora()));
        this.lblNombreEntrenador.setText(this.entrenador.getNombre() + " " + this.entrenador.getApellidoPaterno() + " " + this.entrenador.getApellidoMaterno() + " - ID: " + entrenador.getId());
    }

    private void refrescarBusqueda() throws Exception {
        if (this.chkVigentes.isSelected()) {
            // Se buscara por los macrociclos vigentes
            cargarTablaVigentes();
        } else if (this.chkNoVigentes.isSelected()) {
            // Se buscara por los macrociclos NO vigentes
            cargarTablaNoVigentes();
        } else if (this.chkFuturos.isSelected()) {
            // Se buscara por los macrociclos futuros
            cargarTablaFuturos();
        } else if (this.chkPasados.isSelected()) {
            // Se buscara por los macrociclos pasados
            cargarTablaFuturos();
        } else {
            // Se buscara por TODOS los macrociclos 
            cargarTablaMacros();
        }
    }

    private void cargarTablaMacros() throws Exception {
        uncheckBoxes();
        llenarTabla(MacrociclosDAO.consultarTodosMacrociclosEntrenador(this.entrenador));
    }

    public void cargarTablaVigentes() throws Exception {
        llenarTabla(MacrociclosDAO.consultarMacrociclosVigentes(this.entrenador));
    }

    public void cargarTablaNoVigentes() throws Exception {
        llenarTabla(MacrociclosDAO.consultarMacrociclosNoVigentes(this.entrenador));
    }

    public void cargarTablaFuturos() throws Exception {
        llenarTabla(MacrociclosDAO.consultarMacrociclosFuturos(this.entrenador));
    }

    public void cargarTablaPasados() throws Exception {
        llenarTabla(MacrociclosDAO.consultarMacrociclosPasados(this.entrenador));
    }

    public void llenarTabla(List<Macrociclo> listaMacrociclos) throws ParseException {
        if (!listaMacrociclos.isEmpty()) {
            DefaultTableModel modeloTablaEntrenadores = (DefaultTableModel) this.tblMacrociclos.getModel();
            modeloTablaEntrenadores.setRowCount(0);
            for (Macrociclo macrociclo : listaMacrociclos) {
                Object[] filaNueva = {
                    macrociclo.getId(),
                    macrociclo.getDeporte(),
                    macrociclo.getRama(),
                    macrociclo.getJefeRama(),
                    macrociclo.getPreparadorFisico(),
                    macrociclo.getMetodologo(),
                    macrociclo.getFechaInicio() == null
                    ? "Null"
                    : Fecha.formatoFecha(macrociclo.getFechaInicio()),
                    macrociclo.getFechaFin() == null
                    ? "Null"
                    : Fecha.formatoFecha(macrociclo.getFechaFin())};
                modeloTablaEntrenadores.addRow(filaNueva);
            }
            Validaciones.centrarTabla(tblMacrociclos);
        }
    }

    public int obtenerFila() {
        try {
            int fila = tblMacrociclos.getSelectedRow();
            return fila;
        } catch (Exception e) {
            Logger.getLogger(PanelEntrenador.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }

    public void uncheckBoxes() {
        this.chkVigentes.setSelected(false);
        this.chkNoVigentes.setSelected(false);
        this.chkFuturos.setSelected(false);
        this.chkPasados.setSelected(false);
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
        lblNombreEntrenador = new javax.swing.JLabel();
        lblFechaHoy = new javax.swing.JLabel();
        lblEncabezadoMacro = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPanel = new javax.swing.JScrollPane();
        tblMacrociclos = new javax.swing.JTable();
        btnAyuda = new javax.swing.JButton();
        btnRefrescarTabla = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblSeleccion = new javax.swing.JLabel();
        txtSeleccion = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        btnNuevoMacrociclo = new javax.swing.JButton();
        btnVerMacrociclo = new javax.swing.JButton();
        btnEliminarMacrociclo = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        chkVigentes = new javax.swing.JCheckBox();
        chkFuturos = new javax.swing.JCheckBox();
        chkPasados = new javax.swing.JCheckBox();
        chkNoVigentes = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Panel Principal Adminsitrador");
        setResizable(false);

        lblEncabezadoTitulo.setBackground(new java.awt.Color(98, 142, 255));

        lblNombreEntrenador.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNombreEntrenador.setText("Nombre entrenador");

        lblFechaHoy.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblFechaHoy.setText("Fecha Hoy");

        javax.swing.GroupLayout lblEncabezadoTituloLayout = new javax.swing.GroupLayout(lblEncabezadoTitulo);
        lblEncabezadoTitulo.setLayout(lblEncabezadoTituloLayout);
        lblEncabezadoTituloLayout.setHorizontalGroup(
            lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreEntrenador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFechaHoy)
                .addGap(31, 31, 31))
        );
        lblEncabezadoTituloLayout.setVerticalGroup(
            lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreEntrenador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEncabezadoMacro.setBackground(new java.awt.Color(217, 217, 217));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Mis Macrociclos");

        javax.swing.GroupLayout lblEncabezadoMacroLayout = new javax.swing.GroupLayout(lblEncabezadoMacro);
        lblEncabezadoMacro.setLayout(lblEncabezadoMacroLayout);
        lblEncabezadoMacroLayout.setHorizontalGroup(
            lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoMacroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(684, 684, 684))
        );
        lblEncabezadoMacroLayout.setVerticalGroup(
            lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoMacroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Macrociclos Registrados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 14))); // NOI18N

        tblMacrociclos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tblMacrociclos.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        tblMacrociclos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Deporte", "Rama", "Jefe de Rama", "Prep. Físico", "Metodólogo", "Fecha Inicio", "Fecha Fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMacrociclos.setToolTipText("Haga clic en entrenador a administrar");
        jScrollPanel.setViewportView(tblMacrociclos);

        btnAyuda.setBackground(new java.awt.Color(153, 181, 186));
        btnAyuda.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAyuda.setOpaque(true);
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        btnRefrescarTabla.setBackground(new java.awt.Color(204, 255, 255));
        btnRefrescarTabla.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnRefrescarTabla.setText("Refrescar Tabla");
        btnRefrescarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefrescarTabla.setOpaque(true);
        btnRefrescarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarTablaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Filtros de busqueda:");

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

        btnNuevoMacrociclo.setBackground(new java.awt.Color(204, 255, 204));
        btnNuevoMacrociclo.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnNuevoMacrociclo.setText("Nuevo Macrociclo");
        btnNuevoMacrociclo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoMacrociclo.setOpaque(true);
        btnNuevoMacrociclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMacrocicloActionPerformed(evt);
            }
        });

        btnVerMacrociclo.setBackground(new java.awt.Color(238, 239, 170));
        btnVerMacrociclo.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnVerMacrociclo.setText("Ver");
        btnVerMacrociclo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerMacrociclo.setOpaque(true);
        btnVerMacrociclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMacrocicloActionPerformed(evt);
            }
        });

        btnEliminarMacrociclo.setBackground(new java.awt.Color(239, 170, 170));
        btnEliminarMacrociclo.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnEliminarMacrociclo.setText("Eliminar");
        btnEliminarMacrociclo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarMacrociclo.setOpaque(true);
        btnEliminarMacrociclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMacrocicloActionPerformed(evt);
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

        chkVigentes.setFont(new java.awt.Font("Liberation Sans", 3, 14)); // NOI18N
        chkVigentes.setText("Vigentes");
        chkVigentes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkVigentesItemStateChanged(evt);
            }
        });

        chkFuturos.setFont(new java.awt.Font("Liberation Sans", 3, 14)); // NOI18N
        chkFuturos.setText("Futuros");
        chkFuturos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkFuturosItemStateChanged(evt);
            }
        });

        chkPasados.setFont(new java.awt.Font("Liberation Sans", 3, 14)); // NOI18N
        chkPasados.setText("Pasados");
        chkPasados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkPasadosItemStateChanged(evt);
            }
        });

        chkNoVigentes.setFont(new java.awt.Font("Liberation Sans", 3, 14)); // NOI18N
        chkNoVigentes.setText("No Vigentes");
        chkNoVigentes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkNoVigentesItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(lblSeleccion)
                        .addGap(6, 6, 6)
                        .addComponent(txtSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCerrarSesion)
                        .addGap(359, 359, 359)
                        .addComponent(btnVerMacrociclo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarMacrociclo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkVigentes)
                                .addGap(18, 18, 18)
                                .addComponent(chkNoVigentes)
                                .addGap(18, 18, 18)
                                .addComponent(chkFuturos)
                                .addGap(18, 18, 18)
                                .addComponent(chkPasados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefrescarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNuevoMacrociclo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkVigentes)
                            .addComponent(chkNoVigentes)
                            .addComponent(chkFuturos)
                            .addComponent(chkPasados)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAyuda)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRefrescarTabla)
                            .addComponent(btnNuevoMacrociclo))))
                .addGap(13, 13, 13)
                .addComponent(jScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnSeleccionar))
                    .addComponent(lblSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnCerrarSesion))
                    .addComponent(btnVerMacrociclo)
                    .addComponent(btnEliminarMacrociclo))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        try {
            int fila = obtenerFila();
            if (fila != -1) {
                Macrociclo macrociclo = MacrociclosDAO.consultarMacrociclo((Long) tblMacrociclos.getValueAt(fila, 0));
                this.txtSeleccion.setText(macrociclo.getDeporte() + " - Rama: " + macrociclo.getRama().name() + " - Preparador Fisico: " + macrociclo.getPreparadorFisico() + " - ID: " + entrenador.getId() + ".");
                this.seleccion = macrociclo;
                tblMacrociclos.clearSelection();
            } else {
                JOptionPane.showMessageDialog(null, "Error: Seleccione un entrenador. (De la tabla 'Entrenadores Registrados').", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (EntityNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un errror al querer seleccionar al entrenador. Intente de nuevo", "¡Error interno!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnNuevoMacrocicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMacrocicloActionPerformed
        this.dispose();
        try {
            new Paso1Registro(this.entrenador).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(PanelEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNuevoMacrocicloActionPerformed

    private void btnVerMacrocicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMacrocicloActionPerformed
        if (seleccion != null) {
            try {
                this.dispose();
                new VerMacrociclo(this.entrenador, this.seleccion).setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(PanelEntrenador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Seleccione un macrociclo a ver. (De la tabla 'Macrociclos Registrados').", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerMacrocicloActionPerformed

    private void btnEliminarMacrocicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMacrocicloActionPerformed
        if (seleccion != null) {
            int i = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el macrociclo? (Se eliminaran todas los etapas, medios y relacionados registrados a este macrociclo)", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (i == JOptionPane.YES_OPTION) {
                try {
                    MacrociclosDAO.eliminarMacrociclo(this.seleccion.getId());
                    JOptionPane.showMessageDialog(null, "Se eliminó exitosamente el macrociclo: " + seleccion.getDeporte() + " - Rama: " + seleccion.getRama().name() + " - Preparador Fisico: " + seleccion.getPreparadorFisico() + " - ID: " + seleccion.getId() + ".", "Eliminacion de macrociclo exitosa.", JOptionPane.INFORMATION_MESSAGE);
                    cargarTablaMacros();
                } catch (EntityNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un errror al querer eliminar al macrociclo. Intente de nuevo", "¡Error interno!", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(PanelEntrenador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: Seleccione un macrociclo a eliminar. (De la tabla 'Macrociclos Registrados').", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarMacrocicloActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cerrar sesion?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
            new Login().setVisible(true);
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        JOptionPane.showMessageDialog(null, "Filtros de Busqueda: \n"
                + " - Vigentes: Macrociclos que esten actualmente vigentes. \n"
                + " - No Vigentes: Macrociclos que esten actualmente no vigentes. \n"
                + " - Futuros: Macrociclos que esten por ser vigentes en el futuro. \n"
                + " - Pasados: Macrociclos que hayan finalizado en el pasado. \n"
                + " NOTA: Al no seleccionar ningun filtro se mostraran todos los macrociclos registrados. \n"
                + "\nBotones y funciones: \n"
                + " - Refrescar Tabla: Refrescar la tabla de Macrociclos Registrados. \n"
                + " - Nuevo Macrociclo: Registrar un nuevo macrociclo en el sistema. \n"
                + " - Ver: Consultar los datos del macrociclo seleccionado. \n"
                + " - Editar: Editar los datos del macrociclo seleccionado. \n"
                + " - Eliminar: Eliminar los datos del macrociclo seleccionado. \n",
                "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAyudaActionPerformed

    private void btnRefrescarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarTablaActionPerformed
        try {
            JOptionPane.showMessageDialog(null, "Tabla refrescada con exito.", "Tabla refrescada", JOptionPane.INFORMATION_MESSAGE);
            this.cargarTablaMacros();
        } catch (Exception ex) {
            Logger.getLogger(PanelEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefrescarTablaActionPerformed

    private void chkVigentesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkVigentesItemStateChanged
        try {
            // Desmarcar los otros checkboxes si es seleccionado
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                chkNoVigentes.setSelected(false);
                chkFuturos.setSelected(false);
                chkPasados.setSelected(false);
            } else {
                chkVigentes.setSelected(false);
            }
            refrescarBusqueda();
        } catch (Exception ex) {
            Logger.getLogger(PanelEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chkVigentesItemStateChanged

    private void chkNoVigentesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkNoVigentesItemStateChanged
        try {
            // Desmarcar los otros checkboxes si es seleccionado
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                chkVigentes.setSelected(false);
                chkFuturos.setSelected(false);
                chkPasados.setSelected(false);
            } else {
                chkNoVigentes.setSelected(false);
            }
            refrescarBusqueda();
        } catch (Exception ex) {
            Logger.getLogger(PanelEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chkNoVigentesItemStateChanged

    private void chkFuturosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkFuturosItemStateChanged
        try {
            // Desmarcar los otros checkboxes si es seleccionado
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                chkVigentes.setSelected(false);
                chkNoVigentes.setSelected(false);
                chkPasados.setSelected(false);
            } else {
                chkFuturos.setSelected(false);
            }
            refrescarBusqueda();
        } catch (Exception ex) {
            Logger.getLogger(PanelEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chkFuturosItemStateChanged

    private void chkPasadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkPasadosItemStateChanged
        try {
            // Desmarcar los otros checkboxes si es seleccionado
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                chkVigentes.setSelected(false);
                chkNoVigentes.setSelected(false);
                chkFuturos.setSelected(false);
            } else {
                chkPasados.setSelected(false);
            }
            refrescarBusqueda();
        } catch (Exception ex) {
            Logger.getLogger(PanelEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chkPasadosItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminarMacrociclo;
    private javax.swing.JButton btnNuevoMacrociclo;
    private javax.swing.JButton btnRefrescarTabla;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVerMacrociclo;
    private javax.swing.JCheckBox chkFuturos;
    private javax.swing.JCheckBox chkNoVigentes;
    private javax.swing.JCheckBox chkPasados;
    private javax.swing.JCheckBox chkVigentes;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JPanel lblEncabezadoMacro;
    private javax.swing.JPanel lblEncabezadoTitulo;
    private javax.swing.JLabel lblFechaHoy;
    private javax.swing.JLabel lblNombreEntrenador;
    private javax.swing.JLabel lblSeleccion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblMacrociclos;
    private javax.swing.JTextField txtSeleccion;
    // End of variables declaration//GEN-END:variables
}
