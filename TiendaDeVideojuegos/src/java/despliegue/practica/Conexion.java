package despliegue.practica;

import java.sql.*;
import java.io.*;
import java.util.ArrayList;

public class Conexion {

    private Connection miConexion;

    public Conexion() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/centrogame", "daw2", "1234");
    }

    public ResultSet comprobarUsuario(String usuario, String pass) throws Exception {
        String consulta = "SELECT * FROM usuarios WHERE nombreUsuario=? AND password=?";
        PreparedStatement elStatement = this.miConexion.prepareStatement(consulta, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        elStatement.setString(1, usuario);
        elStatement.setString(2, pass);

        ResultSet elResultado = elStatement.executeQuery();
        return elResultado;
    }

    public void insertarConsola(String nombre, String cpu, String gpu, String compania, String precio, String unidades, String generacion) throws Exception {
        String consulta = "INSERT INTO consolas (nombre, cpuPotencia, gpuPotencia, compania, precio, unidadesDisponibles, generacion) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);

        consultaPreparada.setString(1, nombre);
        consultaPreparada.setString(2, cpu);
        consultaPreparada.setString(3, gpu);
        consultaPreparada.setString(4, compania);
        consultaPreparada.setString(5, precio);
        consultaPreparada.setString(6, unidades);
        consultaPreparada.setString(7, generacion);

        consultaPreparada.executeUpdate();
    }

    public void insertarJuego(String nombre, String compañia, String genero, String puntuacion, String precio, String unidades, String plataforma) throws Exception {
        String consulta = "INSERT INTO juegos (nombre, plataforma, companiaDesarrolladora, genero, puntuacionMetacritic, precio, unidadesDisponibles, generacion) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);

        consultaPreparada.setString(1, nombre);
        consultaPreparada.setString(2, plataforma);
        consultaPreparada.setString(3, compañia);
        consultaPreparada.setString(4, genero);
        consultaPreparada.setString(5, puntuacion);
        consultaPreparada.setString(6, precio);
        consultaPreparada.setString(7, unidades);

        if (plataforma.equals("Xbox one") || plataforma.equals("PS4")) {
            consultaPreparada.setString(8, "vieja");
        } else if (plataforma.equals("Nintendo Switch y Nintendo Switch Lite")) {
            consultaPreparada.setString(8, "actual");
        } else if (plataforma.equals("Xbox Series X y Xbox Series S") || plataforma.equals("PS5 con CD y PS5 sin CD")) {
            consultaPreparada.setString(8, "nueva");
        }

        consultaPreparada.executeUpdate();
    }

    public ArrayList<String> mostrarConsolas() throws Exception {
        String consulta = "Select nombre from consolas";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        ResultSet miResultset = consultaPreparada.executeQuery();
        ArrayList<String> listaNombres = new ArrayList<>();

        while (miResultset.next()) {
            listaNombres.add(miResultset.getString("nombre"));
        }

        return listaNombres;
    }

    public ArrayList<String> mostrarJuegos() throws Exception {
        String consulta = "Select nombre, plataforma from juegos";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        ResultSet miResultset = consultaPreparada.executeQuery();
        ArrayList<String> datosJuegos = new ArrayList<>();

        while (miResultset.next()) {
            datosJuegos.add(miResultset.getString("nombre"));
            datosJuegos.add(miResultset.getString("plataforma"));
        }

        return datosJuegos;
    }

    public void eliminarConsola(String nombreConsola) throws Exception {
        String consulta = "Delete from consolas where nombre = ?";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        consultaPreparada.setString(1, nombreConsola);
        consultaPreparada.executeUpdate();
    }

    public void eliminarJuego(String id) throws Exception {
        String consulta = "Delete from juegos where id = ?";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        consultaPreparada.setString(1, id);
        consultaPreparada.executeUpdate();
    }

    public ArrayList<String> mostrarUnaConsola(String nombreConsola) throws Exception {
        String consulta = "Select * from consolas where nombre = ?";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        consultaPreparada.setString(1, nombreConsola);
        ResultSet miResultset = consultaPreparada.executeQuery();

        ArrayList<String> datosConsola = new ArrayList<>();

        while (miResultset.next()) {
            datosConsola.add(miResultset.getString("nombre"));
            datosConsola.add(miResultset.getString("cpuPotencia"));
            datosConsola.add(miResultset.getString("gpuPotencia"));
            datosConsola.add(miResultset.getString("compania"));
            datosConsola.add(miResultset.getString("precio"));
            datosConsola.add(miResultset.getString("unidadesDisponibles"));
            datosConsola.add(miResultset.getString("generacion"));
        }

        return datosConsola;
    }
    
    public ArrayList<String> mostrarUnaConsola2(String nombreConsola) throws Exception {
        String consulta = "Select * from consolas where nombre = ?";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        consultaPreparada.setString(1, nombreConsola);
        ResultSet miResultset = consultaPreparada.executeQuery();

        ArrayList<String> datosConsola = new ArrayList<>();

        while (miResultset.next()) {
            datosConsola.add(miResultset.getString("nombre"));;
            datosConsola.add(miResultset.getString("precio"));
            datosConsola.add(miResultset.getString("unidadesDisponibles"));
        }

        return datosConsola;
    }

    public ArrayList<String> mostrarUnJuego(String id) throws Exception {
        String consulta = "Select * from juegos where id = ?";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        consultaPreparada.setString(1, id);
        ResultSet miResultset = consultaPreparada.executeQuery();

        ArrayList<String> datosJuego = new ArrayList<>();

        while (miResultset.next()) {
            datosJuego.add(miResultset.getString("nombre"));
            datosJuego.add(miResultset.getString("plataforma"));
            datosJuego.add(miResultset.getString("companiaDesarrolladora"));
            datosJuego.add(miResultset.getString("genero"));
            datosJuego.add(miResultset.getString("puntuacionMetacritic"));
            datosJuego.add(miResultset.getString("precio"));
            datosJuego.add(miResultset.getString("unidadesDisponibles"));
            datosJuego.add(miResultset.getString("generacion"));
        }

        return datosJuego;
    }

    public ArrayList<String> mostrarUnJuego2(String nombre) throws Exception {
        String consulta = "Select * from juegos where nombre = ?";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        consultaPreparada.setString(1, nombre);
        ResultSet miResultset = consultaPreparada.executeQuery();

        ArrayList<String> datosJuego = new ArrayList<>();

        while (miResultset.next()) {
            datosJuego.add(miResultset.getString("nombre"));
            datosJuego.add(miResultset.getString("plataforma"));
            datosJuego.add(miResultset.getString("companiaDesarrolladora"));
            datosJuego.add(miResultset.getString("genero"));
            datosJuego.add(miResultset.getString("puntuacionMetacritic"));
            datosJuego.add(miResultset.getString("precio"));
            datosJuego.add(miResultset.getString("unidadesDisponibles"));
            datosJuego.add(miResultset.getString("generacion"));
        }

        return datosJuego;
    }
    
    public ArrayList<String> mostrarUnJuego3(String nombre) throws Exception {
        String consulta = "Select * from juegos where nombre = ?";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        consultaPreparada.setString(1, nombre);
        ResultSet miResultset = consultaPreparada.executeQuery();

        ArrayList<String> datosJuego = new ArrayList<>();

        while (miResultset.next()) {
            datosJuego.add(miResultset.getString("nombre"));
            datosJuego.add(miResultset.getString("precio"));
            datosJuego.add(miResultset.getString("unidadesDisponibles"));
        }

        return datosJuego;
    }

    public void modificarConsola(String nombre, String cpu, String gpu, String compania, String precio, String unidades, String generacion) throws Exception {
        String consulta = "update consolas set cpuPotencia=?, gpuPotencia=?, "
                + "compania=?, precio=?, unidadesDisponibles=?, generacion=? where nombre=?";

        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);

        consultaPreparada.setString(1, cpu);
        consultaPreparada.setString(2, gpu);
        consultaPreparada.setString(3, compania);
        consultaPreparada.setString(4, precio);
        consultaPreparada.setString(5, unidades);
        consultaPreparada.setString(6, generacion);
        consultaPreparada.setString(7, nombre);

        consultaPreparada.executeUpdate();
    }

    public void modificarJuego(String nombre, String plataforma, String compania, String genero, String puntuacion, String precio, String unidades) throws Exception {
        String consulta = "update juegos set plataforma=?, companiaDesarrolladora=?, "
                + "genero=?, puntuacionMetacritic=?, precio=?, unidadesDisponibles=?, generacion=? where nombre=?";

        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);

        consultaPreparada.setString(1, plataforma);
        consultaPreparada.setString(2, compania);
        consultaPreparada.setString(3, genero);
        consultaPreparada.setString(4, puntuacion);
        consultaPreparada.setString(5, precio);
        consultaPreparada.setString(6, unidades);

        if (plataforma.equals("Xbox one") || plataforma.equals("PS4")) {
            consultaPreparada.setString(7, "vieja");
        } else if (plataforma.equals("Nintendo Switch y Nintendo Switch Lite")) {
            consultaPreparada.setString(7, "actual");
        } else if (plataforma.equals("Xbox Series X y Xbox Series S") || plataforma.equals("PS5 con CD y PS5 sin CD")) {
            consultaPreparada.setString(7, "nueva");
        }

        consultaPreparada.setString(8, nombre);

        consultaPreparada.executeUpdate();
    }

    public void comprarConsola(String nombreConsola) throws Exception {
        String consulta = "UPDATE consolas SET unidadesDisponibles = unidadesDisponibles - 1 WHERE nombre = ? AND unidadesDisponibles > 0";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        consultaPreparada.setString(1, nombreConsola);
        consultaPreparada.executeUpdate();
    }

    public void comprarJuego(String id) throws Exception {
        String consulta = "UPDATE juegos SET unidadesDisponibles = unidadesDisponibles - 1 WHERE id = ? AND unidadesDisponibles > 0";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        consultaPreparada.setString(1, id);
        consultaPreparada.executeUpdate();
    }
    
    public void comprarJuego2(String nombreJuego) throws Exception {
        String consulta = "UPDATE juegos SET unidadesDisponibles = unidadesDisponibles - 1 WHERE nombre = ? AND unidadesDisponibles > 0";
        PreparedStatement consultaPreparada = this.miConexion.prepareStatement(consulta);
        consultaPreparada.setString(1, nombreJuego);
        consultaPreparada.executeUpdate();
    }
}
