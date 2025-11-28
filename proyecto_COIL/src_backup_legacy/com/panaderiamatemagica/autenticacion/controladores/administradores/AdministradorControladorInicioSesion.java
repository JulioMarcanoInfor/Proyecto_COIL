/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controladores.administradores;

import com.panaderiamatemagica.autenticacion.modelo.AdministradorModelo;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionAdminVista;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.panaderiamatemagica.core.dao.AdministradorDAO;

/**
 *
 * @author Equipo Dell
 */
public class AdministradorControladorInicioSesion {
    private InicioSesionAdminVista vista;
        // La lista ya no es necesaria
        // private ArrayList<AdministradorModelo> listaAdministradores; 

        // 1. Instancia del DAO para interactuar con la BDT
        private AdministradorDAO adminDAO; 

        // Constructor 
        public AdministradorControladorInicioSesion(InicioSesionAdminVista vista, ArrayList<AdministradorModelo> listaAdministradores) {
            this.vista = vista;
            // 2. Inicializar el DAO
            this.adminDAO = new AdministradorDAO();
            // La lista ya no se utiliza
            // this.listaAdministradores = listaAdministradores; 
        }
    
    //validacion de inicio de sesion
    public boolean validarInicioSesion(){
       // 1. Obtener datos de la Vista
       String usuario = vista.getTxtusuarioProfesor();
       String contrasena = vista.getTxtcontrasenna();

       // 2. Llamar al DAO para autenticar en la BDT
       // El metodo DAO devuelve un objeto AdministradorModelo si las credenciales son correctas, o null si falla.
       AdministradorModelo adminAutenticado = adminDAO.autenticarAdministrador(usuario, contrasena);

       if (adminAutenticado != null) {
           // Autenticación exitosa
           JOptionPane.showMessageDialog(vista,  
               "Bienvenido: " + adminAutenticado.getNombreUsuario(), 
               "que disfrutes>>.", JOptionPane.INFORMATION_MESSAGE);


           return true; 
       } else {
           // Autenticacion fallida
           JOptionPane.showMessageDialog(vista, 
               "Usuario o Contraseña incorrectos.",
               "MENSAJE DE ERROR: ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
           return false;
       }
   }
}
