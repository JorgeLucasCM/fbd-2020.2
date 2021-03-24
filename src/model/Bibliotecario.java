/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Jorge Lucas
 */
public class Bibliotecario {
    private int id_bibliotecario;
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataDeNascimento;
    private String login;
    private String senha;

    public Bibliotecario(String nome, String cpf, String telefone, Date dataDeNascimento, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataDeNascimento = dataDeNascimento;
        this.login = login;
        this.senha = senha;
    }

    public Bibliotecario() {
    }
    
    

    public int getId_bibliotecario() {
        return id_bibliotecario;
    }

    public void setId_bibliotecario(int id_bibliotecario) {
        this.id_bibliotecario = id_bibliotecario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
