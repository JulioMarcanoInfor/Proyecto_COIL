/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.core.dao;

import com.panaderiamatemagica.core.ConexionBDT;
import com.panaderiamatemagica.ejercicios.modelo.EjercicioModelo;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Equipo Dell
 */
public class EjercicioDAO {

    /**
     * Carga los ejercicios de una dimensión y nivel específicos
     * 
     * @param dimensionId ID de la dimensión (1-5)
     * @param nivelId     ID del nivel (1-3)
     * @return Lista de ejercicios
     */
    public ArrayList<EjercicioModelo> cargarEjerciciosPorDimensionYNivel(int dimensionId, int nivelId) {
        ArrayList<EjercicioModelo> ejercicios = new ArrayList<>();
        String sql = "SELECT * FROM ejercicios WHERE dimension_id = ? AND nivel_id = ? ORDER BY ejercicio_id";

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, dimensionId);
            ps.setInt(2, nivelId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EjercicioModelo ejercicio = new EjercicioModelo();

                // Campos básicos
                ejercicio.setId(rs.getInt("ejercicio_id"));
                ejercicio.setPregunta(rs.getString("pregunta"));
                ejercicio.setDescripcion(rs.getString("descripcion"));

                // Opciones de respuesta
                ArrayList<String> opciones = new ArrayList<>();
                opciones.add(rs.getString("opcion_1"));
                opciones.add(rs.getString("opcion_2"));
                opciones.add(rs.getString("opcion_3"));
                opciones.add(rs.getString("opcion_4"));
                ejercicio.setOpcionesRespuestas(opciones);

                // Respuesta correcta (0-index)
                ejercicio.setNumRespuesta(rs.getInt("respuesta_correcta"));

                // Metadatos
                ejercicio.setNivelId(rs.getInt("nivel_id"));
                ejercicio.setDimensionId(rs.getInt("dimension_id"));
                ejercicio.setDificultad(rs.getInt("dificultad"));

                ejercicios.add(ejercicio);
            }

            System.out.println("Cargados " + ejercicios.size() + " ejercicios para Dimensión " + dimensionId
                    + ", Nivel " + nivelId);

        } catch (Exception e) {
            System.err.println("Error cargando ejercicios: " + e.getMessage());
            e.printStackTrace();
        }

        return ejercicios;
    }
}
