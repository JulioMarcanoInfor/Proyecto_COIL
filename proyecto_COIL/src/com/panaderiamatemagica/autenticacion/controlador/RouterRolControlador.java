/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controlador;

import com.panaderiamatema.core.controlador.RouterControlador;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionVista;
import com.panaderiamatemagica.autenticacion.vista.PantallaAutenticacionVista;
import com.panaderiamatemagica.autenticacion.vista.RegistroVista;

/**
 *
 * @author user
 */
public class RouterRolControlador {
    private PantallaAutenticacionVista pantallaAutenticacion;
    private RegistroVista registro;
    private InicioSesionVista inicioSesion;
    private RouterControlador router;
    
    public RouterRolControlador(RouterControlador router){
        this.router = router;
        pantallaAutenticacion = new PantallaAutenticacionVista(router, this);
        registro = new RegistroVista(router);
        inicioSesion = new InicioSesionVista(router);
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

// ver
