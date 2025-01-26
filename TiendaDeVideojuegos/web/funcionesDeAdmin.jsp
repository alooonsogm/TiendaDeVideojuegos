<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Centro Game</title>
        <link rel="stylesheet" href="estilos.css"/>
    </head>
    <body>
        <h1>Bienvenido Administrador</h1>
        <form action="eleccionAdmin" method="post">
            <select name="eleccion">
                <option value="modificarConsola">Modificar consola</option>
                <option value="modificarJuego">Modificar juego</option>
                <option value="insertarConsola">Insertar consola</option>
                <option value="insertarJuego">Insertar juego</option>
                <option value="eliminarConsola">Eliminar consola</option>
                <option value="eliminarJuego">Eliminar juego</option>
                <option value="salir">Cerrar sesión</option>
            </select>
            <input type="submit" name="enviar" value="Ir">
        </form>
    </body>
</html>
