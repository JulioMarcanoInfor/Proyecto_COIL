/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.ejercicios.controlador;

import com.panaderiamatemagica.ejercicios.modelo.EjercicioModelo;
import com.panaderiamatemagica.core.RouterControlador;
import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import com.panaderiamatemagica.progreso.modelo.ProgresoNivelModelo;
import com.panaderiamatemagica.core.dao.ProgresoNivelDAO;
import com.panaderiamatemagica.core.dao.AlumnoDAO;
import com.panaderiamatemagica.juego.vista.ResultadoVista;
import Utilidades.Validacion;
import com.panaderiamatemagica.juego.vista.EjercicioVista;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EjercicioControladorVista {
    private RouterControlador router;
    private ArrayList<EjercicioModelo> listaEjercicios;
    private EjercicioVista vista;

    private EjercicioModelo ejercicioActual;

    private int indice;
    private int puntaje;

    // Sistema de gamificación
    private ProgresoNivelModelo progresoNivel;
    private int dimensionId;
    private int nivelId;
    private int dificultadNivel;

    public EjercicioControladorVista(RouterControlador router, EjercicioVista vista) {
        this.router = router;
        this.vista = vista;
        this.indice = 0;
        this.puntaje = 0;
        this.dimensionId = 1; // Por defecto
        this.nivelId = 1; // Por defecto
        this.dificultadNivel = 1; // Por defecto
    }

    Validacion validar = new Validacion();

    /**
     * Establece el contexto del nivel (dimensión, nivel, dificultad)
     */
    public void setContextoNivel(int dimensionId, int nivelId, int dificultad) {
        this.dimensionId = dimensionId;
        this.nivelId = nivelId;
        this.dificultadNivel = dificultad;
    }

    /**
     * Inicia un nuevo nivel con sistema de vidas
     */
    public void iniciarNuevoNivel() {
        // 1. Obtener la lista de ejercicios
        ArrayList<EjercicioModelo> ejercicios = router.getListaejercicios_1();

        if (ejercicios == null || ejercicios.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                    "Error: El nivel está vacío. Regresando a la selección.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            router.mostrarSeleccionDimension1();
            return;
        }

        // 2. Inicializar progreso del nivel
        this.progresoNivel = new ProgresoNivelModelo();
        this.progresoNivel.setTotalEjercicios(ejercicios.size());
        this.progresoNivel.setDimensionId(dimensionId);
        this.progresoNivel.setNivelId(nivelId);

        // Obtener alumno actual
        AlumnoModelo alumno = router.getAlumnoActual();
        if (alumno != null) {
            this.progresoNivel.setAlumnoId(alumno.getId_Alumno());
        }

        // 3. Cargar la lista y resetear el estado del juego
        this.listaEjercicios = ejercicios;
        this.indice = 0;
        this.puntaje = 0;
        this.ejercicioActual = null;

        // 4. Actualizar vista con vidas iniciales
        vista.actualizarVidas(progresoNivel.getVidasRestantes());

        // 5. Iniciar el recorrido mostrando el primer ejercicio
        avanzarYMostrarSiguienteEjercicio();
    }

    public void avanzarYMostrarSiguienteEjercicio() {
        if (listaEjercicios == null)
            return;

        if (indice < listaEjercicios.size()) {

            // 1. Obtener el ejercicio a cargar
            EjercicioModelo siguienteEjercicio = listaEjercicios.get(indice);
            this.ejercicioActual = siguienteEjercicio;

            // 2. Cargar en la Vista y mostrarla
            vista.cargarEjercicio(siguienteEjercicio);
            router.mostrarEjercicioVista();

            // 3. Incrementar índice para la próxima vez
            indice++;

        } else {
            // 4. Fin de la secuencia: el nivel ha terminado
            finalizarNivel();
        }
    }

    public void validarRespuesta(String respuestaUsuario) {

        if (ejercicioActual == null) {
            System.err.println("Error: No hay ejercicio cargado para validar.");
            return;
        }

        String respuestaCorrecta = ejercicioActual.getOpcionesRespuestas()
                .get(ejercicioActual.getNumRespuesta());

        if (respuestaUsuario.equals(respuestaCorrecta)) {
            // Respuesta correcta
            progresoNivel.registrarAcierto();
            this.puntaje++;

            JOptionPane.showMessageDialog(null,
                    "¡Correcto! +" + progresoNivel.getVidasRestantes() + " vidas",
                    "Respuesta Correcta",
                    JOptionPane.INFORMATION_MESSAGE);

            avanzarYMostrarSiguienteEjercicio();

        } else {
            // Respuesta incorrecta
            progresoNivel.registrarError();

            // Actualizar vista de vidas
            vista.actualizarVidas(progresoNivel.getVidasRestantes());

            if (progresoNivel.getVidasRestantes() <= 0) {
                // Game Over
                JOptionPane.showMessageDialog(null,
                        "¡Game Over! Te quedaste sin vidas.\nAciertos: " + puntaje + "/" + listaEjercicios.size(),
                        "Fin del Nivel",
                        JOptionPane.ERROR_MESSAGE);
                finalizarNivel();
            } else {
                // Aún tiene vidas
                JOptionPane.showMessageDialog(null,
                        "Respuesta Incorrecta.\nVidas restantes: " + progresoNivel.getVidasRestantes(),
                        "Intenta de nuevo",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * Finaliza el nivel y guarda el progreso en la base de datos
     */
    private void finalizarNivel() {
        // Calcular resultados
        int estrellasObtenidas = progresoNivel.calcularEstrellas();
        int galletasGanadas = progresoNivel.calcularGalletas(dificultadNivel);

        // Marcar como completado si obtuvo al menos 1 estrella
        progresoNivel.setCompletado(estrellasObtenidas > 0);
        progresoNivel.setEstrellas(estrellasObtenidas);

        // Guardar progreso en BD
        guardarProgresoEnBD(estrellasObtenidas, galletasGanadas);

        // Mostrar pantalla de resultados con los datos
        router.mostrarResultadoVista();

        // Actualizar la vista de resultados con los datos del progreso
        try {
            ResultadoVista resultadoVista = router.getPantallaResultado();
            if (resultadoVista != null) {
                resultadoVista.mostrarResultados(
                        estrellasObtenidas,
                        galletasGanadas,
                        progresoNivel.getAciertos(),
                        progresoNivel.getDesaciertos(),
                        progresoNivel.getVidasRestantes());
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar ResultadoVista: " + e.getMessage());
        }
    }

    /**
     * Guarda el progreso del nivel en la base de datos
     */
    private void guardarProgresoEnBD(int estrellas, int galletas) {
        try {
            AlumnoModelo alumno = router.getAlumnoActual();
            if (alumno == null) {
                System.err.println("No hay alumno autenticado. No se guardará el progreso.");
                return;
            }

            // 1. Guardar progreso del nivel
            ProgresoNivelDAO progresoDAO = new ProgresoNivelDAO();
            boolean progresoGuardado = progresoDAO.guardarProgreso(progresoNivel);

            if (progresoGuardado) {
                System.out.println("✓ Progreso guardado: " + estrellas + " estrellas");
            } else {
                System.err.println("✗ Error al guardar progreso");
            }

            // 2. Sumar galletas al alumno
            AlumnoDAO alumnoDAO = new AlumnoDAO();
            boolean galletasSumadas = alumnoDAO.sumarGalletas(alumno.getId_Alumno(), galletas);

            if (galletasSumadas) {
                System.out.println("✓ Galletas sumadas: +" + galletas);
            } else {
                System.err.println("✗ Error al sumar galletas");
            }

            // 3. Actualizar estadísticas
            double porcentajeAciertos = progresoNivel.calcularPorcentajeAciertos();
            double porcentajeDesaciertos = 100 - porcentajeAciertos;

            boolean estadisticasActualizadas = alumnoDAO.actualizarEstadisticas(
                    alumno.getId_Alumno(),
                    porcentajeAciertos,
                    porcentajeDesaciertos);

            if (estadisticasActualizadas) {
                System.out.println("✓ Estadísticas actualizadas");
            } else {
                System.err.println("✗ Error al actualizar estadísticas");
            }

        } catch (Exception e) {
            System.err.println("ERROR al guardar progreso: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Obtiene el progreso actual del nivel (para mostrar en ResultadoVista)
     */
    public ProgresoNivelModelo getProgresoNivel() {
        return progresoNivel;
    }

    /**
     * Obtiene la dificultad del nivel actual
     */
    public int getDificultadNivel() {
        return dificultadNivel;
    }
}