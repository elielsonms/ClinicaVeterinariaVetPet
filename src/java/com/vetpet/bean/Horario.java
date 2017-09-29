package com.vetpet.bean;

import com.vetpet.util.DataUtil;
import java.util.Date;

/**
 *
 * @author elielsonms
 */
public class Horario {
    
    private Long idHorario;
    private Medico medico;
    private Date dataHora;

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    
    public String getDataHoraFormatada(){
        return DataUtil.formatar(getDataHora());
    }

}
