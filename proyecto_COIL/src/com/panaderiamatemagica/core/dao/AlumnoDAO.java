/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.core.dao;

import com.panaderiamatemagica.core.ConexionBDT;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JTable;
import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import java.sql.PreparedStatement;

/**
 *
 * @author Equipo Dell
 */
public class AlumnoDAO {

    public void EjecutarYMostrarAlumnos(JTable vista, String nombreAdministrador, String filtroAdicional) {
        try (Connection conn = ConexionBDT.obtenerConexion()) {
            DefaultTableModel modelo = new DefaultTableModel();
            String sql = "SELECT * FROM alumnos WHERE profesor = '" + nombreAdministrador + "'";
            sql += filtroAdicional;

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apodo");
            modelo.addColumn("Apellido");
            modelo.addColumn("Genero");
            modelo.addColumn("Fecha de nacimiento");
            modelo.addColumn("Promedio aciertos");
            modelo.addColumn("Promedio desaciertos");
            modelo.addColumn("Numero de galletas");
            // modelo.addColumn("Numero de estellas"); // Eliminado porque no existe en la
            // tabla

            String datos[] = new String[9]; // Reducido a 9 columnas

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString("alumno_id"); // Usando nombre de columna correcto
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("apodo");
                datos[3] = rs.getString("apellido");
                datos[4] = rs.getString("genero");
                datos[5] = rs.getString("fecha_nacimiento");
                datos[6] = rs.getString("promedio_aciertos");
                datos[7] = rs.getString("promedio_desaciertos");
                datos[8] = rs.getString("numero_galletas");
                // datos[9] = rs.getString("numero_estrellas"); // Eliminado

                modelo.addRow(datos);
            }
            vista.setModel(modelo);

        } catch (SQLException e) {
            System.err.println("ERROR: La conexión o la consulta falló. " + e.getMessage());
        }
    }

    public void MostrarAlumnos(JTable vista, String nombreAdministrador) {
        EjecutarYMostrarAlumnos(vista, nombreAdministrador, "");
    }

    public void MostrarAlumnosPorMayorEstrellas(JTable vista, String nombreAdministrador) {
        // Como no hay estrellas, ordenamos por galletas o aciertos
        String filtro = " ORDER BY numero_galletas DESC";
        EjecutarYMostrarAlumnos(vista, nombreAdministrador, filtro);
    }

    public void MostrarAlumnosPorNombreCompleto(JTable vista, String nombreAdministrador, String nombre,
            String apellido) {
        String filtro = " AND nombre = '" + nombre + "' AND apellido = '" + apellido + "'";
        EjecutarYMostrarAlumnos(vista, nombreAdministrador, filtro);
    }

    public void MostrarAlumnoPorApodo(JTable vista, String nombreAdministrador, String apodo) {
        String filtro = " AND apodo = '" + apodo + "'";
        EjecutarYMostrarAlumnos(vista, nombreAdministrador, filtro);
    }

    public boolean verificarUnicidadApodoBD(String apodo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM alumnos WHERE apodo = ?";
        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            if (conn == null)
                throw new SQLException("Conexión nula.");
            ps.setString(1, apodo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public boolean insertarAlumno(AlumnoModelo alumno) {
        
        String sql = "INSERT INTO alumnos (nombre, apellido, apodo, fecha_nacimiento, genero, profesor, administrador_id) VALUES (?, ?, ?, ?, ?,?,?)";
        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getApodo());
            ps.setString(4, alumno.getFechaNacimiento());
            ps.setString(5, "O");
            
            //admin por defecto.
            ps.setString(6, "Melanie");
            // id del admin.
            ps.setInt(7, 4);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("ERROR al insertar alumno: " + e.getMessage());
            return false;
        }
    }

    // Método duplicado eliminado

    private boolean modificarCampoAlumno(String campo, String nuevoValor, String apodo) {
        String sql = "UPDATE alumnos SET " + campo + " = ? WHERE apodo = ?";
        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuevoValor);
            ps.setString(2, apodo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("ERROR al modificar el campo '" + campo + "': " + e.getMessage());
            return false;
        }
    }

    public boolean modificarNombre(String nuevoNombre, String apodo) {
        return modificarCampoAlumno("nombre", nuevoNombre, apodo);
    }

    public boolean modificarApellido(String nuevoApellido, String apodo) {
        return modificarCampoAlumno("apellido", nuevoApellido, apodo);
    }

    public boolean modificarGenero(String nuevoGenero, String apodo) {
        return modificarCampoAlumno("genero", nuevoGenero, apodo);
    }

    public boolean modificarApodo(String nuevoApodo, String apodoActual) {
        try {
            if (verificarUnicidadApodoBD(nuevoApodo)) {
                System.err.println("El apodo '" + nuevoApodo + "' ya esta en uso.");
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
        String sql = "UPDATE alumnos SET apodo = ? WHERE apodo = ?";
        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuevoApodo);
            ps.setString(2, apodoActual);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean eliminarAlumnoPorApodo(String apodo) {
        String sql = "DELETE FROM alumnos WHERE apodo = ?";
        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, apodo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("ERROR al eliminar alumno: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarProgreso(String apodo, int nuevasGalletas, int nuevasEstrellas,
            double nuevoPromedioAciertos, double nuevoPromedioDesaciertos) {
        // CORREGIDO: Eliminado numero_estrellas de la actualización
        String sql = "UPDATE alumnos SET numero_galletas = ?, promedio_aciertos = ?, promedio_desaciertos = ? WHERE apodo = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, nuevasGalletas);
            // ps.setInt(2, nuevasEstrellas); // Eliminado
            ps.setDouble(2, nuevoPromedioAciertos);
            ps.setDouble(3, nuevoPromedioDesaciertos);
            ps.setString(4, apodo);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("ERROR al actualizar progreso: " + e.getMessage());
            return false;
        }
    }

    /**
     * Suma galletas al total del alumno
     * 
     * @param alumnoId        ID del alumno
     * @param galletasGanadas Cantidad de galletas a sumar
     * @return true si se actualizó correctamente
     */
    public boolean sumarGalletas(int alumnoId, int galletasGanadas) {
        String sql = "UPDATE alumnos SET numero_galletas = numero_galletas + ? WHERE alumno_id = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, galletasGanadas);
            ps.setInt(2, alumnoId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("ERROR al sumar galletas: " + e.getMessage());
            return false;
        }
    }

    /**
     * Actualiza las estadísticas (promedios) del alumno
     * 
     * @param alumnoId              ID del alumno
     * @param porcentajeAciertos    Nuevo porcentaje de aciertos
     * @param porcentajeDesaciertos Nuevo porcentaje de desaciertos
     * @return true si se actualizó correctamente
     */
    public boolean actualizarEstadisticas(int alumnoId, double porcentajeAciertos, double porcentajeDesaciertos) {
        String sql = "UPDATE alumnos SET promedio_aciertos = ?, promedio_desaciertos = ? WHERE alumno_id = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, porcentajeAciertos);
            ps.setDouble(2, porcentajeDesaciertos);
            ps.setInt(3, alumnoId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("ERROR al actualizar estadísticas: " + e.getMessage());
            return false;
        }
    }

    public AlumnoModelo obtenerAlumnoPorApodo(String apodo) {
        String sql = "SELECT * FROM alumnos WHERE apodo = ?";
        AlumnoModelo alumno = null;
        try (Connection conn = ConexionBDT.obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, apodo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new AlumnoModelo();
                alumno.setId_Alumno(rs.getInt("alumno_id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setGenero(rs.getString("genero"));
                alumno.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                alumno.setApodo(rs.getString("apodo"));
                alumno.setPromedioAciertos(rs.getDouble("promedio_aciertos"));
                alumno.setPromedioDesaciertos(rs.getDouble("promedio_desaciertos"));
                alumno.setNumeroGalletas(rs.getInt("numero_galletas"));
                alumno.setProfesor(rs.getString("profesor"));
            }
        } catch (Exception e) {
            System.err.println("Error obteniendo alumno: " + e.getMessage());
        }
        return alumno;
    }
}
