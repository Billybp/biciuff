/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.DaoGeneric;
import entity.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import repository.IDaoUsuario;
import repository.IDaoUsuarioimpl;
import util.JPAUtil;

/**
 *
 * @author gabri
 */
@SessionScoped
@ManagedBean(name="usuarioBean")
public class UsuarioBean implements Serializable{
    private static final long serialVersionUID = 1L;

	private Usuario user = new Usuario();
	private DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
	private List<Usuario> users = new ArrayList<Usuario>();
	
	private IDaoUsuario iDaoUsuario = new IDaoUsuarioimpl();

	public String salvar() {
		user= daoGeneric.merge(user);
		carregarUsuarios();
		mostrarMsg("Cadastrado com sucesso!");
		return "";
	}
	
	private void mostrarMsg(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(msg);
		context.addMessage(null, message);
		
	}

	public String novo(){
		user = new Usuario();
		return "";
	}
	
	public String remove(){
		daoGeneric.deletePorId(user);
		user = new Usuario();
		carregarUsuarios();
		mostrarMsg("Removido com sucesso!");
		return "";
	}
	
	@PostConstruct
	public void carregarUsuarios(){
		users = daoGeneric.getListEntity(Usuario.class);
                
	}
        
        public Usuario carregarUsuario(){
            Usuario userEdit = iDaoUsuario.consultarId(user.getId());
            return userEdit;
        }
	
	public Usuario getUsuario() {
          /*System.out.println(user.getCpf());
            System.out.println(user.getNome());
            System.out.println(user.getId());
            System.out.println(user.getEndereco());*/

		return user;
	}

	public void setUsuario(Usuario user) {
		this.user = user;
	}

	public DaoGeneric<Usuario> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Usuario> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
	
	public List<Usuario> getUsuarios() {
            return users;
	}
	
	public String logar(){
		
		Usuario userLogar = iDaoUsuario.consultarUsuario(user.getNome(), user.getSenha());
		
		if (userLogar != null){// achou o usuário
			
			//adicionar o usuário na sessão usuarioLogado
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			externalContext.getSessionMap().put("usuarioLogado", userLogar);
                        if (userLogar.getNome().equalsIgnoreCase("admin")){
                            return "primeirapagina.xhtml";
                        }else
                            return "usuario.xhtml";                                                                      
			
		}		
		return "index.xhtml";
	}
	
        public Usuario recuperar(){
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().getSessionMap().get("usuarioLogado");
            return user;
        }
        
        
        
	public boolean permiteAcesso(String acesso) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		Usuario user = (Usuario) externalContext.getSessionMap().get("usuarioLogado");
		if (user.getNome().equals(acesso)){
		return true;
	}else 
                return false;
        }

}
