/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.core.controlador;
import com.panaderiamatemagica.autenticacion.controlador.RouterRolControlador;
import com.panaderiamatemagica.core.visual.PantallaPrincipalVista;
import com.panaderiamatemagica.core.visual.PantallaInicioVista;
import com.panaderiamatemagica.autenticacion.vista.PantallaAutenticacionVista;
import com.panaderiamatemagica.autenticacion.vista.SeleccionRolVista;
//
/**
 *
 * @author user
 */
public class RouterControlador {
    //Se crean instancias de las clases pantallas
    private PantallaPrincipalVista pantallaPrincipal;
    private PantallaInicioVista pantallaInicio;
    private PantallaAutenticacionVista pantallaAutenticacion;
    private SeleccionRolVista pantallaSeleccionRol;
    private RouterRolControlador routerRol;
    
    public RouterControlador(){
        pantallaPrincipal = new PantallaPrincipalVista();
        routerRol = new RouterRolControlador(this);
        
        //Se crean instancias de diferentes JPanel, y se pasa de argumento 'this' 
        //porque eso pasa como argumento la clase actual(RouterControlador).
        pantallaInicio = new PantallaInicioVista(this);
        pantallaAutenticacion = routerRol.getPantallaAutenticacion();
        pantallaSeleccionRol = new SeleccionRolVista(this);
        inicializarPaneles();
        pantallaPrincipal.setVisible(true);
    }
    private void inicializarPaneles(){
        pantallaPrincipal.agregarPanel(pantallaInicio, "INICIO");
        pantallaPrincipal.agregarPanel(pantallaAutenticacion, "AUTENTICACION");
        pantallaPrincipal.agregarPanel(pantallaSeleccionRol, "ROL");
        
        pantallaPrincipal.mostrarPanel("INICIO");
    }
     public void mostrarInicioVista() {
        pantallaPrincipal.mostrarPanel("INICIO");
    }
    
    public void mostrarAutenticacionVista() {
        pantallaPrincipal.mostrarPanel("AUTENTICACION");
    }
    public void mostrarSeleccionRolVista() {
        pantallaPrincipal.mostrarPanel("ROL");
}
}
