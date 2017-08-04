package com.vetpet.bean;

/**
 *
 * @author elielsonms
 */
public class PlanoGratuito implements Plano{

    @Override
    public String getNome() {
        return "Gratuito";
    }

    @Override
    public Long getQuantidadeMensal() {
        return 1l;
    }
    
    @Override
    public Long getQuantidadeAnual() {
        return 1l;
    }

    @Override
    public Double getValor() {
        return 0d;
    }

}
