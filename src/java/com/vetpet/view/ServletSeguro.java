package com.vetpet.view;

import com.vetpet.bean.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elielsonms
 */
public abstract class ServletSeguro extends HttpServlet {

    @Override
    protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("request", request);
        if(request.getSession().getAttribute("USUARIO") == null){
            response.sendRedirect(request.getContextPath()+"/Login");
            return;
        }
        request.setAttribute("usuario", ((Cliente)request.getSession().getAttribute("USUARIO")).getNome());
        get(request, response);
    }
    
    public abstract void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;

    @Override
    protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("request", request);
        if(request.getSession().getAttribute("USUARIO") == null){
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }
        request.setAttribute("usuario", ((Cliente)request.getSession().getAttribute("USUARIO")).getNome());
        post(request, response);
    }
    
    public abstract void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;

}
