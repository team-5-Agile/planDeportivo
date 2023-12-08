/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Entrenador;

import DAOs.EtapasDAO;
import DAOs.MacrociclosDAO;
import Dominio.Entrenador;
import Dominio.Etapa;
import Dominio.Macrociclo;
import Enumeradores.TipoEtapa;
import Herramientas.Fecha;
import Herramientas.Porcentajes;
import Herramientas.Validaciones;
import java.awt.Frame;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author el_fr
 */
public class Paso2Proporciones extends javax.swing.JFrame {

    Entrenador entrenador;
    Macrociclo macrociclo;
    Etapa etapaGeneral;
    Etapa etapaEspecial;
    Etapa etapaCompetitiva;
    EtapasDAO EtapasDAO = new EtapasDAO("AppPlanU");
    MacrociclosDAO MacrociclosDAO = new MacrociclosDAO("AppPlanU");
    Fecha Fecha = new Fecha();
    Porcentajes Porcentajes = new Porcentajes();

    /**
     * Creates new form ViewMacrociclo
     */
    public Paso2Proporciones(Entrenador entrenador, Macrociclo macrociclo) throws ParseException {
        this.entrenador = entrenador;
        this.macrociclo = macrociclo;
        initComponents();
        llenarTextos();
        setLocationRelativeTo(null);
    }

    public void llenarTextos() throws ParseException {
        this.lblFechaHoy.setText(Fecha.formatoFecha(Fecha.fechaAhora()));
        this.lblDeporte.setText(this.macrociclo.getDeporte());
        this.lblRama.setText(this.macrociclo.getRama().name());
        this.lblID.setText(this.macrociclo.getId().toString());
        this.txtPorcientoPreparatorio.setText("50");
        this.txtPorcientoCompetitivo.setText("50");
        this.txtPorcientoGeneral.setText("50");
        this.txtPorcientoEspecial.setText("50");
        this.txtNumSemanasMacro.setText("52");
        this.txtNumSemanasCompetitivo.setText("26");
        this.txtNumSemanasPreparatorio.setText("26");
        this.txtNumSemanasGeneral.setText("13");
        this.txtNumSemanasEspecial.setText("13");
    }

    public void insertarFechasMacro() {
        MacrociclosDAO.insertarFechasMacrociclo(this.macrociclo, this.txtFechaInicioMacro.getCalendar(), this.txtFechaFinMacro.getCalendar());
    }

    public void registrarEtapas() {
        Etapa etapaPreparatoriaGeneral;
        Etapa etapaPreparatoriaEspecial;
        Etapa etapaCompetitiva;
        etapaPreparatoriaGeneral = new Etapa(TipoEtapa.GENERAL, Integer.valueOf(this.txtNumSemanasGeneral.getText()), Porcentajes.calcularPorcentaje(this.txtPorcientoPreparatorio.getText(), this.txtPorcientoGeneral.getText()), this.macrociclo);
        etapaPreparatoriaEspecial = new Etapa(TipoEtapa.ESPECIAL, Integer.valueOf(this.txtNumSemanasEspecial.getText()), Porcentajes.calcularPorcentaje(this.txtPorcientoPreparatorio.getText(), this.txtPorcientoEspecial.getText()), this.macrociclo);
        etapaCompetitiva = new Etapa(TipoEtapa.COMPETITIVA, Integer.valueOf(this.txtNumSemanasCompetitivo.getText()), Double.valueOf(this.txtPorcientoCompetitivo.getText()), this.macrociclo);
        Etapa etapaGen = EtapasDAO.registrarEtapa(etapaPreparatoriaGeneral);
        Etapa etapaEsp = EtapasDAO.registrarEtapa(etapaPreparatoriaEspecial);
        Etapa etapaCom = EtapasDAO.registrarEtapa(etapaCompetitiva);
        // Si se registran correctamente todas las etapas
        if (etapaGen.getId() != null
                && etapaEsp.getId() != null
                && etapaCom.getId() != null) {
            this.etapaGeneral = etapaGen;
            this.etapaEspecial = etapaEsp;
            this.etapaCompetitiva = etapaCom;
            // Se muestra un mensaje de éxito con los detalles de las etapas registradas
            JOptionPane.showMessageDialog(null, "Se crearon exitosamente las etapas: "
                    + "\n1.- Etapa General: " + etapaGen.getDuracionSemanas() + " semanas - " + etapaGen.getProporcion() + "% - TIPO " + etapaGen.getTipo() + " - ID: " + etapaGen.getId() + ". ☺"
                    + "\n2.- Etapra Especial: " + etapaEsp.getDuracionSemanas() + " semanas - " + etapaEsp.getProporcion() + "% - TIPO " + etapaEsp.getTipo() + " - ID: " + etapaEsp.getId() + ". ☺"
                    + "\n3.- Etapa Competitiva: " + etapaCom.getDuracionSemanas() + " semanas - " + etapaCom.getProporcion() + "% - TIPO " + etapaCom.getTipo() + " - ID: " + etapaCom.getId() + ". ☺"
                    + "\n Continue al siguiente paso...", "Registro de etapas exitoso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si ocurre un error en el registro, se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Ocurrió un error al querer registrar las etapas.", "¡Error interno!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean verificarCamposVacios() {
        return this.txtFechaFinMacro.getDate() != null
                && this.txtFechaInicioMacro.getDate() != null
                && !this.txtNumSemanasCompetitivo.getText().isBlank()
                && !this.txtNumSemanasEspecial.getText().isBlank()
                && !this.txtNumSemanasGeneral.getText().isBlank()
                && !this.txtNumSemanasMacro.getText().isBlank()
                && !this.txtNumSemanasPreparatorio.getText().isBlank()
                && !this.txtPorcientoCompetitivo.getText().isBlank()
                && !this.txtPorcientoEspecial.getText().isBlank()
                && !this.txtPorcientoGeneral.getText().isBlank()
                && !this.txtPorcientoPreparatorio.getText().isBlank();
    }

    /**
     * Cierra la ventana ConsultarAcentos si está abierta en el sistema.
     */
    public static void cerrarSiAbierto() {
        // Obtiene todas las ventanas activas en el sistema
        Frame[] frames = JFrame.getFrames();

        // Itera sobre las ventanas para encontrar la instancia de ConsultarAcentos
        for (Frame frame : frames) {
            if (frame instanceof ConsultarAcentos) {
                // Cierra la ventana si es una instancia de ConsultarAcentos
                frame.dispose();
            }
        }
    }

    public void validarSemanasMacro() {
        if (Integer.valueOf(this.txtNumSemanasMacro.getText()) > 52) {
            // Mensaje de error
            JOptionPane.showMessageDialog(null, "La duración máxima para un macrociclo es de 52 semanas.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            this.txtNumSemanasMacro.setText("");
        }
    }

    public void validarSemanasEtapas() {
        if (Integer.valueOf(this.txtNumSemanasPreparatorio.getText()) + Integer.valueOf(this.txtNumSemanasCompetitivo.getText()) > 52) {
            // Mensaje de error
            JOptionPane.showMessageDialog(null, "La duración máxima para un macrociclo es de 52 semanas.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            this.txtNumSemanasPreparatorio.setText("");
            this.txtNumSemanasCompetitivo.setText("");
            this.txtNumSemanasMacro.setText("");
        }
    }

    public void validarSemanasSubEtapas() {
        if (Integer.valueOf(this.txtNumSemanasGeneral.getText()) + Integer.valueOf(this.txtNumSemanasEspecial.getText()) != Integer.valueOf(this.txtNumSemanasPreparatorio.getText())) {
            // Mensaje de error
            JOptionPane.showMessageDialog(null, "La duración para las sub-etapas General y Especial tiene que ser igual a la duracion de la Etapa Preparatoria.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            this.txtNumSemanasGeneral.setText("");
            this.txtNumSemanasEspecial.setText("");
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

        jSeparator1 = new javax.swing.JSeparator();
        lblArrow = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        lblFechaFinMacro = new javax.swing.JLabel();
        lblSemanasMacro = new javax.swing.JLabel();
        lblMensajeMacro = new javax.swing.JLabel();
        txtNumSemanasMacro = new javax.swing.JTextField();
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
        jLabel2 = new javax.swing.JLabel();
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
        btnCancelar = new javax.swing.JButton();
        btnConsultarAcentos = new javax.swing.JButton();
        btnCalcularPorcentajesEtapas = new javax.swing.JButton();
        btnCalcularPorcentajesSubetapas = new javax.swing.JButton();
        btnCalcularTotalSemanas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtFechaInicioMacro = new com.toedter.calendar.JDateChooser();
        txtFechaFinMacro = new com.toedter.calendar.JDateChooser();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Seleccionador de Proporciones");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        lblArrow.setText("<----");

        btnSiguiente.setBackground(new java.awt.Color(204, 255, 204));
        btnSiguiente.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSiguiente.setOpaque(true);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        lblFechaFinMacro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFechaFinMacro.setText("Fecha Fin:");

        lblSemanasMacro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSemanasMacro.setText("Semanas");

        txtNumSemanasMacro.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNumSemanasMacro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumSemanasMacroKeyPressed(evt);
            }
        });

        lblDuracionMacro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDuracionMacro.setText("Duracion:");

        lblFechaInicioMacro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFechaInicioMacro.setText("Fecha Incio:");

        txtNumSemanasPreparatorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumSemanasPreparatorioKeyPressed(evt);
            }
        });

        txtNumSemanasCompetitivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumSemanasCompetitivoKeyPressed(evt);
            }
        });

        txtPorcientoPreparatorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcientoPreparatorioKeyPressed(evt);
            }
        });

        txtPorcientoCompetitivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcientoCompetitivoKeyPressed(evt);
            }
        });

        lblPreparatorio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPreparatorio.setText("Preparatorio:");

        lblCompetitivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCompetitivo.setText("Competitivo:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Seleccione la proporción que se");

        lblPorciento3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento3.setText("semanas");

        lblPorciento5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento5.setText("semanas");

        lblPorciento6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento6.setText("% ");

        lblPorciento7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPorciento7.setText("% ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("le asignará a cada periodo:");

        javax.swing.GroupLayout pnlPeriodosLayout = new javax.swing.GroupLayout(pnlPeriodos);
        pnlPeriodos.setLayout(pnlPeriodosLayout);
        pnlPeriodosLayout.setHorizontalGroup(
            pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPeriodosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPeriodosLayout.createSequentialGroup()
                        .addGroup(pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPeriodosLayout.createSequentialGroup()
                                .addComponent(lblPreparatorio)
                                .addGap(11, 11, 11)
                                .addComponent(txtPorcientoPreparatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPeriodosLayout.createSequentialGroup()
                                .addComponent(lblCompetitivo)
                                .addGap(18, 18, 18)
                                .addComponent(txtPorcientoCompetitivo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPeriodosLayout.createSequentialGroup()
                                .addComponent(lblPorciento7)
                                .addGap(12, 12, 12)
                                .addComponent(txtNumSemanasPreparatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPeriodosLayout.createSequentialGroup()
                                .addComponent(lblPorciento6)
                                .addGap(12, 12, 12)
                                .addComponent(txtNumSemanasCompetitivo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPorciento5)
                            .addComponent(lblPorciento3))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPeriodosLayout.createSequentialGroup()
                        .addGroup(pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );
        pnlPeriodosLayout.setVerticalGroup(
            pnlPeriodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPeriodosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlEtapas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtNumSemanasGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumSemanasGeneralKeyPressed(evt);
            }
        });

        txtNumSemanasEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumSemanasEspecialKeyPressed(evt);
            }
        });

        txtPorcientoGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcientoGeneralKeyPressed(evt);
            }
        });

        txtPorcientoEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcientoEspecialKeyPressed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlEtapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGeneral)
                    .addComponent(lbltxt)
                    .addGroup(pnlEtapasLayout.createSequentialGroup()
                        .addGroup(pnlEtapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEspecial)
                            .addComponent(txtPorcientoEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPorcientoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(pnlEtapasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPorciento1)
                            .addComponent(lblPorciento4))
                        .addGap(18, 18, 18)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        btnCancelar.setBackground(new java.awt.Color(255, 153, 153));
        btnCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnConsultarAcentos.setBackground(new java.awt.Color(237, 192, 123));
        btnConsultarAcentos.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnConsultarAcentos.setText("Consultar Acentos");
        btnConsultarAcentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultarAcentos.setOpaque(true);
        btnConsultarAcentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarAcentosActionPerformed(evt);
            }
        });

        btnCalcularPorcentajesEtapas.setBackground(new java.awt.Color(51, 204, 255));
        btnCalcularPorcentajesEtapas.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnCalcularPorcentajesEtapas.setText("Calcular");
        btnCalcularPorcentajesEtapas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcularPorcentajesEtapas.setOpaque(true);
        btnCalcularPorcentajesEtapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPorcentajesEtapasActionPerformed(evt);
            }
        });

        btnCalcularPorcentajesSubetapas.setBackground(new java.awt.Color(51, 204, 255));
        btnCalcularPorcentajesSubetapas.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnCalcularPorcentajesSubetapas.setText("Calcular");
        btnCalcularPorcentajesSubetapas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcularPorcentajesSubetapas.setOpaque(true);
        btnCalcularPorcentajesSubetapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPorcentajesSubetapasActionPerformed(evt);
            }
        });

        btnCalcularTotalSemanas.setBackground(new java.awt.Color(51, 204, 255));
        btnCalcularTotalSemanas.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnCalcularTotalSemanas.setText("Calcular");
        btnCalcularTotalSemanas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcularTotalSemanas.setOpaque(true);
        btnCalcularTotalSemanas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTotalSemanasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Seleccione una fecha inicio ó una fecha fin");

        txtFechaInicioMacro.setToolTipText("Periodo inicio");

        txtFechaFinMacro.setToolTipText("Periodo inicio");

        lblEncabezadoTitulo.setBackground(new java.awt.Color(98, 142, 255));
        lblEncabezadoTitulo.setPreferredSize(new java.awt.Dimension(750, 50));

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo1.setText("Paso #2: Selección de Proporciones");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMensajeMacro)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(520, 520, 520)
                                    .addComponent(btnConsultarAcentos))
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblFechaFinMacro)
                                        .addComponent(lblFechaInicioMacro))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtFechaFinMacro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtFechaInicioMacro, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnCancelar)
                                    .addGap(506, 506, 506)
                                    .addComponent(btnSiguiente))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblDuracionMacro)
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtNumSemanasMacro, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(lblSemanasMacro))
                                            .addComponent(btnCalcularTotalSemanas)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pnlPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblArrow)
                                        .addGap(16, 16, 16)
                                        .addComponent(pnlEtapas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnCalcularPorcentajesEtapas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalcularPorcentajesSubetapas)
                        .addGap(166, 166, 166))))
            .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btnConsultarAcentos)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMensajeMacro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaInicioMacro)
                            .addComponent(txtFechaInicioMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(txtFechaFinMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(lblFechaFinMacro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDuracionMacro)
                                    .addComponent(txtNumSemanasMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSemanasMacro))
                                .addGap(18, 18, 18)
                                .addComponent(btnCalcularTotalSemanas)
                                .addGap(42, 42, 42)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlPeriodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(67, 67, 67)
                                    .addComponent(lblArrow))
                                .addComponent(pnlEtapas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCalcularPorcentajesEtapas)
                            .addComponent(btnCalcularPorcentajesSubetapas))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSiguiente)
                            .addComponent(btnCancelar))
                        .addGap(29, 29, 29))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int calcularSemanas(int total, int can) {
        int re = (can * total) / 100;
        return re;
    }

    private double calcularPorcentaje(int total, int can) {
        double re = (can * 100) / total;
        return re;
    }

    private String rellenarPorcentaje(String valor) {

        try {
            Validaciones val = new Validaciones();
            if (!valor.equals("")) {
                if (val.isPorcentajeValido(Double.parseDouble(valor))) {
                }
                if (val.isNegativo(Double.parseDouble(valor))) {
                }
                return ((100 - Integer.parseInt(valor)) + "");

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }

        return ((100 - Integer.parseInt(valor)) + "");
    }

    private String rellenarSemanas(String valor, String total) {

        try {
            Validaciones val = new Validaciones();
            if (!valor.equals("")) {
                return ((Integer.parseInt(total) - Integer.parseInt(valor)) + "");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }

        return ((100 - Integer.parseInt(valor)) + "");
    }
    private void txtNumSemanasMacroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSemanasMacroKeyPressed
        String fechaInicio = this.txtFechaInicioMacro.getDateFormatString();
        String numSemanas = this.txtNumSemanasMacro.getText();

        char c = evt.getKeyChar();
        // Validar si es un dígito y la longitud actual es menor que 2
        if (!Character.isDigit(c) || txtNumSemanasMacro.getText().length() >= 2) {
            if (c != '\b') {
                if (c != '\b') {
                    evt.consume();  // Ignorar el evento si no es un dígito o la longitud es mayor o igual a 2
                }
            }
        }

        if (evt.getKeyCode() != 10) {
            return;
        }
        try {
            Validaciones val = new Validaciones();
            if (!val.isNumSemanaValido(numSemanas, 32, 52));
            if (!fechaInicio.equals("")) {
                if (!val.isFechaValida(fechaInicio));

                LocalDate fin = val.calcPeriodo(fechaInicio, Integer.valueOf(numSemanas));
                txtFechaFinMacro.setDate(Fecha.convertirLocalDateADate(fin));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }

    }//GEN-LAST:event_txtNumSemanasMacroKeyPressed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        this.btnCalcularTotalSemanasActionPerformed(evt);
        this.btnCalcularPorcentajesEtapasActionPerformed(evt);
        this.btnCalcularPorcentajesSubetapasActionPerformed(evt);
        if (verificarCamposVacios()) {
            cerrarSiAbierto();
            insertarFechasMacro(); //Asignar fechas de inicio y fin a macrociclo
            registrarEtapas(); //Generar las etapas y relacionarlas al macrociclo
            this.dispose(); // Se cierra la ventana actual
            try {
                new Paso3Medios(this.entrenador, this.macrociclo, this.etapaGeneral, this.etapaEspecial, this.etapaCompetitiva).setVisible(true); // Se abre el paso 3
            } catch (Exception ex) {
                Logger.getLogger(Paso2Proporciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Si algún campo está vacío, se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Ningún campo de registro puede estar vacío.", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnConsultarAcentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarAcentosActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "¿Desea visualizar la configuración predeterminada de acentos?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (i == JOptionPane.YES_OPTION) {
            try {
                new ConsultarAcentos(this.entrenador, this.macrociclo).setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(Paso1Registro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnConsultarAcentosActionPerformed

    private void txtPorcientoGeneralKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcientoGeneralKeyPressed
        String numSemanas = this.txtNumSemanasPreparatorio.getText();
        String porPre = this.txtPorcientoGeneral.getText();

        char c = evt.getKeyChar();
        if (Character.isDigit(c) && txtPorcientoGeneral.getText().length() < 2) {
            // Permitir ingreso de dígitos si la longitud actual es menor que 2
        } else if (c == '\b') {
            // Permitir borrar con la tecla de retroceso ('\b')
        } else {
            evt.consume();  // Ignorar el evento si no es un dígito o la longitud es mayor o igual a 2
        }

        // validar si se a presionado enter
        if (evt.getKeyCode() != 10) {
            return;
        }

        try {
            txtPorcientoEspecial.setText(rellenarPorcentaje(porPre));
            System.out.println("entra");
            if (!numSemanas.equals("")) {
                System.out.println(numSemanas);
                txtNumSemanasGeneral.setText(calcularSemanas(Integer.parseInt(numSemanas), Integer.parseInt(txtPorcientoGeneral.getText())) + "");
                txtNumSemanasEspecial.setText(calcularSemanas(Integer.parseInt(numSemanas), Integer.parseInt(txtPorcientoEspecial.getText())) + "");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_txtPorcientoGeneralKeyPressed

    private void txtPorcientoEspecialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcientoEspecialKeyPressed
        String numSemanas = this.txtNumSemanasPreparatorio.getText();
        String porPre = this.txtPorcientoEspecial.getText();

        char c = evt.getKeyChar();
        if (Character.isDigit(c) && txtPorcientoEspecial.getText().length() < 2) {
            // Permitir ingreso de dígitos si la longitud actual es menor que 2
        } else if (c == '\b') {
            // Permitir borrar con la tecla de retroceso ('\b')
        } else {
            evt.consume();  // Ignorar el evento si no es un dígito o la longitud es mayor o igual a 2
        }

        // validar si se a presionado enter
        if (evt.getKeyCode() != 10) {
            return;
        }

        try {
            txtPorcientoGeneral.setText(rellenarPorcentaje(porPre));
            if (!numSemanas.equals("")) {
                txtNumSemanasGeneral.setText(calcularSemanas(Integer.parseInt(numSemanas), Integer.parseInt(txtPorcientoGeneral.getText())) + "");
                txtNumSemanasEspecial.setText(calcularSemanas(Integer.parseInt(numSemanas), Integer.parseInt(txtPorcientoEspecial.getText())) + "");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_txtPorcientoEspecialKeyPressed

    private void txtNumSemanasGeneralKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSemanasGeneralKeyPressed
        String sem = this.txtNumSemanasGeneral.getText();
        String numSemanas = this.txtNumSemanasPreparatorio.getText();

        char c = evt.getKeyChar();
        if (Character.isDigit(c) && txtNumSemanasGeneral.getText().length() < 2) {
            // Permitir ingreso de dígitos si la longitud actual es menor que 2
        } else if (c == '\b') {
            // Permitir borrar con la tecla de retroceso ('\b')
        } else {
            evt.consume();  // Ignorar el evento si no es un dígito o la longitud es mayor o igual a 2
        }

        // validar si se a presionado enter
        if (evt.getKeyCode() != 10) {
            return;
        }
        try {
            txtNumSemanasEspecial.setText(rellenarSemanas(sem, numSemanas));
            if (!numSemanas.equals("")) {
                txtPorcientoGeneral.setText(calcularPorcentaje(Integer.parseInt(txtNumSemanasPreparatorio.getText()), Integer.parseInt(txtNumSemanasGeneral.getText())) + "");
                txtPorcientoEspecial.setText(calcularPorcentaje(Integer.parseInt(txtNumSemanasPreparatorio.getText()), Integer.parseInt(txtNumSemanasEspecial.getText())) + "");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_txtNumSemanasGeneralKeyPressed

    private void txtNumSemanasEspecialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSemanasEspecialKeyPressed
        String sem = this.txtNumSemanasEspecial.getText();
        String numSemanas = this.txtNumSemanasPreparatorio.getText();

        char c = evt.getKeyChar();
        if (Character.isDigit(c) && txtNumSemanasEspecial.getText().length() < 2) {
            // Permitir ingreso de dígitos si la longitud actual es menor que 2
        } else if (c == '\b') {
            // Permitir borrar con la tecla de retroceso ('\b')
        } else {
            evt.consume();  // Ignorar el evento si no es un dígito o la longitud es mayor o igual a 2
        }

        // validar si se a presionado enter
        if (evt.getKeyCode() != 10) {
            return;
        }
        try {
            txtNumSemanasGeneral.setText(rellenarSemanas(sem, numSemanas));
            if (!numSemanas.equals("")) {
                txtPorcientoGeneral.setText(calcularPorcentaje(Integer.parseInt(txtNumSemanasPreparatorio.getText()), Integer.parseInt(txtNumSemanasGeneral.getText())) + "");
                txtPorcientoEspecial.setText(calcularPorcentaje(Integer.parseInt(txtNumSemanasPreparatorio.getText()), Integer.parseInt(txtNumSemanasEspecial.getText())) + "");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_txtNumSemanasEspecialKeyPressed

    private void txtPorcientoCompetitivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcientoCompetitivoKeyPressed
        String porPre = this.txtPorcientoCompetitivo.getText();
        String numSemanas = this.txtNumSemanasMacro.getText();

        char c = evt.getKeyChar();
        if (Character.isDigit(c) && txtPorcientoCompetitivo.getText().length() < 2) {
            // Permitir ingreso de dígitos si la longitud actual es menor que 2
        } else if (c == '\b') {
            // Permitir borrar con la tecla de retroceso ('\b')
        } else {
            evt.consume();  // Ignorar el evento si no es un dígito o la longitud es mayor o igual a 2
        }

        // validar si se a presionado enter
        if (evt.getKeyCode() != 10) {
            return;
        }

        try {
            txtPorcientoPreparatorio.setText(rellenarPorcentaje(porPre));
            if (!numSemanas.equals("")) {
                txtNumSemanasCompetitivo.setText(calcularSemanas(Integer.parseInt(txtNumSemanasMacro.getText()), Integer.parseInt(txtPorcientoCompetitivo.getText())) + "");
                txtNumSemanasPreparatorio.setText(calcularSemanas(Integer.parseInt(txtNumSemanasMacro.getText()), Integer.parseInt(txtPorcientoPreparatorio.getText())) + "");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_txtPorcientoCompetitivoKeyPressed

    private void txtPorcientoPreparatorioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcientoPreparatorioKeyPressed
        String porPre = this.txtPorcientoPreparatorio.getText();
        String numSemanas = this.txtNumSemanasMacro.getText();

        char c = evt.getKeyChar();
        if (Character.isDigit(c) && txtPorcientoPreparatorio.getText().length() < 2) {
            // Permitir ingreso de dígitos si la longitud actual es menor que 2
        } else if (c == '\b') {
            // Permitir borrar con la tecla de retroceso ('\b')
        } else {
            evt.consume();  // Ignorar el evento si no es un dígito o la longitud es mayor o igual a 2
        }

        // validar si se a presionado enter
        if (evt.getKeyCode() != 10) {
            return;
        }
        try {
            txtPorcientoCompetitivo.setText(rellenarPorcentaje(porPre));
            if (!numSemanas.equals("")) {
                txtNumSemanasCompetitivo.setText(calcularSemanas(Integer.parseInt(txtNumSemanasMacro.getText()), Integer.parseInt(txtPorcientoCompetitivo.getText())) + "");
                txtNumSemanasPreparatorio.setText(calcularSemanas(Integer.parseInt(txtNumSemanasMacro.getText()), Integer.parseInt(txtPorcientoPreparatorio.getText())) + "");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_txtPorcientoPreparatorioKeyPressed

    private void txtNumSemanasCompetitivoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSemanasCompetitivoKeyPressed
        String sem = this.txtNumSemanasCompetitivo.getText();
        String numSemanas = this.txtNumSemanasMacro.getText();

        char c = evt.getKeyChar();
        if (Character.isDigit(c) && txtNumSemanasCompetitivo.getText().length() < 2) {
            // Permitir ingreso de dígitos si la longitud actual es menor que 2
        } else if (c == '\b') {
            // Permitir borrar con la tecla de retroceso ('\b')
        } else {
            evt.consume();  // Ignorar el evento si no es un dígito o la longitud es mayor o igual a 2
        }

        // validar si se a presionado enter
        if (evt.getKeyCode() != 10) {
            return;
        }
        try {
            txtNumSemanasPreparatorio.setText(rellenarSemanas(sem, numSemanas));
            if (!numSemanas.equals("")) {
                txtPorcientoCompetitivo.setText(calcularPorcentaje(Integer.parseInt(txtNumSemanasMacro.getText()), Integer.parseInt(txtNumSemanasCompetitivo.getText())) + "");
                txtPorcientoPreparatorio.setText(calcularPorcentaje(Integer.parseInt(txtNumSemanasMacro.getText()), Integer.parseInt(txtNumSemanasPreparatorio.getText())) + "");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_txtNumSemanasCompetitivoKeyPressed

    private void txtNumSemanasPreparatorioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumSemanasPreparatorioKeyPressed
        String sem = this.txtNumSemanasPreparatorio.getText();
        String numSemanas = this.txtNumSemanasMacro.getText();

        char c = evt.getKeyChar();
        if (Character.isDigit(c) && txtNumSemanasPreparatorio.getText().length() < 2) {
            // Permitir ingreso de dígitos si la longitud actual es menor que 2
        } else if (c == '\b') {
            // Permitir borrar con la tecla de retroceso ('\b')
        } else {
            evt.consume();  // Ignorar el evento si no es un dígito o la longitud es mayor o igual a 2
        }

        // validar si se a presionado enter
        if (evt.getKeyCode() != 10) {
            return;
        }
        try {
            txtNumSemanasCompetitivo.setText(rellenarSemanas(sem, numSemanas));
            if (!numSemanas.equals("")) {
                txtPorcientoCompetitivo.setText(calcularPorcentaje(Integer.parseInt(txtNumSemanasMacro.getText()), Integer.parseInt(txtNumSemanasCompetitivo.getText())) + "");
                txtPorcientoPreparatorio.setText(calcularPorcentaje(Integer.parseInt(txtNumSemanasMacro.getText()), Integer.parseInt(txtNumSemanasPreparatorio.getText())) + "");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_txtNumSemanasPreparatorioKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int i = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cancelar el registro? (Toda información relacionada a este macrociclo será eliminada)", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
            cerrarSiAbierto();
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

    private void btnCalcularPorcentajesEtapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPorcentajesEtapasActionPerformed
        if (!this.txtNumSemanasMacro.getText().isBlank()) {
            if (!this.txtPorcientoPreparatorio.getText().isBlank() || !this.txtPorcientoPreparatorio.getText().isBlank()) {
                int totalSemanas = Integer.parseInt(this.txtNumSemanasMacro.getText());
                int porcentajePrepatorio = Integer.parseInt(this.txtPorcientoPreparatorio.getText());
                int porcentajeCompetitivo = Integer.parseInt(this.txtPorcientoCompetitivo.getText());
                this.txtNumSemanasPreparatorio.setText(String.valueOf(Math.round(Math.ceil(Porcentajes.calcularPorcentaje(totalSemanas, porcentajePrepatorio)))));
                this.txtNumSemanasCompetitivo.setText(String.valueOf(Math.round(Math.floor(Porcentajes.calcularPorcentaje(totalSemanas, porcentajeCompetitivo)))));
                validarSemanasEtapas();
            } else {
                // Mensaje de error
                JOptionPane.showMessageDialog(null, "Seleccione porcentajes válidos para las etapas.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Mensaje de error
            JOptionPane.showMessageDialog(null, "Seleccione una duración total de semanas para el macrociclo.", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCalcularPorcentajesEtapasActionPerformed

    private void btnCalcularPorcentajesSubetapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPorcentajesSubetapasActionPerformed
        if (!this.txtNumSemanasPreparatorio.getText().isBlank()) {
            if (!this.txtPorcientoGeneral.getText().isBlank() || !this.txtPorcientoEspecial.getText().isBlank()) {
                int totalSemanas = Integer.parseInt(this.txtNumSemanasPreparatorio.getText());
                int porcentajeGeneral = Integer.parseInt(this.txtPorcientoGeneral.getText());
                int porcentajeEspecial = Integer.parseInt(this.txtPorcientoEspecial.getText());
                this.txtNumSemanasGeneral.setText(String.valueOf(Math.round(Math.ceil(Porcentajes.calcularPorcentaje(totalSemanas, porcentajeGeneral)))));
                this.txtNumSemanasEspecial.setText(String.valueOf(Math.round(Math.floor(Porcentajes.calcularPorcentaje(totalSemanas, porcentajeEspecial)))));
                validarSemanasSubEtapas();
            } else {
                // Mensaje de error
                JOptionPane.showMessageDialog(null, "Seleccione porcentajes válidos para las sub-etapas.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Mensaje de error
            JOptionPane.showMessageDialog(null, "Seleccione una duración total de semanas para la etapa Preparatoria.", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCalcularPorcentajesSubetapasActionPerformed

    private void btnCalcularTotalSemanasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularTotalSemanasActionPerformed
        try {
            if (!this.txtFechaInicioMacro.getCalendar().equals(null) && !this.txtFechaFinMacro.getCalendar().equals(null)) {
                if (Fecha.esFechaAntes(this.txtFechaInicioMacro.getCalendar(), this.txtFechaFinMacro.getCalendar())) {
                    int totalSemanas = Fecha.calcularSemanasEntreFechas(this.txtFechaInicioMacro.getCalendar(), this.txtFechaFinMacro.getCalendar());
                    this.txtNumSemanasMacro.setText(String.valueOf(totalSemanas));
                    validarSemanasMacro();
                } else {
                    // Mensaje de error
                    JOptionPane.showMessageDialog(null, "La fecha inicio tiene que ser antes a la fecha fin.", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Mensaje de error
                JOptionPane.showMessageDialog(null, "Seleccione una fecha de inicio y una fecha de fin.", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            // Mensaje de error
            JOptionPane.showMessageDialog(null, "Error al querer calcular la duración total del macrociclo, intente de nuevo.", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCalcularTotalSemanasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularPorcentajesEtapas;
    private javax.swing.JButton btnCalcularPorcentajesSubetapas;
    private javax.swing.JButton btnCalcularTotalSemanas;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultarAcentos;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblArrow;
    private javax.swing.JLabel lblCompetitivo;
    private javax.swing.JLabel lblDeporte;
    private javax.swing.JLabel lblDuracionMacro;
    private javax.swing.JPanel lblEncabezadoMacro;
    private javax.swing.JPanel lblEncabezadoTitulo;
    private javax.swing.JLabel lblEspecial;
    private javax.swing.JLabel lblFechaFinMacro;
    private javax.swing.JLabel lblFechaHoy;
    private javax.swing.JLabel lblFechaInicioMacro;
    private javax.swing.JLabel lblGeneral;
    private javax.swing.JLabel lblGuion1;
    private javax.swing.JLabel lblGuion2;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMensajeMacro;
    private javax.swing.JLabel lblNum;
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
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lbltxt;
    private javax.swing.JPanel pnlEtapas;
    private javax.swing.JPanel pnlPeriodos;
    private com.toedter.calendar.JDateChooser txtFechaFinMacro;
    private com.toedter.calendar.JDateChooser txtFechaInicioMacro;
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
