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
import model.*;

/**
 *
 * @author Jorge Lucas
 */
public class EmprestimoDAO extends ExecuteSQL{
    
    public EmprestimoDAO(Connection con) {
        super(con);
    }
    
    
    public String inserirEmprestimo(Emprestimo e) throws SQLException{
        String sql= "insert into emprestimo (id_emprestimo, livro, aluno, renovado) values(0,?,?,?)";
         
        PreparedStatement ps = getCon().prepareCall(sql);
        
        ps.setInt(1, e.getLivro());
        ps.setInt(2, e.getAluno());
        ps.setBoolean(3, e.isRenovado());
        
        
        if(ps.executeUpdate() > 0){
            return "Inserido com sucesso.";
        } else {
            return "Erro ao inserir";
        }
    }
    
    public boolean testarEmprestimoAlunoObra(int aluno, int obra) throws SQLException{
        boolean resultado = false;
        
        
        String sql = "select * from emprestimo where aluno = " + aluno +"";
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                int livro = rs.getInt("livro");
                String sql1 = "select * from livro where id_livro = " + livro +" and obra = "+obra+"";
                PreparedStatement ps1 = getCon().prepareStatement(sql1);
                ResultSet rs1 = ps1.executeQuery();
                
                if(rs1 !=  null){
                    while(rs1.next()){
                        resultado = true;
                    }
                }
            }
        }
        return resultado;
    }
    
    public List<Emprestimo> listarEmprestimoPendente() throws SQLException{
        String sql = "select * from emprestimo where bibliotecario is null and dataInicio is null and dataTermino is null";
        List<Emprestimo> lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Emprestimo e = new Emprestimo();
                    e.setId_emprestimo(rs.getInt("id_emprestimo"));
                    e.setLivro(rs.getInt("livro"));
                    e.setAluno(rs.getInt("aluno"));
                    e.setBibliotecario(rs.getInt("bibliotecario"));
                    e.setDataInicio(rs.getDate("dataInicio"));
                    e.setDataTermino(rs.getDate("dataTermino"));
                    e.setRenovado(rs.getBoolean("renovado"));
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
    
    public List<Emprestimo> listarEmprestimoAceitoAluno(int aluno) throws SQLException{
        String sql = "select * from emprestimo where bibliotecario is not null and dataInicio is not null and dataTermino is not null and aluno = "+aluno+"";
        List<Emprestimo> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Emprestimo e = new Emprestimo();
                    e.setId_emprestimo(rs.getInt("id_emprestimo"));
                    e.setLivro(rs.getInt("livro"));
                    e.setAluno(rs.getInt("aluno"));
                    e.setBibliotecario(rs.getInt("bibliotecario"));
                    e.setDataInicio(rs.getDate("dataInicio"));
                    e.setDataTermino(rs.getDate("dataTermino"));
                    e.setRenovado(rs.getBoolean("renovado"));

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
    
    public String alterarEmprestimo(Emprestimo e) throws SQLException{
        String sql = "update emprestimo set bibliotecario = ?, dataInicio = ?, dataTermino = ?, renovado = ? where id_emprestimo = ? and livro = ? and aluno = ? ";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setInt(1, e.getBibliotecario());
        ps.setDate(2, new java.sql.Date(e.getDataInicio().getTime()));
        ps.setDate(3, new java.sql.Date(e.getDataTermino().getTime()));
        ps.setBoolean(4, e.isRenovado());
        ps.setInt(5, e.getId_emprestimo());
        ps.setInt(6, e.getLivro());
        ps.setInt(7, e.getAluno());

        
        if (ps.executeUpdate() > 0){
            return "Atualizado com sucesso.";
        }else {
            return "Error ao atualizar.";
        }
    }
    
    public Emprestimo receberEmprestimo(int id) throws SQLException{
        Emprestimo e = new Emprestimo();
        String consulta = "select * from emprestimo where id_emprestimo = " + id +"";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                
                e.setId_emprestimo(rs.getInt("id_emprestimo"));
                e.setLivro(rs.getInt("livro"));
                e.setAluno(rs.getInt("aluno"));
                e.setBibliotecario(rs.getInt("bibliotecario"));
                e.setDataInicio(rs.getDate("dataInicio"));
                e.setDataTermino(rs.getDate("dataTermino"));
                e.setRenovado(rs.getBoolean("renovado"));
            }
        }
        return e;
    }
    
    public String removerEmprestimo(int id_emprestimo) throws SQLException{
        String sql="delete from emprestimo where id_emprestimo ="+id_emprestimo+"";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        
        if(ps.executeUpdate() > 0){
            return "Removido com sucesso";
        }else{
            return "Erro ao Remover";
        }
    }
     
}
