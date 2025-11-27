/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.core.visual;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPanel extends JPanel {
    private Image imagenFondo;
    
    // ✅ CONSTRUCTOR MEJORADO para recursos internos
    public FondoPanel(String nombreArchivo) {
        super();
        setOpaque(false);
        cargarImagenDesdeRecursos(nombreArchivo);
    }
    
    private void cargarImagenDesdeRecursos(String nombreArchivo) {
        try {
            // ✅ Cargar imagen desde recursos del proyecto
            java.net.URL urlImagen = getClass().getResource("/images/" + nombreArchivo);
            
            if (urlImagen != null) {
                imagenFondo = new ImageIcon(urlImagen).getImage();
                System.out.println("✅ Imagen cargada desde recursos: " + nombreArchivo);
            } else {
                System.err.println("❌ No se encontró la imagen: " + nombreArchivo);
            }
        } catch (Exception e) {
            System.err.println("❌ Error cargando imagen: " + e.getMessage());
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
