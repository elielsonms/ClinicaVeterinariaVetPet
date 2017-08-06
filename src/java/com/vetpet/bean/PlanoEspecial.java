package com.vetpet.bean;

/**
 *
 * @author elielsonms
 */
public class PlanoEspecial implements Plano{

    @Override
    public String getNome() {
        return "Especial";
    }

    @Override
    public Long getQuantidadeMensal() {
        return 10l;
    }
    
    @Override
    public Long getQuantidadeAnual() {
        return getQuantidadeMensal()*12;
    }

    @Override
    public Double getValor() {
        return 70d;
    }
    
    @Override
    public Plano aumentar(){
        return new PlanoSupremo();
    }
    
    @Override
    public Plano diminuir(){
        return new PlanoBasico();
    }

}
