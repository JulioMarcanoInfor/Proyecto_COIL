/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.vista;

import com.panaderiamatemagica.autenticacion.controladores.alumnos.RouterAutenticacionControlador;
import com.panaderiamatemagica.core.RouterControlador;
import com.panaderiamatemagica.core.visual.componentes.FondoPanel;
import com.panaderiamatemagica.core.visual.componentes.ResponsivePanel;
import com.panaderiamatemagica.core.visual.componentes.ScreenUtils;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author User
 */
public class FondoAutenticacionVista extends javax.swing.JPanel {
    public RouterControlador routerP;
    public RouterAutenticacionControlador routerA;
    public CardLayout pantallasAutenticacion;
    private RecuperarContraseñaVista pantallaRecuperarContraseña;
    
    public FondoAutenticacionVista(RouterControlador routerP, RouterAutenticacionControlador routerA) {
        this.routerP = routerP;
        this.routerA = routerA;
        
        
        initComponents();
        inicializarPantallas();
        
        pantallaRecuperarContraseña = new RecuperarContraseñaVista(routerP);
        monitor.add(pantallaRecuperarContraseña, "RECUPERAR");
    // 1. Obtener factor de escala
        double scale = ScreenUtils.getScaleFactor();
        
        // 2. Calcular tamaños escalados para el MONITOR
        int monitorW = (int)(640 * scale);
        int monitorH = (int)(660 * scale);
        
        // 3. Calcular tamaños escalados para el BOTÓN
        int btnW = (int)(96 * scale);
        int btnH = (int)(57 * scale);

        FondoPanel fondoPanel = new FondoPanel("FondoAutenticacion.jpg");
        // Usamos MigLayout pero inyectamos los tamaños YA CALCULADOS
        fondoPanel.setLayout(new MigLayout("fill, insets 0", "[grow]", "[grow]"));

        setLayout(new java.awt.BorderLayout());
        add(fondoPanel, java.awt.BorderLayout.CENTER);

        remove(monitor);
        remove(botonVolver);
        
        // Reescalar la fuente del botón manualmente (ya que quitamos el recursivo)
        if (botonVolver.getFont() != null) {
            float newSize = (float) (botonVolver.getFont().getSize() * scale);
            botonVolver.setFont(botonVolver.getFont().deriveFont(Math.max(newSize, 10.0f)));
        }

        // 4. Agregar componentes con las medidas dinámicas
        // "pos 50% 15%" mantiene la posición proporcional automáticamente.
        // "w " + monitorW + "!" fuerza el tamaño exacto escalado.
        fondoPanel.add(monitor, "pos 50% 15%, w " + monitorW + "!, h " + monitorH + "!");
        fondoPanel.add(botonVolver, "pos 93% 90%, w " + btnW + "!, h " + btnH + "!");
        
        // 5. IMPORTANTE: Forzar al CardLayout a mostrar la primera pantalla
        pantallasAutenticacion.show(monitor, "ROL");
}


    public void mostrarSeleccionRol() {
        pantallasAutenticacion.show(monitor, "ROL");
    }
    private void inicializarPantallas() {
        pantallasAutenticacion = (CardLayout) monitor.getLayout();
        
    }
    
        private void aplicarReescaladoInterno() {
        double scaleFactor = ScreenUtils.getScaleFactor();
        
        // Solo aplicar si el factor es significativamente diferente a 1
        if (Math.abs(scaleFactor - 1.0) > 0.01) {
            
            // Reescalar recursivamente a todos los elementos dentro de ESTE PANEL
            ScreenUtils.scaleComponentRecursively(this, scaleFactor);
        }
    }

    public void mostrarIniciarSesion() {
        pantallasAutenticacion.show(monitor, "INICIO SESION");
    }

    public void mostrarRegistro() {
        pantallasAutenticacion.show(monitor, "REGISTRO");
    }
    public void mostrarIniciarSesionAdmin(){
        pantallasAutenticacion.show(monitor, "INICIAR ADMIN");
    }
    public void agregarPanel(JPanel panel, String nombre){
        monitor.add(panel, nombre);
    }
    public void mostrarPanel(String nombre) {
    // Esto es el método que cambia entre las tarjetas
    pantallasAutenticacion.show(monitor, nombre); 
}
    

    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monitor = new javax.swing.JPanel();
        pantallaSeleccionRol = new com.panaderiamatemagica.autenticacion.vista.SeleccionRolVista(routerP, routerA);
        pantallaInicioSesion = new com.panaderiamatemagica.autenticacion.vista.InicioSesionVista(routerP, routerA);
        pantallaRegistro = new com.panaderiamatemagica.autenticacion.vista.RegistroVista(routerP, routerA);
        botonVolver = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 228, 171));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        monitor.setLayout(new java.awt.CardLayout());
        monitor.add(pantallaSeleccionRol, "ROL");
        monitor.add(pantallaInicioSesion, "INICIO SESION");
        monitor.add(pantallaRegistro, "REGISTRO");

        botonVolver.setBackground(new java.awt.Color(117, 183, 168));
        botonVolver.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        botonVolver.setForeground(new java.awt.Color(0, 0, 0));
        botonVolver.setText("<");
        botonVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonVolverMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonVolverMouseExited(evt);
            }
        });
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(416, 416, 416)
                                .addComponent(monitor, javax.swing.GroupLayout.PREFERRED_SIZE, 640,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(864, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1050, 1050, 1050)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(monitor, javax.swing.GroupLayout.PREFERRED_SIZE, 660,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(328, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 57,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(470, 470, 470)));
    }// </editor-fold>//GEN-END:initComponents

    public void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {
        if (pantallaRegistro.isVisible()) {
            mostrarIniciarSesion();
        } else if (pantallaInicioSesion.isVisible()) {
            mostrarSeleccionRol();
        } else {
            routerP.mostrarInicioVista();
            routerA.mostrarSeleccionRol();
        }
    }

    public void botonVolverMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_botonVolverMouseEntered
        botonVolver.setBackground(new Color(85, 208, 82));
    }// GEN-LAST:event_botonVolverMouseEntered

    public void botonVolverMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_botonVolverMouseExited
        botonVolver.setBackground(new Color(117, 183, 168));
    }// GEN-LAST:event_botonVolverMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonVolver;
    public javax.swing.JPanel monitor;
    public com.panaderiamatemagica.autenticacion.vista.InicioSesionVista pantallaInicioSesion;
    public com.panaderiamatemagica.autenticacion.vista.SeleccionRolVista pantallaSeleccionRol;
    public com.panaderiamatemagica.autenticacion.vista.RegistroVista pantallaRegistro;
    // End of variables declaration//GEN-END:variables
}
