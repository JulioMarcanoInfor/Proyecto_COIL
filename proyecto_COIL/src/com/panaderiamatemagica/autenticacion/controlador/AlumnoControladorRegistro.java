/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controlador;

import com.panaderiamatemagica.autenticacion.vista.RegistroVista;
import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import Utilidades.Validacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.panaderiamatemagica.core.dao.AlumnoDAO;
import java.sql.SQLException;

/**
 *
 * @author Equipo Dell
 */



public class AlumnoControladorRegistro {
    private AlumnoModelo modeloAlumno;
    private RegistroVista vistaResgistro;
    private AlumnoDAO alumnoDAO;
                                
    //PARA ALMACENAR LA LISTA GLOBAL RECIBIDA
    //private ArrayList<AlumnoModelo> listaAlumnos;
    // eliminamos esta vaina jaja.
    
    //constructor1.
    public AlumnoControladorRegistro(AlumnoModelo modeloAlumno, RegistroVista vistaResgistro) {
            this.modeloAlumno = modeloAlumno;
            this.vistaResgistro = vistaResgistro;
            this.alumnoDAO = new AlumnoDAO();
        }
    
    
    
    //para realizar las validaciones
    Validacion validar = new Validacion();
    
    
    //para ver si hay un apodo igual.
    public boolean verificarUnicidadApodo(String apodo) throws SQLException {
        // Llama al nuevo método DAO
        return alumnoDAO.verificarUnicidadApodoBD(apodo);
    }
    
    //para validar el inicio de sesion.
    public boolean verificarInicioSesion(){
    String apodoIngresado = vistaResgistro.getTxtapodo();

    try {
        //devuelve TRUE si el apodo ya existe en la bdt.
        boolean apodoEncontrado = verificarUnicidadApodo(apodoIngresado);

        if (apodoEncontrado) {
            // El apodo existe, el inicio de sesion es exitoso.
            JOptionPane.showMessageDialog(vistaResgistro,  
                "BIENVENIDO.",
                "INICIO: DISFRUTA>>>", JOptionPane.INFORMATION_MESSAGE); 
            return true;
        } else {
            // El apodo NO existe.
            JOptionPane.showMessageDialog(vistaResgistro,  
                "Ups El Apodo no existe.",
                "MENSAJE DE ERROR: APODO INEXISTENTE", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        } catch (java.sql.SQLException e) { 
            // 🚨 CAPTURA ERRORES ESPECÍFICOS DE LA BASE DE DATOS (Conexion, consulta, etc.)
            System.err.println("Error de BD durante el inicio de sesión: " + e.getMessage());
            JOptionPane.showMessageDialog(vistaResgistro,  
                "Error al verificar la base de datos. Verifique su conexion wifi.",
                "ERROR DE CONEXIÓN BDT", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception e) {
            // Capturamos cualquier otra excepción
            System.err.println("Error inesperado durante el inicio de sesion: " + e.getMessage());
            return false;
        }
    }
    
    //validar todos los datos.
    public boolean validarDatos() throws SQLException{
    // String que acumulará todos los mensajes de error.
    String mensajesError = "";
    
    // Variables de estado (opcionales, pero útiles para la lógica de negocio final)
    boolean boolNombre = false;
    boolean boolApellido = false;
    boolean boolNomUsuario = false;
    boolean boolFechaNacimiento = false;
    
    // --- 1. Validacion de Nombre. ---
    int resultadoNombre = validar.validarCadena(vistaResgistro.getTxtnombre(),
            "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$", 3, 12);
    
    switch (resultadoNombre) {
        case 0:
            mensajesError += "• Nombre: el nombre no puede estar vacio ni solo contener espacios :(\n";
            break;
        case -2:
            mensajesError += "• Nombre: la longitud del nombre no es valida, debe tener entre 3 y 12 caracteres :(\n";
            break;
        case -1:
            mensajesError += "• Nombre: solo puede contener letras :(\n";
            break;
        case 1:
            boolNombre = true;
            break;
    }

    // --- 2. Validacion de Apellido. ---
    int resultadoApellido = validar.validarCadena(vistaResgistro.getTxtapellido(),
            "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$", 3, 12);

    switch (resultadoApellido) {
        case 0:
            mensajesError += "• Apellido: No puede estar vacio ni contener solo espacios :( \n";
            break;
        case -2:
            mensajesError += "• Apellido: la longitud del nombre no es valida, debe tener entre 3 y 12 caracteres :( \n";
            break;
        case -1:
            mensajesError += "• Apellido: solo puede contener letras :(\n";
            break;
        case 1:
            boolApellido = true;
            break;
    }

    // --- 3. Validacion de Apodo (NomUsuario). ---
    int resultadoNomUsuario = validar.validarCadena(vistaResgistro.getTxtapodo(),
            "^[a-zA-Z0-9_]{4,15}$", 4, 15);

    switch (resultadoNomUsuario) {
        case 0:
            mensajesError += "• Apodo: No puede estar vacío ni contener solo espacios.\n";
            break;
        case -2:
            mensajesError += "• Apodo: la longitud del nombre no es valida, debe tener entre 3 y 12 caracteres :(\n";
            break;
        case -1:
            mensajesError += "• Apodo: Solo letras, números y guiones bajos (_) \n";
            break;
        case 1:
            // El formato y longitud son correctos, ahora se valida unicidad.
            if (verificarUnicidadApodo(vistaResgistro.getTxtapodo())) {
                mensajesError += "• Apodo: El apodo ya existe, debe cambiarlo a otro no existente \n";
            } else {
                boolNomUsuario = true;
            }
            break;
    }
    
    // --- 4. Validacion de Fecha de Nacimiento. ---
    int resultadoFechaNacimiento = validar.validarCadena(vistaResgistro.getTxtfechaNacimiento(),
            "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d{2})$", 10, 10);

    if (resultadoFechaNacimiento == 1) {
        int resultadoValidacionFecha = validar.validarFechaDeNacimiento(vistaResgistro.getTxtfechaNacimiento(), "dd/MM/yyyy");
        
        if (resultadoValidacionFecha == 1) {
            boolFechaNacimiento = true;
        } else if (resultadoValidacionFecha == -1) {
            // Error: Fecha inválida (ej. 30/02/2000) o Fecha futura.
            mensajesError += "• Fecha de Nacimiento: No es una fecha valida o es futura, use el formato dd/MM/yyyy \n";
        }
    } else {
        // Manejar errores de formato/longitud de la cadena de fecha
        switch (resultadoFechaNacimiento) {
            case 0:
                mensajesError += "• Fecha de Nacimiento: No puede estar vacia \n";
                break;
            case -2:
                mensajesError += "• Fecha de Nacimiento: Longitud no valida, use el formato dd/MM/yyyy\n";
                break;
            case -1:
                mensajesError += "• Fecha de Nacimiento: El formato no es valido, debe ser dd/MM/yyyy\n";
                break;
        }
    }
    
    // -----------------------------------------------------------------
    // --- 5. Lógica Final: Revisar si hay errores y actuar en consecuencia ---
    // -----------------------------------------------------------------
    
    if (mensajesError.isEmpty()) {

        // 1. Crear la instancia del nuevo objeto Alumno
        AlumnoModelo nuevoAlumno = new AlumnoModelo();

        // 2. Obtener los datos validados de la vista y asignarlos al objeto
        nuevoAlumno.setNombre(vistaResgistro.getTxtnombre());
        nuevoAlumno.setApellido(vistaResgistro.getTxtapellido());
        nuevoAlumno.setApodo(vistaResgistro.getTxtapodo());  
        nuevoAlumno.setFechaNacimiento(vistaResgistro.getTxtfechaNacimiento());
        // nuevoAlumno.setGenero("O"); // hay que ponerlo.
        // lo demos...

        // 3. GUARDAMOs EL OBJETO EN LA BDT
        if (alumnoDAO.insertarAlumno(nuevoAlumno)) {
            JOptionPane.showMessageDialog(vistaResgistro,  
                            "¡Registro exitoso! El alumno fue guardado en la Base de Datos.",
                            "REGISTRO COMPLETADO", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
             JOptionPane.showMessageDialog(vistaResgistro,  
                            "ERROR al guardar sus datos. Revise su coneccion wifi.",
                            "FALLO DE BD", JOptionPane.ERROR_MESSAGE);
             return false;
        }
        } else {
            // ... (Mensaje de errores de validación)
            JOptionPane.showMessageDialog(vistaResgistro,  
                            "<html><body style='width: 300px;'><b>Se encontraron los siguientes errores:</b><br>"
                            + "<span style='color:red;'>" + mensajesError.replaceAll("\n", "<br>") + "</span>"
                            + "</body></html>", 
                            "️ ERRORES EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
