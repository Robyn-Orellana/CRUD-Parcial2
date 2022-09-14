/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nomina;

import java.sql.*;
import java.util.Scanner;


/**
 *
 * @author robyn
 */
public class crud {
    private final String url = "";
    private final String RO = "";
    private final String PASS  = "";
    private Scanner tx = new Scanner(System.in);
    
    public void crear(){
        
        try {
            String nombre,e,f,m,a,ma,j;
            System.out.println("Ingresa el nombre:");
            nombre=tx.nextLine();
            System.out.println("Ingrese Enero");
            e=tx.nextLine();
            System.out.println("Ingrese Febrero");
            f=tx.nextLine();
            System.out.println("Ingrese Marzo");
            m=tx.nextLine();
            System.out.println("Ingrese Abril");
            a=tx.nextLine();
            System.out.println("Ingrese Mayo");
            ma=tx.nextLine();
            System.out.println("Ingrese Junio");
            j=tx.nextLine();
            Connection conexion = DriverManager.getConnection(url,RO,PASS);
            Statement sentencia = conexion.createStatement();//Sirve para procesar sentencias de MySQL
            String query ="insert into tb_empleados (Nombre,Enero,Febrero,Marzo,Abril,Mayo,Junio) "+
                    "values ('"+nombre+"',"+e+","+f+","+m+","+a+","+ma+","+j+")";
            sentencia.executeUpdate(query);
            System.out.println("Registro exitoso!");
            
        } catch (SQLException ex) {
            System.out.println("Tenemos problemas! "+ex);
        }
    }
    public void consultar(String niv){
        int r;
        try {
            Connection conexion = DriverManager.getConnection(url,RO,PASS);
            Statement sentencia = conexion.createStatement();
            String query = "SELECT * FROM tb_empleados  where NIV = "+niv;
            ResultSet resultado = sentencia.executeQuery(query);
            
            while(resultado.next()){
                r=resultado.getInt(3)+resultado.getInt(4)+resultado.getInt(5)+
                    resultado.getInt(6)+resultado.getInt(7)+resultado.getInt(8);
                System.out.println("NIV ="+resultado.getInt(1));
                System.out.println("Nombre = "+resultado.getString(2));
                System.out.println("Enero = "+resultado.getInt(3));
                System.out.println("Febrero = "+resultado.getInt(4));
                System.out.println("Marzo = "+resultado.getInt(5));
                System.out.println("Abril = "+resultado.getInt(6));
                System.out.println("Mayo = "+resultado.getInt(7));
                System.out.println("Junio = "+resultado.getInt(8));
                System.out.println("Total ventas = "+r);
            }
            
        } catch (SQLException ex) {
            System.out.println("Hubo clavo:"+ex.getMessage());
          
        }
        
}
    public void listar(){
        try {
            Connection conexion = DriverManager.getConnection(url,RO,PASS);
            Statement sentencia = conexion.createStatement();
            String query = "SELECT * FROM db_empleados.tb_empleados";
            ResultSet resultado = sentencia.executeQuery(query);
            int e=0,f=0,m=0,a=0,ma=0,j=0;
            
            while(resultado.next()){
                System.out.println("NIV ="+resultado.getInt(1)+"| Nombre = "+resultado.getString(2)+"\t\t| Enero = "+resultado.getInt(3)+
                "| Febrero = "+resultado.getInt(4)+"| Marzo = "+resultado.getInt(5)+"| Abril = "+resultado.getInt(6)+
                "| Mayo = "+resultado.getInt(7)+"| Junio = "+resultado.getInt(8));
                
                e=e+resultado.getInt(3);
                f=f+resultado.getInt(4);
                m=m+resultado.getInt(5);
                a=a+resultado.getInt(6);
                ma=ma+resultado.getInt(7);
                j=j+resultado.getInt(8);
                
            }
            System.out.println("Total de Ventas por mes: ");
            System.out.println("Enero = "+e+"\nFebrero = "+f+"\nMarzo = "+m);
            System.out.println("Abril = "+a+"\nMayo = "+ma+"\nJunio = "+j);
            
        } catch (SQLException ex) {
            System.out.println("Ocurrio un problema! "+ex);
        }
    }
    public void eliminar(String niv){
        try {
            Connection conexion = DriverManager.getConnection(url,RO,PASS);
            Statement sentencia = conexion.createStatement();
            
            String query2 = "SELECT * FROM tb_empleados where NIV="+niv;
            String query = "delete from tb_empleados where NIV="+niv;
            String respuesta;
            
            System.out.println("Estas seguro que quieres eliminar a : ");
            ResultSet resultado = sentencia.executeQuery(query2);
            
            while(resultado.next()){
               System.out.println("NIV = "+resultado.getInt(1)+ " Nombre = "+resultado.getString(2));
            }
            
            respuesta=tx.nextLine();
            
            if (respuesta.equalsIgnoreCase("si")) {
                sentencia.executeUpdate(query);
                System.out.println("Eliminado");

            }else{
                System.out.println("Eliminacion cancelada");
            }
            
        } catch (SQLException ex) {
            System.out.println("Hay un problema... "+ex);
        }
        
    }
    public void actualizar(String niv){
        try {

            String nombre;
            Connection conexion = DriverManager.getConnection(url,RO,PASS);
            Statement sentencia = conexion.createStatement();
            String query2 = "SELECT * FROM tb_empleados  where NIV = "+niv;
            ResultSet resultado = sentencia.executeQuery(query2);
            
            while(resultado.next()){
               System.out.println("NIV = "+resultado.getInt(1)+ " Nombre = "+resultado.getString(2));
               System.out.println("Solo se puede modificar el nombre...");
               System.out.println("Ingrese el nombre: ");
            }
            
            nombre=tx.nextLine();
            String query = "update tb_empleados set nombre= '"+nombre+"' where NIV= "+niv;
            sentencia.executeUpdate(query);
            System.out.println("Actualizacion exitosa!");
          
        } catch (SQLException ex) {
            System.out.println("Hay un problema : "+ex);
        }
        
        
    }
    
}
