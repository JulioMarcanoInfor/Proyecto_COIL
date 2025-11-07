/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.panaderiamatemagica.core;
import com.panaderiamatemagica.comunes.RouterControlador;
import com.panaderiamatemagica.core.visual.PantallaPrincipalVista;
/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //este codigo crea una instancia de RouterCntrolador y ese codigo extraño es necesario para que la interfaz grafica funcione
        java.awt.EventQueue.invokeLater(() -> {
            new RouterControlador(); 
        });
    }
}
