/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.modelo;
import modeloDAO.modeloDAO;

@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {
    
    String listar="/listar.jsp";
    String edit="/actualizar.jsp";
    String dele="/actualizar.jsp";
    String deedit="/listar.jsp";
    String des="/listar.jsp";
    String hab="/listar.jsp";
    modeloDAO dao=new modeloDAO();
    modelo p=new modelo();
   
    int id;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acceso="";
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("edit")){
            acceso=edit;
        }
        else if(accion.equalsIgnoreCase("dele")){
            acceso=dele;
        }
        else if(accion.equalsIgnoreCase("hab")){
            acceso=dele;
        }
        else if(accion.equalsIgnoreCase("des")){
            acceso=des;
        }
        else if(accion.equalsIgnoreCase("deedit")){
            acceso=deedit;
        }else if(accion.equalsIgnoreCase("Editar")){
            try{
                id=Integer.parseInt(request.getParameter("id"));
            } catch (Exception e){
                
            }
            
            request.getRequestDispatcher("/actualizar.jsp").forward(request, response);
        }
        else if(accion.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setIdSong(id);
            dao.delete(id);
            request.getRequestDispatcher("/listar.jsp").forward(request, response);
        }
        else if(accion.equalsIgnoreCase("Habilitar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setIdSong(id);
            dao.habilitar(p);
            acceso=listar;
        }
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion =request.getParameter("accion");
        String nombre = request.getParameter("nombre");
        String interprete = request.getParameter("interprete");
        String album =request.getParameter("album");
        String fechaPublicacion = request.getParameter("fecha");
        modeloDAO DAO = new modeloDAO();
        try{
            switch (accion) {
                case "registrar":
                    try{
                        DAO.agregarCancion(nombre,interprete,album,fechaPublicacion);
                        request.getRequestDispatcher("/listar.jsp").forward(request, response);
                    } catch (IOException | ServletException e) {
                        
                    }
                    break;
                case "editar":
                    try{
                        DAO.modificarCancion(id,nombre,interprete,album,fechaPublicacion);
                        request.getRequestDispatcher("/listar.jsp").forward(request, response);
                    } catch (Exception e){
                        
                    }
                default:
            }
            
        }
        catch(NumberFormatException e){
            
        }
               
    }                
           


}
