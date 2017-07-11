package com.vetpet.dao;

import com.vetpet.bean.Cliente;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class ClienteDAO extends CommonDAO{
    
    public void inserir(Cliente cliente) throws SQLException, NoSuchAlgorithmException{
        MessageDigest  md = MessageDigest.getInstance("MD5");
        Connection c = getConnection();
        String query = "INSERT INTO Cliente (nome,usuario,senha) VALUES (?,?,?)";
        PreparedStatement st = c.prepareStatement(query);
        st.setString(1,cliente.getNome());
        st.setString(2,cliente.getUsuario());
        st.setString(2,new String(md.digest(cliente.getSenha().getBytes())));
        st.executeUpdate();

        st.close();
        c.close();
    }
    
     public Cliente obterPorId(Long idCliente) throws SQLException{
        Connection c = getConnection();
        String query = "SELECT * FROM Cliente WHERE id_cliente = ?";
        PreparedStatement st = c.prepareStatement(query);
        st.setLong(1, idCliente);
        ResultSet rs = st.executeQuery();
        Cliente cliente = null;
        if(rs.next()){
            cliente = montar(rs);
        }
        
        rs.close();;
        st.close();
        c.close();
        return cliente;
    }
    
    public List<Cliente> obterClientes() throws SQLException{
        Connection c = getConnection();
        String query = "SELECT * FROM Cliente";
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Cliente> clientes = new ArrayList<>();
        while(rs.next()){
            clientes.add(montar(rs));
        }
        rs.close();;
        st.close();
        c.close();
        return clientes;
    }
    
    public Cliente montar(ResultSet rs) throws SQLException{
        Cliente c = new Cliente();
        c.setIdCliente(rs.getLong("id_cliente"));
        c.setNome(rs.getString("nome"));
        c.setUsuario(rs.getString("usuario"));
        c.setSenha(rs.getString("senha"));
        
        return c;
    }
    
}
