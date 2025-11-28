/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controladores.alumnos;

import com.panaderiamatemagica.autenticacion.vista.FondoAutenticacionVista;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionVista;
import com.panaderiamatemagica.autenticacion.vista.SeleccionRolVista;
import com.panaderiamatemagica.core.RouterControlador;

/**
 *
 * @author User
 */
public class RouterAutenticacionControlador {
    
    
    private SeleccionRolVista pantallaSeleccionRol;
    private RouterControlador router;
    private FondoAutenticacionVista fondoAutenticacion;
    private InicioSesionVista pantallaInicioSesion;
    
    
    public RouterAutenticacionControlador(RouterControlador router){
        
        this.router = router;
        
        pantallaSeleccionRol = new SeleccionRolVista(router, this);
        fondoAutenticacion = new FondoAutenticacionVista(router);
        pantallaInicioSesion = new InicioSesionVista(router, this);
        inicializarPaneles();
        
    }
    
    
    private void inicializarPaneles(){
        fondoAutenticacion.agregarPanel(pantallaSeleccionRol, "SELECCION ROL");
        fondoAutenticacion.agregarPanel(pantallaInicioSesion, "INICIAR SESION");
        fondoAutenticacion.mostrarPanel("SELECCION ROL");
    }
    public void mostrarSeleccionRol(){
        fondoAutenticacion.mostrarPanel("SELECCION ROL");
    }
    public void mostrarIniciarSesion(){
        fondoAutenticacion.mostrarPanel("INICIAR SESION");
    }
    public FondoAutenticacionVista getFondoAutenticacion(){
        return fondoAutenticacion;
    }
    public InicioSesionVista getInicioSesion(){
        return pantallaInicioSesion;
    }
}
