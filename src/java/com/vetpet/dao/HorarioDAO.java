package com.vetpet.dao;

import com.vetpet.bean.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        
        rs.close();
        st.close();
        c.close();
        return horario;
    }
    
    public List<Horario> horariosLivres(){
        List<Horario> horarios = new ArrayList<Horario>();
        try{
            Connection c = getConnection();
            String query = "SELECT * FROM Horario h WHERE id_horario NOT IN (SELECT id_horario FROM Consulta)";
            PreparedStatement st = c.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                horarios.add(montar(rs));
            }

            rs.close();
            st.close();
            c.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return horarios;
    }
   
    public Horario montar(ResultSet rs) throws SQLException{
        Horario h = new Horario();
        h.setIdHorario(rs.getLong("id_Horario"));
        h.setMedico(new MedicoDAO().obterPorId(rs.getLong("id_Medico")));
        h.setDataHora(rs.getTimestamp("DataHora"));

        return h;
    }
    
}
