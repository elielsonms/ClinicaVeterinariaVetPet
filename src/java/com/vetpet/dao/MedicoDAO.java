package com.vetpet.dao;

import com.vetpet.bean.Medico;
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
public class MedicoDAO extends CommonDAO{
    
    public void inserir(Medico medico) throws SQLException{
        Connection c = getConnection();
        String query = "INSERT INTO Medico (nome) VALUES (?)";
        PreparedStatement st = c.prepareStatement(query);
        st.setString(1,medico.getNome());

        st.executeUpdate();

        st.close();
        c.close();
    }
    
    public Medico obterPorId(Long idMedico) throws SQLException{
        Connection c = getConnection();
        String query = "SELECT * FROM Medico WHERe id_medico = ?";
        PreparedStatement st = c.prepareStatement(query);
        st.setLong(1, idMedico);
        ResultSet rs = st.executeQuery();
        Medico medico = null;
        if(rs.next()){
            medico = montar(rs);
        }
        
        rs.close();;
        st.close();
        c.close();
        return medico;
    }
    
    public List<Medico> obterMedicos() throws SQLException{
        Connection c = getConnection();
        String query = "SELECT * FROM Medico";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Medico> medicos = new ArrayList<>();
        while(rs.next()){
            medicos.add(montar(rs));
        }
        rs.close();;
        st.close();
        c.close();
        return medicos;
    }
    
    public Medico montar(ResultSet rs) throws SQLException{
        Medico m = new Medico();
        m.setIdMedico(rs.getLong("id_medico"));
        m.setNome(rs.getString("nome"));
        
        return m;
    }
}
