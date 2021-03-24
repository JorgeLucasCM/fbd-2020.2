/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.Bibliotecario;
/**
 *
 * @author Jorge Lucas
 */
public class BibliotecarioDAO extends ExecuteSQL {
    private Bibliotecario bibliotecario = new Bibliotecario();
    
    public BibliotecarioDAO(Connection con) {
        super(con);
    }
    
    public boolean Logar(String login, String senha) throws SQLException{
        boolean finalResult = false;
        String consulta = "select * from bibliotecario where login = '" + login +"' and senha = '" + senha +"'";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                bibliotecario.setId_bibliotecario(rs.getInt("id_bibliotecario"));
                bibliotecario.setCpf(rs.getString("cpf"));
                bibliotecario.setNome(rs.getString("nome"));
                bibliotecario.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                bibliotecario.setTelefone(rs.getString("telefone"));
                bibliotecario.setLogin(rs.getString("login"));
                bibliotecario.setSenha(rs.getString("senha"));
                finalResult=true;
            }
        }
        return finalResult;
    }
    
    public String inserirBibliotecario(Bibliotecario b) throws SQLException{
        String sql= "insert into bibliotecario values(0,?,?,?,?,?,?)";
         
        PreparedStatement ps = getCon().prepareCall(sql);
        
        ps.setString(1, b.getNome());
        ps.setString(2, b.getCpf());
        ps.setString(3, b.getTelefone());
        ps.setDate(4, new java.sql.Date(b.getDataDeNascimento().getTime()));
        ps.setString(5, b.getLogin());
        ps.setString(6, b.getSenha());
        
        if(ps.executeUpdate() > 0){
            return "Inserido com sucesso.";
        } else {
            return "Erro ao inserir";
        }
    }
    
    public boolean testarBibliotecarioCPF(String cpf) throws SQLException{
        boolean resultado = false;
        
        String sql = "select * from bibliotecario where cpf = '" + cpf +"'";
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                resultado = true;
            }
        }
        return resultado;
    }
    
    public boolean testarBibliotecarioLogin(String login) throws SQLException{
        boolean resultado = false;
        
        String sql = "select * from bibliotecario where login = '" + login +"'";
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                resultado = true;
            }
        }
        return resultado;
    }

    public List<Bibliotecario> listarBibliotecario() throws SQLException{
        String sql = "select * from bibliotecario";
        List<Bibliotecario> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Bibliotecario b = new Bibliotecario();
                    b.setId_bibliotecario(rs.getInt("id_bibliotecario"));
                    b.setCpf(rs.getString("cpf"));
                    b.setLogin(rs.getString("login"));
                    b.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                    b.setNome(rs.getString("nome"));
                    b.setSenha(rs.getString("senha"));
                    b.setTelefone(rs.getString("telefone"));

                    lista.add(b);
                }
                return lista;

            }else{
                return null;
            }
        }catch (SQLException e) {
            return null;
        }
        
    }
    
    public String alterarBibliotecario(Bibliotecario b) throws SQLException{
        String sql = "update bibliotecario set nome = ?, cpf = ?, telefone = ?, dataDeNascimento = ?, login = ?, senha = ? where id_bibliotecario = ?";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, b.getNome());
        ps.setString(2, b.getCpf());
        ps.setString(3, b.getTelefone());
        ps.setDate(4, new java.sql.Date(b.getDataDeNascimento().getTime()));
        ps.setString(5, b.getLogin());
        ps.setString(6, b.getSenha());
        ps.setInt(7, b.getId_bibliotecario());
        
        if (ps.executeUpdate() > 0){
            return "Atualizado com sucesso.";
        }else {
            return "Error ao atualizar.";
        }
    }
    
    public Bibliotecario receberBibliotecario(int id_bibliotecario) throws SQLException{
        String consulta = "select * from bibliotecario where id_bibliotecario = "+id_bibliotecario+"";
        Bibliotecario b = new Bibliotecario();
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                b.setId_bibliotecario(rs.getInt("id_bibliotecario"));
                b.setCpf(rs.getString("cpf"));
                b.setLogin(rs.getString("login"));
                b.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                b.setNome(rs.getString("nome"));
                b.setSenha(rs.getString("senha"));
                b.setTelefone(rs.getString("telefone"));
            }
        }
        return b;
        
        
    }
    
    public String receberNomeBibliotecario(int id_bibliotecario) throws SQLException{
        String nome = null;
        String consulta = "select nome from bibliotecario where id_bibliotecario = "+id_bibliotecario+"";
        
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                
                nome =(rs.getString("nome"));
            }
        }
        return nome;
        
        
    }
    
    public String removerBibliotecario(int id_bibliotecario) throws SQLException{
        String sql="delete from bibliotecario where id_bibliotecario = ? ";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setInt(1, id_bibliotecario);
        
        if(ps.executeUpdate() > 0){
            return "Removido com sucesso";
        }else{
            return "Erro ao Remover";
        }
    }
    
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }
   
    public void setBibliotecario(Bibliotecario b) {
        this.bibliotecario = bibliotecario;
    }
}
