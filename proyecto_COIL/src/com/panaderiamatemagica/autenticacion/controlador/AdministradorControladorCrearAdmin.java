/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controlador;

import com.panaderiamatemagica.admin.vista.CrearNuevoAdminVista;
import com.panaderiamatemagica.autenticacion.modelo.AdministradorModelo;
import com.panaderiamatemagica.comunes.Validacion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.validation.Validator;

/**
 *
 * @author Equipo Dell
 */
public class AdministradorControladorCrearAdmin {
    private   CrearNuevoAdminVista vista;
    private  ArrayList<AdministradorModelo> listaAdministradores; //se le pasa la global

    //constructor.
    public AdministradorControladorCrearAdmin(CrearNuevoAdminVista vista, ArrayList<AdministradorModelo> listaAdministradores) {
        this.vista = vista;
        this.listaAdministradores = listaAdministradores;
    }
    
    //para las validaciones genericas
    Validacion validar = new Validacion();
    
    public boolean validarParamentros(){
        // --- 1. Validacion de nombre usuario. ---
        int resultadoNombre = validar.validarCadena(vista.getTxtusuario(),
                "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$", 3, 12);
        
        switch (resultadoNombre) {
            case 0:
                // Error de contenido minimo (solo espacios o vacio)
                JOptionPane.showMessageDialog(vista, 
                        "Ups El Nombre no puede estar vacío ni contener solo espacios.",
                        "MENSAJE DE ERROR: CAMPO VACÍO", JOptionPane.ERROR_MESSAGE);
                return false; // Detiene la ejecucion al encontrar el primer error
                
            case -2:
                // Error de longitud
                JOptionPane.showMessageDialog(vista, 
                        "Ups La longitud del Nombre no es válida. Debe tener entre 3 y 12 caracteres.",
                        "MENSAJE DE ERROR: LONGITUD NO VÁLIDA", JOptionPane.ERROR_MESSAGE);
                return false; 
                
            case -1:
                // Error de patron/formato
                JOptionPane.showMessageDialog(vista, 
                        "Ups El Nombre solo puede contener letras.",
                        "MENSAJE DE ERROR: FORMATO INCORRECTO", JOptionPane.ERROR_MESSAGE);
                return false; 
                
            case 1:
                // es corecto el nombre y no retornmos.
                break;
               
        }

        // --- 2. Vaidacion de contraseña. ---
        int resultadoContrasenna = validar.validarCadena(vista.getTxtcontrasenna(),
                "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$", 5, 12);

        switch (resultadoContrasenna) {
            case 0:
                // Error de contenido minimo (solo espacios o vacio)
                JOptionPane.showMessageDialog(vista, 
                        "Ups La contraseña no puede estar vacia ni contener solo espacios.",
                        "MENSAJE DE ERROR: CAMPO VACIO", JOptionPane.ERROR_MESSAGE);
                return false;
                
            case -2:
                // Error de longitud
                JOptionPane.showMessageDialog(vista, 
                        "Ups La longitud de la Contraseña no es valida. Debe tener entre 5 y 12 caracteres.",
                        "MENSAJE DE ERROR: LONGITUD NO VÁLIDA", JOptionPane.ERROR_MESSAGE);
                return false;
                
            case -1:
                // Error de patron/formato
                JOptionPane.showMessageDialog(vista, 
                        "Ups La contraseña solo puede contener letras.",
                        "MENSAJE DE ERROR: FORMATO INCORRECTO", JOptionPane.ERROR_MESSAGE);
                return false;
                
            case 1:
                // esta correcto
                break;
        }
        //si llega aqui es porque todo esta correcto
        return true;
    }
    
    public void crearAdministrador(){
        if (!validarParamentros()) {
            // si ls parametros son errados 
            return; 
        }
        
        // Usar la lista para la validacion:
        for (AdministradorModelo admin : listaAdministradores  ) {
            if (admin.getContraseña().equals(vista.getTxtcontrasenna()) && admin.getNombreUsuario().equals(vista.getTxtusuario())) {
                // Si el usuario y la contraseña coinsiden pasa..
                JOptionPane.showMessageDialog(vista, 
                    "Los datos que coloco ya estan registrados.",
                    "MENSAJE DE ERROR: DATOS EXISTENTES..", JOptionPane.ERROR_MESSAGE);
                return; 
            }
        }
        AdministradorModelo nuevo = new AdministradorModelo();
        //agregamos los datos
        nuevo.setContraseña(vista.getTxtcontrasenna());
        nuevo.setNombreUsuario(vista.getTxtusuario());
        // lo agregamos a la lista.
        listaAdministradores.add(nuevo);
        JOptionPane.showMessageDialog(vista, 
                        "EL NUEVO ADMIN SE AGREGO CORRECTAMENTE.",
                        "EXITOS:>>", JOptionPane.ERROR_MESSAGE);
        return;
    
    }
}
