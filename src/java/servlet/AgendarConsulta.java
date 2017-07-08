/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bd.Dados;
import com.vetpet.bean.Consulta;
import com.vetpet.dao.ConsultaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "AgendarConsulta", urlPatterns = {"/AgendarConsulta"})
public class AgendarConsulta extends HttpServlet {
    private static List<Consulta> consultas;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConsultaDAO consultaDAO = new ConsultaDAO();
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Consulta consulta = new Consulta();
       
        try {
            consulta.setCliente(request.getParameter("cliente"));
            consulta.setAnimal(request.getParameter("animal"));
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                consulta.setData(df.parse(request.getParameter("data")));
            } catch (ParseException ex) {
                Logger.getLogger(AgendarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
            consulta.setMedico(request.getParameter("medico"));
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgendarConsulta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Sistema de Marcação de Consultas da Clinica Veterinária VetPet</h1>");
            out.format("<h1>Olá %s sua consulta para o animal %s foi agendada para o dia %s</h1>",consulta.getCliente(),consulta.getAnimal(),df.format(consulta.getData()));
            out.format("<a href='index.html'>Voltar</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
        Dados.consultas.add(consulta);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
