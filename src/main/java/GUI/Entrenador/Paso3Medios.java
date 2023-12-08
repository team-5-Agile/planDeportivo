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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    TipoMedio RAG, RAE, VEL_GENERAL, VEL_ESPECIAL, RES_VEL_ESP, RES_VEL_GEN, FUERZA_GEN, FUERZA_ESP, COORD_TECN, FLEXIBILIDAD;
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

    private List<Medio> registrarGeneral() {
        List<Medio> listaGeneral = new ArrayList<>();
        try {
            // Medio RAG General
            Medio medioRAG = new Medio();
            medioRAG.setEtapas(this.etapaGeneral);
            medioRAG.setTipoMedio(TipoMedio.RAG);
            medioRAG.setTipo(Unidades.KM);
            medioRAG.setMinimo(Integer.valueOf(this.txtMinRAGGeneral.getText()));
            medioRAG.setMaximo(Integer.valueOf(this.txtMaxRAGGeneral.getText()));
            medioRAG.setPromedio(Float.valueOf(this.txtPromRAGGeneral.getText()));
            medioRAG.setInsitaciones(Integer.valueOf(this.txtInsRAGGeneral.getText()));
            medioRAG.setVolumenEtapa(Float.valueOf(this.txtVolRAGGeneral.getText()));
            listaGeneral.add(medioRAG);

            // Medio RAE General
            Medio medioRAE = new Medio();
            medioRAE.setEtapas(this.etapaGeneral);
            medioRAE.setTipoMedio(TipoMedio.RAE);
            medioRAE.setTipo(Unidades.MIN);
            medioRAE.setMinimo(Integer.valueOf(this.txtMinRAEGeneral.getText()));
            medioRAE.setMaximo(Integer.valueOf(this.txtMaxRAEGeneral.getText()));
            medioRAE.setPromedio(Float.valueOf(this.txtPromRAEGeneral.getText()));
            medioRAE.setInsitaciones(Integer.valueOf(this.txtInsRAEGeneral.getText()));
            medioRAE.setVolumenEtapa(Float.valueOf(this.txtVolRAEGeneral.getText()));
            listaGeneral.add(medioRAE);

            // Medio VelGen General
            Medio medioVelGen = new Medio();
            medioVelGen.setEtapas(this.etapaGeneral);
            medioVelGen.setTipoMedio(TipoMedio.VEL_GENERAL);
            medioVelGen.setTipo(Unidades.MTROS);
            medioVelGen.setMinimo(Integer.valueOf(this.txtMinVelGenGeneral.getText()));
            medioVelGen.setMaximo(Integer.valueOf(this.txtMaxVelGenGeneral.getText()));
            medioVelGen.setPromedio(Float.valueOf(this.txtPromVelGenGeneral.getText()));
            medioVelGen.setInsitaciones(Integer.valueOf(this.txtInsVelGenGeneral.getText()));
            medioVelGen.setVolumenEtapa(Float.valueOf(this.txtVolVelGenGeneral.getText()));
            listaGeneral.add(medioVelGen);

            // Medio VelEsp General
            Medio medioVelEsp = new Medio();
            medioVelEsp.setEtapas(this.etapaGeneral);
            medioVelEsp.setTipoMedio(TipoMedio.VEL_ESPECIAL);
            medioVelEsp.setTipo(Unidades.SEG);
            medioVelEsp.setMinimo(Integer.valueOf(this.txtMinVelEspGeneral.getText()));
            medioVelEsp.setMaximo(Integer.valueOf(this.txtMaxVelEspGeneral.getText()));
            medioVelEsp.setPromedio(Float.valueOf(this.txtPromVelEspGeneral.getText()));
            medioVelEsp.setInsitaciones(Integer.valueOf(this.txtInsVelEspGeneral.getText()));
            medioVelEsp.setVolumenEtapa(Float.valueOf(this.txtVolVelEspGeneral.getText()));
            listaGeneral.add(medioVelEsp);

            // Medio ResVelGen General
            Medio medioResVelGen = new Medio();
            medioResVelGen.setEtapas(this.etapaGeneral);
            medioResVelGen.setTipoMedio(TipoMedio.RES_VEL_GEN);
            medioResVelGen.setTipo(Unidades.MTROS);
            medioResVelGen.setMinimo(Integer.valueOf(this.txtMinResVelGenGeneral.getText()));
            medioResVelGen.setMaximo(Integer.valueOf(this.txtMaxResVelGenGeneral.getText()));
            medioResVelGen.setPromedio(Float.valueOf(this.txtPromResVelGenGeneral.getText()));
            medioResVelGen.setInsitaciones(Integer.valueOf(this.txtInsResVelGenGeneral.getText()));
            medioResVelGen.setVolumenEtapa(Float.valueOf(this.txtVolResVelGenGeneral.getText()));
            listaGeneral.add(medioResVelGen);

            // Medio ResVelEsp General
            Medio medioResVelEsp = new Medio();
            medioResVelEsp.setEtapas(this.etapaGeneral);
            medioResVelEsp.setTipoMedio(TipoMedio.RES_VEL_ESP);
            medioResVelEsp.setTipo(Unidades.MIN);
            medioResVelEsp.setMinimo(Integer.valueOf(this.txtMinResVelEspGeneral.getText()));
            medioResVelEsp.setMaximo(Integer.valueOf(this.txtMaxResVelEspGeneral.getText()));
            medioResVelEsp.setPromedio(Float.valueOf(this.txtPromResVelEspGeneral.getText()));
            medioResVelEsp.setInsitaciones(Integer.valueOf(this.txtInsResVelEspGeneral.getText()));
            medioResVelEsp.setVolumenEtapa(Float.valueOf(this.txtVolResVelEspGeneral.getText()));
            listaGeneral.add(medioResVelEsp);

            // Medio FuerzaGen General
            Medio medioFuerzaGen = new Medio();
            medioFuerzaGen.setEtapas(this.etapaGeneral);
            medioFuerzaGen.setTipoMedio(TipoMedio.FUERZA_GEN);
            medioFuerzaGen.setTipo(Unidades.REP);
            medioFuerzaGen.setMinimo(Integer.valueOf(this.txtMinFuerzaGenGeneral.getText()));
            medioFuerzaGen.setMaximo(Integer.valueOf(this.txtMaxFuerzaGenGeneral.getText()));
            medioFuerzaGen.setPromedio(Float.valueOf(this.txtPromFuerzaGenGeneral.getText()));
            medioFuerzaGen.setInsitaciones(Integer.valueOf(this.txtInsFuerzaGenGeneral.getText()));
            medioFuerzaGen.setVolumenEtapa(Float.valueOf(this.txtVolFuerzaGenGeneral.getText()));
            listaGeneral.add(medioFuerzaGen);

            // Medio FuerzaEsp General
            Medio medioFuerzaEsp = new Medio();
            medioFuerzaEsp.setEtapas(this.etapaGeneral);
            medioFuerzaEsp.setTipoMedio(TipoMedio.FUERZA_ESP);
            medioFuerzaEsp.setTipo(Unidades.REP);
            medioFuerzaEsp.setMinimo(Integer.valueOf(this.txtMinFuerzaEspGeneral.getText()));
            medioFuerzaEsp.setMaximo(Integer.valueOf(this.txtMaxFuerzaEspGeneral.getText()));
            medioFuerzaEsp.setPromedio(Float.valueOf(this.txtPromFuerzaEspGeneral.getText()));
            medioFuerzaEsp.setInsitaciones(Integer.valueOf(this.txtInsFuerzaEspGeneral.getText()));
            medioFuerzaEsp.setVolumenEtapa(Float.valueOf(this.txtVolFuerzaEspGeneral.getText()));
            listaGeneral.add(medioFuerzaEsp);

            // Medio CoordTecn General
            Medio medioCoordTecn = new Medio();
            medioCoordTecn.setEtapas(this.etapaGeneral);
            medioCoordTecn.setTipoMedio(TipoMedio.COORD_TECN);
            medioCoordTecn.setTipo(Unidades.REP);
            medioCoordTecn.setMinimo(Integer.valueOf(this.txtMinCoordTecnGeneral.getText()));
            medioCoordTecn.setMaximo(Integer.valueOf(this.txtMaxCoordTecnGeneral.getText()));
            medioCoordTecn.setPromedio(Float.valueOf(this.txtPromCoordTecnGeneral.getText()));
            medioCoordTecn.setInsitaciones(Integer.valueOf(this.txtInsCoordTecnGeneral.getText()));
            medioCoordTecn.setVolumenEtapa(Float.valueOf(this.txtVolCoordTecnGeneral.getText()));
            listaGeneral.add(medioCoordTecn);

            // Medio Flexibilidad General
            Medio medioFlexibilidad = new Medio();
            medioFlexibilidad.setEtapas(this.etapaGeneral);
            medioFlexibilidad.setTipoMedio(TipoMedio.FLEXIBILIDAD);
            medioFlexibilidad.setTipo(Unidades.MIN);
            medioFlexibilidad.setMinimo(Integer.valueOf(this.txtMinFlexibilidadGeneral.getText()));
            medioFlexibilidad.setMaximo(Integer.valueOf(this.txtMaxFlexibilidadGeneral.getText()));
            medioFlexibilidad.setPromedio(Float.valueOf(this.txtPromFlexibilidadGeneral.getText()));
            medioFlexibilidad.setInsitaciones(Integer.valueOf(this.txtInsFlexibilidadGeneral.getText()));
            medioFlexibilidad.setVolumenEtapa(Float.valueOf(this.txtVolFlexibilidadGeneral.getText()));
            listaGeneral.add(medioFlexibilidad);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
        return listaGeneral;
    }

    private List<Medio> registrarEspecial() {
        List<Medio> listaEspecial = new ArrayList<>();
        try {
            // Medio RAG Especial
            Medio medioRAG = new Medio();
            medioRAG.setEtapas(this.etapaEspecial);
            medioRAG.setTipoMedio(TipoMedio.RAG);
            medioRAG.setTipo(Unidades.KM);
            medioRAG.setMinimo(Integer.valueOf(this.txtMinRAGEspecial.getText()));
            medioRAG.setMaximo(Integer.valueOf(this.txtMaxRAGEspecial.getText()));
            medioRAG.setPromedio(Float.valueOf(this.txtPromRAGEspecial.getText()));
            medioRAG.setInsitaciones(Integer.valueOf(this.txtInsRAGEspecial.getText()));
            medioRAG.setVolumenEtapa(Float.valueOf(this.txtVolRAGEspecial.getText()));
            listaEspecial.add(medioRAG);

            // Medio RAE Especial
            Medio medioRAE = new Medio();
            medioRAE.setEtapas(this.etapaEspecial);
            medioRAE.setTipoMedio(TipoMedio.RAE);
            medioRAE.setTipo(Unidades.MIN);
            medioRAE.setMinimo(Integer.valueOf(this.txtMinRAEEspecial.getText()));
            medioRAE.setMaximo(Integer.valueOf(this.txtMaxRAEEspecial.getText()));
            medioRAE.setPromedio(Float.valueOf(this.txtPromRAEEspecial.getText()));
            medioRAE.setInsitaciones(Integer.valueOf(this.txtInsRAEEspecial.getText()));
            medioRAE.setVolumenEtapa(Float.valueOf(this.txtVolRAEEspecial.getText()));
            listaEspecial.add(medioRAE);

            // Medio VelGen Especial
            Medio medioVelGen = new Medio();
            medioVelGen.setEtapas(this.etapaEspecial);
            medioVelGen.setTipoMedio(TipoMedio.VEL_GENERAL);
            medioVelGen.setTipo(Unidades.MTROS);
            medioVelGen.setMinimo(Integer.valueOf(this.txtMinVelGenEspecial.getText()));
            medioVelGen.setMaximo(Integer.valueOf(this.txtMaxVelGenEspecial.getText()));
            medioVelGen.setPromedio(Float.valueOf(this.txtPromVelGenEspecial.getText()));
            medioVelGen.setInsitaciones(Integer.valueOf(this.txtInsVelGenEspecial.getText()));
            medioVelGen.setVolumenEtapa(Float.valueOf(this.txtVolVelGenEspecial.getText()));
            listaEspecial.add(medioVelGen);

            // Medio VelEsp Especial
            Medio medioVelEsp = new Medio();
            medioVelEsp.setEtapas(this.etapaEspecial);
            medioVelEsp.setTipoMedio(TipoMedio.VEL_ESPECIAL);
            medioVelEsp.setTipo(Unidades.SEG);
            medioVelEsp.setMinimo(Integer.valueOf(this.txtMinVelEspEspecial.getText()));
            medioVelEsp.setMaximo(Integer.valueOf(this.txtMaxVelEspEspecial.getText()));
            medioVelEsp.setPromedio(Float.valueOf(this.txtPromVelEspEspecial.getText()));
            medioVelEsp.setInsitaciones(Integer.valueOf(this.txtInsVelEspEspecial.getText()));
            medioVelEsp.setVolumenEtapa(Float.valueOf(this.txtVolVelEspEspecial.getText()));
            listaEspecial.add(medioVelEsp);

            // Medio ResVelGen Especial
            Medio medioResVelGen = new Medio();
            medioResVelGen.setEtapas(this.etapaEspecial);
            medioResVelGen.setTipoMedio(TipoMedio.RES_VEL_GEN);
            medioResVelGen.setTipo(Unidades.MTROS);
            medioResVelGen.setMinimo(Integer.valueOf(this.txtMinResVelGenEspecial.getText()));
            medioResVelGen.setMaximo(Integer.valueOf(this.txtMaxResVelGenEspecial.getText()));
            medioResVelGen.setPromedio(Float.valueOf(this.txtPromResVelGenEspecial.getText()));
            medioResVelGen.setInsitaciones(Integer.valueOf(this.txtInsResVelGenEspecial.getText()));
            medioResVelGen.setVolumenEtapa(Float.valueOf(this.txtVolResVelGenEspecial.getText()));
            listaEspecial.add(medioResVelGen);

            // Medio ResVelEsp Especial
            Medio medioResVelEsp = new Medio();
            medioResVelEsp.setEtapas(this.etapaEspecial);
            medioResVelEsp.setTipoMedio(TipoMedio.RES_VEL_ESP);
            medioResVelEsp.setTipo(Unidades.MIN);
            medioResVelEsp.setMinimo(Integer.valueOf(this.txtMinResVelEspEspecial.getText()));
            medioResVelEsp.setMaximo(Integer.valueOf(this.txtMaxResVelEspEspecial.getText()));
            medioResVelEsp.setPromedio(Float.valueOf(this.txtPromResVelEspEspecial.getText()));
            medioResVelEsp.setInsitaciones(Integer.valueOf(this.txtInsResVelEspEspecial.getText()));
            medioResVelEsp.setVolumenEtapa(Float.valueOf(this.txtVolResVelEspEspecial.getText()));
            listaEspecial.add(medioResVelEsp);

            // Medio FuerzaGen Especial
            Medio medioFuerzaGen = new Medio();
            medioFuerzaGen.setEtapas(this.etapaEspecial);
            medioFuerzaGen.setTipoMedio(TipoMedio.FUERZA_GEN);
            medioFuerzaGen.setTipo(Unidades.REP);
            medioFuerzaGen.setMinimo(Integer.valueOf(this.txtMinFuerzaGenEspecial.getText()));
            medioFuerzaGen.setMaximo(Integer.valueOf(this.txtMaxFuerzaGenEspecial.getText()));
            medioFuerzaGen.setPromedio(Float.valueOf(this.txtPromFuerzaGenEspecial.getText()));
            medioFuerzaGen.setInsitaciones(Integer.valueOf(this.txtInsFuerzaGenEspecial.getText()));
            medioFuerzaGen.setVolumenEtapa(Float.valueOf(this.txtVolFuerzaGenEspecial.getText()));
            listaEspecial.add(medioFuerzaGen);

            // Medio FuerzaEsp Especial
            Medio medioFuerzaEsp = new Medio();
            medioFuerzaEsp.setEtapas(this.etapaEspecial);
            medioFuerzaEsp.setTipoMedio(TipoMedio.FUERZA_ESP);
            medioFuerzaEsp.setTipo(Unidades.REP);
            medioFuerzaEsp.setMinimo(Integer.valueOf(this.txtMinFuerzaEspEspecial.getText()));
            medioFuerzaEsp.setMaximo(Integer.valueOf(this.txtMaxFuerzaEspEspecial.getText()));
            medioFuerzaEsp.setPromedio(Float.valueOf(this.txtPromFuerzaEspEspecial.getText()));
            medioFuerzaEsp.setInsitaciones(Integer.valueOf(this.txtInsFuerzaEspEspecial.getText()));
            medioFuerzaEsp.setVolumenEtapa(Float.valueOf(this.txtVolFuerzaEspEspecial.getText()));
            listaEspecial.add(medioFuerzaEsp);

            // Medio CoordTecn Especial
            Medio medioCoordTecn = new Medio();
            medioCoordTecn.setEtapas(this.etapaEspecial);
            medioCoordTecn.setTipoMedio(TipoMedio.COORD_TECN);
            medioCoordTecn.setTipo(Unidades.REP);
            medioCoordTecn.setMinimo(Integer.valueOf(this.txtMinCoordTecnEspecial.getText()));
            medioCoordTecn.setMaximo(Integer.valueOf(this.txtMaxCoordTecnEspecial.getText()));
            medioCoordTecn.setPromedio(Float.valueOf(this.txtPromCoordTecnEspecial.getText()));
            medioCoordTecn.setInsitaciones(Integer.valueOf(this.txtInsCoordTecnEspecial.getText()));
            medioCoordTecn.setVolumenEtapa(Float.valueOf(this.txtVolCoordTecnEspecial.getText()));
            listaEspecial.add(medioCoordTecn);

            // Medio Flexibilidad Especial
            Medio medioFlexibilidad = new Medio();
            medioFlexibilidad.setEtapas(this.etapaEspecial);
            medioFlexibilidad.setTipoMedio(TipoMedio.FLEXIBILIDAD);
            medioFlexibilidad.setTipo(Unidades.MIN);
            medioFlexibilidad.setMinimo(Integer.valueOf(this.txtMinFlexibilidadEspecial.getText()));
            medioFlexibilidad.setMaximo(Integer.valueOf(this.txtMaxFlexibilidadEspecial.getText()));
            medioFlexibilidad.setPromedio(Float.valueOf(this.txtPromFlexibilidadEspecial.getText()));
            medioFlexibilidad.setInsitaciones(Integer.valueOf(this.txtInsFlexibilidadEspecial.getText()));
            medioFlexibilidad.setVolumenEtapa(Float.valueOf(this.txtVolFlexibilidadEspecial.getText()));
            listaEspecial.add(medioFlexibilidad);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
        return listaEspecial;
    }

    private List<Medio> registrarCompetitiva() {
        List<Medio> listaCompetitiva = new ArrayList<>();
        try {
            // Medio RAG Competitiva
            Medio medioRAG = new Medio();
            medioRAG.setEtapas(this.etapaCompetitiva);
            medioRAG.setTipoMedio(TipoMedio.RAG);
            medioRAG.setTipo(Unidades.KM);
            medioRAG.setMinimo(Integer.valueOf(this.txtMinRAGCompetitiva.getText()));
            medioRAG.setMaximo(Integer.valueOf(this.txtMaxRAGCompetitiva.getText()));
            medioRAG.setPromedio(Float.valueOf(this.txtPromRAGCompetitiva.getText()));
            medioRAG.setInsitaciones(Integer.valueOf(this.txtInsRAGCompetitiva.getText()));
            medioRAG.setVolumenEtapa(Float.valueOf(this.txtVolRAGCompetitiva.getText()));
            listaCompetitiva.add(medioRAG);

            // Medio RAE Competitiva
            Medio medioRAE = new Medio();
            medioRAE.setEtapas(this.etapaCompetitiva);
            medioRAE.setTipoMedio(TipoMedio.RAE);
            medioRAE.setTipo(Unidades.MIN);
            medioRAE.setMinimo(Integer.valueOf(this.txtMinRAECompetitiva.getText()));
            medioRAE.setMaximo(Integer.valueOf(this.txtMaxRAECompetitiva.getText()));
            medioRAE.setPromedio(Float.valueOf(this.txtPromRAECompetitiva.getText()));
            medioRAE.setInsitaciones(Integer.valueOf(this.txtInsRAECompetitiva.getText()));
            medioRAE.setVolumenEtapa(Float.valueOf(this.txtVolRAECompetitiva.getText()));
            listaCompetitiva.add(medioRAE);

            // Medio VelGen Competitiva
            Medio medioVelGen = new Medio();
            medioVelGen.setEtapas(this.etapaCompetitiva);
            medioVelGen.setTipoMedio(TipoMedio.VEL_GENERAL);
            medioVelGen.setTipo(Unidades.MTROS);
            medioVelGen.setMinimo(Integer.valueOf(this.txtMinVelGenCompetitiva.getText()));
            medioVelGen.setMaximo(Integer.valueOf(this.txtMaxVelGenCompetitiva.getText()));
            medioVelGen.setPromedio(Float.valueOf(this.txtPromVelGenCompetitiva.getText()));
            medioVelGen.setInsitaciones(Integer.valueOf(this.txtInsVelGenCompetitiva.getText()));
            medioVelGen.setVolumenEtapa(Float.valueOf(this.txtVolVelGenCompetitiva.getText()));
            listaCompetitiva.add(medioVelGen);

            // Medio VelEsp Competitiva
            Medio medioVelEsp = new Medio();
            medioVelEsp.setEtapas(this.etapaCompetitiva);
            medioVelEsp.setTipoMedio(TipoMedio.VEL_ESPECIAL);
            medioVelEsp.setTipo(Unidades.SEG);
            medioVelEsp.setMinimo(Integer.valueOf(this.txtMinVelEspCompetitiva.getText()));
            medioVelEsp.setMaximo(Integer.valueOf(this.txtMaxVelEspCompetitiva.getText()));
            medioVelEsp.setPromedio(Float.valueOf(this.txtPromVelEspCompetitiva.getText()));
            medioVelEsp.setInsitaciones(Integer.valueOf(this.txtInsVelEspCompetitiva.getText()));
            medioVelEsp.setVolumenEtapa(Float.valueOf(this.txtVolVelEspCompetitiva.getText()));
            listaCompetitiva.add(medioVelEsp);

            // Medio ResVelGen Competitiva
            Medio medioResVelGen = new Medio();
            medioResVelGen.setEtapas(this.etapaCompetitiva);
            medioResVelGen.setTipoMedio(TipoMedio.RES_VEL_GEN);
            medioResVelGen.setTipo(Unidades.MTROS);
            medioResVelGen.setMinimo(Integer.valueOf(this.txtMinResVelGenCompetitiva.getText()));
            medioResVelGen.setMaximo(Integer.valueOf(this.txtMaxResVelGenCompetitiva.getText()));
            medioResVelGen.setPromedio(Float.valueOf(this.txtPromResVelGenCompetitiva.getText()));
            medioResVelGen.setInsitaciones(Integer.valueOf(this.txtInsResVelGenCompetitiva.getText()));
            medioResVelGen.setVolumenEtapa(Float.valueOf(this.txtVolResVelGenCompetitiva.getText()));
            listaCompetitiva.add(medioResVelGen);

            // Medio ResVelEsp Competitiva
            Medio medioResVelEsp = new Medio();
            medioResVelEsp.setEtapas(this.etapaCompetitiva);
            medioResVelEsp.setTipoMedio(TipoMedio.RES_VEL_ESP);
            medioResVelEsp.setTipo(Unidades.MIN);
            medioResVelEsp.setMinimo(Integer.valueOf(this.txtMinResVelEspCompetitiva.getText()));
            medioResVelEsp.setMaximo(Integer.valueOf(this.txtMaxResVelEspCompetitiva.getText()));
            medioResVelEsp.setPromedio(Float.valueOf(this.txtPromResVelEspCompetitiva.getText()));
            medioResVelEsp.setInsitaciones(Integer.valueOf(this.txtInsResVelEspCompetitiva.getText()));
            medioResVelEsp.setVolumenEtapa(Float.valueOf(this.txtVolResVelEspCompetitiva.getText()));
            listaCompetitiva.add(medioResVelEsp);

            // Medio FuerzaGen Competitiva
            Medio medioFuerzaGen = new Medio();
            medioFuerzaGen.setEtapas(this.etapaCompetitiva);
            medioFuerzaGen.setTipoMedio(TipoMedio.FUERZA_GEN);
            medioFuerzaGen.setTipo(Unidades.REP);
            medioFuerzaGen.setMinimo(Integer.valueOf(this.txtMinFuerzaGenCompetitiva.getText()));
            medioFuerzaGen.setMaximo(Integer.valueOf(this.txtMaxFuerzaGenCompetitiva.getText()));
            medioFuerzaGen.setPromedio(Float.valueOf(this.txtPromFuerzaGenCompetitiva.getText()));
            medioFuerzaGen.setInsitaciones(Integer.valueOf(this.txtInsFuerzaGenCompetitiva.getText()));
            medioFuerzaGen.setVolumenEtapa(Float.valueOf(this.txtVolFuerzaGenCompetitiva.getText()));
            listaCompetitiva.add(medioFuerzaGen);

            // Medio FuerzaEsp Competitiva
            Medio medioFuerzaEsp = new Medio();
            medioFuerzaEsp.setEtapas(this.etapaCompetitiva);
            medioFuerzaEsp.setTipoMedio(TipoMedio.FUERZA_ESP);
            medioFuerzaEsp.setTipo(Unidades.REP);
            medioFuerzaEsp.setMinimo(Integer.valueOf(this.txtMinFuerzaEspCompetitiva.getText()));
            medioFuerzaEsp.setMaximo(Integer.valueOf(this.txtMaxFuerzaEspCompetitiva.getText()));
            medioFuerzaEsp.setPromedio(Float.valueOf(this.txtPromFuerzaEspCompetitiva.getText()));
            medioFuerzaEsp.setInsitaciones(Integer.valueOf(this.txtInsFuerzaEspCompetitiva.getText()));
            medioFuerzaEsp.setVolumenEtapa(Float.valueOf(this.txtVolFuerzaEspCompetitiva.getText()));
            listaCompetitiva.add(medioFuerzaEsp);

            // Medio CoordTecn Competitiva
            Medio medioCoordTecn = new Medio();
            medioCoordTecn.setEtapas(this.etapaCompetitiva);
            medioCoordTecn.setTipoMedio(TipoMedio.COORD_TECN);
            medioCoordTecn.setTipo(Unidades.REP);
            medioCoordTecn.setMinimo(Integer.valueOf(this.txtMinCoordTecnCompetitiva.getText()));
            medioCoordTecn.setMaximo(Integer.valueOf(this.txtMaxCoordTecnCompetitiva.getText()));
            medioCoordTecn.setPromedio(Float.valueOf(this.txtPromCoordTecnCompetitiva.getText()));
            medioCoordTecn.setInsitaciones(Integer.valueOf(this.txtInsCoordTecnCompetitiva.getText()));
            medioCoordTecn.setVolumenEtapa(Float.valueOf(this.txtVolCoordTecnCompetitiva.getText()));
            listaCompetitiva.add(medioCoordTecn);

            // Medio Flexibilidad Competitiva
            Medio medioFlexibilidad = new Medio();
            medioFlexibilidad.setEtapas(this.etapaCompetitiva);
            medioFlexibilidad.setTipoMedio(TipoMedio.FLEXIBILIDAD);
            medioFlexibilidad.setTipo(Unidades.MIN);
            medioFlexibilidad.setMinimo(Integer.valueOf(this.txtMinFlexibilidadCompetitiva.getText()));
            medioFlexibilidad.setMaximo(Integer.valueOf(this.txtMaxFlexibilidadCompetitiva.getText()));
            medioFlexibilidad.setPromedio(Float.valueOf(this.txtPromFlexibilidadCompetitiva.getText()));
            medioFlexibilidad.setInsitaciones(Integer.valueOf(this.txtInsFlexibilidadCompetitiva.getText()));
            medioFlexibilidad.setVolumenEtapa(Float.valueOf(this.txtVolFlexibilidadCompetitiva.getText()));
            listaCompetitiva.add(medioFlexibilidad);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 1);
        }
        return listaCompetitiva;
    }

    private void registrarMedios() {
        List<Medio> listaGeneral = registrarGeneral();
        List<Medio> listaEspecial = registrarEspecial();
        List<Medio> listaCompetitiva = registrarCompetitiva();

        for (Medio medio : listaGeneral) {
            
            MediosDAO.registrarMedio(medio);
        }
        for (Medio medio : listaEspecial) {
            MediosDAO.registrarMedio(medio);
        }
        for (Medio medio : listaCompetitiva) {
            MediosDAO.registrarMedio(medio);
        }

        // Si se registran correctamente todas las etapas
        if (listaGeneral.get(0).getId() != null
                && listaEspecial.get(0).getId() != null
                && listaCompetitiva.get(0).getId() != null) {
            // Se muestra un mensaje de éxito 
            JOptionPane.showMessageDialog(null, "Se crearon exitosamente los medios para cada etapa: "
                    + "\n Regresando al panel entrenador...", "Registro de medios exitoso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si ocurre un error en el registro, se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Ocurrió un error al querer registrar los medios.", "¡Error interno!", JOptionPane.ERROR_MESSAGE);
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
        lblDeporte = new javax.swing.JLabel();
        lblRama = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        lblGuion1 = new javax.swing.JLabel();
        lblGuion2 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        btnVaciarTabla = new javax.swing.JButton();
        lblTituloTabla = new javax.swing.JLabel();
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
        txtMinRAGGeneral = new javax.swing.JTextField();
        txtMaxRAGGeneral = new javax.swing.JTextField();
        txtPromRAGGeneral = new javax.swing.JTextField();
        txtInsRAGGeneral = new javax.swing.JTextField();
        txtVolRAGGeneral = new javax.swing.JTextField();
        txtMinRAEGeneral = new javax.swing.JTextField();
        txtMaxRAEGeneral = new javax.swing.JTextField();
        txtPromRAEGeneral = new javax.swing.JTextField();
        txtInsRAEGeneral = new javax.swing.JTextField();
        txtVolRAEGeneral = new javax.swing.JTextField();
        txtMinVelGenGeneral = new javax.swing.JTextField();
        txtMaxVelGenGeneral = new javax.swing.JTextField();
        txtPromVelGenGeneral = new javax.swing.JTextField();
        txtInsVelGenGeneral = new javax.swing.JTextField();
        txtVolVelGenGeneral = new javax.swing.JTextField();
        txtMinVelEspGeneral = new javax.swing.JTextField();
        txtMaxVelEspGeneral = new javax.swing.JTextField();
        txtPromVelEspGeneral = new javax.swing.JTextField();
        txtInsVelEspGeneral = new javax.swing.JTextField();
        txtVolVelEspGeneral = new javax.swing.JTextField();
        txtMinResVelGenGeneral = new javax.swing.JTextField();
        txtMaxResVelGenGeneral = new javax.swing.JTextField();
        txtPromResVelGenGeneral = new javax.swing.JTextField();
        txtInsResVelGenGeneral = new javax.swing.JTextField();
        txtVolResVelGenGeneral = new javax.swing.JTextField();
        txtMinResVelEspGeneral = new javax.swing.JTextField();
        txtMaxResVelEspGeneral = new javax.swing.JTextField();
        txtPromResVelEspGeneral = new javax.swing.JTextField();
        txtInsResVelEspGeneral = new javax.swing.JTextField();
        txtVolResVelEspGeneral = new javax.swing.JTextField();
        txtMinFuerzaGenGeneral = new javax.swing.JTextField();
        txtMaxFuerzaGenGeneral = new javax.swing.JTextField();
        txtPromFuerzaGenGeneral = new javax.swing.JTextField();
        txtInsFuerzaGenGeneral = new javax.swing.JTextField();
        txtVolFuerzaGenGeneral = new javax.swing.JTextField();
        txtMinFuerzaEspGeneral = new javax.swing.JTextField();
        txtMaxFuerzaEspGeneral = new javax.swing.JTextField();
        txtPromFuerzaEspGeneral = new javax.swing.JTextField();
        txtInsFuerzaEspGeneral = new javax.swing.JTextField();
        txtVolFuerzaEspGeneral = new javax.swing.JTextField();
        txtMinCoordTecnGeneral = new javax.swing.JTextField();
        txtMaxCoordTecnGeneral = new javax.swing.JTextField();
        txtPromCoordTecnGeneral = new javax.swing.JTextField();
        txtInsCoordTecnGeneral = new javax.swing.JTextField();
        txtVolCoordTecnGeneral = new javax.swing.JTextField();
        txtMinFlexibilidadGeneral = new javax.swing.JTextField();
        txtMaxFlexibilidadGeneral = new javax.swing.JTextField();
        txtPromFlexibilidadGeneral = new javax.swing.JTextField();
        txtInsFlexibilidadGeneral = new javax.swing.JTextField();
        txtVolFlexibilidadGeneral = new javax.swing.JTextField();
        pnlEspecial = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEtapaEspecial = new javax.swing.JTable();
        txtMinRAGEspecial = new javax.swing.JTextField();
        txtMaxRAGEspecial = new javax.swing.JTextField();
        txtPromRAGEspecial = new javax.swing.JTextField();
        txtInsRAGEspecial = new javax.swing.JTextField();
        txtVolRAGEspecial = new javax.swing.JTextField();
        txtMinRAEEspecial = new javax.swing.JTextField();
        txtMaxRAEEspecial = new javax.swing.JTextField();
        txtPromRAEEspecial = new javax.swing.JTextField();
        txtInsRAEEspecial = new javax.swing.JTextField();
        txtVolRAEEspecial = new javax.swing.JTextField();
        txtMinVelGenEspecial = new javax.swing.JTextField();
        txtMaxVelGenEspecial = new javax.swing.JTextField();
        txtPromVelGenEspecial = new javax.swing.JTextField();
        txtInsVelGenEspecial = new javax.swing.JTextField();
        txtVolVelGenEspecial = new javax.swing.JTextField();
        txtMinVelEspEspecial = new javax.swing.JTextField();
        txtMaxVelEspEspecial = new javax.swing.JTextField();
        txtPromVelEspEspecial = new javax.swing.JTextField();
        txtInsVelEspEspecial = new javax.swing.JTextField();
        txtVolVelEspEspecial = new javax.swing.JTextField();
        txtMinResVelGenEspecial = new javax.swing.JTextField();
        txtMaxResVelGenEspecial = new javax.swing.JTextField();
        txtPromResVelGenEspecial = new javax.swing.JTextField();
        txtInsResVelGenEspecial = new javax.swing.JTextField();
        txtVolResVelGenEspecial = new javax.swing.JTextField();
        txtMinResVelEspEspecial = new javax.swing.JTextField();
        txtMaxResVelEspEspecial = new javax.swing.JTextField();
        txtPromResVelEspEspecial = new javax.swing.JTextField();
        txtInsResVelEspEspecial = new javax.swing.JTextField();
        txtVolResVelEspEspecial = new javax.swing.JTextField();
        txtMinFuerzaGenEspecial = new javax.swing.JTextField();
        txtMaxFuerzaGenEspecial = new javax.swing.JTextField();
        txtPromFuerzaGenEspecial = new javax.swing.JTextField();
        txtInsFuerzaGenEspecial = new javax.swing.JTextField();
        txtVolFuerzaGenEspecial = new javax.swing.JTextField();
        txtMinFuerzaEspEspecial = new javax.swing.JTextField();
        txtMaxFuerzaEspEspecial = new javax.swing.JTextField();
        txtPromFuerzaEspEspecial = new javax.swing.JTextField();
        txtInsFuerzaEspEspecial = new javax.swing.JTextField();
        txtVolFuerzaEspEspecial = new javax.swing.JTextField();
        txtMinCoordTecnEspecial = new javax.swing.JTextField();
        txtMaxCoordTecnEspecial = new javax.swing.JTextField();
        txtPromCoordTecnEspecial = new javax.swing.JTextField();
        txtInsCoordTecnEspecial = new javax.swing.JTextField();
        txtVolCoordTecnEspecial = new javax.swing.JTextField();
        txtMinFlexibilidadEspecial = new javax.swing.JTextField();
        txtMaxFlexibilidadEspecial = new javax.swing.JTextField();
        txtPromFlexibilidadEspecial = new javax.swing.JTextField();
        txtInsFlexibilidadEspecial = new javax.swing.JTextField();
        txtVolFlexibilidadEspecial = new javax.swing.JTextField();
        pnlCompetitiva = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEtapaCompetitiva = new javax.swing.JTable();
        txtMinRAGCompetitiva = new javax.swing.JTextField();
        txtMaxRAGCompetitiva = new javax.swing.JTextField();
        txtPromRAGCompetitiva = new javax.swing.JTextField();
        txtInsRAGCompetitiva = new javax.swing.JTextField();
        txtVolRAGCompetitiva = new javax.swing.JTextField();
        txtMinRAECompetitiva = new javax.swing.JTextField();
        txtMaxRAECompetitiva = new javax.swing.JTextField();
        txtPromRAECompetitiva = new javax.swing.JTextField();
        txtInsRAECompetitiva = new javax.swing.JTextField();
        txtVolRAECompetitiva = new javax.swing.JTextField();
        txtMinVelGenCompetitiva = new javax.swing.JTextField();
        txtMaxVelGenCompetitiva = new javax.swing.JTextField();
        txtPromVelGenCompetitiva = new javax.swing.JTextField();
        txtInsVelGenCompetitiva = new javax.swing.JTextField();
        txtVolVelGenCompetitiva = new javax.swing.JTextField();
        txtMinVelEspCompetitiva = new javax.swing.JTextField();
        txtMaxVelEspCompetitiva = new javax.swing.JTextField();
        txtPromVelEspCompetitiva = new javax.swing.JTextField();
        txtInsVelEspCompetitiva = new javax.swing.JTextField();
        txtVolVelEspCompetitiva = new javax.swing.JTextField();
        txtMinResVelGenCompetitiva = new javax.swing.JTextField();
        txtMaxResVelGenCompetitiva = new javax.swing.JTextField();
        txtPromResVelGenCompetitiva = new javax.swing.JTextField();
        txtInsResVelGenCompetitiva = new javax.swing.JTextField();
        txtVolResVelGenCompetitiva = new javax.swing.JTextField();
        txtMinResVelEspCompetitiva = new javax.swing.JTextField();
        txtMaxResVelEspCompetitiva = new javax.swing.JTextField();
        txtPromResVelEspCompetitiva = new javax.swing.JTextField();
        txtInsResVelEspCompetitiva = new javax.swing.JTextField();
        txtVolResVelEspCompetitiva = new javax.swing.JTextField();
        txtMinFuerzaGenCompetitiva = new javax.swing.JTextField();
        txtMaxFuerzaGenCompetitiva = new javax.swing.JTextField();
        txtPromFuerzaGenCompetitiva = new javax.swing.JTextField();
        txtInsFuerzaGenCompetitiva = new javax.swing.JTextField();
        txtVolFuerzaGenCompetitiva = new javax.swing.JTextField();
        txtMinFuerzaEspCompetitiva = new javax.swing.JTextField();
        txtMaxFuerzaEspCompetitiva = new javax.swing.JTextField();
        txtPromFuerzaEspCompetitiva = new javax.swing.JTextField();
        txtInsFuerzaEspCompetitiva = new javax.swing.JTextField();
        txtVolFuerzaEspCompetitiva = new javax.swing.JTextField();
        txtMinCoordTecnCompetitiva = new javax.swing.JTextField();
        txtMaxCoordTecnCompetitiva = new javax.swing.JTextField();
        txtPromCoordTecnCompetitiva = new javax.swing.JTextField();
        txtInsCoordTecnCompetitiva = new javax.swing.JTextField();
        txtVolCoordTecnCompetitiva = new javax.swing.JTextField();
        txtMinFlexibilidadCompetitiva = new javax.swing.JTextField();
        txtMaxFlexibilidadCompetitiva = new javax.swing.JTextField();
        txtPromFlexibilidadCompetitiva = new javax.swing.JTextField();
        txtInsFlexibilidadCompetitiva = new javax.swing.JTextField();
        txtVolFlexibilidadCompetitiva = new javax.swing.JTextField();
        btnCalcularPromVolGeneral = new javax.swing.JButton();
        btnCalcularPromVolEspecial = new javax.swing.JButton();
        btnCalcularPromVolCompetitiva = new javax.swing.JButton();

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

        btnVaciarTabla.setBackground(new java.awt.Color(204, 103, 118));
        btnVaciarTabla.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnVaciarTabla.setText("Vaciar Tabla");
        btnVaciarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVaciarTabla.setOpaque(true);
        btnVaciarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarTablaActionPerformed(evt);
            }
        });

        lblTituloTabla.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTituloTabla.setText("Calculadora de Volumen");

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
        tblEtapaGeneral.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tblEtapaGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Min.", "Max.", "Prom.", "Ins.", "Vol."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
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

        txtMinRAGGeneral.setText("3");
        txtMinRAGGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMaxRAGGeneral.setText("6");
        txtMaxRAGGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtPromRAGGeneral.setEditable(false);
        txtPromRAGGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtInsRAGGeneral.setText("3");
        txtInsRAGGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtVolRAGGeneral.setEditable(false);
        txtVolRAGGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMinRAEGeneral.setText("15");
        txtMinRAEGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMaxRAEGeneral.setText("25");
        txtMaxRAEGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtPromRAEGeneral.setEditable(false);
        txtPromRAEGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtInsRAEGeneral.setText("3");
        txtInsRAEGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtVolRAEGeneral.setEditable(false);
        txtVolRAEGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMinVelGenGeneral.setText("120");
        txtMinVelGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMaxVelGenGeneral.setText("300");
        txtMaxVelGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtPromVelGenGeneral.setEditable(false);
        txtPromVelGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtInsVelGenGeneral.setText("2");
        txtInsVelGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtVolVelGenGeneral.setEditable(false);
        txtVolVelGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMinVelEspGeneral.setText("0");
        txtMinVelEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMaxVelEspGeneral.setText("0");
        txtMaxVelEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtPromVelEspGeneral.setEditable(false);
        txtPromVelEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtInsVelEspGeneral.setText("0");
        txtInsVelEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtVolVelEspGeneral.setEditable(false);
        txtVolVelEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMinResVelGenGeneral.setText("600");
        txtMinResVelGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMaxResVelGenGeneral.setText("1500");
        txtMaxResVelGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtPromResVelGenGeneral.setEditable(false);
        txtPromResVelGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtInsResVelGenGeneral.setText("2");
        txtInsResVelGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtVolResVelGenGeneral.setEditable(false);
        txtVolResVelGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMinResVelEspGeneral.setText("0");
        txtMinResVelEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMaxResVelEspGeneral.setText("0");
        txtMaxResVelEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtPromResVelEspGeneral.setEditable(false);
        txtPromResVelEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtInsResVelEspGeneral.setText("0");
        txtInsResVelEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtVolResVelEspGeneral.setEditable(false);
        txtVolResVelEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMinFuerzaGenGeneral.setText("600");
        txtMinFuerzaGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMaxFuerzaGenGeneral.setText("1000");
        txtMaxFuerzaGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtPromFuerzaGenGeneral.setEditable(false);
        txtPromFuerzaGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtInsFuerzaGenGeneral.setText("3");
        txtInsFuerzaGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtVolFuerzaGenGeneral.setEditable(false);
        txtVolFuerzaGenGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMinFuerzaEspGeneral.setText("50");
        txtMinFuerzaEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMaxFuerzaEspGeneral.setText("150");
        txtMaxFuerzaEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtPromFuerzaEspGeneral.setEditable(false);
        txtPromFuerzaEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtInsFuerzaEspGeneral.setText("2");
        txtInsFuerzaEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtVolFuerzaEspGeneral.setEditable(false);
        txtVolFuerzaEspGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMinCoordTecnGeneral.setText("200");
        txtMinCoordTecnGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMaxCoordTecnGeneral.setText("500");
        txtMaxCoordTecnGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtPromCoordTecnGeneral.setEditable(false);
        txtPromCoordTecnGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtInsCoordTecnGeneral.setText("5");
        txtInsCoordTecnGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtVolCoordTecnGeneral.setEditable(false);
        txtVolCoordTecnGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMinFlexibilidadGeneral.setText("20");
        txtMinFlexibilidadGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtMaxFlexibilidadGeneral.setText("30");
        txtMaxFlexibilidadGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtPromFlexibilidadGeneral.setEditable(false);
        txtPromFlexibilidadGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtInsFlexibilidadGeneral.setText("3");
        txtInsFlexibilidadGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        txtVolFlexibilidadGeneral.setEditable(false);
        txtVolFlexibilidadGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaGeneralKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(81, 81, 81))
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlGeneralLayout.createSequentialGroup()
                            .addComponent(txtMinCoordTecnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxCoordTecnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromCoordTecnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsCoordTecnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolCoordTecnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlGeneralLayout.createSequentialGroup()
                            .addComponent(txtMinFuerzaEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxFuerzaEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromFuerzaEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsFuerzaEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolFuerzaEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlGeneralLayout.createSequentialGroup()
                            .addComponent(txtMinFuerzaGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxFuerzaGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromFuerzaGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsFuerzaGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolFuerzaGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlGeneralLayout.createSequentialGroup()
                            .addComponent(txtMinResVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxResVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromResVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsResVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolResVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlGeneralLayout.createSequentialGroup()
                            .addComponent(txtMinResVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxResVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromResVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsResVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolResVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGeneralLayout.createSequentialGroup()
                                .addComponent(txtMinRAGGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxRAGGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromRAGGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsRAGGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolRAGGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlGeneralLayout.createSequentialGroup()
                                .addComponent(txtMinRAEGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxRAEGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromRAEGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsRAEGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolRAEGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlGeneralLayout.createSequentialGroup()
                                .addComponent(txtMinVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlGeneralLayout.createSequentialGroup()
                                .addComponent(txtMinVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addComponent(txtMinFlexibilidadGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtMaxFlexibilidadGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtPromFlexibilidadGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtInsFlexibilidadGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtVolFlexibilidadGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 1, Short.MAX_VALUE))
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinRAGGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxRAGGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromRAGGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsRAGGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolRAGGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinRAEGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxRAEGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromRAEGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsRAEGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolRAEGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinResVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxResVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromResVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsResVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolResVelGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinResVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxResVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromResVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsResVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolResVelEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinFuerzaGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxFuerzaGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromFuerzaGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsFuerzaGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolFuerzaGenGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinFuerzaEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxFuerzaEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromFuerzaEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsFuerzaEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolFuerzaEspGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinCoordTecnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxCoordTecnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromCoordTecnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsCoordTecnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolCoordTecnGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinFlexibilidadGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxFlexibilidadGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromFlexibilidadGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsFlexibilidadGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolFlexibilidadGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlEspecial.setBackground(new java.awt.Color(255, 204, 51));

        jLabel3.setBackground(new java.awt.Color(0, 153, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Etapa Especial");

        tblEtapaEspecial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEtapaEspecial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblEtapaEspecial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Min.", "Max.", "Prom.", "Ins.", "Vol."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
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

        txtMinRAGEspecial.setText("4");
        txtMinRAGEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMaxRAGEspecial.setText("6");
        txtMaxRAGEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtPromRAGEspecial.setEditable(false);
        txtPromRAGEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtInsRAGEspecial.setText("3");
        txtInsRAGEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtVolRAGEspecial.setEditable(false);
        txtVolRAGEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMinRAEEspecial.setText("20");
        txtMinRAEEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMaxRAEEspecial.setText("40");
        txtMaxRAEEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtPromRAEEspecial.setEditable(false);
        txtPromRAEEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtInsRAEEspecial.setText("3");
        txtInsRAEEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtVolRAEEspecial.setEditable(false);
        txtVolRAEEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMinVelGenEspecial.setText("0");
        txtMinVelGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMaxVelGenEspecial.setText("0");
        txtMaxVelGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtPromVelGenEspecial.setEditable(false);
        txtPromVelGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtInsVelGenEspecial.setText("0");
        txtInsVelGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtVolVelGenEspecial.setEditable(false);
        txtVolVelGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMinVelEspEspecial.setText("80");
        txtMinVelEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMaxVelEspEspecial.setText("150");
        txtMaxVelEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtPromVelEspEspecial.setEditable(false);
        txtPromVelEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtInsVelEspEspecial.setText("2");
        txtInsVelEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtVolVelEspEspecial.setEditable(false);
        txtVolVelEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMinResVelGenEspecial.setText("500");
        txtMinResVelGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMaxResVelGenEspecial.setText("800");
        txtMaxResVelGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtPromResVelGenEspecial.setEditable(false);
        txtPromResVelGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtInsResVelGenEspecial.setText("2");
        txtInsResVelGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtVolResVelGenEspecial.setEditable(false);
        txtVolResVelGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMinResVelEspEspecial.setText("6");
        txtMinResVelEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMaxResVelEspEspecial.setText("15");
        txtMaxResVelEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtPromResVelEspEspecial.setEditable(false);
        txtPromResVelEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtInsResVelEspEspecial.setText("2");
        txtInsResVelEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtVolResVelEspEspecial.setEditable(false);
        txtVolResVelEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMinFuerzaGenEspecial.setText("500");
        txtMinFuerzaGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMaxFuerzaGenEspecial.setText("800");
        txtMaxFuerzaGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtPromFuerzaGenEspecial.setEditable(false);
        txtPromFuerzaGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtInsFuerzaGenEspecial.setText("3");
        txtInsFuerzaGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtVolFuerzaGenEspecial.setEditable(false);
        txtVolFuerzaGenEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMinFuerzaEspEspecial.setText("50");
        txtMinFuerzaEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMaxFuerzaEspEspecial.setText("120");
        txtMaxFuerzaEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtPromFuerzaEspEspecial.setEditable(false);
        txtPromFuerzaEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtInsFuerzaEspEspecial.setText("2");
        txtInsFuerzaEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtVolFuerzaEspEspecial.setEditable(false);
        txtVolFuerzaEspEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMinCoordTecnEspecial.setText("100");
        txtMinCoordTecnEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMaxCoordTecnEspecial.setText("300");
        txtMaxCoordTecnEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtPromCoordTecnEspecial.setEditable(false);
        txtPromCoordTecnEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtInsCoordTecnEspecial.setText("5");
        txtInsCoordTecnEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtVolCoordTecnEspecial.setEditable(false);
        txtVolCoordTecnEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMinFlexibilidadEspecial.setText("20");
        txtMinFlexibilidadEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtMaxFlexibilidadEspecial.setText("30");
        txtMaxFlexibilidadEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtPromFlexibilidadEspecial.setEditable(false);
        txtPromFlexibilidadEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtInsFlexibilidadEspecial.setText("2");
        txtInsFlexibilidadEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        txtVolFlexibilidadEspecial.setEditable(false);
        txtVolFlexibilidadEspecial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaEspecialKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlEspecialLayout = new javax.swing.GroupLayout(pnlEspecial);
        pnlEspecial.setLayout(pnlEspecialLayout);
        pnlEspecialLayout.setHorizontalGroup(
            pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEspecialLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(89, 89, 89))
            .addGroup(pnlEspecialLayout.createSequentialGroup()
                .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlEspecialLayout.createSequentialGroup()
                            .addComponent(txtMinCoordTecnEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxCoordTecnEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromCoordTecnEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsCoordTecnEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolCoordTecnEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlEspecialLayout.createSequentialGroup()
                            .addComponent(txtMinFuerzaEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxFuerzaEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromFuerzaEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsFuerzaEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolFuerzaEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlEspecialLayout.createSequentialGroup()
                            .addComponent(txtMinFuerzaGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxFuerzaGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromFuerzaGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsFuerzaGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolFuerzaGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlEspecialLayout.createSequentialGroup()
                            .addComponent(txtMinResVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxResVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromResVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsResVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolResVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlEspecialLayout.createSequentialGroup()
                            .addComponent(txtMinResVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxResVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromResVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsResVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolResVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEspecialLayout.createSequentialGroup()
                                .addComponent(txtMinRAGEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxRAGEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromRAGEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsRAGEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolRAGEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlEspecialLayout.createSequentialGroup()
                                .addComponent(txtMinRAEEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxRAEEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromRAEEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsRAEEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolRAEEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlEspecialLayout.createSequentialGroup()
                                .addComponent(txtMinVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlEspecialLayout.createSequentialGroup()
                                .addComponent(txtMinVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlEspecialLayout.createSequentialGroup()
                        .addComponent(txtMinFlexibilidadEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtMaxFlexibilidadEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtPromFlexibilidadEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtInsFlexibilidadEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtVolFlexibilidadEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlEspecialLayout.setVerticalGroup(
            pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEspecialLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinRAGEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxRAGEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromRAGEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsRAGEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolRAGEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinRAEEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxRAEEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromRAEEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsRAEEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolRAEEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinResVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxResVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromResVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsResVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolResVelGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinResVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxResVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromResVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsResVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolResVelEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinFuerzaGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxFuerzaGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromFuerzaGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsFuerzaGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolFuerzaGenEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinFuerzaEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxFuerzaEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromFuerzaEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsFuerzaEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolFuerzaEspEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinCoordTecnEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxCoordTecnEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromCoordTecnEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsCoordTecnEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolCoordTecnEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlEspecialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinFlexibilidadEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxFlexibilidadEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromFlexibilidadEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsFlexibilidadEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolFlexibilidadEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlCompetitiva.setBackground(new java.awt.Color(255, 51, 51));

        jLabel4.setBackground(new java.awt.Color(0, 153, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Etapa Competitiva");

        tblEtapaCompetitiva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEtapaCompetitiva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblEtapaCompetitiva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Min.", "Max.", "Prom.", "Ins.", "Vol."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
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

        txtMinRAGCompetitiva.setText("3");
        txtMinRAGCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMaxRAGCompetitiva.setText("4");
        txtMaxRAGCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtPromRAGCompetitiva.setEditable(false);
        txtPromRAGCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtInsRAGCompetitiva.setText("2");
        txtInsRAGCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtVolRAGCompetitiva.setEditable(false);
        txtVolRAGCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMinRAECompetitiva.setText("15");
        txtMinRAECompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMaxRAECompetitiva.setText("30");
        txtMaxRAECompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtPromRAECompetitiva.setEditable(false);
        txtPromRAECompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtInsRAECompetitiva.setText("3");
        txtInsRAECompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtVolRAECompetitiva.setEditable(false);
        txtVolRAECompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMinVelGenCompetitiva.setText("0");
        txtMinVelGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMaxVelGenCompetitiva.setText("0");
        txtMaxVelGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtPromVelGenCompetitiva.setEditable(false);
        txtPromVelGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtInsVelGenCompetitiva.setText("0");
        txtInsVelGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtVolVelGenCompetitiva.setEditable(false);
        txtVolVelGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMinVelEspCompetitiva.setText("90");
        txtMinVelEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMaxVelEspCompetitiva.setText("150");
        txtMaxVelEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtPromVelEspCompetitiva.setEditable(false);
        txtPromVelEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtInsVelEspCompetitiva.setText("2");
        txtInsVelEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtVolVelEspCompetitiva.setEditable(false);
        txtVolVelEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMinResVelGenCompetitiva.setText("200");
        txtMinResVelGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMaxResVelGenCompetitiva.setText("400");
        txtMaxResVelGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtPromResVelGenCompetitiva.setEditable(false);
        txtPromResVelGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtInsResVelGenCompetitiva.setText("2");
        txtInsResVelGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtVolResVelGenCompetitiva.setEditable(false);
        txtVolResVelGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMinResVelEspCompetitiva.setText("5");
        txtMinResVelEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMaxResVelEspCompetitiva.setText("10");
        txtMaxResVelEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtPromResVelEspCompetitiva.setEditable(false);
        txtPromResVelEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtInsResVelEspCompetitiva.setText("2");
        txtInsResVelEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtVolResVelEspCompetitiva.setEditable(false);
        txtVolResVelEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMinFuerzaGenCompetitiva.setText("300");
        txtMinFuerzaGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMaxFuerzaGenCompetitiva.setText("500");
        txtMaxFuerzaGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtPromFuerzaGenCompetitiva.setEditable(false);
        txtPromFuerzaGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtInsFuerzaGenCompetitiva.setText("2");
        txtInsFuerzaGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtVolFuerzaGenCompetitiva.setEditable(false);
        txtVolFuerzaGenCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMinFuerzaEspCompetitiva.setText("50");
        txtMinFuerzaEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMaxFuerzaEspCompetitiva.setText("80");
        txtMaxFuerzaEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtPromFuerzaEspCompetitiva.setEditable(false);
        txtPromFuerzaEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtInsFuerzaEspCompetitiva.setText("3");
        txtInsFuerzaEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtVolFuerzaEspCompetitiva.setEditable(false);
        txtVolFuerzaEspCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMinCoordTecnCompetitiva.setText("100");
        txtMinCoordTecnCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMaxCoordTecnCompetitiva.setText("300");
        txtMaxCoordTecnCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtPromCoordTecnCompetitiva.setEditable(false);
        txtPromCoordTecnCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtInsCoordTecnCompetitiva.setText("5");
        txtInsCoordTecnCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtVolCoordTecnCompetitiva.setEditable(false);
        txtVolCoordTecnCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMinFlexibilidadCompetitiva.setText("20");
        txtMinFlexibilidadCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtMaxFlexibilidadCompetitiva.setText("30");
        txtMaxFlexibilidadCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtPromFlexibilidadCompetitiva.setEditable(false);
        txtPromFlexibilidadCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtInsFlexibilidadCompetitiva.setText("2");
        txtInsFlexibilidadCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        txtVolFlexibilidadCompetitiva.setEditable(false);
        txtVolFlexibilidadCompetitiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtapaCompetitivaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlCompetitivaLayout = new javax.swing.GroupLayout(pnlCompetitiva);
        pnlCompetitiva.setLayout(pnlCompetitivaLayout);
        pnlCompetitivaLayout.setHorizontalGroup(
            pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCompetitivaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(61, 61, 61))
            .addGroup(pnlCompetitivaLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlCompetitivaLayout.createSequentialGroup()
                            .addComponent(txtMinCoordTecnCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxCoordTecnCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromCoordTecnCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsCoordTecnCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolCoordTecnCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlCompetitivaLayout.createSequentialGroup()
                            .addComponent(txtMinFuerzaEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxFuerzaEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromFuerzaEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsFuerzaEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolFuerzaEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlCompetitivaLayout.createSequentialGroup()
                            .addComponent(txtMinFuerzaGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxFuerzaGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromFuerzaGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsFuerzaGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolFuerzaGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlCompetitivaLayout.createSequentialGroup()
                            .addComponent(txtMinResVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxResVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromResVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsResVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolResVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlCompetitivaLayout.createSequentialGroup()
                            .addComponent(txtMinResVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtMaxResVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtPromResVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtInsResVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)
                            .addComponent(txtVolResVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCompetitivaLayout.createSequentialGroup()
                                .addComponent(txtMinRAGCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxRAGCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromRAGCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsRAGCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolRAGCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCompetitivaLayout.createSequentialGroup()
                                .addComponent(txtMinRAECompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxRAECompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromRAECompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsRAECompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolRAECompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCompetitivaLayout.createSequentialGroup()
                                .addComponent(txtMinVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCompetitivaLayout.createSequentialGroup()
                                .addComponent(txtMinVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtMaxVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtPromVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtInsVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(txtVolVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlCompetitivaLayout.createSequentialGroup()
                        .addComponent(txtMinFlexibilidadCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtMaxFlexibilidadCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtPromFlexibilidadCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtInsFlexibilidadCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtVolFlexibilidadCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1))
        );
        pnlCompetitivaLayout.setVerticalGroup(
            pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCompetitivaLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinRAGCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxRAGCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromRAGCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsRAGCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolRAGCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinRAECompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxRAECompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromRAECompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsRAECompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolRAECompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinResVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxResVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromResVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsResVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolResVelGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinResVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxResVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromResVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsResVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolResVelEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinFuerzaGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxFuerzaGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromFuerzaGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsFuerzaGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolFuerzaGenCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinFuerzaEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxFuerzaEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromFuerzaEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsFuerzaEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolFuerzaEspCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinCoordTecnCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxCoordTecnCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromCoordTecnCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsCoordTecnCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolCoordTecnCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlCompetitivaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinFlexibilidadCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaxFlexibilidadCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPromFlexibilidadCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtInsFlexibilidadCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolFlexibilidadCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnCalcularPromVolGeneral.setBackground(new java.awt.Color(51, 204, 255));
        btnCalcularPromVolGeneral.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnCalcularPromVolGeneral.setText("Calcular");
        btnCalcularPromVolGeneral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcularPromVolGeneral.setOpaque(true);
        btnCalcularPromVolGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPromVolGeneralActionPerformed(evt);
            }
        });

        btnCalcularPromVolEspecial.setBackground(new java.awt.Color(51, 204, 255));
        btnCalcularPromVolEspecial.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnCalcularPromVolEspecial.setText("Calcular");
        btnCalcularPromVolEspecial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcularPromVolEspecial.setOpaque(true);
        btnCalcularPromVolEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPromVolEspecialActionPerformed(evt);
            }
        });

        btnCalcularPromVolCompetitiva.setBackground(new java.awt.Color(51, 204, 255));
        btnCalcularPromVolCompetitiva.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnCalcularPromVolCompetitiva.setText("Calcular");
        btnCalcularPromVolCompetitiva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcularPromVolCompetitiva.setOpaque(true);
        btnCalcularPromVolCompetitiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPromVolCompetitivaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFrameLayout = new javax.swing.GroupLayout(pnlFrame);
        pnlFrame.setLayout(pnlFrameLayout);
        pnlFrameLayout.setHorizontalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCalcularPromVolGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCalcularPromVolEspecial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEspecial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(pnlCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlFrameLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalcularPromVolCompetitiva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFrameLayout.setVerticalGroup(
            pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlCompetitiva, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlEspecial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(pnlFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcularPromVolGeneral)
                    .addComponent(btnCalcularPromVolEspecial)
                    .addComponent(btnCalcularPromVolCompetitiva))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
            .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblRAG)
                                    .addComponent(lblResVelGen)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(85, 85, 85)
                                            .addComponent(lblRAE))
                                        .addComponent(lblVelGeneral)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addComponent(lblVelEspecial))
                                        .addComponent(btnVaciarTabla))
                                    .addComponent(lblResVelEsp)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(lblFuerzaGen))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(lblFuerzaEsp))
                                        .addComponent(lblCoordTecn))
                                    .addComponent(lblFlexibilidad))
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnFinalizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(pnlFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSemanasGeneral)
                        .addGap(6, 6, 6)
                        .addComponent(lblNumSemanasGeneral)
                        .addGap(187, 187, 187)
                        .addComponent(lblSemanasEspecial)
                        .addGap(6, 6, 6)
                        .addComponent(lblNumSemanasEspecial)
                        .addGap(218, 218, 218)
                        .addComponent(lblSemanasCompetitiva)
                        .addGap(6, 6, 6)
                        .addComponent(lblNumSemanasCompetitiva)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTituloTabla)
                        .addGap(333, 333, 333))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblEncabezadoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblEncabezadoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloTabla)
                    .addComponent(btnVaciarTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSemanasGeneral)
                    .addComponent(lblNumSemanasGeneral)
                    .addComponent(lblSemanasEspecial, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNumSemanasEspecial)
                    .addComponent(lblSemanasCompetitiva, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNumSemanasCompetitiva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRAG)
                        .addGap(3, 3, 3)
                        .addComponent(lblRAE)
                        .addGap(3, 3, 3)
                        .addComponent(lblVelGeneral)
                        .addGap(3, 3, 3)
                        .addComponent(lblVelEspecial)
                        .addGap(3, 3, 3)
                        .addComponent(lblResVelGen)
                        .addGap(3, 3, 3)
                        .addComponent(lblResVelEsp)
                        .addGap(3, 3, 3)
                        .addComponent(lblFuerzaGen)
                        .addGap(3, 3, 3)
                        .addComponent(lblFuerzaEsp)
                        .addGap(3, 3, 3)
                        .addComponent(lblCoordTecn)
                        .addGap(3, 3, 3)
                        .addComponent(lblFlexibilidad)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizar))
                    .addComponent(pnlFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        btnCalcularPromVolGeneralActionPerformed(evt);
        btnCalcularPromVolEspecialActionPerformed(evt);
        btnCalcularPromVolCompetitivaActionPerformed(evt);

        registrarMedios(); // Generar los medios y relacionarlos a cada etapa 

        try {
            // Se abre el panel de entrenador
            new PanelEntrenador(this.entrenador).setVisible(true);
            this.dispose(); // Se cierra la ventana actual
        } catch (Exception ex) {
            Logger.getLogger(Paso3Medios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnCalcularPromVolGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPromVolGeneralActionPerformed
        try {
            float promRAG = 0, promRAE = 0, promVelGen = 0, promVelEsp = 0, promResVelGen = 0, promResVelEsp = 0, promFuerzaGen = 0, promFuerzaEsp = 0, promCoordTecn = 0, promFlexibilidad = 0;
            float volRAG = 0, volRAE = 0, volVelGen = 0, volVelEsp = 0, volResVelGen = 0, volResVelEsp = 0, volFuerzaGen = 0, volFuerzaEsp = 0, volCoordTecn = 0, volFlexibilidad = 0;

            // Se calculan promedios
            promRAG = (Integer.valueOf(this.txtMinRAGGeneral.getText()) + Integer.valueOf(this.txtMaxRAGGeneral.getText())) / 2;
            promRAE = (Integer.valueOf(this.txtMinRAEGeneral.getText()) + Integer.valueOf(this.txtMaxRAEGeneral.getText())) / 2;
            promVelGen = (Integer.valueOf(this.txtMinVelGenGeneral.getText()) + Integer.valueOf(this.txtMaxVelGenGeneral.getText())) / 2;
            promVelEsp = (Integer.valueOf(this.txtMinVelEspGeneral.getText()) + Integer.valueOf(this.txtMaxVelEspGeneral.getText())) / 2;
            promResVelGen = (Integer.valueOf(this.txtMinResVelGenGeneral.getText()) + Integer.valueOf(this.txtMaxResVelGenGeneral.getText())) / 2;
            promResVelEsp = (Integer.valueOf(this.txtMinResVelEspGeneral.getText()) + Integer.valueOf(this.txtMaxResVelEspGeneral.getText())) / 2;
            promFuerzaGen = (Integer.valueOf(this.txtMinFuerzaGenGeneral.getText()) + Integer.valueOf(this.txtMaxFuerzaGenGeneral.getText())) / 2;
            promFuerzaEsp = (Integer.valueOf(this.txtMinFuerzaEspGeneral.getText()) + Integer.valueOf(this.txtMaxFuerzaEspGeneral.getText())) / 2;
            promCoordTecn = (Integer.valueOf(this.txtMinCoordTecnGeneral.getText()) + Integer.valueOf(this.txtMaxCoordTecnGeneral.getText())) / 2;
            promFlexibilidad = (Integer.valueOf(this.txtMinFlexibilidadGeneral.getText()) + Integer.valueOf(this.txtMaxFlexibilidadGeneral.getText())) / 2;

            // Se muestran insertan en tabla promedios
            this.txtPromRAGGeneral.setText(String.valueOf(promRAG));
            this.txtPromRAEGeneral.setText(String.valueOf(promRAE));
            this.txtPromVelGenGeneral.setText(String.valueOf(promVelGen));
            this.txtPromVelEspGeneral.setText(String.valueOf(promVelEsp));
            this.txtPromResVelGenGeneral.setText(String.valueOf(promResVelGen));
            this.txtPromResVelEspGeneral.setText(String.valueOf(promResVelEsp));
            this.txtPromFuerzaGenGeneral.setText(String.valueOf(promFuerzaGen));
            this.txtPromFuerzaEspGeneral.setText(String.valueOf(promFuerzaEsp));
            this.txtPromCoordTecnGeneral.setText(String.valueOf(promCoordTecn));
            this.txtPromFlexibilidadGeneral.setText(String.valueOf(promFlexibilidad));

            // Se calculan volumenes
            Integer duracionEtapa = this.etapaGeneral.getDuracionSemanas();
            volRAG = Float.valueOf(this.txtPromRAGGeneral.getText()) * Float.valueOf(this.txtInsRAGGeneral.getText()) * duracionEtapa;
            volRAE = Float.valueOf(this.txtPromRAEGeneral.getText()) * Float.valueOf(this.txtInsRAEGeneral.getText()) * duracionEtapa;
            volVelGen = Float.valueOf(this.txtPromVelGenGeneral.getText()) * Float.valueOf(this.txtInsVelGenGeneral.getText()) * duracionEtapa;
            volVelEsp = Float.valueOf(this.txtPromVelEspGeneral.getText()) * Float.valueOf(this.txtInsVelEspGeneral.getText()) * duracionEtapa;
            volResVelGen = Float.valueOf(this.txtPromResVelGenGeneral.getText()) * Float.valueOf(this.txtInsResVelGenGeneral.getText()) * duracionEtapa;
            volResVelEsp = Float.valueOf(this.txtPromResVelEspGeneral.getText()) * Float.valueOf(this.txtInsResVelEspGeneral.getText()) * duracionEtapa;
            volFuerzaGen = Float.valueOf(this.txtPromFuerzaGenGeneral.getText()) * Float.valueOf(this.txtInsFuerzaGenGeneral.getText()) * duracionEtapa;
            volFuerzaEsp = Float.valueOf(this.txtPromFuerzaEspGeneral.getText()) * Float.valueOf(this.txtInsFuerzaEspGeneral.getText()) * duracionEtapa;
            volCoordTecn = Float.valueOf(this.txtPromCoordTecnGeneral.getText()) * Float.valueOf(this.txtInsCoordTecnGeneral.getText()) * duracionEtapa;
            volFlexibilidad = Float.valueOf(this.txtPromFlexibilidadGeneral.getText()) * Float.valueOf(this.txtInsFlexibilidadGeneral.getText()) * duracionEtapa;

            // Se muestran insertan en tabla volumenes
            this.txtVolRAGGeneral.setText(String.valueOf(volRAG));
            this.txtVolRAEGeneral.setText(String.valueOf(volRAE));
            this.txtVolVelGenGeneral.setText(String.valueOf(volVelGen));
            this.txtVolVelEspGeneral.setText(String.valueOf(volVelEsp));
            this.txtVolResVelGenGeneral.setText(String.valueOf(volResVelGen));
            this.txtVolResVelEspGeneral.setText(String.valueOf(volResVelEsp));
            this.txtVolFuerzaGenGeneral.setText(String.valueOf(volFuerzaGen));
            this.txtVolFuerzaEspGeneral.setText(String.valueOf(volFuerzaEsp));
            this.txtVolCoordTecnGeneral.setText(String.valueOf(volCoordTecn));
            this.txtVolFlexibilidadGeneral.setText(String.valueOf(volFlexibilidad));
        } catch (NumberFormatException e) {
            // Si algún campo está vacío, se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Ningún campo de registro puede estar vacío.", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCalcularPromVolGeneralActionPerformed

    private void btnCalcularPromVolEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPromVolEspecialActionPerformed
        try {
            float promRAG = 0, promRAE = 0, promVelGen = 0, promVelEsp = 0, promResVelGen = 0, promResVelEsp = 0, promFuerzaGen = 0, promFuerzaEsp = 0, promCoordTecn = 0, promFlexibilidad = 0;
            float volRAG = 0, volRAE = 0, volVelGen = 0, volVelEsp = 0, volResVelGen = 0, volResVelEsp = 0, volFuerzaGen = 0, volFuerzaEsp = 0, volCoordTecn = 0, volFlexibilidad = 0;

            // Se calculan promedios
            promRAG = (Integer.valueOf(this.txtMinRAGEspecial.getText()) + Integer.valueOf(this.txtMaxRAGEspecial.getText())) / 2;
            promRAE = (Integer.valueOf(this.txtMinRAEEspecial.getText()) + Integer.valueOf(this.txtMaxRAEEspecial.getText())) / 2;
            promVelGen = (Integer.valueOf(this.txtMinVelGenEspecial.getText()) + Integer.valueOf(this.txtMaxVelGenEspecial.getText())) / 2;
            promVelEsp = (Integer.valueOf(this.txtMinVelEspEspecial.getText()) + Integer.valueOf(this.txtMaxVelEspEspecial.getText())) / 2;
            promResVelGen = (Integer.valueOf(this.txtMinResVelGenEspecial.getText()) + Integer.valueOf(this.txtMaxResVelGenEspecial.getText())) / 2;
            promResVelEsp = (Integer.valueOf(this.txtMinResVelEspEspecial.getText()) + Integer.valueOf(this.txtMaxResVelEspEspecial.getText())) / 2;
            promFuerzaGen = (Integer.valueOf(this.txtMinFuerzaGenEspecial.getText()) + Integer.valueOf(this.txtMaxFuerzaGenEspecial.getText())) / 2;
            promFuerzaEsp = (Integer.valueOf(this.txtMinFuerzaEspEspecial.getText()) + Integer.valueOf(this.txtMaxFuerzaEspEspecial.getText())) / 2;
            promCoordTecn = (Integer.valueOf(this.txtMinCoordTecnEspecial.getText()) + Integer.valueOf(this.txtMaxCoordTecnEspecial.getText())) / 2;
            promFlexibilidad = (Integer.valueOf(this.txtMinFlexibilidadEspecial.getText()) + Integer.valueOf(this.txtMaxFlexibilidadEspecial.getText())) / 2;

            // Se muestran insertan en tabla promedios
            this.txtPromRAGEspecial.setText(String.valueOf(promRAG));
            this.txtPromRAEEspecial.setText(String.valueOf(promRAE));
            this.txtPromVelGenEspecial.setText(String.valueOf(promVelGen));
            this.txtPromVelEspEspecial.setText(String.valueOf(promVelEsp));
            this.txtPromResVelGenEspecial.setText(String.valueOf(promResVelGen));
            this.txtPromResVelEspEspecial.setText(String.valueOf(promResVelEsp));
            this.txtPromFuerzaGenEspecial.setText(String.valueOf(promFuerzaGen));
            this.txtPromFuerzaEspEspecial.setText(String.valueOf(promFuerzaEsp));
            this.txtPromCoordTecnEspecial.setText(String.valueOf(promCoordTecn));
            this.txtPromFlexibilidadEspecial.setText(String.valueOf(promFlexibilidad));

            // Se calculan volumenes
            Integer duracionEtapa = this.etapaEspecial.getDuracionSemanas();
            volRAG = Float.valueOf(this.txtPromRAGEspecial.getText()) * Float.valueOf(this.txtInsRAGEspecial.getText()) * duracionEtapa;
            volRAE = Float.valueOf(this.txtPromRAEEspecial.getText()) * Float.valueOf(this.txtInsRAEEspecial.getText()) * duracionEtapa;
            volVelGen = Float.valueOf(this.txtPromVelGenEspecial.getText()) * Float.valueOf(this.txtInsVelGenEspecial.getText()) * duracionEtapa;
            volVelEsp = Float.valueOf(this.txtPromVelEspEspecial.getText()) * Float.valueOf(this.txtInsVelEspEspecial.getText()) * duracionEtapa;
            volResVelGen = Float.valueOf(this.txtPromResVelGenEspecial.getText()) * Float.valueOf(this.txtInsResVelGenEspecial.getText()) * duracionEtapa;
            volResVelEsp = Float.valueOf(this.txtPromResVelEspEspecial.getText()) * Float.valueOf(this.txtInsResVelEspEspecial.getText()) * duracionEtapa;
            volFuerzaGen = Float.valueOf(this.txtPromFuerzaGenEspecial.getText()) * Float.valueOf(this.txtInsFuerzaGenEspecial.getText()) * duracionEtapa;
            volFuerzaEsp = Float.valueOf(this.txtPromFuerzaEspEspecial.getText()) * Float.valueOf(this.txtInsFuerzaEspEspecial.getText()) * duracionEtapa;
            volCoordTecn = Float.valueOf(this.txtPromCoordTecnEspecial.getText()) * Float.valueOf(this.txtInsCoordTecnEspecial.getText()) * duracionEtapa;
            volFlexibilidad = Float.valueOf(this.txtPromFlexibilidadEspecial.getText()) * Float.valueOf(this.txtInsFlexibilidadEspecial.getText()) * duracionEtapa;

            // Se muestran insertan en tabla volumenes
            this.txtVolRAGEspecial.setText(String.valueOf(volRAG));
            this.txtVolRAEEspecial.setText(String.valueOf(volRAE));
            this.txtVolVelGenEspecial.setText(String.valueOf(volVelGen));
            this.txtVolVelEspEspecial.setText(String.valueOf(volVelEsp));
            this.txtVolResVelGenEspecial.setText(String.valueOf(volResVelGen));
            this.txtVolResVelEspEspecial.setText(String.valueOf(volResVelEsp));
            this.txtVolFuerzaGenEspecial.setText(String.valueOf(volFuerzaGen));
            this.txtVolFuerzaEspEspecial.setText(String.valueOf(volFuerzaEsp));
            this.txtVolCoordTecnEspecial.setText(String.valueOf(volCoordTecn));
            this.txtVolFlexibilidadEspecial.setText(String.valueOf(volFlexibilidad));
        } catch (NumberFormatException e) {
            // Si algún campo está vacío, se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Ningún campo de registro puede estar vacío.", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCalcularPromVolEspecialActionPerformed

    private void btnCalcularPromVolCompetitivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPromVolCompetitivaActionPerformed
        try {
            float promRAG = 0, promRAE = 0, promVelGen = 0, promVelEsp = 0, promResVelGen = 0, promResVelEsp = 0, promFuerzaGen = 0, promFuerzaEsp = 0, promCoordTecn = 0, promFlexibilidad = 0;
            float volRAG = 0, volRAE = 0, volVelGen = 0, volVelEsp = 0, volResVelGen = 0, volResVelEsp = 0, volFuerzaGen = 0, volFuerzaEsp = 0, volCoordTecn = 0, volFlexibilidad = 0;

            // Se calculan promedios
            promRAG = (Integer.valueOf(this.txtMinRAGCompetitiva.getText()) + Integer.valueOf(this.txtMaxRAGCompetitiva.getText())) / 2;
            promRAE = (Integer.valueOf(this.txtMinRAECompetitiva.getText()) + Integer.valueOf(this.txtMaxRAECompetitiva.getText())) / 2;
            promVelGen = (Integer.valueOf(this.txtMinVelGenCompetitiva.getText()) + Integer.valueOf(this.txtMaxVelGenCompetitiva.getText())) / 2;
            promVelEsp = (Integer.valueOf(this.txtMinVelEspCompetitiva.getText()) + Integer.valueOf(this.txtMaxVelEspCompetitiva.getText())) / 2;
            promResVelGen = (Integer.valueOf(this.txtMinResVelGenCompetitiva.getText()) + Integer.valueOf(this.txtMaxResVelGenCompetitiva.getText())) / 2;
            promResVelEsp = (Integer.valueOf(this.txtMinResVelEspCompetitiva.getText()) + Integer.valueOf(this.txtMaxResVelEspCompetitiva.getText())) / 2;
            promFuerzaGen = (Integer.valueOf(this.txtMinFuerzaGenCompetitiva.getText()) + Integer.valueOf(this.txtMaxFuerzaGenCompetitiva.getText())) / 2;
            promFuerzaEsp = (Integer.valueOf(this.txtMinFuerzaEspCompetitiva.getText()) + Integer.valueOf(this.txtMaxFuerzaEspCompetitiva.getText())) / 2;
            promCoordTecn = (Integer.valueOf(this.txtMinCoordTecnCompetitiva.getText()) + Integer.valueOf(this.txtMaxCoordTecnCompetitiva.getText())) / 2;
            promFlexibilidad = (Integer.valueOf(this.txtMinFlexibilidadCompetitiva.getText()) + Integer.valueOf(this.txtMaxFlexibilidadCompetitiva.getText())) / 2;

            // Se muestran insertan en tabla promedios
            this.txtPromRAGCompetitiva.setText(String.valueOf(promRAG));
            this.txtPromRAECompetitiva.setText(String.valueOf(promRAE));
            this.txtPromVelGenCompetitiva.setText(String.valueOf(promVelGen));
            this.txtPromVelEspCompetitiva.setText(String.valueOf(promVelEsp));
            this.txtPromResVelGenCompetitiva.setText(String.valueOf(promResVelGen));
            this.txtPromResVelEspCompetitiva.setText(String.valueOf(promResVelEsp));
            this.txtPromFuerzaGenCompetitiva.setText(String.valueOf(promFuerzaGen));
            this.txtPromFuerzaEspCompetitiva.setText(String.valueOf(promFuerzaEsp));
            this.txtPromCoordTecnCompetitiva.setText(String.valueOf(promCoordTecn));
            this.txtPromFlexibilidadCompetitiva.setText(String.valueOf(promFlexibilidad));

            // Se calculan volumenes
            Integer duracionEtapa = this.etapaCompetitiva.getDuracionSemanas();
            volRAG = Float.valueOf(this.txtPromRAGCompetitiva.getText()) * Float.valueOf(this.txtInsRAGCompetitiva.getText()) * duracionEtapa;
            volRAE = Float.valueOf(this.txtPromRAECompetitiva.getText()) * Float.valueOf(this.txtInsRAECompetitiva.getText()) * duracionEtapa;
            volVelGen = Float.valueOf(this.txtPromVelGenCompetitiva.getText()) * Float.valueOf(this.txtInsVelGenCompetitiva.getText()) * duracionEtapa;
            volVelEsp = Float.valueOf(this.txtPromVelEspCompetitiva.getText()) * Float.valueOf(this.txtInsVelEspCompetitiva.getText()) * duracionEtapa;
            volResVelGen = Float.valueOf(this.txtPromResVelGenCompetitiva.getText()) * Float.valueOf(this.txtInsResVelGenCompetitiva.getText()) * duracionEtapa;
            volResVelEsp = Float.valueOf(this.txtPromResVelEspCompetitiva.getText()) * Float.valueOf(this.txtInsResVelEspCompetitiva.getText()) * duracionEtapa;
            volFuerzaGen = Float.valueOf(this.txtPromFuerzaGenCompetitiva.getText()) * Float.valueOf(this.txtInsFuerzaGenCompetitiva.getText()) * duracionEtapa;
            volFuerzaEsp = Float.valueOf(this.txtPromFuerzaEspCompetitiva.getText()) * Float.valueOf(this.txtInsFuerzaEspCompetitiva.getText()) * duracionEtapa;
            volCoordTecn = Float.valueOf(this.txtPromCoordTecnCompetitiva.getText()) * Float.valueOf(this.txtInsCoordTecnCompetitiva.getText()) * duracionEtapa;
            volFlexibilidad = Float.valueOf(this.txtPromFlexibilidadCompetitiva.getText()) * Float.valueOf(this.txtInsFlexibilidadCompetitiva.getText()) * duracionEtapa;

            // Se muestran insertan en tabla volumenes
            this.txtVolRAGCompetitiva.setText(String.valueOf(volRAG));
            this.txtVolRAECompetitiva.setText(String.valueOf(volRAE));
            this.txtVolVelGenCompetitiva.setText(String.valueOf(volVelGen));
            this.txtVolVelEspCompetitiva.setText(String.valueOf(volVelEsp));
            this.txtVolResVelGenCompetitiva.setText(String.valueOf(volResVelGen));
            this.txtVolResVelEspCompetitiva.setText(String.valueOf(volResVelEsp));
            this.txtVolFuerzaGenCompetitiva.setText(String.valueOf(volFuerzaGen));
            this.txtVolFuerzaEspCompetitiva.setText(String.valueOf(volFuerzaEsp));
            this.txtVolCoordTecnCompetitiva.setText(String.valueOf(volCoordTecn));
            this.txtVolFlexibilidadCompetitiva.setText(String.valueOf(volFlexibilidad));
        } catch (NumberFormatException e) {
            // Si algún campo está vacío, se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Ningún campo de registro puede estar vacío.", "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCalcularPromVolCompetitivaActionPerformed

    private void EtapaGeneralKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EtapaGeneralKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) || ((JTextField) evt.getSource()).getText().length() >= 5) {
            evt.consume();
        }
    }//GEN-LAST:event_EtapaGeneralKeyTyped

    private void EtapaEspecialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EtapaEspecialKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) || ((JTextField) evt.getSource()).getText().length() >= 5) {
            evt.consume();
        }
    }//GEN-LAST:event_EtapaEspecialKeyTyped

    private void EtapaCompetitivaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EtapaCompetitivaKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) || ((JTextField) evt.getSource()).getText().length() >= 5) {
            evt.consume();
        }
    }//GEN-LAST:event_EtapaCompetitivaKeyTyped

    private void btnVaciarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarTablaActionPerformed
        // Etapa General
        this.txtMinRAGGeneral.setText("");
        this.txtMaxRAGGeneral.setText("");
        this.txtInsRAGGeneral.setText("");
        this.txtMinRAEGeneral.setText("");
        this.txtMaxRAEGeneral.setText("");
        this.txtInsRAEGeneral.setText("");
        this.txtMinVelGenGeneral.setText("");
        this.txtMaxVelGenGeneral.setText("");
        this.txtInsVelGenGeneral.setText("");
        this.txtMinVelEspGeneral.setText("");
        this.txtMaxVelEspGeneral.setText("");
        this.txtInsVelEspGeneral.setText("");
        this.txtMinResVelGenGeneral.setText("");
        this.txtMaxResVelGenGeneral.setText("");
        this.txtInsResVelGenGeneral.setText("");
        this.txtMinResVelEspGeneral.setText("");
        this.txtMaxResVelEspGeneral.setText("");
        this.txtInsResVelEspGeneral.setText("");
        this.txtMinFuerzaGenGeneral.setText("");
        this.txtMaxFuerzaGenGeneral.setText("");
        this.txtInsFuerzaGenGeneral.setText("");
        this.txtMinFuerzaEspGeneral.setText("");
        this.txtMaxFuerzaEspGeneral.setText("");
        this.txtInsFuerzaEspGeneral.setText("");
        this.txtMinCoordTecnGeneral.setText("");
        this.txtMaxCoordTecnGeneral.setText("");
        this.txtInsCoordTecnGeneral.setText("");
        this.txtMinFlexibilidadGeneral.setText("");
        this.txtMaxFlexibilidadGeneral.setText("");
        this.txtInsFlexibilidadGeneral.setText("");
        // Etapa Especial
        this.txtMinRAGEspecial.setText("");
        this.txtMaxRAGEspecial.setText("");
        this.txtInsRAGEspecial.setText("");
        this.txtMinRAEEspecial.setText("");
        this.txtMaxRAEEspecial.setText("");
        this.txtInsRAEEspecial.setText("");
        this.txtMinVelGenEspecial.setText("");
        this.txtMaxVelGenEspecial.setText("");
        this.txtInsVelGenEspecial.setText("");
        this.txtMinVelEspEspecial.setText("");
        this.txtMaxVelEspEspecial.setText("");
        this.txtInsVelEspEspecial.setText("");
        this.txtMinResVelGenEspecial.setText("");
        this.txtMaxResVelGenEspecial.setText("");
        this.txtInsResVelGenEspecial.setText("");
        this.txtMinResVelEspEspecial.setText("");
        this.txtMaxResVelEspEspecial.setText("");
        this.txtInsResVelEspEspecial.setText("");
        this.txtMinFuerzaGenEspecial.setText("");
        this.txtMaxFuerzaGenEspecial.setText("");
        this.txtInsFuerzaGenEspecial.setText("");
        this.txtMinFuerzaEspEspecial.setText("");
        this.txtMaxFuerzaEspEspecial.setText("");
        this.txtInsFuerzaEspEspecial.setText("");
        this.txtMinCoordTecnEspecial.setText("");
        this.txtMaxCoordTecnEspecial.setText("");
        this.txtInsCoordTecnEspecial.setText("");
        this.txtMinFlexibilidadEspecial.setText("");
        this.txtMaxFlexibilidadEspecial.setText("");
        this.txtInsFlexibilidadEspecial.setText("");
        // Etapa Competitiva
        this.txtMinRAGCompetitiva.setText("");
        this.txtMaxRAGCompetitiva.setText("");
        this.txtInsRAGCompetitiva.setText("");
        this.txtMinRAECompetitiva.setText("");
        this.txtMaxRAECompetitiva.setText("");
        this.txtInsRAECompetitiva.setText("");
        this.txtMinVelGenCompetitiva.setText("");
        this.txtMaxVelGenCompetitiva.setText("");
        this.txtInsVelGenCompetitiva.setText("");
        this.txtMinVelEspCompetitiva.setText("");
        this.txtMaxVelEspCompetitiva.setText("");
        this.txtInsVelEspCompetitiva.setText("");
        this.txtMinResVelGenCompetitiva.setText("");
        this.txtMaxResVelGenCompetitiva.setText("");
        this.txtInsResVelGenCompetitiva.setText("");
        this.txtMinResVelEspCompetitiva.setText("");
        this.txtMaxResVelEspCompetitiva.setText("");
        this.txtInsResVelEspCompetitiva.setText("");
        this.txtMinFuerzaGenCompetitiva.setText("");
        this.txtMaxFuerzaGenCompetitiva.setText("");
        this.txtInsFuerzaGenCompetitiva.setText("");
        this.txtMinFuerzaEspCompetitiva.setText("");
        this.txtMaxFuerzaEspCompetitiva.setText("");
        this.txtInsFuerzaEspCompetitiva.setText("");
        this.txtMinCoordTecnCompetitiva.setText("");
        this.txtMaxCoordTecnCompetitiva.setText("");
        this.txtInsCoordTecnCompetitiva.setText("");
        this.txtMinFlexibilidadCompetitiva.setText("");
        this.txtMaxFlexibilidadCompetitiva.setText("");
        this.txtInsFlexibilidadCompetitiva.setText("");
    }//GEN-LAST:event_btnVaciarTablaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularPromVolCompetitiva;
    private javax.swing.JButton btnCalcularPromVolEspecial;
    private javax.swing.JButton btnCalcularPromVolGeneral;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnVaciarTabla;
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
    private javax.swing.JLabel lblTituloTabla;
    private javax.swing.JLabel lblVelEspecial;
    private javax.swing.JLabel lblVelGeneral;
    private javax.swing.JPanel pnlCompetitiva;
    private javax.swing.JPanel pnlEspecial;
    private javax.swing.JPanel pnlFrame;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JTable tblEtapaCompetitiva;
    private javax.swing.JTable tblEtapaEspecial;
    private javax.swing.JTable tblEtapaGeneral;
    private javax.swing.JTextField txtInsCoordTecnCompetitiva;
    private javax.swing.JTextField txtInsCoordTecnEspecial;
    private javax.swing.JTextField txtInsCoordTecnGeneral;
    private javax.swing.JTextField txtInsFlexibilidadCompetitiva;
    private javax.swing.JTextField txtInsFlexibilidadEspecial;
    private javax.swing.JTextField txtInsFlexibilidadGeneral;
    private javax.swing.JTextField txtInsFuerzaEspCompetitiva;
    private javax.swing.JTextField txtInsFuerzaEspEspecial;
    private javax.swing.JTextField txtInsFuerzaEspGeneral;
    private javax.swing.JTextField txtInsFuerzaGenCompetitiva;
    private javax.swing.JTextField txtInsFuerzaGenEspecial;
    private javax.swing.JTextField txtInsFuerzaGenGeneral;
    private javax.swing.JTextField txtInsRAECompetitiva;
    private javax.swing.JTextField txtInsRAEEspecial;
    private javax.swing.JTextField txtInsRAEGeneral;
    private javax.swing.JTextField txtInsRAGCompetitiva;
    private javax.swing.JTextField txtInsRAGEspecial;
    private javax.swing.JTextField txtInsRAGGeneral;
    private javax.swing.JTextField txtInsResVelEspCompetitiva;
    private javax.swing.JTextField txtInsResVelEspEspecial;
    private javax.swing.JTextField txtInsResVelEspGeneral;
    private javax.swing.JTextField txtInsResVelGenCompetitiva;
    private javax.swing.JTextField txtInsResVelGenEspecial;
    private javax.swing.JTextField txtInsResVelGenGeneral;
    private javax.swing.JTextField txtInsVelEspCompetitiva;
    private javax.swing.JTextField txtInsVelEspEspecial;
    private javax.swing.JTextField txtInsVelEspGeneral;
    private javax.swing.JTextField txtInsVelGenCompetitiva;
    private javax.swing.JTextField txtInsVelGenEspecial;
    private javax.swing.JTextField txtInsVelGenGeneral;
    private javax.swing.JTextField txtMaxCoordTecnCompetitiva;
    private javax.swing.JTextField txtMaxCoordTecnEspecial;
    private javax.swing.JTextField txtMaxCoordTecnGeneral;
    private javax.swing.JTextField txtMaxFlexibilidadCompetitiva;
    private javax.swing.JTextField txtMaxFlexibilidadEspecial;
    private javax.swing.JTextField txtMaxFlexibilidadGeneral;
    private javax.swing.JTextField txtMaxFuerzaEspCompetitiva;
    private javax.swing.JTextField txtMaxFuerzaEspEspecial;
    private javax.swing.JTextField txtMaxFuerzaEspGeneral;
    private javax.swing.JTextField txtMaxFuerzaGenCompetitiva;
    private javax.swing.JTextField txtMaxFuerzaGenEspecial;
    private javax.swing.JTextField txtMaxFuerzaGenGeneral;
    private javax.swing.JTextField txtMaxRAECompetitiva;
    private javax.swing.JTextField txtMaxRAEEspecial;
    private javax.swing.JTextField txtMaxRAEGeneral;
    private javax.swing.JTextField txtMaxRAGCompetitiva;
    private javax.swing.JTextField txtMaxRAGEspecial;
    private javax.swing.JTextField txtMaxRAGGeneral;
    private javax.swing.JTextField txtMaxResVelEspCompetitiva;
    private javax.swing.JTextField txtMaxResVelEspEspecial;
    private javax.swing.JTextField txtMaxResVelEspGeneral;
    private javax.swing.JTextField txtMaxResVelGenCompetitiva;
    private javax.swing.JTextField txtMaxResVelGenEspecial;
    private javax.swing.JTextField txtMaxResVelGenGeneral;
    private javax.swing.JTextField txtMaxVelEspCompetitiva;
    private javax.swing.JTextField txtMaxVelEspEspecial;
    private javax.swing.JTextField txtMaxVelEspGeneral;
    private javax.swing.JTextField txtMaxVelGenCompetitiva;
    private javax.swing.JTextField txtMaxVelGenEspecial;
    private javax.swing.JTextField txtMaxVelGenGeneral;
    private javax.swing.JTextField txtMinCoordTecnCompetitiva;
    private javax.swing.JTextField txtMinCoordTecnEspecial;
    private javax.swing.JTextField txtMinCoordTecnGeneral;
    private javax.swing.JTextField txtMinFlexibilidadCompetitiva;
    private javax.swing.JTextField txtMinFlexibilidadEspecial;
    private javax.swing.JTextField txtMinFlexibilidadGeneral;
    private javax.swing.JTextField txtMinFuerzaEspCompetitiva;
    private javax.swing.JTextField txtMinFuerzaEspEspecial;
    private javax.swing.JTextField txtMinFuerzaEspGeneral;
    private javax.swing.JTextField txtMinFuerzaGenCompetitiva;
    private javax.swing.JTextField txtMinFuerzaGenEspecial;
    private javax.swing.JTextField txtMinFuerzaGenGeneral;
    private javax.swing.JTextField txtMinRAECompetitiva;
    private javax.swing.JTextField txtMinRAEEspecial;
    private javax.swing.JTextField txtMinRAEGeneral;
    private javax.swing.JTextField txtMinRAGCompetitiva;
    private javax.swing.JTextField txtMinRAGEspecial;
    private javax.swing.JTextField txtMinRAGGeneral;
    private javax.swing.JTextField txtMinResVelEspCompetitiva;
    private javax.swing.JTextField txtMinResVelEspEspecial;
    private javax.swing.JTextField txtMinResVelEspGeneral;
    private javax.swing.JTextField txtMinResVelGenCompetitiva;
    private javax.swing.JTextField txtMinResVelGenEspecial;
    private javax.swing.JTextField txtMinResVelGenGeneral;
    private javax.swing.JTextField txtMinVelEspCompetitiva;
    private javax.swing.JTextField txtMinVelEspEspecial;
    private javax.swing.JTextField txtMinVelEspGeneral;
    private javax.swing.JTextField txtMinVelGenCompetitiva;
    private javax.swing.JTextField txtMinVelGenEspecial;
    private javax.swing.JTextField txtMinVelGenGeneral;
    private javax.swing.JTextField txtPromCoordTecnCompetitiva;
    private javax.swing.JTextField txtPromCoordTecnEspecial;
    private javax.swing.JTextField txtPromCoordTecnGeneral;
    private javax.swing.JTextField txtPromFlexibilidadCompetitiva;
    private javax.swing.JTextField txtPromFlexibilidadEspecial;
    private javax.swing.JTextField txtPromFlexibilidadGeneral;
    private javax.swing.JTextField txtPromFuerzaEspCompetitiva;
    private javax.swing.JTextField txtPromFuerzaEspEspecial;
    private javax.swing.JTextField txtPromFuerzaEspGeneral;
    private javax.swing.JTextField txtPromFuerzaGenCompetitiva;
    private javax.swing.JTextField txtPromFuerzaGenEspecial;
    private javax.swing.JTextField txtPromFuerzaGenGeneral;
    private javax.swing.JTextField txtPromRAECompetitiva;
    private javax.swing.JTextField txtPromRAEEspecial;
    private javax.swing.JTextField txtPromRAEGeneral;
    private javax.swing.JTextField txtPromRAGCompetitiva;
    private javax.swing.JTextField txtPromRAGEspecial;
    private javax.swing.JTextField txtPromRAGGeneral;
    private javax.swing.JTextField txtPromResVelEspCompetitiva;
    private javax.swing.JTextField txtPromResVelEspEspecial;
    private javax.swing.JTextField txtPromResVelEspGeneral;
    private javax.swing.JTextField txtPromResVelGenCompetitiva;
    private javax.swing.JTextField txtPromResVelGenEspecial;
    private javax.swing.JTextField txtPromResVelGenGeneral;
    private javax.swing.JTextField txtPromVelEspCompetitiva;
    private javax.swing.JTextField txtPromVelEspEspecial;
    private javax.swing.JTextField txtPromVelEspGeneral;
    private javax.swing.JTextField txtPromVelGenCompetitiva;
    private javax.swing.JTextField txtPromVelGenEspecial;
    private javax.swing.JTextField txtPromVelGenGeneral;
    private javax.swing.JTextField txtVolCoordTecnCompetitiva;
    private javax.swing.JTextField txtVolCoordTecnEspecial;
    private javax.swing.JTextField txtVolCoordTecnGeneral;
    private javax.swing.JTextField txtVolFlexibilidadCompetitiva;
    private javax.swing.JTextField txtVolFlexibilidadEspecial;
    private javax.swing.JTextField txtVolFlexibilidadGeneral;
    private javax.swing.JTextField txtVolFuerzaEspCompetitiva;
    private javax.swing.JTextField txtVolFuerzaEspEspecial;
    private javax.swing.JTextField txtVolFuerzaEspGeneral;
    private javax.swing.JTextField txtVolFuerzaGenCompetitiva;
    private javax.swing.JTextField txtVolFuerzaGenEspecial;
    private javax.swing.JTextField txtVolFuerzaGenGeneral;
    private javax.swing.JTextField txtVolRAECompetitiva;
    private javax.swing.JTextField txtVolRAEEspecial;
    private javax.swing.JTextField txtVolRAEGeneral;
    private javax.swing.JTextField txtVolRAGCompetitiva;
    private javax.swing.JTextField txtVolRAGEspecial;
    private javax.swing.JTextField txtVolRAGGeneral;
    private javax.swing.JTextField txtVolResVelEspCompetitiva;
    private javax.swing.JTextField txtVolResVelEspEspecial;
    private javax.swing.JTextField txtVolResVelEspGeneral;
    private javax.swing.JTextField txtVolResVelGenCompetitiva;
    private javax.swing.JTextField txtVolResVelGenEspecial;
    private javax.swing.JTextField txtVolResVelGenGeneral;
    private javax.swing.JTextField txtVolVelEspCompetitiva;
    private javax.swing.JTextField txtVolVelEspEspecial;
    private javax.swing.JTextField txtVolVelEspGeneral;
    private javax.swing.JTextField txtVolVelGenCompetitiva;
    private javax.swing.JTextField txtVolVelGenEspecial;
    private javax.swing.JTextField txtVolVelGenGeneral;
    // End of variables declaration//GEN-END:variables
}
