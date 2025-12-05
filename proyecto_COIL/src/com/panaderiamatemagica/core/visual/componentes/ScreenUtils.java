/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.core.visual.componentes;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JComponent;

public class ScreenUtils {

    // BASE DE DISEÑO (Tu referencia 1600x900)
    private static final double DESIGN_WIDTH = 1600.0;
    private static final double DESIGN_HEIGHT = 900.0;

    public static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static double getScaleFactor() {
        Dimension screenSize = getScreenSize();
        double widthRatio = screenSize.getWidth() / DESIGN_WIDTH;
        double heightRatio = screenSize.getHeight() / DESIGN_HEIGHT;
        return Math.min(widthRatio, heightRatio);
    }

    public static void scaleComponentRecursively(Component comp, double factor) {
        // 1. Reescalar Fuente
        if (comp.getFont() != null) {
            float newSize = (float) (comp.getFont().getSize() * factor);
            comp.setFont(comp.getFont().deriveFont(Math.max(newSize, 10.0f)));
        }

        // 2. Si es contenedor, entrar primero a los hijos (Recursividad)
        if (comp instanceof Container) {
            Container container = (Container) comp;
            
            for (Component child : container.getComponents()) {
                scaleComponentRecursively(child, factor);
            }
            
            // Forzar layout null solo si NO es un componente de sistema como CardLayout/JRootPane
            if (container instanceof JComponent 
                && !(container.getLayout() instanceof java.awt.CardLayout)) {
                container.setLayout(null);
            }
        }

        // 3. Reescalar Posición y Tamaño (Solo si tiene padre que lo permita)
    if (comp.getParent() != null) {
        // --- Paso de depuración ---
        int originalX = comp.getX();
        int originalY = comp.getY();
        
        int x = (int) (originalX * factor);
        int y = (int) (originalY * factor);
        int w = (int) (comp.getWidth() * factor);
        int h = (int) (comp.getHeight() * factor);
        
        // ¡ACTIVA ESTA LÍNEA Y REVISA LA CONSOLA!
        System.out.println("Reescalando " + comp.getClass().getSimpleName() + 
               " | Original: [" + originalX + "," + originalY + "] | Nuevo: [" + x + "," + y + "]");
        
        comp.setBounds(x, y, w, h);
    }
    }
}
