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
import com.panaderiamatemagica.juego.vista.SeleccionDimensionVista1;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author user
 */
public class RouterControlador {

    // LISTAS GLOBALES
    private ArrayList<AlumnoModelo> listaAlumnos = new ArrayList<>();
    private ArrayList<AdministradorModelo> listaProfesores = new ArrayList<>();

    // LISTAS DE EJERCICIOS
    private ArrayList<EjercicioModelo> listaejercicios_1 = new ArrayList<>();

    // LISTA DE NIVELES
    private ArrayList<ArrayList<EjercicioModelo>> niveles = new ArrayList<>();

    // Instancias de pantallas
    private PantallaPrincipalVista pantallaPrincipal;
    private PantallaInicioVista pantallaInicio;
    private RouterAutenticacionControlador routerAutenticacion;
    private InicioSesionAdminVista pantallaInicioSesionAdmin;
    private SeleccionPanaderoVista pantallaSeleccionPanadero;
    private AdminVista pantallaAdmin;
    private SeleccionDimensionVista1 pantallaSeleccionDimension1;
    private EjercicioVista pantallaEjercicio;
    private ResultadoVista pantallaResultado;
    private RouterAdminControlador routerAdmin;
    private RouterDimensionControlador routerDimension;
    private FondoAutenticacionVista fondoAutenticacion;
    private Dimension1Vista Dimension1;
    private RouterAutenticacionControlador routerAuth;

    // Alumno actualmente autenticado
    private AlumnoModelo alumnoActual;

    public RouterControlador() {

        // --- CARGA: ALUMNO POR DEFECTO ---
        AlumnoModelo alumnoDefecto = new AlumnoModelo();
        alumnoDefecto.setNombre("loco");
        alumnoDefecto.setApodo("12345");
        listaAlumnos.add(alumnoDefecto);

        // --- CARGA DEL ADMINISTRADOR POR DEFECTO ---
        AdministradorModelo adminDefecto = new AdministradorModelo();
        adminDefecto.setNombreUsuario("admin123");
        adminDefecto.setContraseña("12345");
        listaProfesores.add(adminDefecto);

        // --- CARGA DE 3 EJERCICIOS DE PRUEBA MANUALES ---

        // EJERCICIO 1: Suma Básica (5 + 3 = 8)
        EjercicioModelo ejercicio1 = new EjercicioModelo();
        ejercicio1.setDescripcion("Suma de ingredientes");
        ejercicio1.setPregunta("Tienes 5 huevos y compras 3 más, ¿cuántos tienes?");
        ejercicio1.setOpcionesRespuestas(new ArrayList<>(Arrays.asList("7", "8", "10", "5")));
        ejercicio1.setNumRespuesta(1);
        listaejercicios_1.add(ejercicio1);

        // EJERCICIO 2: Resta Básica (12 - 4 = 8)
        EjercicioModelo ejercicio2 = new EjercicioModelo();
        ejercicio2.setDescripcion("Control de inventario");
        ejercicio2.setPregunta("Horneaste 12 panecillos y vendiste 4. ¿Cuantos te quedan?");
        ejercicio2.setOpcionesRespuestas(new ArrayList<>(Arrays.asList("9", "6", "8", "4")));
        ejercicio2.setNumRespuesta(2);
        listaejercicios_1.add(ejercicio2);

        // EJERCICIO 3: Multiplicación (3 x 6 = 18)
        EjercicioModelo ejercicio3 = new EjercicioModelo();
        ejercicio3.setDescripcion("Produccion diaria");
        ejercicio3.setPregunta("Cada bandeja lleva 6 galletas. Si llenas 3 bandejas, ¿cuantas galletas haces?");
        ejercicio3.setOpcionesRespuestas(new ArrayList<>(Arrays.asList("12", "18", "24", "15")));
        ejercicio3.setNumRespuesta(1);
        listaejercicios_1.add(ejercicio3);

        // --- ORGANIZACIÓN EN NIVELES ---
        ArrayList<EjercicioModelo> nivel1 = new ArrayList<>();
        nivel1.add(ejercicio1);
        nivel1.add(ejercicio2);
        nivel1.add(ejercicio3);
        this.niveles.add(nivel1);

        // Inicializar pantallas y routers
        pantallaPrincipal = new PantallaPrincipalVista();
        routerAutenticacion = new RouterAutenticacionControlador(this);
        routerAdmin = new RouterAdminControlador(this);
        routerDimension = new RouterDimensionControlador(this);
        routerAuth = new RouterAutenticacionControlador(this);

        // Crear instancias de vistas
        pantallaInicio = new PantallaInicioVista(this);
        pantallaInicioSesionAdmin = new InicioSesionAdminVista(this);
        pantallaSeleccionPanadero = new SeleccionPanaderoVista(this);
        pantallaAdmin = routerAdmin.getPantallaAdmin();
        pantallaSeleccionDimension1 = new SeleccionDimensionVista1(this);
        pantallaEjercicio = new EjercicioVista(this);
        pantallaResultado = new ResultadoVista(this);
        Dimension1 = routerDimension.getPantallaDimension1();
        fondoAutenticacion = routerAuth.getFondoAutenticacion();

        inicializarPaneles();
        pantallaPrincipal.setVisible(true);
        pantallaPrincipal.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    private void inicializarPaneles() {
        pantallaPrincipal.agregarPanel(pantallaInicio, "INICIO");
        pantallaPrincipal.agregarPanel(pantallaInicioSesionAdmin, "SESION ADMIN");
        pantallaPrincipal.agregarPanel(pantallaSeleccionPanadero, "PANADEROS");
        pantallaPrincipal.agregarPanel(pantallaAdmin, "ADMIN");
        pantallaPrincipal.agregarPanel(pantallaSeleccionDimension1, "SELECCION DIMENSION1");
        pantallaPrincipal.agregarPanel(pantallaEjercicio, "EJERCICIO");
        pantallaPrincipal.agregarPanel(pantallaResultado, "RESULTADO");
        pantallaPrincipal.agregarPanel(fondoAutenticacion, "FONDO AUTH");
        pantallaPrincipal.agregarPanel(Dimension1, "DIMENSION1");
        pantallaPrincipal.mostrarPanel("INICIO");
    }

    // Métodos para mostrar vistas
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

    public void mostrarDimension1Vista() {
        pantallaPrincipal.mostrarPanel("DIMENSION1");
    }

    public void mostrarEjercicioVista() {
        pantallaPrincipal.mostrarPanel("EJERCICIO");
    }
    
    public void mostrarSeleccionDimension1(){
        pantallaPrincipal.mostrarPanel("SELECCION DIMENSION1");
    }
    public void mostrarResultadoVista() {
        pantallaPrincipal.mostrarPanel("RESULTADO");
    }

    public void mostrarFondoAutenticacionVista() {
        pantallaPrincipal.mostrarPanel("FONDO AUTH");
    }

    public void mostrarLoginEnFondoAutenticacion() {
        pantallaPrincipal.mostrarPanel("FONDO AUTH");
        if (fondoAutenticacion != null) {
            fondoAutenticacion.mostrarIniciarSesion();
        }
    }

    // Getters de listas globales
    public ArrayList<AlumnoModelo> getListaAlumnos() {
        return listaAlumnos;
    }

    public ArrayList<AdministradorModelo> getListaProfesores() {
        return listaProfesores;
    }

    public ArrayList<EjercicioModelo> getListaejercicios_1() {
        return listaejercicios_1;
    }

    public ArrayList<ArrayList<EjercicioModelo>> getNiveles() {
        return niveles;
    }

    // Getter y setter para alumno actual
    public AlumnoModelo getAlumnoActual() {
        return alumnoActual;
    }

    public void setAlumnoActual(AlumnoModelo alumno) {
        this.alumnoActual = alumno;
    }

    // Métodos para iniciar dimensiones
    public void iniciarDimension1() {
        DimensionModelo modeloDimen1 = new DimensionModelo();
        Dimension1Vista vistaDimension1 = routerDimension.getPantallaDimension1();
        vistaDimension1.inicializarDimension(this, modeloDimen1, this.getNiveles());
        // Establecer ID de dimensión en el controlador
        if (vistaDimension1.getControlador() != null) {
            vistaDimension1.getControlador().setDimensionId(1);
        }
        routerDimension.mostrarDimension1Vista();
    }

    public void iniciarDimension2() {
        DimensionModelo modeloDimen2 = new DimensionModelo();
        Dimension2Vista vistaDimension2 = routerDimension.getPantallaDimension2();
        vistaDimension2.inicializarDimension(this, modeloDimen2, this.getNiveles());
        if (vistaDimension2.getControlador() != null) {
            vistaDimension2.getControlador().setDimensionId(2);
        }
        routerDimension.mostrarDimension2Vista();
    }

    public void iniciarDimension3() {
        DimensionModelo modeloDimen3 = new DimensionModelo();
        Dimension3Vista vistaDimension3 = routerDimension.getPantallaDimension3();
        vistaDimension3.inicializarDimension(this, modeloDimen3, this.getNiveles());
        if (vistaDimension3.getControlador() != null) {
            vistaDimension3.getControlador().setDimensionId(3);
        }
        routerDimension.mostrarDimension3Vista();
    }

    public void iniciarDimension4() {
        DimensionModelo modeloDimen4 = new DimensionModelo();
        Dimension4Vista vistaDimension4 = routerDimension.getPantallaDimension4();
        vistaDimension4.inicializarDimension(this, modeloDimen4, this.getNiveles());
        if (vistaDimension4.getControlador() != null) {
            vistaDimension4.getControlador().setDimensionId(4);
        }
        routerDimension.mostrarDimension4Vista();
    }

    public void iniciarDimension5() {
        DimensionModelo modeloDimen5 = new DimensionModelo();
        Dimension5Vista vistaDimension5 = routerDimension.getPantallaDimension5();
        vistaDimension5.inicializarDimension(this, modeloDimen5, this.getNiveles());
        if (vistaDimension5.getControlador() != null) {
            vistaDimension5.getControlador().setDimensionId(5);
        }
        routerDimension.mostrarDimension5Vista();
    }

    // Método para iniciar juego con ejercicios
    public void iniciarJuegoConEjercicios(ArrayList<EjercicioModelo> ejercicios) {
        this.listaejercicios_1 = ejercicios;
        pantallaEjercicio.iniciarNuevoNivel();
    }

    // Getter para ResultadoVista (necesario para gamificación)
    public ResultadoVista getPantallaResultado() {
        return pantallaResultado;
    }

    // Getter para EjercicioVista (necesario para reiniciar nivel)
    public EjercicioVista getPantallaEjercicio() {
        return pantallaEjercicio;
    }
}
