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
    
    // El método mostrarEjercicio() ya no es necesario, el flujo lo maneja iniciarNuevoNivel()
    /* public void mostrarEjercicio(EjercicioModelo ejercicio) { ... } */
    
    // 💡 Implementación del método de inicio de nivel
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
        if (listaEjercicios == null) return; // Validación extra
        
        if (indice < listaEjercicios.size()) {

            // 1. Obtener el ejercicio a cargar.
            EjercicioModelo siguienteEjercicio = listaEjercicios.get(indice);
            this.ejercicioActual = siguienteEjercicio;
            
            // 2. Cargar en la Vista y mostrarla.
            vista.cargarEjercicio(siguienteEjercicio);
            router.mostrarEjercicioVista();

            // 3. Incrementamos el indice para la próxima vez.
            indice++; 

        } else {
            // 4. Fin de la secuencia: el nivel ha terminado.
            JOptionPane.showMessageDialog(vista,  
                    "Secuencia de ejercicios completada. ¡Nivel finalizado!\nPuntaje: " + puntaje + "/" + listaEjercicios.size(),
                    "FELICIDADES", JOptionPane.INFORMATION_MESSAGE);
            
            // 5. Finalización del nivel:
            router.mostrarResultadoVista(); // Muestra el resultado (si lo implementa)
            router.mostrarSeleccionDimensionVista(); // Regresa a la selección de dimensión
        }
    }

    // ELIMINADO: mostrarListaEjercicios() ya no es necesario, lo reemplaza iniciarNuevoNivel()

    public void validarRespuesta(String respuestaUsuario) {
        
        if (ejercicioActual == null) {
            System.err.println("Error: No hay ejercicio cargado para validar.");
            return;
        }
        
        String respuestaCorrecta = ejercicioActual.getOpcionesRespuestas().get(ejercicioActual.getNumRespuesta());
        
        if (respuestaUsuario.equals(respuestaCorrecta)) {
            
            JOptionPane.showMessageDialog(null, "¡Correcto! Siguiente ejercicio.", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
            this.puntaje++; // Incrementa el puntaje
            avanzarYMostrarSiguienteEjercicio(); 
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Respuesta Incorrecta. Intenta de nuevo.", "Respuesta", JOptionPane.ERROR_MESSAGE);
            // Lógica de penalización (aquí puedes añadir un contador de vidas)
        }
    }
}