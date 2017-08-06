package com.vetpet.view.animal;

import com.vetpet.bean.Cliente;
import com.vetpet.dao.AnimalDAO;
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
 * @author SONY
 */
@WebServlet(name = "MeusAnimais", urlPatterns = {"/animal/Meus"})
public class MeusAnimais extends ServletSeguro {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            request.setAttribute("animais", new AnimalDAO().meus(((Cliente)request.getSession().getAttribute("USUARIO")).getIdCliente()));
        } catch (SQLException ex) {
            Logger.getLogger(MeusAnimais.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/WEB-INF/animal/Meus.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        get(request, response);
    }

}
