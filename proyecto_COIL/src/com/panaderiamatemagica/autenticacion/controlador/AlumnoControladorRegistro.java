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

/**
 *
 * @author Equipo Dell
 */



public class AlumnoControladorRegistro {
    private AlumnoModelo modeloAlumno;
    private RegistroVista vistaResgistro;
                                
    //PARA ALMACENAR LA LISTA GLOBAL RECIBIDA
    private ArrayList<AlumnoModelo> listaAlumnos;
    
    //constructor1.
    public AlumnoControladorRegistro(AlumnoModelo modeloAlumno, RegistroVista vistaResgistro,
            ArrayList<AlumnoModelo> listaGlobal) {//le pasamos la lista global
        this.modeloAlumno = modeloAlumno;
        this.vistaResgistro = vistaResgistro;
        this.listaAlumnos = listaGlobal;
    }
    
    
    
    //para realizar las validaciones
    Validacion validar = new Validacion();
    
    
    //para ver si hay un apodo igual
    public boolean verificarUnicidadApodo(String apodo) {
        // Recorre todos los alumnos registrados
        for (AlumnoModelo alumno : listaAlumnos) {
            // Compara el apodo ingresado (ignorando mayúsculas/minúsculas)
            if (alumno.getApodo().equalsIgnoreCase(apodo)) {
                return true; // El apodo ya existe
            }
        }
        return false; // El apodo es único
    }
    
    //para validar el inicio de sesion.
    public boolean verificarInicioSesion(){
        //utilizamos la funcio verificarUnicidadApodo()
        // ya que si el apodo existe tiene que estar en la lista.
        if (verificarUnicidadApodo(vistaResgistro.getTxtapodo())) {
            // si esta el nombre de usuario
            JOptionPane.showMessageDialog(vistaResgistro, 
                "BIENVENIDO.",
                "INICIO: DISFRUTA>>>", JOptionPane.INFORMATION_MESSAGE); // Cambiado a INFORMATION para no usar ERROR
            return true;
        }else{
            // Mensaje de error ajustado.
            JOptionPane.showMessageDialog(vistaResgistro, 
                    "Ups El Apodo no existe.",
                    "MENSAJE DE ERROR: APODO INEXISTENTE", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    //validar todos los datos.
    public boolean validarDatos(){
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
        // Todos los campos son válidos. Aquí iría la logica para guardar el Alumno
        JOptionPane.showMessageDialog(vistaResgistro, 
                    "¡Registro exitoso! Todos los datos son válidos.",
                    "REGISTRO COMPLETADO", JOptionPane.INFORMATION_MESSAGE);
        
        // 1. Crear la instancia del nuevo objeto Alumno
        AlumnoModelo nuevoAlumno = new AlumnoModelo();
        // 2. Obtener los datos validados de la vista y asignarlos al objeto
        nuevoAlumno.setNombre(vistaResgistro.getTxtnombre());
        nuevoAlumno.setApellido(vistaResgistro.getTxtapellido());
        nuevoAlumno.setApodo(vistaResgistro.getTxtapodo()); 
        nuevoAlumno.setFechaNacimiento(vistaResgistro.getTxtfechaNacimiento());
        // 3. Guardar el objeto en la lista
        listaAlumnos.add(nuevoAlumno);
        
        return true;
    } else {
        // Se encontraron errores. Mostrar el mensaje acumulado en rojo (ERROR_MESSAGE).
        // Se utiliza HTML básico para un formato mejor, pero el color rojo del icono
        // ya lo da el JOptionPane.ERROR_MESSAGE.
        JOptionPane.showMessageDialog(vistaResgistro, 
                    "<html><body style='width: 300px;'><b>Se encontraron los siguientes errores:</b><br>"
                    + "<span style='color:red;'>" + mensajesError.replaceAll("\n", "<br>") + "</span>"
                    + "</body></html>", 
                    "️ ERRORES EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
}
