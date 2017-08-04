package com.vetpet.bean;

import java.util.List;

/**
 *
 * @author elielsonms
 */
public class Cliente {
    
    private Long idCliente;
    private String nome;
    private String usuario;
    private String senha;
    private Long qtdConsultasTotal;
    private Long qtdConsultasAno;
    private Long qtdConsultasMes;
    private Plano plano;

    private List<Animal> animais;
    
    public boolean podeRealizarConsulta(){
        return qtdConsultasAno < plano.getQuantidadeAnual() && qtdConsultasMes < plano.getQuantidadeMensal();
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public Long getQtdConsultasTotal() {
        return qtdConsultasTotal;
    }

    public void setQtdConsultasTotal(Long qtdConsultasTotal) {
        this.qtdConsultasTotal = qtdConsultasTotal;
    }

    public Long getQtdConsultasAno() {
        return qtdConsultasAno;
    }

    public void setQtdConsultasAno(Long qtdConsultasAno) {
        this.qtdConsultasAno = qtdConsultasAno;
    }

    public Long getQtdConsultasMes() {
        return qtdConsultasMes;
    }

    public void setQtdConsultasMes(Long qtdConsultasMes) {
        this.qtdConsultasMes = qtdConsultasMes;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

}
