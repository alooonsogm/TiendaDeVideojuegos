package despliegue.practica;

import java.sql.*;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CompruebaUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CompruebaUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CompruebaUser at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        
        String enviar = request.getParameter("enviar");
        
        if (enviar == null) {
            response.sendRedirect("index.html");
        } else {
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            try {
                Conexion laConexion = new Conexion();
                ResultSet elResultado = laConexion.comprobarUsuario(user, pass);
                if (elResultado.absolute(1)) {
                    if (elResultado.getBoolean("adm") == true) {
                        response.sendRedirect("funcionesDeAdmin.jsp");
                    } else {
                        response.sendRedirect("funcionesDeCliente.jsp");
                    }
                } else {
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
