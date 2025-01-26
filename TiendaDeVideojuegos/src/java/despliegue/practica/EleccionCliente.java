package despliegue.practica;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EleccionCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EleccionCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EleccionCliente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        PrintWriter out = response.getWriter();

        String enviar = request.getParameter("enviar");

        if (enviar == null) {
            response.sendRedirect("index.html");
        } else {
            String eleccion = request.getParameter("eleccion");
            try {
                Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/centrogame", "daw2", "1234");
                Statement miStatement = miConexion.createStatement();
                if (eleccion.equals("consolas")) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Centro Game</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Catalogo de consolas</h1>");
                    out.println("<form action=\"comprarCatalogo\" method=\"post\">");
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<th>Nombre</th>");
                    out.println("<th>CPU potencia</th>");
                    out.println("<th>GPU potencia</th>");
                    out.println("<th>Compania</th>");
                    out.println("<th>Precio</th>");
                    out.println("<th>Unidades disponibles</th>");
                    out.println("<th>Comprar Producto</th>");
                    out.println("</tr>");

                    ResultSet miResultset = miStatement.executeQuery("Select * from consolas");
                    while (miResultset.next()) {
                        out.println("<tr>");
                        out.println("<td>" + miResultset.getString("nombre") + "</td>");
                        out.println("<td>" + miResultset.getString("cpuPotencia") + "</td>");
                        out.println("<td>" + miResultset.getString("gpuPotencia") + "</td>");
                        out.println("<td>" + miResultset.getString("compania") + "</td>");
                        out.println("<td>" + miResultset.getDouble("precio") + "</td>");
                        out.println("<td>" + miResultset.getInt("unidadesDisponibles") + "</td>");
                        out.println("<td><input type=\"checkbox\" name=\"compra\" value=\"" + miResultset.getString("nombre") + "\"></td>");
                        out.println("</tr>");
                    }
                    miResultset.close();
                    miStatement.close();
                    miConexion.close();

                    out.println("<tr>");
                    out.println("<td colspan=\"7\" style=\"text-align: center;\">");
                    out.println("<input type=\"submit\" name=\"enviar\" value=\"Comprar consolas\">");
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                } else if (eleccion.equals("juegosPorConsolas")) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Centro Game</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Catalogo de juegos</h1>");
                    out.println("<p>Elige una consola para mostrar su catalogo de juegos:</p>");
                    out.println("<form action=\"eleccionJuegos\" method=\"post\">");
                    out.println("<select name=\"eleccion\">");
                    out.println("<option value=\"xbox one\">Xbox One</option>");
                    out.println("<option value=\"Xbox Series X y Xbox Series S\">Xbox Series X</option>");
                    out.println("<option value=\"Xbox Series X y Xbox Series S\">Xbox Series S</option>");
                    out.println("<option value=\"Nintendo Switch y Nintendo Switch Lite\">Nintendo Switch</option>");
                    out.println("<option value=\"Nintendo Switch y Nintendo Switch Lite\">Nintendo Switch Lite</option>");
                    out.println("<option value=\"ps4\">PS4</option>");
                    out.println("<option value=\"PS5 con CD y PS5 sin CD\">PS5 con CD</option>");
                    out.println("<option value=\"PS5 con CD y PS5 sin CD\">PS5 sin CD</option>");
                    out.println("</select>");
                    out.println("<input type=\"submit\" name=\"enviar\" value=\"Ir\">");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                } else if (eleccion.equals("juegos")) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Centro Game</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Catalogo total de juegos</h1>");
                    out.println("<form action=\"comprarCatalogo\" method=\"post\">");
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<th>Nombre</th>");
                    out.println("<th>Plataforma</th>");
                    out.println("<th>Compania desarrolladora</th>");
                    out.println("<th>Genero del juego</th>");
                    out.println("<th>Puntuacion en Metacritic</th>");
                    out.println("<th>Precio</th>");
                    out.println("<th>Unidades disponibles</th>");
                    out.println("<th>Comprar Producto</th>");
                    out.println("</tr>");

                    ResultSet miResultset = miStatement.executeQuery("Select * from juegos");
                    while (miResultset.next()) {
                        out.println("<tr>");
                        out.println("<td>" + miResultset.getString("nombre") + "</td>");
                        out.println("<td>" + miResultset.getString("plataforma") + "</td>");
                        out.println("<td>" + miResultset.getString("companiaDesarrolladora") + "</td>");
                        out.println("<td>" + miResultset.getString("genero") + "</td>");
                        out.println("<td>" + miResultset.getString("puntuacionMetacritic") + "</td>");
                        out.println("<td>" + miResultset.getDouble("precio") + "</td>");
                        out.println("<td>" + miResultset.getInt("unidadesDisponibles") + "</td>");
                        out.println("<td><input type=\"checkbox\" name=\"compra\" value=\"" + miResultset.getString("id") + "\"></td>");
                        out.println("</tr>");
                    }
                    miResultset.close();
                    miStatement.close();
                    miConexion.close();

                    out.println("<tr>");
                    out.println("<td colspan=\"8\" style=\"text-align: center;\">");
                    out.println("<input type=\"submit\" name=\"enviar\" value=\"Comprar juegos\">");
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                } else if (eleccion.equals("total")) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Centro Game</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Catalogo total de productos</h1>");
                    out.println("<form action=\"comprarCatalogo\" method=\"post\">");
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<th>Nombre del producto</th>");
                    out.println("<th>Precio</th>");
                    out.println("<th>Unidades disponibles</th>");
                    out.println("<th>Comprar Producto</th>");
                    out.println("</tr>");

                    ResultSet miResultset = miStatement.executeQuery("Select * from consolas");
                    while (miResultset.next()) {
                        out.println("<tr>");
                        out.println("<td>" + miResultset.getString("nombre") + "</td>");
                        out.println("<td>" + miResultset.getDouble("precio") + "</td>");
                        out.println("<td>" + miResultset.getInt("unidadesDisponibles") + "</td>");
                        out.println("<td><input type=\"checkbox\" name=\"compra\" value=\"" + miResultset.getString("nombre") + "\"></td>");
                        out.println("</tr>");
                    }
                    miResultset.close();

                    ResultSet miResultset2 = miStatement.executeQuery("Select * from juegos");
                    while (miResultset2.next()) {
                        out.println("<tr>");
                        out.println("<td>" + miResultset2.getString("nombre") + " - " + miResultset2.getString("plataforma") + "</td>");
                        out.println("<td>" + miResultset2.getDouble("precio") + "</td>");
                        out.println("<td>" + miResultset2.getInt("unidadesDisponibles") + "</td>");
                        out.println("<td><input type=\"checkbox\" name=\"compra\" value=\"" + miResultset2.getString("nombre") + "\"></td>");
                        out.println("</tr>");
                    }
                    miResultset2.close();
                    miStatement.close();
                    miConexion.close();

                    out.println("<tr>");
                    out.println("<td colspan=\"4\" style=\"text-align: center;\">");
                    out.println("<input type=\"submit\" name=\"enviar\" value=\"Comprar productos\">");
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                } else if (eleccion.equals("salir")) {
                    response.sendRedirect("index.html");
                }
            } catch (Exception e) {
                out.println("<h2>Error de conexion</h2>");
                out.println(e.getMessage());
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
