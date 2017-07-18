package com.vetpet.view.consulta;

import com.vetpet.dao.ConsultaDAO;
import com.vetpet.view.ServletSeguro;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "ConsultasAgendadas", urlPatterns = {"/ConsultasAgendadas"})
public class ConsultasAgendadas extends ServletSeguro {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("consultas", new ConsultaDAO().obterConsultas());
            request.getRequestDispatcher("/WEB-INF/consulta/ConsultasAgendadas.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasAgendadas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(ConsultasAgendadas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsultasAgendadas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
