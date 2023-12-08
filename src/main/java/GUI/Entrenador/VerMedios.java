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
import Dominio.Medio;
import Herramientas.Fecha;
import Herramientas.Validaciones;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brawun
 */
public class VerMedios extends javax.swing.JFrame {

    Integer totalSemanasMacrociclo;
    Entrenador entrenador;
    Macrociclo macrociclo;
    Etapa etapaGeneral;
    Etapa etapaEspecial;
    Etapa etapaCompetitiva;
    MediosDAO MediosDAO = new MediosDAO("AppPlanU");
    EtapasDAO EtapasDAO = new EtapasDAO("AppPlanU");
    MacrociclosDAO MacrociclosDAO = new MacrociclosDAO("AppPlanU");
    Validaciones Validaciones = new Validaciones();
    Fecha Fecha = new Fecha();

    /**
     * Creates new form VerMedios
     */
    public VerMedios(Entrenador entrenador, Macrociclo macrociclo, Etapa etapaGeneral, Etapa etapaEspecial, Etapa etapaCompetitiva, Integer totalSemanasMacrociclo) throws ParseException, Exception {
        this.entrenador = entrenador;
        this.macrociclo = macrociclo;
        this.etapaGeneral = etapaGeneral;
        this.etapaEspecial = etapaEspecial;
        this.etapaCompetitiva = etapaCompetitiva;
        this.totalSemanasMacrociclo = totalSemanasMacrociclo;
        initComponents();
        llenarTextos();
        llenarTablaEtapaGeneral(MediosDAO.consultarMediosEtapa(this.etapaGeneral));
        llenarTablaEtapaEspecial(MediosDAO.consultarMediosEtapa(this.etapaEspecial));
        llenarTablaEtapaCompetitiva(MediosDAO.consultarMediosEtapa(this.etapaCompetitiva));
    }

    public void llenarTextos() throws ParseException {
        // Insercion de titulo
        this.lblDeporteTitulo.setText(this.macrociclo.getDeporte());
        this.lblRamaTitulo.setText(this.macrociclo.getRama().name());
        this.lblIDTitulo.setText(this.macrociclo.getId().toString());
        // Insercion numero de semanas por etapa
        this.lblNumSemanasGeneral.setText(this.etapaGeneral.getDuracionSemanas().toString());
        this.lblNumSemanasEspecial.setText(this.etapaEspecial.getDuracionSemanas().toString());
        this.lblNumSemanasCompetitiva.setText(this.etapaCompetitiva.getDuracionSemanas().toString());
    }

    public void llenarTablaEtapaGeneral(List<Medio> mediosEtapaGeneral) {
        if (!mediosEtapaGeneral.isEmpty()) {
            DefaultTableModel modeloTablaEtapaGeneral = (DefaultTableModel) this.tblEtapaGeneral.getModel();
            modeloTablaEtapaGeneral.setRowCount(10);
            for (Medio medio : mediosEtapaGeneral) {
                Object[] filaNueva = {
                    medio.getTipoMedio().toString(),
                    medio.getTipo().toString(),
                    medio.getMinimo(),
                    medio.getMaximo(),
                    medio.getPromedio(),
                    medio.getInsitaciones(),
                    medio.getVolumenEtapa()
                };
                modeloTablaEtapaGeneral.addRow(filaNueva);
            }
            Validaciones.eliminarFilasVacias(tblEtapaGeneral);
            Validaciones.centrarTabla(tblEtapaGeneral);
        }
    }

    public void llenarTablaEtapaEspecial(List<Medio> mediosEtapaEspecial) {
        if (!mediosEtapaEspecial.isEmpty()) {
            DefaultTableModel modeloTablaEtapaEspecial = (DefaultTableModel) this.tblEtapaEspecial.getModel();
            modeloTablaEtapaEspecial.setRowCount(10);
            for (Medio medio : mediosEtapaEspecial) {
                Object[] filaNueva = {
                    medio.getTipoMedio().toString(),
                    medio.getTipo().toString(),
                    medio.getMinimo(),
                    medio.getMaximo(),
                    medio.getPromedio(),
                    medio.getInsitaciones(),
                    medio.getVolumenEtapa()
                };
                modeloTablaEtapaEspecial.addRow(filaNueva);
            }
            Validaciones.eliminarFilasVacias(tblEtapaEspecial);
            Validaciones.centrarTabla(tblEtapaEspecial);
        }
    }

    public void llenarTablaEtapaCompetitiva(List<Medio> mediosEtapaCompetitiva) {
        if (!mediosEtapaCompetitiva.isEmpty()) {
            DefaultTableModel modeloTablaEtapaCompetitiva = (DefaultTableModel) this.tblEtapaCompetitiva.getModel();
            modeloTablaEtapaCompetitiva.setRowCount(10);
            for (Medio medio : mediosEtapaCompetitiva) {
                Object[] filaNueva = {
                    medio.getTipoMedio().toString(),
                    medio.getTipo().toString(),
                    medio.getMinimo(),
                    medio.getMaximo(),
                    medio.getPromedio(),
                    medio.getInsitaciones(),
                    medio.getVolumenEtapa()
                };
                modeloTablaEtapaCompetitiva.addRow(filaNueva);
            }
            Validaciones.eliminarFilasVacias(tblEtapaCompetitiva);
            Validaciones.centrarTabla(tblEtapaCompetitiva);
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
        lblEncabezadoMacro = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblGuion1 = new javax.swing.JLabel();
        lblGuion2 = new javax.swing.JLabel();
        lblRamaTitulo = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        lblDeporteTitulo = new javax.swing.JLabel();
        lblIDTitulo = new javax.swing.JLabel();
        btnVerMicrociclos = new javax.swing.JButton();
        btnVerEtapas = new javax.swing.JButton();
        lblSemanasGeneral = new javax.swing.JLabel();
        lblNumSemanasGeneral = new javax.swing.JLabel();
        lblSemanasEspecial = new javax.swing.JLabel();
        lblNumSemanasEspecial = new javax.swing.JLabel();
        pnlFrame = new javax.swing.JPanel();
        pnlGeneral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEtapaGeneral = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        pnlEspecial = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEtapaEspecial = new javax.swing.JTable();
        pnlCompetitiva = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEtapaCompetitiva = new javax.swing.JTable();
        lblNumSemanasCompetitiva = new javax.swing.JLabel();
        lblSemanasCompetitiva = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ver Medios");
        setResizable(false);

        lblEncabezadoTitulo.setBackground(new java.awt.Color(98, 142, 255));

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo1.setText("Medios del Macrociclo");

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

        lblEncabezadoMacro.setBackground(new java.awt.Color(217, 217, 217));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Ver Medios");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        btnVerMicrociclos.setBackground(new java.awt.Color(153, 153, 255));
        btnVerMicrociclos.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnVerMicrociclos.setText("Ver Microciclos");
        btnVerMicrociclos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerMicrociclos.setOpaque(true);
        btnVerMicrociclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMicrociclosActionPerformed(evt);
            }
        });

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

        lblSemanasGeneral.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSemanasGeneral.setText("Semanas:");

        lblNumSemanasGeneral.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumSemanasGeneral.setText("##");

        lblSemanasEspecial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSemanasEspecial.setText("Semanas:");

        lblNumSemanasEspecial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumSemanasEspecial.setText("##");

        pnlGeneral.setBackground(new java.awt.Color(51, 153, 0));

        tblEtapaGeneral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEtapaGeneral.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        tblEtapaGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Unidad", "Min.", "Max.", "Prom.", "Ins.", "Vol."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
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
        jScrollPane1.setViewportView(tblEtapaGeneral);

        jLabel2.setBackground(new java.awt.Color(0, 153, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Etapa General");

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pnlEspecial.setBackground(new java.awt.Color(255, 204, 51));

        jLabel3.setBackground(new java.awt.Color(0, 153, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Etapa Especial");

        tblEtapaEspecial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEtapaEspecial.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        tblEtapaEspecial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Unidad", "Min.", "Max.", "Prom.", "Ins.", "Vol."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
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
        jScrollPane2.setViewportView(tblEtapaEspecial);

        javax.swing.GroupLayout pnlEspecialLayout = new javax.swing.GroupLayout(pnlEspecial);
        pnlEspecial.setLayout(pnlEspecialLayout);
        pnlEspecialLayout.setHorizontalGroup(
            pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEspecialLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(149, 149, 149))
        );
        pnlEspecialLayout.setVerticalGroup(
            pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEspecialLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pnlCompetitiva.setBackground(new java.awt.Color(255, 51, 51));

        jLabel4.setBackground(new java.awt.Color(0, 153, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Etapa Competitiva");

        tblEtapaCompetitiva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEtapaCompetitiva.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        tblEtapaCompetitiva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Unidad", "Min.", "Max.", "Prom.", "Ins.", "Vol."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
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
        jScrollPane3.setViewportView(tblEtapaCompetitiva);

        javax.swing.GroupLayout pnlCompetitivaLayout = new javax.swing.GroupLayout(pnlCompetitiva);
        pnlCompetitiva.setLayout(pnlCompetitivaLayout);
        pnlCompetitivaLayout.setHorizontalGroup(
            pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCompetitivaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(126, 126, 126))
        );
        pnlCompetitivaLayout.setVerticalGroup(
            pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCompetitivaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout pnlFrameLayout = new javax.swing.GroupLayout(pnlFrame);
        pnlFrame.setLayout(pnlFrameLayout);
        pnlFrameLayout.setHorizontalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrameLayout.createSequentialGroup()
                .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(pnlEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlFrameLayout.setVerticalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        lblNumSemanasCompetitiva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumSemanasCompetitiva.setText("##");

        lblSemanasCompetitiva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSemanasCompetitiva.setText("Semanas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(lblSemanasGeneral)
                .addGap(6, 6, 6)
                .addComponent(lblNumSemanasGeneral)
                .addGap(340, 340, 340)
                .addComponent(lblSemanasEspecial)
                .addGap(6, 6, 6)
                .addComponent(lblNumSemanasEspecial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSemanasCompetitiva)
                .addGap(6, 6, 6)
                .addComponent(lblNumSemanasCompetitiva)
                .addGap(171, 171, 171))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVerEtapas, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerMicrociclos)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSemanasGeneral)
                    .addComponent(lblNumSemanasGeneral)
                    .addComponent(lblSemanasEspecial)
                    .addComponent(lblNumSemanasEspecial)
                    .addComponent(lblSemanasCompetitiva)
                    .addComponent(lblNumSemanasCompetitiva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerMicrociclos)
                    .addComponent(btnVerEtapas))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerMicrociclosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMicrociclosActionPerformed
        try {
            this.dispose();
            new VerMicrociclos(this.entrenador, this.macrociclo, this.etapaGeneral, this.etapaEspecial, this.etapaCompetitiva, this.totalSemanasMacrociclo).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(VerMacrociclo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVerMicrociclosActionPerformed

    private void btnVerEtapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEtapasActionPerformed
        this.dispose();
        try {
            new VerEtapas(this.entrenador, this.macrociclo).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(VerMacrociclo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVerEtapasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerEtapas;
    private javax.swing.JButton btnVerMicrociclos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDeporteTitulo;
    private javax.swing.JPanel lblEncabezadoMacro;
    private javax.swing.JPanel lblEncabezadoTitulo;
    private javax.swing.JLabel lblGuion1;
    private javax.swing.JLabel lblGuion2;
    private javax.swing.JLabel lblIDTitulo;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblNumSemanasCompetitiva;
    private javax.swing.JLabel lblNumSemanasEspecial;
    private javax.swing.JLabel lblNumSemanasGeneral;
    private javax.swing.JLabel lblRamaTitulo;
    private javax.swing.JLabel lblSemanasCompetitiva;
    private javax.swing.JLabel lblSemanasEspecial;
    private javax.swing.JLabel lblSemanasGeneral;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel pnlCompetitiva;
    private javax.swing.JPanel pnlEspecial;
    private javax.swing.JPanel pnlFrame;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JTable tblEtapaCompetitiva;
    private javax.swing.JTable tblEtapaEspecial;
    private javax.swing.JTable tblEtapaGeneral;
    // End of variables declaration//GEN-END:variables
}
