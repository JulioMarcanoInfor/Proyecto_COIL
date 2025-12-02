/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import com.panaderiamatemagica.autenticacion.vista.FondoAutenticacionVista;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionVista;
import com.panaderiamatemagica.autenticacion.vista.RegistroVista;
import com.panaderiamatemagica.autenticacion.vista.SeleccionRolVista;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class CreadorPdf {

    public void generarReporteAlumno(AlumnoModelo alumno, String rutaArchivo) {
        
        int y = 750;
        int x = 50; 
        final int LEADING = 20;

        // CORRECTO PARA PDFBox 3.x:
        PDFont fontNormal = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
        PDFont fontBold = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            
            contentStream.beginText();
            contentStream.setFont(fontBold, 16);
            contentStream.newLineAtOffset(x, y);
            contentStream.showText("REPORTE DE RENDIMIENTO DEL ALUMNO");
            contentStream.endText();
            y -= LEADING * 2; 
            
            //Estudiantes 
            contentStream.beginText();
            contentStream.setFont(fontNormal, 12);
            contentStream.newLineAtOffset(x, y);
            contentStream.showText("Apodo: " + alumno.getApodo());
            y -= LEADING;
            contentStream.newLineAtOffset(0, -LEADING); 
            contentStream.showText("Nombre Completo: " + alumno.getNombre() + " " + alumno.getApellido());
            y -= LEADING;
            contentStream.newLineAtOffset(0, -LEADING);
            contentStream.showText("Profesor: " + alumno.getProfesor());
            contentStream.endText();
            y -= LEADING;

            contentStream.beginText();
            contentStream.setFont(fontBold, 14);
            contentStream.newLineAtOffset(x, y);
            contentStream.showText("Resultados Matemáticos");
            y -= LEADING;
            
            //Promedios 
            contentStream.setFont(fontNormal, 12);
            contentStream.newLineAtOffset(0, -LEADING);
            contentStream.showText("Promedio de Aciertos: " + String.format("%.2f", alumno.getPromedioAciertos()) + "%");
            y -= LEADING;
            contentStream.newLineAtOffset(0, -LEADING);
            contentStream.showText("Promedio de Desaciertos: " + String.format("%.2f", alumno.getPromedioDesaciertos()) + "%");
            contentStream.endText();
            y -= LEADING;

            contentStream.beginText();
            contentStream.setFont(fontBold, 14);
            contentStream.newLineAtOffset(x, y);
            contentStream.showText("Progreso y Recompensas");
            y -= LEADING;
            
            //Recompensas
            contentStream.setFont(fontNormal, 12);
            contentStream.newLineAtOffset(0, -LEADING);
            contentStream.showText("Nivel D1: " + alumno.getIdNivelD1());
            y -= LEADING;
            contentStream.newLineAtOffset(0, -LEADING);
            contentStream.showText("Galletas Acumuladas: " + alumno.getNumeroGalletas());
            y -= LEADING;
            contentStream.newLineAtOffset(0, -LEADING);
            contentStream.showText("Estrellas Obtenidas: " + alumno.getNumeroEstrella());
            contentStream.endText();
            y -= LEADING;

            contentStream.close();
            document.save(rutaArchivo);
            
            System.out.println("Reporte PDF generado exitosamente en: " + rutaArchivo);

        } catch (IOException e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public void initComponents(FondoAutenticacionVista fondoAutenticacionVista) {
        fondoAutenticacionVista.monitor = new JPanel();
        fondoAutenticacionVista.pantallaSeleccionRol = new SeleccionRolVista(fondoAutenticacionVista.routerP, fondoAutenticacionVista.routerA);
        fondoAutenticacionVista.pantallaInicioSesion = new InicioSesionVista(fondoAutenticacionVista.routerP, fondoAutenticacionVista.routerA);
        fondoAutenticacionVista.pantallaRegistro = new RegistroVista(fondoAutenticacionVista.routerP, fondoAutenticacionVista.routerA);
        fondoAutenticacionVista.botonVolver = new JButton();
        fondoAutenticacionVista.setBackground(new Color(255, 228, 171));
        fondoAutenticacionVista.setPreferredSize(new Dimension(1920, 1080));
        fondoAutenticacionVista.monitor.setLayout(new CardLayout());
        fondoAutenticacionVista.monitor.add(fondoAutenticacionVista.pantallaSeleccionRol, "ROL");
        fondoAutenticacionVista.monitor.add(fondoAutenticacionVista.pantallaInicioSesion, "INICIO SESION");
        fondoAutenticacionVista.monitor.add(fondoAutenticacionVista.pantallaRegistro, "REGISTRO");
        fondoAutenticacionVista.botonVolver.setBackground(new Color(117, 183, 168));
        fondoAutenticacionVista.botonVolver.setFont(new Font("Showcard Gothic", 0, 24)); // NOI18N
        fondoAutenticacionVista.botonVolver.setForeground(new Color(0, 0, 0));
        fondoAutenticacionVista.botonVolver.setText("<");
        fondoAutenticacionVista.botonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fondoAutenticacionVista.botonVolver.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                fondoAutenticacionVista.botonVolverMouseEntered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                fondoAutenticacionVista.botonVolverMouseExited(evt);
            }
        });
        fondoAutenticacionVista.botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                fondoAutenticacionVista.botonVolverActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(fondoAutenticacionVista);
        fondoAutenticacionVista.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(416, 416, 416).addComponent(fondoAutenticacionVista.monitor, GroupLayout.PREFERRED_SIZE, 640, GroupLayout.PREFERRED_SIZE).addContainerGap(864, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(fondoAutenticacionVista.botonVolver, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE).addGap(1050, 1050, 1050)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(92, 92, 92).addComponent(fondoAutenticacionVista.monitor, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE).addContainerGap(328, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(fondoAutenticacionVista.botonVolver, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE).addGap(470, 470, 470)));
    } // </editor-fold>

    public void inicializarPantallas(FondoAutenticacionVista fondoAutenticacionVista) {
        fondoAutenticacionVista.pantallasAutenticacion = (CardLayout) fondoAutenticacionVista.monitor.getLayout();
    }
}