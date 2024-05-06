/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exposito_martinez_pablo_prog_tarea09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.io.*;


/**
 * Clase AccesoDatosFicheroTexto destinada a almacenar los datos que
 * se envían desde la clase Main en formato .txt
 * @author Pablo Exposito Martinez 
 * 
 */
public class AccesoDatosFicheroTexto extends AccesoDatosAbstract implements Serializable {
    /**
    * Método orientado a ahorrar escritura a la hora de insertar la 
    * ruta del fichero en los métodos, utilizado en todas las clases
    * de Acceso a Datos
    */
    private static final String RUTA_ARCHIVO = "C:\\\\JAVA\\\\UT9\\\\TareaUT9FicheroTexto.txt";

    private Vehiculo parse(String linea) {
        // Dividimos la línea en partes basándonos en el separador ":"
        String[] partes = linea.split(",");
        // Asumimos que el orden de los atributos en el fichero es el correcto
        String matricula = partes[0];
        String marca = partes[1];
        int numKms = Integer.parseInt(partes[2].trim());
        String fechaMat = partes[3].trim();
        Date fechaMatDate = Utils.parseFecha(fechaMat);
        String descripcion = partes[4];
        String propietario = partes[5];
        String dniPropietario = partes[6];
        int precio = Integer.parseInt(partes[7].trim()); 

        
        

        // Creamos el objeto Vehiculo con los datos obtenidos
        Vehiculo vehiculo = new Vehiculo(
                matricula,
                marca,
                numKms,
                fechaMatDate,
                descripcion,
                propietario,
                dniPropietario,
                precio
        );
        return vehiculo;
    }

    @Override
    public TreeSet<Vehiculo> getAll() {
        TreeSet <Vehiculo> vehiculos = new TreeSet<>();
        try {
            BufferedReader lector;
            lector = new BufferedReader(new FileReader(RUTA_ARCHIVO));
            String linea; 
            while ((linea = lector.readLine()) != null) {
                Vehiculo vehiculo = parse(linea); //se crea una instancia
                vehiculos.add(vehiculo);//se añade 
            }
            lector.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return vehiculos;
    }

    @Override
    public Vehiculo getById(String matricula) {
        try{
            BufferedReader lector;
            lector = new BufferedReader(new FileReader(RUTA_ARCHIVO));
            String linea;
            while ((linea = lector.readLine())!= null){    
                Vehiculo vehiculo = parse(linea);
                if (vehiculo.getMatricula().equalsIgnoreCase(matricula)){
                    return vehiculo;
                }
            }
            lector.close();
            
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Vehiculo vehiculo) {
        try {        
            PrintWriter escrito = 
                    new PrintWriter(new FileWriter(RUTA_ARCHIVO));
            escrito.print(vehiculo.getMatricula() + ", ");
            escrito.print(vehiculo.getMarca() + ", ");
            escrito.print(vehiculo.getNum_kms() + ", ");
            escrito.print(vehiculo.getFecha_mat() + ", ");
            escrito.print(vehiculo.getDescripcion()+ ", ");
            escrito.print(vehiculo.getPropietario() + ", ");            
            escrito.print(vehiculo.getDni_propietario() + ",");
            escrito.print(vehiculo.getPrecio());
            escrito.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        
        
    }

    @Override
    public void update(Vehiculo vehiculo) {
        try (BufferedWriter escrito = 
                new BufferedWriter (new FileWriter(RUTA_ARCHIVO))){
            escrito.write(vehiculo.getMatricula() + ", ");
            escrito.write(vehiculo.getMarca() + ", ");
            escrito.write(vehiculo.getNum_kms() + ", ");
            escrito.write(vehiculo.getFecha_mat() + ", ");
            escrito.write(vehiculo.getDescripcion()+ ", ");
            escrito.write(vehiculo.getPropietario() + ", ");            
            escrito.write(vehiculo.getDni_propietario() + ", ");
            escrito.write(Integer.toString(vehiculo.getPrecio()).trim());
            
           
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Vehiculo vehiculo) {
        TreeSet <Vehiculo> vehiculos = getAll(); 
        vehiculos.remove(vehiculo);
        try (PrintWriter escrito = 
                new PrintWriter(new FileWriter(RUTA_ARCHIVO))){
            for (Vehiculo v : vehiculos){
                escrito.println(v.toString());
            }           
            
        } catch (IOException e){
            e.printStackTrace();
  
        }
    }

}
