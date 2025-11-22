/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Equipo Dell
 */
public class ConexionBDT {
    // **********************************************
    // 1. CREDENCIALES DE CONEXION
    // **********************************************
  
    // HOST: labs-dbservices01.ucab.edu.ve
    // PORT: 5432
    // DATABASE: grupo20
                                       // Esto es la ruta del drive.
    private static final String URL = "jdbc:postgresql://labs-dbservices01.ucab.edu.ve:5432/grupo20";
    
    // USUARIO.
    private static final String USER = "grupo20";
    
    // CONTRASEÑA.
    private static final String PASS = "123456";

    public static Connection obtenerConexion() throws SQLException {
        // DriverManager busca el driver (el JAR de PostgreSQL en Libraries) y lo utiliza
        // para realizar la conexión con la URL, el usuario y la contraseña.
        return DriverManager.getConnection(URL, USER, PASS);
    }
    

}
