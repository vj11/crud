<%-- 
    Document   : registrar
    Created on : 16-sep-2019, 23:50:03
    Author     : sakur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="controlador">

            <input type="text" name="nombre" placeholder="nombre"><br>
            <input type="text" name="interprete" placeholder="interprete"><br>
            <input type="text" name="album" placeholder="album"><br>
            <input type="date" name="fecha" placeholder="fehca de publicacion"><br>
            <input type="submit" name="accion" value="registrar">
        </form>
    </body>
</html>
