<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Centro Game</title>
        <link rel="stylesheet" href="estilos.css"/>
    </head>
    <body>
        <h1>Inserta los datos de la nueva consola</h1>
        <form action="gestionarElStock" method="post">
            <label>Nombre</label>
            <input type="text" name="nombre"><br><br>
            <label>Potencia CPU</label>
            <input type="text" name="cpu"><br><br>
            <label>Potencia GPU</label>
            <input type="text" name="gpu"><br><br>
            <label>Compañia</label>
            <input type="text" name="compañia"><br><br>
            <label>Precio</label>
            <input type="text" name="precio"><br><br>
            <label>Unidades disponibles</label>
            <input type="text" name="unidades"><br><br>
            <label>Generacion</label>
            <select name="generacion">
                <option value="vieja">vieja</option>
                <option value="nueva">nueva</option>
                <option value="actual">actual</option>
            </select>
            <input type="submit" name="enviar" value="Insertar consola">
        </form>
    </body>
</html>
