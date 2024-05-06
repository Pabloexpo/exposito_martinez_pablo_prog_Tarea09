/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exposito_martinez_pablo_prog_tarea09;

import java.util.Date;
import java.io.*;


/**
 * Clase Vehiculo destinada a la creacion de objetos de tipo Vehiculo para
 * posteriormente poder almacenarlos
 * @author Pablo Exposito Martinez 
 * 
 */
public class Vehiculo implements Comparable<Vehiculo>, Serializable{

    private String matricula;
    private String marca;
    private int num_kms;
    private Date fecha_mat;
    private String descripcion;
    private int precio;
    private String propietario;
    private String dni_propietario;

    public Vehiculo(String matricula, String marca, int num_kms, Date fecha_mat, 
            String descripcion, String propietario, 
            String dni_propietario, int precio) {
        this.marca = marca;
        this.matricula = matricula;
        this.num_kms = num_kms;
        this.fecha_mat = fecha_mat;
        this.descripcion = descripcion;
        this.precio = precio;
        this.propietario = propietario;
        this.dni_propietario = dni_propietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNum_kms() {
        return num_kms;
    }

    public void setNum_kms(int num_kms) {
        this.num_kms = num_kms;
    }

    public Date getFecha_mat() {
        return fecha_mat;
    }

    public void setFecha_mat(Date fecha_mat) {
        this.fecha_mat = fecha_mat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getDni_propietario() {
        return dni_propietario;
    }

    public void setDni_propietario(String dni_propietario) {
        this.dni_propietario = dni_propietario;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + 
                "marca=" + marca + 
                ", matricula=" + matricula + 
                ", num_kms=" + num_kms + 
                ", fecha_mat=" + fecha_mat + 
                ", descripcion=" + descripcion + 
                ", propietario=" + propietario + 
                ", dni_propietario=" + dni_propietario + 
                ", precio=" + precio + '}';
    }

    @Override
    public int compareTo(Vehiculo otro) {
        return this.matricula.compareTo(otro.matricula);
    }
    
    
}