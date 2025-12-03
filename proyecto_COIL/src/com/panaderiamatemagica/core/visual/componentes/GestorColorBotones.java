/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.core.visual.componentes;

import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Clase que gestiona el cambio de color aleatorio y sin repetición 
 * para un grupo de botones.
 */
public class GestorColorBotones {

    // Atributos (Estado)
    private final List<JButton> botones;
    
    // Conjunto de colores posibles (Encapsulación de datos)
    private static final List<Color> COLORES_DISPONIBLES = Arrays.asList(
        Color.RED,
        Color.BLUE,
        Color.GREEN,
        Color.YELLOW,
        Color.ORANGE,
        Color.MAGENTA,
        Color.CYAN,
        Color.PINK
    );

    /**
     * Constructor. Inicializa el Gestor con los botones que va a controlar.
     * @param buttons Un array de JButton que serán controlados.
     */
    public GestorColorBotones(JButton... buttons) {
        // Inicializa la lista de botones a partir del array de entrada
        this.botones = Arrays.asList(buttons);
    }

    /**
     * Método que aplica colores aleatorios y sin repetición a los botones.
     * (Comportamiento/Método)
     */
    public void cambiarColoresAleatorios() {
        // 1. Crear una copia modificable de los colores disponibles.
        List<Color> coloresSeleccionables = new ArrayList<>(COLORES_DISPONIBLES);

        // 2. Barajar la lista de colores de forma aleatoria.
        Collections.shuffle(coloresSeleccionables);

        // 3. Obtener la cantidad de botones a colorear.
        int numBotones = botones.size();
        
        // 4. Verificar si hay suficientes colores.
        if (numBotones > COLORES_DISPONIBLES.size()) {
            System.err.println("Advertencia: No hay suficientes colores disponibles para todos los botones.");
            // Si no hay suficientes, usamos todos los colores disponibles
            numBotones = COLORES_DISPONIBLES.size(); 
        }

        // 5. Asignar los colores únicos a cada botón
        for (int i = 0; i < numBotones; i++) {
            JButton boton = botones.get(i);
            Color colorFondo = coloresSeleccionables.get(i);
            
            boton.setBackground(colorFondo);
            
            // Lógica simple para mejorar el contraste del texto (opcional pero útil)
            if (esColorClaro(colorFondo)) {
                boton.setForeground(Color.BLACK);
            } else {
                boton.setForeground(Color.WHITE);
            }
        }
    }
    
    /**
     * Método auxiliar para determinar si un color es claro o no.
     */
    private boolean esColorClaro(Color color) {
        // Cálculo de luminancia basado en pesos estándar (0.299R + 0.587G + 0.114B)
        double luminancia = (0.299 * color.getRed() + 
                             0.587 * color.getGreen() + 
                             0.114 * color.getBlue()) / 255;
        // Si la luminancia es mayor a 0.6, lo consideramos "claro"
        return luminancia > 0.6; 
    }
}