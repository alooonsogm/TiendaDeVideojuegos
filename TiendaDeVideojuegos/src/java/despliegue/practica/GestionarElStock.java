package despliegue.practica;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GestionarElStock extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionarElStock</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GestionarElStock at " + request.getContextPath() + "</h1>");
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

        if (eleccion.equals("Insertar consola")) {
            String nombre = request.getParameter("nombre");
            String cpu = request.getParameter("cpu");
            String gpu = request.getParameter("gpu");
            String compañia = request.getParameter("compañia");
            String precio = request.getParameter("precio");
            String unidades = request.getParameter("unidades");
            String generacion = request.getParameter("generacion");

            try {
                Conexion miConexion = new Conexion();
                miConexion.insertarConsola(nombre, cpu, gpu, compañia, precio, unidades, generacion);

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Consola insertada con exito</h1>");
                out.println("<form action=\"funcionesDeAdmin.jsp\" method=\"post\">");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>CPU potencia</th>");
                out.println("<th>GPU potencia</th>");
                out.println("<th>Compania</th>");
                out.println("<th>Precio</th>");
                out.println("<th>Unidades disponibles</th>");
                out.println("<th>Generacion</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>" + nombre + "</td>");
                out.println("<td>" + cpu + "</td>");
                out.println("<td>" + gpu + "</td>");
                out.println("<td>" + compañia + "</td>");
                out.println("<td>" + precio + "</td>");
                out.println("<td>" + unidades + "</td>");
                out.println("<td>" + generacion + "</td>");
                out.println("</tr>");
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
        } else if (eleccion.equals("Insertar juego")) {
            String nombre = request.getParameter("nombre");
            String compañia = request.getParameter("compañia");
            String genero = request.getParameter("genero");
            String puntuacion = request.getParameter("puntuacion");
            String precio = request.getParameter("precio");
            String unidades = request.getParameter("unidades");
            String plataforma = request.getParameter("plataforma");

            try {
                Conexion miConexion = new Conexion();
                miConexion.insertarJuego(nombre, compañia, genero, puntuacion, precio, unidades, plataforma);

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Juego insertado con exito</h1>");
                out.println("<form action=\"funcionesDeAdmin.jsp\" method=\"post\">");
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
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>" + nombre + "</td>");
                out.println("<td>" + plataforma + "</td>");
                out.println("<td>" + compañia + "</td>");
                out.println("<td>" + genero + "</td>");
                out.println("<td>" + puntuacion + "</td>");
                out.println("<td>" + precio + "</td>");
                out.println("<td>" + unidades + "</td>");

                if (plataforma.equals("Xbox one") || plataforma.equals("PS4")) {
                    out.println("<td>vieja</td>");
                } else if (plataforma.equals("Nintendo Switch y Nintendo Switch Lite")) {
                    out.println("<td>actual</td>");
                } else if (plataforma.equals("Xbox Series X y Xbox Series S") || plataforma.equals("PS5 con CD y PS5 sin CD")) {
                    out.println("<td>nueva</td>");
                }

                out.println("</tr>");
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
        } else if (eleccion.equals("Eliminar consola")) {
            String nombre = request.getParameter("eleccion");

            try {
                Conexion miConexion = new Conexion();
                ArrayList<String> datosConsola = miConexion.mostrarUnaConsola(nombre);

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Consola eliminada con exito</h1>");
                out.println("<form action=\"funcionesDeAdmin.jsp\" method=\"post\">");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>CPU potencia</th>");
                out.println("<th>GPU potencia</th>");
                out.println("<th>Compania</th>");
                out.println("<th>Precio</th>");
                out.println("<th>Unidades disponibles</th>");
                out.println("<th>Generacion</th>");
                out.println("</tr>");
                out.println("<tr>");
                for (String dato : datosConsola) {
                    out.println("<td>" + dato + "</td>");
                }
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td colspan=\"7\" style=\"text-align: center;\">");
                out.println("<input type=\"submit\" name=\"enviar\" value=\"Volver\">");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

                miConexion.eliminarConsola(nombre);
            } catch (Exception e) {
                out.println("<h2>Error de conexion</h2>");
                out.println(e.getMessage());
            }
        } else if (eleccion.equals("Eliminar juego")) {
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Juegos eliminados con exito</h1>");
                out.println("<form action=\"funcionesDeAdmin.jsp\" method=\"post\">");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>Plataforma</th>");
                out.println("<th>Compania desarrolladora</th>");
                out.println("<th>Genero del juego</th>");
                out.println("<th>Puntuacion en Metacritic</th>");
                out.println("<th>Precio</th>");
                out.println("<th>Unidades disponibles</th>");
                out.println("<th>Generacion</th>");

                Conexion miConexion = new Conexion();

                for (String id : request.getParameterValues("juegoEliminados")) {
                    ArrayList<String> datosJuego = miConexion.mostrarUnJuego(id);
                    out.println("</tr>");
                    for (String dato : datosJuego) {
                        out.println("<td>" + dato + "</td>");
                    }
                    out.println("</tr>");
                    miConexion.eliminarJuego(id);
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
        } else if (eleccion.equals("Modificar consola")) {
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Modifica los datos de la consola</h1>");

                Conexion miConexion = new Conexion();
                String nombre = request.getParameter("eleccion");
                ArrayList<String> datosConsola = miConexion.mostrarUnaConsola(nombre);

                out.println("<form action=\"gestionarElStock\" method=\"post\">");
                out.println("<label>Nombre</label>");
                out.println("<select name=\"nombre\">");
                out.println("<option value=\"" + datosConsola.get(0) + "\">" + datosConsola.get(0) + "</option>");
                out.println("</select>");
                out.println("<label>Potencia CPU</label>");
                out.println("<input type=\"text\" name=\"cpu\" value='" + datosConsola.get(1) + "'><br><br>");
                out.println("<label>Potencia GPU</label>");
                out.println("<input type=\"text\" name=\"gpu\" value='" + datosConsola.get(2) + "'><br><br>");
                out.println("<label>Compañia</label>");
                out.println("<input type=\"text\" name=\"compañia\" value='" + datosConsola.get(3) + "'><br><br>");
                out.println("<label>Precio</label>");
                out.println("<input type=\"text\" name=\"precio\" value='" + datosConsola.get(4) + "'><br><br>");
                out.println("<label>Unidades disponibles</label>");
                out.println("<input type=\"text\" name=\"unidades\" value='" + datosConsola.get(5) + "'><br><br>");
                out.println("<label>Generacion</label>");
                out.println("<select name=\"generacion\">");
                out.println("<option value=\"vieja\">vieja</option>");
                out.println("<option value=\"nueva\">nueva</option>");
                out.println("<option value=\"actual\">actual</option>");
                out.println("</select>");
                out.println("<input type=\"submit\" name=\"enviar\" value=\"Actualizar consola\">");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                out.println("<h2>Error de conexion</h2>");
                out.println(e.getMessage());
            }
        } else if (eleccion.equals("Actualizar consola")) {
            String nombre = request.getParameter("nombre");
            String cpu = request.getParameter("cpu");
            String gpu = request.getParameter("gpu");
            String compañia = request.getParameter("compañia");
            String precio = request.getParameter("precio");
            String unidades = request.getParameter("unidades");
            String generacion = request.getParameter("generacion");

            try {
                Conexion miConexion = new Conexion();
                miConexion.modificarConsola(nombre, cpu, gpu, compañia, precio, unidades, generacion);

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Consola actualizada con exito</h1>");
                out.println("<form action=\"funcionesDeAdmin.jsp\" method=\"post\">");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>CPU potencia</th>");
                out.println("<th>GPU potencia</th>");
                out.println("<th>Compania</th>");
                out.println("<th>Precio</th>");
                out.println("<th>Unidades disponibles</th>");
                out.println("<th>Generacion</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>" + nombre + "</td>");
                out.println("<td>" + cpu + "</td>");
                out.println("<td>" + gpu + "</td>");
                out.println("<td>" + compañia + "</td>");
                out.println("<td>" + precio + "</td>");
                out.println("<td>" + unidades + "</td>");
                out.println("<td>" + generacion + "</td>");
                out.println("</tr>");
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
        } else if (eleccion.equals("Modificar juego")) {
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Modifica los datos del juego</h1>");

                Conexion miConexion = new Conexion();
                String nombre = request.getParameter("eleccion");
                ArrayList<String> datosJuegos = miConexion.mostrarUnJuego2(nombre);

                out.println("<form action=\"gestionarElStock\" method=\"post\">");
                out.println("<label>Nombre</label>");
                out.println("<select name=\"nombre\">");
                out.println("<option value=\"" + datosJuegos.get(0) + "\">" + datosJuegos.get(0) + "</option>");
                out.println("</select>");
                out.println("<label>Plataforma</label>");
                out.println("<select name=\"plataforma\">");
                out.println("<option value=\"Xbox one\">Xbox one</option>");
                out.println("<option value=\"Xbox Series X y Xbox Series S\">Xbox Series X y Xbox Series S</option>");
                out.println("<option value=\"Nintendo Switch y Nintendo Switch Lite\">Nintendo Switch y Nintendo Switch Lite</option>");
                out.println("<option value=\"PS4\">PS4</option>");
                out.println("<option value=\"PS5 con CD y PS5 sin CD\">PS5 con CD y PS5 sin CD</option>");
                out.println("</select>");
                out.println("<label>Compañia desarrolladora</label>");
                out.println("<input type=\"text\" name=\"compañia\" value='" + datosJuegos.get(2) + "'><br><br>");
                out.println("<label>Genero</label>");
                out.println("<input type=\"text\" name=\"genero\" value='" + datosJuegos.get(3) + "'><br><br>");
                out.println("<label>Puntuacion Metacritic</label>");
                out.println("<input type=\"text\" name=\"puntuacion\" value='" + datosJuegos.get(4) + "'><br><br>");
                out.println("<label>Precio</label>");
                out.println("<input type=\"text\" name=\"precio\" value='" + datosJuegos.get(5) + "'><br><br>");
                out.println("<label>Unidades disponibles</label>");
                out.println("<input type=\"text\" name=\"unidades\" value='" + datosJuegos.get(6) + "'><br><br>");
                out.println("<input type=\"submit\" name=\"enviar\" value=\"Actualizar juego\">");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                out.println("<h2>Error de conexion</h2>");
                out.println(e.getMessage());
            }
        } else if (eleccion.equals("Actualizar juego")) {
            String nombre = request.getParameter("nombre");
            String plataforma = request.getParameter("plataforma");
            String compañia = request.getParameter("compañia");
            String genero = request.getParameter("genero");
            String puntuacion = request.getParameter("puntuacion");
            String precio = request.getParameter("precio");
            String unidades = request.getParameter("unidades");

            try {
                Conexion miConexion = new Conexion();
                miConexion.modificarJuego(nombre, plataforma, compañia, genero, puntuacion, precio, unidades);

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Centro Game</title>");
                out.println("<link rel=\"stylesheet\" href=\"estilos.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Juego actualizada con exito</h1>");
                out.println("<form action=\"funcionesDeAdmin.jsp\" method=\"post\">");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Nombre</th>");
                out.println("<th>Plataforma</th>");
                out.println("<th>Compania desarrolladora</th>");
                out.println("<th>Genero</th>");
                out.println("<th>Puntuacion Metacritic</th>");
                out.println("<th>Precio</th>");
                out.println("<th>Unidades disponibles</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>" + nombre + "</td>");
                out.println("<td>" + plataforma + "</td>");
                out.println("<td>" + compañia + "</td>");
                out.println("<td>" + genero + "</td>");
                out.println("<td>" + puntuacion + "</td>");
                out.println("<td>" + precio + "</td>");
                out.println("<td>" + unidades + "</td>");
                out.println("</tr>");
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
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
