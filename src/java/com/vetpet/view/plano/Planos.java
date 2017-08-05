package com.vetpet.view.plano;

import com.vetpet.bean.Cliente;
import com.vetpet.bean.Plano;
import com.vetpet.dao.ClienteDAO;
import com.vetpet.view.ServletSeguro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elielsonms
 */
@WebServlet(name = "Planos", urlPatterns = {"/plano/Planos"})
public class Planos extends ServletSeguro {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cliente = ((Cliente)request.getSession().getAttribute("USUARIO"));
        request.setAttribute("classe"+cliente.getPlano().getNome(), "meu_plano");
        request.getRequestDispatcher("/WEB-INF/plano/planos.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente cliente = ((Cliente)request.getSession().getAttribute("USUARIO"));
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.alterarPlano(cliente.getIdCliente(),request.getParameter("plano"));
            request.getSession().setAttribute("USUARIO",clienteDAO.obterPorId(cliente.getIdCliente()));
        } catch (SQLException ex) {
            Logger.getLogger(Planos.class.getName()).log(Level.SEVERE, null, ex);
        }
        get(request, response);
    }

    

}
