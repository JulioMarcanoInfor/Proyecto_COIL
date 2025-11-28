/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.panaderiamatemagica.core;
import com.panaderiamatemagica.core.visual.PantallaPrincipalVista;

import java.sql.Connection; 
import java.sql.SQLException; // También es necesaria para el try-catch
/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // para ver si no tienen problemas con la coneccion a la bdt
        ConexionBDT c = new ConexionBDT();
        System.out.println("Intentando obtener la conexión...");
            try (Connection conn = c.obtenerConexion() ) {
                if (conn != null) {
                    System.out.println("CONEXION ESTABLECIDA.");
                }
            } catch (SQLException e) {
                System.err.println("ERROR: La conexión fallo.");
                System.err.println("Detalles: " + e.getMessage());
            }

        //este codigo crea una instancia de RouterCntrolador y ese codigo extraño es necesario para que la interfaz grafica funcione
        java.awt.EventQueue.invokeLater(() -> {
            new RouterControlador(); 
        });
    }
}
