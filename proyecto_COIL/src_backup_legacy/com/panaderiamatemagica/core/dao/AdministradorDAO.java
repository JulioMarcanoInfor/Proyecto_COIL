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
import com.panaderiamatemagica.autenticacion.modelo.AdministradorModelo;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author Equipo Dell
 */
public class AdministradorDAO {
        
    // mostar 
        // funcion central 
    public void EjecutarYMostrarAdministradores(JTable vista, String filtro){
        System.out.println("Intentando obtener la conexión...");
        try (Connection conn = ConexionBDT.obtenerConexion()){
            if(conn != null){
                System.out.println("CONEXION ESTABLECIDA.");
            }
            
            // tabla donde se mostraran los datos
            DefaultTableModel modelo = new DefaultTableModel();
            
            // La consulta base siempre filtra por profesor.
            String sql = "SELECT * FROM administradores";
            
            // Concatenamos el filtro adicional (ORDER BY o más condiciones WHERE)// para mostra en un orden determinado.
            sql += filtro;
            
            // para ver lo que se le paso a la BDT
            System.out.println("SQL: " + sql);
                    
             // Definición de las 7 columnas
            modelo.addColumn("ID: ");
            modelo.addColumn("Usuario: ");
            // modelo.addColumn("Contraseña: "); no la mostraremos a los demas administradores
            modelo.addColumn("Nombre: ");
            modelo.addColumn("Apellido: ");
            modelo.addColumn("genero: ");
            modelo.addColumn("Fecha nacimiento: ");
            modelo.addColumn("Institucion: ");

            // contendra los datos.
            String datos[] = new String[7];
            
            // obtenemo los datos de la BDT.
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                // Asignacion de las 7 columnas 
                datos[0] = rs.getString(1); // administrador_id
                datos[1] = rs.getString(2); // usuario
                // Columna 3 (contrasena) se salta.
                datos[2] = rs.getString(4); // nombre
                datos[3] = rs.getString(5); // apellido
                datos[4] = rs.getString(6); // genero
                datos[5] = rs.getString(7); // fecha_nacimiento
                datos[6] = rs.getString(8); // institucion.

                modelo.addRow(datos); 
            }
            
            // lo colocamos en la vista.
            vista.setModel(modelo);

            
        } catch (Exception e) {
            System.err.println("ERROR: La conexión o la consulta falló.");
            System.err.println("Detalles: " + e.getMessage());
        }
    }
    
        // Muestra todos los administradores (sin filtro)
    public void MostrarTodosAdministradores(JTable vista){
        EjecutarYMostrarAdministradores(vista, "");
    }
    
        // Muestra administradores filtrados por institución
    public void MostrarAdministradoresPorInstitucion(JTable vista, String institucion){
        // Usamos WHERE para filtrar
        String filtro = " WHERE institucion = '" + institucion + "'";
        EjecutarYMostrarAdministradores(vista, filtro);
    }
    
    
    // verifica que el usuario sea unico.
    public boolean verificarUnicidadUsuarioBD(String nombreUsuario) throws SQLException {
        // Usamos la columna 'usuario'
        String sql = "SELECT COUNT(*) FROM administradores WHERE usuario = ?"; 

        try (Connection conn = ConexionBDT.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombreUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Si COUNT(*) es 1 o más, significa que el usuario ya existe.
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false; 
    }
    
    //para verificar el inicio cecion del administrador.
    //tambien se usara para obtner un admin en especifico para relizar modificaciones.
    public AdministradorModelo autenticarAdministrador(String nombreUsuario, String password) {
        AdministradorModelo admin = null;

        // Seleccionamos todos los campos necesarios. Usamos 'usuario' y 'contrasena' para el filtro.
        String sql = "SELECT administrador_id, nombre, apellido, usuario, genero, fecha_nacimiento, institucion "
                   + "FROM administradores WHERE usuario = ? AND contrasena = ?"; 

        try (Connection conn = ConexionBDT.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombreUsuario);
            ps.setString(2, password); 

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Si la consulta devuelve una fila, el login es exitoso.
                    admin = new AdministradorModelo();

                    // Carga de datos usando los nombres de columna exactos:
                    admin.setId_Administrador(rs.getInt("administrador_id"));
                    admin.setNombreUsuario(rs.getString("usuario"));
                    admin.setNombre(rs.getString("nombre"));
                    admin.setApellido(rs.getString("apellido"));
                    admin.setGenero(rs.getString("genero"));
                    admin.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                    admin.setInstitucion(rs.getString("institucion"));
                }
            }
        } catch (SQLException e) {
            System.err.println("ERROR en la autenticación: " + e.getMessage());
        }
        return admin;
    }
    
    //incertar
    // Recibe el objeto AdministradorModelo con los datos validados.
    public boolean insertarAdministrador(AdministradorModelo admin){
        // nos aseguramos de que las columnas coincidan con el esquema de la tabla administradores.
        // Incluye solo los campos que se van a llenar ahorita (excluyendo IDs autonumericos, nombre ,etc.)
        String sql = "INSERT INTO administradores (usuario,contrasena) "
                   + "VALUES (?, ?)";
        
        // mandamos la consuta a la BDT.
        try (Connection conn = ConexionBDT.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)){
            
             // 1. Asignar los valores del objeto AlumnoModelo a los marcadores (?)
            ps.setString(1, admin.getNombreUsuario());
            ps.setString(2, admin.getContraseña());
            // las demas cosas..
            
            // 3. Ejecutamos la insercion en la bdt
            int filasAfectadas = ps.executeUpdate();
            
            return filasAfectadas > 0; // Retorna true si se insertó al menos una fila.
            
            
        } catch (Exception e) {
            // no se como poner este tipo de mensajes si en patanlla o solo en terminal para 
            // la presnetacion porcia jajaj.
            System.err.println("ERROR al insertar el admin: " + e.getMessage());
            return false;
        }        
    }
    
     //se le pasa el campo que se decea modificar.
    // todo se puede modificar exepto el id.
    private boolean modificarCampoAdministrador(String campo, String nuevoValor, String usuarioActual) {
        // Construccion de la sentencia UPDATE
        String sql = "UPDATE administradores SET " + campo + " = ? WHERE usuario = ?";

        // Bloque try-with-resources para asegurar el cierre de recursos (Connection, PreparedStatement)
        try (Connection conn = ConexionBDT.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // 1. Establecer el nuevo valor
            ps.setString(1, nuevoValor); 
            // 2. Establecer el filtro (el usuario actual)
            ps.setString(2, usuarioActual);     

            int filasAfectadas = ps.executeUpdate();
            
            // si la fila se modificó es true
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("ERROR al modificar el campo '" + campo + "' del administrador: " + e.getMessage());
            return false;
        }
    }

    // modificar nombre.
    public boolean modificarNombre(String nuevoNombre, String usuarioActual) {
        return modificarCampoAdministrador("nombre", nuevoNombre, usuarioActual);
    }

    // modificar apelido 
    public boolean modificarApellido(String nuevoApellido, String usuarioActual) {
        return modificarCampoAdministrador("apellido", nuevoApellido, usuarioActual);
    }

    // modificar genero
    public boolean modificarGenero(String nuevoGenero, String usuarioActual) {
        // Pasa el String correcto ("M", "F", o "O")
        return modificarCampoAdministrador("genero", nuevoGenero, usuarioActual); 
    }
    
    // modificar contraceña.
    public boolean modificarContrasena(String nuevaContrasena, String usuarioActual) {
        return modificarCampoAdministrador("contrasena", nuevaContrasena, usuarioActual);
    }
    
    // modificar usuario.
    public boolean modificarUsuario(String nuevoUsuario, String usuarioActual) {    
        try {
            //Verificar si el nuevo usuario ya existe (unicidad).
            if (verificarUnicidadUsuarioBD(nuevoUsuario)) {
                // Si devuelve TRUE, significa que el usuario ya existe.
                System.err.println("El usuario '" + nuevoUsuario + "' ya esta en uso. Modificación cancelada.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error de BDT durante la verificación de unicidad: " + e.getMessage());
            return false;
        }

        //Si llegamos aquí, el nuevo usuario es unico y procedemos a la modificacion.
        // Usamos el metodo generico que ya maneja la conexión.
        return modificarCampoAdministrador("usuario", nuevoUsuario, usuarioActual);
    }
    
    //eiminar.
    public boolean eliminarAdministradorPorUsuario(String usuario) {
        // La sentencia DELETE elimina filas basadas en una condicion WHERE que en este caso sera el usuario .
        String sql = "DELETE FROM administradores WHERE usuario = ?";

        try (Connection conn = ConexionBDT.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            //Asignamos el usuario para la clausula WHERE.
            // Esto asegura que solo se elimine el alumno con ese apodo.
            ps.setString(1, usuario);

            //Ejecutamos la eliminacion.
            int filasAfectadas = ps.executeUpdate();

            // Retorna true si se elimino exactamente una fila (que es lo esperado).
            return filasAfectadas > 0; 

        } catch (SQLException e) {
            System.err.println("ERROR al eliminar administrador con apodo '" + usuario + "': " + e.getMessage());
            // En caso de error de conexion.
            return false;
        }
    }
}
