package com.vetpet.bean;

import java.util.Date;

public class Horario {
    
    private Long idHorario;
    private Long idMedico;
    private Date DataHora;

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

}
