/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controlador;

import com.panaderiamatemagica.autenticacion.vista.RegistroVista;
import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import com.panaderiamatemagica.comunes.Validacion;
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
                "INICIO: DISFRUTA>>>", JOptionPane.ERROR_MESSAGE);
            return true;
        }else{
            // Error de contenido minimo (solo espacios o vacio)
            JOptionPane.showMessageDialog(vistaResgistro, 
                    "El Apodo no existe.",
                    "MENSAJE DE ERROR: APODO INEXISTENTE", JOptionPane.ERROR_MESSAGE);
            return false;                    
        }
    }
    
    //validar todos los datos.
    public boolean validarDatos(){
        //variables para verificar que todo este correcto
        boolean boolNombre = false;
        boolean boolApellido = false;
        boolean boolNomUsuario = false;
        boolean boolFechaNacimiento = false;
        
        // --- 1. Validacion de Nombre. ---
        int resultadoNombre = validar.validarCadena(vistaResgistro.getTxtnombre(),
                "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$", 3, 12);
        
        switch (resultadoNombre) {
            case 0:
                // Error de contenido minimo (solo espacios o vacio)
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "El Nombre no puede estar vacio ni contener solo espacios.",
                        "MENSAJE DE ERROR: CAMPO VACIO", JOptionPane.ERROR_MESSAGE);
                boolNombre = false;
                return false; // Detiene la ejecucion al encontrar el primer error
                
            case -2:
                // Error de longitud (Se ejecuta antes que la de Patron en validarCadena)
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "La longitud del Nombre no es valida. Debe tener entre 3 y 12 caracteres.",
                        "MENSAJE DE ERROR: LONGITUD", JOptionPane.ERROR_MESSAGE);
                boolNombre = false;
                return false; 
                
            case -1:
                // Error de patron/formato (Captura numeros y simbolos no permitidos)
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "El Nombre solo puede contener letras.",
                        "MENSAJE DE ERROR: FORMATO", JOptionPane.ERROR_MESSAGE);
                boolNombre = false;
                return false; 
                
            case 1:
                // El campo Nombre es correcto.
                boolNombre = true; 
                break;
                
            // aqui se implemneta las validaciones de los otros campos.
        }

        // --- 2. Validacion de Apellido. ---
        int resultadoApellido = validar.validarCadena(vistaResgistro.getTxtapellido(),
                "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$", 3, 12);

        switch (resultadoApellido) {
            case 0:
                // Error de contenido minimo (solo espacios o vacio)
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "El Apellido no puede estar vacio ni contener solo espacios.",
                        "MENSAJE DE ERROR: CAMPO VACIO", JOptionPane.ERROR_MESSAGE);
                boolApellido = false;
                return false;
                
            case -2:
                // Error de longitud
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "La longitud del Apellido no es valida. Debe tener entre 3 y 12 caracteres.",
                        "MENSAJE DE ERROR: LONGITUD", JOptionPane.ERROR_MESSAGE);
                boolApellido = false;
                return false;
                
            case -1:
                // Error de patron/formato
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "El Apellido solo puede contener letras.",
                        "MENSAJE DE ERROR: FORMATO", JOptionPane.ERROR_MESSAGE);
                boolApellido = false;
                return false;
                
            case 1:
                // El campo Apellido es correcto.
                boolApellido = true;
                break;
        }

        // --- 3. Validacion de Apodo (NomUsuario). ---
        // Se asume un patrón para Apodo: letras, números y guion bajo (_). Longitud: 4 a 15.
        int resultadoNomUsuario = validar.validarCadena(vistaResgistro.getTxtapodo(),
                "^[a-zA-Z0-9_]{4,15}$", 4, 15);

        switch (resultadoNomUsuario) {
            case 0:
                // Error de contenido minimo (solo espacios o vacio)
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "El Apodo (Nombre de Usuario) no puede estar vacio ni contener solo espacios.",
                        "MENSAJE DE ERROR: CAMPO VACIO", JOptionPane.ERROR_MESSAGE);
                boolNomUsuario = false;
                return false;
                
            case -2:
                // Error de longitud
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "La longitud del Apodo no es valida. Debe tener entre 4 y 15 caracteres.",
                        "MENSAJE DE ERROR: LONGITUD", JOptionPane.ERROR_MESSAGE);
                boolNomUsuario = false;
                return false;
                
            case -1:
                // Error de patron/formato
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "El Apodo solo puede contener letras, números y guiones bajos (_).",
                        "MENSAJE DE ERROR: FORMATO", JOptionPane.ERROR_MESSAGE);
                boolNomUsuario = false;
                return false;
                
            case 1:
                // El campo Apodo es correcto.
                // pero ahora validamso si se repite.
                if (verificarUnicidadApodo(vistaResgistro.getTxtapodo())) {
                    // Error: el apodo se repite.
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "El apodo ya existe, debe cambiarlo.",
                        "MENSAJE DE ERROR: APODO REPETIDO", JOptionPane.ERROR_MESSAGE);
                    return false;
                }else{
                    boolNomUsuario = true;
                    break;
                }
        }
        
        // --- 4. Validacion de Fecha de Nacimiento. ---
        // Se asume un patron de fecha dd/MM/yyyy.
        int resultadoFechaNacimiento = validar.validarCadena(vistaResgistro.getTxtfechaNacimiento(),
                "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d{2})$", 10, 10);

        switch (resultadoFechaNacimiento) {
            case 0:
                // Error de contenido minimo (solo espacios o vacio)
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "La Fecha de Nacimiento no puede estar vacia.",
                        "MENSAJE DE ERROR: CAMPO VACIO", JOptionPane.ERROR_MESSAGE);
                boolFechaNacimiento = false;
                return false;
                
            case -2:
                // Error de longitud
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "La longitud de la Fecha de Nacimiento no es valida. Use el formato dd/MM/yyyy.",
                        "MENSAJE DE ERROR: LONGITUD", JOptionPane.ERROR_MESSAGE);
                boolFechaNacimiento = false;
                return false;
                
            case -1:
                // Error de patron/formato
                JOptionPane.showMessageDialog(vistaResgistro, 
                        "El formato de la Fecha de Nacimiento no es válido. Use el formato dd/MM/yyyy.",
                        "MENSAJE DE ERROR: FORMATO", JOptionPane.ERROR_MESSAGE);
                boolFechaNacimiento = false;
                return false;
                
            case 1:
                // El campo Fecha de Nacimiento es correcto.
                boolFechaNacimiento = true;
                break;
        }
        
        // --- 5. Logica Final (Ejecutar Accion si Todo es Válido) ---
        if (boolNombre && boolApellido && boolNomUsuario && boolFechaNacimiento) {
            // Todos los campos son válidos. Aquí iría la lógica para guardar el Alumno.
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
        }else{
        //no pasa en teoria 
        JOptionPane.showMessageDialog(vistaResgistro, 
                        "¡Registro rarooo! paso todo y tiene cosas malas.",
                        "REGISTRO NO COMPLETO", JOptionPane.INFORMATION_MESSAGE);
        return false;      
        }
    }
}
