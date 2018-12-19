/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoGeneric;
import entity.Bicicleta;
import entity.Estacao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import repository.IDaoEstacao;
import repository.IDaoEstacaoimpl;

/**
 *
 * @author gabri
 */
@ManagedBean
@RequestScoped
public class EstacaoBean {

    private Estacao est = new Estacao();
	private DaoGeneric<Estacao> daoGeneric = new DaoGeneric<Estacao>();
	private List<Estacao> ests = new ArrayList<Estacao>();
	private IDaoEstacao daoLancamento = new IDaoEstacaoimpl();
	
	
	public String salvar (){
		
		est= daoGeneric.merge(est);
		carregarEstacoes();
		mostrarMsg("Cadastrada com sucesso!");
		return "";		
	}
	
        private void mostrarMsg(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(null, message);
		
	}
        
	@PostConstruct
	private void carregarEstacoes() {
		ests = daoGeneric.getListEntity(Estacao.class);
	}

	public String novo(){
		est = new Estacao();
		return "";
	}
	
	public String remover(){
		daoGeneric.deletePorId(est);
		est = new Estacao();
		carregarEstacoes();
		return "";
				
	}

	public Estacao getEstacao() {
		return est;
	}

	public void setEstacao(Estacao est) {
		this.est= est;
	}

	public DaoGeneric<Estacao> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Estacao> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public List<Estacao> getEstacoes() {
		return ests;
	}

	public void setEstacaoBeans(List<Estacao> ests) {
		this.ests = ests;
	}

}

