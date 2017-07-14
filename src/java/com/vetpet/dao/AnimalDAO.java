package com.vetpet.dao;

import com.vetpet.bean.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author elielsonms
 */
public class AnimalDAO extends CommonDAO{

      public void inserir(Animal animal) throws SQLException{
        Connection c = getConnection();
        String query = "INSERT INTO Animal (nome) VALUES (?)";
        PreparedStatement st = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.setString(1,animal.getNome());

        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();
        Long idAnimal = null;
        if(rs.next()){
            idAnimal = rs.getLong(1);
            animal.setIdAnimal(idAnimal);
        }
        rs.close();

        st.close();
        c.close();
    }
    
    public Animal obterPorId(Long idAnimal) throws SQLException{
        Connection c = getConnection();
        String query = "SELECT * FROM Animal WHERE id_animal= ?";
        PreparedStatement st = c.prepareStatement(query);
        st.setLong(1, idAnimal);
        ResultSet rs = st.executeQuery();
        Animal animal = null;
        if(rs.next()){
            animal = montar(rs);
        }
        
        rs.close();;
        st.close();
        c.close();
        return animal;
    }

    private Animal montar(ResultSet rs) throws SQLException {
        Animal a = new Animal();
        a.setNome(rs.getString("nome"));
        a.setIdAnimal(rs.getLong("id_animal"));
        return a;
    }
    
}
