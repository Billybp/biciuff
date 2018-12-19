/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Usuario;

/**
 *
 * @author gabri
 */
public interface IDaoUsuario {
    
    Usuario consultarUsuario(String nome, String senha);
    
    public Usuario consultarId(int id);
}
