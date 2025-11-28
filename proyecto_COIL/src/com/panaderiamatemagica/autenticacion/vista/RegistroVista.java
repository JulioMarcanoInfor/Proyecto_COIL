/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.vista;

import com.panaderiamatemagica.autenticacion.controladores.alumnos.AlumnoControladorRegistro;
import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import com.panaderiamatemagica.core.RouterControlador;
import com.panaderiamatemagica.core.visual.componentes.ResponsivePanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class RegistroVista extends javax.swing.JPanel {

    private JLabel lblErrorNombre;
    private JLabel lblErrorApellido;
    private JLabel lblErrorApodo;
    private JLabel lblErrorFechaNacimiento;

    private RouterControlador router;
    private AlumnoModelo nuevoAlumno;
    private AlumnoControladorRegistro objetoControlador;

    /**
     * Creates new form RegistroVista
     */
    public RegistroVista(RouterControlador router) {
        this.router = router;

        lblErrorNombre = crearLabelError();
        lblErrorApellido = crearLabelError();
        lblErrorApodo = crearLabelError();
        lblErrorFechaNacimiento = crearLabelError();

        // creamos el alumno
        nuevoAlumno = new AlumnoModelo();

        // creamos el controlador
        objetoControlador = new AlumnoControladorRegistro(
                nuevoAlumno,
                this);

        initComponents();

        // Crear panel responsivo
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

        setLayout(new java.awt.BorderLayout());
        add(responsivePanel, java.awt.BorderLayout.CENTER);

        // Remover componentes del diseño original
        remove(txtnombre);
        remove(txtapellido);
        remove(txtapodo);
        remove(txtfechaNacimiento);
        remove(jTextField1); // Nombre
        remove(jTextField3); // Apellido
        remove(jTextField4); // Fecha
        remove(jTextField5); // Apodo
        remove(jButton1);

        // Configurar fuentes y colores
        Font labelFont = new Font("Segoe UI Semibold", Font.PLAIN, 18);
        Color labelColor = Color.BLACK;

        txtnombre.setFont(labelFont);
        txtnombre.setForeground(labelColor);
        txtapellido.setFont(labelFont);
        txtapellido.setForeground(labelColor);
        txtfechaNacimiento.setFont(labelFont);
        txtfechaNacimiento.setForeground(labelColor);
        txtapodo.setFont(labelFont);
        txtapodo.setForeground(labelColor);

        // Agregar componentes al panel responsivo
        // Título (reutilizamos txtnombre como título o creamos uno nuevo, mejor usamos
        // los labels existentes para los campos)
        JLabel titulo = new JLabel("REGISTRO");
        titulo.setFont(new Font("Showcard Gothic", Font.PLAIN, 36));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setForeground(Color.BLACK);

        // Coordenadas ajustadas para caber en 640x660
        responsivePanel.addScalable(titulo, 90, 30, 450, 50);

        // Fila 1: Nombre y Apellido
        responsivePanel.addScalable(txtnombre, 80, 100, 200, 30);
        responsivePanel.addScalable(jTextField1, 80, 130, 220, 40); // Nombre
        responsivePanel.addScalable(lblErrorNombre, 80, 170, 220, 20);

        responsivePanel.addScalable(txtapellido, 320, 100, 200, 30);
        responsivePanel.addScalable(jTextField3, 320, 130, 220, 40); // Apellido
        responsivePanel.addScalable(lblErrorApellido, 320, 170, 220, 20);

        // Fila 2: Fecha Nacimiento
        responsivePanel.addScalable(txtfechaNacimiento, 80, 200, 460, 30);
        responsivePanel.addScalable(jTextField4, 80, 230, 460, 40); // Fecha
        responsivePanel.addScalable(lblErrorFechaNacimiento, 80, 270, 460, 20);

        // Fila 3: Apodo
        responsivePanel.addScalable(txtapodo, 80, 300, 460, 30);
        responsivePanel.addScalable(jTextField5, 80, 330, 460, 40); // Apodo
        responsivePanel.addScalable(lblErrorApodo, 80, 370, 460, 20);

        // Botón
        responsivePanel.addScalable(jButton1, 130, 420, 370, 100);
    }

    private JLabel crearLabelError() {
        JLabel label = new JLabel("");
        label.setForeground(Color.RED);
        label.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        label.setVisible(false); // Oculto por defecto
        return label;
    }

    public void mostrarErrorNombre(String mensaje) {
        lblErrorNombre.setText("" + mensaje);
        lblErrorNombre.setVisible(true);
    }

    public void limpiarErrorNombre() {
        lblErrorNombre.setText("");
        lblErrorNombre.setVisible(false);
    }

    public void mostrarErrorApellido(String mensaje) {
        lblErrorApellido.setText("" + mensaje);
        lblErrorApellido.setVisible(true);
    }

    public void limpiarErrorApellido() {
        lblErrorApellido.setText("");
        lblErrorApellido.setVisible(false);
    }

    public void mostrarErrorApodo(String mensaje) {
        lblErrorApodo.setText("" + mensaje);
        lblErrorApodo.setVisible(true);
    }

    public void limpiarErrorApodo() {
        lblErrorApodo.setText("");
        lblErrorApodo.setVisible(false);
    }

    public void mostrarErrorFechaNacimiento(String mensaje) {
        lblErrorFechaNacimiento.setText("" + mensaje);
        lblErrorFechaNacimiento.setVisible(true);
    }

    public void limpiarErrorFechaNacimiento() {
        lblErrorFechaNacimiento.setText("");
        lblErrorFechaNacimiento.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        txtnombre = new javax.swing.JLabel();
        txtapellido = new javax.swing.JLabel();
        txtapodo = new javax.swing.JLabel();
        txtfechaNacimiento = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(253, 188, 167));
        setPreferredSize(new java.awt.Dimension(640, 660));

        txtnombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtnombre.setText("Nombre");

        txtapellido.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtapellido.setText("Apellido");

        txtapodo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtapodo.setText("Apodo");

        txtfechaNacimiento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtfechaNacimiento.setText("Fecha de nacimiento (dd/mm/aaaa)");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0), 2));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0), 2));

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0), 2));

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0), 2));

        jButton1.setBackground(new java.awt.Color(84, 180, 183));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("REGISTRARSE");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        // Layout manual no es necesario porque usamos ResponsivePanel, pero dejamos el
        // init básico
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (objetoControlador.validarDatos()) {
                // Solo si la validacion es exitosa y el registro fue guardado:
                router.mostrarSeleccionPanaderoVista();
            }
        } catch (java.sql.SQLException e) {
            System.err.println("ERROR: Fallo de base de datos durante el registro: " + e.getMessage());
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error de conexión o consulta a la Base de Datos.",
                    "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    // get de los paramentros.
    public String getTxtapellido() {
        return jTextField3.getText();
    }

    public String getTxtnombre() {
        return jTextField1.getText();
    }

    public String getTxtapodo() {
        return jTextField5.getText();
    }

    public String getTxtfechaNacimiento() {
        return jTextField4.getText();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel txtapellido;
    private javax.swing.JLabel txtapodo;
    private javax.swing.JLabel txtfechaNacimiento;
    private javax.swing.JLabel txtnombre;
    // End of variables declaration
}
