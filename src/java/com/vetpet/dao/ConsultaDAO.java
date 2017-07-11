package com.vetpet.dao;

import com.vetpet.bean.Consulta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ConsultaDAO extends CommonDAO{
    
    public void inserir(Consulta consulta) throws SQLException{
        Connection c = getConnection();
        String sql = "INSERT INTO CONSULTA (id_cliente,id_animal,id_medico,data) VALUES (?,?,?,?) ";
        PreparedStatement st = c.prepareStatement(sql);
        st.setLong(1,consulta.getCliente().getIdCliente());
        st.setLong(2,consulta.getAnimal().getIdAnimal());
        st.setLong(3,consulta.getMedico().getIdMedico());
        st.setDate(4, (Date) consulta.getData());

        st.executeUpdate();
    }
    
    public List<String> datasPossiveis(){
        List<String> datas = new ArrayList<>();
        Calendar hoje = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for(int i = 0; i< 6; i++){
            hoje.set(Calendar.DATE, hoje.get(Calendar.DATE) + 1);
            datas.add(df.format(hoje.getTime()));
        }
        return datas;
    }

    public List<Consulta> obterConsultas() throws SQLException {
        Connection c = getConnection();
        String query = "SELECT * FROM Consulta";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Consulta> consultas = new ArrayList<>();
        while(rs.next()){
            consultas.add(montar(rs));
        }
        rs.close();;
        st.close();
        c.close();
        return consultas;
    }

    private Consulta montar(ResultSet rs) throws SQLException {
        Consulta c = new Consulta();
        c.setAnimal(new AnimalDAO().obterPorId(rs.getLong("id_animal")));
        c.setCliente(new ClienteDAO().obterPorId(rs.getLong("id_cliente")));
        c.setMedico(new MedicoDAO().obterPorId(rs.getLong("id_medico")));
        c.setData(rs.getDate("data"));
        return c;
    }
    
}
