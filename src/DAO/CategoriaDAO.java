/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;
/**
 *
 * @author Jorge Lucas
 */
public class CategoriaDAO extends ExecuteSQL{
    
    public CategoriaDAO(Connection con) {
        super(con);
    }
    
    public String inserirCategoria(Categoria c) throws SQLException{
        String sql= "insert into categoria values(0,?)";
         
        PreparedStatement ps = getCon().prepareCall(sql);       
        
        ps.setString(1, c.getNome());
        
        if(ps.executeUpdate() > 0){
            return "Inserido com sucesso.";
        } else {
            return "Erro ao inserir";
        }
    }
    
    public List<Categoria> listarCategoria() throws SQLException{
        String sql = "select * from categoria";
        List<Categoria> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Categoria c = new Categoria();
                    c.setNome(rs.getString("nome"));
                   

                    lista.add(c);
                }
                return lista;

            }else{
                return null;
            }
        }catch (SQLException e) {
            return null;
        }
        
    }
    
    public boolean testarCategoriaNome(String nome) throws SQLException{
        boolean resultado = false;
        
        String sql = "select * from categoria where nome = '"+ nome +"'";
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                resultado = true;
            }
        }
        return resultado;
    }
    
    public String removerCategoria(String nome) throws SQLException{
        String sql="delete from categoria where nome = ?";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, nome);
        
        if(ps.executeUpdate() > 0){
            return "Removido com sucesso";
        }else{
            return "Erro ao Remover";
        }
    }
    
    public Categoria receberCategoria(String nome) throws SQLException{
        Categoria c = new Categoria();
        String consulta = "select * from categoria where nome = '" + nome +"'";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                
                c.setId_categoria(rs.getInt("id_categoria"));
                c.setNome(rs.getString("nome"));
            }
        }
        return c;
    }
    
    public String alterarCategoria(Categoria c) throws SQLException{
        String sql = "update categoria set nome = ? where id_categoria = ?";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, c.getNome());
        ps.setInt(2, c.getId_categoria());
        
        if (ps.executeUpdate() > 0){
            return "Atualizado com sucesso.";
        }else {
            return "Error ao atualizar.";
        }
    }
    
    public List<Categoria> listarComboCategoria() throws SQLException{
        String sql = "select nome from categoria order by nome";
        List<Categoria> lista = new ArrayList<>();
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                
                Categoria c = new Categoria();
                c.setNome(rs.getString(1));
                lista.add(c);
                
              
            }
        }
       
       return lista; 
    }
    
    public int receberIdCategoria(String nome) throws SQLException{
        int id = -1;
        String consulta = "select * from categoria where nome = '" + nome +"'";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                
                id = (rs.getInt("id_categoria"));
            }
        }
        return id;
    }
    
    public String receberNomeCategoria(int id) throws SQLException{
        String nome = null;
        String consulta = "select * from categoria where id_categoria = " +id+"";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                
                nome = (rs.getString("nome"));
            }
        }
        return nome;
    }
        
}
