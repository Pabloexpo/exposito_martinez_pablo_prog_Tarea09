/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exposito_martinez_pablo_prog_tarea09;

import java.util.TreeSet;

/**
 * Clase dedicada al almacenamiento de datos en memoria a través del 
 * uso de las llamadas colecciones
 * @author Pablo
 */
public class AccesoDatosMemoria extends AccesoDatosAbstract{

    @Override
    public TreeSet<Vehiculo> getAll() {
        return super.vehiculos;
    }

    @Override
    public Vehiculo getById(String matricula) {
        for (Vehiculo vehiculo: super.vehiculos){ //se puede hacer sin super
            if (vehiculo.getMatricula().equals(matricula)){
                return vehiculo;
            }
            
        }
        return null; 
    }

    @Override
    public void insert(Vehiculo vehiculo) {
        super.vehiculos.add(vehiculo);
    }

    @Override
    public void update(Vehiculo newVehiculo) {
        Vehiculo oldvehiculo = getById(newVehiculo.getMatricula()); 
        oldvehiculo.setPropietario(newVehiculo.getPropietario());
        oldvehiculo.setDescripcion(newVehiculo.getDescripcion());
        oldvehiculo.setDni_propietario(newVehiculo.getDni_propietario());
        oldvehiculo.setFecha_mat(newVehiculo.getFecha_mat());
        oldvehiculo.setMarca(newVehiculo.getMarca());
        oldvehiculo.setNum_kms(newVehiculo.getNum_kms());
        oldvehiculo.setPrecio(newVehiculo.getPrecio());
    }

    @Override
    public void delete(Vehiculo vehiculo) {
        super.vehiculos.remove(vehiculo);
    }

    
    
}
