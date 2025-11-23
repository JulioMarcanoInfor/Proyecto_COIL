/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controlador;

import com.panaderiamatemagica.autenticacion.vista.RegistroVista;
import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import Utilidades.Validacion;
import javax.swing.JOptionPane;
import com.panaderiamatemagica.core.dao.AlumnoDAO;
import java.sql.SQLException;

/**
 * Controlador para manejar el registro e inicio de sesión de Alumnos.
 */
public class AlumnoControladorRegistro {
    private AlumnoModelo modeloAlumno;
    private RegistroVista vistaResgistro;
    private AlumnoDAO alumnoDAO;
                                    
    // para realizar las validaciones
    Validacion validar = new Validacion();
    
    public AlumnoControladorRegistro(AlumnoModelo modeloAlumno, RegistroVista vistaResgistro) {
        this.modeloAlumno = modeloAlumno;
        this.vistaResgistro = vistaResgistro;
        this.alumnoDAO = new AlumnoDAO();
    }
    
    // para ver si hay un apodo igual.
    public boolean verificarUnicidadApodo(String apodo) throws SQLException {
        // Llama al nuevo método DAO
        return alumnoDAO.verificarUnicidadApodoBD(apodo);
    }
    
    // para validar el inicio de sesion.
    public boolean verificarInicioSesion() {
        String apodoIngresado = vistaResgistro.getTxtapodo();

        try {
            // devuelve TRUE si el apodo ya existe en la bdt.
            boolean apodoEncontrado = verificarUnicidadApodo(apodoIngresado);

            if (apodoEncontrado) {
                JOptionPane.showMessageDialog(vistaResgistro,  
                    "BIENVENIDO.",
                    "INICIO: DISFRUTA>>>", JOptionPane.INFORMATION_MESSAGE); 
                return true;
            } else {
                JOptionPane.showMessageDialog(vistaResgistro,  
                    "Ups El Apodo no existe.",
                    "MENSAJE DE ERROR: APODO INEXISTENTE", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (java.sql.SQLException e) { 
            System.err.println("Error de BD durante el inicio de sesión: " + e.getMessage());
            JOptionPane.showMessageDialog(vistaResgistro,  
                "Error al verificar la base de datos. Verifique su conexion wifi.",
                "ERROR DE CONEXIÓN BDT", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            System.err.println("Error inesperado durante el inicio de sesion: " + e.getMessage());
            return false;
        }
    }
    
    // validar todos los datos.
    public boolean validarDatos() throws SQLException {
        
        // 1. Limpiar todos los mensajes de error en la vista al inicio
        vistaResgistro.limpiarErrorNombre(); 
        vistaResgistro.limpiarErrorApellido();
        vistaResgistro.limpiarErrorApodo();
        vistaResgistro.limpiarErrorFechaNacimiento();

        // Variable de estado global para rastrear si HAY algún error
        boolean hayErrores = false;

        // --- 1. Validacion de Nombre. ---
        int resultadoNombre = validar.validarCadena(vistaResgistro.getTxtnombre(),
                "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$", 3, 12);

        switch (resultadoNombre) {
            case 0:
                vistaResgistro.mostrarErrorNombre("El nombre no puede estar vacío.");
                hayErrores = true;
                break;
            case -2:
                vistaResgistro.mostrarErrorNombre("Longitud no válida (3 a 12 caracteres).");
                hayErrores = true;
                break;
            case -1:
                vistaResgistro.mostrarErrorNombre("Solo puede contener letras (no se permiten números ni caracteres especiales).");
                hayErrores = true;
                break;
        }

        // --- 2. Validacion de Apellido. ---
        int resultadoApellido = validar.validarCadena(vistaResgistro.getTxtapellido(),
                "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$", 3, 12);

        switch (resultadoApellido) {
            case 0:
                vistaResgistro.mostrarErrorApellido("No puede estar vacío ni contener solo espacios.");
                hayErrores = true;
                break;
            case -2:
                vistaResgistro.mostrarErrorApellido("Longitud no válida (3 a 12 caracteres).");
                hayErrores = true;
                break;
            case -1:
                vistaResgistro.mostrarErrorApellido("Solo puede contener letras.");
                hayErrores = true;
                break;
        }

        // --- 3. Validacion de Apodo (NomUsuario). ---
        int resultadoNomUsuario = validar.validarCadena(vistaResgistro.getTxtapodo(),
                "^[a-zA-Z0-9_]{4,15}$", 4, 15);

        if (resultadoNomUsuario != 1) {
            switch (resultadoNomUsuario) {
                case 0:
                    vistaResgistro.mostrarErrorApodo("No puede estar vacío.");
                    break;
                case -2:
                    vistaResgistro.mostrarErrorApodo("Longitud no válida (4 a 15 caracteres).");
                    break;
                case -1:
                    vistaResgistro.mostrarErrorApodo("Solo letras, números y guiones bajos (_).");
                    break;
            }
            hayErrores = true;
        } else {
            // El formato y longitud son correctos, ahora se valida unicidad.
            if (verificarUnicidadApodo(vistaResgistro.getTxtapodo())) {
                vistaResgistro.mostrarErrorApodo("El apodo ya existe, elija otro.");
                hayErrores = true;
            }
        }
        
        // --- 4. Validacion de Fecha de Nacimiento. ---
        int resultadoFechaNacimiento = validar.validarCadena(vistaResgistro.getTxtfechaNacimiento(),
                "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d{2})$", 10, 10);

        if (resultadoFechaNacimiento == 1) {
            int resultadoValidacionFecha = validar.validarFechaDeNacimiento(vistaResgistro.getTxtfechaNacimiento(), "dd/MM/yyyy");
            
            if (resultadoValidacionFecha == -1) {
                vistaResgistro.mostrarErrorFechaNacimiento("No es una fecha válida o es futura (dd/MM/yyyy).");
                hayErrores = true;
            }
        } else {
            switch (resultadoFechaNacimiento) {
                case 0:
                    vistaResgistro.mostrarErrorFechaNacimiento("No puede estar vacía.");
                    break;
                case -2:
                    vistaResgistro.mostrarErrorFechaNacimiento("Longitud no válida (dd/MM/yyyy).");
                    break;
                case -1:
                    vistaResgistro.mostrarErrorFechaNacimiento("El formato debe ser dd/MM/yyyy.");
                    break;
            }
            hayErrores = true;
        }

        // -----------------------------------------------------------------
        // --- 5. Lógica Final: Revisar si hay errores y actuar en consecuencia ---
        // -----------------------------------------------------------------
        
        if (hayErrores) {
            // Mostrar un mensaje general indicando que hay errores visibles
            JOptionPane.showMessageDialog(vistaResgistro,  
                    "Por favor, corrija los campos resaltados. Revise los errores debajo de cada casilla.", 
                    "️ ERRORES EN EL REGISTRO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            // Procede con el registro si no hay errores
            AlumnoModelo nuevoAlumno = new AlumnoModelo();
            nuevoAlumno.setNombre(vistaResgistro.getTxtnombre());
            nuevoAlumno.setApellido(vistaResgistro.getTxtapellido());
            nuevoAlumno.setApodo(vistaResgistro.getTxtapodo());  
            nuevoAlumno.setFechaNacimiento(vistaResgistro.getTxtfechaNacimiento());
            // Añadir otros campos (género, etc.) si son necesarios antes de insertar.

            // GUARDAMOS EL OBJETO EN LA BDT
            if (alumnoDAO.insertarAlumno(nuevoAlumno)) {
                JOptionPane.showMessageDialog(vistaResgistro,  
                            "¡Registro exitoso! El alumno fue guardado en la Base de Datos.",
                            "REGISTRO COMPLETADO", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                  JOptionPane.showMessageDialog(vistaResgistro,  
                                "ERROR al guardar sus datos. Revise su conexión.",
                                "FALLO DE BD", JOptionPane.ERROR_MESSAGE);
                  return false;
            }
        }
    }
}
