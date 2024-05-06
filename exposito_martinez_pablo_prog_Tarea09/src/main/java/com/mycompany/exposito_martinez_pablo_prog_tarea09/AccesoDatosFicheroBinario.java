/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exposito_martinez_pablo_prog_tarea09;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 * Clase AccesoDatosFicheroBinario destinada a almacenar los datos que
 * se envían desde la clase Main en formato .bin 
 * @author Pablo Exposito Martinez 
 * 
 */
public class AccesoDatosFicheroBinario extends AccesoDatosAbstract {
    private static final String RUTA_ARCHIVO = "C:\\\\JAVA\\\\UT9\\\\TareaUT9FicheroBinario.bin";

    private Vehiculo parse(DataInputStream dataIn) throws IOException {
        try {
            String matricula = dataIn.readUTF();
            String marca = dataIn.readUTF();
            int numKms = dataIn.readInt();
            Date fechaMat = Utils.parseFecha(dataIn.readUTF());  // Suponemos que la fecha está guardada como UTF
            String descripcion = dataIn.readUTF();
            String propietario = dataIn.readUTF();
            String dniPropietario = dataIn.readUTF();
            int precio = dataIn.readInt();

            Vehiculo vehiculo = new Vehiculo(matricula, marca, numKms, fechaMat, descripcion, propietario, dniPropietario, precio);
            return vehiculo;
        } catch (EOFException e){
            return null;
        }
     
    }

    @Override
    public TreeSet<Vehiculo> getAll() {
        TreeSet <Vehiculo> vehiculos = new TreeSet<>(); 
        try {
            
                      
            ObjectInputStream entrada; 
            entrada = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(RUTA_ARCHIVO)));
            
            while (true){
                try {
                    Vehiculo vehiculoLeido = (Vehiculo) entrada.readObject(); 
                    vehiculos.add(vehiculoLeido); 
                } catch (EOFException e){
                    entrada.close();
                    break; 
                }
                
            }

            
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } 
         
        return vehiculos; 
    }

    @Override
    public Vehiculo getById(String matricula) {
        try (ObjectInputStream entrada =
                new ObjectInputStream(new BufferedInputStream (
                    new FileInputStream(RUTA_ARCHIVO)))){
            
            while (true){
                Vehiculo vehiculoLeido =  (Vehiculo) entrada.readObject();
                if (vehiculoLeido.getMatricula().equalsIgnoreCase(matricula)){
                    return vehiculoLeido;
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Vehiculo vehiculo) {
        try (ObjectOutputStream salida =
                new ObjectOutputStream(new BufferedOutputStream (
                        new FileOutputStream(RUTA_ARCHIVO)))){
            
            salida.writeObject(vehiculo);  
        } catch (IOException e){
            e.printStackTrace();
            
        }
    }

    @Override
    public void update(Vehiculo vehiculo) {
        try {
            TreeSet <Vehiculo> vehiculos = getAll(); 
            vehiculos.remove(vehiculo);
            
            
            ObjectOutputStream salida; 
            salida = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream(RUTA_ARCHIVO)));
            
            ObjectInputStream entrada; 
            entrada = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(RUTA_ARCHIVO)));
            
            //BUSCAMOS EL VEHICULO Y REEMPLAZAMOS
            for (Vehiculo v : vehiculos){
                if (v.getMatricula().equalsIgnoreCase(vehiculo.getMatricula())){
                    vehiculos.remove(v);
                    vehiculos.add(vehiculo);
                    break; 
                }
                
            }
            //ESCRIBIMOS DE NUEVO EL FLUJO DE DATOS
            for (Vehiculo v : vehiculos){
                salida.writeObject(vehiculo);
            }
            
            
        
            
            salida.close();
            entrada.close();
      
        } catch (IOException e){
            e.printStackTrace();
        } /*catch (ClassNotFoundException e){
            e.printStackTrace();
        }*/
    }

    @Override
    public void delete(Vehiculo vehiculo) {
        TreeSet <Vehiculo> vehiculos = getAll(); 
        vehiculos.remove(vehiculo);
        try {
            ObjectOutputStream salida;
        
            salida = new ObjectOutputStream (new BufferedOutputStream( 
            new FileOutputStream((RUTA_ARCHIVO))));
            
            for (Vehiculo v : vehiculos){
                salida.writeObject(vehiculo);
            }
            salida.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        
        
    }

    
    
}
