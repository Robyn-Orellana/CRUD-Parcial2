/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.nomina;

import java.util.Scanner;

/**
 *
 * @author robyn
 */
public class Nomina {
    private static int opcion = -1;
    private static final Scanner T = new Scanner(System.in);
    private static crud CRUD = new crud();

    public static void main(String[] args) {
       String niv; 
       
        while (opcion != 0) {
            try {
                System.out.println("Base de datos empleatos"
                        + "\nSelecciona una opcion"
                        + "\n1.- Crear empleado\n"
                        + "2.- Consultar empleado\n"
                        + "3.- Listar a todos los empleados\n"
                        + "4.- Actualizar registro\n"
                        + "5.- Eliminar registro\n" 
                        + "0.- Salir");
                opcion=Integer.parseInt(T.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.println("Crear empleado\nIngrese los datos");
                        CRUD.crear();
                        
                        break;
                    case 2:
                        System.out.println("Consultar Empleado");
                        System.out.println("Ingrese el NIV del empleado");
                        niv=T.nextLine();
                        CRUD.consultar(niv);
                     
                        break;
                    case 3:
                        System.out.println("Lista de empleados");
                        CRUD.listar();
                        
                        break;
                    case 4:
                        System.out.println("Actualizar registo");
                        System.out.println("Ingresa el NIV del empleado:");
                        niv=T.nextLine();
                        CRUD.actualizar(niv);
                        
                        break;
                    case 5:
                        System.out.println("Eliminar Registro");
                        System.out.println("Ingrese el NIV del empleado:");
                        niv=T.nextLine();
                        CRUD.eliminar(niv);
                        
                        break;
                    case 0:
                        System.out.println("!Nos vemos pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }
}
