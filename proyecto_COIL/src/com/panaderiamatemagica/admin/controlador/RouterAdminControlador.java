/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.admin.controlador;

import com.panaderiamatemagica.admin.vista.AdminVista;
import com.panaderiamatemagica.admin.vista.AdministracionCuentasVista;
import com.panaderiamatemagica.admin.vista.CrearNuevoAdminVista;
import com.panaderiamatemagica.admin.vista.CrearNuevoNivelVista;
import com.panaderiamatemagica.admin.vista.InformeRapidoVista;
import com.panaderiamatemagica.admin.vista.ModificarNivelVista;
import com.panaderiamatemagica.comunes.RouterControlador;

/**
 *
 * @author User
 */
public class RouterAdminControlador {
    private AdminVista pantallaAdmin;
    private AdministracionCuentasVista pantallaAdministracionCuentas;
    private CrearNuevoAdminVista pantallaCrearNuevoAdmin;
    private CrearNuevoNivelVista pantallaCrearNuevoNivel;
    private InformeRapidoVista pantallaInformeRapido;
    private ModificarNivelVista pantallaModificarNivel;
    private RouterControlador router;
    
    public RouterAdminControlador(RouterControlador router){
        
        this.router = router;
        
        pantallaAdmin = new AdminVista(router, this);
        pantallaAdministracionCuentas = new AdministracionCuentasVista(this);
        pantallaCrearNuevoAdmin = new CrearNuevoAdminVista();
        pantallaCrearNuevoNivel = new CrearNuevoNivelVista();
        pantallaInformeRapido = new InformeRapidoVista();
        pantallaModificarNivel = new ModificarNivelVista();
        inicializarPaneles();
        
    }
    private void inicializarPaneles(){
        pantallaAdmin.agregarPanel(pantallaAdministracionCuentas, "ADMINISTRACION");
        pantallaAdmin.agregarPanel(pantallaCrearNuevoAdmin, "NUEVO ADMIN");
        pantallaAdmin.agregarPanel(pantallaCrearNuevoNivel, "NUEVO NIVEL");
        pantallaAdmin.agregarPanel(pantallaModificarNivel, "MODIFICAR NIVEL");
        pantallaAdmin.agregarPanel(pantallaInformeRapido, "INFORME RAPIDO");
    }
    public void mostrarAdministracionCuentasVista(){
        pantallaAdmin.mostrarPanel("ADMINISTRACION");
    }
    public void mostrarCrearNuevoAdminVista(){
        pantallaAdmin.mostrarPanel("NUEVO ADMIN");
        
    }
    public void mostrarCrearNuevoNivelVista(){
        pantallaAdmin.mostrarPanel("NUEVO NIVEL");
        
    }
    public void mostrarModificarNivelVista(){
        pantallaAdmin.mostrarPanel("MODIFICAR NIVEL");
    }
    public void mostrarInformeRapidoVista(){
       pantallaAdmin.mostrarPanel("INFORME RAPIDO");
    }
    
    public AdminVista getPantallaAdmin(){
        return pantallaAdmin;
    }
}
