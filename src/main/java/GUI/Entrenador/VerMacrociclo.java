/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Entrenador;

import GUI.Administrador.PanelAdministrador;
import DAOs.AdministradorDAO;
import DAOs.EntrenadoresDAO;
import Dominio.Administrador;
import Dominio.Entrenador;
import Dominio.Macrociclo;
import Herramientas.Fecha;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author brawun
 */
public class VerMacrociclo extends javax.swing.JFrame {

    //Atributos
    Entrenador entrenador;
    Macrociclo macrociclo;
    AdministradorDAO AdministradorDAO = new AdministradorDAO("AppPlanU");
    EntrenadoresDAO EntrenadoresDAO = new EntrenadoresDAO("AppPlanU");
    Fecha Fecha = new Fecha();

    /**
     * Creates new form RegistrarEntrenador
     */
    public VerMacrociclo(Entrenador entrenador, Macrociclo macrociclo) throws ParseException {
        this.entrenador = entrenador;
        this.macrociclo = macrociclo;
        initComponents();
        llenarTextos();
    }

    public void llenarTextos() throws ParseException {
        // Insercion de datos a mostrar
        this.txtJefeRama.setText(this.macrociclo.getJefeRama());
        this.txtNombreEntrenador.setText(this.entrenador.getNombre() + " " + this.entrenador.getApellidoPaterno() + " " + this.entrenador.getApellidoMaterno());
        this.txtDeporte.setText(this.macrociclo.getDeporte());
        this.txtRama.setText(this.macrociclo.getRama().name());
        this.txtPreparador.setText(this.macrociclo.getPreparadorFisico());
        this.txtMetodologo.setText(this.macrociclo.getMetodologo());
        this.txtInicio.setText(Fecha.formatoFecha(this.macrociclo.getFechaInicio()));
        this.txtFin.setText(Fecha.formatoFecha(this.macrociclo.getFechaFin()));
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
        btnRegresar = new javax.swing.JButton();
        txtNombreEntrenador = new javax.swing.JTextField();
        lblJefeRama = new javax.swing.JLabel();
        lblEntrenador = new javax.swing.JLabel();
        lblDeporte = new javax.swing.JLabel();
        lblRama = new javax.swing.JLabel();
        lblPreparador = new javax.swing.JLabel();
        lblIngreseDatos = new javax.swing.JLabel();
        lblMetodologo = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        btnVerEtapas = new javax.swing.JButton();
        txtJefeRama = new javax.swing.JTextField();
        txtDeporte = new javax.swing.JTextField();
        txtRama = new javax.swing.JTextField();
        txtPreparador = new javax.swing.JTextField();
        txtMetodologo = new javax.swing.JTextField();
        txtInicio = new javax.swing.JTextField();
        txtFin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ver Macrociclo");

        lblEncabezadoTitulo.setBackground(new java.awt.Color(98, 142, 255));

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo1.setText("Datos del Macrociclo");

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
        lblTitulo.setText("Ver Macrociclo");

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

        txtNombreEntrenador.setEditable(false);
        txtNombreEntrenador.setText("Nombre Entrenador");
        txtNombreEntrenador.setToolTipText("Apellido Paterno del entrenador");

        lblJefeRama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJefeRama.setText("Jefe de Rama:");

        lblEntrenador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEntrenador.setText("Entrenador:");

        lblDeporte.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDeporte.setText("Deporte:");

        lblRama.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRama.setText("Rama:");

        lblPreparador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPreparador.setText("Preparador Físico:");

        lblIngreseDatos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIngreseDatos.setText("Datos del macrociclo:");

        lblMetodologo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMetodologo.setText("Metodólogo:");

        lblFechaInicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaInicio.setText("Fecha Inicio:");

        lblFechaFin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaFin.setText("Fecha Fin:");

        btnVerEtapas.setBackground(new java.awt.Color(153, 153, 255));
        btnVerEtapas.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnVerEtapas.setText("Ver Etapas");
        btnVerEtapas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerEtapas.setOpaque(true);
        btnVerEtapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEtapasActionPerformed(evt);
            }
        });

        txtJefeRama.setEditable(false);
        txtJefeRama.setText("Jefe de Rama");
        txtJefeRama.setToolTipText("Apellido Paterno del entrenador");

        txtDeporte.setEditable(false);
        txtDeporte.setText("Deporte");
        txtDeporte.setToolTipText("Apellido Paterno del entrenador");

        txtRama.setEditable(false);
        txtRama.setText("Rama");
        txtRama.setToolTipText("Apellido Paterno del entrenador");

        txtPreparador.setEditable(false);
        txtPreparador.setText("Preparador");
        txtPreparador.setToolTipText("Apellido Paterno del entrenador");

        txtMetodologo.setEditable(false);
        txtMetodologo.setText("Metodologo");
        txtMetodologo.setToolTipText("Apellido Paterno del entrenador");

        txtInicio.setEditable(false);
        txtInicio.setText("Inicio");
        txtInicio.setToolTipText("Apellido Paterno del entrenador");

        txtFin.setEditable(false);
        txtFin.setText("Fin");
        txtFin.setToolTipText("Apellido Paterno del entrenador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerEtapas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEntrenador)
                    .addComponent(lblFechaFin)
                    .addComponent(lblFechaInicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFin, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMetodologo, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPreparador, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRama, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDeporte, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJefeRama, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(114, 114, 114)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDeporte)
                                .addComponent(lblJefeRama))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblIngreseDatos)
                                .addComponent(txtNombreEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblPreparador)
                                .addComponent(lblRama)
                                .addComponent(lblMetodologo))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(70, 70, 70)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(txtJefeRama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEntrenador)
                .addGap(18, 18, 18)
                .addComponent(txtDeporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtRama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPreparador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMetodologo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaInicio)
                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaFin)
                    .addComponent(txtFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnVerEtapas))
                .addGap(17, 17, 17))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(lblIngreseDatos)
                    .addGap(18, 18, 18)
                    .addComponent(lblJefeRama)
                    .addGap(18, 18, 18)
                    .addComponent(txtNombreEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblDeporte)
                    .addGap(18, 18, 18)
                    .addComponent(lblRama)
                    .addGap(18, 18, 18)
                    .addComponent(lblPreparador)
                    .addGap(18, 18, 18)
                    .addComponent(lblMetodologo)
                    .addContainerGap(150, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        try {
            new PanelEntrenador(this.entrenador).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(VerMacrociclo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnVerEtapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEtapasActionPerformed
        // Panel para ver el desglose de las etapas del macrociclo en particular, VerEtapas
    }//GEN-LAST:event_btnVerEtapasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerEtapas;
    private javax.swing.JLabel lblDeporte;
    private javax.swing.JPanel lblEncabezadoMacro;
    private javax.swing.JPanel lblEncabezadoTitulo;
    private javax.swing.JLabel lblEntrenador;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblIngreseDatos;
    private javax.swing.JLabel lblJefeRama;
    private javax.swing.JLabel lblMetodologo;
    private javax.swing.JLabel lblPreparador;
    private javax.swing.JLabel lblRama;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JTextField txtDeporte;
    private javax.swing.JTextField txtFin;
    private javax.swing.JTextField txtInicio;
    private javax.swing.JTextField txtJefeRama;
    private javax.swing.JTextField txtMetodologo;
    private javax.swing.JTextField txtNombreEntrenador;
    private javax.swing.JTextField txtPreparador;
    private javax.swing.JTextField txtRama;
    // End of variables declaration//GEN-END:variables
}
