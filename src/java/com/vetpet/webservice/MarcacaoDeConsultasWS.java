package com.vetpet.webservice;

import com.vetpet.dao.ClienteDAO;
import com.vetpet.dao.HorarioDAO;
import com.vetpet.dao.ConsultaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author elielsonms
 */
@WebService
public class MarcacaoDeConsultasWS {
    
    private HorarioDAO horarioDAO;
    private ConsultaDAO consultaDAO;
    private ClienteDAO clienteDAO;
    
    private List<HorarioDTO> horarios;
    
    public MarcacaoDeConsultasWS(){
        horarios = new ArrayList<HorarioDTO>();
        HorarioDTO h = new HorarioDTO();
        h.setIdHorario(1L);
        h.setMedico("Arnoldo");
        h.setHorario("25/09/2017 08:00");
        
        horarios.add(h);
        
        h = new HorarioDTO();
        h.setIdHorario(2L);
        h.setMedico("Arnoldo");
        h.setHorario("25/09/2017 09:00");
        
        horarios.add(h);
        
        h = new HorarioDTO();
        h.setIdHorario(3L);
        h.setMedico("Arnoldo");
        h.setHorario("25/09/2017 10:00");
        
        horarios.add(h);
        
        h = new HorarioDTO();
        h.setIdHorario(4L);
        h.setMedico("Arnoldo");
        h.setHorario("25/09/2017 11:00");
        
        h = new HorarioDTO();
        h.setIdHorario(5L);
        h.setMedico("Vania");
        h.setHorario("25/09/2017 08:00");
        
        horarios.add(h);
        
        h = new HorarioDTO();
        h.setIdHorario(6L);
        h.setMedico("Vania");
        h.setHorario("25/09/2017 09:00");
        
        horarios.add(h);
        
        h = new HorarioDTO();
        h.setIdHorario(7L);
        h.setMedico("Vania");
        h.setHorario("25/09/2017 10:00");
        
        horarios.add(h);
        
        h = new HorarioDTO();
        h.setIdHorario(8L);
        h.setMedico("Vania");
        h.setHorario("25/09/2017 11:00");
        
        horarios.add(h);
    }
    
    public String marcar(){
        return "marcado";
    }
    
    public List<HorarioDTO> obterHorarios(){
        return horarios; 
    }
    
    public String registrarConsulta(String cpf, HorarioDTO horarioDTO){
        if(horarios.contains(horarioDTO)){
            return "OK";
        }else{
            return "NO";
        }
    }
}
