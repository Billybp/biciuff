/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoGeneric;
import entity.Bicicleta;
import entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import repository.IDaoBicicleta;
import repository.IDaoBicicletaimpl;
import util.JPAUtil;

/**
 *
 * @author gabri
 */
@ViewScoped
@ManagedBean(name = "bicicletaBean")
public class BicicletaBean {
    
	private Bicicleta bici = new Bicicleta();
	private DaoGeneric<Bicicleta> daoGeneric = new DaoGeneric<Bicicleta>();
	private List<Bicicleta> bicis = new ArrayList<Bicicleta>();
	private IDaoBicicleta idaoBici = new IDaoBicicletaimpl();
        private List<Bicicleta> bicidisp = new ArrayList<Bicicleta>();
	
        public BicicletaBean(){
            carregarBicisDisp();
        }
	
	public String salvar (){
		
		bici= daoGeneric.merge(bici);
		carregarBicicletas();
		mostrarMsg("Cadastrada com sucesso!");
		return "";		
	}
	
        private void mostrarMsg(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(null, message);
		
	}
        
	@PostConstruct
	private void carregarBicicletas() {
		bicis = daoGeneric.getListEntity(Bicicleta.class);
	}

	public String novo(){
		bici = new Bicicleta();
		return "";
	}
	
	public String remover(){
		daoGeneric.deletePorId(bici);
		bici = new Bicicleta();
		carregarBicicletas();
		return "";
				
	}

	public Bicicleta getBicicleta() {
		return bici;
	}

	public void setBicicleta(Bicicleta bici) {
		this.bici = bici;
	}

	public DaoGeneric<Bicicleta> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Bicicleta> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Bicicleta> getBicicletas() {
		return bicis;
	}

	public void setBicicletaBeans(List<Bicicleta> bicis) {
		this.bicis = bicis;
	}
        
        
	public List<Bicicleta> carregarBicisDisp(){
                EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
                Query q = em.createQuery("SELECT b FROM Bicicleta b WHERE b.disponivel = true");
		this.bicidisp = q.getResultList();
                em.close();
                return bicidisp;
	}
        
        public List<Bicicleta> getBiciDisp(){
            return bicidisp;
        }
        
}

