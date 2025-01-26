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
        <h1>Modificar juego</h1>
        <p>Elige el juego que deseas modificar</p>
        <form action="gestionarElStock" method="post">
            <select name="eleccion">
                <%
                    Conexion miConexion = new Conexion();
                    ArrayList<String> listaJuegos = miConexion.mostrarJuegos();

                    for (int x = 0; x < listaJuegos.size(); x = x + 2) {
                        out.println("<option value=\"" + listaJuegos.get(x) + "\">" + listaJuegos.get(x) + " - " + listaJuegos.get(x + 1) + "</option>");
                    }
                %>
            </select>
            <input type="submit" name="enviar" value="Modificar juego">
        </form>
    </body>
</html>
