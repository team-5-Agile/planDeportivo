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
            modeloTablaEtapaGeneral.setRowCount(9);
            for (Medio medio : mediosEtapaGeneral) {
                Object[] filaNueva = {
                    medio.getMinimo(),
                    medio.getMaximo(),
                    medio.getPromedio(),
                    medio.getInsitaciones(),
                    medio.getVolumenEtapa()
                };
                modeloTablaEtapaGeneral.addRow(filaNueva);
            }
            Validaciones.centrarTabla(tblEtapaGeneral);
        }
    }

    public void llenarTablaEtapaEspecial(List<Medio> mediosEtapaEspecial) {
        if (!mediosEtapaEspecial.isEmpty()) {
            DefaultTableModel modeloTablaEtapaEspecial = (DefaultTableModel) this.tblEtapaEspecial.getModel();
            modeloTablaEtapaEspecial.setRowCount(9);
            for (Medio medio : mediosEtapaEspecial) {
                Object[] filaNueva = {
                    medio.getMinimo(),
                    medio.getMaximo(),
                    medio.getPromedio(),
                    medio.getInsitaciones(),
                    medio.getVolumenEtapa()
                };
                modeloTablaEtapaEspecial.addRow(filaNueva);
            }
            Validaciones.centrarTabla(tblEtapaEspecial);
        }
    }

    public void llenarTablaEtapaCompetitiva(List<Medio> mediosEtapaCompetitiva) {
        if (!mediosEtapaCompetitiva.isEmpty()) {
            DefaultTableModel modeloTablaEtapaCompetitiva = (DefaultTableModel) this.tblEtapaCompetitiva.getModel();
            modeloTablaEtapaCompetitiva.setRowCount(9);
            for (Medio medio : mediosEtapaCompetitiva) {
                Object[] filaNueva = {
                    medio.getMinimo(),
                    medio.getMaximo(),
                    medio.getPromedio(),
                    medio.getInsitaciones(),
                    medio.getVolumenEtapa()
                };
                modeloTablaEtapaCompetitiva.addRow(filaNueva);
            }
            Validaciones.centrarTabla(tblEtapaGeneral);
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
        lblFlexibilidad = new javax.swing.JLabel();
        lblSemanasGeneral = new javax.swing.JLabel();
        lblNumSemanasGeneral = new javax.swing.JLabel();
        lblSemanasEspecial = new javax.swing.JLabel();
        lblNumSemanasEspecial = new javax.swing.JLabel();
        lblRAG = new javax.swing.JLabel();
        lblRAE = new javax.swing.JLabel();
        lblVelGeneral = new javax.swing.JLabel();
        lblVelEspecial = new javax.swing.JLabel();
        lblResVelGen = new javax.swing.JLabel();
        lblResVelEsp = new javax.swing.JLabel();
        lblFuerzaGen = new javax.swing.JLabel();
        lblFuerzaEsp = new javax.swing.JLabel();
        lblCoordTecn = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 734, Short.MAX_VALUE)
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

        lblFlexibilidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFlexibilidad.setText("Flexibilidad (min)");

        lblSemanasGeneral.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSemanasGeneral.setText("Semanas:");

        lblNumSemanasGeneral.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumSemanasGeneral.setText("##");

        lblSemanasEspecial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSemanasEspecial.setText("Semanas:");

        lblNumSemanasEspecial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumSemanasEspecial.setText("##");

        lblRAG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRAG.setText("RAG (km)");

        lblRAE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRAE.setText("RAE (min)");

        lblVelGeneral.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVelGeneral.setText("Vel. General (mtros)");

        lblVelEspecial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVelEspecial.setText("Vel. Especial (seg)");

        lblResVelGen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblResVelGen.setText("Res. Vel. Gen. (mtros)");

        lblResVelEsp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblResVelEsp.setText("Res. Vel. Esp. (min)");

        lblFuerzaGen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFuerzaGen.setText("Fuerza Gen. (rep)");

        lblFuerzaEsp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFuerzaEsp.setText("Fuerza Esp. (rep)");

        lblCoordTecn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCoordTecn.setText("Coord. Tecn. (rep)");

        pnlFrame.setBackground(new java.awt.Color(0, 0, 0));

        pnlGeneral.setBackground(new java.awt.Color(51, 153, 0));

        tblEtapaGeneral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEtapaGeneral.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblEtapaGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)}
            },
            new String [] {
                "Min.", "Max.", "Prom.", "Ins.", "Vol."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(94, 94, 94))
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlEspecial.setBackground(new java.awt.Color(255, 204, 51));

        jLabel3.setBackground(new java.awt.Color(0, 153, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Etapa Especial");

        tblEtapaEspecial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEtapaEspecial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblEtapaEspecial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)}
            },
            new String [] {
                "Min.", "Max.", "Prom.", "Ins.", "Vol."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEspecialLayout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(89, 89, 89))
        );
        pnlEspecialLayout.setVerticalGroup(
            pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEspecialLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlCompetitiva.setBackground(new java.awt.Color(255, 51, 51));

        jLabel4.setBackground(new java.awt.Color(0, 153, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Etapa Competitiva");

        tblEtapaCompetitiva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEtapaCompetitiva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblEtapaCompetitiva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)},
                {null, null,  new Double(0.0), null,  new Double(0.0)}
            },
            new String [] {
                "Min.", "Max.", "Prom.", "Ins.", "Vol."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true, false
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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCompetitivaLayout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(60, 60, 60))
        );
        pnlCompetitivaLayout.setVerticalGroup(
            pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCompetitivaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlFrameLayout = new javax.swing.GroupLayout(pnlFrame);
        pnlFrame.setLayout(pnlFrameLayout);
        pnlFrameLayout.setHorizontalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFrameLayout.setVerticalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGeneral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(20, 20, 20)
                .addComponent(btnVerEtapas, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerMicrociclos)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSemanasCompetitiva)
                .addGap(6, 6, 6)
                .addComponent(lblNumSemanasCompetitiva)
                .addGap(111, 111, 111))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(299, 299, 299)
                            .addComponent(lblSemanasGeneral)
                            .addGap(6, 6, 6)
                            .addComponent(lblNumSemanasGeneral)
                            .addGap(228, 228, 228)
                            .addComponent(lblSemanasEspecial)
                            .addGap(6, 6, 6)
                            .addComponent(lblNumSemanasEspecial)
                            .addGap(457, 457, 457))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addComponent(lblRAE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(lblVelGeneral))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(lblVelEspecial))
                                    .addComponent(lblResVelGen)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(lblFuerzaGen))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(lblFuerzaEsp))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(lblCoordTecn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(lblFlexibilidad))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(lblResVelEsp)))
                                .addComponent(lblRAG))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSemanasCompetitiva)
                    .addComponent(lblNumSemanasCompetitiva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerMicrociclos)
                    .addComponent(btnVerEtapas))
                .addGap(15, 15, 15))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(118, 118, 118)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblSemanasGeneral)
                        .addComponent(lblNumSemanasGeneral)
                        .addComponent(lblSemanasEspecial)
                        .addComponent(lblNumSemanasEspecial))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(73, 73, 73)
                            .addComponent(lblRAG)
                            .addGap(2, 2, 2)
                            .addComponent(lblRAE)
                            .addGap(0, 0, 0)
                            .addComponent(lblVelGeneral)
                            .addGap(0, 0, 0)
                            .addComponent(lblVelEspecial)
                            .addGap(0, 0, 0)
                            .addComponent(lblResVelGen)
                            .addGap(0, 0, 0)
                            .addComponent(lblResVelEsp)
                            .addGap(0, 0, 0)
                            .addComponent(lblFuerzaGen)
                            .addGap(0, 0, 0)
                            .addComponent(lblFuerzaEsp)
                            .addGap(0, 0, 0)
                            .addComponent(lblCoordTecn)
                            .addGap(0, 0, 0)
                            .addComponent(lblFlexibilidad)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pnlFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(61, Short.MAX_VALUE)))))
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
    private javax.swing.JLabel lblCoordTecn;
    private javax.swing.JLabel lblDeporteTitulo;
    private javax.swing.JPanel lblEncabezadoMacro;
    private javax.swing.JPanel lblEncabezadoTitulo;
    private javax.swing.JLabel lblFlexibilidad;
    private javax.swing.JLabel lblFuerzaEsp;
    private javax.swing.JLabel lblFuerzaGen;
    private javax.swing.JLabel lblGuion1;
    private javax.swing.JLabel lblGuion2;
    private javax.swing.JLabel lblIDTitulo;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblNumSemanasCompetitiva;
    private javax.swing.JLabel lblNumSemanasEspecial;
    private javax.swing.JLabel lblNumSemanasGeneral;
    private javax.swing.JLabel lblRAE;
    private javax.swing.JLabel lblRAG;
    private javax.swing.JLabel lblRamaTitulo;
    private javax.swing.JLabel lblResVelEsp;
    private javax.swing.JLabel lblResVelGen;
    private javax.swing.JLabel lblSemanasCompetitiva;
    private javax.swing.JLabel lblSemanasEspecial;
    private javax.swing.JLabel lblSemanasGeneral;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblVelEspecial;
    private javax.swing.JLabel lblVelGeneral;
    private javax.swing.JPanel pnlCompetitiva;
    private javax.swing.JPanel pnlEspecial;
    private javax.swing.JPanel pnlFrame;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JTable tblEtapaCompetitiva;
    private javax.swing.JTable tblEtapaEspecial;
    private javax.swing.JTable tblEtapaGeneral;
    // End of variables declaration//GEN-END:variables
}
