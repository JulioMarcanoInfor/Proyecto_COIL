/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.core;

import com.panaderiamatemagica.Dimension.modelo.DimensionModelo;
import com.panaderiamatemagica.admin.controlador.RouterAdminControlador;
import com.panaderiamatemagica.admin.vista.AdminVista;
import com.panaderiamatemagica.autenticacion.controladores.alumnos.RouterAutenticacionControlador;
import com.panaderiamatemagica.autenticacion.controladores.alumnos.RouterRolControlador;
import com.panaderiamatemagica.autenticacion.modelo.AdministradorModelo;
import com.panaderiamatemagica.autenticacion.modelo.AlumnoModelo;
import com.panaderiamatemagica.autenticacion.vista.FondoAutenticacionVista;
import com.panaderiamatemagica.autenticacion.vista.InicioSesionAdminVista;
import com.panaderiamatemagica.core.visual.PantallaPrincipalVista;
import com.panaderiamatemagica.core.visual.PantallaInicioVista;
import com.panaderiamatemagica.autenticacion.vista.PantallaAutenticacionVista;
import com.panaderiamatemagica.autenticacion.vista.SeleccionPanaderoVista;
import com.panaderiamatemagica.autenticacion.vista.SeleccionRolVista;
import com.panaderiamatemagica.ejercicios.modelo.EjercicioModelo;
import com.panaderiamatemagica.juego.controlador.RouterDimensionControlador;
import com.panaderiamatemagica.juego.vista.Dimension1Vista;
import com.panaderiamatemagica.juego.vista.Dimension2Vista;
import com.panaderiamatemagica.juego.vista.Dimension3Vista;
import com.panaderiamatemagica.juego.vista.Dimension4Vista;
import com.panaderiamatemagica.juego.vista.Dimension5Vista;
import com.panaderiamatemagica.juego.vista.EjercicioVista;
import com.panaderiamatemagica.juego.vista.ResultadoVista;
import com.panaderiamatemagica.juego.vista.SeleccionDimensionVista;
import com.panaderiamatemagica.core.dao.EjercicioDAO;
import com.panaderiamatemagica.core.dao.NivelDAO;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class RouterControlador {

    // LISTAS GLOBALES.
    private ArrayList<AlumnoModelo> listaAlumnos = new ArrayList<>();
    private ArrayList<AdministradorModelo> listaProfesores = new ArrayList<>();

    // LISTAS DE EJERCICIOS.
    private ArrayList<EjercicioModelo> listaejercicios_1 = new ArrayList<>();

    // LISTA DE NIVELES
    private ArrayList<ArrayList<EjercicioModelo>> niveles = new ArrayList<>();

    // DAOs
    private EjercicioDAO ejercicioDAO = new EjercicioDAO();
    private NivelDAO nivelDAO = new NivelDAO();

    // Se crean instancias de las clases pantallas
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
    private FondoAutenticacionVista fondoAutenticacion;
    private RouterAutenticacionControlador routerAuth;

    public RouterControlador() {

        // --- NUEVA CARGA: ALUMNO POR DEFECTO ---
        AlumnoModelo alumnoDefecto = new AlumnoModelo();
        alumnoDefecto.setNombre("loco"); // nombre
        alumnoDefecto.setApodo("12345"); // Identificador o nombre de usuario
        listaAlumnos.add(alumnoDefecto);

        // --- 1. CARGA DEL ADMINISTRADOR POR DEFECTO ---
        AdministradorModelo adminDefecto = new AdministradorModelo();
        adminDefecto.setNombreUsuario("admin123");
        adminDefecto.setContraseña("12345");
        listaProfesores.add(adminDefecto);

        // ------------------------------------------------------------------
        // --- 3. INICIALIZACIoN DE VISTAS Y CONTROLADORES ---
        // ------------------------------------------------------------------

        pantallaPrincipal = new PantallaPrincipalVista();
        routerRol = new RouterRolControlador(this);
        routerAdmin = new RouterAdminControlador(this);
        routerDimension = new RouterDimensionControlador(this);
        routerAuth = new RouterAutenticacionControlador(this);

        // Se crean instancias de diferentes JPanel, y se pasa de argumento 'this'
        // porque eso pasa como argumento la clase actual(RouterControlador).

        pantallaInicio = new PantallaInicioVista(this);
        pantallaAutenticacion = routerRol.getPantallaAutenticacion();
        pantallaInicioSesionAdmin = new InicioSesionAdminVista(this);
        pantallaSeleccionPanadero = new SeleccionPanaderoVista(this);
        pantallaAdmin = routerAdmin.getPantallaAdmin();
        pantallaSeleccionDimension = routerDimension.getSeleccionDimensionViste();
        pantallaEjercicio = new EjercicioVista(this);
        pantallaResultado = new ResultadoVista(this);
        fondoAutenticacion = routerAuth.getFondoAutenticacion();

        inicializarPaneles();
        pantallaPrincipal.setVisible(true);
        pantallaPrincipal.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    private void inicializarPaneles() {
        /*---------------------------------------
        Se inicializan todos los paneles dentro del JFrame principal para que
        actúe como un monitor
        */

        pantallaPrincipal.agregarPanel(pantallaInicio, "INICIO");
        pantallaPrincipal.agregarPanel(pantallaAutenticacion, "AUTENTICACION");
        pantallaPrincipal.agregarPanel(pantallaInicioSesionAdmin, "SESION ADMIN");
        pantallaPrincipal.agregarPanel(pantallaSeleccionPanadero, "PANADEROS");
        pantallaPrincipal.agregarPanel(pantallaAdmin, "ADMIN");
        pantallaPrincipal.agregarPanel(pantallaSeleccionDimension, "SELECCION DIMENSION");
        pantallaPrincipal.agregarPanel(pantallaEjercicio, "EJERCICIO");
        pantallaPrincipal.agregarPanel(pantallaResultado, "RESULTADO");
        pantallaPrincipal.agregarPanel(fondoAutenticacion, "FONDO AUTH");
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

    public void mostrarInicioSesionAdminVista() {
        pantallaPrincipal.mostrarPanel("SESION ADMIN");
    }

    public void mostrarSeleccionPanaderoVista() {
        pantallaPrincipal.mostrarPanel("PANADEROS");
    }

    public void mostrarAdminVista() {
        pantallaPrincipal.mostrarPanel("ADMIN");
    }

    public void mostrarSeleccionDimensionVista() {
        pantallaPrincipal.mostrarPanel("SELECCION DIMENSION");
    }

    public void mostrarEjercicioVista() {
        pantallaPrincipal.mostrarPanel("EJERCICIO");
    }

    public void mostrarResultadoVista() {
        pantallaPrincipal.mostrarPanel("RESULTADO");
    }

    public void mostrarFondoAutenticacionVista() {
        pantallaPrincipal.mostrarPanel("FONDO AUTH");
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

    public void cargarNivelesDimension(int idDimension) {
        this.niveles.clear();
        ArrayList<Integer> idsNiveles = nivelDAO.obtenerIdsNivelesPorDimension(idDimension);

        System.out.println("IDs de niveles obtenidos: " + idsNiveles);

        for (int idNivel : idsNiveles) {
            ArrayList<EjercicioModelo> ejercicios = ejercicioDAO.obtenerEjerciciosPorNivel(idNivel);
            System.out.println("Nivel " + idNivel + ": " + ejercicios.size() + " ejercicios");
            this.niveles.add(ejercicios);
        }
        System.out.println("Cargados " + this.niveles.size() + " niveles para la dimension " + idDimension);
    }

    public void iniciarDimension1() {
        cargarNivelesDimension(1);
        DimensionModelo modelo = new DimensionModelo();
        modelo.setNiveles(this.niveles);
        Dimension1Vista vista = routerDimension.getPantallaDimension1();
        vista.inicializarDimension(this, modelo, this.getNiveles());
        routerDimension.mostrarDimension1Vista();
    }

    public void iniciarDimension2() {
        cargarNivelesDimension(2);
        DimensionModelo modelo = new DimensionModelo();
        modelo.setNiveles(this.niveles);
        Dimension2Vista vista = routerDimension.getPantallaDimension2();
        vista.inicializarDimension(this, modelo, this.getNiveles());
        routerDimension.mostrarDimension2Vista();
    }

    public void iniciarDimension3() {
        cargarNivelesDimension(3);
        DimensionModelo modelo = new DimensionModelo();
        modelo.setNiveles(this.niveles);
        Dimension3Vista vista = routerDimension.getPantallaDimension3();
        vista.inicializarDimension(this, modelo, this.getNiveles());
        routerDimension.mostrarDimension3Vista();
    }

    public void iniciarDimension4() {
        cargarNivelesDimension(4);
        DimensionModelo modelo = new DimensionModelo();
        modelo.setNiveles(this.niveles);
        Dimension4Vista vista = routerDimension.getPantallaDimension4();
        vista.inicializarDimension(this, modelo, this.getNiveles());
        routerDimension.mostrarDimension4Vista();
    }

    public void iniciarDimension5() {
        cargarNivelesDimension(5);
        DimensionModelo modelo = new DimensionModelo();
        modelo.setNiveles(this.niveles);
        Dimension5Vista vista = routerDimension.getPantallaDimension5();
        vista.inicializarDimension(this, modelo, this.getNiveles());
        routerDimension.mostrarDimension5Vista();
    }

    /**
     * Recibe una lista de ejercicios (un Nivel) y prepara el entorno de juego.
     */
    public void iniciarJuegoConEjercicios(ArrayList<EjercicioModelo> ejercicios) {
        // 1. Carga la lista en la variable global para que el controlador pueda acceder
        // a ella.
        this.listaejercicios_1 = ejercicios;

        // 2. Llama al método de la vista, que a su vez llama al controlador para
        // iniciar el juego.
        pantallaEjercicio.iniciarNuevoNivel();
    }
}
