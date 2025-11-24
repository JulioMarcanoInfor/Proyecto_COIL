/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controladores.alumnos;

import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionVista;
import com.panaderiamatemagica.autenticacion.vista.RegistroVista;
import java.util.ArrayList;
import javax.imageio.spi.RegisterableService;
import javax.swing.JOptionPane;
import com.panaderiamatemagica.core.dao.AlumnoDAO;
import java.sql.SQLException;


/**
 *
 * @author Equipo Dell
 */
public class AlumnoControadorInicioSesion {
    private InicioSesionVista vista;
    // ya no se usa.
    //private ArrayList<AlumnoModelo> listaAlumnos; // lita de alumns registrados.
    private AlumnoDAO alumnoDAO;
    
    public AlumnoControadorInicioSesion(InicioSesionVista vista) {
        this.vista = vista;
        this.alumnoDAO = new AlumnoDAO(); 
    }


    public boolean validarUsuario(){
        String apodoIngresado = vista.getTxtapodo();
        
        // asegurar que el campo no esté vacio porcia
        if (apodoIngresado == null || apodoIngresado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El apodo no puede estar vacío.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            // 1.verificamos la existencia del apodo en la bdt.
            //    Devuelve TRUE si el apodo ya existe.
            boolean apodoEncontrado = alumnoDAO.verificarUnicidadApodoBD(apodoIngresado);

            if (apodoEncontrado) {
                // Inicio de sesión exitoso
                JOptionPane.showMessageDialog(vista, 
                    "Que disfrutes>>.",
                    "Bienvenido: ..", JOptionPane.INFORMATION_MESSAGE);
                return true; 
            } else {
                // Apodo no encontrado en la BD
                JOptionPane.showMessageDialog(vista, 
                    "El apodo no existe en la Base de Datos.",
                    "MENSAJE DE ERROR: APODO INEXISTENTE", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            // Error de conexion o consulta de BD
            System.err.println("Error de BDT durante el inicio de sesión: " + e.getMessage());
            JOptionPane.showMessageDialog(vista, 
                "Error al verificar la base de datos. Verifique su conexion wifi.",
                "ERROR DE CONEXIÓN BDT", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    
}
