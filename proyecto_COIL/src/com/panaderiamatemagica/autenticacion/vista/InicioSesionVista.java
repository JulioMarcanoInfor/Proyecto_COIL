/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.vista;

import com.panaderiamatemagica.autenticacion.controladores.alumnos.AlumnoControadorInicioSesion;
import com.panaderiamatemagica.autenticacion.controladores.alumnos.RouterAutenticacionControlador;
import com.panaderiamatemagica.core.RouterControlador;
import com.panaderiamatemagica.core.visual.componentes.FondoPanel;
import com.panaderiamatemagica.core.visual.componentes.ResponsivePanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 *
 * @author User
 */
public class InicioSesionVista extends javax.swing.JPanel {

    private RouterControlador routerP;
    private RouterAutenticacionControlador routerA;
    private AlumnoControadorInicioSesion objetoControlador;

    public InicioSesionVista(RouterControlador routerP, RouterAutenticacionControlador routerA) {
        this.routerP = routerP;
        this.routerA = routerA;
        objetoControlador = new AlumnoControadorInicioSesion(this, routerP);

        initComponents();

        // Crear panel responsivo con dimensiones de diseño original
        ResponsivePanel responsivePanel = new ResponsivePanel(640, 660) {
            private Image backgroundImage;

            {
                try {
                    backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("images/Panel Ovalado.jpg"));
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
        remove(titulo);
        remove(apodo);
        remove(cajaTexto);
        remove(botonIniciarSesion);
        remove(label1);
        remove(label2);
        remove(label3);

        // Agregar componentes al panel responsivo con posiciones originales
        responsivePanel.addScalable(titulo, 90, 20, 450, 60);
        responsivePanel.addScalable(apodo, 80, 120, 230, 50);
        responsivePanel.addScalable(cajaTexto, 100, 170, 450, 80);
        responsivePanel.addScalable(botonIniciarSesion, 130, 320, 370, 150);
        responsivePanel.addScalable(label1, 180, 500, 280, 30);
        responsivePanel.addScalable(label2, 200, 525, 280, 30);
        responsivePanel.addScalable(label3, 180, 550, 280, 30);

        // Agregar listener para registro
        label3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                routerA.mostrarRegistro();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonIniciarSesion = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        cajaTexto = new javax.swing.JTextField();
        apodo = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 228, 196));
        setPreferredSize(new java.awt.Dimension(640, 660));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonIniciarSesion.setBackground(new java.awt.Color(84, 180, 183));
        botonIniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        botonIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        botonIniciarSesion.setText("INICIAR SESIÓN");
        botonIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonIniciarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonIniciarSesionMouseExited(evt);
            }
        });
        botonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarSesionActionPerformed(evt);
            }
        });
        add(botonIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 420, 70));

        titulo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("INICIAR SESIÓN");
        add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 450, 60));

        cajaTexto.setBackground(new java.awt.Color(255, 255, 255));
        cajaTexto.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        cajaTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0), 3));
        cajaTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaTextoActionPerformed(evt);
            }
        });
        add(cajaTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 279, 440, 50));

        apodo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        apodo.setForeground(new java.awt.Color(0, 0, 0));
        apodo.setText("APODO");
        add(apodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 230, 50));

        label3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        label3.setForeground(new java.awt.Color(133, 47, 27));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setText("<html><u>Regístrate</u></html>");
        label3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 280, 30));

        label2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        label2.setForeground(new java.awt.Color(0, 0, 0));
        label2.setText("¿No tienes una cuenta?");
        add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, 310, -1));

        label1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(133, 47, 27));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("<html><u>¿Olvidaste tu contraseña?</u></html>");
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 300, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void cajaTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaTextoActionPerformed

    private void botonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonIniciarSesionActionPerformed
        if (objetoControlador.validarUsuario()) {
            routerP.mostrarSeleccionDimension1();
            vaciarTextField();
        }
    }

    public void vaciarTextField() {
        cajaTexto.setText("");
    }// GEN-LAST:event_botonIniciarSesionActionPerformed

    private void botonIniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_botonIniciarSesionMouseEntered
        botonIniciarSesion.setBackground(new Color(85, 208, 82));
    }// GEN-LAST:event_botonIniciarSesionMouseEntered

    private void botonIniciarSesionMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_botonIniciarSesionMouseExited
        botonIniciarSesion.setBackground(new Color(117, 183, 168));
    }// GEN-LAST:event_botonIniciarSesionMouseExited

    public String getTxtapodo() {
        return cajaTexto.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apodo;
    private javax.swing.JButton botonIniciarSesion;
    private javax.swing.JTextField cajaTexto;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
