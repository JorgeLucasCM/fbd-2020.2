/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import java.sql.Date;
import java.sql.*;
import java.util.ArrayList;
import model.Aluno;
/**
 *
 * @author Jorge Lucas
 */
public class AlunoDAO extends ExecuteSQL{
    private Aluno aluno = new Aluno();
    
    public AlunoDAO(Connection con) {
        super(con);
    }
    
    public boolean Logar(String login, String senha) throws SQLException{
        boolean finalResult = false;
        String consulta = "select * from aluno where matricula = '" + login +"' and senha = '" + senha +"'";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                
                aluno.setCpf(rs.getString("cpf"));
                aluno.setCurso(rs.getString("curso"));
                aluno.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setSenha(rs.getString("senha"));
                finalResult=true;
            }
        }
        return finalResult;
    }
    
    public Aluno receberAluno(int matricula) throws SQLException{
        Aluno a = new Aluno();
        String consulta = "select * from aluno where matricula = " + matricula +"";
        PreparedStatement ps = getCon().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if(rs!= null){
            while(rs.next()){
                
                a.setCpf(rs.getString("cpf"));
                a.setCurso(rs.getString("curso"));
                a.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                a.setNome(rs.getString("nome"));
                a.setTelefone(rs.getString("telefone"));
                a.setMatricula(rs.getInt("matricula"));
                a.setSenha(rs.getString("senha"));
            }
        }
        return a;
    }

    public String inserirAluno(Aluno a) throws SQLException{
        String sql= "insert into aluno values(?,?,?,?,?,?,?)";
         
        PreparedStatement ps = getCon().prepareCall(sql);
        
        
        
        ps.setInt(1, a.getMatricula());
        ps.setString(2, a.getNome());
        ps.setString(3, a.getCpf());
        ps.setString(4, a.getTelefone());
        ps.setDate(5, new java.sql.Date(a.getDataDeNascimento().getTime()));
        ps.setString(6, a.getCurso());
        ps.setString(7, a.getSenha());
        
        if(ps.executeUpdate() > 0){
            return "Inserido com sucesso.";
        } else {
            return "Erro ao inserir";
        }
    }
    
    public List<Aluno> listarAluno() throws SQLException{
        String sql = "select * from aluno";
        List<Aluno> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Aluno a = new Aluno();
                    a.setMatricula(rs.getInt("matricula"));
                    a.setCpf(rs.getString("cpf"));
                    a.setCurso(rs.getString("curso"));
                    a.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                    a.setNome(rs.getString("nome"));
                    a.setSenha(rs.getString("senha"));
                    a.setTelefone(rs.getString("telefone"));

                    lista.add(a);
                }
                return lista;

            }else{
                return null;
            }
        }catch (SQLException e) {
            return null;
        }
        
    }
    
    public List<Aluno> pesquisarNomeAluno(String nome) throws SQLException{
        String sql = "select * from aluno where nome Like '%"+nome+"%'";
        List<Aluno> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Aluno a = new Aluno();
                    a.setMatricula(rs.getInt("matricula"));
                    a.setCpf(rs.getString("cpf"));
                    a.setCurso(rs.getString("curso"));
                    a.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                    a.setNome(rs.getString("nome"));
                    a.setSenha(rs.getString("senha"));
                    a.setTelefone(rs.getString("telefone"));

                    lista.add(a);
                }
                return lista;

            }else{
                return null;
            }
        }catch (SQLException e) {
            return null;
        }
        
    }
    
    public List<Aluno> pesquisarMatriculaAluno(int matricula) throws SQLException{
        String sql = "select * from aluno where matricula Like '%"+matricula+"%'";
        List<Aluno> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Aluno a = new Aluno();
                    a.setMatricula(rs.getInt("matricula"));
                    a.setCpf(rs.getString("cpf"));
                    a.setCurso(rs.getString("curso"));
                    a.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                    a.setNome(rs.getString("nome"));
                    a.setSenha(rs.getString("senha"));
                    a.setTelefone(rs.getString("telefone"));

                    lista.add(a);
                }
                return lista;

            }else{
                return null;
            }
        }catch (SQLException e) {
            return null;
        }
        
    }
    
    public boolean testarAlunoMatricula(int matricula) throws SQLException{
        boolean resultado = false;
        
        String sql = "select * from aluno where matricula = " + matricula +"";
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                resultado = true;
            }
        }
        return resultado;
    }
    
    public boolean testarAlunoCPF(String cpf) throws SQLException{
        boolean resultado = false;
        
        String sql = "select * from aluno where cpf = '" + cpf +"'";
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if(rs != null){
            while (rs.next()){
                resultado = true;
            }
        }
        return resultado;
    }
    
    public List<Aluno> capturarAluno(int matricula) throws SQLException{
        String sql = "select * from aluno where matricula = "+matricula+"";
        List<Aluno> lista = new ArrayList<>();
        
        try{
            PreparedStatement ps = getCon().prepareCall(sql);
            ResultSet rs = ps.executeQuery();

            if(rs != null){
                while(rs.next()){
                    Aluno a = new Aluno();
                    a.setMatricula(rs.getInt("matricula"));
                    a.setCpf(rs.getString("cpf"));
                    a.setCurso(rs.getString("curso"));
                    a.setDataDeNascimento(rs.getDate("dataDeNascimento"));
                    a.setNome(rs.getString("nome"));
                    a.setSenha(rs.getString("senha"));
                    a.setTelefone(rs.getString("telefone"));

                    lista.add(a);
                }
                return lista;

            }else{
                return null;
            }
        }catch (SQLException e) {
            return null;
        }
        
    }
    
    public String alterarAluno(Aluno a) throws SQLException{
        String sql = "update aluno set nome = ?, cpf = ?, telefone = ?, dataDeNascimento = ?, curso = ?, senha = ? where matricula = ?";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setString(1, a.getNome());
        ps.setString(2, a.getCpf());
        ps.setString(3, a.getTelefone());
        ps.setDate(4, new java.sql.Date(a.getDataDeNascimento().getTime()));
        ps.setString(5, a.getCurso());
        ps.setString(6, a.getSenha());
        ps.setInt(7, a.getMatricula());
        
        if (ps.executeUpdate() > 0){
            return "Atualizado com sucesso.";
        }else {
            return "Error ao atualizar.";
        }
    }
    
    public String removerAluno(int matricula) throws SQLException{
        String sql="delete from aluno where matricula = ? ";
        
        PreparedStatement ps = getCon().prepareStatement(sql);
        ps.setInt(1, matricula);
        
        if(ps.executeUpdate() > 0){
            return "Removido com sucesso";
        }else{
            return "Erro ao Remover";
        }
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
}
