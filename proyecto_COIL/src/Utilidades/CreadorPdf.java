/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import java.io.IOException;
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
}