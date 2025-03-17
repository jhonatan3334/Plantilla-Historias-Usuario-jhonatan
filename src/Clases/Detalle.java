
package Clases;

public class Detalle {
    private int ID;
    private String Codigo_Producto;
    private int Cantidad;
    private double Precio;
    private int ID_Venta;
    
    public Detalle(){
        
    }

    public Detalle(int ID, String Codigo_Producto, int Cantidad, double Precio, int ID_Venta) {
        this.ID = ID;
        this.Codigo_Producto = Codigo_Producto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.ID_Venta = ID_Venta;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCodigo_Producto() {
        return Codigo_Producto;
    }

    public void setCodigo_Producto(String Codigo_Producto) {
        this.Codigo_Producto = Codigo_Producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getID_Venta() {
        return ID_Venta;
    }

    public void setID_Venta(int ID_Venta) {
        this.ID_Venta = ID_Venta;
    }
}

    