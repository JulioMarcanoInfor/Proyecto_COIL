/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.core.visual.componentes;

import java.awt.*;
import javax.swing.*;

public class JLabelReescalable extends JLabel {
    
    public JLabelReescalable() {
        super();
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        // Solo pintar si tenemos un ImageIcon válido
        Icon icon = getIcon();
        if (icon instanceof ImageIcon) {
            Image img = ((ImageIcon) icon).getImage();
            if (img != null) {
                // Graphics2D para mejor calidad
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                                   RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                
                g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                return; // Importante: salir después de pintar
            }
        }
        
        // Si no hay imagen válida, comportamiento normal
        super.paintComponent(g);
    }
}