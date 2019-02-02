/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Contato;

/**
 *
 * @author work
 */
public interface ContatoDAO {
    public void inserir(Contato contato);
    public List<Contato> listarTodos();
}
