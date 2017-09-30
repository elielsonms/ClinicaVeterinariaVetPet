package com.vetpet.webservice;

import com.vetpet.bean.Animal;
import com.vetpet.bean.Cliente;
import com.vetpet.bean.Consulta;
import com.vetpet.bean.Horario;
import com.vetpet.dao.AnimalDAO;
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

    private final HorarioDAO  horarioDAO  = new HorarioDAO();
    private final ConsultaDAO consultaDAO = new ConsultaDAO();
    private final ClienteDAO  clienteDAO  = new ClienteDAO();
    private final AnimalDAO   animalDAO   = new AnimalDAO();

    public List<HorarioDTO> obterHorarios(){
        List<Horario> horarios = horarioDAO.horariosLivres();
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
    
    public String registrarConsulta(String cpfCliente, String nomeAnimal, Long idHorario){
        try{
            Cliente cliente = clienteDAO.obterPorCPF(cpfCliente);
            if(cliente == null){
                return  "Clinte não identificado";
            }
            if(idHorario == null){
                return "Horário não identificado";
            }
            Horario horario = horarioDAO.obterPorId(idHorario);
            if(horario == null){
                return "Horário não identificado";
            }
            Consulta consulta = consultaDAO.obterPorIdHorario(idHorario);
            if(consulta != null){
                return "Horario já está agendado";
            }
            if(cliente.podeRealizarConsulta()){
                Animal animal = animalDAO.obterPorNomeECliente(nomeAnimal, cliente.getIdCliente());
                if(animal == null){
                    animal = new Animal();
                    animal.setDono(cliente);
                    animal.setNome(nomeAnimal);
                    animalDAO.inserir(animal);

                    animal = animalDAO.obterPorNomeECliente(nomeAnimal, cliente.getIdCliente());
                }

                Consulta novaConsulta = new Consulta();
                novaConsulta.setHorario(horario);
                novaConsulta.setCliente(cliente);
                novaConsulta.setAnimal(animal);

                consultaDAO.inserir(novaConsulta);
                return "Consulta salva com sucesso";
            }else{
                return "Quantidade de consultas para seu plano já terminou";
            }
        }catch(Exception e){
            e.printStackTrace();
            return "Erro ao marcar consulta, tente novamente.";
        }
        
    }
}
