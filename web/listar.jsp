<%-- 
    Document   : listar
    Created on : 16-sep-2019, 23:50:29
    Author     : sakur
--%>

<%@page import="java.util.Iterator"%>
<%@page import="modelo.modelo"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.modeloDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div class="card-body">
            <div class="table-responsive">
                
                <table id="example" class="display table table-light table-hover table-bordered " width="100%">
                <thead>
                  <tr>
                    <th>Nombre</th>
                    <th>Interprete</th>
                    <th>Album</th>
                    <th>Fecha de Publicacion</th>
                    <th>Opciones</th>
                  </tr>
                </thead>
                <tfoot>
                  <tr>
                      <th style="display: none">id</th>
                    <th>Nombre</th>
                    <th>Interprete</th>
                    <th>Album</th>
                    <th>Fecha de Publicacion</th>
                    <th>Opciones</th>
                  </tr>
                </tfoot>
                <% 
                    modeloDAO dao=new modeloDAO();
                    List<modelo>list=dao.listar();
                    Iterator<modelo>iter=list.iterator();
                    modelo res = null;
                    while(iter.hasNext()){
                     res=iter.next();
                    %>
                <tbody>
                    <tr>
                        <td style="display: none"><%=res.getIdSong()%></td>
                        <td><%=res.getNombre()%></td>
                        <td><%=res.getInterprete()%></td>
                        <td><%=res.getAlbum()%></td>
                        <td><%=res.getFechaPublicacion()%></td>
                        <td>
                            <a href="controlador?accion=Editar&id=<%=res.getIdSong()%>">Editar</a>
                            <a href="controlador?accion=eliminar&id=<%= res.getIdSong()%>">Eliminar</a>
                        </td>
                    </tr>
                    
                </tbody>
                <%
                    }
                %>
               </table>
            </div>
          </div>
    </body>
</html>
