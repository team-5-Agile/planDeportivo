/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.edu.itson.plan.grafica;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import mx.edu.itson.plan.negocio.Validaciones;

/**
 *
 * @author el_fr
 */
public class ViewMacrociclo extends javax.swing.JFrame {

    /**
     * Creates new form ViewMacrociclo
     */
    public ViewMacrociclo() {
        initComponents();
        setLocationRelativeTo(null);
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
        lblDeporte = new javax.swing.JLabel();
        lblRama = new javax.swing.JLabel();
        btnConfigurarAcentos = new javax.swing.JButton();
        lblFechaFinMacro = new javax.swing.JLabel();
        lblSemanasMacro = new javax.swing.JLabel();
        lblMensajeMacro = new javax.swing.JLabel();
        txtNumSemanasMacro = new javax.swing.JTextField();
        txtFechaInicioMacro = new javax.swing.JTextField();
        txtFechaFinMacro = new javax.swing.JTextField();
        lblDuracionMacro = new javax.swing.JLabel();
        lblFechaInicioMacro = new javax.swing.JLabel();
        pnlPeriodos = new javax.swing.JPanel();
        txtNumSemanasPreparatorio = new javax.swing.JTextField();
        txtNumSemanasCompetitivo = new javax.swing.JTextField();
        txtPorcientoPreparatorio = new javax.swing.JTextField();
        txtPorcientoCompetitivo = new javax.swing.JTextField();
        lblPreparatorio = new javax.swing.JLabel();
        lblCompetitivo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPorciento3 = new javax.swing.JLabel();
        lblPorciento5 = new javax.swing.JLabel();
        lblPorciento6 = new javax.swing.JLabel();
        lblPorciento7 = new javax.swing.JLabel();
        pnlEtapas = new javax.swing.JPanel();
        txtNumSemanasGeneral = new javax.swing.JTextField();
        txtNumSemanasEspecial = new javax.swing.JTextField();
        txtPorcientoGeneral = new javax.swing.JTextField();
        txtPorcientoEspecial = new javax.swing.JTextField();
        lblPorciento = new javax.swing.JLabel();
        lblPorciento2 = new javax.swing.JLabel();
        lbltxt = new javax.swing.JLabel();
        lblEspecial = new javax.swing.JLabel();
        lblGeneral = new javax.swing.JLabel();
        lblPorciento1 = new javax.swing.JLabel();
        lblPorciento4 = new javax.swing.JLabel();
        lblArrow = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnCalcularPorcentajes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Macrociclo");
        setBackground(new java.awt.Color(255, 255, 255));

        lblEncabezadoMacro.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Nuevo Macrociclo");

        lblDeporte.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDeporte.setText("Deporte");

        lblRama.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRama.setText("Rama");

        javax.swing.GroupLayout lblEncabezadoMacroLayout = new javax.swing.GroupLayout(lblEncabezadoMacro);
        lblEncabezadoMacro.setLayout(lblEncabezadoMacroLayout);
        lblEncabezadoMacroLayout.setHorizontalGroup(
            lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoMacroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDeporte)
                .addGap(18, 18, 18)
                .addComponent(lblRama)
                .addGap(34, 34, 34))
        );
        lblEncabezadoMacroLayout.setVerticalGroup(
            lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoMacroLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeporte)
                    .addComponent(lblTitulo)
                    .addComponent(lblRama)))
        );

        btnConfigurarAcentos.setBackground(new java.awt.Color(204, 255, 204));
        btnConfigurarAcentos.setText("Siguiente");
        btnConfigurarAcentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfigurarAcentos.setOpaque(true);
        btnConfigurarAcentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigurarAcentosActionPerformed(evt);
            }
        });

        lblFechaFinMacro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFechaFinMacro.setText("Fecha Fin:");

        lblSemanasMacro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSemanasMacro.setText("Semanas");

        lblMensajeMacro.setText("Seleccione una fecha inicio ó una fecha fin");

        txtNumSemanasMacro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNumSemanasMacro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumSemanasMacroKeyPressed(evt);
            }
        });

        txtFechaInicioMacro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaInicioMacro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaInicioMacroKeyPressed(evt);
            }
        });

        txtFechaFinMacro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaFinMacro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaFinMacroKeyPressed(evt);
            }
        });

        lblDuracionMacro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDuracionMacro.setText("Duracion:");

        lblFechaInicioMacro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFechaInicioMacro.setText("Fecha Incio:");

        txtNumSemanasPreparatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumSemanasPreparatorioActionPerformed(evt);
            }
        });

        lblPreparatorio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPreparatorio.setText("Preparatorio:");

        lblCompetitivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCompetitivo.setText("Competitivo:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione la proporción \nque se le asignará a cada periodo");

        lblPorciento3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento3.setText("semanas");

        lblPorciento5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento5.setText("semanas");

        lblPorciento6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento6.setText("% ");

        lblPorciento7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento7.setText("% ");

        javax.swing.GroupLayout pnlPeriodosLayout = new javax.swing.GroupLayout(pnlPeriodos);
        pnlPeriodos.setLayout(pnlPeriodosLayout);
        pnlPeriodosLayout.setHorizontalGroup(
            pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPeriodosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPeriodosLayout.createSequentialGroup()
                        .addGroup(pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPeriodosLayout.createSequentialGroup()
                                .addComponent(lblPreparatorio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPorcientoPreparatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPeriodosLayout.createSequentialGroup()
                                .addComponent(lblCompetitivo)
                                .addGap(18, 18, 18)
                                .addComponent(txtPorcientoCompetitivo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPeriodosLayout.createSequentialGroup()
                                .addComponent(lblPorciento7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNumSemanasPreparatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPeriodosLayout.createSequentialGroup()
                                .addComponent(lblPorciento6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumSemanasCompetitivo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPorciento5)
                            .addComponent(lblPorciento3))
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPeriodosLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        pnlPeriodosLayout.setVerticalGroup(
            pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPeriodosLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumSemanasPreparatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcientoPreparatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreparatorio)
                    .addComponent(lblPorciento3)
                    .addComponent(lblPorciento7))
                .addGap(18, 18, 18)
                .addGroup(pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumSemanasCompetitivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompetitivo)
                    .addComponent(lblPorciento5)
                    .addComponent(lblPorciento6)
                    .addComponent(txtPorcientoCompetitivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlEtapas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPorcientoGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcientoGeneralActionPerformed(evt);
            }
        });

        lblPorciento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento.setText("semanas");

        lblPorciento2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento2.setText("semanas");

        lbltxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbltxt.setText("Etapas del periodo Preparatorio ");

        lblEspecial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEspecial.setText("Especial");

        lblGeneral.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGeneral.setText("General");

        lblPorciento1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento1.setText("%");

        lblPorciento4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento4.setText("%");

        javax.swing.GroupLayout pnlEtapasLayout = new javax.swing.GroupLayout(pnlEtapas);
        pnlEtapas.setLayout(pnlEtapasLayout);
        pnlEtapasLayout.setHorizontalGroup(
            pnlEtapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEtapasLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(pnlEtapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGeneral)
                    .addComponent(lbltxt)
                    .addGroup(pnlEtapasLayout.createSequentialGroup()
                        .addGroup(pnlEtapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEspecial)
                            .addComponent(txtPorcientoEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPorcientoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(pnlEtapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPorciento1)
                            .addComponent(lblPorciento4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEtapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEtapasLayout.createSequentialGroup()
                                .addComponent(txtNumSemanasGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPorciento))
                            .addGroup(pnlEtapasLayout.createSequentialGroup()
                                .addComponent(txtNumSemanasEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPorciento2)))))
                .addGap(26, 26, 26))
        );
        pnlEtapasLayout.setVerticalGroup(
            pnlEtapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEtapasLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(lbltxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGeneral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEtapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPorcientoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPorciento)
                    .addComponent(lblPorciento1)
                    .addComponent(txtNumSemanasGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(lblEspecial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEtapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPorcientoEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPorciento2)
                    .addComponent(lblPorciento4)
                    .addComponent(txtNumSemanasEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblArrow.setText("<----");

        btnAtras.setBackground(new java.awt.Color(255, 153, 153));
        btnAtras.setText("Atrás");
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSiguiente.setText("Configurar Acentos");
        btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSiguiente.setOpaque(true);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnCalcularPorcentajes.setBackground(new java.awt.Color(51, 204, 255));
        btnCalcularPorcentajes.setText("Calcular");
        btnCalcularPorcentajes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcularPorcentajes.setOpaque(true);
        btnCalcularPorcentajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPorcentajesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPeriodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(303, 303, 303))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblDuracionMacro))
                            .addComponent(lblFechaInicioMacro)
                            .addComponent(lblFechaFinMacro, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNumSemanasMacro, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSemanasMacro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSiguiente))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAtras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConfigurarAcentos))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtFechaFinMacro, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFechaInicioMacro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(226, 226, 226)
                                            .addComponent(lblArrow)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pnlEtapas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblMensajeMacro)))))
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(btnCalcularPorcentajes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumSemanasMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDuracionMacro)
                    .addComponent(lblSemanasMacro)
                    .addComponent(btnSiguiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensajeMacro)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFechaInicioMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaInicioMacro))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addComponent(pnlEtapas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtras)
                            .addComponent(btnConfigurarAcentos))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaFinMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFechaFinMacro))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblArrow)
                                .addGap(132, 132, 132))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(pnlPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCalcularPorcentajes)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaFinMacroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaFinMacroKeyPressed
        String fechaInicio = this.txtFechaInicioMacro.getText();
        String fechaFin = this.txtFechaFinMacro.getText();
        // validar si se a presionado enter
        if (evt.getKeyCode() != 10) {
            return;
        }
        try {
            // si se presiono enter se validan los textos de los jtextField
            Validaciones val = new Validaciones();
            val.isFechaAnterior(fechaInicio, fechaFin);
            if (!fechaInicio.equals("")) {
                val.isFechaValida(fechaInicio);
                Long numSemanas = val.calcPeriodo(fechaInicio, fechaFin);
                txtNumSemanasMacro.setText(numSemanas + "");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_txtFechaFinMacroKeyPressed

    private void txtFechaInicioMacroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaInicioMacroKeyPressed
        String fechaInicio = this.txtFechaInicioMacro.getText();
        String numSemanas = this.txtNumSemanasMacro.getText();
        // validar si se a presionado enter

        if (evt.getKeyCode() != 10) {
            return;
        }
        try {

            Validaciones val = new Validaciones();
            val.isNumSemanaValido(numSemanas, 32, 52);
            if (!fechaInicio.equals("")) {
                if (!val.isFechaValida(fechaInicio)) {
                }

                LocalDate fin = val.calcPeriodo(fechaInicio, Integer.valueOf(numSemanas));
                txtFechaFinMacro.setText(val.convertirFecha(fin));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_txtFechaInicioMacroKeyPressed
    private double calcularPorcentaje(int total, int can){
        double re= (can/total)*100;
        return re;
    }
    private void txtNumSemanasMacroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSemanasMacroKeyPressed
        String fechaInicio = this.txtFechaInicioMacro.getText();
        String numSemanas = this.txtNumSemanasMacro.getText();
        if (evt.getKeyCode() != 10) {
            return;
        }
        try {
            Validaciones val = new Validaciones();
            if (!val.isNumSemanaValido(numSemanas, 32, 52));
            if (!fechaInicio.equals("")) {
                if (!val.isFechaValida(fechaInicio));

                LocalDate fin = val.calcPeriodo(fechaInicio, Integer.valueOf(numSemanas));
                txtFechaFinMacro.setText(val.convertirFecha(fin));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }

    }//GEN-LAST:event_txtNumSemanasMacroKeyPressed

    private void btnCalcularPorcentajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPorcentajesActionPerformed
        txtNumSemanasPreparatorio.setText(calcularPorcentaje(Integer.parseInt(txtNumSemanasMacro.getText()), Integer.parseInt(txtPorcientoPreparatorio.getText()))+"");
        txtNumSemanasCompetitivo.setText(calcularPorcentaje(Integer.parseInt(txtNumSemanasMacro.getText()), Integer.parseInt(txtPorcientoCompetitivo.getText()))+"");

        txtPorcientoGeneral.setText(calcularPorcentaje(Integer.parseInt(txtPorcientoPreparatorio.getText()), Integer.parseInt(txtNumSemanasGeneral.getText()))+"");
        txtPorcientoEspecial.setText(calcularPorcentaje(Integer.parseInt(txtPorcientoPreparatorio.getText()), Integer.parseInt(txtNumSemanasEspecial.getText()))+"");

    }//GEN-LAST:event_btnCalcularPorcentajesActionPerformed

    private void txtNumSemanasPreparatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumSemanasPreparatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumSemanasPreparatorioActionPerformed

    private void btnConfigurarAcentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigurarAcentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfigurarAcentosActionPerformed

    private void txtPorcientoGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcientoGeneralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcientoGeneralActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMacrociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMacrociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMacrociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMacrociclo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMacrociclo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCalcularPorcentajes;
    private javax.swing.JButton btnConfigurarAcentos;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblArrow;
    private javax.swing.JLabel lblCompetitivo;
    private javax.swing.JLabel lblDeporte;
    private javax.swing.JLabel lblDuracionMacro;
    private javax.swing.JPanel lblEncabezadoMacro;
    private javax.swing.JLabel lblEspecial;
    private javax.swing.JLabel lblFechaFinMacro;
    private javax.swing.JLabel lblFechaInicioMacro;
    private javax.swing.JLabel lblGeneral;
    private javax.swing.JLabel lblMensajeMacro;
    private javax.swing.JLabel lblPorciento;
    private javax.swing.JLabel lblPorciento1;
    private javax.swing.JLabel lblPorciento2;
    private javax.swing.JLabel lblPorciento3;
    private javax.swing.JLabel lblPorciento4;
    private javax.swing.JLabel lblPorciento5;
    private javax.swing.JLabel lblPorciento6;
    private javax.swing.JLabel lblPorciento7;
    private javax.swing.JLabel lblPreparatorio;
    private javax.swing.JLabel lblRama;
    private javax.swing.JLabel lblSemanasMacro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lbltxt;
    private javax.swing.JPanel pnlEtapas;
    private javax.swing.JPanel pnlPeriodos;
    private javax.swing.JTextField txtFechaFinMacro;
    private javax.swing.JTextField txtFechaInicioMacro;
    private javax.swing.JTextField txtNumSemanasCompetitivo;
    private javax.swing.JTextField txtNumSemanasEspecial;
    private javax.swing.JTextField txtNumSemanasGeneral;
    private javax.swing.JTextField txtNumSemanasMacro;
    private javax.swing.JTextField txtNumSemanasPreparatorio;
    private javax.swing.JTextField txtPorcientoCompetitivo;
    private javax.swing.JTextField txtPorcientoEspecial;
    private javax.swing.JTextField txtPorcientoGeneral;
    private javax.swing.JTextField txtPorcientoPreparatorio;
    // End of variables declaration//GEN-END:variables
}
