package com.vetpet.bean;

/**
 *
 * @author elielsonms
 */
public class PlanoSupremo implements Plano{

    @Override
    public String getNome() {
        return "Supremo";
    }

    @Override
    public Long getQuantidadeMensal() {
        return 30l;
    }

    @Override
    public Long getQuantidadeAnual() {
        return getQuantidadeMensal()*12;
    }

    @Override
    public Double getValor() {
        return 100d;
    }
    
    @Override
    public Plano aumentar(){
        return new PlanoSupremo();
    }
    
    @Override
    public Plano diminuir(){
        return new PlanoEspecial();
    }

}
