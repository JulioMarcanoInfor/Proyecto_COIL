/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class CreadorPdf {

    public void generarReporteGlobal(List<AlumnoModelo> listaAlumnos, String rutaArchivo) {
        try (PDDocument document = new PDDocument()) {

            PDPage pageGraficas = new PDPage(PDRectangle.A4);
            document.addPage(pageGraficas);
            PDPageContentStream contentStream = new PDPageContentStream(document, pageGraficas);
            
            float y = 750;

            contentStream.beginText();
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 18);
            contentStream.newLineAtOffset(50, y);
            contentStream.showText("Reporte del salon");
            contentStream.endText();
            y -= 40; 
            
            double sumaAciertos = 0;
            double sumaDesaciertos = 0;
            int totalAlumnos = listaAlumnos.size();

            for (AlumnoModelo al : listaAlumnos) {
                sumaAciertos += al.getPromedioAciertos();
                sumaDesaciertos += al.getPromedioDesaciertos();
            }

            double promAciertos = (totalAlumnos > 0) ? (sumaAciertos / totalAlumnos) : 0;
            double promDesaciertos = (totalAlumnos > 0) ? (sumaDesaciertos / totalAlumnos) : 0;
            
            String[] etiquetasRendimiento = {"Promedio Aciertos", "Promedio Desaciertos"};
            double[] valoresRendimiento = {promAciertos, promDesaciertos};
            Color[] coloresRendimiento = {new Color(46, 204, 113), new Color(231, 76, 60)}; 

            BufferedImage imgRendimiento = crearGraficaBarrasAgrupadas(
                "Balance General: Aciertos vs Errores", 
                etiquetasRendimiento, 
                valoresRendimiento, 
                100, 
                coloresRendimiento
            );
            
            PDImageXObject pdImgRendimiento = LosslessFactory.createFromImage(document, imgRendimiento);
            contentStream.drawImage(pdImgRendimiento, 40, y - 250, 520, 250);
            
            contentStream.close(); 

            PDPage pageTabla = new PDPage(PDRectangle.A4);
            document.addPage(pageTabla);
            PDPageContentStream tableStream = new PDPageContentStream(document, pageTabla);
            y = 750;

            tableStream.beginText();
            tableStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 14);
            tableStream.newLineAtOffset(50, y);
            tableStream.showText("Detalle Individual por Alumno");
            tableStream.endText();
            y -= 30;

            tableStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 10);
            tableStream.beginText();
            tableStream.newLineAtOffset(50, y);
            tableStream.showText("ALUMNO (Nombre Completo)");
            tableStream.newLineAtOffset(250, 0); 
            tableStream.showText("ACIERTOS");
            tableStream.newLineAtOffset(90, 0);
            tableStream.showText("DESACIERTOS");
            tableStream.endText();
            
            y -= 5;
            tableStream.moveTo(50, y);
            tableStream.lineTo(550, y); 
            tableStream.stroke();
            y -= 15;

            tableStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 10);

            for (AlumnoModelo al : listaAlumnos) {
                if (y < 50) { 
                    tableStream.close();
                    pageTabla = new PDPage(PDRectangle.A4);
                    document.addPage(pageTabla);
                    tableStream = new PDPageContentStream(document, pageTabla);
                    tableStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 10);
                    y = 750;
                }
                
                tableStream.beginText();
                tableStream.newLineAtOffset(50, y);
                
                String apodo = (al.getApodo() != null) ? al.getApodo() : "";
                String nombre = (al.getNombre() != null) ? al.getNombre() : "";
                String apellido = (al.getApellido() != null) ? al.getApellido() : "";
                
                String nombreCompleto = apodo + " (" + nombre + " " + apellido + ")";
             
                if(nombreCompleto.length() > 35) {
                    nombreCompleto = nombreCompleto.substring(0, 35) + "...";
                }
                
                tableStream.showText(nombreCompleto);
                
                tableStream.newLineAtOffset(250, 0); 
                tableStream.showText(String.format("%.1f %%", al.getPromedioAciertos()));
                
                tableStream.newLineAtOffset(90, 0);
                tableStream.showText(String.format("%.1f %%", al.getPromedioDesaciertos()));
                
                tableStream.endText();
                y -= 15;
            }

            tableStream.close();
            document.save(rutaArchivo);
            System.out.println("Reporte generado en: " + rutaArchivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage crearGraficaBarrasAgrupadas(String titulo, String[] etiquetas, double[] valores, double maxValorEjeY, Color[] colores) {
        int width = 600;
        int height = 300;
        int padding = 40;
        int labelPadding = 20;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(245, 248, 250)); 
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        FontMetrics fm = g2d.getFontMetrics();
        int titleWidth = fm.stringWidth(titulo);
        g2d.drawString(titulo, (width - titleWidth) / 2, 25);
        int x0 = padding + 20;
        int y0 = height - padding - labelPadding;
        int x1 = width - padding;
        int y1 = padding + 10;
        g2d.setFont(new Font("Arial", Font.PLAIN, 10));
        g2d.setColor(new Color(200, 200, 200)); 
        int numDivisiones = 5;
        for (int i = 0; i <= numDivisiones; i++) {
            int yLine = y0 - (i * (y0 - y1) / numDivisiones);
            double valLabel = i * (maxValorEjeY / numDivisiones);
            
            g2d.drawLine(x0, yLine, x1, yLine);
            g2d.setColor(Color.GRAY);
            String label = String.format("%.0f", valLabel);
            g2d.drawString(label, x0 - 30, yLine + 4);
            g2d.setColor(new Color(200, 200, 200)); 
        }

        int numBarras = etiquetas.length;
        if (numBarras > 0) {
            int availableWidth = x1 - x0;
            int barWidth = (availableWidth / numBarras) / 2; 
            if (barWidth > 100) barWidth = 100;
            
            int gap = (availableWidth - (barWidth * numBarras)) / (numBarras + 1);

            for (int i = 0; i < numBarras; i++) {
                double val = valores[i];
                int barHeight = (int) ((val / maxValorEjeY) * (y0 - y1));
                
                int xBar = x0 + gap + (i * (barWidth + gap));
                int yBar = y0 - barHeight;

                g2d.setColor(colores[i]);
                g2d.fillRect(xBar, yBar, barWidth, barHeight);
                g2d.setColor(colores[i].darker());
                g2d.drawRect(xBar, yBar, barWidth, barHeight);

                g2d.setColor(Color.BLACK);
                g2d.setFont(new Font("Arial", Font.BOLD, 11));
                String nombre = etiquetas[i];
                int labelWidth = g2d.getFontMetrics().stringWidth(nombre);
                g2d.drawString(nombre, xBar + (barWidth - labelWidth) / 2, y0 + 15);
                
                g2d.setColor(Color.DARK_GRAY);
                String valStr = String.format("%.1f", val);
                int valWidth = g2d.getFontMetrics().stringWidth(valStr);
                g2d.drawString(valStr, xBar + (barWidth - valWidth) / 2, yBar - 5);
            }
        }
        g2d.dispose();
        return image;
    }
}