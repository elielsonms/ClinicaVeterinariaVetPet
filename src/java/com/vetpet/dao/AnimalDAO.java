package com.vetpet.dao;

import com.vetpet.bean.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elielsonms
 */
public class AnimalDAO extends CommonDAO{

      public void inserir(Animal animal) throws SQLException{
        Connection c = getConnection();
        String query = "INSERT INTO Animal (nome,id_cliente) VALUES (?,?)";
        PreparedStatement st = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.setString(1,animal.getNome());
        st.setLong(2, animal.getDono().getIdCliente());

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

    public List<Animal> meus(Long idCliente) throws SQLException {
        Connection c = getConnection();
        String query = "SELECT * FROM Animal WHERE id_cliente= ?";
        PreparedStatement st = c.prepareStatement(query);
        st.setLong(1, idCliente);
        ResultSet rs = st.executeQuery();
        List<Animal> animais = new ArrayList<Animal>();
        while(rs.next()){
            animais.add(montar(rs));
        }

        rs.close();;
        st.close();
        c.close();
        return animais;
    }
    
}
