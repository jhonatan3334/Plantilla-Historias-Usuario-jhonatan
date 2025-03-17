/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Conexion {
    
    private final String base = "sventa";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection con;
       
    
public Connection getConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,password);
            System.out.println("Se conecto a bd"+base);
            
        } catch (ClassNotFoundException | SQLException  ex) {
            System.out.println("No se conecto a bd "+base);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
}
}

   
