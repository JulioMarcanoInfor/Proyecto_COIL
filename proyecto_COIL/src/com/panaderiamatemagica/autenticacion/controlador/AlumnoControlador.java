/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controlador;

import com.panaderiamatemagica.autenticacion.vista.RegistroVista;
import com.panaderiamatemagica.modelos.AlumnoModelo;
import com.panaderiamatemagica.modelos.ValidacionesGenericas;

/**
 *
 * @author Equipo Dell
 */
public class AlumnoControlador {
    private AlumnoModelo modeloAlumno;
    private RegistroVista vistaResgistro;
    private boolean correcto = false; // si todos los campos estan corectos sera true.
                                      // se usara para implementra la loica de verificacion final.
                                     

    //constructor1.
    public AlumnoControlador(AlumnoModelo modeloAlumno, RegistroVista vistaResgistro) {
        this.modeloAlumno = modeloAlumno;
        this.vistaResgistro = vistaResgistro;
    }
    
    
    //para realizar las validaciones
    ValidacionesGenericas validar = new ValidacionesGenericas();
    
    public void validarDatos(){
        if (validar.validarCadena(vistaResgistro.getName(),"^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$", 3, 12) == 0) {
            //  Error: Solo contenia espacios en blanco.
        } else if (validar.validarCadena(vistaResgistro.getName(),"^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$", 3, 12) == -1) {
            // Error: No cumple con el patron (formato).
        } else if (validar.validarCadena(vistaResgistro.getName(),"^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$", 3, 12) == -2) {
            //Error: La longitud esta fuera de los limites.
        }else{
            // esta correcto el nombre
        }
        // hacerlo con las demas o implementar un || (or) en el if y que quede super largo jajaja
        // por separado podemos mostrar el error en especifico
        // junto se dari el mensaje de error general pero el usuario no 
        // sabe cual campo espesficamnete tine el error.
    }
    
    
    
}
