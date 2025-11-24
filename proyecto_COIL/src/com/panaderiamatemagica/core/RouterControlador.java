/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.core;
import com.panaderiamatemagica.Dimension.modelo.DimensionModelo;
import com.panaderiamatemagica.admin.controlador.RouterAdminControlador;
import com.panaderiamatemagica.admin.vista.AdminVista;
import com.panaderiamatemagica.autenticacion.controladores.alumnos.RouterRolControlador;
import com.panaderiamatemagica.autenticacion.controladores.alumnos.RouterRolControlador;
import com.panaderiamatemagica.autenticacion.modelo.AdministradorModelo;
import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionAdminVista;
import com.panaderiamatemagica.core.visual.PantallaPrincipalVista;
import com.panaderiamatemagica.core.visual.PantallaInicioVista;
import com.panaderiamatemagica.autenticacion.vista.PantallaAutenticacionVista;
import com.panaderiamatemagica.autenticacion.vista.SeleccionPanaderoVista;
import com.panaderiamatemagica.autenticacion.vista.SeleccionRolVista;
import com.panaderiamatemagica.ejercicios.modelo.EjercicioModelo;
import com.panaderiamatemagica.juego.controlador.RouterDimensionControlador;
import com.panaderiamatemagica.juego.vista.Dimension1Vista;
import com.panaderiamatemagica.juego.vista.EjercicioVista;
import com.panaderiamatemagica.juego.vista.ResultadoVista;
import com.panaderiamatemagica.juego.vista.SeleccionDimensionVista;
import java.util.ArrayList;
import java.util.Arrays;
//
/**
 *
 * @author user
 */
public class RouterControlador {
    
    // LISTAS GLOBALES.
    private ArrayList<AlumnoModelo> listaAlumnos = new ArrayList<>();
    private ArrayList<AdministradorModelo> listaProfesores = new ArrayList<>();
    // RouterControlador.java
    
    //LISTAS DE EJERCICIOS.
    private ArrayList<EjercicioModelo> listaejercicios_1 = new ArrayList<>();
    
    // LISTA DE NIVELES
    private ArrayList<ArrayList<EjercicioModelo>> niveles = new ArrayList<>();
    
    //Se crean instancias de las clases pantallas
    private PantallaPrincipalVista pantallaPrincipal;
    private PantallaInicioVista pantallaInicio;
    private PantallaAutenticacionVista pantallaAutenticacion;
    private SeleccionRolVista pantallaSeleccionRol;
    private RouterRolControlador routerRol;
    private InicioSesionAdminVista pantallaInicioSesionAdmin;
    private SeleccionPanaderoVista pantallaSeleccionPanadero;
    private AdminVista pantallaAdmin;
    private SeleccionDimensionVista pantallaSeleccionDimension;
    private EjercicioVista pantallaEjercicio;
    private ResultadoVista pantallaResultado;
    private RouterAdminControlador routerAdmin;
    private RouterDimensionControlador routerDimension;
            
    public RouterControlador(){

        
        // --- NUEVA CARGA: ALUMNO POR DEFECTO ---
        AlumnoModelo alumnoDefecto = new AlumnoModelo();
        alumnoDefecto.setNombre("loco"); //nombre
        alumnoDefecto.setApodo("12345"); // Identificador o nombre de usuario
        listaAlumnos.add(alumnoDefecto);
        
        // --- 1. CARGA DEL ADMINISTRADOR POR DEFECTO ---
        AdministradorModelo adminDefecto = new AdministradorModelo();
        adminDefecto.setNombreUsuario("admin123"); 
        adminDefecto.setContraseña("12345");
        listaProfesores.add(adminDefecto);
        
        // ------------------------------------------------------------------
        // --- 2. CARGA DE 3 EJERCICIOS DE PRUEBA MANUALES ---
        // ------------------------------------------------------------------
        
        // --- EJERCICIO 1: Suma Básica (5 + 3 = 8) ---
        EjercicioModelo ejercicio1 = new EjercicioModelo();
        ejercicio1.setDescripcion("Suma de ingredientes");
        ejercicio1.setPregunta("Tienes 5 huevos y compras 3 más, ¿cuántos tienes?");
        ejercicio1.setOpcionesRespuestas(new ArrayList<>(Arrays.asList("7", "8", "10", "5")));
        ejercicio1.setNumRespuesta(1); 
        listaejercicios_1.add(ejercicio1);

        // --- EJERCICIO 2: Resta Básica (12 - 4 = 8) ---
        EjercicioModelo ejercicio2 = new EjercicioModelo();
        ejercicio2.setDescripcion("Control de inventario");
        ejercicio2.setPregunta("Horneaste 12 panecillos y vendiste 4. ¿Cuantos te quedan?");
        ejercicio2.setOpcionesRespuestas(new ArrayList<>(Arrays.asList("9", "6", "8", "4")));
        ejercicio2.setNumRespuesta(2); 
        listaejercicios_1.add(ejercicio2);
        
        // --- EJERCICIO 3: Multiplicación (3 x 6 = 18) ---
        EjercicioModelo ejercicio3 = new EjercicioModelo();
        ejercicio3.setDescripcion("Produccion diaria");
        ejercicio3.setPregunta("Cada bandeja lleva 6 galletas. Si llenas 3 bandejas, ¿cuantas galletas haces?");
        ejercicio3.setOpcionesRespuestas(new ArrayList<>(Arrays.asList("12", "18", "24", "15")));
        ejercicio3.setNumRespuesta(1); 
        listaejercicios_1.add(ejercicio3);
        
        // ------------------------------------------------------------------
        // --- 3. INICIALIZACIoN DE VISTAS Y CONTROLADORES ---
        // ------------------------------------------------------------------
        
        // ------------------------------------------------------------------
        // --- CARGA DE EJERCICIOS Y ORGANIZACIÓN EN NIVELES ---
        // ------------------------------------------------------------------
        // 2. Cargando niveles.
        // --- 2.1 Creación de Ejercicios Manuales ---

        // --- EJERCICIO 1: Suma Basica (5 + 3 = 8) ---
        EjercicioModelo ejercicio1_1 = new EjercicioModelo();
        ejercicio1_1.setDescripcion("Suma de ingredientes");
        ejercicio1_1.setPregunta("Tienes 5 huevos y compras 3 mas, ¿cuantos tienes?");
        ejercicio1_1.setOpcionesRespuestas(new ArrayList<>(Arrays.asList("7", "8", "10", "5")));
        ejercicio1_1.setNumRespuesta(1); 
        // Nota: Ya no es necesario listaejercicios_1.add(ejercicio1);

        // --- EJERCICIO 2: Resta Basica (12 - 4 = 8) ---
        EjercicioModelo ejercicio1_2 = new EjercicioModelo();
        ejercicio1_2.setDescripcion("Control de inventario");
        ejercicio1_2.setPregunta("Horneaste 12 panecillos y vendiste 4. ¿Cuantos te quedan?");
        ejercicio1_2.setOpcionesRespuestas(new ArrayList<>(Arrays.asList("9", "6", "8", "4")));
        ejercicio1_2.setNumRespuesta(2); 
        // Nota: Ya no es necesario listaejercicios_1.add(ejercicio2);

        // --- EJERCICIO 3: Multiplicación (3 x 6 = 18) ---
        EjercicioModelo ejercicio1_3 = new EjercicioModelo();
        ejercicio1_3.setDescripcion("Produccion diaria");
        ejercicio1_3.setPregunta("Cada bandeja lleva 6 galletas. Si llenas 3 bandejas, ¿cusntas galletas haces?");
        ejercicio1_3.setOpcionesRespuestas(new ArrayList<>(Arrays.asList("12", "18", "24", "15")));
        ejercicio1_3.setNumRespuesta(1); 

        // --- 2.2 Organizacion de Ejercicios en el Nivel unico ---

        // Nivel 1: Contiene los 3 ejercicios de prueba
        ArrayList<EjercicioModelo> nivel1 = new ArrayList<>();
        nivel1.add(ejercicio1);
        nivel1.add(ejercicio2);
        nivel1.add(ejercicio3);

        // Añadimos el Nivel 1 a la lista principal de niveles (niveles)
        this.niveles.add(nivel1);

        // para que funcione los tres niveles se deve implementar esto.
        // con sus ejercicios.
        /*
        ArrayList<EjercicioModelo> nivel2 = new ArrayList<>();
        this.niveles.add(nivel2); 
        ArrayList<EjercicioModelo> nivel3 = new ArrayList<>();
        this.niveles.add(nivel3);
        */

        
        
        pantallaPrincipal = new PantallaPrincipalVista();
        routerRol = new RouterRolControlador(this);
        routerAdmin = new RouterAdminControlador(this);
        routerDimension = new RouterDimensionControlador(this);
        
        //Se crean instancias de diferentes JPanel, y se pasa de argumento 'this' 
        //porque eso pasa como argumento la clase actual(RouterControlador).
        pantallaInicio = new PantallaInicioVista(this);
        pantallaAutenticacion = routerRol.getPantallaAutenticacion();
        pantallaSeleccionRol = new SeleccionRolVista(this);
        pantallaInicioSesionAdmin = new InicioSesionAdminVista(this);
        pantallaSeleccionPanadero = new SeleccionPanaderoVista(this);
        pantallaAdmin = routerAdmin.getPantallaAdmin();
        pantallaSeleccionDimension = routerDimension.getSeleccionDimensionViste();
        pantallaEjercicio = new EjercicioVista(this);
        pantallaResultado = new ResultadoVista(this);
        inicializarPaneles();
        pantallaPrincipal.setVisible(true);
    }
    private void inicializarPaneles(){
        /*---------------------------------------
        Se inicializan todos los paneles dentro del JFrame principal para que
        actúe como un monitor
        */
        
        pantallaPrincipal.agregarPanel(pantallaInicio, "INICIO");
        pantallaPrincipal.agregarPanel(pantallaAutenticacion, "AUTENTICACION");
        pantallaPrincipal.agregarPanel(pantallaSeleccionRol, "ROL");
        pantallaPrincipal.agregarPanel(pantallaInicioSesionAdmin, "SESION ADMIN");
        pantallaPrincipal.agregarPanel(pantallaSeleccionPanadero, "PANADEROS");
        pantallaPrincipal.agregarPanel(pantallaAdmin, "ADMIN");
        pantallaPrincipal.agregarPanel(pantallaSeleccionDimension, "SELECCION DIMENSION");
        pantallaPrincipal.agregarPanel(pantallaEjercicio, "EJERCICIO");
        pantallaPrincipal.agregarPanel(pantallaResultado, "RESULTADO");
        pantallaPrincipal.mostrarPanel("INICIO");
    }
     public void mostrarInicioVista() {
        pantallaPrincipal.mostrarPanel("INICIO");
    }
    
    public void mostrarAutenticacionVista() {
        pantallaPrincipal.mostrarPanel("AUTENTICACION");
    }
    public void mostrarSeleccionRolVista() {
        pantallaPrincipal.mostrarPanel("ROL");
}
    public void mostrarInicioSesionAdminVista(){
        pantallaPrincipal.mostrarPanel("SESION ADMIN");
    }
    public void mostrarSeleccionPanaderoVista(){
        pantallaPrincipal.mostrarPanel("PANADEROS");
    }
    public void mostrarAdminVista(){
        pantallaPrincipal.mostrarPanel("ADMIN");
    }
    public void mostrarSeleccionDimensionVista(){
        pantallaPrincipal.mostrarPanel("SELECCION DIMENSION");
    }
    public void mostrarEjercicioVista(){
        pantallaPrincipal.mostrarPanel("EJERCICIO");
    }
    public void mostrarResultadoVista(){
        pantallaPrincipal.mostrarPanel("RESULTADO");
    }
    
    // get de las listas globales
    public ArrayList<AlumnoModelo> getListaAlumnos() {
        return listaAlumnos;
    }
    public ArrayList<AdministradorModelo> getListaProfesores() {
        return listaProfesores;
    }

    public ArrayList<EjercicioModelo> getListaejercicios_1() {
        return listaejercicios_1;
    }
    // lista de niveles.
    public ArrayList<ArrayList<EjercicioModelo>> getNiveles() {
        return niveles;
    }
    
    public void iniciarDimension1() {
        // 1. Crear o recuperar el modelo para esta dimensión
        // (Asumimos que el modelo puede ser simple si no tienes datos guardados).
        DimensionModelo modeloDimen1 = new DimensionModelo(); 

        // 2. Obtener la instancia específica de Dimension1Vista del RouterDimensionControlador
        // Nota: Esto requiere que routerDimension tenga el método getPantallaDimension1() (ver punto 3).
        Dimension1Vista vistaDimension1 = routerDimension.getPantallaDimension1();

        // 💥 3. ¡EL PASO CLAVE! Inicializar la vista, forzando la creación del DimensionControlador
        // Aquí se inyectan todas las dependencias (Router, Modelo, y Niveles).
        // Nota: Esto requiere que Dimension1Vista tenga el método inicializarDimension() (ver punto 4).
        vistaDimension1.inicializarDimension(this, modeloDimen1, this.getNiveles());

        // 4. Mostrar la vista en el panel principal
        routerDimension.mostrarDimension1Vista();
    }
    
    
    
    /**
 * Recibe una lista de ejercicios (un Nivel) y prepara el entorno de juego.
 */
    public void iniciarJuegoConEjercicios(ArrayList<EjercicioModelo> ejercicios) {

        // 1. Carga la lista en la variable global para que el controlador pueda acceder a ella.
        this.listaejercicios_1 = ejercicios; 

        // 2. Llama al método de la vista, que a su vez llama al controlador para iniciar el juego.
        pantallaEjercicio.iniciarNuevoNivel(); 

        // Nota: mostrarEjercicioVista() no es estrictamente necesario aquí, ya que 
        // iniciarNuevoNivel (via avanzarYMostrarSiguienteEjercicio) llama a router.mostrarEjercicioVista().
        // Pero puedes dejarlo como capa de seguridad si quieres.
        // mostrarEjercicioVista(); 
    }
}
