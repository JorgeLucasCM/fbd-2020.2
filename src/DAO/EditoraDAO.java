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
import model.Aluno;
import model.Editora;

/**
 *
 * @author Jorge Lucas
 */
public class EditoraDAO extends ExecuteSQL{
    
    public EditoraDAO(Connection con) {
        super(con);
    }
    
    public String inserirEditora(Editora e) throws SQLException{
        String sql= "insert into editora values(0,?,?,?)";
         
        PreparedStatement ps = getCon().prepareCall(sql);       
        
        ps.setString(1, e.getNome());
        ps.setString(2, e.getCnpj());
        ps.setString(3, e.getCidade());
        
        if(ps.executeUpdate() > 0){
            return "Inserido com sucesso.";
        } else {
            return "Erro ao inserir";
        }
    }
    
    public List<Editora> listarEditora() throws SQLException{
        String sql = "select * from editora";
        List<Editora> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Editora e = new Editora();
                    e.setNome(rs.getString("nome"));
                    e.setCnpj(rs.getString("cnpj"));
                    e.setCidade(rs.getString("cidade"));


                    lista.add(e);
                }
                return lista;

            }else{
                return null;
            }
        }catch (SQLException e) {
            return null;
        }
        
    }
    
    public boolean testarEditoraNome(String nome) throws SQLException{
        boolean resultado = false;
        
        String sql = "select * from editora where nome = '" + nome +"'";
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                resultado = true;
            }
        }
        return resultado;
    }
    
    public boolean testarEditoraCNPJ(String cnpj) throws SQLException{
        boolean resultado = false;
        
        String sql = "select * from editora where cnpj = '" + cnpj +"'";
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                resultado = true;
            }
        }
        return resultado;
    }
    
    public String removerEditora(String nome, String cnpj) throws SQLException{
        String sql="delete from editora where nome = ? and cnpj = ? ";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, cnpj);
        
        if(ps.executeUpdate() > 0){
            return "Removido com sucesso";
        }else{
            return "Erro ao Remover";
        }
    }
    
    public Editora receberEditora(String nome, String cnpj) throws SQLException{
        Editora e = new Editora();
        String consulta = "select * from editora where nome = '" + nome +"' and cnpj ='"+cnpj+"'";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                
                e.setId_editora(rs.getInt("id_editora"));
                e.setNome(rs.getString("nome"));
                e.setCnpj(rs.getString("cnpj"));
                e.setCidade(rs.getString("cidade"));
            }
        }
        return e;
    }
    
    public String alterarEditora(Editora e) throws SQLException{
        String sql = "update editora set nome = ?, cnpj = ?, cidade = ? where id_editora = ?";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, e.getNome());
        ps.setString(2, e.getCnpj());
        ps.setString(3, e.getCidade());
        ps.setInt(4, e.getId_editora());
        
        if (ps.executeUpdate() > 0){
            return "Atualizado com sucesso.";
        }else {
            return "Error ao atualizar.";
        }
    }
    
    public List<Editora> listarComboEditora() throws SQLException{
        String sql = "select nome from editora order by nome";
        List<Editora> lista = new ArrayList<>();
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                
                Editora e = new Editora();
                e.setNome(rs.getString(1));
                lista.add(e);
                
              
            }
        }
       
       return lista; 
    }
    
    public int receberIdEditora(String nome) throws SQLException{
        int id = -1;
        String consulta = "select * from editora where nome = '" + nome +"'";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                
                id =(rs.getInt("id_editora"));
            }
        }
        return id;
    }
    
    public String receberNomeEditora(int id) throws SQLException{
        String nome = null;
        String consulta = "select * from editora where id_editora = " + id +"";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                
                nome =(rs.getString("nome"));
            }
        }
        return nome;
    }
}
