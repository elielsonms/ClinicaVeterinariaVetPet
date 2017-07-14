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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elielsonms
 */
public class ClienteDAO extends CommonDAO{
    
    public Long inserir(Cliente cliente) throws SQLException{
        if(cliente.getSenha() != null){
            try {
                MessageDigest  md = MessageDigest.getInstance("MD5");
                cliente.setSenha(new String(md.digest(cliente.getSenha().getBytes())));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Connection c = getConnection();
        String query = "INSERT INTO Cliente (nome,usuario,senha) VALUES (?,?,?)";
        PreparedStatement st = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.setString(1,cliente.getNome());
        st.setString(2,cliente.getUsuario());
        st.setString(3,cliente.getSenha());
        st.executeUpdate();
        ResultSet rs = st.getGeneratedKeys();
        Long idCliente = null;
        if(rs.next()){
            idCliente = rs.getLong(1);
            cliente.setIdCliente(idCliente);
        }
        rs.close();
        st.close();
        c.close();
        return idCliente;
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
