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
        //funcion central.
    public void EjecutarYMostrarAlumnos(JTable vista, String nombreAdministrador, String filtroAdicional) {
        System.out.println("Intentando obtener la conexión...");
        try (Connection conn = ConexionBDT.obtenerConexion() ) {
            if (conn != null) {
                System.out.println("CONEXION ESTABLECIDA.");
            }
            
            //tabla donde se mostraran los datos.
            DefaultTableModel modelo = new DefaultTableModel();

            // La consulta base siempre filtra por profesor.
            String sql = "SELECT * FROM alumnos WHERE profesor = '" + nombreAdministrador + "'";

            // Concatenamos el filtro adicional (ORDER BY o más condiciones WHERE)// para mostra en un orden determinado.
            sql += filtroAdicional; 

            // para ver lo que se le paso a la BDT
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
            // lo colocamos en la vista.
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
        
        // mandamos la consuta a la BDT.
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
    
    // obtener un alumno.
    public AlumnoModelo obtenerAlumnoPorApodo(String apodo) {
        AlumnoModelo alumno = null;
        String sql = "SELECT id, nombre, apellido, apodo, fecha_nacimiento, genero, "
                   + "promedio_aciertos, promedio_desaciertos, numero_galletas, numero_estrellas, profesor "
                   + "FROM alumnos WHERE apodo = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, apodo);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    alumno = new AlumnoModelo();

                    // NOTA: Asegúrate de que tu AlumnoModelo tiene los setters correctos para INT y DOUBLE
                    alumno.setId_Alumno(rs.getInt("id"));
                    alumno.setNombre(rs.getString("nombre"));
                    alumno.setApellido(rs.getString("apellido"));
                    alumno.setApodo(rs.getString("apodo"));
                    alumno.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                    alumno.setGenero(rs.getString("genero")); // ✅ Usa String aquí
                    alumno.setPromedioAciertos(rs.getDouble("promedio_aciertos")); // Usa double
                    alumno.setPromedioDesaciertos(rs.getDouble("promedio_desaciertos")); // Usa double
                    alumno.setNumeroGalletas(rs.getInt("numero_galletas")); // Usa int
                    alumno.setNumeroEstrella(rs.getInt("numero_estrellas")); // Usa int
                    alumno.setProfesor(rs.getString("profesor"));
                }
            }
        } catch (SQLException e) {
            System.err.println("ERROR al obtener alumno por apodo: " + e.getMessage());
        }
        return alumno;
    }
    
    //se le pasa el campo que se decea modificar.
    // todo se puede modificar exepto el id.
    private boolean modificarCampoAlumno(String campo, String nuevoValor, String apodo) {
        // Construccion de la sentencia UPDATE
        String sql = "UPDATE alumnos SET " + campo + " = ? WHERE apodo = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoValor); 
            ps.setString(2, apodo);      

            int filasAfectadas = ps.executeUpdate();
            // si la fila se modifico es true 
            return filasAfectadas > 0;

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
        // Pasa el String correcto ("M", "F", o "O")
        return modificarCampoAlumno("genero", nuevoGenero, apodo); 
    }
    
    // hay que probar esto bien.
    public boolean modificarApodo(String nuevoApodo, String apodoActual) {    
        try {
            //verificamos si el apodo existe.
            if (verificarUnicidadApodoBD(nuevoApodo)) {
                // Si devuelve TRUE, significa que el apodo ya existe.
                System.err.println("El apodo '" + nuevoApodo + "' ya esta en uso. Modificación cancelada.");
                return false;
            }
        } catch (SQLException e) {
            // Si hay un error de conexión o SQL durante la verificación.
            System.err.println("Error de BDT durante la verificación de unicidad: " + e.getMessage());
            return false;
        }

        // 2. Si llegamos aquí, el nuevo apodo es ÚNICO y procedemos a la modificación (UPDATE).
        String sql = "UPDATE alumnos SET apodo = ? WHERE apodo = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoApodo);  // El nuevo valor a guardar
            ps.setString(2, apodoActual); // El filtro para saber que alumno cambiar

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("ERROR al modificar el apodo: " + e.getMessage());
            return false;
        }
    }

    
    // eliminar.
    public boolean eliminarAlumnoPorApodo(String apodo) {
        // La sentencia DELETE elimina filas basadas en una condicion WHERE que en este caso sera el apodo .
        String sql = "DELETE FROM alumnos WHERE apodo = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            //Asignamos el apodo para la clausula WHERE.
            // Esto asegura que solo se elimine el alumno con ese apodo.
            ps.setString(1, apodo);

            //Ejecutamos la eliminacion.
            int filasAfectadas = ps.executeUpdate();

            // Retorna true si se eliminó exactamente una fila (que es lo esperado).
            return filasAfectadas > 0; 

        } catch (SQLException e) {
            System.err.println("ERROR al eliminar alumno con apodo '" + apodo + "': " + e.getMessage());
            // En caso de error de conexion.
            return false;
        }
    }
}
