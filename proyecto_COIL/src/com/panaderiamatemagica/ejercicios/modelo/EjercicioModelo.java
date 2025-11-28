/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.ejercicios.modelo;

import java.util.ArrayList;

/**
 *
 * @author Equipo Dell
 */
public class EjercicioModelo {
    private int id_Ejercicio;
    private String pregunta;
    private int dificultad;
    private int grado;
    private String dimension;
    private String pista;
    // private String recompensa;
    private String tutorial;
    private ArrayList<String> opcionesRespuestas; // tendra 4 preguntas
    private int numRespuesta; // el indice de la pregunta correcta
    private String descripcion;

    // constructor1
    public EjercicioModelo(String pregunta, int dificultad, int grado, String dimension, String pista, String tutorial,
            ArrayList<String> opcionesRespuestas, int numRespuesta, String descripcion) {
        this.pregunta = pregunta;
        this.dificultad = dificultad;
        this.grado = grado;
        this.dimension = dimension;
        this.pista = pista;
        this.tutorial = tutorial;
        this.opcionesRespuestas = opcionesRespuestas;
        this.numRespuesta = numRespuesta;
        this.descripcion = descripcion;
    }

    // constructor2.
    public EjercicioModelo() {
        this.pregunta = "";
        this.dificultad = 0;
        this.grado = 0;
        this.dimension = "";
        this.pista = "";
        this.tutorial = "";
        this.opcionesRespuestas = null;
        this.numRespuesta = 0;
        this.descripcion = "";
    }

    // get y set

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }

    public ArrayList<String> getOpcionesRespuestas() {
        return opcionesRespuestas;
    }

    public void setOpcionesRespuestas(ArrayList<String> opcionesRespuestas) {
        this.opcionesRespuestas = opcionesRespuestas;
    }

    public int getNumRespuesta() {
        return numRespuesta;
    }

    public void setNumRespuesta(int numRespuesta) {
        this.numRespuesta = numRespuesta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_Ejercicio() {
        return id_Ejercicio;
    }

    public void setId_Ejercicio(int id_Ejercicio) {
        this.id_Ejercicio = id_Ejercicio;
    }

    // Alias para compatibilidad con DAO
    public void setId(int id) {
        this.id_Ejercicio = id;
    }

    public int getId() {
        return id_Ejercicio;
    }

    // Campos adicionales para compatibilidad con BD
    private int nivelId;
    private int dimensionId;

    public int getNivelId() {
        return nivelId;
    }

    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
    }

    public int getDimensionId() {
        return dimensionId;
    }

    public void setDimensionId(int dimensionId) {
        this.dimensionId = dimensionId;
    }
}
