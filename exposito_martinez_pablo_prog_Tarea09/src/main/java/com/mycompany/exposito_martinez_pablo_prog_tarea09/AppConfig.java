/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exposito_martinez_pablo_prog_tarea09;

/**
 * Clase destinada a configurar el modo de acceso a los datos, dependiendo 
 * de la forma elegida en modoAcesoDatos, la aplicación almacenará de una
 * forma diferente los datos que se vayan introduciendo
 * @author david
 *
 */
public class AppConfig {
    public static String modoAccesoDatos = "FICHERO_JSON"; //Valores: FICHERO_TEXTO, FICHERO_BINARIO, FICHERO_JSON, MEMORIA
    public static String rutaFicheroTexto = "C:\\JAVA\\UT9\\TareaUT9FicheroTexto.txt";
    public static String rutaFicheroBinario = "C:\\JAVA\\UT9\\TareaUT9FicheroBinario.bin";
    public static String rutaFicheroJSON= "C:\\JAVA\\UT9\\TareaUT9FicheroJSON.json";
}
