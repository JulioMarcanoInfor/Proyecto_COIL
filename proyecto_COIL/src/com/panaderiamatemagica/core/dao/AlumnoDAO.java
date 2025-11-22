/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.core.dao;

import com.panaderiamatemagica.core.ConexionBDT;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.spi.DirStateFactory;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JTable;
import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo Dell
 */
public class AlumnoDAO {
    
    
    
    //mostrar.
    public void MostrarAlumnos(JTable vista, String nombreAdministrador){
        System.out.println("Intentando obtener la conexión...");
        try (Connection conn = ConexionBDT.obtenerConexion() ) {
            if (conn != null) {
                System.out.println("CONEXION ESTABLECIDA.");
            }
                    
        //tabla donde parecen los alumnos.
        DefaultTableModel modelo = new DefaultTableModel();
        
        //para realizar la consulta a la bdt 
        // manda a los estudiantes que sean administrados por el profesor.
        String sql = "SELECT * FROM alumnos WHERE profesor = '" + nombreAdministrador + "'";
        
        modelo.addColumn("ID: ");
        modelo.addColumn("Nombre: ");
        modelo.addColumn("Apodo: ");
        modelo.addColumn("Apellido: ");
        modelo.addColumn("Genero: ");
        modelo.addColumn("Fecha de nacimiento: ");
        modelo.addColumn("Promedio aciertos: ");
        modelo.addColumn("Promedio desaciertos: ");
        modelo.addColumn("Numero de galletas: ");
        modelo.addColumn("Numero de estellas: ");
        
        String datos[] = new String[9];
        
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            datos[0] = rs.getString(1); // recorremos la tabla como si fie un arreglo que parte de 1.
            datos[0] = rs.getString(2);
            datos[0] = rs.getString(3);
            datos[0] = rs.getString(4);
            datos[0] = rs.getString(5);
            datos[0] = rs.getString(6);
            datos[0] = rs.getString(7);
            datos[0] = rs.getString(8);
            datos[0] = rs.getString(9);
            datos[0] = rs.getString(10);
            
            modelo.addRow(datos); // agrega una nueva fila de datos.        
            
        }
        
        //le asignaos la tabla creada a la vista actual.
        vista.setModel(modelo);
        
        } catch (SQLException e) {
            System.err.println("ERROR: La conexión fallo.");
            System.err.println("Detalles: " + e.getMessage());
            return; 
        }        
    }
    
    // true si el apodo ya existe.
    public boolean verificarUnicidadApodoBD(String apodo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM alumnos WHERE apodo = ?"; 

        try (Connection conn = ConexionBDT.obtenerConexion(); // <--- Aqui puede fallar no se muy bien pq 
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (conn == null) {
                System.err.println("!!! Fallo: La conexion a la BDT es nula. !!!");
                throw new SQLException("Conexión nula."); 
            }

            ps.setString(1, apodo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    //incertar
    // Recibe el objeto AlumnoModelo con los datos validados.
    public boolean insertarAlumno(AlumnoModelo alumno) {
        // nos aseguramos de que las columnas coincidan con el esquema de la tabla alumnos.
        // Incluye solo los campos que se a llenar ahorita (excluyendo IDs autonumericos, promedios por defecto,etc.)
        String sql = "INSERT INTO alumnos (nombre, apellido, apodo, fecha_nacimiento, genero) "
                   + "VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionBDT.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // 1. Asignar los valores del objeto AlumnoModelo a los marcadores (?)
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getApodo());
            ps.setString(4, alumno.getFechaNacimiento());
            // le pongo esto al genere pq es obligatorio en la bdt
            ps.setString(5, "O");
            
            // 3. Ejecutamos la insercion en la bdt
            int filasAfectadas = ps.executeUpdate();
            
            return filasAfectadas > 0; // Retorna true si se insertó al menos una fila.
            
        } catch (SQLException e) {
            // no se como poner este tipo de mensajes si en patanlla o solo en terminal para 
            // la presnetacion porcia jajaj.
            System.err.println("ERROR al insertar alumno: " + e.getMessage());
            return false;
        }
    }
}
