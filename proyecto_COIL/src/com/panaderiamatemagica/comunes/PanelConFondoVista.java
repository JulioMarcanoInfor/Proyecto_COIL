/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.comunes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class PanelConFondoVista extends JPanel {
    private BufferedImage imagenFondo;
    
    // Constructor vacío - para usar en NetBeans Designer
    public PanelConFondoVista (){
        super();
        setOpaque(false); // Hacer el panel transparente para que se vea la imagen
    }
    
    // Constructor con ruta de imagen
    public PanelConFondoVista (String rutaImagen) {
        super();
        setOpaque(false);
        cargarImagen(rutaImagen);
    }
        // Método para cargar imagen desde ruta
    public void cargarImagen(String rutaImagen) {
        try {
            imagenFondo = ImageIO.read(new File(rutaImagen));
            repaint(); // Forzar a redibujar con la nueva imagen
        } catch (IOException e) {
            System.err.println("Error cargando imagen: " + rutaImagen);
            e.printStackTrace();
        }
    }
      // Método para cargar imagen desde recursos del proyecto (RECOMENDADO)
    public void cargarImagenDesdeResources(String nombreArchivo) {
        try {
            // La imagen debe estar en: src/main/resources/images/
            imagenFondo = ImageIO.read(getClass().getResource("/images/" + nombreArchivo));
            repaint();
        } catch (IOException e) {
            System.err.println("Error cargando imagen desde resources: " + nombreArchivo);
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Imagen no encontrada en resources: " + nombreArchivo);
        }
    }
    // Método para establecer imagen directamente
    public void setImagenFondo(BufferedImage imagen) {
        this.imagenFondo = imagen;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // IMPORTANTE: llamar al método padre primero
        
        // Si hay imagen de fondo, dibujarla
        if (imagenFondo != null) {
            // Opción A: Dibujar imagen escalada al tamaño del panel
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
     // Método para escalar imagen al tamaño del panel
    public void escalarImagenAlTamañoPanel() {
        if (imagenFondo != null && getWidth() > 0 && getHeight() > 0) {
            Image imagenEscalada = imagenFondo.getScaledInstance(
                getWidth(), getHeight(), Image.SCALE_SMOOTH
            );
            
            // Convertir Image a BufferedImage
            BufferedImage nuevaImagen = new BufferedImage(
                getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB
            );
            Graphics2D g2d = nuevaImagen.createGraphics();
            g2d.drawImage(imagenEscalada, 0, 0, null);
            g2d.dispose();
            
            imagenFondo = nuevaImagen;
            repaint();
        }
    }
    
    // Método para verificar si tiene imagen
    public boolean tieneImagen() {
        return imagenFondo != null;
    }
    
    // Método para obtener la imagen actual
    public BufferedImage getImagenFondo() {
        return imagenFondo;
    }

}
