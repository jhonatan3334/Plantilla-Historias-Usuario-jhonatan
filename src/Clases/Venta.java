/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author PC
 */
public class Venta {
    
    private int id;
    private String Vendedor;
    private String Nombre;
    private double Total;
   
    
    public Venta (){
        
    }

    public Venta(int id, String Vendedor, String Nombre, double Total) {
        this.id = id;
        this.Vendedor = Vendedor;
        this.Nombre = Nombre;
        this.Total = Total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    

    
}