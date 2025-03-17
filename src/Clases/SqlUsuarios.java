package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlUsuarios extends Conexion {

    public boolean registrar(Usuarios usr) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuarios (Nombre, Usuario, Contraseña, id_tipo, Correo) VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getUsuario());
            ps.setString(3, usr.getContraseña());
            ps.setInt(4, usr.getId_tipo());
            ps.setString(5, usr.getCorreo());
            
            
            ps.execute();
            return true;

        } catch (SQLException e) {
            return false;
        }

    }

    public boolean Login(Usuarios usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        //String sql = "SELECT count(id) FROM usuarios WHERE Usuario = ?";
        String sql = "SELECT u.ID, u.Usuario, u.Contraseña, u.Nombre, u.id_tipo, t.nombre FROM Usuarios AS u INNER JOIN tipo_usuario AS t ON u.id_tipo=t.ID WHERE Usuario = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getContraseña().equals(rs.getString(3))) {
                    
                    
                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setId_tipo(rs.getInt(5));
                    usr.setNombre_tipo(rs.getString(6));
                    
                    
                    return true;
                } else {
                    return false;
                }
            }
            return false;

        } catch (SQLException e) {
            return false;
        }
    }


public int existeUsuario(String usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        //String sql = "SELECT count(id) FROM usuarios WHERE Usuario = ?";
        String sql = "SELECT count(ID) FROM Usuarios WHERE Usuario = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException e) {
            return 1;
        }
    }

    public boolean esEmail(String correo) {
        // Validar campos email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correo);
        return matcher.find();
    }

}
