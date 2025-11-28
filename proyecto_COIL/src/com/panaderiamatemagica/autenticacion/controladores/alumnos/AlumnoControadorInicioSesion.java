/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controladores.alumnos;

import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionVista;
import com.panaderiamatemagica.autenticacion.vista.RegistroVista;
import com.panaderiamatemagica.core.RouterControlador;
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
    private RouterControlador router;
    private AlumnoDAO alumnoDAO;

    public AlumnoControadorInicioSesion(InicioSesionVista vista, RouterControlador router) {
        this.vista = vista;
        this.router = router;
        this.alumnoDAO = new AlumnoDAO();
    }

    public boolean validarUsuario() {
        String apodoIngresado = vista.getTxtapodo();

        if (apodoIngresado == null || apodoIngresado.trim().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El apodo no puede estar vacío.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            boolean apodoEncontrado = alumnoDAO.verificarUnicidadApodoBD(apodoIngresado);

            if (apodoEncontrado) {
                AlumnoModelo alumno = alumnoDAO.obtenerAlumnoPorApodo(apodoIngresado);

                if (alumno != null) {
                    router.setAlumnoActual(alumno);
                    System.out.println(
                            "✓ Alumno autenticado: " + alumno.getApodo() + " (ID: " + alumno.getId_Alumno() + ")");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(vista,
                            "Error al cargar los datos del alumno.",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(vista,
                        "El apodo no existe en la Base de Datos.",
                        "MENSAJE DE ERROR: APODO INEXISTENTE", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error de BDT durante el inicio de sesión: " + e.getMessage());
            JOptionPane.showMessageDialog(vista,
                    "Error al verificar la base de datos. Verifique su conexion wifi.",
                    "ERROR DE CONEXIÓN BDT", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
