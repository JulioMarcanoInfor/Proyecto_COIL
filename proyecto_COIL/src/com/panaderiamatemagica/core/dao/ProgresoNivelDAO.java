package com.panaderiamatemagica.core.dao;

import com.panaderiamatemagica.core.ConexionBDT;
import com.panaderiamatemagica.progreso.modelo.ProgresoNivelModelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para gestionar el progreso de los alumnos en los niveles
 */
public class ProgresoNivelDAO {

    /**
     * Obtiene el progreso de un alumno en un nivel específico
     */
    public ProgresoNivelModelo obtenerProgreso(int alumnoId, int dimensionId, int nivelId) throws SQLException {
        String sql = "SELECT * FROM progreso_niveles WHERE alumno_id = ? AND dimension_id = ? AND nivel_id = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, alumnoId);
            stmt.setInt(2, dimensionId);
            stmt.setInt(3, nivelId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ProgresoNivelModelo progreso = new ProgresoNivelModelo();
                progreso.setAlumnoId(rs.getInt("alumno_id"));
                progreso.setDimensionId(rs.getInt("dimension_id"));
                progreso.setNivelId(rs.getInt("nivel_id"));
                progreso.setEstrellas(rs.getInt("estrellas"));
                progreso.setCompletado(rs.getBoolean("completado"));
                progreso.setEjercicioActual(rs.getInt("ejercicio_actual"));
                progreso.setFechaActualizacion(rs.getTimestamp("fecha_actualizacion"));
                return progreso;
            }
        }
        return null; // No existe progreso previo
    }

    /**
     * Guarda o actualiza el progreso de un alumno en un nivel
     */
    public boolean guardarProgreso(ProgresoNivelModelo progreso) throws SQLException {
        // Primero verificar si ya existe un registro
        ProgresoNivelModelo existente = obtenerProgreso(
                progreso.getAlumnoId(),
                progreso.getDimensionId(),
                progreso.getNivelId());

        if (existente == null) {
            return insertarProgreso(progreso);
        } else {
            return actualizarProgreso(progreso);
        }
    }

    /**
     * Inserta un nuevo registro de progreso
     */
    private boolean insertarProgreso(ProgresoNivelModelo progreso) throws SQLException {
        String sql = "INSERT INTO progreso_niveles (alumno_id, dimension_id, nivel_id, estrellas, completado, ejercicio_actual, fecha_actualizacion) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, progreso.getAlumnoId());
            stmt.setInt(2, progreso.getDimensionId());
            stmt.setInt(3, progreso.getNivelId());
            stmt.setInt(4, progreso.getEstrellas());
            stmt.setBoolean(5, progreso.isCompletado());
            stmt.setInt(6, progreso.getEjercicioActual());

            return stmt.executeUpdate() > 0;
        }
    }

    /**
     * Actualiza un registro de progreso existente
     */
    private boolean actualizarProgreso(ProgresoNivelModelo progreso) throws SQLException {
        String sql = "UPDATE progreso_niveles SET estrellas = ?, completado = ?, ejercicio_actual = ?, fecha_actualizacion = CURRENT_TIMESTAMP "
                +
                "WHERE alumno_id = ? AND dimension_id = ? AND nivel_id = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, progreso.getEstrellas());
            stmt.setBoolean(2, progreso.isCompletado());
            stmt.setInt(3, progreso.getEjercicioActual());
            stmt.setInt(4, progreso.getAlumnoId());
            stmt.setInt(5, progreso.getDimensionId());
            stmt.setInt(6, progreso.getNivelId());

            return stmt.executeUpdate() > 0;
        }
    }

    /**
     * Verifica si un alumno puede acceder a un nivel (progresión lineal)
     * 
     * @return true si puede acceder, false si está bloqueado
     */
    public boolean puedeAccederNivel(int alumnoId, int dimensionId, int nivelId) throws SQLException {
        // El primer nivel siempre está desbloqueado
        if (nivelId == 1) {
            return true;
        }

        // Verificar si completó el nivel anterior con al menos 1 estrella
        ProgresoNivelModelo nivelAnterior = obtenerProgreso(alumnoId, dimensionId, nivelId - 1);

        return nivelAnterior != null && nivelAnterior.isCompletado() && nivelAnterior.getEstrellas() >= 1;
    }

    /**
     * Obtiene todos los niveles completados de un alumno en una dimensión
     */
    public List<ProgresoNivelModelo> obtenerProgresosDimension(int alumnoId, int dimensionId) throws SQLException {
        String sql = "SELECT * FROM progreso_niveles WHERE alumno_id = ? AND dimension_id = ? ORDER BY nivel_id";
        List<ProgresoNivelModelo> progresos = new ArrayList<>();

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, alumnoId);
            stmt.setInt(2, dimensionId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProgresoNivelModelo progreso = new ProgresoNivelModelo();
                progreso.setAlumnoId(rs.getInt("alumno_id"));
                progreso.setDimensionId(rs.getInt("dimension_id"));
                progreso.setNivelId(rs.getInt("nivel_id"));
                progreso.setEstrellas(rs.getInt("estrellas"));
                progreso.setCompletado(rs.getBoolean("completado"));
                progreso.setEjercicioActual(rs.getInt("ejercicio_actual"));
                progreso.setFechaActualizacion(rs.getTimestamp("fecha_actualizacion"));
                progresos.add(progreso);
            }
        }

        return progresos;
    }

    /**
     * Obtiene el total de estrellas de un alumno en una dimensión
     */
    public int obtenerTotalEstrellasDimension(int alumnoId, int dimensionId) throws SQLException {
        String sql = "SELECT SUM(estrellas) as total FROM progreso_niveles WHERE alumno_id = ? AND dimension_id = ? AND completado = true";

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, alumnoId);
            stmt.setInt(2, dimensionId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("total");
            }
        }

        return 0;
    }
}
