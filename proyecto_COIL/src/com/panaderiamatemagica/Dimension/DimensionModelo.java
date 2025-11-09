/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.Dimension;

import com.panaderiamatemagica.ejercicios.EjercicioModelo;
import java.util.ArrayList;

/**
 *
 * @author Equipo Dell
 */
public class DimensionModelo {
    private ArrayList<ArrayList<EjercicioModelo>> niveles; // coleccion de colecciones. un nivel tiene varios ejercicios
    private String categoria;
    private int numeroSubdimension; // niveles
    private ArrayList<String> mensajeFelicitacion;
    private int recompensa;
    private String descripcion;
    private int estrellasActualesDimension;
    private boolean completado; 

    //constructor1.
    public DimensionModelo(ArrayList<ArrayList<EjercicioModelo>> niveles, String categoria, int numeroSubdimension, ArrayList<String> mensajeFelicitacion, int recompensa, String descripcion, int estrellasActualesDimension, boolean completado) {
        this.niveles = niveles;
        this.categoria = categoria;
        this.numeroSubdimension = numeroSubdimension;
        this.mensajeFelicitacion = mensajeFelicitacion;
        this.recompensa = recompensa;
        this.descripcion = descripcion;
        this.estrellasActualesDimension = estrellasActualesDimension;
        this.completado = completado;
    }
    //constructor2
    public DimensionModelo() {
        this.niveles = null;
        this.categoria = "";
        this.numeroSubdimension = 0;
        this.mensajeFelicitacion = null;
        this.recompensa = 0;
        this.descripcion = "";
        this.estrellasActualesDimension = 0;
        this.completado = false;
    }
    
    //get y set

    public ArrayList<ArrayList<EjercicioModelo>> getNiveles() {
        return niveles;
    }

    public void setNiveles(ArrayList<ArrayList<EjercicioModelo>> niveles) {
        this.niveles = niveles;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumeroSubdimension() {
        return numeroSubdimension;
    }

    public void setNumeroSubdimension(int numeroSubdimension) {
        this.numeroSubdimension = numeroSubdimension;
    }

    public ArrayList<String> getMensajeFelicitacion() {
        return mensajeFelicitacion;
    }

    public void setMensajeFelicitacion(ArrayList<String> mensajeFelicitacion) {
        this.mensajeFelicitacion = mensajeFelicitacion;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstrellasActualesDimension() {
        return estrellasActualesDimension;
    }

    public void setEstrellasActualesDimension(int estrellasActualesDimension) {
        this.estrellasActualesDimension = estrellasActualesDimension;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
    
}
