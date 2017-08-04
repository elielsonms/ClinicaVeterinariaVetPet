package com.vetpet.view.cliente;

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
@WebServlet(name = "LisaCliente", urlPatterns = {"/cliente/ListaCliente"})
public class ListaCliente extends ServletSeguro {

    @Override
    public void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("request", request);
        try {
            request.setAttribute("clientes", new ClienteDAO().obterClientes());
        } catch (SQLException ex) {
            request.setAttribute("clientes", null);
            Logger.getLogger(ListaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/WEB-INF/cliente/ListaCliente.jsp").forward(request, response);
    }

    @Override
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        get(request, response);
    }

}
