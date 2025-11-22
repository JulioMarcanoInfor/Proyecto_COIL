/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.autenticacion.modelo;

/**
 *
 * @author Equipo Dell
 */
public class AlumnoModelo extends UsuarioModelo{
    private int id_Alumno;
    // para guardar por que nivel estan.
    private int idNivelD1;
    private int idNivelD2;
    private int idNivelD3;
    private int idNivelD4;
    private int idNivelD5;
    String apodo;
    double promedioAciertos;
    double promedioDesaciertos; 
    String profesor;
    int numeroGalletas;
    int numeroEstrella;
    
    //contructor1.
    public AlumnoModelo(String apodo, double promedioAciertos, double promedioDesaciertos, String profesor, int numeroGalletas, int numeroEstrella, String nombre, String apellido, int genero, String fechaNacimiento) {
        super(nombre, apellido, genero, fechaNacimiento);
        this.apodo = apodo;
        this.promedioAciertos = promedioAciertos;
        this.promedioDesaciertos = promedioDesaciertos;
        this.profesor = profesor;
        this.numeroGalletas = numeroGalletas;
        this.numeroEstrella = numeroEstrella;
    }

    //construtor2.
    public AlumnoModelo() {
        super();
        this.apodo = "";
        this.promedioAciertos = 0.0;
        this.promedioDesaciertos = 0.0;
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
    public double getpromedioDesaciertos() {
        return promedioDesaciertos;
    }
    public void setpromedioDesaciertos(double promedioDesaciertos) {
        this.promedioDesaciertos = promedioDesaciertos;
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

    public int getId_Alumno() {
        return id_Alumno;
    }

    public void setId_Alumno(int id_Alumno) {
        this.id_Alumno = id_Alumno;
    }

    public double getPromedioDesaciertos() {
        return promedioDesaciertos;
    }

    public void setPromedioDesaciertos(double promedioDesaciertos) {
        this.promedioDesaciertos = promedioDesaciertos;
    }

    public int getIdNivelD1() {
        return idNivelD1;
    }

    public void setIdNivelD1(int idNivelD1) {
        this.idNivelD1 = idNivelD1;
    }

    public int getIdNivelD2() {
        return idNivelD2;
    }

    public void setIdNivelD2(int idNivelD2) {
        this.idNivelD2 = idNivelD2;
    }

    public int getIdNivelD3() {
        return idNivelD3;
    }

    public void setIdNivelD3(int idNivelD3) {
        this.idNivelD3 = idNivelD3;
    }

    public int getIdNivelD4() {
        return idNivelD4;
    }

    public void setIdNivelD4(int idNivelD4) {
        this.idNivelD4 = idNivelD4;
    }

    public int getIdNivelD5() {
        return idNivelD5;
    }

    public void setIdNivelD5(int idNivelD5) {
        this.idNivelD5 = idNivelD5;
    }
    
}
