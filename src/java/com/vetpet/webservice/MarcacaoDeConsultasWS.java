package com.vetpet.webservice;

import com.vetpet.bean.Animal;
import com.vetpet.bean.Cliente;
import com.vetpet.bean.Consulta;
import com.vetpet.bean.Horario;
import com.vetpet.dao.AnimalDAO;
import com.vetpet.dao.ClienteDAO;
import com.vetpet.dao.HorarioDAO;
import com.vetpet.dao.ConsultaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author elielsonms
 */
@WebService
public class MarcacaoDeConsultasWS {

    private final HorarioDAO  horarioDAO  = new HorarioDAO();
    private final ConsultaDAO consultaDAO = new ConsultaDAO();
    private final ClienteDAO  clienteDAO  = new ClienteDAO();
    private final AnimalDAO   animalDAO   = new AnimalDAO();
    
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

    public List<HorarioDTO> obterHorarios(){
        return horarios; 
    }
    
    public String registrarConsulta(String cpfCliente, String nomeAnimal,Long idHorario){
        try{
            Horario horario = horarioDAO.obterPorId(idHorario);
            if(horario == null){
                return "Horário não identificado";
            }
            Cliente cliente = clienteDAO.obterPorCPF(cpfCliente);
            if(cliente == null){
                return  "Clinte não identificado";
            }
            Animal animal = animalDAO.obterPorNomeECliente(nomeAnimal, cliente.getIdCliente());
            if(animal == null){
                animal = new Animal();
                animal.setDono(cliente);
                animal.setNome(nomeAnimal);
                animalDAO.inserir(animal);

                animal = animalDAO.obterPorNomeECliente(nomeAnimal, cliente.getIdCliente());
            }

            Consulta consulta = new Consulta();
            consulta.setHorario(horario);
            consulta.setCliente(cliente);
            consulta.setAnimal(animal);

            consultaDAO.inserir(consulta);
            return "OK";
        }catch(Exception e){
            return "NO";
        }
        
    }
}
