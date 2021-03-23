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
public class Livro {
    private int id_livro;
    private int obra;
    private Date dataAquisicao;
    private String situacao;

    public Livro(int obra, Date dataAquisicao, String situacao) {
        this.obra = obra;
        this.dataAquisicao = dataAquisicao;
        this.situacao = situacao;
    }

    public Livro() {
    }

    
    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public int getObra() {
        return obra;
    }

    public void setObra(int obra) {
        this.obra = obra;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
    
}
