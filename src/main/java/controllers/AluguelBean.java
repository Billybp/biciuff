/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoGeneric;
import entity.Aluguel;
import entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import repository.IDaoUsuario;
import repository.IDaoUsuarioimpl;
import util.JPAUtil;

/**
 *
 * @author gabri
 */
@ViewScoped
@ManagedBean(name = "aluguelBean")
public class AluguelBean {

    /**
     * Creates a new instance of AluguelBean
     */
    public AluguelBean() {
        
    }
    
    private Aluguel al = new Aluguel();
	private DaoGeneric<Aluguel> daoGeneric = new DaoGeneric<Aluguel>();
	private List<Aluguel> alugs = new ArrayList<Aluguel>();
	
	private IDaoUsuario iDaoUsuario = new IDaoUsuarioimpl();

	public String salvar() {
		al = daoGeneric.merge(al);
		mostrarMsg("Bicicleta alugada!");
                
		return "";
	}
        
        public void salvar2(Aluguel al) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(al);
        em.getTransaction().commit();
        em.close();
        } 
	
	private void mostrarMsg(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(null, message);
		
	}

	public String novo(){
		al = new Aluguel();
		return "";
	}
	
	public String remove(){
		daoGeneric.deletePorId(al);
		al = new Aluguel();
		carregarAlugueis();
		mostrarMsg("Removido com sucesso!");
		return "";
	}
	
	@PostConstruct
	public void carregarAlugueis(){
		alugs = daoGeneric.getListEntity(Aluguel.class);
                
	}
	
	public Aluguel getAluguel() {

		return al;
	}

	public void setAluguel(Aluguel al) {
		this.al = al;
	}

	public DaoGeneric<Aluguel> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Aluguel> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
	
	public List<Aluguel> getAlugueis() {
            return alugs;
	}
        
        
}
