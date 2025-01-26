package despliegue.practica;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ComprarCatalogo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ComprarCatalogo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ComprarCatalogo at " + request.getContextPath() + "</h1>");
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
        String eleccion = request.getParameter("enviar");

        if (eleccion.equals("Comprar consolas")) {
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Consolas compradas con exito</h1>");
                out.println("<form action=\"funcionesDeCliente.jsp\" method=\"post\">");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>CPU potencia</th>");
                out.println("<th>GPU potencia</th>");
                out.println("<th>Compania</th>");
                out.println("<th>Precio</th>");
                out.println("<th>Unidades disponibles</th>");
                out.println("<th>Generacion</th>");

                Conexion miConexion = new Conexion();

                for (String nombre : request.getParameterValues("compra")) {
                    miConexion.comprarConsola(nombre);
                    ArrayList<String> datosConsola = miConexion.mostrarUnaConsola(nombre);
                    out.println("</tr>");
                    for (String dato : datosConsola) {
                        out.println("<td>" + dato + "</td>");
                    }
                    out.println("</tr>");
                }

                out.println("<tr>");
                out.println("<td colspan=\"7\" style=\"text-align: center;\">");
                out.println("<input type=\"submit\" name=\"enviar\" value=\"Volver\">");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                out.println("<h2>Error de conexion</h2>");
                out.println(e.getMessage());
            }
        } else if (eleccion.equals("Comprar juego")) {
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Juegos comprados con exito</h1>");
                out.println("<form action=\"funcionesDeCliente.jsp\" method=\"post\">");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>Plataforma</th>");
                out.println("<th>Compania desarrolladora</th>");
                out.println("<th>Genero</th>");
                out.println("<th>Puntuacion Metacritic</th>");
                out.println("<th>Precio</th>");
                out.println("<th>Unidades disponibles</th>");
                out.println("<th>Generacion</th>");

                Conexion miConexion = new Conexion();

                for (String id : request.getParameterValues("compra")) {
                    miConexion.comprarJuego(id);
                    ArrayList<String> datosJuego = miConexion.mostrarUnJuego(id);
                    out.println("</tr>");
                    for (String dato : datosJuego) {
                        out.println("<td>" + dato + "</td>");
                    }
                    out.println("</tr>");
                }

                out.println("<tr>");
                out.println("<td colspan=\"8\" style=\"text-align: center;\">");
                out.println("<input type=\"submit\" name=\"enviar\" value=\"Volver\">");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                out.println("<h2>Error de conexion</h2>");
                out.println(e.getMessage());
            }
        } else if (eleccion.equals("Comprar juegos")) {
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Juegos comprados con exito</h1>");
                out.println("<form action=\"funcionesDeCliente.jsp\" method=\"post\">");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>Plataforma</th>");
                out.println("<th>Compania desarrolladora</th>");
                out.println("<th>Genero</th>");
                out.println("<th>Puntuacion Metacritic</th>");
                out.println("<th>Precio</th>");
                out.println("<th>Unidades disponibles</th>");
                out.println("<th>Generacion</th>");

                Conexion miConexion = new Conexion();

                for (String id : request.getParameterValues("compra")) {
                    miConexion.comprarJuego(id);
                    ArrayList<String> datosJuego = miConexion.mostrarUnJuego(id);
                    out.println("</tr>");
                    for (String dato : datosJuego) {
                        out.println("<td>" + dato + "</td>");
                    }
                    out.println("</tr>");
                }

                out.println("<tr>");
                out.println("<td colspan=\"8\" style=\"text-align: center;\">");
                out.println("<input type=\"submit\" name=\"enviar\" value=\"Volver\">");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                out.println("<h2>Error de conexion</h2>");
                out.println(e.getMessage());
            }
        } else if (eleccion.equals("Comprar productos")) {
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Productos comprados con exito</h1>");
                out.println("<form action=\"funcionesDeCliente.jsp\" method=\"post\">");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Nombre del producto</th>");
                out.println("<th>Precio</th>");
                out.println("<th>Unidades disponibles</th>");

                Conexion miConexion = new Conexion();

                for (String nombre : request.getParameterValues("compra")) {
                    miConexion.comprarJuego2(nombre);
                    miConexion.comprarConsola(nombre);
                    ArrayList<String> datosConsola = miConexion.mostrarUnaConsola2(nombre);

                    if (datosConsola == null) {
                        ArrayList<String> datosJuego = miConexion.mostrarUnJuego3(nombre);
                        out.println("</tr>");
                        for (String dato : datosJuego) {
                            out.println("<td>" + dato + "</td>");
                        }
                        out.println("</tr>");
                    } else {
                        out.println("</tr>");
                        for (String dato : datosConsola) {
                            out.println("<td>" + dato + "</td>");
                        }
                        out.println("</tr>");
                    }
                }

                out.println("<tr>");
                out.println("<td colspan=\"4\" style=\"text-align: center;\">");
                out.println("<input type=\"submit\" name=\"enviar\" value=\"Volver\">");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
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
