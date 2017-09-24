package com.vetpet.webservice;

import javax.xml.ws.Endpoint;

/**
 *
 * @author SONY
 */
public class Publish {

    public static void main(String[] ar){
        Endpoint.publish("http://192.168.0.24:9999/MarcarConsulta", new MarcacaoDeConsultasWS());
    }    
}
