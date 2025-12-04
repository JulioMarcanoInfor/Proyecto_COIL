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
                    backgroundImage = ImageIO.read(getClass().getResource("/images/FondoInicial.png"));
                } catch (Exception e) {
                    // Registra el error internamente sin molestar al usuario
                    
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonJugar = new javax.swing.JButton();
        jLabelReescalable1 = new com.panaderiamatemagica.core.visual.componentes.JLabelReescalable();

        setBackground(new java.awt.Color(0, 255, 204));
        setMaximumSize(new java.awt.Dimension(833, 615));
        setMinimumSize(new java.awt.Dimension(833, 615));
        setPreferredSize(new java.awt.Dimension(833, 615));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonJugar.setBackground(new java.awt.Color(117, 183, 168));
        botonJugar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
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
        add(botonJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 234, 50));

        jLabelReescalable1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelReescalable1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoInicial.png"))); // NOI18N
        jLabelReescalable1.setText("jLabelReescalable1");
        jLabelReescalable1.setPreferredSize(new java.awt.Dimension(833, 615));
        add(jLabelReescalable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 630));
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
