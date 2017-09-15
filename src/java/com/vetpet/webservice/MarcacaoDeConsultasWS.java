/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vetpet.webservice;

import javax.jws.WebService;

/**
 *
 * @author elielsonms
 */
@WebService(endpointInterface =  "com.vetpet.webservice")
public class MarcacaoDeConsultasWS {
    
    public String marcar(){
        return "Marcada";
    }
}
