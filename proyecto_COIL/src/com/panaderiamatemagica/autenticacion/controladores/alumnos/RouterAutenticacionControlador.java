/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.controladores.alumnos;

import com.panaderiamatemagica.autenticacion.vista.FondoAutenticacionVista;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionAdminVista;
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
    private InicioSesionAdminVista pantallaInicioAdmin;

    public RouterAutenticacionControlador(RouterControlador router) {
        this.router = router;

        pantallaSeleccionRol = new SeleccionRolVista(router, this);
        fondoAutenticacion = new FondoAutenticacionVista(router, this);
        pantallaInicioSesion = new InicioSesionVista(router, this);
        pantallaInicioAdmin = new InicioSesionAdminVista(router);
        
        fondoAutenticacion.agregarPanel(pantallaInicioAdmin, "INICIO ADMIN");
    }

    public void mostrarSeleccionRol() {
        fondoAutenticacion.mostrarSeleccionRol();
    }
    public void mostrarInicioSesionAdminVista(){
        fondoAutenticacion.mostrarPanel("INICIO ADMIN");
    }

    public void mostrarIniciarSesion() {
        fondoAutenticacion.mostrarIniciarSesion();
    }

    public void mostrarRegistro() {
        fondoAutenticacion.mostrarRegistro();
    }

    public FondoAutenticacionVista getFondoAutenticacion() {
        return fondoAutenticacion;
    }
    public void mostrarRecuperarContraseñaVista(){
        fondoAutenticacion.mostrarPanel("RECUPERAR");
    }

    public InicioSesionVista getInicioSesion() {
        return pantallaInicioSesion;
    }

    public void limpiarTextFieldInicioSesion() {
        pantallaInicioSesion.vaciarTextField();
    }
}
