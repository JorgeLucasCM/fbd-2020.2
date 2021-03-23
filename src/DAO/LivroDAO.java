/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Livro;

/**
 *
 * @author Jorge Lucas
 */
public class LivroDAO extends ExecuteSQL{
    
    public LivroDAO(Connection con) {
        super(con);
    }
    
    public String inserirLivros(Livro l, int qtd) throws SQLException{
        String sql= "insert into livro values(0,?,?,?)";
         
        PreparedStatement ps = getCon().prepareCall(sql);       
        
        ps.setInt(1, l.getObra());
        ps.setDate(2, new java.sql.Date(l.getDataAquisicao().getTime()));
        ps.setString(3, l.getSituacao());
        
        for (; qtd > 0 ; qtd--){
            ps.executeUpdate();
        }
        
        if(qtd == 0){
            return "Inserido com sucesso.";
        } else {
            return "Erro ao inserir";
        }
    }
    
    public List<Livro> listarLivros() throws SQLException{
        String sql = "select * from livro";
        List<Livro> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Livro l = new Livro();
                    l.setId_livro(rs.getInt("id_livro"));
                    l.setObra(rs.getInt("obra"));
                    l.setDataAquisicao(rs.getDate("dataAquiscao"));
                    l.setSituacao(rs.getString("situcao"));


                    lista.add(l);
                }
                return lista;

            }else{
                return null;
            }
        }catch (SQLException e) {
            return null;
        }
        
    }
    
    public int quantidadeLivroDispObra(int obra) throws SQLException{
        int qtd = -1;
        String sql = "select count(*) from livro where obra = "+obra+" and situacao = 'disponivel'";

            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){    
                    qtd = (rs.getInt(1));
                }
            }
        return qtd;
    }
    
    public String removerLivrosQuantidade(int obra, int qtd) throws SQLException{
       String sql1 = "select id_livro from livro where obra = "+obra+" and situacao = 'disponivel'";
       
            PreparedStatement ps1 = getCon().prepareCall(sql1);
            ResultSet rs1 = ps1.executeQuery();

            if(rs1 != null){
                while(rs1.next()){
                    if(qtd > 0){
                        String sql="delete from livro where id_livro = "+rs1.getInt("id_livro")+"";
                        PreparedStatement ps = getCon().prepareStatement(sql);
                        ps.executeUpdate();
                        qtd--;
                    }
                }
            }        
        if(qtd == 0){
            return "Removido com sucesso";
        }else{
            return "Erro ao Remover";
        }
    }
    
    public int receberIdLivro(int obra) throws SQLException{
        int id = -1;
        String sql = "select id_livro from livro where obra = "+obra+" and situacao = 'disponivel'";
        
        PreparedStatement ps = getCon().prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                id  = (rs.getInt("id_livro"));
                return id;
            }
        }
        return id;
    }
    
    public Livro receberLivro(int id_livro) throws SQLException{
        Livro l = new Livro();
        String sql = "select * from livro where id_livro = "+id_livro+"";
        
        PreparedStatement ps = getCon().prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                l.setId_livro(rs.getInt("id_livro"));
                l.setObra(rs.getInt("obra"));
                l.setDataAquisicao(rs.getDate("dataAquiscao"));
                l.setSituacao(rs.getString("situacao"));
                
                return l;
            }
        }
        return l;
    }
    
    public String atualizarSituacao(int id_livro, String situacao) throws SQLException{
        String sql = "update livro set situacao = '"+situacao+"' where id_livro = "+id_livro+"";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        
        if (ps.executeUpdate() > 0){
            return "Atualizado com sucesso.";
        }else {
            return "Error ao atualizar.";
        }
        
    }
    
    public int receberLivrosPedentes() throws SQLException{
        int id = -1;
        String sql = "select count(*) from livro where situacao = 'pedente'";
        
        PreparedStatement ps = getCon().prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                id  = (rs.getInt(1));
            }
        }
        return id;
    }
}
