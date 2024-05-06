/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exposito_martinez_pablo_prog_tarea09;

import java.util.Calendar;
import java.util.Date;
/**
 * CLase dedicada a realizar verificaciones acerca de las fechas, el dni, 
 * la matrícula y el nombre de los datos introducidos 
 * @author David
 */
public class Validar {
    /**
     * 
     * Método dedicado a comparar la fecha y darle formato
     * @param fecha_mat
     * 
     */
    
    public static boolean comparaFecha (Date fecha_mat){
        // Obtener la fecha actual sin tiempo
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date hoy = calendar.getTime();
        
        // Comparar si la fecha_mat es antes de hoy
        return fecha_mat.before(hoy);
    }
    /**
     * Método dedicado a verificar si un dni tiene formáto válido
     * @param dni
     * 
     */
    public static boolean validaDNI (String dni){
        return dni.matches("^[0-9]{8}[A-Z]$");  //Versión simple para validar un DNI.
        
    }
    /**
     * Método para verificar que una matrícula introducida es correcta
     * @param matricula
     *  
     */
    public static boolean validaMatricula (String matricula){        
        return matricula.matches("^[0-9]{4}[A-Z]{3}$"); //Versión simple para validar una matrícula.
    }
    /**
     * Método que verifica que un nombre introducido no tiene espacios en blanco
     * o su longitud no supera los 40 caracteres
     * @param nombre
     * 
     */
    public static boolean validaNombre (String nombre){
        
        if (nombre.length()>40) return false; //comprobamos que el tamaño no supera los 40 caracteres
         
        int posicion = nombre.indexOf(" "); //buscamos el primer espacio en blanco.
        
        if (posicion==-1) return false; //Si no existe
        else {
            posicion=nombre.indexOf(" ", posicion+1); //Buscamos el siguiente espacio en blanco.
            if (posicion==-1) return false; //Si no lo encontramos
            
        }
        return true;
        
    }
    
}
