/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Bicicleta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import util.JPAUtil;

/**
 *
 * @author gabri
 */
public class IDaoBicicletaimpl implements IDaoBicicleta{
    
        @Override
	public List<Bicicleta> consultar() {
		List<Bicicleta> lista = null;
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		lista = entityManager.createQuery("SELECT b FROM Bicicleta b WHERE b.disponivel = true ").getResultList();
		
		transaction.commit();
		entityManager.close();
		
		return lista;
	}
    
}
