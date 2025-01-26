package despliegue.practica;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EleccionJuegos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EleccionJuegos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EleccionJuegos at " + request.getContextPath() + "</h1>");
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

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Centro Game</title>");
            out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Catalogo de juegos de cada consola</h1>");
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

            try {
                String consulta = "Select * from juegos where plataforma = ?";
                Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/centrogame", "daw2", "1234");
                PreparedStatement elStatementPreparado = miConexion.prepareStatement(consulta, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                elStatementPreparado.setString(1, eleccion);
                ResultSet miResultset = elStatementPreparado.executeQuery();
                while (miResultset.next()) {
                    out.println("<tr>");
                    out.println("<td>" + miResultset.getString("nombre") + "</td>");
                    out.println("<td>" + miResultset.getString("plataforma") + "</td>");
                    out.println("<td>" + miResultset.getString("companiaDesarrolladora") + "</td>");
                    out.println("<td>" + miResultset.getString("genero") + "</td>");
                    out.println("<td>" + miResultset.getDouble("puntuacionMetacritic") + "</td>");
                    out.println("<td>" + miResultset.getDouble("precio") + "</td>");
                    out.println("<td>" + miResultset.getInt("unidadesDisponibles") + "</td>");
                    out.println("<td><input type=\"checkbox\" name=\"compra\" value=\"" + miResultset.getString("id") + "\"></td>");
                    out.println("</tr>");
                }
                miResultset.close();
                elStatementPreparado.close();
                miConexion.close();

                out.println("<tr>");
                out.println("<td colspan=\"8\" style=\"text-align: center;\">");
                out.println("<input type=\"submit\" name=\"enviar\" value=\"Comprar juego\">");
                out.println("</td>");
                out.println("</tr>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
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
