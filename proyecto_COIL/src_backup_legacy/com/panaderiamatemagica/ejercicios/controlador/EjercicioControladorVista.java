/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.ejercicios.controlador;

import com.panaderiamatemagica.ejercicios.modelo.EjercicioModelo;
import com.panaderiamatemagica.core.RouterControlador;
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
    private int puntaje; // NUEVO: Para llevar el conteo de respuestas correctas

    public EjercicioControladorVista(RouterControlador router, EjercicioVista vista) {
        this.router = router;
        this.vista = vista;
        this.indice = 0; // Inicializar
        this.puntaje = 0; // Inicializar
    }

    Validacion validar = new Validacion();

    // Implementacion del metodo de inicio de nivel
    public void iniciarNuevoNivel() {
        // 1. Obtener la lista cargada por RouterControlador.iniciarJuegoConEjercicios()
        ArrayList<EjercicioModelo> ejercicios = router.getListaejercicios_1();

        if (ejercicios == null || ejercicios.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                    "Error: El nivel está vacío. Regresando a la selección.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            router.mostrarSeleccionDimensionVista();
            return;
        }

        // 2. Cargar la lista y resetear el estado del juego.
        this.listaEjercicios = ejercicios;
        this.indice = 0;
        this.puntaje = 0;
        this.ejercicioActual = null;

        // 3. Iniciar el recorrido mostrando el primer ejercicio.
        avanzarYMostrarSiguienteEjercicio();
    }

    public void avanzarYMostrarSiguienteEjercicio() {
        if (listaEjercicios == null)
            return; // Validación extra

        if (indice < listaEjercicios.size()) {

            // 1. Obtener el ejercicio a cargar.
            EjercicioModelo siguienteEjercicio = listaEjercicios.get(indice);
            this.ejercicioActual = siguienteEjercicio;

            // 2. Cargar en la Vista y mostrarla.
            vista.cargarEjercicio(siguienteEjercicio);
            router.mostrarEjercicioVista();

            // 3. Incrementamos el indice para la proxima vez.
            indice++;

        } else {
            // 4. Fin de la secuencia: el nivel ha terminado.

            // --- LÓGICA DE RECOMPENSAS ---
            int totalEjercicios = listaEjercicios.size();
            double eficiencia = ((double) puntaje / totalEjercicios) * 100;
            int estrellasGanadas = 0;
            int galletasGanadas = 0;

            if (eficiencia >= 100) {
                estrellasGanadas = 3;
                galletasGanadas = 50;
            } else if (eficiencia >= 70) {
                estrellasGanadas = 2;
                galletasGanadas = 30;
            } else if (eficiencia >= 50) {
                estrellasGanadas = 1;
                galletasGanadas = 10;
            } else {
                estrellasGanadas = 0;
                galletasGanadas = 0;
            }

            // Obtener alumno actual
            com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo alumno = router.getAlumnoActual();
            String mensaje = String.format(
                    "¡Nivel Finalizado!\n\nPuntaje: %d/%d\nEficiencia: %.1f%%\nEstrellas: %d\nGalletas: %d",
                    puntaje, totalEjercicios, eficiencia, estrellasGanadas, galletasGanadas);

            if (alumno != null) {
                // Actualizar datos del alumno
                int nuevasGalletasTotal = alumno.getNumeroGalletas() + galletasGanadas;
                int nuevasEstrellasTotal = alumno.getNumeroEstrella() + estrellasGanadas;

                // Calculo simple de nuevo promedio (promedio acumulado)
                double viejoPromedio = alumno.getPromedioAciertos();
                double nuevoPromedio = (viejoPromedio == 0) ? eficiencia : (viejoPromedio + eficiencia) / 2;

                // Actualizar objeto local
                alumno.setNumeroGalletas(nuevasGalletasTotal);
                alumno.setNumeroEstrella(nuevasEstrellasTotal);
                alumno.setPromedioAciertos(nuevoPromedio);

                // Guardar en BD
                com.panaderiamatemagica.core.dao.AlumnoDAO alumnoDAO = new com.panaderiamatemagica.core.dao.AlumnoDAO();
                boolean exito = alumnoDAO.actualizarProgreso(alumno.getApodo(), nuevasGalletasTotal,
                        nuevasEstrellasTotal, nuevoPromedio, 0); // Desaciertos pendiente

                if (exito) {
                    mensaje += "\n\n¡Progreso guardado!";
                } else {
                    mensaje += "\n\n(Error al guardar progreso)";
                }
            } else {
                mensaje += "\n\n(Modo invitado - Progreso no guardado)";
            }

            JOptionPane.showMessageDialog(vista, mensaje, "RESULTADOS", JOptionPane.INFORMATION_MESSAGE);

            // 5. Finalización del nivel:
            router.mostrarResultadoVista(); // Muestra el resultado (si lo implementa)
            router.mostrarSeleccionDimensionVista(); // Regresa a la selección de dimensión
        }
    }

    public void validarRespuesta(String respuestaUsuario) {

        if (ejercicioActual == null) {
            System.err.println("Error: No hay ejercicio cargado para validar.");
            return;
        }

        String respuestaCorrecta = ejercicioActual.getOpcionesRespuestas().get(ejercicioActual.getNumRespuesta());

        if (respuestaUsuario.equals(respuestaCorrecta)) {

            JOptionPane.showMessageDialog(null, "¡Correcto! Siguiente ejercicio.", "Respuesta",
                    JOptionPane.INFORMATION_MESSAGE);
            this.puntaje++; // Incrementa el puntaje
            avanzarYMostrarSiguienteEjercicio();

        } else {

            JOptionPane.showMessageDialog(null, "Respuesta Incorrecta. Intenta de nuevo.", "Respuesta",
                    JOptionPane.ERROR_MESSAGE);
            // Logica de penalizacion ()
        }
    }
}