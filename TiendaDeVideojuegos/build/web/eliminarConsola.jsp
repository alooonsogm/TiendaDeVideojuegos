<%@page import="java.util.ArrayList"%>
<%@page import="despliegue.practica.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Centro Game</title>
        <link rel="stylesheet" href="estilos.css"/>
    </head>
    <body>
        <h1>Eliminar consola</h1>
        <p>Elige la consola que deseas eliminar:</p>
        <form action="gestionarElStock" method="post">
            <select name="eleccion">
                <%
                    Conexion miConexion = new Conexion();
                    ArrayList<String> listaConsola = miConexion.mostrarConsolas();

                    for (String consola : listaConsola) {
                        out.println("<option value=\"" + consola + "\">" + consola + "</option>");
                    }
                %>
            </select>
            <input type="submit" name="enviar" value="Eliminar consola">
        </form>
    </body>
</html>
