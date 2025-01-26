<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Centro Game</title>
        <link rel="stylesheet" href="estilos.css"/>
    </head>
    <body>
        <h1>Bienvenido cliente</h1>
        <form action="eleccionCliente" method="post">
            <select name="eleccion">
                <option value="consolas">Catálogo de consolas</option>
                <option value="juegosPorConsolas">Catálogo de juegos de cada consola</option>
                <option value="juegos">Catálogo total de juegos</option>
                <option value="total">Catálogo de todos los productos</option>
                <option value="salir">Cerrar sesion</option>
            </select>
            <input type="submit" name="enviar" value="Ir">
        </form>
    </body>
</html>
