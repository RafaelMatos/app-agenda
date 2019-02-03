/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contato;

/**
 *
 * @author work
 */
public class JDBCContatoDAO implements ContatoDAO{
    
    Connection conexao;
    
    public JDBCContatoDAO(Connection conexao){
        this.conexao = conexao;
    }
    
    @Override
    public void inserir(Contato contato) {

        String sql = "INSERT INTO contato(nome,telefone,celular,email) VALUES(?,?,?,?)";
        
        PreparedStatement p;
        try {
            p = this.conexao.prepareStatement(sql);
            
            p.setString(1, contato.getNome());
            p.setString(2, contato.getTelefone());
            p.setString(3, contato.getCelular());
            p.setString(4, contato.getEmail());
           
            p.execute();
        } catch (SQLException ex) {
//            Logger.getLogger(JDBCContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
               ex.printStackTrace();
        }
        
        
    }

    @Override
    public List<Contato> listarTodos() {
        
        List<Contato> contatos = new ArrayList<Contato>();
        
        String sql = "SELECT * FROM contato;";
        try {
            
            java.sql.Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Contato contato = new Contato();
                
                int idContato = rs.getInt("idContato");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String celular = rs.getString("celular");
                String email = rs.getString("email");
                
                contato.setId(idContato);
                contato.setNome(nome);
                contato.setTelefone(telefone);
                contato.setCelular(celular);
                contato.setEmail(email);
                
                contatos.add(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
    }
    
}
