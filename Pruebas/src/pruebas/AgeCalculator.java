/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

/**
 *
 * @author User
 */
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Period;


public class AgeCalculator {

    // Servidor NTP de ejemplo (puedes usar otros servidores públicos)
    private static final String TIME_SERVER = "time.google.com"; 

    /**
     * Obtiene la fecha actual de un servidor NTP (hora real)
     * @return LocalDate con la fecha actual del servidor, o null si falla.
     */
    public LocalDate getRealCurrentDate() {
        NTPUDPClient client = new NTPUDPClient();
        client.setDefaultTimeout(5000); // Timeout de 5 segundos

        try {
            InetAddress address = InetAddress.getByName(TIME_SERVER);
            TimeInfo timeInfo = client.getTime(address);
            
            // Obtener el tiempo de la respuesta del servidor en milisegundos
            long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
            
            // Convertir el tiempo (long) a un objeto Instant, que representa un punto en el tiempo
            Instant instant = Instant.ofEpochMilli(returnTime);
            
            // Convertir el Instant a LocalDate usando una zona horaria (UTC es la más segura)
            return LocalDate.ofInstant(instant, ZoneId.of("UTC"));

        } catch (IOException e) {
            System.err.println("Error al conectar con el servidor NTP: " + e.getMessage());
            // **IMPORTANTE**: Aquí deberías tener una estrategia de respaldo
            // como usar la hora local y notificar al usuario.
            return null;
        } finally {
            client.close();
        }
    }

    /**
     * Calcula la edad en años comparando la fecha de nacimiento con la fecha real.
     * @param birthDate Fecha de nacimiento del niño.
     * @return Edad calculada en años, o -1 si no se pudo obtener la fecha real.
     */
    public int calculateAge(LocalDate birthDate) {
        LocalDate realCurrentDate = getRealCurrentDate();

        if (realCurrentDate != null) {
            return Period.between(birthDate, realCurrentDate).getYears();
        } else {
            // Manejar el error, por ejemplo, devolviendo un valor de error o la edad almacenada
            return -1; 
        }
    }

    public static void main(String[] args) {
        AgeCalculator calculator = new AgeCalculator();
        
        // Ejemplo: Asumimos que el niño nació el 10 de septiembre de 2018
        LocalDate birthDate = LocalDate.of(2018, 9, 10); 
        
        int age = calculator.calculateAge(birthDate);

        if (age != -1) {
            System.out.println("La fecha real obtenida es: " + calculator.getRealCurrentDate());
            System.out.println("Fecha de nacimiento: " + birthDate);
            System.out.println("La edad real del niño es: " + age + " años.");
        } else {
            System.out.println("No se pudo calcular la edad. Verifique la conexión a internet.");
        }
    }
}
