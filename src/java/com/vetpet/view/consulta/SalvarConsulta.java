package com.vetpet.view.consulta;

import com.vetpet.bean.Animal;
import com.vetpet.bean.Cliente;
import com.vetpet.bean.Consulta;
import com.vetpet.dao.AnimalDAO;
import com.vetpet.dao.ClienteDAO;
import com.vetpet.dao.ConsultaDAO;
import com.vetpet.dao.MedicoDAO;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "SalvarConsulta", urlPatterns = {"/consulta/Salvar"})
public class SalvarConsulta extends ServletSeguro {
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        ConsultaDAO consultaDAO = new ConsultaDAO();
        MedicoDAO medicoDAO = new MedicoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        AnimalDAO animalDAO = new AnimalDAO();

        Consulta consulta = new Consulta();
       
        try {
            Cliente cl = new Cliente();
            cl.setNome(request.getParameter("cliente"));
            clienteDAO.inserir(cl);
            consulta.setCliente(cl);
            Animal a = new Animal();
            a.setNome(request.getParameter("animal"));
            a.setDono(cl);
            animalDAO.inserir(a);
            consulta.setAnimal(a);
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                consulta.setData(df.parse(request.getParameter("data")));
            } catch (ParseException ex) {
                Logger.getLogger(SalvarConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
            consulta.setMedico(medicoDAO.obterPorId(Long.parseLong(request.getParameter("medico"))));
            
        } finally {            
            out.close();
        }
        consultaDAO.inserir(consulta);
        
        request.getRequestDispatcher("/WEB-INF/consulta/ConsultaSalva.jsp").forward(request, response);
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
    public void get(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SalvarConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void post(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SalvarConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
