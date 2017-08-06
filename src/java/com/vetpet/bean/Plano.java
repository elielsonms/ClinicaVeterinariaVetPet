
package com.vetpet.bean;

/**
 *
 * @author elielsonms
 */
public interface Plano {
    
    public String getNome();
    public Long getQuantidadeMensal();
    public Long getQuantidadeAnual();
    public Double getValor();
    public Plano aumentar();
    public Plano diminuir();

}
