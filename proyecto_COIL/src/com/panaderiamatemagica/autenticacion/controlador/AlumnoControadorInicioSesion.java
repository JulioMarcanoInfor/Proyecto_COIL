/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controlador;

import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionVista;
import com.panaderiamatemagica.autenticacion.vista.RegistroVista;
import java.util.ArrayList;
import javax.imageio.spi.RegisterableService;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo Dell
 */
public class AlumnoControadorInicioSesion {
    private InicioSesionVista vista;
    private ArrayList<AlumnoModelo> listaAlumnos; // lita de alumns registrados.

    public AlumnoControadorInicioSesion(InicioSesionVista vista, ArrayList<AlumnoModelo> listaAlumnos) {
        this.vista = vista;
        this.listaAlumnos = listaAlumnos;
    }

    public boolean validarUsuario(){
        // Usar la lista para la validación:
        for (AlumnoModelo alumno : listaAlumnos) {
            if (alumno.getApodo().equals(vista.getTxtapodo())) {
                // Si el apodo coincide con uno registrado, la validación pasa.
                JOptionPane.showMessageDialog(vista, 
                    "que disfrutes>>.",
                    "Bienvenido: ..", JOptionPane.ERROR_MESSAGE);
                return true; 
            }
        }
        JOptionPane.showMessageDialog(vista, 
                        "El apodo no existe.",
                        "MENSAJE DE ERROR: APODO INEXISTENTE", JOptionPane.ERROR_MESSAGE);
        return false;
    
    }
    
    
    
}
