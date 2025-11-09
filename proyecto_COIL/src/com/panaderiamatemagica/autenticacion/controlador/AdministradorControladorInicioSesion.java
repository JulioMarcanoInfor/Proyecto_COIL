/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controlador;

import com.panaderiamatemagica.autenticacion.modelo.AdministradorModelo;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionAdminVista;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo Dell
 */
public class AdministradorControladorInicioSesion {
    private  InicioSesionAdminVista vista;
    private  ArrayList<AdministradorModelo> listaAdministradores; //se le pasa la global

    //constructor.
    public AdministradorControladorInicioSesion(InicioSesionAdminVista vista, ArrayList<AdministradorModelo> listaAdministradores) {
        this.vista = vista;
        this.listaAdministradores = listaAdministradores;
    }
    
    //validacion de inicio de sesion
    public boolean validarInicioSesion(){
        // Usar la lista para la validacion:
        for (AdministradorModelo admin : listaAdministradores  ) {
            if (admin.getContraseña().equals(vista.getTxtcontrasenna()) && admin.getNombreUsuario().equals(vista.getTxtusuarioProfesor())) {
                // Si el usuario y la contraseña coinsiden pasa..
                JOptionPane.showMessageDialog(vista, 
                    "que disfrutes>>.",
                    "Bienvenido: ..", JOptionPane.ERROR_MESSAGE);
                return true; 
            }
        }
        JOptionPane.showMessageDialog(vista, 
                        "La cuenta no existe.",
                        "MENSAJE DE ERROR: MENSAJE INEXISTENTE", JOptionPane.ERROR_MESSAGE);
        return false;
    
    }
    
    public void crearAdministrador(){
        // Usar la lista para la validacion:
        for (AdministradorModelo admin : listaAdministradores  ) {
            if (admin.getContraseña().equals(vista.getTxtcontrasenna()) && admin.getNombreUsuario().equals(vista.getTxtusuarioProfesor())) {
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
        nuevo.setNombreUsuario(vista.getTxtusuarioProfesor());
        // lo agregamos a la lista.
        listaAdministradores.add(nuevo);
        JOptionPane.showMessageDialog(vista, 
                        "EL NUEVO ADMIN SE AGREGO CORRECTAMENTE.",
                        "EXITOS:>>", JOptionPane.ERROR_MESSAGE);
        return;
    
    }
    
}
