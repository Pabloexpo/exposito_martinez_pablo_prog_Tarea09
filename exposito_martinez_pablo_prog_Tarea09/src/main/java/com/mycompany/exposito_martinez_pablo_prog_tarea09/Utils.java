/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exposito_martinez_pablo_prog_tarea09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Clase dedidaca a dar formato a las fechas de matriculación de los 
 * vehículos
 * @author david
 */
public class Utils {

    public static Date parseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        try {
            return formato.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // O manejar de otra manera
        }
    }
}
