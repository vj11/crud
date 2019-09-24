/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.modelo;

/**
 *
 * @author sakur
 */
public class modeloDAO {
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    modelo per=new modelo();
    public List listar() {
        ArrayList<modelo>list=new ArrayList<>();
        String sql="SELECT `idCanciones`, `nombre`, `interprete`, `album`, `fechaPublicacion` FROM `canciones` WHERE `estado`= 1";
        try{
            
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                modelo res=new modelo();
                res.setIdSong(rs.getInt("idCanciones"));
                res.setNombre(rs.getString("nombre"));
                res.setInterprete(rs.getString("interprete"));
                res.setAlbum(rs.getString("album"));
                res.setFechaPublicacion(rs.getString("fechaPublicacion"));
                list.add(res);
            }
        }
        catch (SQLException e) {
            
        }
        return list;
    }
    public modelo list(int id) {
        String sql="select * from canciones where idCanciones="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                per.setIdSong(rs.getInt("idCanciones"));
                per.setNombre(rs.getString("nombre"));
                per.setInterprete(rs.getString("interprete"));
                per.setAlbum(rs.getString("album"));
                per.setFechaPublicacion(rs.getString("fechaPublicacion"));
                
            }
        } catch (SQLException e) {
        }
        return per;
    }
    public void agregarCancion(String nombre,String interprete,String album,String fechaPublicacion){

        String sql="INSERT INTO `canciones`( `nombre`, `interprete`, `album`, `fechaPublicacion`,`estado`) VALUES  (?,?,?,?,'1');";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            
            ps.setString(1, nombre); 
            ps.setString(2, interprete);
            ps.setString(3, album);
            ps.setString(4, fechaPublicacion);
            
            ps.execute();
        }
        catch(SQLException e){
            
        }
    }
    public void modificarCancion (int id,String nombre,String interprete,String album,String fechaPublicacion) throws SQLException{
        
        String sql="UPDATE `canciones` SET `nombre`=?,`interprete`=?,`album`=?,`fechaPublicacion`=? WHERE `idCanciones`=?";
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, interprete);
            ps.setString(3, album);
            ps.setString(4, fechaPublicacion);
            ps.setInt(5, id);
            
            ps.execute();
   }
    public void habilitar(modelo per) {
        String sql="update canciones set estado= 1 where idCanciones="+per.getIdSong();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
   
    public void delete(int id) {
        String sql="update canciones set estado= 0 where idCanciones="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
}
