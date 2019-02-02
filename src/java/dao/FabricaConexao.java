/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;

/**
 *
 * @author work
 */
public class FabricaConexao {
    private java.sql.Connection conexao;
    
    public Connection criarConexao(){
        try {
                Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("com.mysql.jdbc.Driver");org.gjt.mm.mysql.Ddriver
            conexao = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","rafael","1234");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }
    
    public void fecharConexao(){
        try {
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
