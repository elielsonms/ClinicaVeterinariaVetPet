package com.vetpet.view.consulta;

import com.vetpet.bean.Cliente;
import com.vetpet.bean.Horario;
import com.vetpet.dao.ConsultaDAO;
import com.vetpet.dao.HorarioDAO;
import com.vetpet.dao.MedicoDAO;
import com.vetpet.view.ServletSeguro;
import com.vetpet.webservice.HorarioDTO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author elielsonms
 */
@WebServlet(name = "SelecionarData", urlPatterns = {"/consulta/SelecionarData"})
public class SelecionarData extends ServletSeguro {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("request",request);
        Cliente cl = (Cliente)request.getSession().getAttribute("USUARIO");
        if(cl.podeRealizarConsulta()){
            request.setAttribute("horariosLivres", horariosLivresDTO());
            request.getRequestDispatcher("/WEB-INF/consulta/SelecionarData.jsp").forward(request, response);
        }else{
            request.setAttribute("cliente", cl);
            request.getRequestDispatcher("/WEB-INF/consulta/NaoPodeRealizarConsulta.jsp").forward(request, response);
        }
    }
    
     private List<HorarioDTO> horariosLivresDTO(){
        List<Horario> horarios = new HorarioDAO().horariosLivres();
        List<HorarioDTO> horariosDTO = new ArrayList<HorarioDTO>();
        for(Horario h : horarios){
            try{
                horariosDTO.add(new HorarioDTO(h.getIdHorario(), h.getDataHoraFormatada(), h.getMedico().getNome()));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return horariosDTO;
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
    public void get(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }
}
