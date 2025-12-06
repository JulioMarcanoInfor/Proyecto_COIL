/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.panaderiamatemagica.core.visual;
import com.panaderiamatemagica.core.visual.componentes.ScreenUtils;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Pantalla Principal Purificada
 * @author user
 */
public class PantallaPrincipalVista extends javax.swing.JFrame {
    
    private CardLayout listaPantallas;
    // Referencia al monitor (declarado manualmente para tener control total)
    private JPanel monitor; 
    
    public PantallaPrincipalVista() {
        // 1. Inicializamos la interfaz manualmente (Adiós GroupLayout conflictivo)
        inicializarInterfaz();
        
        // 2. Configurar el gestor de pantallas
        configurarListaPantallas();
        
        // 3. Maximizar ventana y aplicar lógica de pantalla
        configurarVentana();
    }
    
    private void inicializarInterfaz() {
        // Configuración básica del Frame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panadería Matemágica");
        
        // CAMBIO CLAVE: Usamos BorderLayout. 
        // Este layout estira automáticamente lo que esté en el CENTRO.
        setLayout(new BorderLayout());

        // Inicializamos el monitor
        monitor = new JPanel();
        monitor.setBackground(new java.awt.Color(255, 255, 255));
        
        // Agregamos el monitor al centro. Se estirará automáticamente.
        add(monitor, BorderLayout.CENTER);
    }
    
    private void configurarVentana() {
        // Forzar pantalla completa maximizada
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Si quieres quitar los bordes de la ventana (estilo juego real), descomenta esto:
        // setUndecorated(true);
        
        // Opcional: Establecer un tamaño mínimo para evitar que la encojan demasiado
        setMinimumSize(new Dimension(800, 600));
        
        // Hacemos visible la ventana
        pack(); // Ajusta los componentes
        setVisible(true); // Muestra la ventana
    }
    
    private void configurarListaPantallas(){
        listaPantallas = new CardLayout();
        monitor.setLayout(listaPantallas);
    }
    
    public void mostrarPanel(String nombrePanel) {
        listaPantallas.show(monitor, nombrePanel);
    }
    
    public void agregarPanel(JPanel panel, String nombre) {
        // 1. Calculamos factor de escala
        double scaleFactor = ScreenUtils.getScaleFactor();
        
        System.out.println("Agregando panel: " + nombre + " | Factor escala: " + scaleFactor);

        // 3. Agregar al CardLayout
        monitor.add(panel, nombre);
        
        // 4. IMPORTANTE: Validar el árbol de componentes para asegurar que se pinten
        monitor.revalidate();
        monitor.repaint();
    }

    // Ya no necesitamos el método initComponents generado automáticamente
    // ni el main si lo tenías aquí.

    
}




