package com.vetpet.view.consulta;

import com.vetpet.bean.Cliente;
import com.vetpet.bean.Horario;
import com.vetpet.bean.Medico;
import com.vetpet.dao.HorarioDAO;
import com.vetpet.dao.MedicoDAO;
import com.vetpet.view.ServletSeguro;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elielsonms
 */
@WebServlet(name = "InformarDados", urlPatterns = {"/consulta/InformarDados"})
public class InformarDados extends ServletSeguro {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        request.setAttribute("request",request);

        Horario h = new HorarioDAO().obterPorId(Long.parseLong(request.getParameter("id_horario")));

        request.setAttribute("idHorario", h.getIdHorario());
        request.setAttribute("nomeMedico", h.getMedico().getNome());
        request.setAttribute("dataSelecionada", h.getDataHora());
        request.setAttribute("nomeCliente",((Cliente)request.getSession().getAttribute("USUARIO")).getNome());
        request.getRequestDispatcher("/WEB-INF/consulta/InformarDados.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InformarDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void post(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InformarDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
