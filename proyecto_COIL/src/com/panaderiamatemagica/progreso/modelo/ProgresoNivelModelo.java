package com.panaderiamatemagica.progreso.modelo;

import java.sql.Timestamp;

/**
 * Modelo para representar el progreso de un alumno en un nivel específico
 */
public class ProgresoNivelModelo {
    private int alumnoId;
    private int dimensionId;
    private int nivelId;
    private int estrellas;
    private boolean completado;
    private int ejercicioActual;
    private Timestamp fechaActualizacion;

    // Campos adicionales para estadísticas de la sesión actual (no persistidos)
    private int vidasRestantes;
    private int aciertos;
    private int desaciertos;
    private int totalEjercicios;

    public ProgresoNivelModelo() {
        this.vidasRestantes = 5; // Iniciar con 5 vidas
        this.aciertos = 0;
        this.desaciertos = 0;
        this.estrellas = 0;
        this.completado = false;
        this.ejercicioActual = 0;
    }

    // Getters y Setters
    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public int getDimensionId() {
        return dimensionId;
    }

    public void setDimensionId(int dimensionId) {
        this.dimensionId = dimensionId;
    }

    public int getNivelId() {
        return nivelId;
    }

    public void setNivelId(int nivelId) {
        this.nivelId = nivelId;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    public int getEjercicioActual() {
        return ejercicioActual;
    }

    public void setEjercicioActual(int ejercicioActual) {
        this.ejercicioActual = ejercicioActual;
    }

    public Timestamp getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Timestamp fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getVidasRestantes() {
        return vidasRestantes;
    }

    public void setVidasRestantes(int vidasRestantes) {
        this.vidasRestantes = vidasRestantes;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getDesaciertos() {
        return desaciertos;
    }

    public void setDesaciertos(int desaciertos) {
        this.desaciertos = desaciertos;
    }

    public int getTotalEjercicios() {
        return totalEjercicios;
    }

    public void setTotalEjercicios(int totalEjercicios) {
        this.totalEjercicios = totalEjercicios;
    }

    /**
     * Registra un acierto
     */
    public void registrarAcierto() {
        this.aciertos++;
    }

    /**
     * Registra un error y resta una vida
     */
    public void registrarError() {
        this.desaciertos++;
        if (this.vidasRestantes > 0) {
            this.vidasRestantes--;
        }
    }

    /**
     * Calcula las estrellas obtenidas basándose en las vidas restantes
     * 
     * @return número de estrellas (0-3)
     */
    public int calcularEstrellas() {
        if (vidasRestantes == 5) {
            return 3;
        } else if (vidasRestantes >= 3) {
            return 2;
        } else if (vidasRestantes >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Calcula las galletas ganadas basándose en estrellas y dificultad
     * 
     * @param dificultad nivel de dificultad del nivel (1-5)
     * @return cantidad de galletas ganadas
     */
    public int calcularGalletas(int dificultad) {
        int estrellasObtenidas = calcularEstrellas();
        // Fórmula: estrellas * dificultad * 10
        return estrellasObtenidas * dificultad * 10;
    }

    /**
     * Calcula el porcentaje de aciertos
     * 
     * @return porcentaje de aciertos (0-100)
     */
    public double calcularPorcentajeAciertos() {
        if (totalEjercicios == 0)
            return 0;
        return (aciertos * 100.0) / totalEjercicios;
    }
}
