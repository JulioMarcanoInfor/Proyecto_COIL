/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controladores.alumnos;

import com.panaderiamatemagica.autenticacion.vista.FondoAutenticacionVista;
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
    
    
    public RouterAutenticacionControlador(RouterControlador router){
        
        this.router = router;
        
        pantallaSeleccionRol = new SeleccionRolVista(router, this);
        fondoAutenticacion = new FondoAutenticacionVista(router);
        
        inicializarPaneles();
        
    }
    
    
    private void inicializarPaneles(){
        fondoAutenticacion.agregarPanel(pantallaSeleccionRol, "SELECCION ROL");
        fondoAutenticacion.mostrarPanel("SELECCION ROL");
    }
    public void mostrarSeleccionRol(){
        fondoAutenticacion.mostrarPanel("SELECCION ROL");
    }
    public FondoAutenticacionVista getFondoAutenticacion(){
        return fondoAutenticacion;
    }
}
