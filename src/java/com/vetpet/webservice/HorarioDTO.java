package com.vetpet.webservice;

/**
 *
 * @author SONY
 */
public class HorarioDTO {

    private Long idHorario;
    private String horario;
    private String medico;

    public HorarioDTO() {}

    public HorarioDTO(Long idHorario, String horario, String medico) {
        this.idHorario = idHorario;
        this.horario = horario;
        this.medico = medico;
    }

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
    
    
}
