/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.modelos;

/**
 *
 * @author Equipo Dell
 */
public class AlumnoModelo extends UsuarioModelo{
    String apodo;
    double promedioAciertos;
    double printomedioDesaciertos; 
    String profesor;
    int numeroGalletas;
    int numeroEstrella;
    
    //contructor1.
    public AlumnoModelo(String apodo, double promedioAciertos, double printomedioDesaciertos, String profesor, int numeroGalletas, int numeroEstrella, String nombre, String apellido, int genero, String fechaNacimiento) {
        super(nombre, apellido, genero, fechaNacimiento);
        this.apodo = apodo;
        this.promedioAciertos = promedioAciertos;
        this.printomedioDesaciertos = printomedioDesaciertos;
        this.profesor = profesor;
        this.numeroGalletas = numeroGalletas;
        this.numeroEstrella = numeroEstrella;
    }

    //construtor2.
    public AlumnoModelo() {
        super();
        this.apodo = "";
        this.promedioAciertos = 0.0;
        this.printomedioDesaciertos = 0.0;
        this.profesor = "";
        this.numeroGalletas = 0;
        this.numeroEstrella = 0;   
    }
    
    //grt y set 

    public String getApodo() {
        return apodo;
    }
    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
    public double getPromedioAciertos() {
        return promedioAciertos;
    }
    public void setPromedioAciertos(double promedioAciertos) {
        this.promedioAciertos = promedioAciertos;
    }
    public double getPrintomedioDesaciertos() {
        return printomedioDesaciertos;
    }
    public void setPrintomedioDesaciertos(double printomedioDesaciertos) {
        this.printomedioDesaciertos = printomedioDesaciertos;
    }
    public String getProfesor() {
        return profesor;
    }
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    public int getNumeroGalletas() {
        return numeroGalletas;
    }
    public void setNumeroGalletas(int numeroGalletas) {
        this.numeroGalletas = numeroGalletas;
    }
    public int getNumeroEstrella() {
        return numeroEstrella;
    }
    public void setNumeroEstrella(int numeroEstrella) {
        this.numeroEstrella = numeroEstrella;
    }   
}
