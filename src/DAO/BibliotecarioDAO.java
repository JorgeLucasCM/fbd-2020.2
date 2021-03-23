/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
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

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario b) {
        this.bibliotecario = bibliotecario;
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
}
