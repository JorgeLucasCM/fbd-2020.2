/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.sun.accessibility.internal.resources.accessibility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Obra;

/**
 *
 * @author Jorge Lucas
 */
public class ObraDAO extends ExecuteSQL{
    
    public ObraDAO(Connection con) {
        super(con);
    }
    
    public String inserirObra(Obra o) throws SQLException{
        String sql= "insert into obra values(0,?,?,?,?,?,?,?)";
         
        PreparedStatement ps = getCon().prepareCall(sql);       
        
        ps.setString(1, o.getTitulo());
        ps.setString(2, o.getAutor());
        ps.setInt(3, o.getIsbn());
        ps.setInt(4, o.getVolume());
        ps.setString(5, o.getDescricaoDaObra());
        ps.setInt(6, o.getCategoria());
        ps.setInt(7, o.getEditora());
        
        if(ps.executeUpdate() > 0){
            return "Inserido com sucesso.";
        } else {
            return "Erro ao inserir";
        }
    }
    
    public List<Obra> listarObra() throws SQLException{
        String sql = "select * from obra";
        List<Obra> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Obra o = new Obra();
                    o.setTitulo(rs.getString("titulo"));
                    o.setAutor(rs.getString("autor"));
                    o.setIsbn(rs.getInt("isbn"));
                    o.setVolume(rs.getInt("volume"));
                    o.setDescricaoDaObra(rs.getString("descricaoDaObra"));
                    o.setCategoria(rs.getInt("categoria"));
                    o.setEditora(rs.getInt("editora"));
                    o.setId_obra(rs.getInt("id_obra"));

                    lista.add(o);
                }
                return lista;

            }else{
                return null;
            }
        }catch (SQLException e) {
            return null;
        }
        
    }
    
    public String removerObra(String titulo, int categoria, int editora) throws SQLException{
        String sql="delete from obra where titulo = ? and categoria = ? and editora = ?";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, titulo);
        ps.setInt(2, categoria);
        ps.setInt(3, editora);
        
        if(ps.executeUpdate() > 0){
            return "Removido com sucesso";
        }else{
            return "Erro ao Remover";
        }
    }
    
    public Obra receberObra(String titulo, int categoria, int editora) throws SQLException{
        Obra o = new Obra();
        String sql = "select * from obra where titulo = '"+titulo+"' and categoria ="+categoria+" and editora = "+editora+"";
        
        PreparedStatement ps = getCon().prepareStatement(sql);       
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
               o.setId_obra(rs.getInt("id_obra"));
               o.setTitulo(rs.getString("titulo"));
               o.setAutor(rs.getString("autor"));
               o.setIsbn(rs.getInt("isbn"));
               o.setVolume(rs.getInt("volume"));
               o.setDescricaoDaObra(rs.getString("descricaoDaObra"));
               o.setCategoria(rs.getInt("categoria"));
               o.setEditora(rs.getInt("editora"));
            }
                
        }
        return o;
    }
    
    public String alterarObra(Obra o) throws SQLException{
        String sql = "update obra set titulo = ?, autor = ?, isbn = ?, volume = ?, descricaoDaObra = ?, categoria = ?, editora = ? where id_obra = ?";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, o.getTitulo());
        ps.setString(2, o.getAutor());
        ps.setInt(3, o.getIsbn());
        ps.setInt(4, o.getVolume());
        ps.setString(5, o.getDescricaoDaObra());
        ps.setInt(6, o.getCategoria());
        ps.setInt(7, o.getEditora());
        ps.setInt(8, o.getId_obra());
        
        if (ps.executeUpdate() > 0){
            return "Atualizado com sucesso.";
        }else {
            return "Error ao atualizar.";
        }
    }
    
    public boolean testarTituloObra(String titulo) throws SQLException{
        boolean resultado = false;
        
        String sql = "select * from obra where titulo = '" + titulo +"'";
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                resultado = true;
            }
        }
        return resultado;
    }
    
    public boolean testarIsbnObra(int isbn) throws SQLException{
        boolean resultado = false;
        
        String sql = "select * from obra where isbn = " + isbn +"";
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                resultado = true;
            }
        }
        return resultado;
    }
    
    public List<Obra> listarComboObra() throws SQLException{
        String sql = "select titulo from obra order by titulo";
        List<Obra> lista = new ArrayList<>();
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while(rs.next()){
                
                Obra o = new Obra();
                o.setTitulo(rs.getString(1));
                lista.add(o);
                
              
            }
        }
       
       return lista; 
    }
    
    public int receberIdObra(String titulo) throws SQLException{
        int id = -1;
        String consulta = "select * from obra where titulo = '" + titulo +"'";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                
                id =(rs.getInt("id_obra"));
            }
        }
        return id;
    }
    
    public String receberTituloObra(int obra) throws SQLException{
        String titulo = "";
        String consulta = "select titulo from obra where id_obra = "+ obra +"";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                
                titulo = (rs.getString("titulo"));
            }
        }
        return titulo;
    }
        
}
