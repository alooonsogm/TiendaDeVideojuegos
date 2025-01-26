<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Centro Game</title>
        <link rel="stylesheet" href="estilos.css"/>
    </head>
    <body>
        <h1>Inserta los datos del nuevo juego</h1>
        <form action="gestionarElStock" method="post">
            <label>Nombre</label>
            <input type="text" name="nombre"><br><br>
            <label>Compañia desarrolladora</label>
            <input type="text" name="compañia"><br><br>
            <label>Genero</label>
            <input type="text" name="genero"><br><br>
            <label>Puntuacion Metacritic</label>
            <input type="text" name="puntuacion"><br><br>
            <label>Precio</label>
            <input type="text" name="precio"><br><br>
            <label>Unidades disponibles</label>
            <input type="text" name="unidades"><br><br>
            <label>Plataforma</label>
            <select name="plataforma">
                <option value="Xbox one">Xbox one</option>
                <option value="Xbox Series X y Xbox Series S">Xbox Series X y Xbox Series S</option>
                <option value="Nintendo Switch y Nintendo Switch Lite">Nintendo Switch y Nintendo Switch Lite</option>
                <option value="PS4">PS4</option>
                <option value="PS5 con CD y PS5 sin CD">PS5 con CD y PS5 sin CD</option>
            </select>
            <input type="submit" name="enviar" value="Insertar juego">
        </form>
    </body>
</html>
