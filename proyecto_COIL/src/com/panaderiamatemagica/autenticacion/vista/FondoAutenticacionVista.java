/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.vista;

import com.panaderiamatemagica.autenticacion.controladores.alumnos.RouterAutenticacionControlador;
import com.panaderiamatemagica.core.RouterControlador;
import com.panaderiamatemagica.core.visual.componentes.FondoPanel;
import com.panaderiamatemagica.core.visual.componentes.ResponsivePanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class FondoAutenticacionVista extends javax.swing.JPanel {
    private RouterControlador routerP;
    private RouterAutenticacionControlador routerA;
    private CardLayout pantallasAutenticacion;

    public FondoAutenticacionVista(RouterControlador routerP, RouterAutenticacionControlador routerA) {
        this.routerP = routerP;
        this.routerA = routerA;
        initComponents();
        inicializarPantallas();

        // Crear panel responsivo con dimensiones de diseño original
        ResponsivePanel responsivePanel = new ResponsivePanel(1920, 1080) {
            private Image backgroundImage;

            {
                try {
                    backgroundImage = ImageIO
                            .read(getClass().getClassLoader().getResource("images/fondoAutenticacion.jpg"));
                } catch (Exception e) {
                    System.err.println("Error cargando imagen de fondo: " + e.getMessage());
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        // Configurar layout principal
        setLayout(new java.awt.BorderLayout());
        add(responsivePanel, java.awt.BorderLayout.CENTER);

        // Remover componentes del diseño original
        remove(monitor);
        remove(botonVolver);

        // Agregar componentes al panel responsivo
        responsivePanel.addScalable(monitor, 416, 92, 640, 660);
        responsivePanel.addScalable(botonVolver, 688, 770, 96, 57);
    }

    private void inicializarPantallas() {
        pantallasAutenticacion = (CardLayout) monitor.getLayout();
    }

    public void mostrarSeleccionRol() {
        pantallasAutenticacion.show(monitor, "ROL");
    }

    public void mostrarIniciarSesion() {
        pantallasAutenticacion.show(monitor, "INICIO SESION");
    }

    public void mostrarRegistro() {
        pantallasAutenticacion.show(monitor, "REGISTRO");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monitor = new javax.swing.JPanel();
        pantallaSeleccionRol = new com.panaderiamatemagica.autenticacion.vista.SeleccionRolVista(routerP, routerA);
        pantallaInicioSesion = new com.panaderiamatemagica.autenticacion.vista.InicioSesionVista(routerP, routerA);
        pantallaRegistro = new com.panaderiamatemagica.autenticacion.vista.RegistroVista(routerP);
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

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {
        if (pantallaRegistro.isVisible()) {
            mostrarIniciarSesion();
        } else if (pantallaInicioSesion.isVisible()) {
            mostrarSeleccionRol();
        } else {
            routerP.mostrarInicioVista();
        }
    }

    private void botonVolverMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_botonVolverMouseEntered
        botonVolver.setBackground(new Color(85, 208, 82));
    }// GEN-LAST:event_botonVolverMouseEntered

    private void botonVolverMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_botonVolverMouseExited
        botonVolver.setBackground(new Color(117, 183, 168));
    }// GEN-LAST:event_botonVolverMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonVolver;
    private javax.swing.JPanel monitor;
    private com.panaderiamatemagica.autenticacion.vista.InicioSesionVista pantallaInicioSesion;
    private com.panaderiamatemagica.autenticacion.vista.SeleccionRolVista pantallaSeleccionRol;
    private com.panaderiamatemagica.autenticacion.vista.RegistroVista pantallaRegistro;
    // End of variables declaration//GEN-END:variables
}
