/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jorge Lucas
 */
public class Obra {
    private int id_obra;
    private String titulo;
    private String autor;
    private int isbn;
    private int volume;
    private String descricaoDaObra;
    private int categoria;
    private int editora;

    public Obra(String titulo, String autor, int isbn, int volume, String descricaoDaObra, int categoria, int editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.volume = volume;
        this.descricaoDaObra = descricaoDaObra;
        this.categoria = categoria;
        this.editora = editora;
    }

    public Obra() {
    }

    
    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getDescricaoDaObra() {
        return descricaoDaObra;
    }

    public void setDescricaoDaObra(String descricaoDaObra) {
        this.descricaoDaObra = descricaoDaObra;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getEditora() {
        return editora;
    }

    public void setEditora(int editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Obra{" + "titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", volume=" + volume + ", descricaoDaObra=" + descricaoDaObra + ", categoria=" + categoria + ", editora=" + editora + '}';
    }
    
    
    
    
}
