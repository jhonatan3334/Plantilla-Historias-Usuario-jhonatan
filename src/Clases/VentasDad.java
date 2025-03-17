/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class VentasDad {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public int IdVenta(){
        int ID = 0;
        String sql = "SELECT MAX(ID) FROM ventas";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                ID = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ID;
    }
    public int RegistrarVenta(Venta v) {
        String sql = "INSERT INTO ventas(Vendedor, Total) VALUES (?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getVendedor());
            ps.setDouble(2,v.getTotal());
            ps.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    public int RegistrarDetalle(Detalle Dv){
        String sql = "INSERT INTO detalle (Codigo_Producto, Cantidad, Precio, ID_Venta) VALUES (?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Dv.getCodigo_Producto());
            ps.setInt(2, Dv.getCantidad());
            ps.setDouble(3, Dv.getPrecio());
            ps.setInt(4, Dv.getID());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    public boolean ActualizarStock(int cant,String cod){
        String sql ="UPDATE productos SET Stock = ? WHERE Codigo = ? ";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }   
    
    public List ListarVentas() {
        List<Venta> ListaVentas = new ArrayList();
        String sql = "SELECT * FROM ventas";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta vent = new Venta();
                vent.setId(rs.getInt("id"));
                vent.setVendedor(rs.getString("Vendedor"));
                vent.setTotal(rs.getDouble("Total"));
                ListaVentas.add(vent);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaVentas;
    }
    
}
