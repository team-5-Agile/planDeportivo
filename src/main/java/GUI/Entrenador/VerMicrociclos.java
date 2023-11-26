/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Entrenador;

import DAOs.EtapasDAO;
import DAOs.MacrociclosDAO;
import DAOs.MediosDAO;
import Dominio.Entrenador;
import Dominio.Etapa;
import Dominio.Macrociclo;
import Herramientas.Fecha;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brawun
 */
public class VerMicrociclos extends javax.swing.JFrame {

    Integer totalSemanasMacrociclo;
    Entrenador entrenador;
    Macrociclo macrociclo;
    Etapa etapaGeneral;
    Etapa etapaEspecial;
    Etapa etapaCompetitiva;
    MediosDAO MediosDAO = new MediosDAO("AppPlanU");
    EtapasDAO EtapasDAO = new EtapasDAO("AppPlanU");
    MacrociclosDAO MacrociclosDAO = new MacrociclosDAO("AppPlanU");
    Fecha Fecha = new Fecha();

    /**
     * Creates new form VerMicrociclos
     */
    public VerMicrociclos(Entrenador entrenador, Macrociclo macrociclo, Etapa etapaGeneral, Etapa etapaEspecial, Etapa etapaCompetitiva, Integer totalSemanasMacrociclo) throws ParseException {
        this.entrenador = entrenador;
        this.macrociclo = macrociclo;
        this.etapaGeneral = etapaGeneral;
        this.etapaEspecial = etapaEspecial;
        this.etapaCompetitiva = etapaCompetitiva;
        this.totalSemanasMacrociclo = totalSemanasMacrociclo;
        initComponents();
        llenarTextos();
    }

    public void llenarTextos() throws ParseException {
        // Insercion de titulo
        this.lblDeporteTitulo.setText(this.macrociclo.getDeporte());
        this.lblRamaTitulo.setText(this.macrociclo.getRama().name());
        this.lblIDTitulo.setText(this.macrociclo.getId().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEncabezadoMacro = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblGuion1 = new javax.swing.JLabel();
        lblGuion2 = new javax.swing.JLabel();
        lblRamaTitulo = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        lblDeporteTitulo = new javax.swing.JLabel();
        lblIDTitulo = new javax.swing.JLabel();
        lblEncabezadoTitulo = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        btnVerMedios = new javax.swing.JButton();
        btnRegresarPanel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEncabezadoMacro.setBackground(new java.awt.Color(217, 217, 217));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Ver Microciclos");

        lblGuion1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGuion1.setText("-");

        lblGuion2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGuion2.setText("-");

        lblRamaTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRamaTitulo.setText("Rama");

        lblNum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNum.setText("#");

        lblDeporteTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDeporteTitulo.setText("Deporte");

        lblIDTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIDTitulo.setText("ID");

        javax.swing.GroupLayout lblEncabezadoMacroLayout = new javax.swing.GroupLayout(lblEncabezadoMacro);
        lblEncabezadoMacro.setLayout(lblEncabezadoMacroLayout);
        lblEncabezadoMacroLayout.setHorizontalGroup(
            lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoMacroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                .addComponent(lblDeporteTitulo)
                .addGap(32, 32, 32)
                .addComponent(lblGuion1)
                .addGap(35, 35, 35)
                .addComponent(lblRamaTitulo)
                .addGap(37, 37, 37)
                .addComponent(lblGuion2)
                .addGap(35, 35, 35)
                .addComponent(lblNum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIDTitulo)
                .addGap(17, 17, 17))
        );
        lblEncabezadoMacroLayout.setVerticalGroup(
            lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoMacroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(lblDeporteTitulo)
                    .addComponent(lblRamaTitulo)
                    .addComponent(lblIDTitulo)
                    .addComponent(lblNum)
                    .addComponent(lblGuion1)
                    .addComponent(lblGuion2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEncabezadoTitulo.setBackground(new java.awt.Color(98, 142, 255));

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo1.setText("Microciclos del Macrociclo");

        javax.swing.GroupLayout lblEncabezadoTituloLayout = new javax.swing.GroupLayout(lblEncabezadoTitulo);
        lblEncabezadoTitulo.setLayout(lblEncabezadoTituloLayout);
        lblEncabezadoTituloLayout.setHorizontalGroup(
            lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lblEncabezadoTituloLayout.setVerticalGroup(
            lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btnVerMedios.setBackground(new java.awt.Color(153, 153, 255));
        btnVerMedios.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnVerMedios.setText("Ver Medios");
        btnVerMedios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerMedios.setOpaque(true);
        btnVerMedios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMediosActionPerformed(evt);
            }
        });

        btnRegresarPanel.setBackground(new java.awt.Color(123, 162, 237));
        btnRegresarPanel.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnRegresarPanel.setText("Regresar a Panel");
        btnRegresarPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarPanel.setOpaque(true);
        btnRegresarPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnVerMedios, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresarPanel)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresarPanel)
                    .addComponent(btnVerMedios))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerMediosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMediosActionPerformed
        try {
            this.dispose();
            new VerMedios(this.entrenador, this.macrociclo, this.etapaGeneral, this.etapaEspecial, this.etapaCompetitiva, this.totalSemanasMacrociclo).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(VerMacrociclo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVerMediosActionPerformed

    private void btnRegresarPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPanelActionPerformed
        this.dispose(); // Se cierra la ventana actual
        try {
            // Se abre el panel de entrenador
            new PanelEntrenador(entrenador).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Paso3Medios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegresarPanelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresarPanel;
    private javax.swing.JButton btnVerMedios;
    private javax.swing.JLabel lblDeporteTitulo;
    private javax.swing.JPanel lblEncabezadoMacro;
    private javax.swing.JPanel lblEncabezadoTitulo;
    private javax.swing.JLabel lblGuion1;
    private javax.swing.JLabel lblGuion2;
    private javax.swing.JLabel lblIDTitulo;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblRamaTitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    // End of variables declaration//GEN-END:variables
}