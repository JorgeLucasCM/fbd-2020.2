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
public class Emprestimo {
    private int id_emprestimo;
    private int livro;
    private int aluno;
    private int bibliotecario;
    private Date dataInicio;
    private Date dataTermino;
    private boolean renovado = false;

    public Emprestimo(int livro, int aluno) {
        this.livro = livro;
        this.aluno = aluno;
    }

    public Emprestimo() {
    }

    public Emprestimo(int id_emprestimo, int livro, int aluno, int bibliotecario, Date dataInicio, Date dataTermino) {
        this.id_emprestimo = id_emprestimo;
        this.livro = livro;
        this.aluno = aluno;
        this.bibliotecario = bibliotecario;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }
    
    
    
    
    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public int getLivro() {
        return livro;
    }

    public void setLivro(int livro) {
        this.livro = livro;
    }

    public int getAluno() {
        return aluno;
    }

    public void setAluno(int aluno) {
        this.aluno = aluno;
    }

    public int getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(int bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataInicio, int dias) {
        long diasEmTime = 86400000;
        this.dataTermino.setTime(dataInicio.getTime() + (dias*diasEmTime));
    }
    
    public void setDataTermino(Date dataTermino){
        this.dataTermino = dataTermino;
    }

    public boolean isRenovado() {
        return renovado;
    }

    public void setRenovado(boolean renovado) {
        this.renovado = renovado;
    }
    
    
}
