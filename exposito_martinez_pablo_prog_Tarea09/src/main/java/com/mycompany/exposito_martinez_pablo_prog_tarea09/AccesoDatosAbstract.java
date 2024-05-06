/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exposito_martinez_pablo_prog_tarea09;
import java.util.TreeSet;

/**
 * Clase abstracta dedicada a declarar los métodos CRUD que serán 
 * utilizados por las clases hijas de acceso a datos de texto, binarios, json 
 * y memoria
 * @author David
 * 
 */
public abstract class AccesoDatosAbstract
{
    private static AccesoDatosAbstract conexion;


    protected TreeSet<Vehiculo> vehiculos = new TreeSet<Vehiculo>();
    
    
    /**
    * Método que devuelve una coleccion de tipo Vehiculo, su objetivo
    * es listar todos los vehículos insertados en la aplicación
    * 
    */
    public abstract TreeSet<Vehiculo> getAll();
    
    /**
    * Método que devuelve un objeto de la clase Vehículo, pretende recuperar
    * el objeto a través de su atributo matrícula
    * @param matricula : String de la matrícula del coche 
    */
    public abstract Vehiculo getById(String matricula);
    
    
    /**
    * Método destinado a insertar nuevos vehículos en la aplicación
    * @param vehiculo : objeto de la clase Vehiculo
    */
    public abstract void insert(Vehiculo vehiculo);

    /**
    * Método destinado a realizar modificaciones en los kilómetros de
    * un vehículo ya insertado
    * @param vehiculo : objeto de la clase Vehiculo
    */
    public abstract void update(Vehiculo vehiculo);
    
    
    /**
    * Método destinado a borrar vehículos de la aplicación
    * @param vehiculo : objeto de la clase Vehiculo
    */
    public abstract void delete(Vehiculo vehiculo);
    
    
    /**
    * Método destinado a realizar la conexión con el tipo de acceso a datos
    * que se ha elegido 
    */
    public static AccesoDatosAbstract getInstance()
    {
        if (AppConfig.modoAccesoDatos.equalsIgnoreCase("MEMORIA"))
        {
            if (conexion == null){
                conexion = new AccesoDatosMemoria();
            }
        }
        if (AppConfig.modoAccesoDatos.equalsIgnoreCase("FICHERO_TEXTO"))
        {
            if (conexion == null){
                conexion = new AccesoDatosFicheroTexto();
            }
        }
        if (AppConfig.modoAccesoDatos.equalsIgnoreCase("FICHERO_BINARIO"))
        {
            if (conexion == null){
                conexion = new AccesoDatosFicheroBinario();
            }
        }
        if (AppConfig.modoAccesoDatos.equalsIgnoreCase("FICHERO_JSON"))
        {
            if (conexion == null){
                conexion = new AccesoDatosFicheroJSON();
            }
        }        
        return conexion;
    }
}
