/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.modelo;

/**
 *
 * @author Equipo Dell
 */
public abstract class UsuarioModelo {
    String nombre;
    String apellido;
    String genero; 
    String fechaNacimiento;

    //constructor1.
    public UsuarioModelo(String nombre, String apellido, String genero, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    //constructor2.
    public UsuarioModelo(){
        this.nombre = "";
        this.apellido = "";
        this.genero = "";
        this.fechaNacimiento = "";
    }
    
    // get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
