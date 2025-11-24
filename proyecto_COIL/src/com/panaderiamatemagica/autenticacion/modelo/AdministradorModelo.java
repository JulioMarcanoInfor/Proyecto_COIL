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
public class AdministradorModelo extends UsuarioModelo{
    private int id_Administrador;
    String contraseña;
    String nombreUsuario;
    String institucion;
    
    //constructor1.
    public AdministradorModelo(String institucion, String contraseña, String nombreUsuario,String nombre, String apellido, String genero, String fechaNacimiento) {
        super(nombre, apellido, genero, fechaNacimiento);
        this.institucion = institucion;
        this.contraseña = contraseña;
        this.nombreUsuario = nombreUsuario;
    }
    //constructor2.
    public AdministradorModelo() {
        super();
        this.institucion = "";
        this.contraseña = "";
        this.nombreUsuario = "";
    }
    
    //get y set
    public int getId_Administrador() {
        return id_Administrador;
    }

    public void setId_Administrador(int id_Administrador) {
        this.id_Administrador = id_Administrador;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
    
}
