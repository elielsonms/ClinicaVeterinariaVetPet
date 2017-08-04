
package com.vetpet.bean;

/**
 *
 * @author elielsonms
 */
public class PlanoBasico implements Plano{

    @Override
    public String getNome() {
        return "Basico";
    }

    @Override
    public Long getQuantidadeMensal() {
        return 5l;
    }
    
    @Override
    public Long getQuantidadeAnual() {
        return getQuantidadeMensal()*12;
    }

    @Override
    public Double getValor() {
        return 50d;
    }

    

}
