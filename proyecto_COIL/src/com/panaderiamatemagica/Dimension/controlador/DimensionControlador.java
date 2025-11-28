/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.Dimension.controlador;

import com.panaderiamatemagica.Dimension.modelo.DimensionModelo;
import com.panaderiamatemagica.core.RouterControlador;
import com.panaderiamatemagica.ejercicios.modelo.EjercicioModelo;
import com.panaderiamatemagica.core.dao.EjercicioDAO;
import com.panaderiamatemagica.core.dao.ProgresoNivelDAO;
import com.panaderiamatemagica.ejercicios.controlador.EjercicioControladorVista;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo Dell
 */
public class DimensionControlador {
    private RouterControlador router;
    private DimensionModelo modelo;
    private JPanel vista;
    private ArrayList<ArrayList<EjercicioModelo>> niveles;
    private int indiceNivel;
    private int dimensionId; // ID de la dimensión actual

    // constructor
    public DimensionControlador(RouterControlador router, DimensionModelo modelo, JPanel vista,
            ArrayList<ArrayList<EjercicioModelo>> niveles) {
        this.router = router;
        this.modelo = modelo;
        this.vista = vista;
        this.niveles = niveles;
        this.indiceNivel = 0;
        this.dimensionId = 1; // Por defecto dimensión 1
    }

    /**
     * Establece la dimensión actual
     */
    public void setDimensionId(int dimensionId) {
        this.dimensionId = dimensionId;
    }

    /**
     * Inicia un nivel cargando ejercicios desde la base de datos
     */
    public void iniciarNivel(int nivelNumero) {
        // nivelNumero es 0-indexed (0=Nivel 1, 1=Nivel 2, 2=Nivel 3)
        // CORREGIDO: Calcular ID global del nivel basado en la dimensión (3 niveles por
        // dimensión)
        int nivelId = (this.dimensionId - 1) * 3 + (nivelNumero + 1);

        try {
            // Verificar prerrequisitos
            if (router.getAlumnoActual() != null) {
                int alumnoId = router.getAlumnoActual().getId_Alumno();
                ProgresoNivelDAO progresoDAO = new ProgresoNivelDAO();

                if (!progresoDAO.puedeAccederNivel(alumnoId, dimensionId, nivelId)) {
                    JOptionPane.showMessageDialog(vista,
                            "Debes completar el nivel anterior para acceder a este nivel.",
                            "Nivel Bloqueado",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            // Cargar ejercicios desde la base de datos
            EjercicioDAO ejercicioDAO = new EjercicioDAO();
            ArrayList<EjercicioModelo> ejerciciosDelNivel = ejercicioDAO.cargarEjerciciosPorDimensionYNivel(
                    dimensionId,
                    nivelId);

            if (ejerciciosDelNivel == null || ejerciciosDelNivel.isEmpty()) {
                JOptionPane.showMessageDialog(vista,
                        "Este nivel aún no tiene ejercicios.\nDimensión: " + dimensionId + ", Nivel: " + nivelId,
                        "Nivel Vacío",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            System.out.println("✓ Cargados " + ejerciciosDelNivel.size() +
                    " ejercicios - Dimensión " + dimensionId + ", Nivel " + nivelId);

            // Establecer contexto en EjercicioControladorVista
            EjercicioControladorVista ejercicioControlador = router.getPantallaEjercicio().getControlador();
            if (ejercicioControlador != null) {
                // Obtener dificultad del primer ejercicio (o parametrizado)
                int dificultad = ejerciciosDelNivel.get(0).getDificultad();
                ejercicioControlador.setContextoNivel(dimensionId, nivelId, dificultad);
            }

            // Iniciar el juego con esta lista de ejercicios
            router.iniciarJuegoConEjercicios(ejerciciosDelNivel);

        } catch (Exception e) {
            System.err.println("Error al cargar ejercicios: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista,
                    "Error al cargar los ejercicios del nivel.\n" + e.getMessage(),
                    "Error de Base de Datos",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
