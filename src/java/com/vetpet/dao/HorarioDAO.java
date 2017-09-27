package com.vetpet.dao;

import com.vetpet.bean.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author SONY
 */
public class HorarioDAO extends CommonDAO{
    
    public Horario obterPorId(Long idHorario) throws SQLException{
        Connection c = getConnection();
        String query = "SELECT * FROM Horario WHERe id_horario = ?";
        PreparedStatement st = c.prepareStatement(query);
        st.setLong(1, idHorario);
        ResultSet rs = st.executeQuery();
        Horario horario = null;
        if(rs.next()){
            horario = montar(rs);
        }
        
        rs.close();;
        st.close();
        c.close();
        return horario;
    }
    
        public List<Horario> obterHorarios(Long idHorario) throws SQLException{
        List<Horario> horarios = new ArrayList<>();
        
        Connection c = getConnection();
        String query = "SELECT id_Horario, id_Medico, DataHora FROM Horario";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            horarios.add (montar(rs));
        }
        
        rs.close();;
        st.close();
        c.close();
        return horarios;
    }
    
    public Horario montar(ResultSet rs) throws SQLException{
        Horario h = new Horario();
        h.setIdHorario(rs.getLong("idHorario"));
        
        return h;
    }
    
}
