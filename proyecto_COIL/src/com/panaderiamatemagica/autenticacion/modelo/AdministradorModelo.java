/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.modelo;

import java.util.ArrayList;

/**
 *
 * @author Equipo Dell
 */
public class AdministradorModelo {
    ArrayList <AlumnoModelo> listaAlumnos; // coleccion de alumnos
    String contraseña;
    String correoElectronico;
    
    //constructor1.
    public AdministradorModelo(ArrayList<AlumnoModelo> listaAlumnos, String contraseña, String correoElectronico) {
        this.listaAlumnos = listaAlumnos;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
    }
    //constructor2.
    public AdministradorModelo() {
        this.listaAlumnos = null;
        this.contraseña = "";
        this.correoElectronico = "";
    }
    
    //get y set

    public ArrayList<AlumnoModelo> getListaAlumnos() {
        return listaAlumnos;
    }
    public void setListaAlumnos(ArrayList<AlumnoModelo> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
}
