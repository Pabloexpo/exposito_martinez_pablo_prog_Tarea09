/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exposito_martinez_pablo_prog_tarea09;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;


/**
 * Clase AccesoDatosFicheroJSON destinada a almacenar los datos que
 * se envían desde la clase Main en formato .json
 * @author Pablo Exposito Martinez 
 * 
 */
public class AccesoDatosFicheroJSON extends AccesoDatosAbstract {
    private static final String RUTA_ARCHIVO = "C:\\JAVA\\UT9\\TareaUT9FicheroJSON.json";

    public void crearFichero(File arch){
        // Asegúrate de que el archivo exista o maneja la situación si no existe
        if (!arch.exists()) {
            try {
                arch.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    @Override
    public TreeSet<Vehiculo> getAll() {
        TreeSet <Vehiculo> vehiculos = new TreeSet<>(); 
        
        try {
            FileReader lector = new FileReader(RUTA_ARCHIVO);
            BufferedReader lectorBuffer; 
            lectorBuffer= new BufferedReader(lector);
            
            Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
            
            while (true){
                try {
                    Vehiculo vehiculo = gson.fromJson(lectorBuffer, Vehiculo.class);
                
                    vehiculos.add(vehiculo); 
                } catch (Exception e){
                    
                    break; 
                }

            }
            lectorBuffer.close();

        } catch (IOException e){
            e.printStackTrace();
        }
        return vehiculos; 
    }

    @Override
    public Vehiculo getById(String matricula) {
        Vehiculo vehiculoEncontrado = null; 

        try {
            FileReader lector = new FileReader(RUTA_ARCHIVO);
            BufferedReader lectorBuffer; 
            lectorBuffer= new BufferedReader(lector); 
            
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String linea; 
            StringBuilder json = new StringBuilder(); 
            
            while ((linea=lectorBuffer.readLine())!= null) {
                
                json.append(linea); 
                
            }
            
            Vehiculo vehiculo = gson.fromJson(json.toString(), Vehiculo.class);
            
            if (vehiculo.getMatricula().equalsIgnoreCase(matricula)){
                    vehiculoEncontrado= vehiculo; 
                }
            
            lectorBuffer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return vehiculoEncontrado; 
    }

    @Override
    public void insert(Vehiculo vehiculo) {
        try {
            File archivo = new File(RUTA_ARCHIVO);
            crearFichero(archivo);
            FileWriter escritor = new FileWriter(archivo);
            
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            
            gson.toJson(vehiculo, escritor);
            
            escritor.close();
            
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Vehiculo vehiculo) {
        TreeSet <Vehiculo> vehiculos = getAll();
        
        vehiculos.remove(vehiculo);
        
        try {
            FileWriter escritor = new FileWriter(RUTA_ARCHIVO);
            BufferedWriter escritorBuffer; 
            escritorBuffer= new BufferedWriter(escritor); 
            
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            
            //añadimos el vehiculo seteado a la coleccion
            for (Vehiculo v : vehiculos){
                vehiculos.remove(v); 
                vehiculos.add(vehiculo); 
            }
            
            //añadimos el vehiculo al json ya modificado

            insert(vehiculo);
            
            
            
            
            escritorBuffer.close();
            
        } catch (IOException e){
            e.printStackTrace();
        }
        
        
        
    }

    @Override
    public void delete(Vehiculo vehiculo) {
        TreeSet <Vehiculo> vehiculos = getAll(); 
        vehiculos.remove(vehiculo); 
        try {
            FileWriter escritor = new FileWriter(RUTA_ARCHIVO);
            
            PrintWriter escritorPrint; 
            escritorPrint= new PrintWriter(escritor); 
            
            for (Vehiculo v : vehiculos){
                
                escritorPrint.print(vehiculo);
            }
            
            escritorPrint.close();
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
   

}
