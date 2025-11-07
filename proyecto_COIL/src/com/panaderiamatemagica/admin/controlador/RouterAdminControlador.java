/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.admin.controlador;

import com.panaderiamatemagica.admin.vista.AdminVista;
import com.panaderiamatemagica.admin.vista.AdministracionCuentasVista;
import com.panaderiamatemagica.admin.vista.CrearNuevoAdminVIsta;
import com.panaderiamatemagica.admin.vista.CrearNuevoNivelVista;
import com.panaderiamatemagica.comunes.RouterControlador;

/**
 *
 * @author User
 */
public class RouterAdminControlador {
    private AdminVista pantallaAdmin;
    private AdministracionCuentasVista pantallaAdministracionCuentas;
    private CrearNuevoAdminVIsta pantallaCrearNuevoAdmin;
    private CrearNuevoNivelVista pantallaCrearNuevoNivel;
    private RouterControlador router;
    
    public RouterAdminControlador(RouterControlador router){
        this.router = router;
        pantallaAdmin = new AdminVista(router, this);
        registro = new RegistroVista(router);
        inicioSesion = new InicioSesionVista();
        inicializarPaneles();
        
    }
    private void inicializarPaneles(){
        pantallaAutenticacion.agregarPanel(registro, "REGISTRO");
        pantallaAutenticacion.agregarPanel(inicioSesion, "INICIAR SESION");
    }
    public void mostrarRegistrarseVista(){
        pantallaAutenticacion.mostrarPanel("REGISTRO");
    }
    public void mostrarIniciarSesionVista(){
        pantallaAutenticacion.mostrarPanel("INICIAR SESION");
    }
    public PantallaAutenticacionVista getPantallaAutenticacion() {
        return pantallaAutenticacion;
    }
}
