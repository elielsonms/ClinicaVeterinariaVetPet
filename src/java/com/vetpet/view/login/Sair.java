package com.vetpet.view.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elielsonms
 */
@WebServlet(name = "Sair", urlPatterns = {"/Sair"})
public class Sair extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("USUARIO");
        response.sendRedirect(request.getContextPath()+"/");
    }

}
