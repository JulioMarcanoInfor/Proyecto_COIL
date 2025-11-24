package com.panaderiamatemagica.autenticacion.controladores.administradores;

import com.panaderiamatemagica.admin.vista.CrearNuevoAdminVista;
import com.panaderiamatemagica.autenticacion.modelo.AdministradorModelo;
import com.panaderiamatemagica.core.dao.AdministradorDAO; // Importamos el DAO
import Utilidades.Validacion;
import java.sql.SQLException; // Para manejar errores del DAO
import java.util.ArrayList;
import javax.swing.JOptionPane;
// import javax.xml.validation.Validator; // Generalmente no es necesario

/**
 *
 * @author Equipo Dell
 */
public class AdministradorControladorCrearAdmin {
    
    private CrearNuevoAdminVista vista;
    private AdministradorDAO adminDAO; // instancia del dao 
    // ya no se usa.
    //private ArrayList<AdministradorModelo> listaAdministradores; 

    // Constructor.
    public AdministradorControladorCrearAdmin(CrearNuevoAdminVista vista) {
        this.vista = vista;
        //this.listaAdministradores = listaAdministradores;
        this.adminDAO = new AdministradorDAO(); // Inicializar el DAO
    }
    
    // para las validaciones genericas
    Validacion validar = new Validacion();
    
    // ... (El método validarParamentros() se mantiene igual y es correcto) ...
    
    public boolean validarParamentros(){
        // --- 1. Validacion de nombre usuario. ---
        int resultadoNombre = validar.validarCadena(vista.getTxtusuario(),
                // PENDIENTE: El patrón para el usuario debe ser más flexible que solo letras.
                // Recomiendo usar un patrón que admita letras, números, y quizás guiones/puntos.
                "^[a-zA-Z0-9._-]{3,12}$", 3, 12); 
        
        // ... (El switch-case para el nombre de usuario permanece igual) ...
        switch (resultadoNombre) {
            case 0:
                JOptionPane.showMessageDialog(vista, "Ups El Nombre de usuario no puede estar vacío.", "MENSAJE DE ERROR: CAMPO VACÍO", JOptionPane.ERROR_MESSAGE);
                return false; 
            case -2:
                JOptionPane.showMessageDialog(vista, "Ups La longitud del Nombre de usuario debe tener entre 3 y 12 caracteres.", "MENSAJE DE ERROR: LONGITUD NO VÁLIDA", JOptionPane.ERROR_MESSAGE);
                return false;  
            case -1:
                JOptionPane.showMessageDialog(vista, "Ups El Nombre de usuario solo puede contener letras, números, puntos, guiones bajos o medios.", "MENSAJE DE ERROR: FORMATO INCORRECTO", JOptionPane.ERROR_MESSAGE);
                return false; 
            case 1:
                break;
        }

        // --- 2. Vaidacion de contraseña. ---
        int resultadoContrasenna = validar.validarCadena(vista.getTxtcontrasenna(),
                // PENDIENTE: El patrón para contraseña debe ser más seguro (admitir símbolos)
                // Usaré un patrón flexible para no romper tu lógica actual, pero es recomendable cambiarlo.
                
                // el patron que tenia antes mente daba error no se por que.
                "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ!@#$%^&*()\\\\-_+=]{5,12}$", 5, 12);

        // ... (El switch-case para la contraseña permanece igual) ...
        switch (resultadoContrasenna) {
            case 0:
                JOptionPane.showMessageDialog(vista, "Ups La contraseña no puede estar vacía.", "MENSAJE DE ERROR: CAMPO VACIO", JOptionPane.ERROR_MESSAGE);
                return false;
            case -2:
                JOptionPane.showMessageDialog(vista, "Ups La longitud de la Contraseña no es válida. Debe tener entre 5 y 12 caracteres.", "MENSAJE DE ERROR: LONGITUD NO VÁLIDA", JOptionPane.ERROR_MESSAGE);
                return false;
            case -1:
                JOptionPane.showMessageDialog(vista, "Ups La contraseña contiene caracteres no permitidos.", "MENSAJE DE ERROR: FORMATO INCORRECTO", JOptionPane.ERROR_MESSAGE);
                return false;
            case 1:
                break;
        }
        //si llega aqui es porque todo esta correcto
        return true;
    }

    /*
     * Lógica para crear un administrador: 
     * 1. Valida los parametros usando validarParamentros().
     * 2. Verifica la unicidad del usuario en la BDT.
     * 3. Inserta el administrador en la BDT.
     */
    public void crearAdministrador(){
        // 1. Validar los parámetros
        if (!validarParamentros()) {
            return; // Detiene la ejecución si la validación falla
        }
        
        // 2. Crear el objeto Modelo con los datos de la Vista
        AdministradorModelo nuevoAdmin = new AdministradorModelo();
        nuevoAdmin.setNombreUsuario(vista.getTxtusuario());
        nuevoAdmin.setContraseña(vista.getTxtcontrasenna());
        
        try {
            // 3. Verificar Unicidad del Usuario en la BDT
            if (adminDAO.verificarUnicidadUsuarioBD(nuevoAdmin.getNombreUsuario())) {
                JOptionPane.showMessageDialog(vista, 
                    "Los datos que colocó (Usuario) ya están registrados. Use uno diferente.",
                    "MENSAJE DE ERROR: DATOS EXISTENTES", JOptionPane.ERROR_MESSAGE);
                return; // Detener la ejecución
            }

            // 4. Insertar en la BDT
            boolean insercionExitosa = adminDAO.insertarAdministrador(nuevoAdmin);

            if (insercionExitosa) {
                JOptionPane.showMessageDialog(vista, 
                    "El nuevo administrador se agregó correctamente.",
                    "EXITOS:>>", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Esto podría ser un fallo de conexión o SQL
                JOptionPane.showMessageDialog(vista, 
                    "Fallo al registrar el administrador. Consulte el log para detalles.",
                    "ERROR DE REGISTRO", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            // Error durante la verificación de unicidad (fallo de BDT)
            System.err.println("Error grave de conexión al verificar o insertar: " + e.getMessage());
            JOptionPane.showMessageDialog(vista, 
                    "Error crítico de conexión con la base de datos.",
                    "ERROR CRÍTICO", JOptionPane.ERROR_MESSAGE);
        }
    }
}