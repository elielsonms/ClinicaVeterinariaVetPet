package com.vetpet.bean;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class Consulta {
    
    private Long idConsulta;
    private Cliente cliente;
    private Animal animal;
    private Date data;
    private Medico medico;

    public Long getIdConsulta() {
        return idConsulta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Date getData() {
        return data;
    }

    public Medico getMedico() {
        return medico;
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

    public void setData(Date data) {
        this.data = data;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}
