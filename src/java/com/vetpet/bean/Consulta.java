package com.vetpet.bean;

/**
 *
 * @author aluno
 */
public class Consulta {
    
    private Long idConsulta;
    private Cliente cliente;
    private Animal animal;
    private Horario horario;

    public Long getIdConsulta() {
        return idConsulta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

}
