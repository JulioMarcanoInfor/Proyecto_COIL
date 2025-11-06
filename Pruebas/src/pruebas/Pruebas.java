/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;
import java.time.LocalDate;
/**
 *
 * @author User
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// 1. Crear una instancia de AgeCalculator
        AgeCalculator calculator = new AgeCalculator();
        
        // 2. Definir una fecha de nacimiento (Ejemplo: 15 de Mayo de 2010)
        LocalDate fechaNacimiento = LocalDate.of(2010, 5, 15);

        // 3. Obtener la hora actual REAL del servidor NTP
        LocalDate fechaActualReal = calculator.getRealCurrentDate();

        // Verificar si se pudo obtener la fecha (la comunicación NTP puede fallar)
        if (fechaActualReal != null) {
            
            // 4. Calcular la edad usando la fecha real
       int edad = calculator.calculateAge(fechaNacimiento);
            
            System.out.println("✅ PRUEBA EXITOSA DE CONFIGURACIÓN Y CÓDIGO ✅");
            System.out.println("----------------------------------------------");
            System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
            System.out.println("Fecha Actual (NTP):  " + fechaActualReal);
            
            // LÍNEA CORREGIDA (sin **)
            System.out.println("La edad calculada es: " + edad + " años");
            
        } else {
            System.out.println("❌ ERROR DE CONEXIÓN NTP ❌");
            System.out.println("No se pudo obtener la fecha real del servidor (time.google.com).");
            System.out.println("Verifica tu conexión a internet o el firewall.");
        }
    }
}
