package com.panaderiamatemagica.core.dao;

import com.panaderiamatemagica.core.ConexionBDT;
import com.panaderiamatemagica.ejercicios.modelo.EjercicioModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Equipo Dell
 */
public class EjercicioDAO {

    public ArrayList<EjercicioModelo> obtenerEjerciciosPorNivel(int idNivel) {
        ArrayList<EjercicioModelo> listaEjercicios = new ArrayList<>();
        String sql = "SELECT * FROM ejercicios WHERE id_nivel = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idNivel);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    EjercicioModelo ejercicio = mapResultSetToEjercicio(rs);
                    listaEjercicios.add(ejercicio);
                }
            }
        } catch (SQLException e) {
            System.err.println("ERROR al obtener ejercicios por nivel: " + e.getMessage());
        }
        return listaEjercicios;
    }


    public ArrayList<EjercicioModelo> obtenerEjerciciosPorDimension(int idDimension) {
        ArrayList<EjercicioModelo> listaEjercicios = new ArrayList<>();
        String sql = "SELECT * FROM ejercicios WHERE id_dimension = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idDimension);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    EjercicioModelo ejercicio = mapResultSetToEjercicio(rs);
                    listaEjercicios.add(ejercicio);
                }
            }
        } catch (SQLException e) {
            System.err.println("ERROR al obtener ejercicios por dimensión: " + e.getMessage());
        }
        return listaEjercicios;
    }

    /**
     * Mapea un ResultSet a un objeto EjercicioModelo.
     */
    private EjercicioModelo mapResultSetToEjercicio(ResultSet rs) throws SQLException {
        EjercicioModelo ejercicio = new EjercicioModelo();

        ejercicio.setId_Ejercicio(rs.getInt("ejercicio_id"));
        ejercicio.setPregunta(rs.getString("pregunta"));
        ejercicio.setDificultad(rs.getInt("dificultad"));
        ejercicio.setGrado(rs.getInt("grado"));
        ejercicio.setDimension(String.valueOf(rs.getInt("id_dimension")));
        ejercicio.setPista(rs.getString("pista"));
        ejercicio.setTutorial(rs.getString("tutorial"));
        ejercicio.setDescripcion(rs.getString("descripcion"));
        ejercicio.setNumRespuesta(rs.getInt("num_respuesta"));

        // Convertir opciones_respuestas (String) a ArrayList<String>
        String opcionesStr = rs.getString("opciones_respuestas");
        if (opcionesStr != null && !opcionesStr.isEmpty()) {
            // Las opciones están separadas por punto y coma (;) en la BD
            opcionesStr = opcionesStr.replace("{", "").replace("}", "").replace("\"", "").trim();
            String[] opcionesArray = opcionesStr.split(";"); // ✅ Cambio de , a ;

            // Limpiar espacios en blanco de cada opción
            ArrayList<String> opcionesLimpias = new ArrayList<>();
            for (String opcion : opcionesArray) {
                opcionesLimpias.add(opcion.trim());
            }
            ejercicio.setOpcionesRespuestas(opcionesLimpias);
        } else {
            ejercicio.setOpcionesRespuestas(new ArrayList<>());
        }

        return ejercicio;
    }
}
