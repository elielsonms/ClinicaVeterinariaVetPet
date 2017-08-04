package com.vetpet.dao;

import com.vetpet.bean.Cliente;
import com.vetpet.bean.Plano;
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
        /*if(cliente.getSenha() != null){
            try {
                MessageDigest  md = MessageDigest.getInstance("MD5");
                //cliente.setSenha(new String(md.digest(cliente.getSenha().getBytes())));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
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
    
    public Cliente login(String usuario,String senha)throws SQLException{
        /*String senhaEncriptada = "";
        try {
            MessageDigest  md = MessageDigest.getInstance("MD5");
            senhaEncriptada = new String(md.digest(senha.getBytes()));
            System.out.println(senhaEncriptada);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        Connection c = getConnection();
        String query = colunas()+tabela()+" WHERE usuario = ? AND senha = ?";
        PreparedStatement st = c.prepareStatement(query);
        st.setString(1, usuario);
        st.setString(2, senha);
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
    
     public Cliente obterPorId(Long idCliente) throws SQLException{
        Connection c = getConnection();
        String query = colunas()+tabela()+" WHERE id_cliente = ?";
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
        String query = colunas()+tabela();
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
    
    private String colunas(){
        return "SELECT cli.*,(SELECT COUNT(*) FROM Consulta con WHERE con.id_cliente = cli.id_cliente AND YEAR(con.data) = YEAR(CURDATE())) qtd_ano, "
                + "(SELECT COUNT(*) FROM Consulta con WHERE con.id_cliente = cli.id_cliente AND YEAR(con.data) = YEAR(CURDATE()) AND MONTH(con.data) = MONTH(CURDATE())) qtd_mes, "
                + "(SELECT COUNT(*) FROM Consulta con WHERE con.id_cliente = cli.id_cliente) qtd_total ";
    }
    private String tabela(){
        return " FROM Cliente cli";
    }
    public Cliente montar(ResultSet rs) throws SQLException{
        Cliente c = new Cliente();
        c.setQtdConsultasAno(rs.getLong("qtd_ano"));
        c.setQtdConsultasMes(rs.getLong("qtd_mes"));
        c.setQtdConsultasTotal(rs.getLong("qtd_total"));
        c.setIdCliente(rs.getLong("id_cliente"));
        c.setNome(rs.getString("nome"));
        c.setUsuario(rs.getString("usuario"));
        c.setSenha(rs.getString("senha"));
        try{
            c.setPlano((Plano) Class.forName("com.vetpet.bean.Plano"+rs.getString("plano")).getConstructor().newInstance());
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,null,e);
        }
        
        return c;
    }

    public boolean existeLogin(String usuario) {
        boolean existe = false;
        try{
            Connection c = getConnection();
            String query = "SELECT 1 FROM Cliente WHERE usuario = ? ";
            PreparedStatement st = c.prepareStatement(query);
            st.setString(1, usuario);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                existe = true;
            }
            rs.close();
            st.close();
            c.close();
        }catch(SQLException e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,null,e);
        }
        return existe;
    }
    
}
