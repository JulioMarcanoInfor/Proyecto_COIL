package com.panaderiamatemagica.autenticacion.controladores.alumnos;

import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionVista;
import com.panaderiamatemagica.core.RouterControlador;
import javax.swing.JOptionPane;
import com.panaderiamatemagica.core.dao.AlumnoDAO;
import java.sql.SQLException;
// Importaciones del Logger
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Equipo Dell
 */
public class AlumnoControadorInicioSesion {
    private InicioSesionVista vista;
    private RouterControlador router;
    private AlumnoDAO alumnoDAO;
    
    // 1. [AGREGAR ESTA LÍNEA] Definimos el objeto LOGGER
    private static final Logger LOGGER = Logger.getLogger(AlumnoControadorInicioSesion.class.getName());

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
            // Lógica de base de datos
            boolean apodoEncontrado = alumnoDAO.verificarUnicidadApodoBD(apodoIngresado);

            if (apodoEncontrado) {
                AlumnoModelo alumno = alumnoDAO.obtenerAlumnoPorApodo(apodoIngresado);

                if (alumno != null) {
                    router.setAlumnoActual(alumno);
                    // [CORRECTO] Sin System.out.println. Éxito silencioso.
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
            // 2. [CORREGIDO] Usamos la variable 'LOGGER' (instancia) en vez de la clase 'Logger'
            LOGGER.log(Level.SEVERE, "Error crítico de BDT en login para: " + apodoIngresado, e);
            
            JOptionPane.showMessageDialog(vista,
                    "Error al verificar la base de datos. Verifique su conexion wifi.",
                    "ERROR DE CONEXIÓN BDT", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}