/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panaderiamatemagica.modelos;

/**
 *
 * @author Equipo Dell
 */
public class ValidacionesGenericas {
    // validacion de numeros enteros.
    public int validarEntero(String entrada, int liminf, int limsup) {
        // 1. Limpia y valida si la entrada es un entero valido (la excepcion es: NumberFormatException)
        String entradaLimpia = entrada.trim();
        int entero;
        
        try {
            entero = Integer.parseInt(entradaLimpia);
        } catch (NumberFormatException objeto) {
            // No es un numero entero valido
            return -1; // error no es un numero.
        }
        
        // 2. Valida si el entero esta dentro de los limites
        if (entero < liminf || entero > limsup) {
            return -2; //el numero no esta dentro de los limites
        }
        
        // 3. La validacion es exitosa
        return 1;
    }
    
    //validacion de numeros decimales
    public int validarDoouble(String entrada, double liminf, double limsup) {
        // 1. Limpia y valida si la entrada es un double valido (la excepcion es: NumberFormatException)
        String entradaLimpia = entrada.trim();
        double numeroDouble;
        
        try {
            //Usamos Double.parseDouble() para pasarlo an dooble.
            numeroDouble = Double.parseDouble(entradaLimpia);
        } catch (NumberFormatException objeto) {
            return -1; // error no es un numero dooble valido.
        }
   
        // 2. Valida si el double esta dentro de los limites
        if (numeroDouble < liminf || numeroDouble > limsup) {
            return -2; // el numero no esta dentro de los limites
        }
        
        // 3. La validacion es exitosa.
        return 1;
    }
    
    //validacion de una cadena 
    //para que no tenga caracteres raros uasar:"^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s.-]{3,100}$"
    // para que sea cualquier caracter: "."
    public int validarCadena(String entrada, String patron, int longMin, int longMax) {
        // Verificacion de contenido minimo: si la cadena limpia esta vacia, es solo espacios.
        String entradaLimpia = entrada.trim();
        if (entradaLimpia.isEmpty()) {
            return 0; // Error: Solo contenia espacios en blanco.
        }

        int longitud = entrada.length(); // Tomamos la longitud de la cadena original

        // 1. Validacion de Longitud (usando la longitud de la cadena ORIGINAL)
        if (longitud < longMin || longitud > longMax) {
            return -2; // Error: La longitud esta fuera de los limites.
        }

        // 2. Validacion de Patron (usando la cadena ORIGINAL)
        if (!entrada.matches(patron)) {
            return -1; // Error: No cumple con el patron (formato).
        }

        // 3. Exito: La cadena es valida en formato, longitud y contenido.
        return 1; 
    }
}
