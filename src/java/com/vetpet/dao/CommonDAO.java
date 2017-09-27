package com.vetpet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elielsonms
 */
public class CommonDAO {
    
    public CommonDAO(){
        try {  
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://elielsonms.com:53891/VetPet", "vetPet", "v3tp6y7i");
        //return DriverManager.getConnection("jdbc:mysql://localhost:3388/VetPet", "root", "");
        //return DriverManager.getConnection("jdbc:mysql://localhost:53891/VetPet", "vetPet", "v3tp6y7i");
    }
    
    
}
