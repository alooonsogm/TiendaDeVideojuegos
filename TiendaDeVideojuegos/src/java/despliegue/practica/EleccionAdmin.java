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

public class EleccionAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EleccionAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EleccionAdmin at " + request.getContextPath() + "</h1>");
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

        String eleccion = request.getParameter("eleccion");

        switch (eleccion) {
            case "modificarConsola":
                response.sendRedirect("modificarConsola.jsp");
                break;
            case "modificarJuego":
                response.sendRedirect("modificarJuego.jsp");
                break;
            case "insertarConsola":
                response.sendRedirect("insertarConsola.jsp");
                break;
            case "insertarJuego":
                response.sendRedirect("insertarJuego.jsp");
                break;
            case "eliminarConsola":
                response.sendRedirect("eliminarConsola.jsp");
                break;
            case "eliminarJuego":
                try {
                    Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/centrogame", "daw2", "1234");
                    Statement miStatement = miConexion.createStatement();
                    ResultSet miResultset = miStatement.executeQuery("Select * from juegos");

                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Centro Game</title>");
                    out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Eliminar juego</h1>");
                    out.println("<form action=\"gestionarElStock\" method=\"post\">");
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<th>Nombre</th>");
                    out.println("<th>Plataforma</th>");
                    out.println("<th>Compania desarrolladora</th>");
                    out.println("<th>Genero del juego</th>");
                    out.println("<th>Puntuacion en Metacritic</th>");
                    out.println("<th>Precio</th>");
                    out.println("<th>Unidades disponibles</th>");
                    out.println("<th>Eliminar juego</th>");
                    out.println("</tr>");

                    while (miResultset.next()) {
                        out.println("<tr>");
                        out.println("<td>" + miResultset.getString("nombre") + "</td>");
                        out.println("<td>" + miResultset.getString("plataforma") + "</td>");
                        out.println("<td>" + miResultset.getString("companiaDesarrolladora") + "</td>");
                        out.println("<td>" + miResultset.getString("genero") + "</td>");
                        out.println("<td>" + miResultset.getString("puntuacionMetacritic") + "</td>");
                        out.println("<td>" + miResultset.getDouble("precio") + "</td>");
                        out.println("<td>" + miResultset.getInt("unidadesDisponibles") + "</td>");
                        out.println("<td><input type=\"checkbox\" name=\"juegoEliminados\" value=\"" + miResultset.getString("id") + "\"></td>");
                        out.println("</tr>");
                    }
                    miResultset.close();
                    miStatement.close();
                    miConexion.close();

                    out.println("<tr>");
                    out.println("<td colspan=\"8\" style=\"text-align: center;\">");
                    out.println("<input type=\"submit\" name=\"enviar\" value=\"Eliminar juego\">");
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                } catch (Exception e) {
                    out.println("<h2>Error de conexion</h2>");
                    out.println(e.getMessage());
                }
                break;
            case "salir":
                response.sendRedirect("index.html");
                break;
            default:
                response.sendRedirect("index.html");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
