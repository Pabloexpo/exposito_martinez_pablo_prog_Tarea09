/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exposito_martinez_pablo_prog_tarea09;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;


/**
 * Clase Main orientada a configurar las posibles opciones que brinda la 
 * aplicacion, para que después los métodos estáticos llamen a los métodos
 * de las clases de AccessoDatosFichero, txt, memoria, json
 * 
 * @author Pablo Exposito Martinez 
 * 
 */
public class Main {
    
    private static AccesoDatosAbstract accesoDatos = AccesoDatosAbstract.getInstance();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nGESTIÓN DE VEHÍCULOS DE UN CONCESIONARIO");
            System.out.println("1.Nuevo Vehículo.");
            System.out.println("2.Listar Vehículos.");
            System.out.println("3.Buscar Vehículo por matrícula.");
            System.out.println("4.Sumar Kilómetros de Vehículo.");
            System.out.println("5.Eliminar Vehículo.");
            System.out.println("6.Salir.");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarVehiculo(scanner);
                    break;
                case 2:
                    listarVehiculos();
                    break;
                case 3:
                    buscarVehiculoPorMatricula(scanner);
                    break;
                case 4:
                    sumarKilometros(scanner);
                    break;
                case 5:
                    eliminarVehiculo(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }
    /**
    * Método para añadir un vehiculo
    * @param scanner: introduce datos por la clase Scanner
    */


    private static void agregarVehiculo(Scanner scanner) {
//        System.out.println("Nuevo Vehículo");
//        System.out.print("Introduce la marca del vehículo: ");
//        String marca = scanner.nextLine();
//        System.out.print("Introduce la matrícula del vehículo: ");
//        String matricula = scanner.nextLine();
//        System.out.print("Introduce la descripción del vehículo: ");
//        String descripcion = scanner.nextLine();
//        System.out.print("Introduce el número de kilómetros del vehículo: ");
//        int num_kms = scanner.nextInt();
//        System.out.print("Introduce el precio del vehículo: ");
//        int precio = scanner.nextInt();
//        scanner.nextLine(); // Limpiar buffer
//        System.out.print("Introduce el propietario del vehículo (Nombre Apellido1 Apellido2): ");
//        String propietario = scanner.nextLine();
//        System.out.print("Introduce el dni propietario del vehículo: ");
//        String dniPropietario = scanner.nextLine();
//        System.out.print("Introduce el día de matriculación: ");
//        int diaMatriculacion = scanner.nextInt();
//        System.out.print("Introduce el mes de matriculación: ");
//        int mesMatriculacion = scanner.nextInt();
//        System.out.print("Introduce el año de matriculación: ");
//        int anoMatriculacion = scanner.nextInt(); 
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR, anoMatriculacion);
//        calendar.set(Calendar.MONTH, mesMatriculacion - 1); // Meses en Calendar comienzan desde 0
//        calendar.set(Calendar.DAY_OF_MONTH, diaMatriculacion);
//        calendar.set(Calendar.HOUR, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        Date fecha_mat = calendar.getTime();
        
        String marca = "Ford";
        String matricula = "1111AAA";
        String descripcion = "coche 1";
        int num_kms = 100000;
        int precio = 3000;
        String propietario = "David Guerrero Gonzalez";
        String dniPropietario = "11111111A";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2001);
        calendar.set(Calendar.MONTH, 1 - 1); // Meses en Calendar comienzan desde 0
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date fecha_mat = calendar.getTime();
        
        Vehiculo vehiculo = new Vehiculo(
                matricula, 
                marca,
                num_kms, 
                fecha_mat,
                descripcion, 
                propietario,  
                dniPropietario,
                precio
        );
        if (!validar(vehiculo)){
            return;
        }
        accesoDatos.insert(vehiculo);
        System.out.println("El vehículo ha sido creado en el concesionario.");
    }
    /**
    * Método para listar todos los vehiculos, hace llamada del 
    * método getAll () de las clases de acceso a datos
    */

    private static void listarVehiculos() {
        TreeSet<Vehiculo> vehiculos = accesoDatos.getAll();
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString()); 
        }
    }
    /**
    * Método para buscar un vehiculo ya insertado, jace uso del método
    * getById de las clases de acceso a datos
    * @param scanner : se introduce la matrícula para buscar el vehículo
    * 
    */

    private static void buscarVehiculoPorMatricula(Scanner scanner) {
        System.out.print("Introduce la matrícula: ");
        String matricula = scanner.nextLine();
        Vehiculo vehiculo = accesoDatos.getById(matricula);
        if (vehiculo == null){
            System.out.println("Vehículo no encontrado.");
            return;
        }
        System.out.println(vehiculo.toString());
    }
    
    /**
    * Método para sumar los kilómetros a un vehículo ya insertado, 
    * obtenemos el vehículo a través del método getById de las clases de 
    * acceso a datos y con el método update de esas clases hacemos 
    * actualización de los datos del vehículo
    * @param scanner : utilizado para ingresar la matrícula del vehículo
    */

    private static void sumarKilometros(Scanner scanner) {
        System.out.print("Introduce la matrícula: ");
        String matricula = scanner.nextLine();
        Vehiculo vehiculo = accesoDatos.getById(matricula);
        if (vehiculo == null){
            System.out.println("Vehículo no encontrado.");
            return;
        }
        System.out.print("Introduce los km: ");
        int km = scanner.nextInt();
        int newKm = vehiculo.getNum_kms() + km;
        vehiculo.setNum_kms(newKm);
        accesoDatos.update(vehiculo);
        System.out.println(vehiculo.toString());
    }
    /**
    * Método eliminar el vehículo, se utiliza el método getById de las 
    * clases de acceso a datos y, una vez obtenido el vehículo, se
    * hace uso del método delete de esas mismas clases
    * @param scanner : utilizado para introducir por pantalla la
    * matrícula del vehículo 
    */

    private static void eliminarVehiculo(Scanner scanner) {
        System.out.print("Introduce la matrícula: ");
        String matricula = scanner.nextLine();
        Vehiculo vehiculo = accesoDatos.getById(matricula);
        if (vehiculo == null){
            System.out.println("Vehículo no encontrado.");
            return;
        }
        accesoDatos.delete(vehiculo);
        System.out.println("Vehículo eliminado");
    }
    
    /**
    * Método para validar los datos proporcionados por el programa
    * para que sean acordes con los estándares oficiales 
    * @param vehiculo : objeto de la clase Vehiculo del cual se
    * van a obtener datos para hacer las comparaciones y validaciones
    * 
    */
    
    
    private static boolean validar(Vehiculo vehiculo){
         //Validación de la fecha.
        if (!Validar.comparaFecha(vehiculo.getFecha_mat())) {
            System.out.println("Los datos de la fecha de matriculación son "
                    + "incorrectos o la fecha no es anterior a la actual");
            return false;
        }
        if (!Validar.validaDNI(vehiculo.getDni_propietario())) {
            System.out.println("DNI incorrecto");
            return false;
        }
        if (!Validar.validaMatricula(vehiculo.getMatricula())) {
            System.out.println("Matricula incorrecta. Formato: NNNNLLL");
            return false;
        }
        if (!Validar.validaNombre(vehiculo.getPropietario())) {
            System.out.println("Matricula incorrecta. Formato: Nombre "
                    + "Apellido1 Apellido2");
            return false;
        }
                
        return true;
    }
    
    
}
