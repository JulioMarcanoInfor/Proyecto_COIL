/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.comunes;
import com.panaderiamatemagica.admin.controlador.RouterAdminControlador;
import com.panaderiamatemagica.admin.vista.AdminVista;
import com.panaderiamatemagica.autenticacion.controlador.RouterRolControlador;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionAdminVista;
import com.panaderiamatemagica.core.visual.PantallaPrincipalVista;
import com.panaderiamatemagica.core.visual.PantallaInicioVista;
import com.panaderiamatemagica.autenticacion.vista.PantallaAutenticacionVista;
import com.panaderiamatemagica.autenticacion.vista.SeleccionPanaderoVista;
import com.panaderiamatemagica.autenticacion.vista.SeleccionRolVista;
import com.panaderiamatemagica.juego.controlador.RouterDimensionControlador;
import com.panaderiamatemagica.juego.vista.EjercicioVista;
import com.panaderiamatemagica.juego.vista.ResultadoVista;
import com.panaderiamatemagica.juego.vista.SeleccionDimensionVista;
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
    private InicioSesionAdminVista pantallaInicioSesionAdmin;
    private SeleccionPanaderoVista pantallaSeleccionPanadero;
    private AdminVista pantallaAdmin;
    private SeleccionDimensionVista pantallaSeleccionDimension;
    private EjercicioVista pantallaEjercicio;
    private ResultadoVista pantallaResultado;
    private RouterAdminControlador routerAdmin;
    private RouterDimensionControlador routerDimension;
            
    public RouterControlador(){
        pantallaPrincipal = new PantallaPrincipalVista();
        routerRol = new RouterRolControlador(this);
        routerAdmin = new RouterAdminControlador(this);
        routerDimension = new RouterDimensionControlador(this);
        
        //Se crean instancias de diferentes JPanel, y se pasa de argumento 'this' 
        //porque eso pasa como argumento la clase actual(RouterControlador).
        pantallaInicio = new PantallaInicioVista(this);
        pantallaAutenticacion = routerRol.getPantallaAutenticacion();
        pantallaSeleccionRol = new SeleccionRolVista(this);
        pantallaInicioSesionAdmin = new InicioSesionAdminVista(this);
        pantallaSeleccionPanadero = new SeleccionPanaderoVista(this);
        pantallaAdmin = routerAdmin.getPantallaAdmin();
        pantallaSeleccionDimension = routerDimension.getSeleccionDimensionViste();
        pantallaEjercicio = new EjercicioVista(this);
        pantallaResultado = new ResultadoVista(this);
        inicializarPaneles();
        pantallaPrincipal.setVisible(true);
    }
    private void inicializarPaneles(){
        pantallaPrincipal.agregarPanel(pantallaInicio, "INICIO");
        pantallaPrincipal.agregarPanel(pantallaAutenticacion, "AUTENTICACION");
        pantallaPrincipal.agregarPanel(pantallaSeleccionRol, "ROL");
        pantallaPrincipal.agregarPanel(pantallaInicioSesionAdmin, "SESION ADMIN");
        pantallaPrincipal.agregarPanel(pantallaSeleccionPanadero, "PANADEROS");
        pantallaPrincipal.agregarPanel(pantallaAdmin, "ADMIN");
        pantallaPrincipal.agregarPanel(pantallaSeleccionDimension, "SELECCION DIMENSION");
        pantallaPrincipal.agregarPanel(pantallaEjercicio, "EJERCICIO");
        pantallaPrincipal.agregarPanel(pantallaResultado, "RESULTADO");
        
        
        
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
    public void mostrarInicioSesionAdminVista(){
        pantallaPrincipal.mostrarPanel("SESION ADMIN");
    }
    public void mostrarSeleccionPanaderoVista(){
        pantallaPrincipal.mostrarPanel("PANADEROS");
    }
    public void mostrarAdminVista(){
        pantallaPrincipal.mostrarPanel("ADMIN");
    }
    public void mostrarSeleccionDimensionVista(){
        pantallaPrincipal.mostrarPanel("SELECCION DIMENSION");
    }
    public void mostrarEjercicioVista(){
        pantallaPrincipal.mostrarPanel("EJERCICIO");
    }
    public void mostrarResultadoVista(){
        pantallaPrincipal.mostrarPanel("RESULTADO");
    }
}
