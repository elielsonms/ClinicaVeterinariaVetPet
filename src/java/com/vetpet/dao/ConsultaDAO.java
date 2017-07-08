package com.vetpet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class ConsultaDAO {
    
    public ConsultaDAO(){
        try{
          Class.forName("com.mysql.jdbc.Driver");  

            Connection connection = DriverManager.getConnection("jdbc:mysql://elielsonms.com:53891/VetPet", "vetPet", "v3tp6y7i");
            System.out.println(connection);
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,null,e);
        }
    }
    
}
