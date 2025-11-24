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

    
    // ver esto para implentar en la vista.
    // mostra alumnos. 
        //muestra simplemente los que tine el profesor.
    public void EjecutarYMostrarAlumnos(JTable vista, String nombreAdministrador, String filtroAdicional) {
        System.out.println("Intentando obtener la conexión...");
        try (Connection conn = ConexionBDT.obtenerConexion() ) {
            if (conn != null) {
                System.out.println("CONEXION ESTABLECIDA.");
            }

            DefaultTableModel modelo = new DefaultTableModel();

            // La consulta base siempre filtra por profesor.
            String sql = "SELECT * FROM alumnos WHERE profesor = '" + nombreAdministrador + "'";

            // Concatenamos el filtro adicional (ORDER BY o más condiciones WHERE)// para mostra en un orden determinado.
            sql += filtroAdicional; 

            System.out.println("SQL: " + sql);

            // Definición de las 10 columnas
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

            // contendra los datos.
            String datos[] = new String[10];

            // obtenemo los datos de la BDT.
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                // Asignacion de las 10 columnas.
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);

                modelo.addRow(datos); 
            }

            vista.setModel(modelo);

        } catch (SQLException e) {
            System.err.println("ERROR: La conexión o la consulta falló.");
            System.err.println("Detalles: " + e.getMessage());
        } 
    }
    
        //Muestra a TODOS los alumnos del profesor (sin filtro adicional ni orden).
   public void MostrarAlumnos(JTable vista, String nombreAdministrador){
       // Al pasar una cadena vacía "" como filtro adicional, solo se aplica el WHERE profesor = '...'
       EjecutarYMostrarAlumnos(vista, nombreAdministrador, ""); 
   }
    
        //Muestra todos los alumnos del profesor ordenados por número de estrellas (Mayor a Menor)
   public void MostrarAlumnosPorMayorEstrellas(JTable vista, String nombreAdministrador) {
       // Definimos el filtro SQL para ordenar por estrellas de forma descendente (DESC)
       String filtro = " ORDER BY numero_estrellas DESC";

       // Llamamos a la funcion central
       EjecutarYMostrarAlumnos(vista, nombreAdministrador, filtro);
   }
    
        //Muestra los alumnos que coinciden con un nombre y apellido especificos.
   public void MostrarAlumnosPorNombreCompleto(JTable vista, String nombreAdministrador, String nombre, String apellido) {
       // Definimos el filtro SQL usando AND para nombre y apellido
       String filtro = " AND nombre = '" + nombre + "' AND apellido = '" + apellido + "'";

       // Llamamos a la función central
       EjecutarYMostrarAlumnos(vista, nombreAdministrador, filtro);
   }
   
        //Muestra el alumno que coincide con un apodo especifico.
   public void MostrarAlumnoPorApodo(JTable vista, String nombreAdministrador, String apodo) {
       // Definimos el filtro SQL usando AND para el apodo
       String filtro = " AND apodo = '" + apodo + "'";

       // Llamamos a la funcion central
       EjecutarYMostrarAlumnos(vista, nombreAdministrador, filtro);
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
    
    // seleccionar alumno.
    public void seleccionarAlumno(){
        
    
    }
}
