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
import Enumeradores.TipoMedio;
import Enumeradores.Unidades;
import Herramientas.Fecha;
import Herramientas.Validaciones;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brawun
 */
public class Paso3Medios extends javax.swing.JFrame {

    Entrenador entrenador;
    Macrociclo macrociclo;
    Etapa etapaGeneral;
    Etapa etapaEspecial;
    Etapa etapaCompetitiva;
    TipoMedio RAG, RAE, VEL_GENERAL,VEL_ESPECIAL,RES_VEL_ESP,RES_VEL_GEN,TipoMedio,FUERZA_GEN,FUERZA_ESP,COORD_TECN,FLEXIBILIDAD;
    Unidades KM, MIN, MTROS, SEG, REP;
    MediosDAO MediosDAO = new MediosDAO("AppPlanU");
    EtapasDAO EtapasDAO = new EtapasDAO("AppPlanU");
    MacrociclosDAO MacrociclosDAO = new MacrociclosDAO("AppPlanU");
    Fecha Fecha = new Fecha();

    /**
     * Creates new form Paso3Medios
     */
    public Paso3Medios(Entrenador entrenador, Macrociclo macrociclo, Etapa etapaGen, Etapa etapaEsp, Etapa etapaCom) throws ParseException {
        this.entrenador = entrenador;
        this.macrociclo = macrociclo;
        this.etapaGeneral = etapaGen;
        this.etapaEspecial = etapaEsp;
        this.etapaCompetitiva = etapaCom;
        initComponents();
        llenarTextos();
    }

    public void llenarTextos() throws ParseException {
        // Insercion de titulo
        this.lblFechaHoy.setText(Fecha.formatoFecha(Fecha.fechaAhora()));
        this.lblDeporte.setText(this.macrociclo.getDeporte());
        this.lblRama.setText(this.macrociclo.getRama().name());
        this.lblID.setText(this.macrociclo.getId().toString());
        // Insercion numero de semanas por etapa
        this.lblNumSemanasGeneral.setText(this.etapaGeneral.getDuracionSemanas().toString());
        this.lblNumSemanasEspecial.setText(this.etapaEspecial.getDuracionSemanas().toString());
        this.lblNumSemanasCompetitiva.setText(this.etapaCompetitiva.getDuracionSemanas().toString());
    }
    private List<Medio> registrarGeneral(){
        List<Medio> lista = null;
        int minimo, maximo,insitaciones;
        float promedio, volumen;
        Medio medio =new Medio();
        Validaciones va= new Validaciones();
        for (int col = 0; col < 10; col++) {
            try{
            medio=eleccionNum(medio, col);
            String[] rowData1;
            rowData1 = extraerRow(tblEtapaGeneral, 0);
            minimo=Integer.parseInt(rowData1[0]);
            if(va.validarMedio(minimo)){}
            medio.setMinimo(minimo);
            maximo=Integer.parseInt(rowData1[1]);
            if(va.validarMedio(maximo)){}
            medio.setMaximo(maximo);
            promedio = (float)((Integer.parseInt(rowData1[0])+(Integer.parseInt(rowData1[1]))/2));
            medio.setPromedio(promedio);
            insitaciones=Integer.parseInt(rowData1[3]);
            medio.setInsitaciones(insitaciones);
            volumen= (float)(promedio*(Integer.parseInt(rowData1[3]))*this.etapaGeneral.getDuracionSemanas());
            medio.setVolumenEtapa(volumen);
            medio.setEtapas(etapaGeneral);
            lista.add(medio);
            return lista;
            }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
        }
        return lista;
    }
    private List<Medio> registrarEspecial(){
        List<Medio> lista = null;
        int minimo, maximo,insitaciones;
        float promedio, volumen;
        Medio medio =new Medio();
        Validaciones va= new Validaciones();
        for (int col = 0; col < 10; col++) {
            try{
            medio=eleccionNum(medio, col);
            String[] rowData1;
            rowData1 = extraerRow(tblEtapaEspecial, 0);
            minimo=Integer.parseInt(rowData1[0]);
            if(va.validarMedio(minimo)){}
            medio.setMinimo(minimo);
            maximo=Integer.parseInt(rowData1[1]);
            if(va.validarMedio(maximo)){}
            medio.setMaximo(maximo);
            promedio = (float)((Integer.parseInt(rowData1[0])+(Integer.parseInt(rowData1[1]))/2));
            medio.setPromedio(promedio);
            insitaciones=Integer.parseInt(rowData1[3]);
            medio.setInsitaciones(insitaciones);
            volumen= (float)(promedio*(Integer.parseInt(rowData1[3]))*this.etapaEspecial.getDuracionSemanas());
            medio.setVolumenEtapa(volumen);
            medio.setEtapas(etapaEspecial);
            lista.add(medio);
            return lista;
            }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
        }
        return lista;
    }
    private List<Medio> registrarCompetitiva(){
        List<Medio> lista = null;
        int minimo, maximo,insitaciones;
        float promedio, volumen;
        Medio medio =new Medio();
        Validaciones va= new Validaciones();
        for (int col = 0; col < 10; col++) {
            try{
            medio=eleccionNum(medio, col);
            String[] rowData1;
            rowData1 = extraerRow(tblEtapaCompetitiva, 0);
            minimo=Integer.parseInt(rowData1[0]);
            if(va.validarMedio(minimo)){}
            medio.setMinimo(minimo);
            maximo=Integer.parseInt(rowData1[1]);
            if(va.validarMedio(maximo)){}
            medio.setMaximo(maximo);
            promedio = (float)((Integer.parseInt(rowData1[0])+(Integer.parseInt(rowData1[1]))/2));
            medio.setPromedio(promedio);
            insitaciones=Integer.parseInt(rowData1[3]);
            medio.setInsitaciones(insitaciones);
            volumen= (float)(promedio*(Integer.parseInt(rowData1[3]))*this.etapaCompetitiva.getDuracionSemanas());
            medio.setVolumenEtapa(volumen);
            medio.setEtapas(etapaCompetitiva);
            lista.add(medio);
            return lista;
            }catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
        }
        return lista;
    }
    private Medio eleccionNum(Medio medio, int col){
            
            TipoMedio tipoMedio;
            Unidades unidad;
        switch (col+1) {
            case 1:
               medio.setTipoMedio(RAG);
               medio.setTipo(KM);
                return medio;
            case 2:
               medio.setTipoMedio(RAE);
               medio.setTipo(MIN);
                return medio;
            case 3:
                medio.setTipo(MTROS);
                medio.setTipoMedio(VEL_GENERAL);
                return medio;
            case 4:
                medio.setTipoMedio(VEL_ESPECIAL);
                medio.setTipo(SEG);
                return medio;
            case 5:
                medio.setTipoMedio(RES_VEL_ESP);
                medio.setTipo(MTROS);
                return medio;
            case 6:
                medio.setTipoMedio(RES_VEL_GEN);
                medio.setTipo(MIN);
                return medio;
            case 7:
                medio.setTipoMedio(FUERZA_GEN);
                medio.setTipo(REP);
                return medio;
            case 8:
                medio.setTipoMedio(FUERZA_ESP);
                medio.setTipo(REP);
                return medio;
            case 9:
                medio.setTipoMedio(COORD_TECN);
                medio.setTipo(REP);
                return medio;
            case 10:
                medio.setTipoMedio(FLEXIBILIDAD);
                medio.setTipo(MIN);
                return medio;
        }
        return null;
    }
    private void registrarMedios(){
        List<Medio> listaGeneral= registrarGeneral();
        List<Medio> listaEspecial=registrarEspecial();
        List<Medio> listaCompetitiva=registrarCompetitiva();
        for (Medio medio : listaGeneral) {
                MediosDAO.registrarMedio(medio);
            }
        for (Medio medio : listaEspecial) {
                MediosDAO.registrarMedio(medio);
            }
        for (Medio medio : listaCompetitiva) {
                MediosDAO.registrarMedio(medio);
            }
        
    }

     private String[] extraerRow(JTable table, int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int colCount = model.getColumnCount();
        String[] rowData = new String[colCount];

        for (int col = 0; col < colCount; col++) {
            Object value = model.getValueAt(rowIndex, col);
            rowData[col] = value != null ? value.toString() : "";
        }

        return rowData;
    }


    public boolean verificarCamposVacios() {
        return true;
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
        lblDeporte = new javax.swing.JLabel();
        lblRama = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        lblGuion1 = new javax.swing.JLabel();
        lblGuion2 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblRAG = new javax.swing.JLabel();
        lblRAE = new javax.swing.JLabel();
        lblVelGeneral = new javax.swing.JLabel();
        lblVelEspecial = new javax.swing.JLabel();
        lblResVelGen = new javax.swing.JLabel();
        lblResVelEsp = new javax.swing.JLabel();
        lblFuerzaGen = new javax.swing.JLabel();
        lblFuerzaEsp = new javax.swing.JLabel();
        lblCoordTecn = new javax.swing.JLabel();
        lblFlexibilidad = new javax.swing.JLabel();
        lblSemanasGeneral = new javax.swing.JLabel();
        lblSemanasCompetitiva = new javax.swing.JLabel();
        lblSemanasEspecial = new javax.swing.JLabel();
        lblNumSemanasGeneral = new javax.swing.JLabel();
        lblNumSemanasEspecial = new javax.swing.JLabel();
        lblNumSemanasCompetitiva = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Seleccionador de Medios");
        setResizable(false);

        lblEncabezadoTitulo.setBackground(new java.awt.Color(98, 142, 255));
        lblEncabezadoTitulo.setPreferredSize(new java.awt.Dimension(750, 50));

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo1.setText("Paso #3: Selección de Medios");

        lblFechaHoy.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        lblFechaHoy.setText("Fecha Hoy");

        javax.swing.GroupLayout lblEncabezadoTituloLayout = new javax.swing.GroupLayout(lblEncabezadoTitulo);
        lblEncabezadoTitulo.setLayout(lblEncabezadoTituloLayout);
        lblEncabezadoTituloLayout.setHorizontalGroup(
            lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFechaHoy)
                .addGap(27, 27, 27))
        );
        lblEncabezadoTituloLayout.setVerticalGroup(
            lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoTituloLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(lblEncabezadoTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo1)
                    .addComponent(lblFechaHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEncabezadoMacro.setBackground(new java.awt.Color(217, 217, 217));
        lblEncabezadoMacro.setPreferredSize(new java.awt.Dimension(750, 50));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Nuevo Macrociclo");

        lblDeporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDeporte.setText("Deporte");

        lblRama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRama.setText("Rama");

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblID.setText("ID");

        lblNum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNum.setText("#");

        lblGuion1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGuion1.setText("-");

        lblGuion2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblGuion2.setText("-");

        javax.swing.GroupLayout lblEncabezadoMacroLayout = new javax.swing.GroupLayout(lblEncabezadoMacro);
        lblEncabezadoMacro.setLayout(lblEncabezadoMacroLayout);
        lblEncabezadoMacroLayout.setHorizontalGroup(
            lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblEncabezadoMacroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDeporte)
                .addGap(32, 32, 32)
                .addComponent(lblGuion1)
                .addGap(35, 35, 35)
                .addComponent(lblRama)
                .addGap(37, 37, 37)
                .addComponent(lblGuion2)
                .addGap(35, 35, 35)
                .addComponent(lblNum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblID)
                .addGap(39, 39, 39))
        );
        lblEncabezadoMacroLayout.setVerticalGroup(
            lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblEncabezadoMacroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblEncabezadoMacroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDeporte)
                        .addComponent(lblRama)
                        .addComponent(lblID)
                        .addComponent(lblNum)
                        .addComponent(lblGuion1)
                        .addComponent(lblGuion2))
                    .addComponent(lblTitulo))
                .addContainerGap())
        );

        btnFinalizar.setBackground(new java.awt.Color(204, 255, 204));
        btnFinalizar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizar.setOpaque(true);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 153, 153));
        btnCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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

        lblFlexibilidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFlexibilidad.setText("Flexibilidad (min)");

        lblSemanasGeneral.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSemanasGeneral.setText("Semanas:");

        lblSemanasCompetitiva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSemanasCompetitiva.setText("Semanas:");

        lblSemanasEspecial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSemanasEspecial.setText("Semanas:");

        lblNumSemanasGeneral.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumSemanasGeneral.setText("##");

        lblNumSemanasEspecial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumSemanasEspecial.setText("##");

        lblNumSemanasCompetitiva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumSemanasCompetitiva.setText("##");

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
        jScrollPane1.setViewportView(tblEtapaGeneral);

        jLabel2.setBackground(new java.awt.Color(0, 153, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Etapa General");

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlFrameLayout = new javax.swing.GroupLayout(pnlFrame);
        pnlFrame.setLayout(pnlFrameLayout);
        pnlFrameLayout.setHorizontalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(pnlCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFrameLayout.setVerticalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addComponent(pnlCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addComponent(pnlEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1233, Short.MAX_VALUE)
            .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.DEFAULT_SIZE, 1233, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnCancelar))
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
                            .addComponent(lblRAG))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(pnlFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSemanasGeneral)
                        .addGap(6, 6, 6)
                        .addComponent(lblNumSemanasGeneral)
                        .addGap(228, 228, 228)
                        .addComponent(lblSemanasEspecial)
                        .addGap(6, 6, 6)
                        .addComponent(lblNumSemanasEspecial)
                        .addGap(230, 230, 230)
                        .addComponent(lblSemanasCompetitiva)
                        .addGap(6, 6, 6)
                        .addComponent(lblNumSemanasCompetitiva)
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnFinalizar)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSemanasGeneral)
                    .addComponent(lblNumSemanasGeneral)
                    .addComponent(lblSemanasEspecial)
                    .addComponent(lblNumSemanasEspecial)
                    .addComponent(lblSemanasCompetitiva)
                    .addComponent(lblNumSemanasCompetitiva))
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
                        .addComponent(lblFlexibilidad))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar)
                    .addComponent(btnCancelar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (verificarCamposVacios()) {
            registrarMedios(); // Generar los medios y relacionarlos a cada etapa 
            this.dispose(); // Se cierra la ventana actual
            try {
                // Se abre el panel de entrenador
                new PanelEntrenador(entrenador).setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(Paso3Medios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Si algún campo está vacío, se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Ningún campo de registro puede estar vacío.", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cancelar el registro? (Toda información relacionada a este macrociclo será eliminada)", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
            try {
                MacrociclosDAO.eliminarMacrociclo(this.macrociclo.getId());
                new PanelEntrenador(this.entrenador).setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(Paso1Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCoordTecn;
    private javax.swing.JLabel lblDeporte;
    private javax.swing.JPanel lblEncabezadoMacro;
    private javax.swing.JPanel lblEncabezadoTitulo;
    private javax.swing.JLabel lblFechaHoy;
    private javax.swing.JLabel lblFlexibilidad;
    private javax.swing.JLabel lblFuerzaEsp;
    private javax.swing.JLabel lblFuerzaGen;
    private javax.swing.JLabel lblGuion1;
    private javax.swing.JLabel lblGuion2;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblNumSemanasCompetitiva;
    private javax.swing.JLabel lblNumSemanasEspecial;
    private javax.swing.JLabel lblNumSemanasGeneral;
    private javax.swing.JLabel lblRAE;
    private javax.swing.JLabel lblRAG;
    private javax.swing.JLabel lblRama;
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
