/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.JPAUtil;
/**
 *
 * @author gabri
 */
public class DaoGeneric<E> {

	
	public void salvar(E entidade){
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(entidade);
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	
	public E merge(E entidade){
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		E retorno = entityManager.merge(entidade);
		
		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	}
	
	
	public void delete(E entidade){
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.remove(entidade);
		
		entityTransaction.commit();
		entityManager.close();
	}
	
	public void deletePorId(E entidade){
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Object id = JPAUtil.getPrimaryKey(entidade);
		entityManager.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id = " + id).executeUpdate();
		
		entityTransaction.commit();
		entityManager.close();
	}

	
	public List<E> getListEntity(Class<E> entidade){
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		
		List<E> retorno = em.createQuery("from " + entidade.getName()).getResultList();
		
		entityTransaction.commit();
		em.close();
		
		return retorno;
	}
	
        public List<E> getListEntityDisp(Class<E> entidade){
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction entityTransaction = em.getTransaction();
		entityTransaction.begin();
		
		List<E> retorno = em.createQuery("Select b from " + entidade.getName()+" b where b.disponivel = true").getResultList();
		
		entityTransaction.commit();
		em.close();
		
		return retorno;
	}
}