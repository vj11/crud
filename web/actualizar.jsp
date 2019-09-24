<%-- 
    Document   : actualizar
    Created on : 16-sep-2019, 23:50:19
    Author     : sakur
--%>
<%@page import="modeloDAO.modeloDAO"%>
<%@page import="modelo.modelo" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <% modeloDAO dao=new modeloDAO();
                int id=Integer.parseInt(request.getParameter("id"));
                modelo per=(modelo)dao.list(id);%>
        <form action="controlador" method="post">
            <input type="number" name="id" value="<%=per.getIdSong()%>" style="display: none">
            <input type="text" name="nombre" value="<%=per.getNombre()%>" ><br>
            <input type="text" name="interprete"  value="<%=per.getInterprete()%>"><br>
            <input type="text" name="album" value="<%=per.getAlbum()%>"><br>
            <input type="date" name="fecha" value="<%=per.getFechaPublicacion()%>"><br>
            <input type="submit" name="accion" value="editar">
        </form>
    </body>
</html>
