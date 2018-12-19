/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import util.JPAUtil;

/**
 *
 * @author gabri
 */
public class IDaoUsuarioimpl implements IDaoUsuario{
    
        @Override
	public Usuario consultarUsuario(String nome, String senha) {
		
		Usuario user = null;
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		user = (Usuario) entityManager.createQuery("select p from Usuario p where p.nome = '" + nome + "' and p.senha = '" + senha + "'").getSingleResult();
		
		entityTransaction.commit();
		entityManager.close();
		
		return user;
	}
        
        @Override
        public Usuario consultarId(int id) {
		
		Usuario user = null;
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		user = (Usuario) entityManager.createQuery("SELECT u FROM Usuario u WHERE u.id = :id").getSingleResult();
		
		entityTransaction.commit();
		entityManager.close();
		
		return user;
	}

}

