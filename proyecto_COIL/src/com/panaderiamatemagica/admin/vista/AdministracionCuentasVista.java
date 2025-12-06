/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panaderiamatemagica.admin.vista;

import com.panaderiamatemagica.admin.controlador.RouterAdminControlador;
import com.panaderiamatemagica.core.dao.AlumnoDAO;
import com.panaderiamatemagica.core.visual.componentes.ScreenUtils;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author User
 */
public class AdministracionCuentasVista extends javax.swing.JPanel {
    private RouterAdminControlador routerAdmin;
    private AlumnoDAO configuracionTabla;
    /**
     * Creates new form AdministracionCuentasVista
     */
    public AdministracionCuentasVista(RouterAdminControlador routerAdmin) {
        this.routerAdmin = routerAdmin;
        configuracionTabla = new AlumnoDAO();

        // 1. Inicializar componentes (Esto los agrega a 'this' con AbsoluteLayout)
        initComponents(); 
        
        // 2. Configurar el contenedor intermedio (Tu "FondoPanel")
        javax.swing.JPanel panelContenido = new javax.swing.JPanel();
        panelContenido.setBackground(new java.awt.Color(255, 228, 196)); // Tu color original
        // "insets 0" quita bordes, "fill" ocupa todo, "novisualpadding" ayuda con la precisión
        panelContenido.setLayout(new net.miginfocom.swing.MigLayout("fill, insets 0, novisualpadding", "[grow]", "[grow]"));

        // 3. Cambiar el layout de la vista principal para alojar el panelContenido
        this.setLayout(new java.awt.BorderLayout());
        this.add(panelContenido, java.awt.BorderLayout.CENTER);

        configuracionTabla.MostrarAlumnos(jTable1, "Melanie");

        // 4. Obtener factor de escala
        double scale = ScreenUtils.getScaleFactor();
        
        // =================================================================================
        // MIGRACIÓN DE COMPONENTES AL PANEL CON MIGLAYOUT
        // Fórmula: (ValorOriginal * scale)
        // =================================================================================

        // --- 1. TABLA (jScrollPane2) ---
        // Original: 120, 110, 840, 390
        configurarComponente(this, panelContenido, jScrollPane2, scale, 120, 110, 840, 390);

        // --- 2. BOTÓN REFRESCAR (jButton1) ---
        // Original: 1010, 110, 200, 50
        configurarComponente(this, panelContenido, jButton1, scale, 1010, 110, 200, 50);

        // --- 3. BOTÓN ACIERTOS (jButton3) ---
        // Original: 970, 180, 290, 50
        configurarComponente(this, panelContenido, jButton3, scale, 970, 180, 290, 50);

        // --- 4. TEXTFIELD APODO (apodo) ---
        // Original: 270, 510, 640, 40
        configurarComponente(this, panelContenido, apodo, scale, 270, 510, 640, 40);

        // --- 5. LABEL BUSCAR APODO (jLabel1) ---
        // Original: 120, 520, 540, 30
        configurarComponente(this, panelContenido, jLabel1, scale, 120, 520, 540, 30);

        // --- 6. BOTÓN BUSCAR APODO (buscarPorApodo) ---
        // Original: 950, 510, 130, 40
        configurarComponente(this, panelContenido, buscarPorApodo, scale, 950, 510, 130, 40);

        // --- 7. TEXTFIELD APELLIDO (apellido) ---
        // Original: 640, 590, 290, 40
        configurarComponente(this, panelContenido, apellido, scale, 640, 590, 290, 40);

        // --- 8. LABEL BUSCAR NOMBRE/APELLIDO (jLabel2) ---
        // Original: 90, 600, 540, 30
        configurarComponente(this, panelContenido, jLabel2, scale, 90, 600, 540, 30);

        // --- 9. BOTÓN BUSCAR NOMBRE (buscarPorNombre) ---
        // Original: 960, 590, 130, 40
        configurarComponente(this, panelContenido, buscarPorNombre, scale, 960, 590, 130, 40);

        // --- 10. TEXTFIELD NOMBRE (nombre) ---
        // Original: 320, 590, 300, 40
        configurarComponente(this, panelContenido, nombre, scale, 320, 590, 300, 40);

        // --- 11. LABEL TÍTULO APELLIDO (jLabel3) ---
        // Original: 760, 570. (Sin ancho/alto definido en NetBeans, usaremos Preferred Size)
        configurarComponente(this, panelContenido, jLabel3, scale, 760, 570, -1, -1);

        // --- 12. LABEL TÍTULO NOMBRE (jLabel4) ---
        // Original: 440, 570.
        configurarComponente(this, panelContenido, jLabel4, scale, 440, 570, -1, -1);
        
        // Forzar repintado final
        this.revalidate();
        this.repaint();
    }

    /**
     * Método auxiliar para limpiar el código repetitivo.
     * Mueve un componente del contenedor viejo al nuevo, reescala fuente, posición y tamaño.
     * Si w o h son -1, se usa el tamaño preferido del componente (útil para JLabels simples).
     */
    private void configurarComponente(java.awt.Container oldParent, java.awt.Container newParent, 
                                      javax.swing.JComponent comp, double scale, 
                                      int x, int y, int w, int h) {
        
        // 1. Reescalar fuente si existe
        if (comp.getFont() != null) {
            float newSize = (float) (comp.getFont().getSize() * scale);
            comp.setFont(comp.getFont().deriveFont(Math.max(newSize, 10.0f)));
        }
        
        // 2. Calcular nuevas coordenadas
        int newX = (int)(x * scale);
        int newY = (int)(y * scale);
        
        // 3. Crear string de restricciones para MigLayout
        String constraints;
        if (w != -1 && h != -1) {
            // Caso normal: tiene ancho y alto definidos
            int newW = (int)(w * scale);
            int newH = (int)(h * scale);
            constraints = "pos " + newX + " " + newY + ", w " + newW + "!, h " + newH + "!";
        } else {
            // Caso Labels sin tamaño fijo: Usar "preferred size"
            constraints = "pos " + newX + " " + newY + ", w min:pref, h min:pref";
        }

        // 4. Mover componente
        oldParent.remove(comp);
        newParent.add(comp, constraints);
    }

/**
 * Método auxiliar para no repetir el código del "if font != null"
 */
private void reescalarFuente(java.awt.Component comp, double scale) {
    if (comp.getFont() != null) {
        float newSize = (float) (comp.getFont().getSize() * scale);
        comp.setFont(comp.getFont().deriveFont(Math.max(newSize, 10.0f)));
    }
}
    
    private void aplicarReescaladoInterno() {
        double scaleFactor = ScreenUtils.getScaleFactor();
        
        // Solo aplicar si el factor es significativamente diferente a 1
        if (Math.abs(scaleFactor - 1.0) > 0.01) {
            
            // Reescalar recursivamente a todos los elementos dentro de ESTE PANEL
            ScreenUtils.scaleComponentRecursively(this, scaleFactor);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        apodo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buscarPorApodo = new javax.swing.JButton();
        apellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buscarPorNombre = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 228, 196));
        setForeground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(555, 615));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 840, 390));

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("REFRESCAR TABLA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 200, 50));

        jButton3.setBackground(new java.awt.Color(153, 102, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("MOSTRAR ACIERTOS DE MAYOR A MENOR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 180, 290, 50));
        add(apodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 640, 40));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar alumno por apodo:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 540, 30));

        buscarPorApodo.setText("BUSCAR");
        buscarPorApodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorApodoActionPerformed(evt);
            }
        });
        add(buscarPorApodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 510, 130, 40));

        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });
        add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, 290, 40));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar alumno por nomre y apellido");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 600, 540, 30));

        buscarPorNombre.setText("BUSCAR");
        buscarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorNombreActionPerformed(evt);
            }
        });
        add(buscarPorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 590, 130, 40));
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 590, 300, 40));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("APELLIDO");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NOMBRE");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 570, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        configuracionTabla.MostrarAlumnos(jTable1, "Melanie");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        configuracionTabla.MostrarAlumnosPorMayorEstrellas(jTable1, "Melanie");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    private void buscarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorNombreActionPerformed
        String nombre1 = nombre.getText();
        String apellido1 = apellido.getText();
        
        if (nombre1.isEmpty() && apellido1.isEmpty()){
            JOptionPane.showMessageDialog(null, 
                              "¡No inserto ningun nombre ni apellido!", 
                              "", 
                              JOptionPane.WARNING_MESSAGE);
            
        } else if (nombre1.isEmpty() && !apellido1.isEmpty()){
                    configuracionTabla.MostrarAlumnosPorApellido(jTable1, "Melanie", apellido1);
                    
        } else if (apellido1.isEmpty() && !nombre1.isEmpty()){
            configuracionTabla.MostrarAlumnosPorNombre(jTable1, "Melanie", nombre1);
        } else {
            configuracionTabla.MostrarAlumnosPorNombreCompleto(jTable1, "Melanie", nombre1, apellido1);
        }
    }//GEN-LAST:event_buscarPorNombreActionPerformed

    private void buscarPorApodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorApodoActionPerformed
        String apodo1 = apodo.getText();
        if (apodo1.isEmpty()){
            JOptionPane.showMessageDialog(null, 
                              "¡No inserto un apodo!", 
                              "", 
                              JOptionPane.WARNING_MESSAGE);
        }
        else {
            configuracionTabla.MostrarAlumnoPorApodo(jTable1, "Melanie", apodo1);
        }
    }//GEN-LAST:event_buscarPorApodoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JTextField apodo;
    private javax.swing.JButton buscarPorApodo;
    private javax.swing.JButton buscarPorNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
