/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.juego.controlador;

import com.panaderiamatemagica.core.RouterControlador;
import com.panaderiamatemagica.juego.vista.Dimension1Vista;
import com.panaderiamatemagica.juego.vista.Dimension2Vista;
import com.panaderiamatemagica.juego.vista.Dimension3Vista;
import com.panaderiamatemagica.juego.vista.Dimension4Vista;
import com.panaderiamatemagica.juego.vista.Dimension5Vista;
import com.panaderiamatemagica.juego.vista.EjercicioVista;
import com.panaderiamatemagica.juego.vista.SeleccionDimensionVista;

/**
 *
 * @author User
 */
public class RouterDimensionControlador {
    private RouterControlador router;
    private SeleccionDimensionVista pantallaSeleccionDimension;
    private Dimension1Vista pantallaDimension1;
    private Dimension2Vista pantallaDimension2;
    private Dimension3Vista pantallaDimension3;
    private Dimension4Vista pantallaDimension4;
    private Dimension5Vista pantallaDimension5;
    
    public RouterDimensionControlador(RouterControlador router){
        this.router = router;
        
        pantallaSeleccionDimension = new SeleccionDimensionVista(router,this);
        pantallaDimension1 = new Dimension1Vista();
        pantallaDimension2 = new Dimension2Vista();
        
        //pantallas a eliminar en siguiente version, es mejor implementar una sola interfaz que cambie de fondo
        pantallaDimension3 = new Dimension3Vista();
        pantallaDimension4 = new Dimension4Vista();
        pantallaDimension5 = new Dimension5Vista();
        
        inicializarPantallas();
    }
    private void inicializarPantallas(){
        pantallaSeleccionDimension.agregarPanel(pantallaDimension1, "DIMENSION1");
        pantallaSeleccionDimension.agregarPanel(pantallaDimension2, "DIMENSION2");
    }
    public void mostrarDimension1Vista(){
        pantallaSeleccionDimension.mostrarPanel("DIMENSION1");
    }
    public void mostrarDimension2Vista(){
        pantallaSeleccionDimension.mostrarPanel("DIMENSION2");
    }
    public SeleccionDimensionVista getSeleccionDimensionViste(){
        return pantallaSeleccionDimension;
    }
    
    //ver

    /**
     *
     * @return
     */
    public Dimension1Vista getPantallaDimension1(){
        return pantallaDimension1;
    }

}


