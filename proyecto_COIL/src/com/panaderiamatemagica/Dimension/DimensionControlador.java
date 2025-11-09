/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.Dimension;

import com.panaderiamatemagica.comunes.RouterControlador;
import com.panaderiamatemagica.ejercicios.EjercicioModelo;
import com.panaderiamatemagica.juego.vista.Dimension1Vista;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo Dell
 */
public class DimensionControlador {
    private RouterControlador router;
    private DimensionModelo modelo;
    private Dimension1Vista vista;
    private ArrayList<ArrayList<EjercicioModelo>> niveles;
    private int indiceNivel;
        
    //constructor
    public DimensionControlador(RouterControlador router, DimensionModelo modelo, Dimension1Vista vista, ArrayList<ArrayList<EjercicioModelo>> niveles) {
        this.router = router;
        this.modelo = modelo;
        this.vista = vista;
        this.niveles = niveles;
        this.indiceNivel = 0; // Inicializar indice (para saber por donde va)
    }
    
    public void iniciarNivel(int indiceNivel) {
        // Validacion de la lista de niveles y el indice
        if (niveles == null || indiceNivel < 0 || indiceNivel >= niveles.size()) {
            // Manejo de error si el indice esta fuera de rango
            JOptionPane.showMessageDialog(vista, "Error: Nivel no disponible o fuera de rango.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 1. Obtener la lista específica de ejercicios para el nivel seleccionado
        ArrayList<EjercicioModelo> ejerciciosDelNivel = niveles.get(indiceNivel);

        if (ejerciciosDelNivel.isEmpty()) {
            // Manejo si el nivel no contiene ejercicios
            JOptionPane.showMessageDialog(vista, "Este nivel aun no tiene ejercicios.", "Nivel Vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Usar el RouterControlador para iniciar el juego con esta lista de ejercicios.
        router.iniciarJuegoConEjercicios(ejerciciosDelNivel);
    }

}
