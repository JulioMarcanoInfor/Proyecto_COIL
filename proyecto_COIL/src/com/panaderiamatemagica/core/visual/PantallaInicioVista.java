/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panaderiamatemagica.core.visual;

import com.panaderiamatemagica.core.RouterControlador;
import com.panaderiamatemagica.core.visual.componentes.FondoPanel;
import com.panaderiamatemagica.core.visual.componentes.ResponsivePanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author userr
 */
public class PantallaInicioVista extends javax.swing.JPanel {
    private RouterControlador router;

    public PantallaInicioVista(RouterControlador router) {
        this.router = router;
        initComponents();

        // Crear panel responsivo con dimensiones de diseño original
        ResponsivePanel responsivePanel = new ResponsivePanel(833, 615) {
            private Image backgroundImage;

            {
                try {
                    backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("images/FondoInicial.png"));
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
        remove(jLabelReescalable1);
        remove(botonJugar);

        // Agregar botón al panel responsivo
        responsivePanel.addScalable(botonJugar, 330, 410, 234, 110);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelReescalable1 = new com.panaderiamatemagica.core.visual.componentes.JLabelReescalable();
        botonJugar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 228, 171));
        setPreferredSize(new java.awt.Dimension(833, 615));

        jLabelReescalable1.setText("jLabelReescalable1");

        botonJugar.setBackground(new java.awt.Color(117, 183, 168));
        botonJugar.setFont(new java.awt.Font("Showcard Gothic", 0, 48)); // NOI18N
        botonJugar.setForeground(new java.awt.Color(0, 0, 0));
        botonJugar.setText("JUGAR");
        botonJugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonJugarMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonJugarMouseExited(evt);
            }
        });
        botonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(botonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 234,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(269, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabelReescalable1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(395, Short.MAX_VALUE)
                                .addComponent(botonJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabelReescalable1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))));
    }// </editor-fold>//GEN-END:initComponents

    private void botonJugarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonJugarActionPerformed
        router.mostrarFondoAutenticacionVista();
    }// GEN-LAST:event_botonJugarActionPerformed

    private void botonJugarMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_botonJugarMouseEntered
        botonJugar.setBackground(new Color(85, 208, 82));
    }// GEN-LAST:event_botonJugarMouseEntered

    private void botonJugarMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_botonJugarMouseExited
        botonJugar.setBackground(new Color(117, 183, 168));
    }// GEN-LAST:event_botonJugarMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonJugar;
    private com.panaderiamatemagica.core.visual.componentes.JLabelReescalable jLabelReescalable1;
    // End of variables declaration//GEN-END:variables
}
