package com.vetpet.view.cliente;

import com.vetpet.bean.Cliente;
import com.vetpet.bean.PlanoGratuito;
import com.vetpet.dao.ClienteDAO;
import java.io.IOException;
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
@WebServlet(name = "CadastroCliente", urlPatterns = {"/cliente/Cadastro"})
public class CadastroCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("request", request);
        request.getRequestDispatcher("/WEB-INF/cliente/Cadastro.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente c = new Cliente();
        c.setPlano(new PlanoGratuito());
        c.setNome(request.getParameter("nome"));
        c.setCpf(request.getParameter("cpf"));
        c.setUsuario(request.getParameter("usuario"));
        c.setSenha(request.getParameter("senha"));

        ClienteDAO clienteDAO = new ClienteDAO();
        if(clienteDAO.existeCPF(c.getCpf())){
            request.setAttribute("mensagem", "Cliente já cadastrado com este CPF");
            doGet(request, response);
        }else{
            if(clienteDAO.existeLogin(c.getUsuario())){
                request.setAttribute("mensagem", "Usuario existente, tente outro.");
                doGet(request, response);
            }else{
                try {

                    c.setIdCliente(clienteDAO.inserir(c));
                    request.getSession().setAttribute("USUARIO", c);
                    response.sendRedirect(request.getContextPath()+"/Menu");
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
                    doGet(request, response);
                }
            }
        }
    }
}
