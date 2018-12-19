/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Estacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import util.JPAUtil;

/**
 *
 * @author gabri
 */
public class IDaoEstacaoimpl implements IDaoEstacao {
    
        @Override
	public List<Estacao> consultar(String nome) {
		List<Estacao> lista = null;
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		lista = entityManager.createQuery(" from Estacao where bicicleta.nome = " + nome).getResultList();
		
		transaction.commit();
		entityManager.close();
		
		return lista;
	}
    
}
