/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DAO.*;
import model.*;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
import view.CadastroAluno;
/**
 *
 * @author Jorge Lucas
 */
public class main {
    
    
    public static String identificacao = null;
    public static Aluno alunoEditar = new Aluno();
    public static Bibliotecario bibliotecarioEditar = new Bibliotecario();
    public static Editora editoraEditar = new Editora();
    public static Categoria categoriaEditar = new Categoria();
    public static Obra obraEditar = new Obra();
    public static Aluno alunoLogado = new Aluno();
    public static Bibliotecario bibLogado = new Bibliotecario();
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        new telaLogin().setVisible(true);
        
    }
}
