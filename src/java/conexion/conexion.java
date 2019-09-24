package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class conexion {
    Connection con;
    public conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud?useSSL=false&useUnicode=True&useJDBCCompliantTimezoneShift=True&useLegacyDatetimeCode=False&serverTimezone=UTC","root","porticalle13");
        }
        catch (ClassNotFoundException | SQLException e){
            System.err.println("Error: "+e);
        }
    }
    public Connection getConnection() {
                 return con;
    }
    
    /* prueba de la conexion de BD*/
        /*public static void main(String []args){
        conexion cn=new conexion();
        Statement st;
        ResultSet rs;
        try{
            st=cn.con.createStatement();
            rs=st.executeQuery("SELECT `idResiduosInventario`, `idFormulario`, `tipoResiduo`, `cantidad`, `generador` FROM `residuosinventario` WHERE 1");
            while (rs.next()){
                System.out.println(rs.getInt("idResiduosInventario")+" "+rs.getString("tipoResiduo"));
            }
            cn.con.close();
        }
        catch(Exception e){
            
        }
    }*/
        }
